package AST;

import Exceptions.SymbolAlreadyDeclaredException;
import kotlin.NotImplementedError;


public abstract class AstVisitor<T> {
    public T Visit(ProgramNode node) {
        //open global scope
        SymTab.OpenScope();
        return null;
        //scope to be closed by caller
    }

    public T Visit(ContentNode node) throws Exception {
        //load all functions
        for(int i = 0; i < node.functionNodes.size(); i++){
            SymTab.EnterSymbol(node.functionNodes.get(i));
        }
        return null;
    };
    public T Visit(FunctionNode node){
        //scope is opened by the StmtListNode
        return null;
    };
    public T Visit(DeclareStmtListNode node){
        return null;
    };
    public T Visit(ValueListNode node){
        return null;
    };
    public T Visit(StmtListNode node){
        SymTab.OpenScope();
        return null;
        //scope to be closed by caller
    };
    public T Visit(ReturnStmtNode node){
        return null;
    };
    public T Visit(DeclareStmtNode node) throws SymbolAlreadyDeclaredException {
        SymTab.EnterSymbol(node);
        return null;
    };
    public T Visit(AssignNode node){
        return null;
    };
    public T Visit(IdentifierNode node){
        return null;
    };
    public T Visit(VariableModifierAccessNode node){
        return null;
    };
    public T Visit(VariablePropertyAccessNode node){
        return null;
    };
    public T Visit(IfNode node){
        //scope is opened by the StmtListNode
        return null;
    };
    public T Visit(SwitchNode node){
        //cases open their own scopes
        return null;
    };
    public T Visit(DefinedCaseListNode node){
        return null;
    };
    public T Visit(DefinedCaseNode node){
        //scope is opened by the StmtListNode
        return null;
    };
    public T Visit(DefaultCaseNode node){
        //scope is opened by the StmtListNode
        return null;
    };
    public T Visit(ForeachNode node){
        //scope is opened by the StmtListNode
        return null;
    };
    public T Visit(LoopNode node){
        //scope is opened by the StmtListNode
        return null;
    };
    public T Visit(WhileNode node){
        //scope is opened by the StmtListNode
        return null;
    };
    public T Visit(ExprStmtNode node){
        return null;
    };
    public T Visit(IntLiteralNode node){
        return null;
    };
    public T Visit(FloatLiteralNode node){
        return null;
    };
    public T Visit(PiLiteralNode node){
        return null;
    };
    public T Visit(StringLiteralNode node){
        return null;
    };
    public T Visit(BoolLiteralNode node){
        return null;
    };
    public T Visit(AngleLiteralNode node){
        return null;
    };
    public T Visit(ArrayLiteralNode node){
        return null;
    };
    public T Visit(TypeModAccessNode node){
        return null;
    };
    public T Visit(FunctionCallNode node){
        return null;
    };
    public T Visit(MethodCallNode node){
        return null;
    };
    public T Visit(PropertyCallNode node){
        return null;
    };
    public T Visit(ParenthesisedExprNode node){
        return null;
    };
    public T Visit(UnaryMinusNode node){
        return null;
    };
    public T Visit(UnaryPlusNode node){
        return null;
    };
    public T Visit(UnaryNegationNode node){
        return null;
    };
    public T Visit(SubtractionNode node){
        return null;
    };
    public T Visit(AdditionNode node){
        return null;
    };
    public T Visit(MultiplicationNode node){
        return null;
    };
    public T Visit(DivisionNode node){
        return null;
    };
    public T Visit(ModuloNode node){
        return null;
    };
    public T Visit(PowerNode node){
        return null;
    };
    public T Visit(EqualsNode node){
        return null;
    };
    public T Visit(NotEqualsNode node){
        return null;
    };
    public T Visit(LesserThanNode node){
        return null;
    };
    public T Visit(GreaterThanNode node){
        return null;
    };
    public T Visit(LesserOrEqualsNode node){
        return null;
    };
    public T Visit(GreaterOrEqualsNode node){
        return null;
    };
    public T Visit(AndNode node){
        return null;
    };
    public T Visit(OrNode node){
        return null;
    };


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
