package gen; // Generated from C:/Users/Anders/Documents/GitHub/p4_compiler/P4_Compiler/ANTLR/src/main/antlr\CFG_concrete.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CFG_concreteParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		IntLiteral=39, FloatLiteral=40, StringLiteral=41, BoolLiteral=42, AngleLiteral=43, 
		AccessModifier=44, Type=45, TypeModifier=46, IdToken=47, EOLcomment=48, 
		BlockComment=49, WS=50;
	public static final int
		RULE_program = 0, RULE_content = 1, RULE_stmt = 2, RULE_function = 3, 
		RULE_parameterDeclareList = 4, RULE_parameterDeclare = 5, RULE_stmtList = 6, 
		RULE_stmtListNoBraces = 7, RULE_return_ = 8, RULE_declare = 9, RULE_assign = 10, 
		RULE_variableAccess = 11, RULE_variablePropertyAccess = 12, RULE_variableModifierAccess = 13, 
		RULE_select = 14, RULE_ifSelect = 15, RULE_switchSelect = 16, RULE_definedCaseList = 17, 
		RULE_definedCase = 18, RULE_defaultCase = 19, RULE_iterate = 20, RULE_foreachIterate = 21, 
		RULE_loopIterate = 22, RULE_whileIterate = 23, RULE_functionCall = 24, 
		RULE_parameterValueList = 25, RULE_methodCall = 26, RULE_exprStmt = 27, 
		RULE_expr = 28, RULE_orExpr = 29, RULE_andExpr = 30, RULE_equalityExpr = 31, 
		RULE_relationExpr = 32, RULE_additiveExpr = 33, RULE_multiplicativeExpr = 34, 
		RULE_powerExpr = 35, RULE_unaryExpr = 36, RULE_atomExpr = 37, RULE_parenthesisedExpr = 38, 
		RULE_variableAccessExpr = 39, RULE_literal = 40, RULE_arrayLiteral = 41, 
		RULE_piLiteral = 42, RULE_intLiteral = 43, RULE_floatLiteral = 44, RULE_stringLiteral = 45, 
		RULE_boolLiteral = 46, RULE_angleLiteral = 47, RULE_identifier = 48;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "content", "stmt", "function", "parameterDeclareList", "parameterDeclare", 
			"stmtList", "stmtListNoBraces", "return_", "declare", "assign", "variableAccess", 
			"variablePropertyAccess", "variableModifierAccess", "select", "ifSelect", 
			"switchSelect", "definedCaseList", "definedCase", "defaultCase", "iterate", 
			"foreachIterate", "loopIterate", "whileIterate", "functionCall", "parameterValueList", 
			"methodCall", "exprStmt", "expr", "orExpr", "andExpr", "equalityExpr", 
			"relationExpr", "additiveExpr", "multiplicativeExpr", "powerExpr", "unaryExpr", 
			"atomExpr", "parenthesisedExpr", "variableAccessExpr", "literal", "arrayLiteral", 
			"piLiteral", "intLiteral", "floatLiteral", "stringLiteral", "boolLiteral", 
			"angleLiteral", "identifier"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'void'", "'('", "')'", "','", "'{'", "'}'", "'return'", "';'", 
			"'IS'", "'.'", "'['", "']'", "'if'", "'else'", "'switch'", "'case'", 
			"':'", "'default'", "'foreach'", "'in'", "'loop'", "'while'", "'OR'", 
			"'AND'", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'-'", "'+'", 
			"'*'", "'/'", "'%'", "'^'", "'!'", "'PI'", null, null, null, null, null, 
			"'const'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "IntLiteral", "FloatLiteral", "StringLiteral", "BoolLiteral", 
			"AngleLiteral", "AccessModifier", "Type", "TypeModifier", "IdToken", 
			"EOLcomment", "BlockComment", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "CFG_concrete.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CFG_concreteParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public ContentContext content() {
			return getRuleContext(ContentContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CFG_concreteParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			content();
			setState(99);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContentContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public ContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_content; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContentContext content() throws RecognitionException {
		ContentContext _localctx = new ContentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_content);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(103);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(101);
					stmt();
					}
					break;
				case 2:
					{
					setState(102);
					function();
					}
					break;
				}
				}
				setState(105); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__4) | (1L << T__6) | (1L << T__10) | (1L << T__12) | (1L << T__14) | (1L << T__18) | (1L << T__20) | (1L << T__21) | (1L << T__30) | (1L << T__31) | (1L << T__36) | (1L << T__37) | (1L << IntLiteral) | (1L << FloatLiteral) | (1L << StringLiteral) | (1L << BoolLiteral) | (1L << AngleLiteral) | (1L << AccessModifier) | (1L << Type) | (1L << IdToken))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public Return_Context return_() {
			return getRuleContext(Return_Context.class,0);
		}
		public DeclareContext declare() {
			return getRuleContext(DeclareContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public SelectContext select() {
			return getRuleContext(SelectContext.class,0);
		}
		public IterateContext iterate() {
			return getRuleContext(IterateContext.class,0);
		}
		public StmtListContext stmtList() {
			return getRuleContext(StmtListContext.class,0);
		}
		public ExprStmtContext exprStmt() {
			return getRuleContext(ExprStmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stmt);
		try {
			setState(114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				return_();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				declare();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(109);
				assign();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(110);
				select();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(111);
				iterate();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(112);
				stmtList();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(113);
				exprStmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ParameterDeclareListContext parameterDeclareList() {
			return getRuleContext(ParameterDeclareListContext.class,0);
		}
		public StmtListContext stmtList() {
			return getRuleContext(StmtListContext.class,0);
		}
		public TerminalNode Type() { return getToken(CFG_concreteParser.Type, 0); }
		public TerminalNode TypeModifier() { return getToken(CFG_concreteParser.TypeModifier, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Type:
				{
				setState(116);
				match(Type);
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TypeModifier) {
					{
					setState(117);
					match(TypeModifier);
					}
				}

				}
				break;
			case T__0:
				{
				setState(120);
				match(T__0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(123);
			identifier();
			setState(124);
			match(T__1);
			setState(125);
			parameterDeclareList();
			setState(126);
			match(T__2);
			setState(127);
			stmtList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterDeclareListContext extends ParserRuleContext {
		public List<ParameterDeclareContext> parameterDeclare() {
			return getRuleContexts(ParameterDeclareContext.class);
		}
		public ParameterDeclareContext parameterDeclare(int i) {
			return getRuleContext(ParameterDeclareContext.class,i);
		}
		public ParameterDeclareListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDeclareList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterParameterDeclareList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitParameterDeclareList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitParameterDeclareList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterDeclareListContext parameterDeclareList() throws RecognitionException {
		ParameterDeclareListContext _localctx = new ParameterDeclareListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parameterDeclareList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Type) {
				{
				setState(129);
				parameterDeclare();
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(130);
					match(T__3);
					setState(131);
					parameterDeclare();
					}
					}
					setState(136);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterDeclareContext extends ParserRuleContext {
		public TerminalNode Type() { return getToken(CFG_concreteParser.Type, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode TypeModifier() { return getToken(CFG_concreteParser.TypeModifier, 0); }
		public ParameterDeclareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDeclare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterParameterDeclare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitParameterDeclare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitParameterDeclare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterDeclareContext parameterDeclare() throws RecognitionException {
		ParameterDeclareContext _localctx = new ParameterDeclareContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_parameterDeclare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(Type);
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TypeModifier) {
				{
				setState(140);
				match(TypeModifier);
				}
			}

			setState(143);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtListContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public StmtListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterStmtList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitStmtList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitStmtList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtListContext stmtList() throws RecognitionException {
		StmtListContext _localctx = new StmtListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_stmtList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(T__4);
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__6) | (1L << T__10) | (1L << T__12) | (1L << T__14) | (1L << T__18) | (1L << T__20) | (1L << T__21) | (1L << T__30) | (1L << T__31) | (1L << T__36) | (1L << T__37) | (1L << IntLiteral) | (1L << FloatLiteral) | (1L << StringLiteral) | (1L << BoolLiteral) | (1L << AngleLiteral) | (1L << AccessModifier) | (1L << Type) | (1L << IdToken))) != 0)) {
				{
				{
				setState(146);
				stmt();
				}
				}
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(152);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtListNoBracesContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public StmtListNoBracesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtListNoBraces; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterStmtListNoBraces(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitStmtListNoBraces(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitStmtListNoBraces(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtListNoBracesContext stmtListNoBraces() throws RecognitionException {
		StmtListNoBracesContext _localctx = new StmtListNoBracesContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stmtListNoBraces);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__6) | (1L << T__10) | (1L << T__12) | (1L << T__14) | (1L << T__18) | (1L << T__20) | (1L << T__21) | (1L << T__30) | (1L << T__31) | (1L << T__36) | (1L << T__37) | (1L << IntLiteral) | (1L << FloatLiteral) | (1L << StringLiteral) | (1L << BoolLiteral) | (1L << AngleLiteral) | (1L << AccessModifier) | (1L << Type) | (1L << IdToken))) != 0)) {
				{
				{
				setState(154);
				stmt();
				}
				}
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Return_Context extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Return_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterReturn_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitReturn_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitReturn_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_Context return_() throws RecognitionException {
		Return_Context _localctx = new Return_Context(_ctx, getState());
		enterRule(_localctx, 16, RULE_return_);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(T__6);
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__30) | (1L << T__31) | (1L << T__36) | (1L << T__37) | (1L << IntLiteral) | (1L << FloatLiteral) | (1L << StringLiteral) | (1L << BoolLiteral) | (1L << AngleLiteral) | (1L << IdToken))) != 0)) {
				{
				setState(161);
				expr();
				}
			}

			setState(164);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclareContext extends ParserRuleContext {
		public TerminalNode Type() { return getToken(CFG_concreteParser.Type, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode AccessModifier() { return getToken(CFG_concreteParser.AccessModifier, 0); }
		public TerminalNode TypeModifier() { return getToken(CFG_concreteParser.TypeModifier, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterDeclare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitDeclare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitDeclare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclareContext declare() throws RecognitionException {
		DeclareContext _localctx = new DeclareContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_declare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AccessModifier) {
				{
				setState(166);
				match(AccessModifier);
				}
			}

			setState(169);
			match(Type);
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TypeModifier) {
				{
				setState(170);
				match(TypeModifier);
				}
			}

			setState(173);
			identifier();
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(174);
				match(T__8);
				setState(175);
				expr();
				}
			}

			setState(178);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignContext extends ParserRuleContext {
		public VariableAccessContext variableAccess() {
			return getRuleContext(VariableAccessContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			variableAccess();
			setState(181);
			match(T__8);
			setState(182);
			expr();
			setState(183);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableAccessContext extends ParserRuleContext {
		public VariablePropertyAccessContext variablePropertyAccess() {
			return getRuleContext(VariablePropertyAccessContext.class,0);
		}
		public VariableAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterVariableAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitVariableAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitVariableAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableAccessContext variableAccess() throws RecognitionException {
		VariableAccessContext _localctx = new VariableAccessContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_variableAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			variablePropertyAccess(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariablePropertyAccessContext extends ParserRuleContext {
		public VariableModifierAccessContext variableModifierAccess() {
			return getRuleContext(VariableModifierAccessContext.class,0);
		}
		public VariablePropertyAccessContext variablePropertyAccess() {
			return getRuleContext(VariablePropertyAccessContext.class,0);
		}
		public VariablePropertyAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variablePropertyAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterVariablePropertyAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitVariablePropertyAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitVariablePropertyAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariablePropertyAccessContext variablePropertyAccess() throws RecognitionException {
		return variablePropertyAccess(0);
	}

	private VariablePropertyAccessContext variablePropertyAccess(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		VariablePropertyAccessContext _localctx = new VariablePropertyAccessContext(_ctx, _parentState);
		VariablePropertyAccessContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_variablePropertyAccess, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(188);
			variableModifierAccess(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(195);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new VariablePropertyAccessContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_variablePropertyAccess);
					setState(190);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(191);
					match(T__9);
					setState(192);
					variableModifierAccess(0);
					}
					} 
				}
				setState(197);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class VariableModifierAccessContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public VariableModifierAccessContext variableModifierAccess() {
			return getRuleContext(VariableModifierAccessContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VariableModifierAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableModifierAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterVariableModifierAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitVariableModifierAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitVariableModifierAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableModifierAccessContext variableModifierAccess() throws RecognitionException {
		return variableModifierAccess(0);
	}

	private VariableModifierAccessContext variableModifierAccess(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		VariableModifierAccessContext _localctx = new VariableModifierAccessContext(_ctx, _parentState);
		VariableModifierAccessContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_variableModifierAccess, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(199);
			identifier();
			}
			_ctx.stop = _input.LT(-1);
			setState(208);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new VariableModifierAccessContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_variableModifierAccess);
					setState(201);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(202);
					match(T__10);
					setState(203);
					expr();
					setState(204);
					match(T__11);
					}
					} 
				}
				setState(210);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class SelectContext extends ParserRuleContext {
		public IfSelectContext ifSelect() {
			return getRuleContext(IfSelectContext.class,0);
		}
		public SwitchSelectContext switchSelect() {
			return getRuleContext(SwitchSelectContext.class,0);
		}
		public SelectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterSelect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitSelect(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitSelect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectContext select() throws RecognitionException {
		SelectContext _localctx = new SelectContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_select);
		try {
			setState(213);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(211);
				ifSelect();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 2);
				{
				setState(212);
				switchSelect();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfSelectContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtListContext stmtList() {
			return getRuleContext(StmtListContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public IfSelectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifSelect; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterIfSelect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitIfSelect(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitIfSelect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfSelectContext ifSelect() throws RecognitionException {
		IfSelectContext _localctx = new IfSelectContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ifSelect);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(T__12);
			setState(216);
			match(T__1);
			setState(217);
			expr();
			setState(218);
			match(T__2);
			setState(219);
			stmtList();
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(220);
				match(T__13);
				setState(221);
				stmt();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchSelectContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DefinedCaseListContext definedCaseList() {
			return getRuleContext(DefinedCaseListContext.class,0);
		}
		public DefaultCaseContext defaultCase() {
			return getRuleContext(DefaultCaseContext.class,0);
		}
		public SwitchSelectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchSelect; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterSwitchSelect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitSwitchSelect(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitSwitchSelect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchSelectContext switchSelect() throws RecognitionException {
		SwitchSelectContext _localctx = new SwitchSelectContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_switchSelect);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(T__14);
			setState(225);
			match(T__1);
			setState(226);
			expr();
			setState(227);
			match(T__2);
			setState(228);
			match(T__4);
			setState(229);
			definedCaseList();
			setState(230);
			defaultCase();
			setState(231);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinedCaseListContext extends ParserRuleContext {
		public List<DefinedCaseContext> definedCase() {
			return getRuleContexts(DefinedCaseContext.class);
		}
		public DefinedCaseContext definedCase(int i) {
			return getRuleContext(DefinedCaseContext.class,i);
		}
		public DefinedCaseListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definedCaseList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterDefinedCaseList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitDefinedCaseList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitDefinedCaseList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinedCaseListContext definedCaseList() throws RecognitionException {
		DefinedCaseListContext _localctx = new DefinedCaseListContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_definedCaseList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15) {
				{
				{
				setState(233);
				definedCase();
				}
				}
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinedCaseContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtListNoBracesContext stmtListNoBraces() {
			return getRuleContext(StmtListNoBracesContext.class,0);
		}
		public DefinedCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definedCase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterDefinedCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitDefinedCase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitDefinedCase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinedCaseContext definedCase() throws RecognitionException {
		DefinedCaseContext _localctx = new DefinedCaseContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_definedCase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(T__15);
			setState(240);
			expr();
			setState(241);
			match(T__16);
			setState(242);
			stmtListNoBraces();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefaultCaseContext extends ParserRuleContext {
		public StmtListNoBracesContext stmtListNoBraces() {
			return getRuleContext(StmtListNoBracesContext.class,0);
		}
		public DefaultCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultCase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterDefaultCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitDefaultCase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitDefaultCase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultCaseContext defaultCase() throws RecognitionException {
		DefaultCaseContext _localctx = new DefaultCaseContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_defaultCase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(T__17);
			setState(245);
			match(T__16);
			setState(246);
			stmtListNoBraces();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IterateContext extends ParserRuleContext {
		public ForeachIterateContext foreachIterate() {
			return getRuleContext(ForeachIterateContext.class,0);
		}
		public LoopIterateContext loopIterate() {
			return getRuleContext(LoopIterateContext.class,0);
		}
		public WhileIterateContext whileIterate() {
			return getRuleContext(WhileIterateContext.class,0);
		}
		public IterateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterIterate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitIterate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitIterate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterateContext iterate() throws RecognitionException {
		IterateContext _localctx = new IterateContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_iterate);
		try {
			setState(251);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				setState(248);
				foreachIterate();
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 2);
				{
				setState(249);
				loopIterate();
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 3);
				{
				setState(250);
				whileIterate();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForeachIterateContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public StmtListContext stmtList() {
			return getRuleContext(StmtListContext.class,0);
		}
		public ForeachIterateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreachIterate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterForeachIterate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitForeachIterate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitForeachIterate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForeachIterateContext foreachIterate() throws RecognitionException {
		ForeachIterateContext _localctx = new ForeachIterateContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_foreachIterate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			match(T__18);
			setState(254);
			match(T__1);
			setState(255);
			identifier();
			setState(256);
			match(T__19);
			setState(257);
			identifier();
			setState(258);
			match(T__2);
			setState(259);
			stmtList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoopIterateContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtListContext stmtList() {
			return getRuleContext(StmtListContext.class,0);
		}
		public LoopIterateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopIterate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterLoopIterate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitLoopIterate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitLoopIterate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopIterateContext loopIterate() throws RecognitionException {
		LoopIterateContext _localctx = new LoopIterateContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_loopIterate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(T__20);
			setState(262);
			match(T__1);
			setState(263);
			expr();
			setState(264);
			match(T__2);
			setState(265);
			stmtList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileIterateContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtListContext stmtList() {
			return getRuleContext(StmtListContext.class,0);
		}
		public WhileIterateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileIterate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterWhileIterate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitWhileIterate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitWhileIterate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileIterateContext whileIterate() throws RecognitionException {
		WhileIterateContext _localctx = new WhileIterateContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_whileIterate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			match(T__21);
			setState(268);
			match(T__1);
			setState(269);
			expr();
			setState(270);
			match(T__2);
			setState(271);
			stmtList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ParameterValueListContext parameterValueList() {
			return getRuleContext(ParameterValueListContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_functionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			identifier();
			setState(274);
			match(T__1);
			setState(275);
			parameterValueList();
			setState(276);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterValueListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ParameterValueListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterValueList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterParameterValueList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitParameterValueList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitParameterValueList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterValueListContext parameterValueList() throws RecognitionException {
		ParameterValueListContext _localctx = new ParameterValueListContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_parameterValueList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__30) | (1L << T__31) | (1L << T__36) | (1L << T__37) | (1L << IntLiteral) | (1L << FloatLiteral) | (1L << StringLiteral) | (1L << BoolLiteral) | (1L << AngleLiteral) | (1L << IdToken))) != 0)) {
				{
				setState(278);
				expr();
				setState(283);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(279);
					match(T__3);
					setState(280);
					expr();
					}
					}
					setState(285);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodCallContext extends ParserRuleContext {
		public VariableAccessContext variableAccess() {
			return getRuleContext(VariableAccessContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ParameterValueListContext parameterValueList() {
			return getRuleContext(ParameterValueListContext.class,0);
		}
		public MethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitMethodCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitMethodCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodCallContext methodCall() throws RecognitionException {
		MethodCallContext _localctx = new MethodCallContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_methodCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			variableAccess();
			setState(289);
			match(T__9);
			setState(290);
			identifier();
			setState(291);
			match(T__1);
			setState(292);
			parameterValueList();
			setState(293);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterExprStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitExprStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitExprStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprStmtContext exprStmt() throws RecognitionException {
		ExprStmtContext _localctx = new ExprStmtContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_exprStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			expr();
			setState(296);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			orExpr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrExprContext extends ParserRuleContext {
		public AndExprContext andExpr() {
			return getRuleContext(AndExprContext.class,0);
		}
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public OrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitOrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrExprContext orExpr() throws RecognitionException {
		return orExpr(0);
	}

	private OrExprContext orExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		OrExprContext _localctx = new OrExprContext(_ctx, _parentState);
		OrExprContext _prevctx = _localctx;
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_orExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(301);
			andExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(308);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new OrExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_orExpr);
					setState(303);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					{
					setState(304);
					match(T__22);
					}
					setState(305);
					andExpr(0);
					}
					} 
				}
				setState(310);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AndExprContext extends ParserRuleContext {
		public EqualityExprContext equalityExpr() {
			return getRuleContext(EqualityExprContext.class,0);
		}
		public AndExprContext andExpr() {
			return getRuleContext(AndExprContext.class,0);
		}
		public AndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitAndExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExprContext andExpr() throws RecognitionException {
		return andExpr(0);
	}

	private AndExprContext andExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AndExprContext _localctx = new AndExprContext(_ctx, _parentState);
		AndExprContext _prevctx = _localctx;
		int _startState = 60;
		enterRecursionRule(_localctx, 60, RULE_andExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(312);
			equalityExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(319);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AndExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_andExpr);
					setState(314);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					{
					setState(315);
					match(T__23);
					}
					setState(316);
					equalityExpr(0);
					}
					} 
				}
				setState(321);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EqualityExprContext extends ParserRuleContext {
		public RelationExprContext relationExpr() {
			return getRuleContext(RelationExprContext.class,0);
		}
		public EqualityExprContext equalityExpr() {
			return getRuleContext(EqualityExprContext.class,0);
		}
		public EqualityExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterEqualityExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitEqualityExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitEqualityExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityExprContext equalityExpr() throws RecognitionException {
		return equalityExpr(0);
	}

	private EqualityExprContext equalityExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EqualityExprContext _localctx = new EqualityExprContext(_ctx, _parentState);
		EqualityExprContext _prevctx = _localctx;
		int _startState = 62;
		enterRecursionRule(_localctx, 62, RULE_equalityExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(323);
			relationExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(330);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new EqualityExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_equalityExpr);
					setState(325);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(326);
					_la = _input.LA(1);
					if ( !(_la==T__24 || _la==T__25) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(327);
					relationExpr(0);
					}
					} 
				}
				setState(332);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class RelationExprContext extends ParserRuleContext {
		public AdditiveExprContext additiveExpr() {
			return getRuleContext(AdditiveExprContext.class,0);
		}
		public RelationExprContext relationExpr() {
			return getRuleContext(RelationExprContext.class,0);
		}
		public RelationExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterRelationExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitRelationExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitRelationExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationExprContext relationExpr() throws RecognitionException {
		return relationExpr(0);
	}

	private RelationExprContext relationExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelationExprContext _localctx = new RelationExprContext(_ctx, _parentState);
		RelationExprContext _prevctx = _localctx;
		int _startState = 64;
		enterRecursionRule(_localctx, 64, RULE_relationExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(334);
			additiveExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(341);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RelationExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_relationExpr);
					setState(336);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(337);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(338);
					additiveExpr(0);
					}
					} 
				}
				setState(343);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AdditiveExprContext extends ParserRuleContext {
		public MultiplicativeExprContext multiplicativeExpr() {
			return getRuleContext(MultiplicativeExprContext.class,0);
		}
		public AdditiveExprContext additiveExpr() {
			return getRuleContext(AdditiveExprContext.class,0);
		}
		public AdditiveExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterAdditiveExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitAdditiveExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitAdditiveExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveExprContext additiveExpr() throws RecognitionException {
		return additiveExpr(0);
	}

	private AdditiveExprContext additiveExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AdditiveExprContext _localctx = new AdditiveExprContext(_ctx, _parentState);
		AdditiveExprContext _prevctx = _localctx;
		int _startState = 66;
		enterRecursionRule(_localctx, 66, RULE_additiveExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(345);
			multiplicativeExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(352);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AdditiveExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_additiveExpr);
					setState(347);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(348);
					_la = _input.LA(1);
					if ( !(_la==T__30 || _la==T__31) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(349);
					multiplicativeExpr(0);
					}
					} 
				}
				setState(354);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MultiplicativeExprContext extends ParserRuleContext {
		public PowerExprContext powerExpr() {
			return getRuleContext(PowerExprContext.class,0);
		}
		public MultiplicativeExprContext multiplicativeExpr() {
			return getRuleContext(MultiplicativeExprContext.class,0);
		}
		public MultiplicativeExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterMultiplicativeExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitMultiplicativeExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitMultiplicativeExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeExprContext multiplicativeExpr() throws RecognitionException {
		return multiplicativeExpr(0);
	}

	private MultiplicativeExprContext multiplicativeExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultiplicativeExprContext _localctx = new MultiplicativeExprContext(_ctx, _parentState);
		MultiplicativeExprContext _prevctx = _localctx;
		int _startState = 68;
		enterRecursionRule(_localctx, 68, RULE_multiplicativeExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(356);
			powerExpr();
			}
			_ctx.stop = _input.LT(-1);
			setState(363);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MultiplicativeExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpr);
					setState(358);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(359);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__32) | (1L << T__33) | (1L << T__34))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(360);
					powerExpr();
					}
					} 
				}
				setState(365);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PowerExprContext extends ParserRuleContext {
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public PowerExprContext powerExpr() {
			return getRuleContext(PowerExprContext.class,0);
		}
		public PowerExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_powerExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterPowerExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitPowerExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitPowerExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PowerExprContext powerExpr() throws RecognitionException {
		PowerExprContext _localctx = new PowerExprContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_powerExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			unaryExpr();
			setState(369);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(367);
				match(T__35);
				setState(368);
				powerExpr();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryExprContext extends ParserRuleContext {
		public AtomExprContext atomExpr() {
			return getRuleContext(AtomExprContext.class,0);
		}
		public UnaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitUnaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitUnaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExprContext unaryExpr() throws RecognitionException {
		UnaryExprContext _localctx = new UnaryExprContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_unaryExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << T__31) | (1L << T__36))) != 0)) {
				{
				setState(371);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << T__31) | (1L << T__36))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(374);
			atomExpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomExprContext extends ParserRuleContext {
		public ParenthesisedExprContext parenthesisedExpr() {
			return getRuleContext(ParenthesisedExprContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public VariableAccessExprContext variableAccessExpr() {
			return getRuleContext(VariableAccessExprContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public AtomExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterAtomExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitAtomExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitAtomExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomExprContext atomExpr() throws RecognitionException {
		AtomExprContext _localctx = new AtomExprContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_atomExpr);
		try {
			setState(381);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(376);
				parenthesisedExpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(377);
				literal();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(378);
				variableAccessExpr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(379);
				functionCall();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(380);
				methodCall();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParenthesisedExprContext extends ParserRuleContext {
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public ParenthesisedExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenthesisedExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterParenthesisedExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitParenthesisedExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitParenthesisedExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParenthesisedExprContext parenthesisedExpr() throws RecognitionException {
		ParenthesisedExprContext _localctx = new ParenthesisedExprContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_parenthesisedExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			match(T__1);
			setState(384);
			orExpr(0);
			setState(385);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableAccessExprContext extends ParserRuleContext {
		public VariableAccessContext variableAccess() {
			return getRuleContext(VariableAccessContext.class,0);
		}
		public VariableAccessExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableAccessExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterVariableAccessExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitVariableAccessExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitVariableAccessExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableAccessExprContext variableAccessExpr() throws RecognitionException {
		VariableAccessExprContext _localctx = new VariableAccessExprContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_variableAccessExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
			variableAccess();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public IntLiteralContext intLiteral() {
			return getRuleContext(IntLiteralContext.class,0);
		}
		public FloatLiteralContext floatLiteral() {
			return getRuleContext(FloatLiteralContext.class,0);
		}
		public PiLiteralContext piLiteral() {
			return getRuleContext(PiLiteralContext.class,0);
		}
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public BoolLiteralContext boolLiteral() {
			return getRuleContext(BoolLiteralContext.class,0);
		}
		public AngleLiteralContext angleLiteral() {
			return getRuleContext(AngleLiteralContext.class,0);
		}
		public ArrayLiteralContext arrayLiteral() {
			return getRuleContext(ArrayLiteralContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_literal);
		try {
			setState(396);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(389);
				intLiteral();
				}
				break;
			case FloatLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(390);
				floatLiteral();
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 3);
				{
				setState(391);
				piLiteral();
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(392);
				stringLiteral();
				}
				break;
			case BoolLiteral:
				enterOuterAlt(_localctx, 5);
				{
				setState(393);
				boolLiteral();
				}
				break;
			case AngleLiteral:
				enterOuterAlt(_localctx, 6);
				{
				setState(394);
				angleLiteral();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 7);
				{
				setState(395);
				arrayLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayLiteralContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArrayLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterArrayLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitArrayLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitArrayLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayLiteralContext arrayLiteral() throws RecognitionException {
		ArrayLiteralContext _localctx = new ArrayLiteralContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_arrayLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(398);
			match(T__10);
			setState(407);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__30) | (1L << T__31) | (1L << T__36) | (1L << T__37) | (1L << IntLiteral) | (1L << FloatLiteral) | (1L << StringLiteral) | (1L << BoolLiteral) | (1L << AngleLiteral) | (1L << IdToken))) != 0)) {
				{
				setState(399);
				expr();
				setState(404);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(400);
					match(T__3);
					setState(401);
					expr();
					}
					}
					setState(406);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(409);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PiLiteralContext extends ParserRuleContext {
		public PiLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_piLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterPiLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitPiLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitPiLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PiLiteralContext piLiteral() throws RecognitionException {
		PiLiteralContext _localctx = new PiLiteralContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_piLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
			match(T__37);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntLiteralContext extends ParserRuleContext {
		public TerminalNode IntLiteral() { return getToken(CFG_concreteParser.IntLiteral, 0); }
		public IntLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterIntLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitIntLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitIntLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntLiteralContext intLiteral() throws RecognitionException {
		IntLiteralContext _localctx = new IntLiteralContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_intLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(413);
			match(IntLiteral);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FloatLiteralContext extends ParserRuleContext {
		public TerminalNode FloatLiteral() { return getToken(CFG_concreteParser.FloatLiteral, 0); }
		public FloatLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterFloatLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitFloatLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitFloatLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FloatLiteralContext floatLiteral() throws RecognitionException {
		FloatLiteralContext _localctx = new FloatLiteralContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_floatLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			match(FloatLiteral);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringLiteralContext extends ParserRuleContext {
		public TerminalNode StringLiteral() { return getToken(CFG_concreteParser.StringLiteral, 0); }
		public StringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringLiteralContext stringLiteral() throws RecognitionException {
		StringLiteralContext _localctx = new StringLiteralContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_stringLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			match(StringLiteral);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolLiteralContext extends ParserRuleContext {
		public TerminalNode BoolLiteral() { return getToken(CFG_concreteParser.BoolLiteral, 0); }
		public BoolLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterBoolLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitBoolLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitBoolLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolLiteralContext boolLiteral() throws RecognitionException {
		BoolLiteralContext _localctx = new BoolLiteralContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_boolLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
			match(BoolLiteral);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AngleLiteralContext extends ParserRuleContext {
		public TerminalNode AngleLiteral() { return getToken(CFG_concreteParser.AngleLiteral, 0); }
		public AngleLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_angleLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterAngleLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitAngleLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitAngleLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AngleLiteralContext angleLiteral() throws RecognitionException {
		AngleLiteralContext _localctx = new AngleLiteralContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_angleLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
			match(AngleLiteral);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IdToken() { return getToken(CFG_concreteParser.IdToken, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFG_concreteListener ) ((CFG_concreteListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFG_concreteVisitor ) return ((CFG_concreteVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
			match(IdToken);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12:
			return variablePropertyAccess_sempred((VariablePropertyAccessContext)_localctx, predIndex);
		case 13:
			return variableModifierAccess_sempred((VariableModifierAccessContext)_localctx, predIndex);
		case 29:
			return orExpr_sempred((OrExprContext)_localctx, predIndex);
		case 30:
			return andExpr_sempred((AndExprContext)_localctx, predIndex);
		case 31:
			return equalityExpr_sempred((EqualityExprContext)_localctx, predIndex);
		case 32:
			return relationExpr_sempred((RelationExprContext)_localctx, predIndex);
		case 33:
			return additiveExpr_sempred((AdditiveExprContext)_localctx, predIndex);
		case 34:
			return multiplicativeExpr_sempred((MultiplicativeExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean variablePropertyAccess_sempred(VariablePropertyAccessContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean variableModifierAccess_sempred(VariableModifierAccessContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean orExpr_sempred(OrExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean andExpr_sempred(AndExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean equalityExpr_sempred(EqualityExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean relationExpr_sempred(RelationExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean additiveExpr_sempred(AdditiveExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean multiplicativeExpr_sempred(MultiplicativeExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\64\u01ac\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\3\2\3\3\3"+
		"\3\6\3j\n\3\r\3\16\3k\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4u\n\4\3\5\3\5\5\5"+
		"y\n\5\3\5\5\5|\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\7\6\u0087\n\6\f"+
		"\6\16\6\u008a\13\6\5\6\u008c\n\6\3\7\3\7\5\7\u0090\n\7\3\7\3\7\3\b\3\b"+
		"\7\b\u0096\n\b\f\b\16\b\u0099\13\b\3\b\3\b\3\t\7\t\u009e\n\t\f\t\16\t"+
		"\u00a1\13\t\3\n\3\n\5\n\u00a5\n\n\3\n\3\n\3\13\5\13\u00aa\n\13\3\13\3"+
		"\13\5\13\u00ae\n\13\3\13\3\13\3\13\5\13\u00b3\n\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00c4\n\16\f\16"+
		"\16\16\u00c7\13\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00d1"+
		"\n\17\f\17\16\17\u00d4\13\17\3\20\3\20\5\20\u00d8\n\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\5\21\u00e1\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\23\7\23\u00ed\n\23\f\23\16\23\u00f0\13\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\5\26\u00fe\n\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\7\33\u011c"+
		"\n\33\f\33\16\33\u011f\13\33\5\33\u0121\n\33\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\7\37"+
		"\u0135\n\37\f\37\16\37\u0138\13\37\3 \3 \3 \3 \3 \3 \7 \u0140\n \f \16"+
		" \u0143\13 \3!\3!\3!\3!\3!\3!\7!\u014b\n!\f!\16!\u014e\13!\3\"\3\"\3\""+
		"\3\"\3\"\3\"\7\"\u0156\n\"\f\"\16\"\u0159\13\"\3#\3#\3#\3#\3#\3#\7#\u0161"+
		"\n#\f#\16#\u0164\13#\3$\3$\3$\3$\3$\3$\7$\u016c\n$\f$\16$\u016f\13$\3"+
		"%\3%\3%\5%\u0174\n%\3&\5&\u0177\n&\3&\3&\3\'\3\'\3\'\3\'\3\'\5\'\u0180"+
		"\n\'\3(\3(\3(\3(\3)\3)\3*\3*\3*\3*\3*\3*\3*\5*\u018f\n*\3+\3+\3+\3+\7"+
		"+\u0195\n+\f+\16+\u0198\13+\5+\u019a\n+\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/"+
		"\3\60\3\60\3\61\3\61\3\62\3\62\3\62\2\n\32\34<>@BDF\63\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`b\2"+
		"\7\3\2\33\34\3\2\35 \3\2!\"\3\2#%\4\2!\"\'\'\2\u01aa\2d\3\2\2\2\4i\3\2"+
		"\2\2\6t\3\2\2\2\b{\3\2\2\2\n\u008b\3\2\2\2\f\u008d\3\2\2\2\16\u0093\3"+
		"\2\2\2\20\u009f\3\2\2\2\22\u00a2\3\2\2\2\24\u00a9\3\2\2\2\26\u00b6\3\2"+
		"\2\2\30\u00bb\3\2\2\2\32\u00bd\3\2\2\2\34\u00c8\3\2\2\2\36\u00d7\3\2\2"+
		"\2 \u00d9\3\2\2\2\"\u00e2\3\2\2\2$\u00ee\3\2\2\2&\u00f1\3\2\2\2(\u00f6"+
		"\3\2\2\2*\u00fd\3\2\2\2,\u00ff\3\2\2\2.\u0107\3\2\2\2\60\u010d\3\2\2\2"+
		"\62\u0113\3\2\2\2\64\u0120\3\2\2\2\66\u0122\3\2\2\28\u0129\3\2\2\2:\u012c"+
		"\3\2\2\2<\u012e\3\2\2\2>\u0139\3\2\2\2@\u0144\3\2\2\2B\u014f\3\2\2\2D"+
		"\u015a\3\2\2\2F\u0165\3\2\2\2H\u0170\3\2\2\2J\u0176\3\2\2\2L\u017f\3\2"+
		"\2\2N\u0181\3\2\2\2P\u0185\3\2\2\2R\u018e\3\2\2\2T\u0190\3\2\2\2V\u019d"+
		"\3\2\2\2X\u019f\3\2\2\2Z\u01a1\3\2\2\2\\\u01a3\3\2\2\2^\u01a5\3\2\2\2"+
		"`\u01a7\3\2\2\2b\u01a9\3\2\2\2de\5\4\3\2ef\7\2\2\3f\3\3\2\2\2gj\5\6\4"+
		"\2hj\5\b\5\2ig\3\2\2\2ih\3\2\2\2jk\3\2\2\2ki\3\2\2\2kl\3\2\2\2l\5\3\2"+
		"\2\2mu\5\22\n\2nu\5\24\13\2ou\5\26\f\2pu\5\36\20\2qu\5*\26\2ru\5\16\b"+
		"\2su\58\35\2tm\3\2\2\2tn\3\2\2\2to\3\2\2\2tp\3\2\2\2tq\3\2\2\2tr\3\2\2"+
		"\2ts\3\2\2\2u\7\3\2\2\2vx\7/\2\2wy\7\60\2\2xw\3\2\2\2xy\3\2\2\2y|\3\2"+
		"\2\2z|\7\3\2\2{v\3\2\2\2{z\3\2\2\2|}\3\2\2\2}~\5b\62\2~\177\7\4\2\2\177"+
		"\u0080\5\n\6\2\u0080\u0081\7\5\2\2\u0081\u0082\5\16\b\2\u0082\t\3\2\2"+
		"\2\u0083\u0088\5\f\7\2\u0084\u0085\7\6\2\2\u0085\u0087\5\f\7\2\u0086\u0084"+
		"\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u0083\3\2\2\2\u008b\u008c\3\2"+
		"\2\2\u008c\13\3\2\2\2\u008d\u008f\7/\2\2\u008e\u0090\7\60\2\2\u008f\u008e"+
		"\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\5b\62\2\u0092"+
		"\r\3\2\2\2\u0093\u0097\7\7\2\2\u0094\u0096\5\6\4\2\u0095\u0094\3\2\2\2"+
		"\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009a"+
		"\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009b\7\b\2\2\u009b\17\3\2\2\2\u009c"+
		"\u009e\5\6\4\2\u009d\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2"+
		"\2\2\u009f\u00a0\3\2\2\2\u00a0\21\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a4"+
		"\7\t\2\2\u00a3\u00a5\5:\36\2\u00a4\u00a3\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5"+
		"\u00a6\3\2\2\2\u00a6\u00a7\7\n\2\2\u00a7\23\3\2\2\2\u00a8\u00aa\7.\2\2"+
		"\u00a9\u00a8\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ad"+
		"\7/\2\2\u00ac\u00ae\7\60\2\2\u00ad\u00ac\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae"+
		"\u00af\3\2\2\2\u00af\u00b2\5b\62\2\u00b0\u00b1\7\13\2\2\u00b1\u00b3\5"+
		":\36\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4"+
		"\u00b5\7\n\2\2\u00b5\25\3\2\2\2\u00b6\u00b7\5\30\r\2\u00b7\u00b8\7\13"+
		"\2\2\u00b8\u00b9\5:\36\2\u00b9\u00ba\7\n\2\2\u00ba\27\3\2\2\2\u00bb\u00bc"+
		"\5\32\16\2\u00bc\31\3\2\2\2\u00bd\u00be\b\16\1\2\u00be\u00bf\5\34\17\2"+
		"\u00bf\u00c5\3\2\2\2\u00c0\u00c1\f\4\2\2\u00c1\u00c2\7\f\2\2\u00c2\u00c4"+
		"\5\34\17\2\u00c3\u00c0\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3\2\2\2"+
		"\u00c5\u00c6\3\2\2\2\u00c6\33\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00c9"+
		"\b\17\1\2\u00c9\u00ca\5b\62\2\u00ca\u00d2\3\2\2\2\u00cb\u00cc\f\4\2\2"+
		"\u00cc\u00cd\7\r\2\2\u00cd\u00ce\5:\36\2\u00ce\u00cf\7\16\2\2\u00cf\u00d1"+
		"\3\2\2\2\u00d0\u00cb\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3\35\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d8\5 \21"+
		"\2\u00d6\u00d8\5\"\22\2\u00d7\u00d5\3\2\2\2\u00d7\u00d6\3\2\2\2\u00d8"+
		"\37\3\2\2\2\u00d9\u00da\7\17\2\2\u00da\u00db\7\4\2\2\u00db\u00dc\5:\36"+
		"\2\u00dc\u00dd\7\5\2\2\u00dd\u00e0\5\16\b\2\u00de\u00df\7\20\2\2\u00df"+
		"\u00e1\5\6\4\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1!\3\2\2\2"+
		"\u00e2\u00e3\7\21\2\2\u00e3\u00e4\7\4\2\2\u00e4\u00e5\5:\36\2\u00e5\u00e6"+
		"\7\5\2\2\u00e6\u00e7\7\7\2\2\u00e7\u00e8\5$\23\2\u00e8\u00e9\5(\25\2\u00e9"+
		"\u00ea\7\b\2\2\u00ea#\3\2\2\2\u00eb\u00ed\5&\24\2\u00ec\u00eb\3\2\2\2"+
		"\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef%\3"+
		"\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f2\7\22\2\2\u00f2\u00f3\5:\36\2\u00f3"+
		"\u00f4\7\23\2\2\u00f4\u00f5\5\20\t\2\u00f5\'\3\2\2\2\u00f6\u00f7\7\24"+
		"\2\2\u00f7\u00f8\7\23\2\2\u00f8\u00f9\5\20\t\2\u00f9)\3\2\2\2\u00fa\u00fe"+
		"\5,\27\2\u00fb\u00fe\5.\30\2\u00fc\u00fe\5\60\31\2\u00fd\u00fa\3\2\2\2"+
		"\u00fd\u00fb\3\2\2\2\u00fd\u00fc\3\2\2\2\u00fe+\3\2\2\2\u00ff\u0100\7"+
		"\25\2\2\u0100\u0101\7\4\2\2\u0101\u0102\5b\62\2\u0102\u0103\7\26\2\2\u0103"+
		"\u0104\5b\62\2\u0104\u0105\7\5\2\2\u0105\u0106\5\16\b\2\u0106-\3\2\2\2"+
		"\u0107\u0108\7\27\2\2\u0108\u0109\7\4\2\2\u0109\u010a\5:\36\2\u010a\u010b"+
		"\7\5\2\2\u010b\u010c\5\16\b\2\u010c/\3\2\2\2\u010d\u010e\7\30\2\2\u010e"+
		"\u010f\7\4\2\2\u010f\u0110\5:\36\2\u0110\u0111\7\5\2\2\u0111\u0112\5\16"+
		"\b\2\u0112\61\3\2\2\2\u0113\u0114\5b\62\2\u0114\u0115\7\4\2\2\u0115\u0116"+
		"\5\64\33\2\u0116\u0117\7\5\2\2\u0117\63\3\2\2\2\u0118\u011d\5:\36\2\u0119"+
		"\u011a\7\6\2\2\u011a\u011c\5:\36\2\u011b\u0119\3\2\2\2\u011c\u011f\3\2"+
		"\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u0121\3\2\2\2\u011f"+
		"\u011d\3\2\2\2\u0120\u0118\3\2\2\2\u0120\u0121\3\2\2\2\u0121\65\3\2\2"+
		"\2\u0122\u0123\5\30\r\2\u0123\u0124\7\f\2\2\u0124\u0125\5b\62\2\u0125"+
		"\u0126\7\4\2\2\u0126\u0127\5\64\33\2\u0127\u0128\7\5\2\2\u0128\67\3\2"+
		"\2\2\u0129\u012a\5:\36\2\u012a\u012b\7\n\2\2\u012b9\3\2\2\2\u012c\u012d"+
		"\5<\37\2\u012d;\3\2\2\2\u012e\u012f\b\37\1\2\u012f\u0130\5> \2\u0130\u0136"+
		"\3\2\2\2\u0131\u0132\f\4\2\2\u0132\u0133\7\31\2\2\u0133\u0135\5> \2\u0134"+
		"\u0131\3\2\2\2\u0135\u0138\3\2\2\2\u0136\u0134\3\2\2\2\u0136\u0137\3\2"+
		"\2\2\u0137=\3\2\2\2\u0138\u0136\3\2\2\2\u0139\u013a\b \1\2\u013a\u013b"+
		"\5@!\2\u013b\u0141\3\2\2\2\u013c\u013d\f\4\2\2\u013d\u013e\7\32\2\2\u013e"+
		"\u0140\5@!\2\u013f\u013c\3\2\2\2\u0140\u0143\3\2\2\2\u0141\u013f\3\2\2"+
		"\2\u0141\u0142\3\2\2\2\u0142?\3\2\2\2\u0143\u0141\3\2\2\2\u0144\u0145"+
		"\b!\1\2\u0145\u0146\5B\"\2\u0146\u014c\3\2\2\2\u0147\u0148\f\4\2\2\u0148"+
		"\u0149\t\2\2\2\u0149\u014b\5B\"\2\u014a\u0147\3\2\2\2\u014b\u014e\3\2"+
		"\2\2\u014c\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014dA\3\2\2\2\u014e\u014c"+
		"\3\2\2\2\u014f\u0150\b\"\1\2\u0150\u0151\5D#\2\u0151\u0157\3\2\2\2\u0152"+
		"\u0153\f\4\2\2\u0153\u0154\t\3\2\2\u0154\u0156\5D#\2\u0155\u0152\3\2\2"+
		"\2\u0156\u0159\3\2\2\2\u0157\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158C"+
		"\3\2\2\2\u0159\u0157\3\2\2\2\u015a\u015b\b#\1\2\u015b\u015c\5F$\2\u015c"+
		"\u0162\3\2\2\2\u015d\u015e\f\4\2\2\u015e\u015f\t\4\2\2\u015f\u0161\5F"+
		"$\2\u0160\u015d\3\2\2\2\u0161\u0164\3\2\2\2\u0162\u0160\3\2\2\2\u0162"+
		"\u0163\3\2\2\2\u0163E\3\2\2\2\u0164\u0162\3\2\2\2\u0165\u0166\b$\1\2\u0166"+
		"\u0167\5H%\2\u0167\u016d\3\2\2\2\u0168\u0169\f\4\2\2\u0169\u016a\t\5\2"+
		"\2\u016a\u016c\5H%\2\u016b\u0168\3\2\2\2\u016c\u016f\3\2\2\2\u016d\u016b"+
		"\3\2\2\2\u016d\u016e\3\2\2\2\u016eG\3\2\2\2\u016f\u016d\3\2\2\2\u0170"+
		"\u0173\5J&\2\u0171\u0172\7&\2\2\u0172\u0174\5H%\2\u0173\u0171\3\2\2\2"+
		"\u0173\u0174\3\2\2\2\u0174I\3\2\2\2\u0175\u0177\t\6\2\2\u0176\u0175\3"+
		"\2\2\2\u0176\u0177\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u0179\5L\'\2\u0179"+
		"K\3\2\2\2\u017a\u0180\5N(\2\u017b\u0180\5R*\2\u017c\u0180\5P)\2\u017d"+
		"\u0180\5\62\32\2\u017e\u0180\5\66\34\2\u017f\u017a\3\2\2\2\u017f\u017b"+
		"\3\2\2\2\u017f\u017c\3\2\2\2\u017f\u017d\3\2\2\2\u017f\u017e\3\2\2\2\u0180"+
		"M\3\2\2\2\u0181\u0182\7\4\2\2\u0182\u0183\5<\37\2\u0183\u0184\7\5\2\2"+
		"\u0184O\3\2\2\2\u0185\u0186\5\30\r\2\u0186Q\3\2\2\2\u0187\u018f\5X-\2"+
		"\u0188\u018f\5Z.\2\u0189\u018f\5V,\2\u018a\u018f\5\\/\2\u018b\u018f\5"+
		"^\60\2\u018c\u018f\5`\61\2\u018d\u018f\5T+\2\u018e\u0187\3\2\2\2\u018e"+
		"\u0188\3\2\2\2\u018e\u0189\3\2\2\2\u018e\u018a\3\2\2\2\u018e\u018b\3\2"+
		"\2\2\u018e\u018c\3\2\2\2\u018e\u018d\3\2\2\2\u018fS\3\2\2\2\u0190\u0199"+
		"\7\r\2\2\u0191\u0196\5:\36\2\u0192\u0193\7\6\2\2\u0193\u0195\5:\36\2\u0194"+
		"\u0192\3\2\2\2\u0195\u0198\3\2\2\2\u0196\u0194\3\2\2\2\u0196\u0197\3\2"+
		"\2\2\u0197\u019a\3\2\2\2\u0198\u0196\3\2\2\2\u0199\u0191\3\2\2\2\u0199"+
		"\u019a\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019c\7\16\2\2\u019cU\3\2\2\2"+
		"\u019d\u019e\7(\2\2\u019eW\3\2\2\2\u019f\u01a0\7)\2\2\u01a0Y\3\2\2\2\u01a1"+
		"\u01a2\7*\2\2\u01a2[\3\2\2\2\u01a3\u01a4\7+\2\2\u01a4]\3\2\2\2\u01a5\u01a6"+
		"\7,\2\2\u01a6_\3\2\2\2\u01a7\u01a8\7-\2\2\u01a8a\3\2\2\2\u01a9\u01aa\7"+
		"\61\2\2\u01aac\3\2\2\2$iktx{\u0088\u008b\u008f\u0097\u009f\u00a4\u00a9"+
		"\u00ad\u00b2\u00c5\u00d2\u00d7\u00e0\u00ee\u00fd\u011d\u0120\u0136\u0141"+
		"\u014c\u0157\u0162\u016d\u0173\u0176\u017f\u018e\u0196\u0199";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}