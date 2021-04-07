package AST;

import java.util.ArrayList;
import java.util.List;

class ProgramNode extends Node {
    public ContentNode content;
}

class ContentNode extends Node {
    public List<StmtNode> stmtNodes;
    public List<FunctionNode> functionNodes;
    public ContentNode(){
        stmtNodes = new ArrayList<>();
        functionNodes = new ArrayList<>();
    }
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
    public DeclareStmtListNode(){
        declarations = new ArrayList<>();
    }
}

class ValueListNode extends Node {
    List<ExprNode> exprNodes;
    public ValueListNode(){ exprNodes = new ArrayList<>(); }
}

class StmtListNode extends StmtNode {
    List<StmtNode> statements;
    public StmtListNode(){
        statements = new ArrayList<>();
    }
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
    VariableAccessNode variable;
    ExprNode value;
}

//--variable access--
abstract class VariableAccessNode extends AtomExprNode {
}
class IdentifierNode extends VariableModifierAccessNode{
    String id;
}
class VariableModifierAccessNode extends VariableAccessNode {
    VariableAccessNode variable;
    ExprNode expr;
}
class VariablePropertyAccessNode extends VariableAccessNode {
    VariableAccessNode parent;
    VariableAccessNode child;
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
    StmtListNode stmtNodes;
}

//----expr stmt----
class ExprStmtNode extends ExprNode{
    ExprNode expr;
}

//----------------expressions-----------------
abstract class ExprNode extends StmtNode{
}

abstract class OrExprNode extends ExprNode{
}

abstract class AndExprNode extends OrExprNode{
}

abstract class EqualityExprNode extends AndExprNode{
}

abstract class RelationExprNode extends EqualityExprNode{
}

abstract class AdditiveExprNode extends RelationExprNode{
}

abstract class MultiplicativeExprNode extends AdditiveExprNode{
}

abstract class PowerExprNode extends MultiplicativeExprNode{
}

abstract class UnaryExprNode extends PowerExprNode{
    ExprNode expr;
}

abstract class AtomExprNode extends UnaryExprNode{
}

abstract class LiteralNode extends AtomExprNode {
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
    List<ExprNode> elements;
    public ArrayLiteralNode(){
        elements = new ArrayList<>();
    }
}

class TypeModAccessNode extends Node{
    List<ExprNode> exprNodes;
    public TypeModAccessNode(){ exprNodes = new ArrayList<>(); }
}

class FunctionCallNode extends AtomExprNode {
    IdentifierNode id;
    ValueListNode parameters;
}
class MethodCallNode extends AtomExprNode {
    IdentifierNode valueID;
    IdentifierNode methodID;
    ValueListNode parameters;
}
class PropertyCallNode extends AtomExprNode {
    IdentifierNode valueID;
    IdentifierNode propertyID;
}

class ParenthesisedExprNode extends AtomExprNode {
    ExprNode innerExpr;
}

class UnaryMinusNode extends UnaryExprNode{

}

class UnaryPlusNode extends UnaryExprNode{

}

class UnaryNegationNode extends UnaryExprNode{

}

class SubtractionNode extends AdditiveExprNode{
    ExprNode left;
    ExprNode right;
}

class AdditionNode extends AdditiveExprNode{
    ExprNode left;
    ExprNode right;
}

class MultiplicationNode extends MultiplicativeExprNode{
    ExprNode left;
    ExprNode right;
}

class DivisionNode extends MultiplicativeExprNode{
    ExprNode left;
    ExprNode right;
}

class ModuloNode extends MultiplicativeExprNode{
    ExprNode left;
    ExprNode right;
}

class PowerNode extends PowerExprNode{
    ExprNode left;
    ExprNode right;
}

class EqualsNode extends EqualityExprNode{
    ExprNode left;
    ExprNode right;
}

class NotEqualsNode extends EqualityExprNode{
    ExprNode left;
    ExprNode right;
}

class LesserThanNode extends RelationExprNode{
    ExprNode left;
    ExprNode right;
}

class GreaterThanNode extends RelationExprNode{
    ExprNode left;
    ExprNode right;
}

class LesserOrEqualsNode extends RelationExprNode{
    ExprNode left;
    ExprNode right;
}

class GreaterOrEqualsNode extends RelationExprNode{
    ExprNode left;
    ExprNode right;
}

class AndNode extends AndExprNode{
    ExprNode left;
    ExprNode right;
}

class OrNode extends OrExprNode{
    ExprNode left;
    ExprNode right;
}