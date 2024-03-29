package AST;

import java.util.ArrayList;
import java.util.List;

class ProgramNode extends Node {
    public ContentNode content;
}

class ContentNode extends Node {
    public List<Node> stmtAndFuncNodes;
    public ContentNode(){
        stmtAndFuncNodes = new ArrayList<>();
    }
}

class FunctionNode extends Node {
    String type;
    String typeModifier;
    IdentifierNode id;
    DeclareStmtListNode parameters;
    StmtListNode stmtFuncNodes;
    //decoration
    TypeDecoration typeDecoration;
    public FunctionNode(){}
    public FunctionNode(String _name, String _type, String _typeModifier, DeclareStmtListNode _parameters){
        id = new IdentifierNode();
        id.id = _name;
        type = _type;
        typeModifier = _typeModifier;
        parameters = _parameters;
    }
}
class DeclareStmtListNode extends Node {
    List<DeclareStmtNode> declarations;
    public DeclareStmtListNode(){
        declarations = new ArrayList<>();
    }


    @Override
    public boolean equals(Object obj){
        //Check for null and compare run-time types.
        if (!(obj instanceof DeclareStmtListNode))
        {
            return false;
        }
        else {
            DeclareStmtListNode D1 = (DeclareStmtListNode) obj;
            DeclareStmtListNode D2 = this;
            boolean isSame = true;
            for(int i = 0; i < declarations.size(); i++){
                if(!D1.declarations.get(i).equals(D2.declarations.get(i))){
                    isSame = false;
                }
            }
            return isSame;
        }
    }
}

class ValueListNode extends Node {
    List<ExprNode> exprNodes;
    public ValueListNode(){
        exprNodes = new ArrayList<>();
    }
}

class StmtListNode extends StmtNode {
    List<StmtNode> statements;
    boolean hasBraces = true; //default
    public StmtListNode(){
        statements = new ArrayList<>();
    }
}


//------------statements--------------
abstract class StmtNode extends Node {
}

class ReturnStmtNode extends StmtNode {
    ExprNode value;
    //decoration
    TypeDecoration typeDecoration;
}
class DeclareStmtNode extends StmtNode {
    String type;
    String typeModifier;
    IdentifierNode id;
    ExprNode value;
    //symbol table stuff
    public String SymbolString(){
        return id.id + typeModifier;
    }
    public DeclareStmtNode(){}
    public DeclareStmtNode(String _type, String _typeModifier, String _id){
        type = _type;
        typeModifier = _typeModifier;
        id = new IdentifierNode();
        id.id = _id;
    }

    @Override
    public boolean equals(Object obj){
        //Check for null and compare run-time types.
        if (!(obj instanceof DeclareStmtNode))
        {
            return false;
        }
        else {
            DeclareStmtNode D1 = (DeclareStmtNode) obj;
            DeclareStmtNode D2 = this;
            return D1.id.equals(D2.id)
                    && D1.type.equals(D2.type)
                    && D1.typeModifier.equals(D2.typeModifier);
        }
    }
}
class AssignNode extends StmtNode {
    VariableAccessNode variable;
    ExprNode value;
}

//--variable access--
abstract class VariableAccessNode extends Node {
     //symbol table stuff
     TypeDecoration typeDecoration;
     abstract String GetID();
     abstract String GetTypeModifier();
}

class IdentifierNode extends VariableAccessNode{
    //x
    String id;
    //decoration
    Symbol symbol;
    //symbol table stuff
    public String GetID(){
        return id;
    }
    public String GetTypeModifier(){
        return ""; //bottom layer
    }
}
class VariableModifierAccessNode extends VariableAccessNode {
    //x[e]
    VariableAccessNode variable;
    ExprNode expr;
    //symbol table stuff
    public String GetID(){
        return variable.GetID();
    }
    public String GetTypeModifier(){
        return "[]" + variable.GetTypeModifier();
    }
}
class VariablePropertyAccessNode extends VariableAccessNode {
    //x.x
    VariableAccessNode parent;
    VariableAccessNode child;
    //symbol table stuff
    public String GetID(){
        return parent.GetID();
    }
    public String GetTypeModifier(){
        return parent.GetTypeModifier();
    }
}
class VariableAccessExprNode extends ExprNode{
    VariableAccessNode variableExpr;
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
    public DefinedCaseListNode(){
        cases = new ArrayList<>();
    }
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
    VariableAccessNode collectionID;
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
abstract class ExprNode extends StmtNode {
    //decoration
    TypeDecoration typeDecoration;
}

class ExprStmtNode extends ExprNode{
    ExprNode expr;
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
    List<ExprNode> elements;
    public ArrayLiteralNode(){
        elements = new ArrayList<>();
    }
}

class FunctionCallNode extends ExprNode {
    IdentifierNode id;
    ValueListNode parameters;
}
class MethodCallNode extends ExprNode {
    VariableAccessNode valueID;
    IdentifierNode methodID;
    ValueListNode parameters;
}
class PropertyCallNode extends ExprNode {
    VariableAccessNode valueID;
    IdentifierNode propertyID;
}

class ParenthesisedExprNode extends ExprNode {
    ExprNode innerExpr;
}

class UnaryMinusNode extends ExprNode{
    ExprNode expr;
}

class UnaryPlusNode extends ExprNode{
    ExprNode expr;
}

class UnaryNegationNode extends ExprNode{
    ExprNode expr;
}

class SubtractionNode extends ExprNode{
    ExprNode left;
    ExprNode right;
}

class AdditionNode extends ExprNode{
    ExprNode left;
    ExprNode right;
}

class MultiplicationNode extends ExprNode{
    ExprNode left;
    ExprNode right;
}

class DivisionNode extends ExprNode{
    ExprNode left;
    ExprNode right;
}

class ModuloNode extends ExprNode{
    ExprNode left;
    ExprNode right;
}

class PowerNode extends ExprNode{
    ExprNode left;
    ExprNode right;
}

class EqualsNode extends ExprNode{
    ExprNode left;
    ExprNode right;
}

class NotEqualsNode extends ExprNode{
    ExprNode left;
    ExprNode right;
}

class LesserThanNode extends ExprNode{
    ExprNode left;
    ExprNode right;
}

class GreaterThanNode extends ExprNode{
    ExprNode left;
    ExprNode right;
}

class LesserOrEqualsNode extends ExprNode{
    ExprNode left;
    ExprNode right;
}

class GreaterOrEqualsNode extends ExprNode{
    ExprNode left;
    ExprNode right;
}

class AndNode extends ExprNode{
    ExprNode left;
    ExprNode right;
}

class OrNode extends ExprNode{
    ExprNode left;
    ExprNode right;
}