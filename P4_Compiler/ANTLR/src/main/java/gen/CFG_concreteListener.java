package gen; // Generated from C:/Users/Anders/Documents/GitHub/p4_compiler/P4_Compiler/ANTLR/src/main/antlr\CFG_concrete.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CFG_concreteParser}.
 */
public interface CFG_concreteListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CFG_concreteParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CFG_concreteParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#content}.
	 * @param ctx the parse tree
	 */
	void enterContent(CFG_concreteParser.ContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#content}.
	 * @param ctx the parse tree
	 */
	void exitContent(CFG_concreteParser.ContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(CFG_concreteParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(CFG_concreteParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(CFG_concreteParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(CFG_concreteParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#parameterDeclareList}.
	 * @param ctx the parse tree
	 */
	void enterParameterDeclareList(CFG_concreteParser.ParameterDeclareListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#parameterDeclareList}.
	 * @param ctx the parse tree
	 */
	void exitParameterDeclareList(CFG_concreteParser.ParameterDeclareListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#parameterDeclare}.
	 * @param ctx the parse tree
	 */
	void enterParameterDeclare(CFG_concreteParser.ParameterDeclareContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#parameterDeclare}.
	 * @param ctx the parse tree
	 */
	void exitParameterDeclare(CFG_concreteParser.ParameterDeclareContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#stmtList}.
	 * @param ctx the parse tree
	 */
	void enterStmtList(CFG_concreteParser.StmtListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#stmtList}.
	 * @param ctx the parse tree
	 */
	void exitStmtList(CFG_concreteParser.StmtListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#stmtListNoBraces}.
	 * @param ctx the parse tree
	 */
	void enterStmtListNoBraces(CFG_concreteParser.StmtListNoBracesContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#stmtListNoBraces}.
	 * @param ctx the parse tree
	 */
	void exitStmtListNoBraces(CFG_concreteParser.StmtListNoBracesContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#return_}.
	 * @param ctx the parse tree
	 */
	void enterReturn_(CFG_concreteParser.Return_Context ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#return_}.
	 * @param ctx the parse tree
	 */
	void exitReturn_(CFG_concreteParser.Return_Context ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#declare}.
	 * @param ctx the parse tree
	 */
	void enterDeclare(CFG_concreteParser.DeclareContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#declare}.
	 * @param ctx the parse tree
	 */
	void exitDeclare(CFG_concreteParser.DeclareContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(CFG_concreteParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(CFG_concreteParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#variableAccess}.
	 * @param ctx the parse tree
	 */
	void enterVariableAccess(CFG_concreteParser.VariableAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#variableAccess}.
	 * @param ctx the parse tree
	 */
	void exitVariableAccess(CFG_concreteParser.VariableAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#variablePropertyAccess}.
	 * @param ctx the parse tree
	 */
	void enterVariablePropertyAccess(CFG_concreteParser.VariablePropertyAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#variablePropertyAccess}.
	 * @param ctx the parse tree
	 */
	void exitVariablePropertyAccess(CFG_concreteParser.VariablePropertyAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#variableModifierAccess}.
	 * @param ctx the parse tree
	 */
	void enterVariableModifierAccess(CFG_concreteParser.VariableModifierAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#variableModifierAccess}.
	 * @param ctx the parse tree
	 */
	void exitVariableModifierAccess(CFG_concreteParser.VariableModifierAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#select}.
	 * @param ctx the parse tree
	 */
	void enterSelect(CFG_concreteParser.SelectContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#select}.
	 * @param ctx the parse tree
	 */
	void exitSelect(CFG_concreteParser.SelectContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#ifSelect}.
	 * @param ctx the parse tree
	 */
	void enterIfSelect(CFG_concreteParser.IfSelectContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#ifSelect}.
	 * @param ctx the parse tree
	 */
	void exitIfSelect(CFG_concreteParser.IfSelectContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#switchSelect}.
	 * @param ctx the parse tree
	 */
	void enterSwitchSelect(CFG_concreteParser.SwitchSelectContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#switchSelect}.
	 * @param ctx the parse tree
	 */
	void exitSwitchSelect(CFG_concreteParser.SwitchSelectContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#definedCaseList}.
	 * @param ctx the parse tree
	 */
	void enterDefinedCaseList(CFG_concreteParser.DefinedCaseListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#definedCaseList}.
	 * @param ctx the parse tree
	 */
	void exitDefinedCaseList(CFG_concreteParser.DefinedCaseListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#definedCase}.
	 * @param ctx the parse tree
	 */
	void enterDefinedCase(CFG_concreteParser.DefinedCaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#definedCase}.
	 * @param ctx the parse tree
	 */
	void exitDefinedCase(CFG_concreteParser.DefinedCaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#defaultCase}.
	 * @param ctx the parse tree
	 */
	void enterDefaultCase(CFG_concreteParser.DefaultCaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#defaultCase}.
	 * @param ctx the parse tree
	 */
	void exitDefaultCase(CFG_concreteParser.DefaultCaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#iterate}.
	 * @param ctx the parse tree
	 */
	void enterIterate(CFG_concreteParser.IterateContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#iterate}.
	 * @param ctx the parse tree
	 */
	void exitIterate(CFG_concreteParser.IterateContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#foreachIterate}.
	 * @param ctx the parse tree
	 */
	void enterForeachIterate(CFG_concreteParser.ForeachIterateContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#foreachIterate}.
	 * @param ctx the parse tree
	 */
	void exitForeachIterate(CFG_concreteParser.ForeachIterateContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#loopIterate}.
	 * @param ctx the parse tree
	 */
	void enterLoopIterate(CFG_concreteParser.LoopIterateContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#loopIterate}.
	 * @param ctx the parse tree
	 */
	void exitLoopIterate(CFG_concreteParser.LoopIterateContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#whileIterate}.
	 * @param ctx the parse tree
	 */
	void enterWhileIterate(CFG_concreteParser.WhileIterateContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#whileIterate}.
	 * @param ctx the parse tree
	 */
	void exitWhileIterate(CFG_concreteParser.WhileIterateContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(CFG_concreteParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(CFG_concreteParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#parameterValueList}.
	 * @param ctx the parse tree
	 */
	void enterParameterValueList(CFG_concreteParser.ParameterValueListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#parameterValueList}.
	 * @param ctx the parse tree
	 */
	void exitParameterValueList(CFG_concreteParser.ParameterValueListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(CFG_concreteParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(CFG_concreteParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#propertyCall}.
	 * @param ctx the parse tree
	 */
	void enterPropertyCall(CFG_concreteParser.PropertyCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#propertyCall}.
	 * @param ctx the parse tree
	 */
	void exitPropertyCall(CFG_concreteParser.PropertyCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#exprStmt}.
	 * @param ctx the parse tree
	 */
	void enterExprStmt(CFG_concreteParser.ExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#exprStmt}.
	 * @param ctx the parse tree
	 */
	void exitExprStmt(CFG_concreteParser.ExprStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(CFG_concreteParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(CFG_concreteParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(CFG_concreteParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(CFG_concreteParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(CFG_concreteParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(CFG_concreteParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpr(CFG_concreteParser.EqualityExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpr(CFG_concreteParser.EqualityExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#relationExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelationExpr(CFG_concreteParser.RelationExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#relationExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelationExpr(CFG_concreteParser.RelationExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpr(CFG_concreteParser.AdditiveExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpr(CFG_concreteParser.AdditiveExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpr(CFG_concreteParser.MultiplicativeExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpr(CFG_concreteParser.MultiplicativeExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#powerExpr}.
	 * @param ctx the parse tree
	 */
	void enterPowerExpr(CFG_concreteParser.PowerExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#powerExpr}.
	 * @param ctx the parse tree
	 */
	void exitPowerExpr(CFG_concreteParser.PowerExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(CFG_concreteParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(CFG_concreteParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#atomExpr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(CFG_concreteParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#atomExpr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(CFG_concreteParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#parenthesisedExpr}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisedExpr(CFG_concreteParser.ParenthesisedExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#parenthesisedExpr}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisedExpr(CFG_concreteParser.ParenthesisedExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(CFG_concreteParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(CFG_concreteParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteral(CFG_concreteParser.ArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteral(CFG_concreteParser.ArrayLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#piLiteral}.
	 * @param ctx the parse tree
	 */
	void enterPiLiteral(CFG_concreteParser.PiLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#piLiteral}.
	 * @param ctx the parse tree
	 */
	void exitPiLiteral(CFG_concreteParser.PiLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#intLiteral}.
	 * @param ctx the parse tree
	 */
	void enterIntLiteral(CFG_concreteParser.IntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#intLiteral}.
	 * @param ctx the parse tree
	 */
	void exitIntLiteral(CFG_concreteParser.IntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#floatLiteral}.
	 * @param ctx the parse tree
	 */
	void enterFloatLiteral(CFG_concreteParser.FloatLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#floatLiteral}.
	 * @param ctx the parse tree
	 */
	void exitFloatLiteral(CFG_concreteParser.FloatLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(CFG_concreteParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(CFG_concreteParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#boolLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBoolLiteral(CFG_concreteParser.BoolLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#boolLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBoolLiteral(CFG_concreteParser.BoolLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#angleLiteral}.
	 * @param ctx the parse tree
	 */
	void enterAngleLiteral(CFG_concreteParser.AngleLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#angleLiteral}.
	 * @param ctx the parse tree
	 */
	void exitAngleLiteral(CFG_concreteParser.AngleLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFG_concreteParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(CFG_concreteParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFG_concreteParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(CFG_concreteParser.IdentifierContext ctx);
}