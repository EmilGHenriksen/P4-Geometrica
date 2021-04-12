package AST;

import Exceptions.FunctionAlreadyDeclaredException;
import Exceptions.FunctionOverloadingTypeException;
import Exceptions.SymbolAlreadyDeclaredException;
import Exceptions.VarNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class SymTab {
    static List<Func> functions = new ArrayList<>(); //unordered list of functions
    static List<SymList> scopes = new ArrayList<>(); //these scopes are used as a stack

    public static void OpenScope(){
        scopes.add(new SymList());
    }
    public static void CloseScope(){
        scopes.remove(scopes.size()-1);
    }

    public static void EnterSymbol(DeclareStmtNode node) throws SymbolAlreadyDeclaredException {
        //check if the symbol is already in the table
        if(DeclaredLocally(node.id)){
            throw new SymbolAlreadyDeclaredException("Variable already declared in current scope with name: " + node.id.id);
        }
        else{
            scopes.get(scopes.size()-1).symbols.add(new Variable(node.accessModifier, node.type, node.typeModifier, node.id));
        }
    }
    public static void EnterSymbol(FunctionNode node) throws Exception {
        //check if the symbol is already in the table
        if(DeclaredLocally(node.id)){
            Symbol symbol = RetrieveSymbol(node.id);
            if(symbol instanceof Func){
                Func func = (Func)symbol;
                List<DeclareStmtNode> func1Params = func.parameters.declarations;
                List<DeclareStmtNode> func2Params = node.parameters.declarations;
                boolean sameParams = true;

                //check if the parameters have the same types
                if(func1Params.size() != func2Params.size()){
                    sameParams = false;
                }
                else{
                    //check if individual parameters from func1 exist in func2
                    for(int i = 0; i < func1Params.size(); i++){
                        //check if the number i parameter from func1 exists in func2
                        boolean paramFound = false;
                        for(int j = 0; j < func2Params.size(); j++){
                            if (func1Params.get(i).type.equals(func2Params.get(j).type) && func1Params.get(i).typeModifier.equals(func2Params.get(j).typeModifier)) {
                                paramFound = true;
                                break;
                            }
                        }
                        if(!paramFound){
                            sameParams = false;
                        }
                    }
                }

                //at this point, it is known with sameParams whether they have the same parameters.
                if(sameParams){
                    throw new FunctionAlreadyDeclaredException("Function already declared with name: " + node.id.id + " with type: " + node.type + " and parameters: " + node.parameters.declarations.toString());
                }
                else{
                    //found, but with different parameters -> doing function overloading
                    //needs same return type
                    boolean sameType;

                    //check if they have the same return type
                    sameType = func.type.equals(node.type) && func.typeModifier.equals(node.typeModifier);

                    if(sameType){
                        functions.add(new Func(node.type, node.typeModifier, node.id, node.parameters));
                    }
                    else{
                        throw new FunctionOverloadingTypeException("Function overloading with inconsistent return types. ID: " + node.id.id + " type1: " + node.type + " type2: " + func.type);
                    }
                }


            }
            else{
                //should never happen given the functions are loaded first
                throw new Exception("Variable already declared with given function name");
            }
        }
        else{
            //not found in table
            functions.add(new Func(node.type, node.typeModifier, node.id, node.parameters));
        }
    }

    //retrieves either a variable or a function
    public static Symbol RetrieveSymbol(IdentifierNode id) throws VarNotFoundException {
        Symbol symbol = null;
        //try to find a variable
        for(int scopeCount = scopes.size()-1; scopeCount >= 0; scopeCount--){
            for(int symbolCount = scopes.get(scopeCount).symbols.size()-1; symbolCount >= 0; symbolCount--){
                //looping through all symbols in all scopes, in reverse order
                Symbol current = scopes.get(scopeCount).symbols.get(symbolCount);
                if(current.id == id && symbol == null){
                    symbol = current;
                }
            }
        }
        //try to find a function
        for(int i = functions.size()-1; i >= 0; i--){
            Func current = functions.get(i);
            if(current.id == id && symbol == null){
                symbol = current;
            }
        }
        if(symbol == null){
            throw new VarNotFoundException("Undeclared symbol: " + id.id);
        }
        return symbol;
    }

    //auxiliary function for determining if a symbol is already declared in current scope
    //also checks if a function with that name exists (globally)
    private static boolean DeclaredLocally(IdentifierNode id){
        boolean found = false;
        //check local variables
        int scopeCount = scopes.size()-1;
        for(int symbolCount = scopes.get(scopeCount).symbols.size()-1; symbolCount >= 0; symbolCount--){
            //looping through all symbols in all scopes, in reverse order
            Symbol current = scopes.get(scopeCount).symbols.get(symbolCount);
            if(current.id == id){
                found = true;
            }
        }
        //check global functions
        for(int i = functions.size()-1; i >= 0; i--){
            Func current = functions.get(i);
            if(current.id == id){
                found = true;
            }
        }
        return found;
    }
}


class SymList {
    public SymList(){
        symbols = new ArrayList<>();
    }
    List<Symbol> symbols;
    //these symbols are an unordered list
}


abstract class Symbol{
    public Symbol(IdentifierNode _id){
        id = _id;
    }
    IdentifierNode id;
}

class Variable extends Symbol {
    public Variable(String _accessModifier, String _type, String _typeModifier, IdentifierNode _id){
        super(_id);
        accessModifier = _accessModifier;
        type = _type;
        typeModifier = _typeModifier;
    }
    String accessModifier;
    String type;
    String typeModifier;
}

class Func extends Symbol {
    public Func(String _type, String _typeModifier, IdentifierNode _id, DeclareStmtListNode _parameters){
        super(_id);
        type = _type;
        typeModifier = _typeModifier;
        parameters = _parameters;
    }
    String type;
    String typeModifier;
    DeclareStmtListNode parameters;
}