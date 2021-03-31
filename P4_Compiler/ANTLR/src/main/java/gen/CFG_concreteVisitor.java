package gen; // Generated from C:/Users/Anders/Documents/GitHub/p4_compiler/P4_Compiler/ANTLR/src/main/antlr\CFG_concrete.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CFG_concreteParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CFG_concreteVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(CFG_concreteParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContent(CFG_concreteParser.ContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(CFG_concreteParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(CFG_concreteParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#parameterDeclareList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterDeclareList(CFG_concreteParser.ParameterDeclareListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#stmtList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtList(CFG_concreteParser.StmtListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#return_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_(CFG_concreteParser.Return_Context ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclare(CFG_concreteParser.DeclareContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(CFG_concreteParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#typeModAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeModAccess(CFG_concreteParser.TypeModAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#select}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect(CFG_concreteParser.SelectContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#ifSelect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfSelect(CFG_concreteParser.IfSelectContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#switchSelect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchSelect(CFG_concreteParser.SwitchSelectContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#definedCaseList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinedCaseList(CFG_concreteParser.DefinedCaseListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#definedCase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinedCase(CFG_concreteParser.DefinedCaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#defaultCase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultCase(CFG_concreteParser.DefaultCaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#iterate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterate(CFG_concreteParser.IterateContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#foreachIterate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForeachIterate(CFG_concreteParser.ForeachIterateContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#loopIterate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopIterate(CFG_concreteParser.LoopIterateContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#whileIterate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileIterate(CFG_concreteParser.WhileIterateContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(CFG_concreteParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#parameterValueList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterValueList(CFG_concreteParser.ParameterValueListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(CFG_concreteParser.MethodCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#propertyCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyCall(CFG_concreteParser.PropertyCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(CFG_concreteParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#orExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(CFG_concreteParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(CFG_concreteParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#equalityExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpr(CFG_concreteParser.EqualityExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#relationExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationExpr(CFG_concreteParser.RelationExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#additiveExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpr(CFG_concreteParser.AdditiveExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpr(CFG_concreteParser.MultiplicativeExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#powerExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowerExpr(CFG_concreteParser.PowerExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(CFG_concreteParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#atomExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(CFG_concreteParser.AtomExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#parenthesisedExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesisedExpr(CFG_concreteParser.ParenthesisedExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#variableExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableExpr(CFG_concreteParser.VariableExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(CFG_concreteParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#arrayLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteral(CFG_concreteParser.ArrayLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#piLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPiLiteral(CFG_concreteParser.PiLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#intLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLiteral(CFG_concreteParser.IntLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#floatLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatLiteral(CFG_concreteParser.FloatLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#stringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(CFG_concreteParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#boolLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLiteral(CFG_concreteParser.BoolLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#angleLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAngleLiteral(CFG_concreteParser.AngleLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFG_concreteParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(CFG_concreteParser.IdentifierContext ctx);
}