// Generated from regularExpression.g4 by ANTLR 4.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class regularExpressionParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__9=1, T__8=2, T__7=3, T__6=4, T__5=5, T__4=6, T__3=7, T__2=8, T__1=9, 
		T__0=10, SYMB=11, WS=12;
	public static final String[] tokenNames = {
		"<INVALID>", "']'", "')'", "'+'", "'*'", "'['", "'{'", "'('", "'}'", "'|'", 
		"'?'", "SYMB", "WS"
	};
	public static final int
		RULE_start = 0, RULE_altn = 1, RULE_concat = 2, RULE_starred = 3, RULE_exp = 4;
	public static final String[] ruleNames = {
		"start", "altn", "concat", "starred", "exp"
	};

	@Override
	public String getGrammarFileName() { return "regularExpression.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public regularExpressionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(regularExpressionParser.EOF, 0); }
		public AltnContext altn() {
			return getRuleContext(AltnContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regularExpressionListener ) ((regularExpressionListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regularExpressionListener ) ((regularExpressionListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof regularExpressionVisitor ) return ((regularExpressionVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10); altn();
			setState(11); match(EOF);
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

	public static class AltnContext extends ParserRuleContext {
		public List<ConcatContext> concat() {
			return getRuleContexts(ConcatContext.class);
		}
		public ConcatContext concat(int i) {
			return getRuleContext(ConcatContext.class,i);
		}
		public AltnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_altn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regularExpressionListener ) ((regularExpressionListener)listener).enterAltn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regularExpressionListener ) ((regularExpressionListener)listener).exitAltn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof regularExpressionVisitor ) return ((regularExpressionVisitor<? extends T>)visitor).visitAltn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AltnContext altn() throws RecognitionException {
		AltnContext _localctx = new AltnContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_altn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13); concat();
			setState(18);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==9) {
				{
				{
				setState(14); match(9);
				setState(15); concat();
				}
				}
				setState(20);
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

	public static class ConcatContext extends ParserRuleContext {
		public StarredContext starred(int i) {
			return getRuleContext(StarredContext.class,i);
		}
		public List<StarredContext> starred() {
			return getRuleContexts(StarredContext.class);
		}
		public ConcatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_concat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regularExpressionListener ) ((regularExpressionListener)listener).enterConcat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regularExpressionListener ) ((regularExpressionListener)listener).exitConcat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof regularExpressionVisitor ) return ((regularExpressionVisitor<? extends T>)visitor).visitConcat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConcatContext concat() throws RecognitionException {
		ConcatContext _localctx = new ConcatContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_concat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21); starred();
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 6) | (1L << 7) | (1L << SYMB))) != 0)) {
				{
				{
				setState(22); starred();
				}
				}
				setState(27);
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

	public static class StarredContext extends ParserRuleContext {
		public StarredContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_starred; }
	 
		public StarredContext() { }
		public void copyFrom(StarredContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PlusContext extends StarredContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public PlusContext(StarredContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regularExpressionListener ) ((regularExpressionListener)listener).enterPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regularExpressionListener ) ((regularExpressionListener)listener).exitPlus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof regularExpressionVisitor ) return ((regularExpressionVisitor<? extends T>)visitor).visitPlus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StarContext extends StarredContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public StarContext(StarredContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regularExpressionListener ) ((regularExpressionListener)listener).enterStar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regularExpressionListener ) ((regularExpressionListener)listener).exitStar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof regularExpressionVisitor ) return ((regularExpressionVisitor<? extends T>)visitor).visitStar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprContext extends StarredContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ExprContext(StarredContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regularExpressionListener ) ((regularExpressionListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regularExpressionListener ) ((regularExpressionListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof regularExpressionVisitor ) return ((regularExpressionVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QuesContext extends StarredContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public QuesContext(StarredContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regularExpressionListener ) ((regularExpressionListener)listener).enterQues(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regularExpressionListener ) ((regularExpressionListener)listener).exitQues(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof regularExpressionVisitor ) return ((regularExpressionVisitor<? extends T>)visitor).visitQues(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StarredContext starred() throws RecognitionException {
		StarredContext _localctx = new StarredContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_starred);
		try {
			setState(38);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new ExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(28); exp();
				}
				break;

			case 2:
				_localctx = new StarContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(29); exp();
				setState(30); match(4);
				}
				}
				break;

			case 3:
				_localctx = new QuesContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(32); exp();
				setState(33); match(10);
				}
				}
				break;

			case 4:
				_localctx = new PlusContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(35); exp();
				setState(36); match(3);
				}
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

	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RekuContext extends ExpContext {
		public List<TerminalNode> SYMB() { return getTokens(regularExpressionParser.SYMB); }
		public TerminalNode SYMB(int i) {
			return getToken(regularExpressionParser.SYMB, i);
		}
		public RekuContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regularExpressionListener ) ((regularExpressionListener)listener).enterReku(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regularExpressionListener ) ((regularExpressionListener)listener).exitReku(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof regularExpressionVisitor ) return ((regularExpressionVisitor<? extends T>)visitor).visitReku(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SymbolContext extends ExpContext {
		public TerminalNode SYMB() { return getToken(regularExpressionParser.SYMB, 0); }
		public SymbolContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regularExpressionListener ) ((regularExpressionListener)listener).enterSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regularExpressionListener ) ((regularExpressionListener)listener).exitSymbol(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof regularExpressionVisitor ) return ((regularExpressionVisitor<? extends T>)visitor).visitSymbol(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrexpContext extends ExpContext {
		public List<TerminalNode> SYMB() { return getTokens(regularExpressionParser.SYMB); }
		public TerminalNode SYMB(int i) {
			return getToken(regularExpressionParser.SYMB, i);
		}
		public OrexpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regularExpressionListener ) ((regularExpressionListener)listener).enterOrexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regularExpressionListener ) ((regularExpressionListener)listener).exitOrexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof regularExpressionVisitor ) return ((regularExpressionVisitor<? extends T>)visitor).visitOrexp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GroupContext extends ExpContext {
		public AltnContext altn() {
			return getRuleContext(AltnContext.class,0);
		}
		public GroupContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regularExpressionListener ) ((regularExpressionListener)listener).enterGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regularExpressionListener ) ((regularExpressionListener)listener).exitGroup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof regularExpressionVisitor ) return ((regularExpressionVisitor<? extends T>)visitor).visitGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_exp);
		int _la;
		try {
			setState(59);
			switch (_input.LA(1)) {
			case 7:
				_localctx = new GroupContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(40); match(7);
				setState(41); altn();
				setState(42); match(2);
				}
				break;
			case SYMB:
				_localctx = new SymbolContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(44); match(SYMB);
				}
				break;
			case 5:
				_localctx = new OrexpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(45); match(5);
				setState(47); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(46); match(SYMB);
					}
					}
					setState(49); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==SYMB );
				setState(51); match(1);
				}
				break;
			case 6:
				_localctx = new RekuContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(52); match(6);
				setState(54); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(53); match(SYMB);
					}
					}
					setState(56); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==SYMB );
				setState(58); match(8);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\16@\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\3\3\3\3\3\7\3\23\n\3\f\3\16\3"+
		"\26\13\3\3\4\3\4\7\4\32\n\4\f\4\16\4\35\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\5\5)\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\6\6\62\n\6\r\6\16"+
		"\6\63\3\6\3\6\3\6\6\69\n\6\r\6\16\6:\3\6\5\6>\n\6\3\6\2\2\7\2\4\6\b\n"+
		"\2\2D\2\f\3\2\2\2\4\17\3\2\2\2\6\27\3\2\2\2\b(\3\2\2\2\n=\3\2\2\2\f\r"+
		"\5\4\3\2\r\16\7\2\2\3\16\3\3\2\2\2\17\24\5\6\4\2\20\21\7\13\2\2\21\23"+
		"\5\6\4\2\22\20\3\2\2\2\23\26\3\2\2\2\24\22\3\2\2\2\24\25\3\2\2\2\25\5"+
		"\3\2\2\2\26\24\3\2\2\2\27\33\5\b\5\2\30\32\5\b\5\2\31\30\3\2\2\2\32\35"+
		"\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\7\3\2\2\2\35\33\3\2\2\2\36)\5"+
		"\n\6\2\37 \5\n\6\2 !\7\6\2\2!)\3\2\2\2\"#\5\n\6\2#$\7\f\2\2$)\3\2\2\2"+
		"%&\5\n\6\2&\'\7\5\2\2\')\3\2\2\2(\36\3\2\2\2(\37\3\2\2\2(\"\3\2\2\2(%"+
		"\3\2\2\2)\t\3\2\2\2*+\7\t\2\2+,\5\4\3\2,-\7\4\2\2->\3\2\2\2.>\7\r\2\2"+
		"/\61\7\7\2\2\60\62\7\r\2\2\61\60\3\2\2\2\62\63\3\2\2\2\63\61\3\2\2\2\63"+
		"\64\3\2\2\2\64\65\3\2\2\2\65>\7\3\2\2\668\7\b\2\2\679\7\r\2\28\67\3\2"+
		"\2\29:\3\2\2\2:8\3\2\2\2:;\3\2\2\2;<\3\2\2\2<>\7\n\2\2=*\3\2\2\2=.\3\2"+
		"\2\2=/\3\2\2\2=\66\3\2\2\2>\13\3\2\2\2\b\24\33(\63:=";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}