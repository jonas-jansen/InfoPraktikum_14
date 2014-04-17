// Generated from GOTO.g4 by ANTLR 4.2.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GOTOParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__11=1, T__10=2, T__9=3, T__8=4, T__7=5, T__6=6, T__5=7, T__4=8, T__3=9, 
		T__2=10, T__1=11, T__0=12, VAR=13, INT=14, NEWLINE=15, WS=16;
	public static final String[] tokenNames = {
		"<INVALID>", "'>'", "'GOTO'", "'+'", "'-'", "'*'", "'IF'", "'/'", "'=='", 
		"'<'", "'='", "';'", "'PRINT'", "VAR", "INT", "NEWLINE", "WS"
	};
	public static final int
		RULE_start = 0, RULE_exp = 1, RULE_zuw = 2, RULE_bool = 3, RULE_aus = 4;
	public static final String[] ruleNames = {
		"start", "exp", "zuw", "bool", "aus"
	};

	@Override
	public String getGrammarFileName() { return "GOTO.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GOTOParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(GOTOParser.NEWLINE); }
		public TerminalNode EOF() { return getToken(GOTOParser.EOF, 0); }
		public TerminalNode NEWLINE(int i) {
			return getToken(GOTOParser.NEWLINE, i);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GOTOListener ) ((GOTOListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GOTOListener ) ((GOTOListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(10); exp();
				setState(11); match(11);
				setState(12); match(NEWLINE);
				}
				}
				setState(16); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 6) | (1L << 12) | (1L << VAR))) != 0) );
			setState(18); match(EOF);
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
	public static class BedingungContext extends ExpContext {
		public TerminalNode INT() { return getToken(GOTOParser.INT, 0); }
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public BedingungContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GOTOListener ) ((GOTOListener)listener).enterBedingung(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GOTOListener ) ((GOTOListener)listener).exitBedingung(this);
		}
	}
	public static class ZuweisungContext extends ExpContext {
		public TerminalNode VAR() { return getToken(GOTOParser.VAR, 0); }
		public ZuwContext zuw() {
			return getRuleContext(ZuwContext.class,0);
		}
		public ZuweisungContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GOTOListener ) ((GOTOListener)listener).enterZuweisung(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GOTOListener ) ((GOTOListener)listener).exitZuweisung(this);
		}
	}
	public static class GotoContext extends ExpContext {
		public TerminalNode INT() { return getToken(GOTOParser.INT, 0); }
		public GotoContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GOTOListener ) ((GOTOListener)listener).enterGoto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GOTOListener ) ((GOTOListener)listener).exitGoto(this);
		}
	}
	public static class DruckContext extends ExpContext {
		public TerminalNode VAR() { return getToken(GOTOParser.VAR, 0); }
		public DruckContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GOTOListener ) ((GOTOListener)listener).enterDruck(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GOTOListener ) ((GOTOListener)listener).exitDruck(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_exp);
		try {
			setState(32);
			switch (_input.LA(1)) {
			case VAR:
				_localctx = new ZuweisungContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(20); match(VAR);
				setState(21); match(10);
				setState(22); zuw();
				}
				break;
			case 12:
				_localctx = new DruckContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(23); match(12);
				setState(24); match(VAR);
				}
				break;
			case 2:
				_localctx = new GotoContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(25); match(2);
				setState(26); match(INT);
				}
				break;
			case 6:
				_localctx = new BedingungContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(27); match(6);
				setState(28); bool();
				setState(29); match(2);
				setState(30); match(INT);
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

	public static class ZuwContext extends ParserRuleContext {
		public ZuwContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_zuw; }
	 
		public ZuwContext() { }
		public void copyFrom(ZuwContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MultiplicationContext extends ZuwContext {
		public List<AusContext> aus() {
			return getRuleContexts(AusContext.class);
		}
		public AusContext aus(int i) {
			return getRuleContext(AusContext.class,i);
		}
		public MultiplicationContext(ZuwContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GOTOListener ) ((GOTOListener)listener).enterMultiplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GOTOListener ) ((GOTOListener)listener).exitMultiplication(this);
		}
	}
	public static class SubtractionContext extends ZuwContext {
		public List<AusContext> aus() {
			return getRuleContexts(AusContext.class);
		}
		public AusContext aus(int i) {
			return getRuleContext(AusContext.class,i);
		}
		public SubtractionContext(ZuwContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GOTOListener ) ((GOTOListener)listener).enterSubtraction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GOTOListener ) ((GOTOListener)listener).exitSubtraction(this);
		}
	}
	public static class DivisionContext extends ZuwContext {
		public List<AusContext> aus() {
			return getRuleContexts(AusContext.class);
		}
		public AusContext aus(int i) {
			return getRuleContext(AusContext.class,i);
		}
		public DivisionContext(ZuwContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GOTOListener ) ((GOTOListener)listener).enterDivision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GOTOListener ) ((GOTOListener)listener).exitDivision(this);
		}
	}
	public static class AusdruckContext extends ZuwContext {
		public AusContext aus() {
			return getRuleContext(AusContext.class,0);
		}
		public AusdruckContext(ZuwContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GOTOListener ) ((GOTOListener)listener).enterAusdruck(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GOTOListener ) ((GOTOListener)listener).exitAusdruck(this);
		}
	}
	public static class AdditionContext extends ZuwContext {
		public List<AusContext> aus() {
			return getRuleContexts(AusContext.class);
		}
		public AusContext aus(int i) {
			return getRuleContext(AusContext.class,i);
		}
		public AdditionContext(ZuwContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GOTOListener ) ((GOTOListener)listener).enterAddition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GOTOListener ) ((GOTOListener)listener).exitAddition(this);
		}
	}

	public final ZuwContext zuw() throws RecognitionException {
		ZuwContext _localctx = new ZuwContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_zuw);
		int _la;
		try {
			setState(66);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new AusdruckContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(35);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(34); match(4);
					}
				}

				setState(37); aus();
				}
				break;

			case 2:
				_localctx = new AdditionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(38); match(4);
					}
				}

				setState(41); aus();
				setState(42); match(3);
				setState(43); aus();
				}
				break;

			case 3:
				_localctx = new SubtractionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(46);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(45); match(4);
					}
				}

				setState(48); aus();
				setState(49); match(4);
				setState(50); aus();
				}
				break;

			case 4:
				_localctx = new MultiplicationContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(53);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(52); match(4);
					}
				}

				setState(55); aus();
				setState(56); match(5);
				setState(57); aus();
				}
				break;

			case 5:
				_localctx = new DivisionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(60);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(59); match(4);
					}
				}

				setState(62); aus();
				setState(63); match(7);
				setState(64); aus();
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

	public static class BoolContext extends ParserRuleContext {
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
	 
		public BoolContext() { }
		public void copyFrom(BoolContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IstKleinerNumberContext extends BoolContext {
		public List<AusContext> aus() {
			return getRuleContexts(AusContext.class);
		}
		public AusContext aus(int i) {
			return getRuleContext(AusContext.class,i);
		}
		public IstKleinerNumberContext(BoolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GOTOListener ) ((GOTOListener)listener).enterIstKleinerNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GOTOListener ) ((GOTOListener)listener).exitIstKleinerNumber(this);
		}
	}
	public static class IstGroesserNumberContext extends BoolContext {
		public List<AusContext> aus() {
			return getRuleContexts(AusContext.class);
		}
		public AusContext aus(int i) {
			return getRuleContext(AusContext.class,i);
		}
		public IstGroesserNumberContext(BoolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GOTOListener ) ((GOTOListener)listener).enterIstGroesserNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GOTOListener ) ((GOTOListener)listener).exitIstGroesserNumber(this);
		}
	}
	public static class IstIdentischNumberContext extends BoolContext {
		public List<AusContext> aus() {
			return getRuleContexts(AusContext.class);
		}
		public AusContext aus(int i) {
			return getRuleContext(AusContext.class,i);
		}
		public IstIdentischNumberContext(BoolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GOTOListener ) ((GOTOListener)listener).enterIstIdentischNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GOTOListener ) ((GOTOListener)listener).exitIstIdentischNumber(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_bool);
		int _la;
		try {
			setState(89);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new IstIdentischNumberContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(68); aus();
				setState(69); match(8);
				setState(71);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(70); match(4);
					}
				}

				setState(73); aus();
				}
				break;

			case 2:
				_localctx = new IstGroesserNumberContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(75); aus();
				setState(76); match(1);
				setState(78);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(77); match(4);
					}
				}

				setState(80); aus();
				}
				break;

			case 3:
				_localctx = new IstKleinerNumberContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(82); aus();
				setState(83); match(9);
				setState(85);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(84); match(4);
					}
				}

				setState(87); aus();
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

	public static class AusContext extends ParserRuleContext {
		public AusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aus; }
	 
		public AusContext() { }
		public void copyFrom(AusContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VariableContext extends AusContext {
		public TerminalNode VAR() { return getToken(GOTOParser.VAR, 0); }
		public VariableContext(AusContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GOTOListener ) ((GOTOListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GOTOListener ) ((GOTOListener)listener).exitVariable(this);
		}
	}
	public static class NumberContext extends AusContext {
		public TerminalNode INT() { return getToken(GOTOParser.INT, 0); }
		public NumberContext(AusContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GOTOListener ) ((GOTOListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GOTOListener ) ((GOTOListener)listener).exitNumber(this);
		}
	}

	public final AusContext aus() throws RecognitionException {
		AusContext _localctx = new AusContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_aus);
		try {
			setState(93);
			switch (_input.LA(1)) {
			case VAR:
				_localctx = new VariableContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(91); match(VAR);
				}
				break;
			case INT:
				_localctx = new NumberContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(92); match(INT);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\22b\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\6\2\21\n\2\r\2\16\2\22\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3#\n\3\3\4\5\4"+
		"&\n\4\3\4\3\4\5\4*\n\4\3\4\3\4\3\4\3\4\3\4\5\4\61\n\4\3\4\3\4\3\4\3\4"+
		"\3\4\5\48\n\4\3\4\3\4\3\4\3\4\3\4\5\4?\n\4\3\4\3\4\3\4\3\4\5\4E\n\4\3"+
		"\5\3\5\3\5\5\5J\n\5\3\5\3\5\3\5\3\5\3\5\5\5Q\n\5\3\5\3\5\3\5\3\5\3\5\5"+
		"\5X\n\5\3\5\3\5\5\5\\\n\5\3\6\3\6\5\6`\n\6\3\6\2\2\7\2\4\6\b\n\2\2o\2"+
		"\20\3\2\2\2\4\"\3\2\2\2\6D\3\2\2\2\b[\3\2\2\2\n_\3\2\2\2\f\r\5\4\3\2\r"+
		"\16\7\r\2\2\16\17\7\21\2\2\17\21\3\2\2\2\20\f\3\2\2\2\21\22\3\2\2\2\22"+
		"\20\3\2\2\2\22\23\3\2\2\2\23\24\3\2\2\2\24\25\7\2\2\3\25\3\3\2\2\2\26"+
		"\27\7\17\2\2\27\30\7\f\2\2\30#\5\6\4\2\31\32\7\16\2\2\32#\7\17\2\2\33"+
		"\34\7\4\2\2\34#\7\20\2\2\35\36\7\b\2\2\36\37\5\b\5\2\37 \7\4\2\2 !\7\20"+
		"\2\2!#\3\2\2\2\"\26\3\2\2\2\"\31\3\2\2\2\"\33\3\2\2\2\"\35\3\2\2\2#\5"+
		"\3\2\2\2$&\7\6\2\2%$\3\2\2\2%&\3\2\2\2&\'\3\2\2\2\'E\5\n\6\2(*\7\6\2\2"+
		")(\3\2\2\2)*\3\2\2\2*+\3\2\2\2+,\5\n\6\2,-\7\5\2\2-.\5\n\6\2.E\3\2\2\2"+
		"/\61\7\6\2\2\60/\3\2\2\2\60\61\3\2\2\2\61\62\3\2\2\2\62\63\5\n\6\2\63"+
		"\64\7\6\2\2\64\65\5\n\6\2\65E\3\2\2\2\668\7\6\2\2\67\66\3\2\2\2\678\3"+
		"\2\2\289\3\2\2\29:\5\n\6\2:;\7\7\2\2;<\5\n\6\2<E\3\2\2\2=?\7\6\2\2>=\3"+
		"\2\2\2>?\3\2\2\2?@\3\2\2\2@A\5\n\6\2AB\7\t\2\2BC\5\n\6\2CE\3\2\2\2D%\3"+
		"\2\2\2D)\3\2\2\2D\60\3\2\2\2D\67\3\2\2\2D>\3\2\2\2E\7\3\2\2\2FG\5\n\6"+
		"\2GI\7\n\2\2HJ\7\6\2\2IH\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KL\5\n\6\2L\\\3\2"+
		"\2\2MN\5\n\6\2NP\7\3\2\2OQ\7\6\2\2PO\3\2\2\2PQ\3\2\2\2QR\3\2\2\2RS\5\n"+
		"\6\2S\\\3\2\2\2TU\5\n\6\2UW\7\13\2\2VX\7\6\2\2WV\3\2\2\2WX\3\2\2\2XY\3"+
		"\2\2\2YZ\5\n\6\2Z\\\3\2\2\2[F\3\2\2\2[M\3\2\2\2[T\3\2\2\2\\\t\3\2\2\2"+
		"]`\7\17\2\2^`\7\20\2\2_]\3\2\2\2_^\3\2\2\2`\13\3\2\2\2\17\22\"%)\60\67"+
		">DIPW[_";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}