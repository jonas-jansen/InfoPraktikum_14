// Generated from regularExpression.g4 by ANTLR 4.1
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
		T__3=1, T__2=2, T__1=3, T__0=4, SYMB=5, WS=6;
	public static final String[] tokenNames = {
		"<INVALID>", "')'", "'*'", "'('", "'|'", "SYMB", "WS"
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
			while (_la==4) {
				{
				{
				setState(14); match(4);
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
			while (_la==3 || _la==SYMB) {
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
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public StarredContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_starred; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regularExpressionListener ) ((regularExpressionListener)listener).enterStarred(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regularExpressionListener ) ((regularExpressionListener)listener).exitStarred(this);
		}
	}

	public final StarredContext starred() throws RecognitionException {
		StarredContext _localctx = new StarredContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_starred);
		try {
			setState(32);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(28); exp();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(29); exp();
				setState(30); match(2);
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
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_exp);
		try {
			setState(39);
			switch (_input.LA(1)) {
			case 3:
				_localctx = new GroupContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(34); match(3);
				setState(35); altn();
				setState(36); match(1);
				}
				break;
			case SYMB:
				_localctx = new SymbolContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(38); match(SYMB);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\b,\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\3\3\3\3\3\7\3\23\n\3\f\3\16\3"+
		"\26\13\3\3\4\3\4\7\4\32\n\4\f\4\16\4\35\13\4\3\5\3\5\3\5\3\5\5\5#\n\5"+
		"\3\6\3\6\3\6\3\6\3\6\5\6*\n\6\3\6\2\7\2\4\6\b\n\2\2*\2\f\3\2\2\2\4\17"+
		"\3\2\2\2\6\27\3\2\2\2\b\"\3\2\2\2\n)\3\2\2\2\f\r\5\4\3\2\r\16\7\2\2\3"+
		"\16\3\3\2\2\2\17\24\5\6\4\2\20\21\7\6\2\2\21\23\5\6\4\2\22\20\3\2\2\2"+
		"\23\26\3\2\2\2\24\22\3\2\2\2\24\25\3\2\2\2\25\5\3\2\2\2\26\24\3\2\2\2"+
		"\27\33\5\b\5\2\30\32\5\b\5\2\31\30\3\2\2\2\32\35\3\2\2\2\33\31\3\2\2\2"+
		"\33\34\3\2\2\2\34\7\3\2\2\2\35\33\3\2\2\2\36#\5\n\6\2\37 \5\n\6\2 !\7"+
		"\4\2\2!#\3\2\2\2\"\36\3\2\2\2\"\37\3\2\2\2#\t\3\2\2\2$%\7\5\2\2%&\5\4"+
		"\3\2&\'\7\3\2\2\'*\3\2\2\2(*\7\7\2\2)$\3\2\2\2)(\3\2\2\2*\13\3\2\2\2\6"+
		"\24\33\")";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}