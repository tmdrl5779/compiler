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
		WHILE=25, IF=26, ELSE=27, RETURN=28, OR=29, AND=30, LE=31, GE=32, EQ=33, 
		NE=34, IDENT=35, LITERAL=36, DecimalConstant=37, OctalConstant=38, HexadecimalConstant=39, 
		WS=40;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "':'", "'{'", "'['", "';'", "'<'", "'++'", "'--'", 
		"'}'", "']'", "'='", "'>'", "'!'", "'%'", "'('", "')'", "'*'", "'+'", 
		"','", "'-'", "'void'", "'int'", "'switch'", "'case'", "'while'", "'if'", 
		"'else'", "'return'", "'or'", "'and'", "'<='", "'>='", "'=='", "'!='", 
		"IDENT", "LITERAL", "DecimalConstant", "OctalConstant", "HexadecimalConstant", 
		"WS"
	};
	public static final int
		RULE_program = 0, RULE_decl = 1, RULE_var_decl = 2, RULE_type_spec = 3, 
		RULE_fun_decl = 4, RULE_params = 5, RULE_param = 6, RULE_stmt = 7, RULE_case_stmt = 8, 
		RULE_switch_stmt = 9, RULE_expr_stmt = 10, RULE_while_stmt = 11, RULE_compound_stmt = 12, 
		RULE_local_decl = 13, RULE_if_stmt = 14, RULE_return_stmt = 15, RULE_expr = 16, 
		RULE_args = 17;
	public static final String[] ruleNames = {
		"program", "decl", "var_decl", "type_spec", "fun_decl", "params", "param", 
		"stmt", "case_stmt", "switch_stmt", "expr_stmt", "while_stmt", "compound_stmt", 
		"local_decl", "if_stmt", "return_stmt", "expr", "args"
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
			setState(37); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(36); decl();
				}
				}
				setState(39); 
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
			setState(43);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(41); var_decl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(42); fun_decl();
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
			setState(62);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(45); type_spec();
				setState(46); match(IDENT);
				setState(47); match(T__15);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(49); type_spec();
				setState(50); match(IDENT);
				setState(51); match(T__9);
				setState(52); match(LITERAL);
				setState(53); match(T__15);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(55); type_spec();
				setState(56); match(IDENT);
				setState(57); match(T__16);
				setState(58); match(LITERAL);
				setState(59); match(T__10);
				setState(60); match(T__15);
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
			setState(64);
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
			setState(66); type_spec();
			setState(67); match(IDENT);
			setState(68); match(T__5);
			setState(69); params();
			setState(70); match(T__4);
			setState(71); compound_stmt();
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
			setState(83);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(73); param();
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(74); match(T__1);
					setState(75); param();
					}
					}
					setState(80);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(81); match(VOID);
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
			setState(93);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(85); type_spec();
				setState(86); match(IDENT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(88); type_spec();
				setState(89); match(IDENT);
				setState(90); match(T__16);
				setState(91); match(T__10);
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
			setState(102);
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
				setState(95); expr_stmt();
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 2);
				{
				setState(96); compound_stmt();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(97); if_stmt();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 4);
				{
				setState(98); while_stmt();
				}
				break;
			case SWITCH:
				enterOuterAlt(_localctx, 5);
				{
				setState(99); switch_stmt();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 6);
				{
				setState(100); return_stmt();
				}
				break;
			case CASE:
				enterOuterAlt(_localctx, 7);
				{
				setState(101); case_stmt();
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
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode LITERAL() { return getToken(MiniCParser.LITERAL, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
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
		enterRule(_localctx, 16, RULE_case_stmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(104); match(CASE);
			setState(105); match(LITERAL);
			setState(106); match(T__18);
			setState(110);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(107); stmt();
					}
					} 
				}
				setState(112);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		enterRule(_localctx, 18, RULE_switch_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113); match(SWITCH);
			setState(114); match(T__5);
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
		enterRule(_localctx, 20, RULE_expr_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119); expr(0);
			setState(120); match(T__15);
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
		enterRule(_localctx, 22, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122); match(WHILE);
			setState(123); match(T__5);
			setState(124); expr(0);
			setState(125); match(T__4);
			setState(126); stmt();
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
		enterRule(_localctx, 24, RULE_compound_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128); match(T__17);
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VOID || _la==INT) {
				{
				{
				setState(129); local_decl();
				}
				}
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__13) | (1L << T__12) | (1L << T__7) | (1L << T__5) | (1L << T__2) | (1L << T__0) | (1L << SWITCH) | (1L << CASE) | (1L << WHILE) | (1L << IF) | (1L << RETURN) | (1L << IDENT) | (1L << LITERAL))) != 0)) {
				{
				{
				setState(135); stmt();
				}
				}
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(141); match(T__11);
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
		enterRule(_localctx, 26, RULE_local_decl);
		try {
			setState(160);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(143); type_spec();
				setState(144); match(IDENT);
				setState(145); match(T__15);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(147); type_spec();
				setState(148); match(IDENT);
				setState(149); match(T__9);
				setState(150); match(LITERAL);
				setState(151); match(T__15);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(153); type_spec();
				setState(154); match(IDENT);
				setState(155); match(T__16);
				setState(156); match(LITERAL);
				setState(157); match(T__10);
				setState(158); match(T__15);
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
		enterRule(_localctx, 28, RULE_if_stmt);
		try {
			setState(176);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(162); match(IF);
				setState(163); match(T__5);
				setState(164); expr(0);
				setState(165); match(T__4);
				setState(166); stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(168); match(IF);
				setState(169); match(T__5);
				setState(170); expr(0);
				setState(171); match(T__4);
				setState(172); stmt();
				setState(173); match(ELSE);
				setState(174); stmt();
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
		enterRule(_localctx, 30, RULE_return_stmt);
		try {
			setState(184);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(178); match(RETURN);
				setState(179); match(T__15);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(180); match(RETURN);
				setState(181); expr(0);
				setState(182); match(T__15);
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
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(187); match(T__0);
				setState(188); expr(20);
				}
				break;
			case 2:
				{
				setState(189); match(T__2);
				setState(190); expr(19);
				}
				break;
			case 3:
				{
				setState(191); match(T__12);
				setState(192); expr(18);
				}
				break;
			case 4:
				{
				setState(193); match(T__13);
				setState(194); expr(17);
				}
				break;
			case 5:
				{
				setState(195); match(T__7);
				setState(196); expr(5);
				}
				break;
			case 6:
				{
				setState(197); match(IDENT);
				setState(198); match(T__9);
				setState(199); expr(2);
				}
				break;
			case 7:
				{
				setState(200); match(LITERAL);
				}
				break;
			case 8:
				{
				setState(201); match(T__5);
				setState(202); expr(0);
				setState(203); match(T__4);
				}
				break;
			case 9:
				{
				setState(205); match(IDENT);
				}
				break;
			case 10:
				{
				setState(206); match(IDENT);
				setState(207); match(T__16);
				setState(208); expr(0);
				setState(209); match(T__10);
				}
				break;
			case 11:
				{
				setState(211); match(IDENT);
				setState(212); match(T__5);
				setState(213); args();
				setState(214); match(T__4);
				}
				break;
			case 12:
				{
				setState(216); match(IDENT);
				setState(217); match(T__16);
				setState(218); expr(0);
				setState(219); match(T__10);
				setState(220); match(T__9);
				setState(221); expr(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(266);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(264);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(225);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(226); match(T__3);
						setState(227); expr(17);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(228);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(229); match(T__19);
						setState(230); expr(16);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(231);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(232); match(T__6);
						setState(233); expr(15);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(234);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(235); match(T__2);
						setState(236); expr(14);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(237);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(238); match(T__0);
						setState(239); expr(13);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(240);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(241); match(EQ);
						setState(242); expr(12);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(243);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(244); match(NE);
						setState(245); expr(11);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(246);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(247); match(LE);
						setState(248); expr(10);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(249);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(250); match(T__14);
						setState(251); expr(9);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(252);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(253); match(GE);
						setState(254); expr(8);
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(255);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(256); match(T__8);
						setState(257); expr(7);
						}
						break;
					case 12:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(258);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(259); match(AND);
						setState(260); expr(5);
						}
						break;
					case 13:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(261);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(262); match(OR);
						setState(263); expr(4);
						}
						break;
					}
					} 
				}
				setState(268);
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
		enterRule(_localctx, 34, RULE_args);
		int _la;
		try {
			setState(278);
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
				setState(269); expr(0);
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(270); match(T__1);
					setState(271); expr(0);
					}
					}
					setState(276);
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
		case 16: return expr_sempred((ExprContext)_localctx, predIndex);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3*\u011b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\6\2(\n\2\r\2\16\2)\3\3\3\3\5\3.\n\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4A\n\4\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\7\7O\n\7\f\7\16\7R\13\7\3\7\3\7\5"+
		"\7V\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b`\n\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\5\ti\n\t\3\n\3\n\3\n\3\n\7\no\n\n\f\n\16\nr\13\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\7\16\u0085"+
		"\n\16\f\16\16\16\u0088\13\16\3\16\7\16\u008b\n\16\f\16\16\16\u008e\13"+
		"\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\5\17\u00a3\n\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00b3\n\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\5\21\u00bb\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\5\22\u00e2\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\7\22\u010b\n\22\f\22\16\22\u010e\13\22\3\23\3\23\3\23\7\23"+
		"\u0113\n\23\f\23\16\23\u0116\13\23\3\23\5\23\u0119\n\23\3\23\2\3\"\24"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\3\3\2\27\30\u0137\2\'\3"+
		"\2\2\2\4-\3\2\2\2\6@\3\2\2\2\bB\3\2\2\2\nD\3\2\2\2\fU\3\2\2\2\16_\3\2"+
		"\2\2\20h\3\2\2\2\22j\3\2\2\2\24s\3\2\2\2\26y\3\2\2\2\30|\3\2\2\2\32\u0082"+
		"\3\2\2\2\34\u00a2\3\2\2\2\36\u00b2\3\2\2\2 \u00ba\3\2\2\2\"\u00e1\3\2"+
		"\2\2$\u0118\3\2\2\2&(\5\4\3\2\'&\3\2\2\2()\3\2\2\2)\'\3\2\2\2)*\3\2\2"+
		"\2*\3\3\2\2\2+.\5\6\4\2,.\5\n\6\2-+\3\2\2\2-,\3\2\2\2.\5\3\2\2\2/\60\5"+
		"\b\5\2\60\61\7%\2\2\61\62\7\7\2\2\62A\3\2\2\2\63\64\5\b\5\2\64\65\7%\2"+
		"\2\65\66\7\r\2\2\66\67\7&\2\2\678\7\7\2\28A\3\2\2\29:\5\b\5\2:;\7%\2\2"+
		";<\7\6\2\2<=\7&\2\2=>\7\f\2\2>?\7\7\2\2?A\3\2\2\2@/\3\2\2\2@\63\3\2\2"+
		"\2@9\3\2\2\2A\7\3\2\2\2BC\t\2\2\2C\t\3\2\2\2DE\5\b\5\2EF\7%\2\2FG\7\21"+
		"\2\2GH\5\f\7\2HI\7\22\2\2IJ\5\32\16\2J\13\3\2\2\2KP\5\16\b\2LM\7\25\2"+
		"\2MO\5\16\b\2NL\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QV\3\2\2\2RP\3\2"+
		"\2\2SV\7\27\2\2TV\3\2\2\2UK\3\2\2\2US\3\2\2\2UT\3\2\2\2V\r\3\2\2\2WX\5"+
		"\b\5\2XY\7%\2\2Y`\3\2\2\2Z[\5\b\5\2[\\\7%\2\2\\]\7\6\2\2]^\7\f\2\2^`\3"+
		"\2\2\2_W\3\2\2\2_Z\3\2\2\2`\17\3\2\2\2ai\5\26\f\2bi\5\32\16\2ci\5\36\20"+
		"\2di\5\30\r\2ei\5\24\13\2fi\5 \21\2gi\5\22\n\2ha\3\2\2\2hb\3\2\2\2hc\3"+
		"\2\2\2hd\3\2\2\2he\3\2\2\2hf\3\2\2\2hg\3\2\2\2i\21\3\2\2\2jk\7\32\2\2"+
		"kl\7&\2\2lp\7\4\2\2mo\5\20\t\2nm\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2"+
		"q\23\3\2\2\2rp\3\2\2\2st\7\31\2\2tu\7\21\2\2uv\5\"\22\2vw\7\22\2\2wx\5"+
		"\20\t\2x\25\3\2\2\2yz\5\"\22\2z{\7\7\2\2{\27\3\2\2\2|}\7\33\2\2}~\7\21"+
		"\2\2~\177\5\"\22\2\177\u0080\7\22\2\2\u0080\u0081\5\20\t\2\u0081\31\3"+
		"\2\2\2\u0082\u0086\7\5\2\2\u0083\u0085\5\34\17\2\u0084\u0083\3\2\2\2\u0085"+
		"\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u008c\3\2"+
		"\2\2\u0088\u0086\3\2\2\2\u0089\u008b\5\20\t\2\u008a\u0089\3\2\2\2\u008b"+
		"\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008f\3\2"+
		"\2\2\u008e\u008c\3\2\2\2\u008f\u0090\7\13\2\2\u0090\33\3\2\2\2\u0091\u0092"+
		"\5\b\5\2\u0092\u0093\7%\2\2\u0093\u0094\7\7\2\2\u0094\u00a3\3\2\2\2\u0095"+
		"\u0096\5\b\5\2\u0096\u0097\7%\2\2\u0097\u0098\7\r\2\2\u0098\u0099\7&\2"+
		"\2\u0099\u009a\7\7\2\2\u009a\u00a3\3\2\2\2\u009b\u009c\5\b\5\2\u009c\u009d"+
		"\7%\2\2\u009d\u009e\7\6\2\2\u009e\u009f\7&\2\2\u009f\u00a0\7\f\2\2\u00a0"+
		"\u00a1\7\7\2\2\u00a1\u00a3\3\2\2\2\u00a2\u0091\3\2\2\2\u00a2\u0095\3\2"+
		"\2\2\u00a2\u009b\3\2\2\2\u00a3\35\3\2\2\2\u00a4\u00a5\7\34\2\2\u00a5\u00a6"+
		"\7\21\2\2\u00a6\u00a7\5\"\22\2\u00a7\u00a8\7\22\2\2\u00a8\u00a9\5\20\t"+
		"\2\u00a9\u00b3\3\2\2\2\u00aa\u00ab\7\34\2\2\u00ab\u00ac\7\21\2\2\u00ac"+
		"\u00ad\5\"\22\2\u00ad\u00ae\7\22\2\2\u00ae\u00af\5\20\t\2\u00af\u00b0"+
		"\7\35\2\2\u00b0\u00b1\5\20\t\2\u00b1\u00b3\3\2\2\2\u00b2\u00a4\3\2\2\2"+
		"\u00b2\u00aa\3\2\2\2\u00b3\37\3\2\2\2\u00b4\u00b5\7\36\2\2\u00b5\u00bb"+
		"\7\7\2\2\u00b6\u00b7\7\36\2\2\u00b7\u00b8\5\"\22\2\u00b8\u00b9\7\7\2\2"+
		"\u00b9\u00bb\3\2\2\2\u00ba\u00b4\3\2\2\2\u00ba\u00b6\3\2\2\2\u00bb!\3"+
		"\2\2\2\u00bc\u00bd\b\22\1\2\u00bd\u00be\7\26\2\2\u00be\u00e2\5\"\22\26"+
		"\u00bf\u00c0\7\24\2\2\u00c0\u00e2\5\"\22\25\u00c1\u00c2\7\n\2\2\u00c2"+
		"\u00e2\5\"\22\24\u00c3\u00c4\7\t\2\2\u00c4\u00e2\5\"\22\23\u00c5\u00c6"+
		"\7\17\2\2\u00c6\u00e2\5\"\22\7\u00c7\u00c8\7%\2\2\u00c8\u00c9\7\r\2\2"+
		"\u00c9\u00e2\5\"\22\4\u00ca\u00e2\7&\2\2\u00cb\u00cc\7\21\2\2\u00cc\u00cd"+
		"\5\"\22\2\u00cd\u00ce\7\22\2\2\u00ce\u00e2\3\2\2\2\u00cf\u00e2\7%\2\2"+
		"\u00d0\u00d1\7%\2\2\u00d1\u00d2\7\6\2\2\u00d2\u00d3\5\"\22\2\u00d3\u00d4"+
		"\7\f\2\2\u00d4\u00e2\3\2\2\2\u00d5\u00d6\7%\2\2\u00d6\u00d7\7\21\2\2\u00d7"+
		"\u00d8\5$\23\2\u00d8\u00d9\7\22\2\2\u00d9\u00e2\3\2\2\2\u00da\u00db\7"+
		"%\2\2\u00db\u00dc\7\6\2\2\u00dc\u00dd\5\"\22\2\u00dd\u00de\7\f\2\2\u00de"+
		"\u00df\7\r\2\2\u00df\u00e0\5\"\22\2\u00e0\u00e2\3\2\2\2\u00e1\u00bc\3"+
		"\2\2\2\u00e1\u00bf\3\2\2\2\u00e1\u00c1\3\2\2\2\u00e1\u00c3\3\2\2\2\u00e1"+
		"\u00c5\3\2\2\2\u00e1\u00c7\3\2\2\2\u00e1\u00ca\3\2\2\2\u00e1\u00cb\3\2"+
		"\2\2\u00e1\u00cf\3\2\2\2\u00e1\u00d0\3\2\2\2\u00e1\u00d5\3\2\2\2\u00e1"+
		"\u00da\3\2\2\2\u00e2\u010c\3\2\2\2\u00e3\u00e4\f\22\2\2\u00e4\u00e5\7"+
		"\23\2\2\u00e5\u010b\5\"\22\23\u00e6\u00e7\f\21\2\2\u00e7\u00e8\7\3\2\2"+
		"\u00e8\u010b\5\"\22\22\u00e9\u00ea\f\20\2\2\u00ea\u00eb\7\20\2\2\u00eb"+
		"\u010b\5\"\22\21\u00ec\u00ed\f\17\2\2\u00ed\u00ee\7\24\2\2\u00ee\u010b"+
		"\5\"\22\20\u00ef\u00f0\f\16\2\2\u00f0\u00f1\7\26\2\2\u00f1\u010b\5\"\22"+
		"\17\u00f2\u00f3\f\r\2\2\u00f3\u00f4\7#\2\2\u00f4\u010b\5\"\22\16\u00f5"+
		"\u00f6\f\f\2\2\u00f6\u00f7\7$\2\2\u00f7\u010b\5\"\22\r\u00f8\u00f9\f\13"+
		"\2\2\u00f9\u00fa\7!\2\2\u00fa\u010b\5\"\22\f\u00fb\u00fc\f\n\2\2\u00fc"+
		"\u00fd\7\b\2\2\u00fd\u010b\5\"\22\13\u00fe\u00ff\f\t\2\2\u00ff\u0100\7"+
		"\"\2\2\u0100\u010b\5\"\22\n\u0101\u0102\f\b\2\2\u0102\u0103\7\16\2\2\u0103"+
		"\u010b\5\"\22\t\u0104\u0105\f\6\2\2\u0105\u0106\7 \2\2\u0106\u010b\5\""+
		"\22\7\u0107\u0108\f\5\2\2\u0108\u0109\7\37\2\2\u0109\u010b\5\"\22\6\u010a"+
		"\u00e3\3\2\2\2\u010a\u00e6\3\2\2\2\u010a\u00e9\3\2\2\2\u010a\u00ec\3\2"+
		"\2\2\u010a\u00ef\3\2\2\2\u010a\u00f2\3\2\2\2\u010a\u00f5\3\2\2\2\u010a"+
		"\u00f8\3\2\2\2\u010a\u00fb\3\2\2\2\u010a\u00fe\3\2\2\2\u010a\u0101\3\2"+
		"\2\2\u010a\u0104\3\2\2\2\u010a\u0107\3\2\2\2\u010b\u010e\3\2\2\2\u010c"+
		"\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d#\3\2\2\2\u010e\u010c\3\2\2\2"+
		"\u010f\u0114\5\"\22\2\u0110\u0111\7\25\2\2\u0111\u0113\5\"\22\2\u0112"+
		"\u0110\3\2\2\2\u0113\u0116\3\2\2\2\u0114\u0112\3\2\2\2\u0114\u0115\3\2"+
		"\2\2\u0115\u0119\3\2\2\2\u0116\u0114\3\2\2\2\u0117\u0119\3\2\2\2\u0118"+
		"\u010f\3\2\2\2\u0118\u0117\3\2\2\2\u0119%\3\2\2\2\24)-@PU_hp\u0086\u008c"+
		"\u00a2\u00b2\u00ba\u00e1\u010a\u010c\u0114\u0118";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}