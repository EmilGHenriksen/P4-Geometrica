package AST;

import kotlin.NotImplementedError;

import java.lang.reflect.Method;

public abstract class AstVisitor<T> {
    public abstract T Visit(ProgramNode node);
    public abstract T Visit(ContentNode node);
    public abstract T Visit(FunctionNode node);
    public abstract T Visit(DeclareStmtListNode node);
    public abstract T Visit(ReturnStmtNode node);
    public abstract T Visit(DeclareStmtNode node);
    public abstract T Visit(AssignNode node);
    public abstract T Visit(IfNode node);
    public abstract T Visit(SwitchNode node);
    public abstract T Visit(DefinedCaseListNode node);
    public abstract T Visit(DefinedCaseNode node);
    public abstract T Visit(DefaultCaseNode node);
    public abstract T Visit(ForeachNode node);
    public abstract T Visit(LoopNode node);
    public abstract T Visit(WhileNode node);
    public abstract T Visit(IntLiteralNode node);
    public abstract T Visit(FloatLiteralNode node);
    public abstract T Visit(PiLiteralNode node);
    public abstract T Visit(StringLiteralNode node);
    public abstract T Visit(BoolLiteralNode node);
    public abstract T Visit(AngleLiteralNode node);
    public abstract T Visit(ArrayLiteralNode node);
    public abstract T Visit(IdentifierNode node);
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
    public abstract T Visit(PowerNode node);
    public abstract T Visit(ModuloNode node);
    public abstract T Visit(EqualsNode node);
    public abstract T Visit(NotEqualsNode node);
    public abstract T Visit(LesserThanNode node);
    public abstract T Visit(GreaterThanNode node);
    public abstract T Visit(LesserOrEqualsNode node);
    public abstract T Visit(GreaterOrEqualsNode node);
    public abstract T Visit(AndNode node);
    public abstract T Visit(OrNode node);
    public abstract T Visit(TypeNode node);
    public abstract T Visit(ConstAccessModifierNode node);
    public abstract T Visit(VoidTypeNode node);
    public abstract T Visit(BoolTypeNode node);
    public abstract T Visit(IntTypeNode node);
    public abstract T Visit(FloatTypeNode node);
    public abstract T Visit(StringTypeNode node);
    public abstract T Visit(PointTypeNode node);
    public abstract T Visit(LineTypeNode node);
    public abstract T Visit(TriangleTypeNode node);
    public abstract T Visit(SquareTypeNode node);
    public abstract T Visit(CircleTypeNode node);
    public abstract T Visit(AngleTypeNode node);
    public abstract T Visit(ArrayModifierNode node);

    public T Visit(Node node) {
        if (node instanceof ProgramNode) {
            return Visit((ProgramNode)node);
        } else if(node instanceof ContentNode){
            return Visit((ContentNode)node);
        } else if(node instanceof FunctionNode){
            return Visit((FunctionNode)node);
        } else if(node instanceof DeclareStmtListNode){
            return Visit((DeclareStmtListNode)node);
        } else if(node instanceof ReturnStmtNode){
            return Visit((ReturnStmtNode) node);
        } else if(node instanceof DeclareStmtNode){
            return Visit((DeclareStmtNode) node);
        } else if(node instanceof AssignNode){
            return Visit((AssignNode) node);
        } else if(node instanceof IfNode){
            return Visit((IfNode) node);
        } else if(node instanceof SwitchNode){
            return Visit((SwitchNode) node);
        } else if(node instanceof DefinedCaseListNode){
            return Visit((DefinedCaseListNode) node);
        }
        else
            throw new NotImplementedError();
    }
}
