package AST;

import Exceptions.InvalidStatementException;
import Exceptions.SymbolAlreadyDeclaredException;
import Exceptions.TypeException;
import Exceptions.VarNotFoundException;
import kotlin.NotImplementedError;

import java.util.ArrayList;
import java.util.Objects;


public class ASTdecorator extends ASTvisitor<Node> {
    SymTab symTab;
    public ProgramNode Visit(ProgramNode node) throws Exception {
        //global scope opened by constructor
        symTab = new SymTab(true);
        node.content = Visit(node.content);
        symTab.CloseScope();
        return node;
    };
    public ContentNode Visit(ContentNode node) throws Exception {
        //go through all statements and functions
        int totalNodes = node.stmtAndFuncNodes.size();
        for(int i = 0; i < totalNodes; i++){
            Node current = node.stmtAndFuncNodes.get(i);
            if(current instanceof StmtNode){
                StmtNode currentStmt = (StmtNode) Visit((StmtNode) current);
                node.stmtAndFuncNodes.set(i, currentStmt);
            }
            else if(current instanceof  FunctionNode){
                node.stmtAndFuncNodes.set(i, Visit((FunctionNode) current));
            }
            else{
                throw new Exception("invalid node type in global scope");
            }
        }
        return node;
    };
    public FunctionNode Visit(FunctionNode node) throws Exception {
        //scope is opened by the StmtListNode
        node.typeDecoration = new TypeDecoration(node.type, node.typeModifier);
        symTab.EnterSymbol(node);
        symTab.currentFunc = (FuncSymbol) symTab.RetrieveSymbol(node.id.id, symTab, node.parameters);
        node.stmtFuncNodes = Visit(node.stmtFuncNodes);
        symTab.currentFunc = null;
        //last statement needs to be a return statement
        StmtNode lastStmt = node.stmtFuncNodes.statements.get(node.stmtFuncNodes.statements.size()-1);
        if(!(lastStmt instanceof ReturnStmtNode)){
            throw new Exception("Last statement in function needs to be return (in: " + node.toString() + " )");
        }
        return node;
    };
    public DeclareStmtListNode Visit(DeclareStmtListNode node) throws Exception {
        for(int i = 0; i < node.declarations.size(); i++){
            DeclareStmtNode declareStmtNode = Visit(node.declarations.get(i));
            node.declarations.set(i, declareStmtNode);
        }
        return node;
    };
    public ValueListNode Visit(ValueListNode node) throws Exception {
        for(int i = 0; i < node.exprNodes.size(); i++){
            ExprNode exprNode = (ExprNode) Visit(node.exprNodes.get(i));
            node.exprNodes.set(i, exprNode);
        }
        return node;
    };
    public StmtListNode Visit(StmtListNode node) throws Exception {
        symTab.OpenScope();
        for(int i = 0; i < node.statements.size(); i++){
            StmtNode stmtNode = (StmtNode) Visit(node.statements.get(i));
            node.statements.set(i, stmtNode);
        }
        symTab.CloseScope();
        return node;
    };
    public ReturnStmtNode Visit(ReturnStmtNode node) throws Exception {
        node.value = (ExprNode) Visit(node.value);
        node.typeDecoration = node.value.typeDecoration;
        //type checking
        FuncSymbol currentFunc = symTab.currentFunc;
        TypeDecoration currentFuncDec = new TypeDecoration(currentFunc.type, currentFunc.typeModifier);
        if(!CompatibleOneway(node.typeDecoration, currentFuncDec)){
            throw new TypeException("Function: " + currentFunc.id + " does not match type for return statement: " + node.toString());
        }
        return node;
    };
    public DeclareStmtNode Visit(DeclareStmtNode node) throws Exception {
        symTab.EnterSymbol(node, symTab);
        node.id = Visit(node.id);
        node.value = (ExprNode) Visit(node.value);
        return node;
    };
    public AssignNode Visit(AssignNode node) throws Exception {
        node.variable = (VariableAccessNode) Visit(node.variable);
        node.value = (ExprNode) Visit(node.value);
        //check that the variable exists
        symTab.RetrieveSymbol(node.variable, symTab);
        //type checking
        if(!CompatibleOneway(node.value.typeDecoration, node.variable.typeDecoration)){
            throw new TypeException("Assign error: variable " + node.variable.GetID() + " has incompatible type with value: " + node.value);
        }
        return node;
    };
    public IdentifierNode Visit(IdentifierNode node){
        try{
            VarSymbol varSymbol = symTab.RetrieveSymbol(node.GetID(), symTab);
            node.typeDecoration = new TypeDecoration(varSymbol.type, varSymbol.typeModifier);
        }
        catch(VarNotFoundException e){/*might just be a declaration*/}
        return node;
    };
    public VariableModifierAccessNode Visit(VariableModifierAccessNode node) throws Exception {
        node.expr = (ExprNode) Visit(node.expr);
        node.variable = (VariableAccessNode) Visit(node.variable);
        node.typeDecoration.typeModifier = node.typeDecoration.typeModifier + "[]";
        return node;
    };
    public VariablePropertyAccessNode Visit(VariablePropertyAccessNode node) throws Exception {
        node.child = (VariableAccessNode) Visit(node.child);
        node.parent = (VariableAccessNode) Visit(node.parent);
        node.typeDecoration = node.child.typeDecoration;
        return node;
    };
    public ExprNode Visit(VariableAccessExprNode node) throws Exception {
        node.variableExpr = (VariableAccessNode) Visit(node.variableExpr);
        //check that it exists
        symTab.RetrieveSymbol(node.variableExpr, symTab);
        //assign type
        node.typeDecoration = node.variableExpr.typeDecoration;
        return node;
    }
    public IfNode Visit(IfNode node) throws Exception {
        //scope is opened by the StmtListNode
        node.value = (ExprNode) Visit(node.value);
        if(!node.value.typeDecoration.type.equals("bool") || !node.value.typeDecoration.typeModifier.equals("")){
            throw new TypeException("if node's value: " + node.value.toString() + " needs to be boolean");
        }
        if(node.elseStmtNode != null){
            node.elseStmtNode = (StmtNode) Visit(node.elseStmtNode);
        }
        node.ifStmtNodes = Visit(node.ifStmtNodes);
        return node;
    };
    public SwitchNode Visit(SwitchNode node) throws Exception {
        //cases open their own scopes
        node.value = (ExprNode) Visit(node.value);
        if(node.value.typeDecoration == null){
            throw new TypeException("Null value in switch node's switching value: " + node.toString());
        }
        node.cases = Visit(node.cases);
        for(int i = 0; i < node.cases.cases.size(); i++){
            if(!CompatibleOneway(node.cases.cases.get(i).value.typeDecoration, node.value.typeDecoration)){
                throw new TypeException("case: " + node.cases.cases.get(i).toString() + " does not have same type as its switching value");
            }
        }
        node.defaultCase = Visit(node.defaultCase);
        return node;
    };
    public DefinedCaseListNode Visit(DefinedCaseListNode node) throws Exception {
        for(int i = 0; i < node.cases.size(); i++){
            node.cases.set(i, Visit(node.cases.get(i)));
        }
        return node;
    };
    public DefinedCaseNode Visit(DefinedCaseNode node) throws Exception {
        //scope is opened by the StmtListNode
        //type checking is done by the switch node
        node.value = (ExprNode) Visit(node.value);
        node.stmtNodes = Visit(node.stmtNodes);
        return node;
    };
    public DefaultCaseNode Visit(DefaultCaseNode node) throws Exception {
        //scope is opened by the StmtListNode
        node.stmtNodes = Visit(node.stmtNodes);
        return node;
    };
    public ForeachNode Visit(ForeachNode node) throws Exception {
        //scope is opened by the StmtListNode
        node.elementID = Visit(node.elementID);
        node.collectionID = Visit(node.collectionID);
        //check that the collection exits
        symTab.RetrieveSymbol(node.collectionID, symTab);
        //check that the collection is a list
        if(node.collectionID.typeDecoration.typeModifier.equals("")){
            throw new TypeException("collection in foreach node needs to be a list (in: " + node.toString() + ")");
        }
        //insert element in symTab
        String oldModifier = node.collectionID.typeDecoration.typeModifier;
        String newModifier = oldModifier.substring(0, oldModifier.length()-2); //new type modifier (1 dimension lower) - remove "[]" from end
        //don't reset fields if it has been declared, in case it has fields
        if(node.elementID.typeDecoration == null){
            node.elementID.typeDecoration = new TypeDecoration();
        }
        node.elementID.typeDecoration.type = node.collectionID.typeDecoration.type;
        node.elementID.typeDecoration.typeModifier = newModifier;
        DeclareStmtNode declElement = new DeclareStmtNode(node.collectionID.typeDecoration.type, newModifier, node.elementID.id);
        symTab.EnterSymbol(declElement, symTab);

        node.stmtNodes = Visit(node.stmtNodes);
        return node;
    };
    public LoopNode Visit(LoopNode node) throws Exception {
        //scope is opened by the StmtListNode
        node.loopcount = (ExprNode) Visit(node.loopcount);
        if(!node.loopcount.typeDecoration.type.equals("int") || !node.loopcount.typeDecoration.typeModifier.equals("")){
            throw new TypeException("loop needs int as type (in: " + node.toString() + ")");
        }
        node.stmtNodes = Visit(node.stmtNodes);
        return node;
    };
    public WhileNode Visit(WhileNode node) throws Exception {
        //scope is opened by the StmtListNode
        node.conditionExpression = (ExprNode) Visit(node.conditionExpression);
        if(!node.conditionExpression.typeDecoration.type.equals("bool") || !node.conditionExpression.typeDecoration.typeModifier.equals("")){
            throw new TypeException("while needs boolean as type (in: " + node.toString() + ")");
        }
        node.stmtNodes = Visit(node.stmtNodes);
        return node;
    };
    public ExprStmtNode Visit(ExprStmtNode node) throws Exception {
        node.expr = (ExprNode) Visit(node.expr);
        ExprNode expr = node.expr;
        if(!(expr instanceof FunctionCallNode) && !(expr instanceof  MethodCallNode)){
            throw new InvalidStatementException("Invalid statement: " + node.toString());
        }
        return node;
    };
    public IntLiteralNode Visit(IntLiteralNode node){
        node.typeDecoration = new TypeDecoration("int", "");
        return node;
    };
    public FloatLiteralNode Visit(FloatLiteralNode node){
        node.typeDecoration = new TypeDecoration("float", "");
        return node;
    };
    public PiLiteralNode Visit(PiLiteralNode node){
        node.typeDecoration = new TypeDecoration("float", "");
        return node;
    };
    public StringLiteralNode Visit(StringLiteralNode node){
        node.typeDecoration = new TypeDecoration("string", "");
        return node;
    };
    public BoolLiteralNode Visit(BoolLiteralNode node){
        node.typeDecoration = new TypeDecoration("bool", "");
        return node;
    };
    public AngleLiteralNode Visit(AngleLiteralNode node){
        node.typeDecoration = new TypeDecoration("angle", "");
        return node;
    };
    public ArrayLiteralNode Visit(ArrayLiteralNode node) throws Exception {
        if(node.elements != null){
            //visit
            for(int i = 0; i < node.elements.size(); i++){
                node.elements.set(i, (ExprNode) Visit(node.elements.get(i)));
            }
            //type check
            //also allow implicit type conversions (angle > float > int)
            TypeDecoration currentLargestType = new TypeDecoration();
            for(int i = 0; i < node.elements.size(); i++){
                try{
                    currentLargestType = CompatibleTypes(currentLargestType, node.elements.get(i).typeDecoration);
                }
                catch(TypeException e){
                    throw new TypeException("Elements of incompatible types not allowed in lists (in: " + node.toString() + ")");
                }
            }
            //decorate
            node.typeDecoration = currentLargestType;
            node.typeDecoration.typeModifier += "[]"; //add another list dimension (e.g. int -> int[])
        }
        return node;
    };
    public FunctionCallNode Visit(FunctionCallNode node) throws Exception {
        node.id = Visit(node.id);
        node.parameters = Visit(node.parameters);
        //retrieval also checks types of parameters
        FuncSymbol funcSym = symTab.RetrieveSymbol(node.id.id, symTab, node.parameters);
        node.typeDecoration = new TypeDecoration(funcSym.type, funcSym.typeModifier);
        return node;
    };
    public MethodCallNode Visit(MethodCallNode node) throws Exception {
        node.valueID = (VariableAccessNode) Visit(node.valueID);
        node.methodID = Visit(node.methodID);
        node.parameters = Visit(node.parameters);
        VarSymbol variable = symTab.RetrieveSymbol(node.valueID.GetID(), symTab);
        //retrieve also checks types of parameters
        FuncSymbol method = variable.fields.RetrieveSymbol(node.methodID.id, variable.fields, node.parameters);
        node.typeDecoration = new TypeDecoration(method.type, method.typeModifier);
        return node;
    };
    public PropertyCallNode Visit(PropertyCallNode node) throws Exception {
        node.valueID = (VariableAccessNode) Visit(node.valueID);
        node.propertyID = Visit(node.propertyID);
        VarSymbol value = symTab.RetrieveSymbol(node.valueID.GetID(), symTab);
        VarSymbol property = symTab.RetrieveSymbol(node.propertyID.GetID(), value.fields);
        node.typeDecoration = new TypeDecoration(property.type, property.typeModifier);
        node.typeDecoration.fields = property.fields;
        return node;
    };
    public ParenthesisedExprNode Visit(ParenthesisedExprNode node) throws Exception {
        node.innerExpr = (ExprNode) Visit(node.innerExpr);
        node.typeDecoration = node.innerExpr.typeDecoration;
        //type checking according to operator types
        String type = node.typeDecoration.type;
        if(!type.equals("int") && !type.equals("float") && !type.equals("bool") && !type.equals("angle")){
            throw new TypeException("disallowed type in parenthesized expression: " + node.toString());
        }
        else if(!node.typeDecoration.typeModifier.equals("")){
            throw new TypeException("Lists not allowed in parenthesized expression: " + node.toString());
        }
        return node;
    };
    public UnaryMinusNode Visit(UnaryMinusNode node) throws Exception {
        node.expr = (ExprNode) Visit(node.expr);
        node.typeDecoration = node.expr.typeDecoration;
        //type checking according to operator types
        String type = node.typeDecoration.type;
        if(!type.equals("int") && !type.equals("float") && !type.equals("angle")){
            throw new TypeException("disallowed type in unary minus expression: " + node.toString());
        }
        else if(!node.typeDecoration.typeModifier.equals("")){
            throw new TypeException("Lists not allowed in unary minus expression: " + node.toString());
        }
        return node;
    };
    public UnaryPlusNode Visit(UnaryPlusNode node) throws Exception {
        node.expr = (ExprNode) Visit(node.expr);
        node.typeDecoration = node.expr.typeDecoration;
        //type checking according to operator types
        String type = node.typeDecoration.type;
        if(!type.equals("int") && !type.equals("float") && !type.equals("angle")){
            throw new TypeException("disallowed type in unary plus expression: " + node.toString());
        }
        else if(!node.typeDecoration.typeModifier.equals("")){
            throw new TypeException("Lists not allowed in unary plus expression: " + node.toString());
        }
        return node;
    };
    public UnaryNegationNode Visit(UnaryNegationNode node) throws Exception {
        node.expr = (ExprNode) Visit(node.expr);
        node.typeDecoration = node.expr.typeDecoration;
        //type checking according to operator types
        String type = node.typeDecoration.type;
        if(!type.equals("bool")){
            throw new TypeException("disallowed type in unary negation expression: " + node.toString());
        }
        else if(!node.typeDecoration.typeModifier.equals("")){
            throw new TypeException("Lists not allowed in unary negation expression: " + node.toString());
        }
        return node;
    };
    public SubtractionNode Visit(SubtractionNode node) throws Exception {
        node.left = (ExprNode) Visit(node.left);
        node.right = (ExprNode) Visit(node.right);
        //check they have compatible types
        //also throws error if incompatible
        node.typeDecoration = CompatibleTypes(node.left.typeDecoration, node.right.typeDecoration);
        //type checking according to operator types
        String type = node.typeDecoration.type;
        if(!type.equals("int") && !type.equals("float") && !type.equals("angle") && !type.equals("point")){
            throw new TypeException("disallowed type in subtraction expression: " + node.toString());
        }
        else if(!node.typeDecoration.typeModifier.equals("")){
            throw new TypeException("Lists not allowed in subtraction expression: " + node.toString());
        }
        return node;
    };
    public AdditionNode Visit(AdditionNode node) throws Exception {
        node.left = (ExprNode) Visit(node.left);
        node.right = (ExprNode) Visit(node.right);
        //check they have compatible types
        //also throws error if incompatible
        node.typeDecoration = CompatibleTypes(node.left.typeDecoration, node.right.typeDecoration);
        //type checking according to operator types
        String type = node.typeDecoration.type;
        if(!type.equals("int") && !type.equals("float") && !type.equals("angle") && !type.equals("point")){
            throw new TypeException("disallowed type in addition expression: " + node.toString());
        }
        else if(!node.typeDecoration.typeModifier.equals("")){
            throw new TypeException("Lists not allowed in addition expression: " + node.toString());
        }
        return node;
    };
    public MultiplicationNode Visit(MultiplicationNode node) throws Exception {
        node.left = (ExprNode) Visit(node.left);
        node.right = (ExprNode) Visit(node.right);
        //check they have compatible types
        //also throws error if incompatible
        node.typeDecoration = CompatibleTypes(node.left.typeDecoration, node.right.typeDecoration);
        //type checking according to operator types
        String type = node.typeDecoration.type;
        if(!type.equals("int") && !type.equals("float") && !type.equals("angle")){
            throw new TypeException("disallowed type in multiplication expression: " + node.toString());
        }
        else if(!node.typeDecoration.typeModifier.equals("")){
            throw new TypeException("Lists not allowed in multiplication expression: " + node.toString());
        }
        return node;
    };
    public DivisionNode Visit(DivisionNode node) throws Exception {
        node.left = (ExprNode) Visit(node.left);
        node.right = (ExprNode) Visit(node.right);
        //check they have compatible types
        //also throws error if incompatible
        node.typeDecoration = CompatibleTypes(node.left.typeDecoration, node.right.typeDecoration);
        //type checking according to operator types
        String type = node.typeDecoration.type;
        if(!type.equals("int") && !type.equals("float") && !type.equals("angle")){
            throw new TypeException("disallowed type in division expression: " + node.toString());
        }
        else if(!node.typeDecoration.typeModifier.equals("")){
            throw new TypeException("Lists not allowed in division expression: " + node.toString());
        }
        return node;
    };
    public ModuloNode Visit(ModuloNode node) throws Exception {
        node.left = (ExprNode) Visit(node.left);
        node.right = (ExprNode) Visit(node.right);
        //check they have compatible types
        //also throws error if incompatible
        node.typeDecoration = CompatibleTypes(node.left.typeDecoration, node.right.typeDecoration);
        //type checking according to operator types
        String type = node.typeDecoration.type;
        if(!type.equals("int") && !type.equals("float") && !type.equals("angle")){
            throw new TypeException("disallowed type in modulo expression: " + node.toString());
        }
        else if(!node.typeDecoration.typeModifier.equals("")){
            throw new TypeException("Lists not allowed in modulo expression: " + node.toString());
        }
        return node;
    };
    public PowerNode Visit(PowerNode node) throws Exception {
        node.left = (ExprNode) Visit(node.left);
        node.right = (ExprNode) Visit(node.right);
        //check they have compatible types
        //also throws error if incompatible
        node.typeDecoration = CompatibleTypes(node.left.typeDecoration, node.right.typeDecoration);
        //type checking according to operator types
        String type = node.typeDecoration.type;
        if(!type.equals("int") && !type.equals("float")){
            throw new TypeException("disallowed type in power expression: " + node.toString());
        }
        else if(!node.typeDecoration.typeModifier.equals("")){
            throw new TypeException("Lists not allowed in power expression: " + node.toString());
        }
        return node;
    };
    public EqualsNode Visit(EqualsNode node) throws Exception {
        node.left = (ExprNode) Visit(node.left);
        node.right = (ExprNode) Visit(node.right);
        //check they have compatible types
        //also throws error if incompatible
        node.typeDecoration = CompatibleTypesBoolOp(node.left.typeDecoration, node.right.typeDecoration);
        //type checking according to operator types
        String type = node.typeDecoration.type;
        if(type.equals("string")){
            throw new TypeException("disallowed type in equals expression: " + node.toString());
        }
        else if(!node.typeDecoration.typeModifier.equals("")){
            throw new TypeException("Lists not allowed in equals expression: " + node.toString());
        }
        //if nothing failed
        node.typeDecoration.type = "bool";
        return node;
    };
    public NotEqualsNode Visit(NotEqualsNode node) throws Exception {
        node.left = (ExprNode) Visit(node.left);
        node.right = (ExprNode) Visit(node.right);
        //check they have compatible types
        //also throws error if incompatible
        node.typeDecoration = CompatibleTypesBoolOp(node.left.typeDecoration, node.right.typeDecoration);
        //type checking according to operator types
        String type = node.typeDecoration.type;
        if(type.equals("string")){
            throw new TypeException("disallowed type in notEquals expression: " + node.toString());
        }
        else if(!node.typeDecoration.typeModifier.equals("")){
            throw new TypeException("Lists not allowed in notEquals expression: " + node.toString());
        }
        //if nothing failed
        node.typeDecoration.type = "bool";
        return node;
    };
    public LesserThanNode Visit(LesserThanNode node) throws Exception {
        node.left = (ExprNode) Visit(node.left);
        node.right = (ExprNode) Visit(node.right);
        //check they have compatible types
        //also throws error if incompatible
        node.typeDecoration = CompatibleTypesBoolOp(node.left.typeDecoration, node.right.typeDecoration);
        //type checking according to operator types
        String type = node.typeDecoration.type;
        if(!type.equals("int") && !type.equals("float") && !type.equals("angle")){
            throw new TypeException("disallowed type in lesserThan expression: " + node.toString());
        }
        else if(!node.typeDecoration.typeModifier.equals("")){
            throw new TypeException("Lists not allowed in lesserThan expression: " + node.toString());
        }
        //if nothing failed
        node.typeDecoration.type = "bool";
        return node;
    };
    public GreaterThanNode Visit(GreaterThanNode node) throws Exception {
        node.left = (ExprNode) Visit(node.left);
        node.right = (ExprNode) Visit(node.right);
        //check they have compatible types
        //also throws error if incompatible
        node.typeDecoration = CompatibleTypesBoolOp(node.left.typeDecoration, node.right.typeDecoration);
        //type checking according to operator types
        String type = node.typeDecoration.type;
        if(!type.equals("int") && !type.equals("float") && !type.equals("angle")){
            throw new TypeException("disallowed type in greaterThan expression: " + node.toString());
        }
        else if(!node.typeDecoration.typeModifier.equals("")){
            throw new TypeException("Lists not allowed in greaterThan expression: " + node.toString());
        }
        //if nothing failed
        node.typeDecoration.type = "bool";
        return node;
    };
    public LesserOrEqualsNode Visit(LesserOrEqualsNode node) throws Exception {
        node.left = (ExprNode) Visit(node.left);
        node.right = (ExprNode) Visit(node.right);
        //check they have compatible types
        //also throws error if incompatible
        node.typeDecoration = CompatibleTypesBoolOp(node.left.typeDecoration, node.right.typeDecoration);
        //type checking according to operator types
        String type = node.typeDecoration.type;
        if(!type.equals("int") && !type.equals("float") && !type.equals("angle")){
            throw new TypeException("disallowed type in lesserOrEquals expression: " + node.toString());
        }
        else if(!node.typeDecoration.typeModifier.equals("")){
            throw new TypeException("Lists not allowed in lesserOrEquals expression: " + node.toString());
        }
        //if nothing failed
        node.typeDecoration.type = "bool";
        return node;
    };
    public GreaterOrEqualsNode Visit(GreaterOrEqualsNode node) throws Exception {
        node.left = (ExprNode) Visit(node.left);
        node.right = (ExprNode) Visit(node.right);
        //check they have compatible types
        //also throws error if incompatible
        node.typeDecoration = CompatibleTypesBoolOp(node.left.typeDecoration, node.right.typeDecoration);
        //type checking according to operator types
        String type = node.typeDecoration.type;
        if(!type.equals("int") && !type.equals("float") && !type.equals("angle")){
            throw new TypeException("disallowed type in greaterOrEquals expression: " + node.toString());
        }
        else if(!node.typeDecoration.typeModifier.equals("")){
            throw new TypeException("Lists not allowed in greaterOrEquals expression: " + node.toString());
        }
        //if nothing failed
        node.typeDecoration.type = "bool";
        return node;
    };
    public AndNode Visit(AndNode node) throws Exception {
        node.left = (ExprNode) Visit(node.left);
        node.right = (ExprNode) Visit(node.right);
        if(!node.left.typeDecoration.type.equals("bool") || !node.right.typeDecoration.type.equals("bool")){
            throw new TypeException("non-boolean values not allowed in AND expression: " + node.toString());
        }
        else if(!node.left.typeDecoration.typeModifier.equals("") || !node.right.typeDecoration.typeModifier.equals("")){
            throw new TypeException("list values not allowed in AND expression: " + node.toString());
        }
        return node;
    };
    public OrNode Visit(OrNode node) throws Exception {
        node.left = (ExprNode) Visit(node.left);
        node.right = (ExprNode) Visit(node.right);
        if(!node.left.typeDecoration.type.equals("bool") || !node.right.typeDecoration.type.equals("bool")){
            throw new TypeException("non-boolean values not allowed in OR expression: " + node.toString());
        }
        else if(!node.left.typeDecoration.typeModifier.equals("") || !node.right.typeDecoration.typeModifier.equals("")){
            throw new TypeException("list values not allowed in OR expression: " + node.toString());
        }
        return node;
    };


