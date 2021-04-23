package AST;

import Exceptions.*;
import org.antlr.v4.codegen.model.decl.Decl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SymTab {
    public SymTab(){
        //default constructor
        //used for fields
        this.OpenScope();
    }
    public SymTab(boolean e) throws Exception {
        //scope constructor (includes all default variables/functions)
        this.OpenScope();

        //PI - this symbol might not be necessary
        DeclareStmtNode declPI = new DeclareStmtNode("float", "", "PI");
        EnterSymbol(declPI, this);

        //---angle functions
        //arccos
        DeclareStmtListNode declArccos = new DeclareStmtListNode();
        declArccos.declarations.add(new DeclareStmtNode("float", "", "input"));
        FunctionNode arccos = new FunctionNode("arccos", "angle", "", declArccos);
        EnterSymbol(arccos);
        //arcsin
        FunctionNode arcsin = arccos;
        arcsin.id.id = "arcsin";
        EnterSymbol(arcsin);
        //arctan
        FunctionNode arctan = arccos;
        arctan.id.id = "arctan";
        EnterSymbol(arctan);
        //cos
        DeclareStmtListNode declCos = new DeclareStmtListNode();
        declCos.declarations.add(new DeclareStmtNode("angle", "", "input"));
        FunctionNode cos = new FunctionNode("cos", "float", "", declCos);
        EnterSymbol(cos);
        //sin
        FunctionNode sin = cos;
        sin.id.id = "sin";
        EnterSymbol(sin);
        //tan
        FunctionNode tan = cos;
        tan.id.id = "tan";
        EnterSymbol(tan);

        //---canvas-related functions
        //clearcanvas
        DeclareStmtListNode declClearcanvas = new DeclareStmtListNode();
        FunctionNode clearcanvas = new FunctionNode("clearcanvas", "void", "", declClearcanvas);
        EnterSymbol(clearcanvas);
        //connect
        //TBD
        //--draw variations
        //draw point
        DeclareStmtListNode declDraw = new DeclareStmtListNode();
        declDraw.declarations.add(new DeclareStmtNode("point", "", "toDraw"));
        FunctionNode draw = new FunctionNode("draw", "void", "", declDraw);
        EnterSymbol(draw);
        //draw line
        DeclareStmtListNode declDraw2 = new DeclareStmtListNode();
        declDraw2.declarations.add(new DeclareStmtNode("line", "", "toDraw"));
        FunctionNode draw2 = new FunctionNode("draw", "void", "", declDraw2);
        EnterSymbol(draw2);
        //drawAll
        //TBD

        //---other default functions
        //move
        //TBD
        //root
        DeclareStmtListNode declRoot = new DeclareStmtListNode();
        declRoot.declarations.add(new DeclareStmtNode("float", "", "value"));
        declRoot.declarations.add(new DeclareStmtNode("float", "", "power")); //maybe int instead, depending on implementation difficulty
        FunctionNode root = new FunctionNode("root", "float", "", declRoot);
        EnterSymbol(root);
        //sqrt
        DeclareStmtListNode declSqrt = new DeclareStmtListNode();
        declSqrt.declarations.add(new DeclareStmtNode("float", "", "input"));
        FunctionNode sqrt = new FunctionNode("sqrt", "float", "", declSqrt);
        EnterSymbol(sqrt);
        //wait
        DeclareStmtListNode declWait = new DeclareStmtListNode();
        declWait.declarations.add(new DeclareStmtNode("int", "", "milliseconds"));
        FunctionNode wait = new FunctionNode("wait", "void", "", declWait);
        EnterSymbol(wait);
    }

    public List<FuncSymbol> functions = new ArrayList<>(); //unordered list of functions
    public List<SymList> scopes = new ArrayList<>(); //these scopes are used as a stack
    public FuncSymbol currentFunc = null;

    public void OpenScope(){
        scopes.add(new SymList());
    }
    public void CloseScope(){
        scopes.remove(scopes.size()-1);
    }

    public void EnterSymbol(DeclareStmtNode node, SymTab symTab) throws SymbolAlreadyDeclaredException {
        //check if the symbol is already in the table
        if(DeclaredLocally(node.id.id)){
            throw new SymbolAlreadyDeclaredException("Variable already declared in current scope with name: " + node.id.id);
        }
        else{
            SymList currentScope = scopes.get(scopes.size()-1);
            currentScope.symbols.add(new VarSymbol(node));
        }
    }

    //only allow new function declaration if either:
    //  -it has a unique name
    //OR
    //  -it has a non-unique name, with the same type as previously declared function of that name, and unique parameters*
    //      *ordering of parameters does not change uniqueness
    public void EnterSymbol(FunctionNode node) throws Exception {
        //check if the symbol is already in the table
        if(DeclaredLocally(node.id.id)){
            EnterOverloadedFunc(node);
        }
        else{
            //not found in table
            functions.add(new FuncSymbol(node.type, node.typeModifier, node.id.id, node.parameters));
        }
    }
    private void EnterOverloadedFunc(FunctionNode node) throws Exception {
        //go through all declared functions, and find the ones with the same name
        List<FuncSymbol> sameFuncs = new ArrayList<>();
        for(int i = 0; i < functions.size(); i++){
            FuncSymbol current = functions.get(i);
            if(current.id.equals(node.id.id)){
                sameFuncs.add(current);
            }
        }

        //check if the overloading is valid
        if(AllValidOverload(sameFuncs, node)){
            functions.add(new FuncSymbol(node.type, node.typeModifier, node.id.id, node.parameters));
        }
        else{
            throw new FunctionAlreadyDeclaredException("Function already declared with name: " + node.id.id + " with type: " + node.type + " and parameters: " + node.parameters.declarations.toString());
        }
    }
    private boolean AllValidOverload(List<FuncSymbol> sameFuncs, FunctionNode node){
        //go through the overloaded versions, and check if it's valid for each of them
        for(int funcCount = 0; funcCount < sameFuncs.size(); funcCount++){
            FuncSymbol currentFunc = sameFuncs.get(funcCount);
            if(!ValidOverload(currentFunc, node)){
                return false;
            }
        }
        return true;
    }
    private boolean ValidOverload(FuncSymbol _currentFunc, FunctionNode node){
        List<DeclareStmtNode> func1Params = _currentFunc.parameters.declarations;
        List<DeclareStmtNode> func2Params = node.parameters.declarations;

        if(SameParams(func1Params, func2Params)){
            return false;
        }
        else{
            //found, and with different parameters -> doing function overloading
            //needs same return type
            boolean sameType = Objects.equals(_currentFunc.type, (node.type))
                            && Objects.equals(_currentFunc.typeModifier, node.typeModifier);
            if(sameType){
                return true;
            }
            else{
                return false;
            }
        }
    }
    private boolean SameParams(List<DeclareStmtNode> func1Params, List<DeclareStmtNode> func2Params){
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
                    if (func1Params.get(i).type.equals(func2Params.get(j).type)
                            && Objects.equals(func1Params.get(i).typeModifier, func2Params.get(j).typeModifier)) {
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


    public VarSymbol RetrieveSymbol(String id, SymTab _symTab) throws VarNotFoundException {
        Symbol symbol = null;
        //try to find a variable
        for(int scopeCount = _symTab.scopes.size()-1; scopeCount >= 0; scopeCount--){
            for(int symbolCount = _symTab.scopes.get(scopeCount).symbols.size()-1; symbolCount >= 0; symbolCount--){
                //looping through all symbols in all scopes, in reverse order
                Symbol current = _symTab.scopes.get(scopeCount).symbols.get(symbolCount);
                if(current.id.equals(id) && symbol == null){
                    symbol = current;
                }
            }
        }
        if(symbol == null){
            throw new VarNotFoundException("Undeclared symbol: " + id);
        }
        return (VarSymbol) symbol;
    }
    public FuncSymbol RetrieveSymbol(String id, SymTab _symTab, DeclareStmtListNode parameters) throws VarNotFoundException {
        Symbol symbol = null;
        //try to find a function
        for(int i = _symTab.functions.size()-1; i >= 0; i--){
            FuncSymbol current = _symTab.functions.get(i);
            if(current.id.equals(id) && symbol == null){
                //check parameters
                if(SameParams(parameters.declarations, current.parameters.declarations)){
                    symbol = current;
                }
            }
        }
        if(symbol == null){
            throw new VarNotFoundException("Undeclared symbol: " + id);
        }
        return (FuncSymbol) symbol;
    }
    public FuncSymbol RetrieveSymbol(String id, SymTab _symTab, ValueListNode parameters) throws VarNotFoundException {
        //uses the other FuncSymbol RetrieveSymbol function
        //convert ValueListNode to DeclareStmtListNode
        DeclareStmtListNode declParams = new DeclareStmtListNode();
        for(int i = 0; i < parameters.exprNodes.size(); i++){
            ExprNode value = parameters.exprNodes.get(i);
            //since the parameter IDs are not checked, it can be anything (in this case empty)
            DeclareStmtNode decl = new DeclareStmtNode(value.typeDecoration.type, value.typeDecoration.typeModifier, "");
            declParams.declarations.add(decl);
        }
        //retrieve
        return RetrieveSymbol(id, _symTab, declParams);
    }

    //auxiliary function for determining if a symbol is already declared in current scope
    //also checks if a function with that name exists (globally)
    private boolean DeclaredLocally(String id){
        boolean found = false;
        //check local variables
        if(scopes != null && scopes.size() > 0){
            int scopeCount = scopes.size()-1;
            int totalSymbols = (scopes.get(scopeCount).symbols.size())-1;
            for(int symbolCount = totalSymbols; symbolCount >= 0; symbolCount--){
                //looping through all symbols in local scope, in reverse order
                Symbol current = scopes.get(scopeCount).symbols.get(symbolCount);
                if(current.id.equals(id)){
                    found = true;
                }
            }
        }
        //check global functions
        for(int i = functions.size()-1; i >= 0; i--){
            FuncSymbol current = functions.get(i);
            if(current.id.equals(id)){
                found = true;
            }
        }
        return found;
    }


    @Override
    public boolean equals(Object obj){
        //Check for null and compare run-time types.
        if (!(obj instanceof SymTab))
        {
            return false;
        }
        else {
            SymTab S1 = (SymTab) obj;
            SymTab S2 = this;
            boolean isSame = true;
            for(int i = 0; i < scopes.size(); i++){
                if(!S1.scopes.get(i).equals(S2.scopes.get(i))){
                    isSame = false;
                }
            }
            for(int i = 0; i < functions.size(); i++){
                if(!S1.functions.get(i).equals(S2.functions.get(i))){
                    isSame = false;
                }
            }
            return isSame;
        }
    }
}


class SymList {
    public SymList(){
        symbols = new ArrayList<>();
    }

    List<Symbol> symbols;
    //these symbols are an unordered list

    @Override
    public boolean equals(Object obj){
        //Check for null and compare run-time types.
        if (!(obj instanceof SymList))
        {
            return false;
        }
        else {
            SymList S1 = (SymList) obj;
            SymList S2 = this;
            boolean isSame = true;
            for(int i = 0; i < symbols.size(); i++){
                if(!S1.symbols.get(i).equals(S2.symbols.get(i))){
                    isSame = false;
                }
            }
            return isSame;
        }
    }
}


abstract class Symbol{
    public Symbol(String _id){
        id = _id;
    }
    String id;
    @Override
    public abstract boolean equals(Object obj);
}

class VarSymbol extends Symbol {
    public VarSymbol(DeclareStmtNode node) throws SymbolAlreadyDeclaredException {
        super(node.id.id);
        accessModifier = node.accessModifier;
        type = node.type;
        typeModifier = node.typeModifier;
        //fields based on node.type
        fields = new SymTab();
        if(node.type.equals("point")){
            DeclareStmtNode declX = new DeclareStmtNode("float", "", "x");
            fields.EnterSymbol(declX, fields);
            DeclareStmtNode declY = new DeclareStmtNode("float", "", "y");
            fields.EnterSymbol(declY, fields);
        }
        else if(node.type.equals("line")){
            DeclareStmtNode declA = new DeclareStmtNode("point", "", "A");
            fields.EnterSymbol(declA, fields);
            DeclareStmtNode declB = new DeclareStmtNode("point", "", "B");
            fields.EnterSymbol(declB, fields);
        }
        else if(node.type.equals("triangle")){
            DeclareStmtNode declA = new DeclareStmtNode("point", "", "A");
            fields.EnterSymbol(declA, fields);
            DeclareStmtNode declB = new DeclareStmtNode("point", "", "B");
            fields.EnterSymbol(declB, fields);
            DeclareStmtNode declC = new DeclareStmtNode("point", "", "C");
            fields.EnterSymbol(declC, fields);
        }
        else if(node.type.equals("square")){
            DeclareStmtNode declA = new DeclareStmtNode("point", "", "A");
            fields.EnterSymbol(declA, fields);
            DeclareStmtNode declB = new DeclareStmtNode("point", "", "B");
            fields.EnterSymbol(declB, fields);
            DeclareStmtNode declC = new DeclareStmtNode("point", "", "C");
            fields.EnterSymbol(declC, fields);
            DeclareStmtNode declD = new DeclareStmtNode("point", "", "D");
            fields.EnterSymbol(declD, fields);
        }
        else if(node.type.equals("circle")){
            DeclareStmtNode declC = new DeclareStmtNode("point", "", "center");
            fields.EnterSymbol(declC, fields);
            DeclareStmtNode declR = new DeclareStmtNode("float", "", "radius");
            fields.EnterSymbol(declR, fields);
        }
    }
    String accessModifier;
    String type;
    String typeModifier;
    SymTab fields;

    @Override
    public boolean equals(Object obj){
        //Check for null and compare run-time types.
        if (!(obj instanceof VarSymbol))
        {
            return false;
        }
        else {
            VarSymbol V1 = (VarSymbol) obj;
            VarSymbol V2 = this;
            boolean isSame = true;
            if(!V1.type.equals(V2.type)){
                isSame = false;
            }
            if(!Objects.equals(V1.typeModifier, V2.typeModifier)){
                isSame = false;
            }
            //if they're null then they're equals
            //avoids infinitely recursive definition
            if(!(V1.fields == null) && !(V2.fields == null)){
                if(!V1.fields.equals(V2.fields)){
                    isSame = false;
                }
            }
            else if(V1.fields == null && V2.fields != null){
                isSame = false;
            }
            else if(V1.fields != null && V2.fields == null){
                isSame = false;
            }
            return isSame;
        }
    }
}

class FuncSymbol extends Symbol {
    public FuncSymbol(String _type, String _typeModifier, String _id, DeclareStmtListNode _parameters){
        super(_id);
        type = _type;
        typeModifier = _typeModifier;
        parameters = _parameters;
    }
    String type;
    String typeModifier;
    DeclareStmtListNode parameters;

    @Override
    public boolean equals(Object obj){
        //Check for null and compare run-time types.
        if (!(obj instanceof FuncSymbol))
        {
            return false;
        }
        else {
            FuncSymbol F1 = (FuncSymbol) obj;
            FuncSymbol F2 = this;
            return F1.id.equals(F2.id)
                    && F1.type.equals(F2.type)
                    && Objects.equals(F1.typeModifier, F2.typeModifier)
                    && F1.parameters.equals(F2.parameters);
        }
    }
}