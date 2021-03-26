package AST;

import java.util.List;

abstract class Node{}

class ProgramNode extends Node {
    public ContentNode content;
}

class ContentNode extends Node {
    public List<StmtNode> stmtNodes;
    public List<FunctionNode> functionNodes;
}

class FunctionNode extends Node {
    String type;
    String typeModifier;
    IdentifierNode id;
    DeclareStmtListNode parameters;
    StmtListNode stmtFuncNodes;
}
class DeclareStmtListNode extends Node {
    List<DeclareStmtNode> declarations;
}
class StmtListNode extends Node {
    List<StmtNode> statements;
}


//------------statements--------------
abstract class StmtNode extends Node {
}

class ReturnStmtNode extends StmtNode {
    ExprNode value;
}
class DeclareStmtNode extends StmtNode {
    String accessModifier;
    String type;
    String typeModifier;
    IdentifierNode id;
    ExprNode value;
}
class AssignNode extends StmtNode {
    IdentifierNode id;
    ExprNode value;
}

//----selection----
class IfNode extends StmtNode {
    ExprNode value;
    StmtListNode ifStmtNodes;
    StmtNode elseStmtNode;
}
class SwitchNode extends StmtNode {
    ExprNode value;
    DefinedCaseListNode cases;
    DefaultCaseNode defaultCase;
}
class DefinedCaseListNode extends Node {
    List<DefinedCaseNode> cases;
}
class DefinedCaseNode extends Node {
    ExprNode value;
    StmtListNode stmtNodes;
}

class DefaultCaseNode extends Node {
    StmtListNode stmtNodes;
}

//----iteration----

class ForeachNode extends StmtNode {
    IdentifierNode elementID;
    IdentifierNode collectionID;
    StmtListNode stmtNodes;
}
class LoopNode extends StmtNode {
    ExprNode loopcount;
    StmtListNode stmtNodes;
}
class WhileNode extends StmtNode {
    ExprNode conditionExpression;
    List<StmtNode> stmtNodes;
}

//----------------expressions-----------------
abstract class ExprNode extends StmtNode{
}

abstract class LiteralNode extends ExprNode {
}

class IntLiteralNode extends LiteralNode{
    Long value;
}

class FloatLiteralNode extends LiteralNode{
    Double value;
}

class PiLiteralNode extends LiteralNode{

}

class StringLiteralNode extends LiteralNode{
    String value;
}

class BoolLiteralNode extends LiteralNode{
    Boolean value;
}

class AngleLiteralNode extends LiteralNode{
    Double value;
}

class ArrayLiteralNode extends LiteralNode{
    List<LiteralNode> elements;
}

class IdentifierNode extends Node {
    String id;
}

class FunctionCallNode extends ExprNode {
    IdentifierNode id;
    List<ExprNode> parameters;
}
class MethodCallNode extends ExprNode {
    IdentifierNode valueID;
    IdentifierNode methodID;
    List<ExprNode> parameters;
}
class PropertyCallNode extends ExprNode {
    IdentifierNode valueID;
    IdentifierNode propertyID;
}

class ParenthesisedExprNode extends ExprNode {
    ExprNode innerExpr;
}

abstract class UnaryExprNode extends ExprNode{
    ExprNode expr;
}

class UnaryMinusNode extends UnaryExprNode{

}

class UnaryPlusNode extends UnaryExprNode{

}

class UnaryNegationNode extends UnaryExprNode{

}

abstract class BinaryExprNode extends ExprNode{
    ExprNode left;
    ExprNode right;
}

class SubtractionNode extends BinaryExprNode{

}

class AdditionNode extends BinaryExprNode{

}

class MultiplicationNode extends BinaryExprNode{

}

class DivisionNode extends BinaryExprNode{

}

class PowerNode extends BinaryExprNode{

}

class ModuloNode extends BinaryExprNode{

}

class EqualsNode extends BinaryExprNode{

}

class NotEqualsNode extends BinaryExprNode{

}

class LesserThanNode extends BinaryExprNode{

}

class GreaterThanNode extends BinaryExprNode{

}

class LesserOrEqualsNode extends BinaryExprNode{

}

class GreaterOrEqualsNode extends BinaryExprNode{

}

class AndNode extends BinaryExprNode{

}

class OrNode extends BinaryExprNode{

}