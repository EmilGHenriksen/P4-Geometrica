class ProgramNode {
	public list<StmtNode> StmtNodes;
	public list<FunctionNode> FunctionNodes;
}

class FunctionNode {
	TypeNode type;
	IdentifierNode id;
	List<DeclareNode> parameters;
	list<StmtNode> StmtNodes;
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
	TypeModifier modifier;
	ExprNode value;
}
class AssignNode extends StmtNode {
	IdentifierNode id;
	ExprNode value;
}

//----selection----
class IfNode extends StmtNode {
	ExprNode value;
	List<StmtNode> IfStmtNodes;
	List<StmtNode> ElseStmtNodes;
}
class SwitchNode extends StmtNode {
	ExprNode value;
	List<DefinedCaseNode> cases;
	DefaultCaseNode default;
}
class DefinedCaseNode {
	ExprNode value;
	List<StmtNode> StmtNodes;
	bool Fallthrough;
}

//----iteration----
class ForNode extends StmtNode {
	TypeNode ControlType;
	AssignNode ControlAssign;
	ExprNode ConditionExpression;
	AssignNode UpdateAssign;
	list<StmtNode> StmtNodes;
}
class ForeachNode extends StmtNode {
	IdentifierNode ElementID;
	identifierNode CollectionID;
	list<StmtNode> StmtNodes;
}
class LoopNode extends StmtNode {
	ExprNode Loopcount;
	list<StmtNode> StmtNodes;
}
class WhileNode extends StmtNode {
	ExprNode ConditionExpression;
	list<StmtNode> StmtNodes;
}

//----calls----
class FunctionCallNode extends StmtNode {
	IdentifierNode id;
	list<ExprNode> parameters;
}
class MethodCallNode extends StmtNode {
	Identifier valueID;
	Identifier methodID;
	list<ExprNode> parameters;
}
class PropertyCallNode extends StmtNode {
	Identifier valueID;
	Identifier propertyID;
}


//----------------expressions-----------------
abstract class ExprNode {
}

class LiteralNode extends ExprNode {
	
}







expr -> literal
	  | identifier
	  | functionCall
	  | methodCall		//example: x.func()
	  | propertyCall    //example: x.name
	  | assign
	  | '(' expr ')'
	  | unaryExpr
	  | binaryExpr
unaryExpr -> unaryOp expr
binaryExpr -> expr binaryOp expr


//----literals----
literal -> intLiteral
		 | floatLiteral
		 | 'PI' //converts to float number for pi
		 | stringLiteral
		 | boolLiteral
		 | angleLiteral
		 | arrayLiteral
		 //the other types have no literals
arrayLiteral ->  '[' (literal (',' literal)*)? ']'