package AST;

import Exceptions.SymbolAlreadyDeclaredException;
import Exceptions.TypeException;
import kotlin.NotImplementedError;


public abstract class ASTvisitor<T> {
    public abstract T Visit(ProgramNode node) throws Exception;
    public abstract T Visit(ContentNode node) throws Exception;
    public abstract T Visit(FunctionNode node) throws Exception;
    public abstract T Visit(DeclareStmtListNode node) throws SymbolAlreadyDeclaredException;
    public abstract T Visit(ValueListNode node) throws Exception;
    public abstract T Visit(StmtListNode node) throws Exception;
    public abstract T Visit(ReturnStmtNode node) throws Exception;
    public abstract T Visit(DeclareStmtNode node) throws SymbolAlreadyDeclaredException;
    public abstract T Visit(AssignNode node) throws Exception;
    public abstract T Visit(IdentifierNode node);
    public abstract T Visit(VariableModifierAccessNode node) throws Exception;
    public abstract T Visit(VariablePropertyAccessNode node) throws Exception;
    public abstract T Visit(IfNode node) throws Exception;
    public abstract T Visit(SwitchNode node) throws Exception;
    public abstract T Visit(DefinedCaseListNode node) throws Exception;
    public abstract T Visit(DefinedCaseNode node) throws Exception;
    public abstract T Visit(DefaultCaseNode node) throws Exception;
    public abstract T Visit(ForeachNode node) throws Exception;
    public abstract T Visit(LoopNode node) throws Exception;
    public abstract T Visit(WhileNode node) throws Exception;
    public abstract T Visit(ExprStmtNode node) throws Exception;
    public abstract T Visit(IntLiteralNode node);
    public abstract T Visit(FloatLiteralNode node);
    public abstract T Visit(PiLiteralNode node);
    public abstract T Visit(StringLiteralNode node);
    public abstract T Visit(BoolLiteralNode node);
    public abstract T Visit(AngleLiteralNode node);
    public abstract T Visit(ArrayLiteralNode node) throws Exception;
    public abstract T Visit(FunctionCallNode node) throws Exception;
    public abstract T Visit(MethodCallNode node) throws Exception;
    public abstract T Visit(PropertyCallNode node) throws Exception;
    public abstract T Visit(ParenthesisedExprNode node) throws Exception;
    public abstract T Visit(UnaryMinusNode node) throws Exception;
    public abstract T Visit(UnaryPlusNode node) throws Exception;
    public abstract T Visit(UnaryNegationNode node) throws Exception;
    public abstract T Visit(SubtractionNode node) throws Exception;
    public abstract T Visit(AdditionNode node) throws Exception;
    public abstract T Visit(MultiplicationNode node) throws Exception;
    public abstract T Visit(DivisionNode node) throws Exception;
    public abstract T Visit(ModuloNode node) throws Exception;
    public abstract T Visit(PowerNode node) throws Exception;
    public abstract T Visit(EqualsNode node) throws Exception;
    public abstract T Visit(NotEqualsNode node) throws Exception;
    public abstract T Visit(LesserThanNode node) throws Exception;
    public abstract T Visit(GreaterThanNode node) throws Exception;
    public abstract T Visit(LesserOrEqualsNode node) throws Exception;
    public abstract T Visit(GreaterOrEqualsNode node) throws Exception;
    public abstract T Visit(AndNode node) throws Exception;
    public abstract T Visit(OrNode node) throws Exception;


    public T Visit(Node node) throws Exception {
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
