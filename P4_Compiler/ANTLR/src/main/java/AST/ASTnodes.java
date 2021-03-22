package AST;

import java.util.List;

class ProgramNode {
    public List<StmtNode> stmtNodes;
    public List<FunctionNode> functionNodes;
}

class FunctionNode {
    TypeNode type;
    IdentifierNode id;
    List<DeclareStmtNode> parameters;
    List<StmtNode> stmtNodes;
}


//------------statements--------------
abstract class StmtNode {
}

class ReturnStmtNode extends StmtNode {
    ExprNode value;
}
class DeclareStmtNode extends StmtNode {
    TypeNode type;
    IdentifierNode id;
    TypeModifierNode modifier;
    ExprNode value;
}
class AssignNode extends StmtNode {
    IdentifierNode id;
    ExprNode value;
}

//----selection----
class IfNode extends StmtNode {
    ExprNode value;
    List<StmtNode> ifStmtNodes;
    List<StmtNode> elseStmtNodes;
}
class SwitchNode extends StmtNode {
    ExprNode value;
    List<DefinedCaseNode> cases;
    DefaultCaseNode defaultCase;
}
class DefinedCaseNode {
    ExprNode value;
    List<StmtNode> stmtNodes;
    boolean fallthrough;
}

class DefaultCaseNode {
    List<StmtNode> stmtNodes;
}

//----iteration----
class ForNode extends StmtNode {
    TypeNode controlType;
    AssignNode controlAssign;
    ExprNode conditionExpression;
    AssignNode updateAssign;
    List<StmtNode> stmtNodes;
}
class ForeachNode extends StmtNode {
    IdentifierNode elementID;
    IdentifierNode collectionID;
    List<StmtNode> stmtNodes;
}
class LoopNode extends StmtNode {
    ExprNode loopcount;
    List<StmtNode> stmtNodes;
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

class IdentifierNode{
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

class TypeNode {
    AccessModiferNode modifer;
    SimpleTypeNode type;
}

abstract class AccessModiferNode {

}

class ConstAccessModifierNode extends AccessModiferNode{

}

abstract class SimpleTypeNode {

}

class VoidTypeNode extends SimpleTypeNode {

}

class BoolTypeNode extends SimpleTypeNode {

}

class IntTypeNode extends SimpleTypeNode {

}

class FloatTypeNode extends SimpleTypeNode {

}

class StringTypeNode extends SimpleTypeNode {

}

class PointTypeNode extends SimpleTypeNode {

}

class LineTypeNode extends SimpleTypeNode {

}

class TriangleTypeNode extends SimpleTypeNode {

}

class SquareTypeNode extends SimpleTypeNode {

}

class CircleTypeNode extends SimpleTypeNode {

}

class AngleTypeNode extends SimpleTypeNode {

}

abstract class TypeModifierNode {

}

class ArrayModifierNode extends TypeModifierNode {
    int dimensions;
}
