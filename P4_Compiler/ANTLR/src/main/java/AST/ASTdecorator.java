package AST;

import Exceptions.SymbolAlreadyDeclaredException;
import Exceptions.TypeException;
import kotlin.NotImplementedError;


public class ASTdecorator extends ASTvisitor<Node> {
    SymTab symTab;
    public ProgramNode Visit(ProgramNode node) throws Exception {
        symTab = new SymTab();
        //global scope
        symTab.OpenScope();
        node.content = Visit(node.content);
        symTab.CloseScope();
        return node;
    };
    public ContentNode Visit(ContentNode node) throws Exception {
        //load all functions
        for(int i = 0; i < node.functionNodes.size(); i++){
            node.functionNodes.set(i, Visit(node.functionNodes.get(i)));
        }
        //go through all statements
        for(int i = 0; i < node.stmtNodes.size(); i++){
            node.stmtNodes.set(i, (StmtNode) Visit(node.stmtNodes.get(i)));
        }
        return node;
    };
    public FunctionNode Visit(FunctionNode node) throws Exception {
        //scope is opened by the StmtListNode
        node.typeDecoration.type = node.type;
        node.typeDecoration.typeModifier = node.typeModifier;
        symTab.EnterSymbol(node);
        symTab.currentFunc = node.id.id;
        node.stmtFuncNodes = Visit(node.stmtFuncNodes);
        symTab.currentFunc = null;
        return node;
    };
    public DeclareStmtListNode Visit(DeclareStmtListNode node) throws SymbolAlreadyDeclaredException {
        for(int i = 0; i < node.declarations.size(); i++){
            DeclareStmtNode declareStmtNode =  Visit(node.declarations.get(i));
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
        FuncSymbol currentFunc = (FuncSymbol) symTab.RetrieveSymbol(symTab.currentFunc, symTab);
        if(!node.typeDecoration.type.equals(currentFunc.type)
                    || !node.typeDecoration.typeModifier.equals(currentFunc.typeModifier)){
            throw new TypeException("Function: " + currentFunc.id + " does not match type for return statement: " + node.toString());
        }
        return node;
    };
    public DeclareStmtNode Visit(DeclareStmtNode node) throws SymbolAlreadyDeclaredException {
        symTab.EnterSymbol(node, symTab);
        return node;
    };
    public AssignNode Visit(AssignNode node) throws Exception {
        node.variable = (VariableAccessNode) Visit(node.variable);
        node.value = (ExprNode) Visit(node.value);
        //---type checking---
        //copy the node
        VariableAccessNode nodeCurrent = node.variable;
        //find the variable in SymTab
        VarSymbol symCurrent = (VarSymbol) symTab.RetrieveSymbol(nodeCurrent.GetID(), symTab);
        //for every access node, check if it exists in the symbol table
        while(!(nodeCurrent instanceof IdentifierNode)){
            if(nodeCurrent instanceof VariableModifierAccessNode){
                //array access
                if(symCurrent.typeModifier.length() >= nodeCurrent.GetTypeModifier().length()){
                    nodeCurrent = ((VariableModifierAccessNode) nodeCurrent).variable;
                }
                else{
                    throw new TypeException("Assign error: variable " + node.variable.GetID() + " has fewer list dimensions than value: " + node.value);
                }
            }
            else{
                //property access
                symCurrent = (VarSymbol) symTab.RetrieveSymbol(nodeCurrent.GetID(), symCurrent.fields);
                nodeCurrent = ((VariablePropertyAccessNode) nodeCurrent).child;
            }
        }
        //if no exceptions have been thrown, it can be returned
        return node;
    };
    public IdentifierNode Visit(IdentifierNode node){

        return null;
    };
    public VariableModifierAccessNode Visit(VariableModifierAccessNode node){

        return null;
    };
    public VariablePropertyAccessNode Visit(VariablePropertyAccessNode node){

        return null;
    };
    public IfNode Visit(IfNode node){
        //scope is opened by the StmtListNode
        return null;
    };
    public SwitchNode Visit(SwitchNode node){
        //cases open their own scopes
        return null;
    };
    public DefinedCaseListNode Visit(DefinedCaseListNode node){

        return null;
    };
    public DefinedCaseNode Visit(DefinedCaseNode node){
        //scope is opened by the StmtListNode
        return null;
    };
    public DefaultCaseNode Visit(DefaultCaseNode node){
        //scope is opened by the StmtListNode
        return null;
    };
    public ForeachNode Visit(ForeachNode node){
        //scope is opened by the StmtListNode
        return null;
    };
    public LoopNode Visit(LoopNode node){
        //scope is opened by the StmtListNode
        return null;
    };
    public WhileNode Visit(WhileNode node){
        //scope is opened by the StmtListNode
        return null;
    };
    public ExprStmtNode Visit(ExprStmtNode node){
        return null;
    };
    public IntLiteralNode Visit(IntLiteralNode node){
        return null;
    };
    public FloatLiteralNode Visit(FloatLiteralNode node){
        return null;
    };
    public PiLiteralNode Visit(PiLiteralNode node){
        return null;
    };
    public StringLiteralNode Visit(StringLiteralNode node){
        return null;
    };
    public BoolLiteralNode Visit(BoolLiteralNode node){
        return null;
    };
    public AngleLiteralNode Visit(AngleLiteralNode node){
        return null;
    };
    public ArrayLiteralNode Visit(ArrayLiteralNode node){
        return null;
    };
    public TypeModAccessNode Visit(TypeModAccessNode node){
        return null;
    };
    public FunctionCallNode Visit(FunctionCallNode node){
        return null;
    };
    public MethodCallNode Visit(MethodCallNode node){
        return null;
    };
    public PropertyCallNode Visit(PropertyCallNode node){
        return null;
    };
    public ParenthesisedExprNode Visit(ParenthesisedExprNode node){
        return null;
    };
    public UnaryMinusNode Visit(UnaryMinusNode node){
        return null;
    };
    public UnaryPlusNode Visit(UnaryPlusNode node){
        return null;
    };
    public UnaryNegationNode Visit(UnaryNegationNode node){
        return null;
    };
    public SubtractionNode Visit(SubtractionNode node){
        return null;
    };
    public AdditionNode Visit(AdditionNode node){
        return null;
    };
    public MultiplicationNode Visit(MultiplicationNode node){
        return null;
    };
    public DivisionNode Visit(DivisionNode node){
        return null;
    };
    public ModuloNode Visit(ModuloNode node){
        return null;
    };
    public PowerNode Visit(PowerNode node){
        return null;
    };
    public EqualsNode Visit(EqualsNode node){
        return null;
    };
    public NotEqualsNode Visit(NotEqualsNode node){
        return null;
    };
    public LesserThanNode Visit(LesserThanNode node){
        return null;
    };
    public GreaterThanNode Visit(GreaterThanNode node){
        return null;
    };
    public LesserOrEqualsNode Visit(LesserOrEqualsNode node){
        return null;
    };
    public GreaterOrEqualsNode Visit(GreaterOrEqualsNode node){
        return null;
    };
    public AndNode Visit(AndNode node){
        return null;
    };
    public OrNode Visit(OrNode node){
        return null;
    };


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
        }else if(node instanceof VariablePropertyAccessNode){
            return Visit((VariablePropertyAccessNode)node);
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
        }else if(node instanceof TypeModAccessNode){
            return Visit((TypeModAccessNode)node);
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