    //auxiliary functions
    private TypeDecoration CompatibleTypes(TypeDecoration T1, TypeDecoration T2) throws TypeException {
        if(CompatibleOneway(T1, T2)){
            return T2;
        }
        else if(CompatibleOneway(T2, T1)){
            return T1;
        }
        else{
            throw new TypeException("Incompatible types: ( " + T1.toString() + " ) and ( " + T2.toString() + " )");
        }
    }
    private boolean CompatibleOneway(TypeDecoration T1, TypeDecoration T2){
        if(Objects.equals(T1, T2)){
            return true;
        }
        else{
            //check if T1 can be implicitly converted to T2
            if(Objects.equals(T1.type, "int") && Objects.equals(T2.type, "float")){
                return true;
            }
            else if(Objects.equals(T1.type, "int") && Objects.equals(T2.type, "angle")){
                return true;
            }
            else if(Objects.equals(T1.type, "float") && Objects.equals(T2.type, "angle")){
                return true;
            }
            else{
                return false;
            }
        }
    }

    private TypeDecoration CompatibleTypesBoolOp(TypeDecoration T1, TypeDecoration T2) throws TypeException {
        if(CompatibleOnewayBoolOp(T1, T2)){
            return T2;
        }
        else if(CompatibleOnewayBoolOp(T2, T1)){
            return T1;
        }
        else{
            throw new TypeException("Incompatible types for comparison/equality: ( " + T1.toString() + " ) and ( " + T2.toString() + " )");
        }
    }
    private boolean CompatibleOnewayBoolOp(TypeDecoration T1, TypeDecoration T2){
        if(Objects.equals(T1, T2)){
            return true;
        }
        else if(T1 != null && T2 != null){
            //check if T1 can be implicitly converted to T2
            if(Objects.equals(T1.type, "int") && Objects.equals(T2.type, "float")){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }



    public Node Visit(Node node) throws Exception {
        if(node instanceof ProgramNode){
            return Visit((ProgramNode)node);
        }else if(node instanceof ContentNode){
            return Visit((ContentNode)node);
        }else if(node instanceof FunctionNode){
            return Visit((FunctionNode)node);
        }else if(node instanceof DeclareStmtListNode){
            return Visit((DeclareStmtListNode)node);
        }else if(node instanceof ValueListNode){
            return Visit((ValueListNode)node);
        }else if(node instanceof StmtListNode){
            return Visit((StmtListNode)node);
        }else if(node instanceof ReturnStmtNode){
            return Visit((ReturnStmtNode)node);
        }else if(node instanceof DeclareStmtNode){
            return Visit((DeclareStmtNode)node);
        }else if(node instanceof AssignNode){
            return Visit((AssignNode)node);
        }else if(node instanceof IdentifierNode){
            return Visit((IdentifierNode)node);
        }else if(node instanceof VariableModifierAccessNode){
            return Visit((VariableModifierAccessNode)node);
        }else if(node instanceof VariablePropertyAccessNode) {
            return Visit((VariablePropertyAccessNode) node);
        }else if(node instanceof VariableAccessExprNode){
            return Visit((VariableAccessExprNode) node);
        }else if(node instanceof IfNode){
            return Visit((IfNode)node);
        }else if(node instanceof SwitchNode){
            return Visit((SwitchNode)node);
        }else if(node instanceof DefinedCaseListNode){
            return Visit((DefinedCaseListNode)node);
        }else if(node instanceof DefinedCaseNode){
            return Visit((DefinedCaseNode)node);
        }else if(node instanceof DefaultCaseNode){
            return Visit((DefaultCaseNode)node);
        }else if(node instanceof ForeachNode){
            return Visit((ForeachNode)node);
        }else if(node instanceof LoopNode){
            return Visit((LoopNode)node);
        }else if(node instanceof WhileNode){
            return Visit((WhileNode)node);
        }else if(node instanceof ExprStmtNode){
            return Visit((ExprStmtNode)node);
        }else if(node instanceof IntLiteralNode){
            return Visit((IntLiteralNode)node);
        }else if(node instanceof FloatLiteralNode){
            return Visit((FloatLiteralNode)node);
        }else if(node instanceof PiLiteralNode){
            return Visit((PiLiteralNode)node);
        }else if(node instanceof StringLiteralNode){
            return Visit((StringLiteralNode)node);
        }else if(node instanceof BoolLiteralNode){
            return Visit((BoolLiteralNode)node);
        }else if(node instanceof AngleLiteralNode){
            return Visit((AngleLiteralNode)node);
        }else if(node instanceof ArrayLiteralNode){
            return Visit((ArrayLiteralNode)node);
        }else if(node instanceof FunctionCallNode){
            return Visit((FunctionCallNode)node);
        }else if(node instanceof MethodCallNode){
            return Visit((MethodCallNode)node);
        }else if(node instanceof PropertyCallNode){
            return Visit((PropertyCallNode)node);
        }else if(node instanceof ParenthesisedExprNode){
            return Visit((ParenthesisedExprNode)node);
        }else if(node instanceof UnaryMinusNode){
            return Visit((UnaryMinusNode)node);
        }else if(node instanceof UnaryPlusNode){
            return Visit((UnaryPlusNode)node);
        }else if(node instanceof UnaryNegationNode){
            return Visit((UnaryNegationNode)node);
        }else if(node instanceof SubtractionNode){
            return Visit((SubtractionNode)node);
        }else if(node instanceof AdditionNode){
            return Visit((AdditionNode)node);
        }else if(node instanceof MultiplicationNode){
            return Visit((MultiplicationNode)node);
        }else if(node instanceof DivisionNode){
            return Visit((DivisionNode)node);
        }else if(node instanceof ModuloNode){
            return Visit((ModuloNode)node);
        }else if(node instanceof PowerNode){
            return Visit((PowerNode)node);
        }else if(node instanceof EqualsNode){
            return Visit((EqualsNode)node);
        }else if(node instanceof NotEqualsNode){
            return Visit((NotEqualsNode)node);
        }else if(node instanceof LesserThanNode){
            return Visit((LesserThanNode)node);
        }else if(node instanceof GreaterThanNode){
            return Visit((GreaterThanNode)node);
        }else if(node instanceof LesserOrEqualsNode){
            return Visit((LesserOrEqualsNode)node);
        }else if(node instanceof GreaterOrEqualsNode){
            return Visit((GreaterOrEqualsNode)node);
        }else if(node instanceof AndNode){
            return Visit((AndNode)node);
        }else if(node instanceof OrNode){
            return Visit((OrNode)node);
        }
        else
            throw new NotImplementedError();
    }
}
