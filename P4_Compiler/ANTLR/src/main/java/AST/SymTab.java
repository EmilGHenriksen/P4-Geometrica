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
        EnterSymbol(declPI, this, false); //technically it is global, but Math.PI is inserted directly instead

        //---angle functions
        //arccos
        DeclareStmtListNode declArccos = new DeclareStmtListNode();
        declArccos.declarations.add(new DeclareStmtNode("float", "", "input"));
        FunctionNode arccos = new FunctionNode("arccos", "angle", "", declArccos);
        EnterSymbol(arccos, false);
        //arcsin
        FunctionNode arcsin = arccos;
        arcsin.id.id = "arcsin";
        EnterSymbol(arcsin, false);
        //arctan
        FunctionNode arctan = arccos;
        arctan.id.id = "arctan";
        EnterSymbol(arctan, false);
        //cos
        DeclareStmtListNode declCos = new DeclareStmtListNode();
        declCos.declarations.add(new DeclareStmtNode("angle", "", "input"));
        FunctionNode cos = new FunctionNode("cos", "float", "", declCos);
        EnterSymbol(cos, false);
        //sin
        FunctionNode sin = cos;
        sin.id.id = "sin";
        EnterSymbol(sin, false);
        //tan
        FunctionNode tan = cos;
        tan.id.id = "tan";
        EnterSymbol(tan, false);

        //---canvas-related functions
        //clearcanvas
        DeclareStmtListNode declClearcanvas = new DeclareStmtListNode();
        FunctionNode clearcanvas = new FunctionNode("clearcanvas", "void", "", declClearcanvas);
        EnterSymbol(clearcanvas, false);
        //connect TBD
        //--draw variations
        //draw point
        DeclareStmtListNode declDraw = new DeclareStmtListNode();
        declDraw.declarations.add(new DeclareStmtNode("point", "", "toDraw"));
        FunctionNode draw = new FunctionNode("draw", "void", "", declDraw);
        EnterSymbol(draw, false);
        //draw line
        DeclareStmtListNode declDraw2 = new DeclareStmtListNode();
        declDraw2.declarations.add(new DeclareStmtNode("line", "", "toDraw"));
        FunctionNode draw2 = new FunctionNode("draw", "void", "", declDraw2);
        EnterSymbol(draw2, false);
        //draw circle
        DeclareStmtListNode declDraw3 = new DeclareStmtListNode();
        declDraw3.declarations.add(new DeclareStmtNode("circle", "", "toDraw"));
        FunctionNode draw3 = new FunctionNode("draw", "void", "", declDraw3);
        EnterSymbol(draw3, false);
        //draw triangle
        DeclareStmtListNode declDraw4 = new DeclareStmtListNode();
        declDraw4.declarations.add(new DeclareStmtNode("triangle", "", "toDraw"));
        FunctionNode draw4 = new FunctionNode("draw", "void", "", declDraw4);
        EnterSymbol(draw4, false);
        //draw square
        DeclareStmtListNode declDraw5 = new DeclareStmtListNode();
        declDraw5.declarations.add(new DeclareStmtNode("square", "", "toDraw"));
        FunctionNode draw5 = new FunctionNode("draw", "void", "", declDraw5);
        EnterSymbol(draw5, false);
        //drawAll TBD

        //---other default functions
        //root
        DeclareStmtListNode declRoot = new DeclareStmtListNode();
        declRoot.declarations.add(new DeclareStmtNode("float", "", "value"));
        declRoot.declarations.add(new DeclareStmtNode("float", "", "power")); //maybe int instead, depending on implementation difficulty
        FunctionNode root = new FunctionNode("root", "float", "", declRoot);
        EnterSymbol(root, false);
        //sqrt
        DeclareStmtListNode declSqrt = new DeclareStmtListNode();
        declSqrt.declarations.add(new DeclareStmtNode("float", "", "input"));
        FunctionNode sqrt = new FunctionNode("sqrt", "float", "", declSqrt);
        EnterSymbol(sqrt, false);
        //wait
        DeclareStmtListNode declWait = new DeclareStmtListNode();
        declWait.declarations.add(new DeclareStmtNode("int", "", "milliseconds"));
        FunctionNode wait = new FunctionNode("wait", "void", "", declWait);
        EnterSymbol(wait, false);
    }

    public List<FuncSymbol> functions = new ArrayList<>(); //unordered list of functions
    public List<SymList> scopes = new ArrayList<>(); //these scopes are used as a stack
    public FuncSymbol currentFunc = null;
    //for code generation
    public static List<FunctionNode> globalFuncs = new ArrayList<>();
    public static List<DeclareStmtNode> globalVars = new ArrayList<>();


    public void OpenScope(){
        scopes.add(new SymList());
    }
    public void CloseScope(){
        scopes.remove(scopes.size()-1);
    }

    public void EnterSymbol(DeclareStmtNode node, SymTab symTab, boolean isGlobal) throws Exception {
        //check if the symbol is already in the table
        if(DeclaredLocally(node.id.id)){
            throw new SymbolAlreadyDeclaredException("Variable already declared in current scope with name: " + node.id.id);
        }
        else{
            SymList currentScope = scopes.get(scopes.size()-1);
            currentScope.symbols.add(new VarSymbol(node));
            if(isGlobal){
                globalVars.add(node);
            }
        }
    }

    //only allow new function declaration if either:
    //  -it has a unique name
    //OR
    //  -it has a non-unique name, with the same type as previously declared function of that name, and unique parameters*
    //      *ordering of parameters does not change uniqueness
    public void EnterSymbol(FunctionNode node, boolean isFinal) throws Exception {
        //check if the symbol is already in the table
        if(DeclaredLocally(node.id.id)){
            EnterOverloadedFunc(node, isFinal);
        }
        else{
            //not found in table
            functions.add(new FuncSymbol(node.type, node.typeModifier, node.id.id, node.parameters));
            if(isFinal){
                globalFuncs.add(node);
            }
        }
    }
    private void EnterOverloadedFunc(FunctionNode node, boolean isFinal) throws Exception {
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
            if(isFinal){
                globalFuncs.add(node);
            }
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
            //check if each parameter is of the same type
            for(int i = 0; i < func1Params.size(); i++){
                boolean sameType = (func1Params.get(i).type.equals(func2Params.get(i).type));
                boolean sameTypeModifier = (func1Params.get(i).typeModifier.equals(func2Params.get(i).typeModifier));
                if(!sameType || !sameTypeModifier){
                    return false;
                }
            }
            //if no parameter is different
            return true;
        }
    }

    //retrieve variable
    public VarSymbol RetrieveSymbol(VariableAccessNode node, SymTab _symTab) throws VarNotFoundException {
        if(node instanceof IdentifierNode){
            return RetrieveSymbol(((IdentifierNode) node).id, _symTab);
        }
        else if(node instanceof VariableModifierAccessNode){
            //x[e]
            //check it has at most the same number of dimensions as the stored variable
            VarSymbol variable = RetrieveSymbol(node.GetID(), _symTab);
            if(node.GetTypeModifier().length() <= variable.typeModifier.length()){
                return RetrieveSymbol(((VariableModifierAccessNode) node).variable, _symTab);
            }
            else{
                throw new VarNotFoundException("Variable: " + node.GetID() + " does not have at least " + (node.GetTypeModifier().length()/2) + " list dimensions" );
            }
        }
        else{
            //instance of VariablePropertyAccessNode
            //x.x
            VarSymbol variable = RetrieveSymbol(node.GetID(), _symTab);
            VarSymbol property = RetrieveSymbol(((VariablePropertyAccessNode) node).child, variable.fields);
            return property;
        }
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
    //retrieve function
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
    public VarSymbol(DeclareStmtNode node) throws Exception {
        super(node.id.id);
        accessModifier = node.accessModifier;
        if(accessModifier == null) accessModifier = "";
        type = node.type;
        typeModifier = node.typeModifier;
        //fields based on node.type
        fields = new SymTab();

        //list or not
        if(!accessModifier.equals("")){
            //.add
            DeclareStmtListNode addDecl = new DeclareStmtListNode();
            String elementModifier = typeModifier.substring(0, typeModifier.length()-2);
            addDecl.declarations.add(new DeclareStmtNode(type, elementModifier, "toAdd"));
            FunctionNode add = new FunctionNode("add", "void", "", addDecl);
            fields.EnterSymbol(add, false);
            //.remove
            DeclareStmtListNode removeDecl = new DeclareStmtListNode();
            removeDecl.declarations.add(new DeclareStmtNode("int", "", "index"));
            FunctionNode remove = new FunctionNode("remove", "void", "", removeDecl);
            fields.EnterSymbol(remove, false);
        }
        else{
            //.move looks like this
            DeclareStmtListNode moveDecl = new DeclareStmtListNode();
            moveDecl.declarations.add(new DeclareStmtNode("float", "", "x"));
            moveDecl.declarations.add(new DeclareStmtNode("float", "", "y"));
            FunctionNode move = new FunctionNode("move", "void", "", moveDecl);
            //insert to fields
            if(node.type.equals("point")){
                DeclareStmtNode declX = new DeclareStmtNode("float", "", "x");
                fields.EnterSymbol(declX, fields, false);
                DeclareStmtNode declY = new DeclareStmtNode("float", "", "y");
                fields.EnterSymbol(declY, fields, false);
                fields.EnterSymbol(move,false);
            }
            else if(node.type.equals("line")){
                DeclareStmtNode declA = new DeclareStmtNode("point", "", "A");
                fields.EnterSymbol(declA, fields, false);
                DeclareStmtNode declB = new DeclareStmtNode("point", "", "B");
                fields.EnterSymbol(declB, fields, false);
                fields.EnterSymbol(move,false);
            }
            else if(node.type.equals("triangle")){
                DeclareStmtNode declA = new DeclareStmtNode("point", "", "A");
                fields.EnterSymbol(declA, fields, false);
                DeclareStmtNode declB = new DeclareStmtNode("point", "", "B");
                fields.EnterSymbol(declB, fields, false);
                DeclareStmtNode declC = new DeclareStmtNode("point", "", "C");
                fields.EnterSymbol(declC, fields, false);
                fields.EnterSymbol(move,false);
            }
            else if(node.type.equals("square")){
                DeclareStmtNode declA = new DeclareStmtNode("point", "", "A");
                fields.EnterSymbol(declA, fields, false);
                DeclareStmtNode declB = new DeclareStmtNode("point", "", "B");
                fields.EnterSymbol(declB, fields, false);
                DeclareStmtNode declC = new DeclareStmtNode("point", "", "C");
                fields.EnterSymbol(declC, fields, false);
                DeclareStmtNode declD = new DeclareStmtNode("point", "", "D");
                fields.EnterSymbol(declD, fields, false);
                fields.EnterSymbol(move,false);
            }
            else if(node.type.equals("circle")){
                DeclareStmtNode declC = new DeclareStmtNode("point", "", "center");
                fields.EnterSymbol(declC, fields, false);
                DeclareStmtNode declR = new DeclareStmtNode("float", "", "radius");
                fields.EnterSymbol(declR, fields, false);
                fields.EnterSymbol(move,false);
            }
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