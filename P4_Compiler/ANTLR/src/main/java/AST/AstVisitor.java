package AST;

import kotlin.NotImplementedError;

import java.lang.reflect.Method;

public abstract class AstVisitor<T> {
    public T Visit(ProgramNode node) {
        //open global scope
        SymTab.OpenScope();
        return null;
    }

    public T Visit(ContentNode node) {
        //load all functions

        return null;
    };
    public abstract T Visit(FunctionNode node);
    public abstract T Visit(DeclareStmtListNode node);
    public abstract T Visit(ValueListNode node);
    public abstract T Visit(StmtListNode node);
    public abstract T Visit(ReturnStmtNode node);
    public abstract T Visit(DeclareStmtNode node);
    public abstract T Visit(AssignNode node);
    public abstract T Visit(IdentifierNode node);
    public abstract T Visit(VariableModifierAccessNode node);
    public abstract T Visit(VariablePropertyAccessNode node);
    public abstract T Visit(IfNode node);
    public abstract T Visit(SwitchNode node);
    public abstract T Visit(DefinedCaseListNode node);
    public abstract T Visit(DefinedCaseNode node);
    public abstract T Visit(DefaultCaseNode node);
    public abstract T Visit(ForeachNode node);
    public abstract T Visit(LoopNode node);
    public abstract T Visit(WhileNode node);
    public abstract T Visit(ExprStmtNode node);
    public abstract T Visit(IntLiteralNode node);
    public abstract T Visit(FloatLiteralNode node);
    public abstract T Visit(PiLiteralNode node);
    public abstract T Visit(StringLiteralNode node);
    public abstract T Visit(BoolLiteralNode node);
    public abstract T Visit(AngleLiteralNode node);
    public abstract T Visit(ArrayLiteralNode node);
    public abstract T Visit(TypeModAccessNode node);
    public abstract T Visit(FunctionCallNode node);
    public abstract T Visit(MethodCallNode node);
    public abstract T Visit(PropertyCallNode node);
    public abstract T Visit(ParenthesisedExprNode node);
    public abstract T Visit(UnaryMinusNode node);
    public abstract T Visit(UnaryPlusNode node);
    public abstract T Visit(UnaryNegationNode node);
    public abstract T Visit(SubtractionNode node);
    public abstract T Visit(AdditionNode node);
    public abstract T Visit(MultiplicationNode node);
    public abstract T Visit(DivisionNode node);
    public abstract T Visit(ModuloNode node);
    public abstract T Visit(PowerNode node);
    public abstract T Visit(EqualsNode node);
    public abstract T Visit(NotEqualsNode node);
    public abstract T Visit(LesserThanNode node);
    public abstract T Visit(GreaterThanNode node);
    public abstract T Visit(LesserOrEqualsNode node);
    public abstract T Visit(GreaterOrEqualsNode node);
    public abstract T Visit(AndNode node);
    public abstract T Visit(OrNode node);


    public T Visit(Node node) {
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
