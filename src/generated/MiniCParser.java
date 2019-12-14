// Generated from MiniC.g4 by ANTLR 4.4
 
package generated;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__19=1, T__18=2, T__17=3, T__16=4, T__15=5, T__14=6, T__13=7, T__12=8, 
		T__11=9, T__10=10, T__9=11, T__8=12, T__7=13, T__6=14, T__5=15, T__4=16, 
		T__3=17, T__2=18, T__1=19, T__0=20, VOID=21, INT=22, SWITCH=23, CASE=24, 
		BREAK=25, WHILE=26, FOR=27, IF=28, ELSE=29, RETURN=30, OR=31, AND=32, 
		LE=33, GE=34, EQ=35, NE=36, IDENT=37, LITERAL=38, DecimalConstant=39, 
		OctalConstant=40, HexadecimalConstant=41, WS=42;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "':'", "'{'", "'['", "';'", "'<'", "'++'", "'--'", 
		"'}'", "']'", "'='", "'>'", "'!'", "'%'", "'('", "')'", "'*'", "'+'", 
		"','", "'-'", "'void'", "'int'", "'switch'", "'case'", "'break;'", "'while'", 
		"'for'", "'if'", "'else'", "'return'", "'or'", "'and'", "'<='", "'>='", 
		"'=='", "'!='", "IDENT", "LITERAL", "DecimalConstant", "OctalConstant", 
		"HexadecimalConstant", "WS"
	};
	public static final int
		RULE_program = 0, RULE_decl = 1, RULE_var_decl = 2, RULE_type_spec = 3, 
		RULE_fun_decl = 4, RULE_params = 5, RULE_param = 6, RULE_stmt = 7, RULE_for_stmt = 8, 
		RULE_for_decl = 9, RULE_case_stmt = 10, RULE_switch_stmt = 11, RULE_expr_stmt = 12, 
		RULE_while_stmt = 13, RULE_compound_stmt = 14, RULE_local_decl = 15, RULE_if_stmt = 16, 
		RULE_return_stmt = 17, RULE_expr = 18, RULE_args = 19;
	public static final String[] ruleNames = {
		"program", "decl", "var_decl", "type_spec", "fun_decl", "params", "param", 
		"stmt", "for_stmt", "for_decl", "case_stmt", "switch_stmt", "expr_stmt", 
		"while_stmt", "compound_stmt", "local_decl", "if_stmt", "return_stmt", 
		"expr", "args"
	};

	@Override
	public String getGrammarFileName() { return "MiniC.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(40); decl();
				}
				}
				setState(43); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==VOID || _la==INT );
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

	public static class DeclContext extends ParserRuleContext {
		public Fun_declContext fun_decl() {
			return getRuleContext(Fun_declContext.class,0);
		}
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		try {
			setState(47);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(45); var_decl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(46); fun_decl();
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

	public static class Var_declContext extends ParserRuleContext {
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public TerminalNode LITERAL() { return getToken(MiniCParser.LITERAL, 0); }
		public TerminalNode IDENT() { return getToken(MiniCParser.IDENT, 0); }
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterVar_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitVar_decl(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_var_decl);
		try {
			setState(66);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(49); type_spec();
				setState(50); match(IDENT);
				setState(51); match(T__15);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(53); type_spec();
				setState(54); match(IDENT);
				setState(55); match(T__9);
				setState(56); match(LITERAL);
				setState(57); match(T__15);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(59); type_spec();
				setState(60); match(IDENT);
				setState(61); match(T__16);
				setState(62); match(LITERAL);
				setState(63); match(T__10);
				setState(64); match(T__15);
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

	public static class Type_specContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(MiniCParser.VOID, 0); }
		public TerminalNode INT() { return getToken(MiniCParser.INT, 0); }
		public Type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterType_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitType_spec(this);
		}
	}

	public final Type_specContext type_spec() throws RecognitionException {
		Type_specContext _localctx = new Type_specContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type_spec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			_la = _input.LA(1);
			if ( !(_la==VOID || _la==INT) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class Fun_declContext extends ParserRuleContext {
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(MiniCParser.IDENT, 0); }
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public Fun_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fun_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterFun_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitFun_decl(this);
		}
	}

	public final Fun_declContext fun_decl() throws RecognitionException {
		Fun_declContext _localctx = new Fun_declContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fun_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70); type_spec();
			setState(71); match(IDENT);
			setState(72); match(T__5);
			setState(73); params();
			setState(74); match(T__4);
			setState(75); compound_stmt();
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

	public static class ParamsContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public TerminalNode VOID() { return getToken(MiniCParser.VOID, 0); }
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitParams(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_params);
		int _la;
		try {
			setState(87);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(77); param();
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(78); match(T__1);
					setState(79); param();
					}
					}
					setState(84);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(85); match(VOID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
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

	public static class ParamContext extends ParserRuleContext {
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(MiniCParser.IDENT, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitParam(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_param);
		try {
			setState(97);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(89); type_spec();
				setState(90); match(IDENT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(92); type_spec();
				setState(93); match(IDENT);
				setState(94); match(T__16);
				setState(95); match(T__10);
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

	public static class StmtContext extends ParserRuleContext {
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public For_stmtContext for_stmt() {
			return getRuleContext(For_stmtContext.class,0);
		}
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public Switch_stmtContext switch_stmt() {
			return getRuleContext(Switch_stmtContext.class,0);
		}
		public Case_stmtContext case_stmt() {
			return getRuleContext(Case_stmtContext.class,0);
		}
		public Return_stmtContext return_stmt() {
			return getRuleContext(Return_stmtContext.class,0);
		}
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public Expr_stmtContext expr_stmt() {
			return getRuleContext(Expr_stmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stmt);
		try {
			setState(107);
			switch (_input.LA(1)) {
			case T__13:
			case T__12:
			case T__7:
			case T__5:
			case T__2:
			case T__0:
			case IDENT:
			case LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(99); expr_stmt();
				}
				break;
			case T__18:
			case T__17:
				enterOuterAlt(_localctx, 2);
				{
				setState(100); compound_stmt();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(101); if_stmt();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 4);
				{
				setState(102); while_stmt();
				}
				break;
			case SWITCH:
				enterOuterAlt(_localctx, 5);
				{
				setState(103); switch_stmt();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 6);
				{
				setState(104); return_stmt();
				}
				break;
			case CASE:
				enterOuterAlt(_localctx, 7);
				{
				setState(105); case_stmt();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 8);
				{
				setState(106); for_stmt();
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

	public static class For_stmtContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public For_declContext for_decl() {
			return getRuleContext(For_declContext.class,0);
		}
		public TerminalNode FOR() { return getToken(MiniCParser.FOR, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public For_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterFor_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitFor_stmt(this);
		}
	}

	public final For_stmtContext for_stmt() throws RecognitionException {
		For_stmtContext _localctx = new For_stmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_for_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109); match(FOR);
			setState(110); match(T__5);
			setState(111); for_decl();
			setState(112); match(T__15);
			setState(113); expr(0);
			setState(114); match(T__15);
			setState(115); expr(0);
			setState(116); match(T__4);
			setState(117); stmt();
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

	public static class For_declContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public TerminalNode LITERAL() { return getToken(MiniCParser.LITERAL, 0); }
		public TerminalNode IDENT() { return getToken(MiniCParser.IDENT, 0); }
		public For_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterFor_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitFor_decl(this);
		}
	}

	public final For_declContext for_decl() throws RecognitionException {
		For_declContext _localctx = new For_declContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_for_decl);
		try {
			setState(125);
			switch (_input.LA(1)) {
			case VOID:
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(119); type_spec();
				setState(120); match(IDENT);
				setState(121); match(T__9);
				setState(122); match(LITERAL);
				}
				break;
			case T__13:
			case T__12:
			case T__7:
			case T__5:
			case T__2:
			case T__0:
			case IDENT:
			case LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(124); expr(0);
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

	public static class Case_stmtContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(MiniCParser.CASE, 0); }
		public TerminalNode BREAK() { return getToken(MiniCParser.BREAK, 0); }
		public TerminalNode LITERAL() { return getToken(MiniCParser.LITERAL, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public Case_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterCase_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitCase_stmt(this);
		}
	}

	public final Case_stmtContext case_stmt() throws RecognitionException {
		Case_stmtContext _localctx = new Case_stmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_case_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127); match(CASE);
			setState(128); match(LITERAL);
			setState(129); stmt();
			setState(130); match(BREAK);
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

	public static class Switch_stmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SWITCH() { return getToken(MiniCParser.SWITCH, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public Switch_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switch_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterSwitch_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitSwitch_stmt(this);
		}
	}

	public final Switch_stmtContext switch_stmt() throws RecognitionException {
		Switch_stmtContext _localctx = new Switch_stmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_switch_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132); match(SWITCH);
			setState(133); match(T__5);
			setState(134); expr(0);
			setState(135); match(T__4);
			setState(136); stmt();
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

	public static class Expr_stmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterExpr_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitExpr_stmt(this);
		}
	}

	public final Expr_stmtContext expr_stmt() throws RecognitionException {
		Expr_stmtContext _localctx = new Expr_stmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expr_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138); expr(0);
			setState(139); match(T__15);
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

	public static class While_stmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(MiniCParser.WHILE, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public While_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterWhile_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitWhile_stmt(this);
		}
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141); match(WHILE);
			setState(142); match(T__5);
			setState(143); expr(0);
			setState(144); match(T__4);
			setState(145); stmt();
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

	public static class Compound_stmtContext extends ParserRuleContext {
		public List<Local_declContext> local_decl() {
			return getRuleContexts(Local_declContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public Local_declContext local_decl(int i) {
			return getRuleContext(Local_declContext.class,i);
		}
		public Compound_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterCompound_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitCompound_stmt(this);
		}
	}

	public final Compound_stmtContext compound_stmt() throws RecognitionException {
		Compound_stmtContext _localctx = new Compound_stmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_compound_stmt);
		int _la;
		try {
			int _alt;
			setState(174);
			switch (_input.LA(1)) {
			case T__17:
				enterOuterAlt(_localctx, 1);
				{
				setState(147); match(T__17);
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VOID || _la==INT) {
					{
					{
					setState(148); local_decl();
					}
					}
					setState(153);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__17) | (1L << T__13) | (1L << T__12) | (1L << T__7) | (1L << T__5) | (1L << T__2) | (1L << T__0) | (1L << SWITCH) | (1L << CASE) | (1L << WHILE) | (1L << FOR) | (1L << IF) | (1L << RETURN) | (1L << IDENT) | (1L << LITERAL))) != 0)) {
					{
					{
					setState(154); stmt();
					}
					}
					setState(159);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(160); match(T__11);
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 2);
				{
				setState(161); match(T__18);
				setState(165);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(162); local_decl();
						}
						} 
					}
					setState(167);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				setState(171);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(168); stmt();
						}
						} 
					}
					setState(173);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				}
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

	public static class Local_declContext extends ParserRuleContext {
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public TerminalNode LITERAL() { return getToken(MiniCParser.LITERAL, 0); }
		public TerminalNode IDENT() { return getToken(MiniCParser.IDENT, 0); }
		public Local_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_local_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterLocal_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitLocal_decl(this);
		}
	}

	public final Local_declContext local_decl() throws RecognitionException {
		Local_declContext _localctx = new Local_declContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_local_decl);
		try {
			setState(193);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(176); type_spec();
				setState(177); match(IDENT);
				setState(178); match(T__15);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(180); type_spec();
				setState(181); match(IDENT);
				setState(182); match(T__9);
				setState(183); match(LITERAL);
				setState(184); match(T__15);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(186); type_spec();
				setState(187); match(IDENT);
				setState(188); match(T__16);
				setState(189); match(LITERAL);
				setState(190); match(T__10);
				setState(191); match(T__15);
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

	public static class If_stmtContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(MiniCParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(MiniCParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterIf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitIf_stmt(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_if_stmt);
		try {
			setState(209);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(195); match(IF);
				setState(196); match(T__5);
				setState(197); expr(0);
				setState(198); match(T__4);
				setState(199); stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(201); match(IF);
				setState(202); match(T__5);
				setState(203); expr(0);
				setState(204); match(T__4);
				setState(205); stmt();
				setState(206); match(ELSE);
				setState(207); stmt();
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

	public static class Return_stmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(MiniCParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Return_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterReturn_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitReturn_stmt(this);
		}
	}

	public final Return_stmtContext return_stmt() throws RecognitionException {
		Return_stmtContext _localctx = new Return_stmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_return_stmt);
		try {
			setState(217);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(211); match(RETURN);
				setState(212); match(T__15);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(213); match(RETURN);
				setState(214); expr(0);
				setState(215); match(T__15);
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

	public static class ExprContext extends ParserRuleContext {
		public TerminalNode GE() { return getToken(MiniCParser.GE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LE() { return getToken(MiniCParser.LE, 0); }
		public TerminalNode AND() { return getToken(MiniCParser.AND, 0); }
		public TerminalNode EQ() { return getToken(MiniCParser.EQ, 0); }
		public TerminalNode NE() { return getToken(MiniCParser.NE, 0); }
		public TerminalNode OR() { return getToken(MiniCParser.OR, 0); }
		public TerminalNode LITERAL() { return getToken(MiniCParser.LITERAL, 0); }
		public TerminalNode IDENT() { return getToken(MiniCParser.IDENT, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(220); match(T__0);
				setState(221); expr(20);
				}
				break;
			case 2:
				{
				setState(222); match(T__2);
				setState(223); expr(19);
				}
				break;
			case 3:
				{
				setState(224); match(T__12);
				setState(225); expr(18);
				}
				break;
			case 4:
				{
				setState(226); match(T__13);
				setState(227); expr(17);
				}
				break;
			case 5:
				{
				setState(228); match(T__7);
				setState(229); expr(5);
				}
				break;
			case 6:
				{
				setState(230); match(IDENT);
				setState(231); match(T__9);
				setState(232); expr(2);
				}
				break;
			case 7:
				{
				setState(233); match(LITERAL);
				}
				break;
			case 8:
				{
				setState(234); match(T__5);
				setState(235); expr(0);
				setState(236); match(T__4);
				}
				break;
			case 9:
				{
				setState(238); match(IDENT);
				}
				break;
			case 10:
				{
				setState(239); match(IDENT);
				setState(240); match(T__16);
				setState(241); expr(0);
				setState(242); match(T__10);
				}
				break;
			case 11:
				{
				setState(244); match(IDENT);
				setState(245); match(T__5);
				setState(246); args();
				setState(247); match(T__4);
				}
				break;
			case 12:
				{
				setState(249); match(IDENT);
				setState(250); match(T__16);
				setState(251); expr(0);
				setState(252); match(T__10);
				setState(253); match(T__9);
				setState(254); expr(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(299);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(297);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(258);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(259); match(T__3);
						setState(260); expr(17);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(261);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(262); match(T__19);
						setState(263); expr(16);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(264);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(265); match(T__6);
						setState(266); expr(15);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(267);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(268); match(T__2);
						setState(269); expr(14);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(270);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(271); match(T__0);
						setState(272); expr(13);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(273);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(274); match(EQ);
						setState(275); expr(12);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(276);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(277); match(NE);
						setState(278); expr(11);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(279);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(280); match(LE);
						setState(281); expr(10);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(282);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(283); match(T__14);
						setState(284); expr(9);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(285);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(286); match(GE);
						setState(287); expr(8);
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(288);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(289); match(T__8);
						setState(290); expr(7);
						}
						break;
					case 12:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(291);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(292); match(AND);
						setState(293); expr(5);
						}
						break;
					case 13:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(294);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(295); match(OR);
						setState(296); expr(4);
						}
						break;
					}
					} 
				}
				setState(301);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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

	public static class ArgsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitArgs(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_args);
		int _la;
		try {
			setState(311);
			switch (_input.LA(1)) {
			case T__13:
			case T__12:
			case T__7:
			case T__5:
			case T__2:
			case T__0:
			case IDENT:
			case LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(302); expr(0);
				setState(307);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(303); match(T__1);
					setState(304); expr(0);
					}
					}
					setState(309);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 18: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 16);
		case 1: return precpred(_ctx, 15);
		case 2: return precpred(_ctx, 14);
		case 3: return precpred(_ctx, 13);
		case 4: return precpred(_ctx, 12);
		case 5: return precpred(_ctx, 11);
		case 6: return precpred(_ctx, 10);
		case 7: return precpred(_ctx, 9);
		case 8: return precpred(_ctx, 8);
		case 9: return precpred(_ctx, 7);
		case 10: return precpred(_ctx, 6);
		case 11: return precpred(_ctx, 4);
		case 12: return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3,\u013c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\6\2,\n\2\r\2\16\2-\3\3\3\3\5\3\62\n"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\5\4E\n\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\7\7S\n\7\f\7"+
		"\16\7V\13\7\3\7\3\7\5\7Z\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bd\n\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tn\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0080\n\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\20\3\20\7\20\u0098\n\20\f\20\16\20\u009b\13\20\3\20\7\20\u009e"+
		"\n\20\f\20\16\20\u00a1\13\20\3\20\3\20\3\20\7\20\u00a6\n\20\f\20\16\20"+
		"\u00a9\13\20\3\20\7\20\u00ac\n\20\f\20\16\20\u00af\13\20\5\20\u00b1\n"+
		"\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\5\21\u00c4\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00d4\n\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\5\23\u00dc\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\5\24\u0103\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\7\24\u012c\n\24\f\24\16\24\u012f\13\24\3\25\3\25\3\25\7\25\u0134\n\25"+
		"\f\25\16\25\u0137\13\25\3\25\5\25\u013a\n\25\3\25\2\3&\26\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\36 \"$&(\2\3\3\2\27\30\u015a\2+\3\2\2\2\4\61"+
		"\3\2\2\2\6D\3\2\2\2\bF\3\2\2\2\nH\3\2\2\2\fY\3\2\2\2\16c\3\2\2\2\20m\3"+
		"\2\2\2\22o\3\2\2\2\24\177\3\2\2\2\26\u0081\3\2\2\2\30\u0086\3\2\2\2\32"+
		"\u008c\3\2\2\2\34\u008f\3\2\2\2\36\u00b0\3\2\2\2 \u00c3\3\2\2\2\"\u00d3"+
		"\3\2\2\2$\u00db\3\2\2\2&\u0102\3\2\2\2(\u0139\3\2\2\2*,\5\4\3\2+*\3\2"+
		"\2\2,-\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\3\3\2\2\2/\62\5\6\4\2\60\62\5\n\6"+
		"\2\61/\3\2\2\2\61\60\3\2\2\2\62\5\3\2\2\2\63\64\5\b\5\2\64\65\7\'\2\2"+
		"\65\66\7\7\2\2\66E\3\2\2\2\678\5\b\5\289\7\'\2\29:\7\r\2\2:;\7(\2\2;<"+
		"\7\7\2\2<E\3\2\2\2=>\5\b\5\2>?\7\'\2\2?@\7\6\2\2@A\7(\2\2AB\7\f\2\2BC"+
		"\7\7\2\2CE\3\2\2\2D\63\3\2\2\2D\67\3\2\2\2D=\3\2\2\2E\7\3\2\2\2FG\t\2"+
		"\2\2G\t\3\2\2\2HI\5\b\5\2IJ\7\'\2\2JK\7\21\2\2KL\5\f\7\2LM\7\22\2\2MN"+
		"\5\36\20\2N\13\3\2\2\2OT\5\16\b\2PQ\7\25\2\2QS\5\16\b\2RP\3\2\2\2SV\3"+
		"\2\2\2TR\3\2\2\2TU\3\2\2\2UZ\3\2\2\2VT\3\2\2\2WZ\7\27\2\2XZ\3\2\2\2YO"+
		"\3\2\2\2YW\3\2\2\2YX\3\2\2\2Z\r\3\2\2\2[\\\5\b\5\2\\]\7\'\2\2]d\3\2\2"+
		"\2^_\5\b\5\2_`\7\'\2\2`a\7\6\2\2ab\7\f\2\2bd\3\2\2\2c[\3\2\2\2c^\3\2\2"+
		"\2d\17\3\2\2\2en\5\32\16\2fn\5\36\20\2gn\5\"\22\2hn\5\34\17\2in\5\30\r"+
		"\2jn\5$\23\2kn\5\26\f\2ln\5\22\n\2me\3\2\2\2mf\3\2\2\2mg\3\2\2\2mh\3\2"+
		"\2\2mi\3\2\2\2mj\3\2\2\2mk\3\2\2\2ml\3\2\2\2n\21\3\2\2\2op\7\35\2\2pq"+
		"\7\21\2\2qr\5\24\13\2rs\7\7\2\2st\5&\24\2tu\7\7\2\2uv\5&\24\2vw\7\22\2"+
		"\2wx\5\20\t\2x\23\3\2\2\2yz\5\b\5\2z{\7\'\2\2{|\7\r\2\2|}\7(\2\2}\u0080"+
		"\3\2\2\2~\u0080\5&\24\2\177y\3\2\2\2\177~\3\2\2\2\u0080\25\3\2\2\2\u0081"+
		"\u0082\7\32\2\2\u0082\u0083\7(\2\2\u0083\u0084\5\20\t\2\u0084\u0085\7"+
		"\33\2\2\u0085\27\3\2\2\2\u0086\u0087\7\31\2\2\u0087\u0088\7\21\2\2\u0088"+
		"\u0089\5&\24\2\u0089\u008a\7\22\2\2\u008a\u008b\5\20\t\2\u008b\31\3\2"+
		"\2\2\u008c\u008d\5&\24\2\u008d\u008e\7\7\2\2\u008e\33\3\2\2\2\u008f\u0090"+
		"\7\34\2\2\u0090\u0091\7\21\2\2\u0091\u0092\5&\24\2\u0092\u0093\7\22\2"+
		"\2\u0093\u0094\5\20\t\2\u0094\35\3\2\2\2\u0095\u0099\7\5\2\2\u0096\u0098"+
		"\5 \21\2\u0097\u0096\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099"+
		"\u009a\3\2\2\2\u009a\u009f\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009e\5\20"+
		"\t\2\u009d\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\u00a2\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00b1\7\13"+
		"\2\2\u00a3\u00a7\7\4\2\2\u00a4\u00a6\5 \21\2\u00a5\u00a4\3\2\2\2\u00a6"+
		"\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00ad\3\2"+
		"\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00ac\5\20\t\2\u00ab\u00aa\3\2\2\2\u00ac"+
		"\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b1\3\2"+
		"\2\2\u00af\u00ad\3\2\2\2\u00b0\u0095\3\2\2\2\u00b0\u00a3\3\2\2\2\u00b1"+
		"\37\3\2\2\2\u00b2\u00b3\5\b\5\2\u00b3\u00b4\7\'\2\2\u00b4\u00b5\7\7\2"+
		"\2\u00b5\u00c4\3\2\2\2\u00b6\u00b7\5\b\5\2\u00b7\u00b8\7\'\2\2\u00b8\u00b9"+
		"\7\r\2\2\u00b9\u00ba\7(\2\2\u00ba\u00bb\7\7\2\2\u00bb\u00c4\3\2\2\2\u00bc"+
		"\u00bd\5\b\5\2\u00bd\u00be\7\'\2\2\u00be\u00bf\7\6\2\2\u00bf\u00c0\7("+
		"\2\2\u00c0\u00c1\7\f\2\2\u00c1\u00c2\7\7\2\2\u00c2\u00c4\3\2\2\2\u00c3"+
		"\u00b2\3\2\2\2\u00c3\u00b6\3\2\2\2\u00c3\u00bc\3\2\2\2\u00c4!\3\2\2\2"+
		"\u00c5\u00c6\7\36\2\2\u00c6\u00c7\7\21\2\2\u00c7\u00c8\5&\24\2\u00c8\u00c9"+
		"\7\22\2\2\u00c9\u00ca\5\20\t\2\u00ca\u00d4\3\2\2\2\u00cb\u00cc\7\36\2"+
		"\2\u00cc\u00cd\7\21\2\2\u00cd\u00ce\5&\24\2\u00ce\u00cf\7\22\2\2\u00cf"+
		"\u00d0\5\20\t\2\u00d0\u00d1\7\37\2\2\u00d1\u00d2\5\20\t\2\u00d2\u00d4"+
		"\3\2\2\2\u00d3\u00c5\3\2\2\2\u00d3\u00cb\3\2\2\2\u00d4#\3\2\2\2\u00d5"+
		"\u00d6\7 \2\2\u00d6\u00dc\7\7\2\2\u00d7\u00d8\7 \2\2\u00d8\u00d9\5&\24"+
		"\2\u00d9\u00da\7\7\2\2\u00da\u00dc\3\2\2\2\u00db\u00d5\3\2\2\2\u00db\u00d7"+
		"\3\2\2\2\u00dc%\3\2\2\2\u00dd\u00de\b\24\1\2\u00de\u00df\7\26\2\2\u00df"+
		"\u0103\5&\24\26\u00e0\u00e1\7\24\2\2\u00e1\u0103\5&\24\25\u00e2\u00e3"+
		"\7\n\2\2\u00e3\u0103\5&\24\24\u00e4\u00e5\7\t\2\2\u00e5\u0103\5&\24\23"+
		"\u00e6\u00e7\7\17\2\2\u00e7\u0103\5&\24\7\u00e8\u00e9\7\'\2\2\u00e9\u00ea"+
		"\7\r\2\2\u00ea\u0103\5&\24\4\u00eb\u0103\7(\2\2\u00ec\u00ed\7\21\2\2\u00ed"+
		"\u00ee\5&\24\2\u00ee\u00ef\7\22\2\2\u00ef\u0103\3\2\2\2\u00f0\u0103\7"+
		"\'\2\2\u00f1\u00f2\7\'\2\2\u00f2\u00f3\7\6\2\2\u00f3\u00f4\5&\24\2\u00f4"+
		"\u00f5\7\f\2\2\u00f5\u0103\3\2\2\2\u00f6\u00f7\7\'\2\2\u00f7\u00f8\7\21"+
		"\2\2\u00f8\u00f9\5(\25\2\u00f9\u00fa\7\22\2\2\u00fa\u0103\3\2\2\2\u00fb"+
		"\u00fc\7\'\2\2\u00fc\u00fd\7\6\2\2\u00fd\u00fe\5&\24\2\u00fe\u00ff\7\f"+
		"\2\2\u00ff\u0100\7\r\2\2\u0100\u0101\5&\24\2\u0101\u0103\3\2\2\2\u0102"+
		"\u00dd\3\2\2\2\u0102\u00e0\3\2\2\2\u0102\u00e2\3\2\2\2\u0102\u00e4\3\2"+
		"\2\2\u0102\u00e6\3\2\2\2\u0102\u00e8\3\2\2\2\u0102\u00eb\3\2\2\2\u0102"+
		"\u00ec\3\2\2\2\u0102\u00f0\3\2\2\2\u0102\u00f1\3\2\2\2\u0102\u00f6\3\2"+
		"\2\2\u0102\u00fb\3\2\2\2\u0103\u012d\3\2\2\2\u0104\u0105\f\22\2\2\u0105"+
		"\u0106\7\23\2\2\u0106\u012c\5&\24\23\u0107\u0108\f\21\2\2\u0108\u0109"+
		"\7\3\2\2\u0109\u012c\5&\24\22\u010a\u010b\f\20\2\2\u010b\u010c\7\20\2"+
		"\2\u010c\u012c\5&\24\21\u010d\u010e\f\17\2\2\u010e\u010f\7\24\2\2\u010f"+
		"\u012c\5&\24\20\u0110\u0111\f\16\2\2\u0111\u0112\7\26\2\2\u0112\u012c"+
		"\5&\24\17\u0113\u0114\f\r\2\2\u0114\u0115\7%\2\2\u0115\u012c\5&\24\16"+
		"\u0116\u0117\f\f\2\2\u0117\u0118\7&\2\2\u0118\u012c\5&\24\r\u0119\u011a"+
		"\f\13\2\2\u011a\u011b\7#\2\2\u011b\u012c\5&\24\f\u011c\u011d\f\n\2\2\u011d"+
		"\u011e\7\b\2\2\u011e\u012c\5&\24\13\u011f\u0120\f\t\2\2\u0120\u0121\7"+
		"$\2\2\u0121\u012c\5&\24\n\u0122\u0123\f\b\2\2\u0123\u0124\7\16\2\2\u0124"+
		"\u012c\5&\24\t\u0125\u0126\f\6\2\2\u0126\u0127\7\"\2\2\u0127\u012c\5&"+
		"\24\7\u0128\u0129\f\5\2\2\u0129\u012a\7!\2\2\u012a\u012c\5&\24\6\u012b"+
		"\u0104\3\2\2\2\u012b\u0107\3\2\2\2\u012b\u010a\3\2\2\2\u012b\u010d\3\2"+
		"\2\2\u012b\u0110\3\2\2\2\u012b\u0113\3\2\2\2\u012b\u0116\3\2\2\2\u012b"+
		"\u0119\3\2\2\2\u012b\u011c\3\2\2\2\u012b\u011f\3\2\2\2\u012b\u0122\3\2"+
		"\2\2\u012b\u0125\3\2\2\2\u012b\u0128\3\2\2\2\u012c\u012f\3\2\2\2\u012d"+
		"\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e\'\3\2\2\2\u012f\u012d\3\2\2\2"+
		"\u0130\u0135\5&\24\2\u0131\u0132\7\25\2\2\u0132\u0134\5&\24\2\u0133\u0131"+
		"\3\2\2\2\u0134\u0137\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136"+
		"\u013a\3\2\2\2\u0137\u0135\3\2\2\2\u0138\u013a\3\2\2\2\u0139\u0130\3\2"+
		"\2\2\u0139\u0138\3\2\2\2\u013a)\3\2\2\2\27-\61DTYcm\177\u0099\u009f\u00a7"+
		"\u00ad\u00b0\u00c3\u00d3\u00db\u0102\u012b\u012d\u0135\u0139";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}