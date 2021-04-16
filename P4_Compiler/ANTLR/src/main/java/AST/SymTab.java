package AST;

import Exceptions.FunctionAlreadyDeclaredException;
import Exceptions.FunctionOverloadingTypeException;
import Exceptions.SymbolAlreadyDeclaredException;
import Exceptions.VarNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class SymTab {
    static List<FuncSymbol> functions = new ArrayList<>(); //unordered list of functions
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

    //only allow new function declaration if either:
    //  -it has a unique name
    //OR
    //  -it has a non-unique name, with the same type as previously declared function of that name, and unique parameters*
    //      *ordering of parameters does not change uniqueness
    public static void EnterSymbol(FunctionNode node) throws Exception {
        //check if the symbol is already in the table
        if(DeclaredLocally(node.id)){
            EnterOverloadedFunc(node);
        }
        else{
            //not found in table
            functions.add(new FuncSymbol(node.type, node.typeModifier, node.id, node.parameters));
        }
    }
    private static void EnterOverloadedFunc(FunctionNode node) throws Exception {
        //go through all declared functions, and find the ones with the same name
        List<FuncSymbol> sameFuncs = new ArrayList<>();
        for(int i = 0; i < functions.size(); i++){
            FuncSymbol current = functions.get(i);
            if(current.id == node.id){
                sameFuncs.add(current);
            }
        }

        if(AllValidOverload(sameFuncs, node)){
            functions.add(new FuncSymbol(node.type, node.typeModifier, node.id, node.parameters));
        }
        else{
            throw new FunctionAlreadyDeclaredException("Function already declared with name: " + node.id.id + " with type: " + node.type + " and parameters: " + node.parameters.declarations.toString());
        }
    }
    private static boolean AllValidOverload(List<FuncSymbol> sameFuncs, FunctionNode node){
        //go through the overloaded versions, and check if it's valid for each of them
        for(int funcCount = 0; funcCount < sameFuncs.size(); funcCount++){
            FuncSymbol currentFunc = sameFuncs.get(funcCount);
            if(!ValidOverload(currentFunc, node)){
                return false;
            }
        }
        return true;
    }
    private static boolean ValidOverload(FuncSymbol currentFunc, FunctionNode node){
        List<DeclareStmtNode> func1Params = currentFunc.parameters.declarations;
        List<DeclareStmtNode> func2Params = node.parameters.declarations;

        if(SameParams(func1Params, func2Params)){
            return false;
        }
        else{
            //found, but with different parameters -> doing function overloading
            //needs same return type
            boolean sameType;

            //check if they have the same return type
            sameType = currentFunc.type.equals(node.type) && currentFunc.typeModifier.equals(node.typeModifier);
            if(sameType){
                return true;
            }
            else{
                return false;
            }
        }
    }
    private static boolean SameParams(List<DeclareStmtNode> func1Params, List<DeclareStmtNode> func2Params){
        //check if the parameters have the same types
        if(func1Params.size() != func2Params.size()){
            return false;
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
                    return false;
                }
            }
        }
        return true;
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
            FuncSymbol current = functions.get(i);
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
            FuncSymbol current = functions.get(i);
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

class FuncSymbol extends Symbol {
    public FuncSymbol(String _type, String _typeModifier, IdentifierNode _id, DeclareStmtListNode _parameters){
        super(_id);
        type = _type;
        typeModifier = _typeModifier;
        parameters = _parameters;
    }
    String type;
    String typeModifier;
    DeclareStmtListNode parameters;
}