// Generated from GOTO.g4 by ANTLR 4.1
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GOTOVisitor ) return ((GOTOVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GOTOVisitor ) return ((GOTOVisitor<? extends T>)visitor).visitBedingung(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GOTOVisitor ) return ((GOTOVisitor<? extends T>)visitor).visitZuweisung(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GOTOVisitor ) return ((GOTOVisitor<? extends T>)visitor).visitGoto(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GOTOVisitor ) return ((GOTOVisitor<? extends T>)visitor).visitDruck(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GOTOVisitor ) return ((GOTOVisitor<? extends T>)visitor).visitMultiplication(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GOTOVisitor ) return ((GOTOVisitor<? extends T>)visitor).visitSubtraction(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GOTOVisitor ) return ((GOTOVisitor<? extends T>)visitor).visitDivision(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GOTOVisitor ) return ((GOTOVisitor<? extends T>)visitor).visitAusdruck(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GOTOVisitor ) return ((GOTOVisitor<? extends T>)visitor).visitAddition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ZuwContext zuw() throws RecognitionException {
		ZuwContext _localctx = new ZuwContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_zuw);
		int _la;
		try {
			setState(78);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
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
				setState(44);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(43); match(4);
					}
				}

				setState(46); aus();
				}
				break;

			case 3:
				_localctx = new SubtractionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(49);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(48); match(4);
					}
				}

				setState(51); aus();
				setState(52); match(4);
				setState(54);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(53); match(4);
					}
				}

				setState(56); aus();
				}
				break;

			case 4:
				_localctx = new MultiplicationContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(59);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(58); match(4);
					}
				}

				setState(61); aus();
				setState(62); match(5);
				setState(64);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(63); match(4);
					}
				}

				setState(66); aus();
				}
				break;

			case 5:
				_localctx = new DivisionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(69);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(68); match(4);
					}
				}

				setState(71); aus();
				setState(72); match(7);
				setState(74);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(73); match(4);
					}
				}

				setState(76); aus();
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GOTOVisitor ) return ((GOTOVisitor<? extends T>)visitor).visitIstKleinerNumber(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GOTOVisitor ) return ((GOTOVisitor<? extends T>)visitor).visitIstIdentischNumber(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GOTOVisitor ) return ((GOTOVisitor<? extends T>)visitor).visitIstGroesserNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_bool);
		int _la;
		try {
			setState(101);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new IstIdentischNumberContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(80); aus();
				setState(81); match(8);
				setState(83);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(82); match(4);
					}
				}

				setState(85); aus();
				}
				break;

			case 2:
				_localctx = new IstGroesserNumberContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(87); aus();
				setState(88); match(1);
				setState(90);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(89); match(4);
					}
				}

				setState(92); aus();
				}
				break;

			case 3:
				_localctx = new IstKleinerNumberContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(94); aus();
				setState(95); match(9);
				setState(97);
				_la = _input.LA(1);
				if (_la==4) {
					{
					setState(96); match(4);
					}
				}

				setState(99); aus();
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GOTOVisitor ) return ((GOTOVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GOTOVisitor ) return ((GOTOVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AusContext aus() throws RecognitionException {
		AusContext _localctx = new AusContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_aus);
		try {
			setState(105);
			switch (_input.LA(1)) {
			case VAR:
				_localctx = new VariableContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(103); match(VAR);
				}
				break;
			case INT:
				_localctx = new NumberContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(104); match(INT);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\22n\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\6\2\21\n\2\r\2\16\2\22\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3#\n\3\3\4\5\4"+
		"&\n\4\3\4\3\4\5\4*\n\4\3\4\3\4\3\4\5\4/\n\4\3\4\3\4\3\4\5\4\64\n\4\3\4"+
		"\3\4\3\4\5\49\n\4\3\4\3\4\3\4\5\4>\n\4\3\4\3\4\3\4\5\4C\n\4\3\4\3\4\3"+
		"\4\5\4H\n\4\3\4\3\4\3\4\5\4M\n\4\3\4\3\4\5\4Q\n\4\3\5\3\5\3\5\5\5V\n\5"+
		"\3\5\3\5\3\5\3\5\3\5\5\5]\n\5\3\5\3\5\3\5\3\5\3\5\5\5d\n\5\3\5\3\5\5\5"+
		"h\n\5\3\6\3\6\5\6l\n\6\3\6\2\7\2\4\6\b\n\2\2\177\2\20\3\2\2\2\4\"\3\2"+
		"\2\2\6P\3\2\2\2\bg\3\2\2\2\nk\3\2\2\2\f\r\5\4\3\2\r\16\7\r\2\2\16\17\7"+
		"\21\2\2\17\21\3\2\2\2\20\f\3\2\2\2\21\22\3\2\2\2\22\20\3\2\2\2\22\23\3"+
		"\2\2\2\23\24\3\2\2\2\24\25\7\2\2\3\25\3\3\2\2\2\26\27\7\17\2\2\27\30\7"+
		"\f\2\2\30#\5\6\4\2\31\32\7\16\2\2\32#\7\17\2\2\33\34\7\4\2\2\34#\7\20"+
		"\2\2\35\36\7\b\2\2\36\37\5\b\5\2\37 \7\4\2\2 !\7\20\2\2!#\3\2\2\2\"\26"+
		"\3\2\2\2\"\31\3\2\2\2\"\33\3\2\2\2\"\35\3\2\2\2#\5\3\2\2\2$&\7\6\2\2%"+
		"$\3\2\2\2%&\3\2\2\2&\'\3\2\2\2\'Q\5\n\6\2(*\7\6\2\2)(\3\2\2\2)*\3\2\2"+
		"\2*+\3\2\2\2+,\5\n\6\2,.\7\5\2\2-/\7\6\2\2.-\3\2\2\2./\3\2\2\2/\60\3\2"+
		"\2\2\60\61\5\n\6\2\61Q\3\2\2\2\62\64\7\6\2\2\63\62\3\2\2\2\63\64\3\2\2"+
		"\2\64\65\3\2\2\2\65\66\5\n\6\2\668\7\6\2\2\679\7\6\2\28\67\3\2\2\289\3"+
		"\2\2\29:\3\2\2\2:;\5\n\6\2;Q\3\2\2\2<>\7\6\2\2=<\3\2\2\2=>\3\2\2\2>?\3"+
		"\2\2\2?@\5\n\6\2@B\7\7\2\2AC\7\6\2\2BA\3\2\2\2BC\3\2\2\2CD\3\2\2\2DE\5"+
		"\n\6\2EQ\3\2\2\2FH\7\6\2\2GF\3\2\2\2GH\3\2\2\2HI\3\2\2\2IJ\5\n\6\2JL\7"+
		"\t\2\2KM\7\6\2\2LK\3\2\2\2LM\3\2\2\2MN\3\2\2\2NO\5\n\6\2OQ\3\2\2\2P%\3"+
		"\2\2\2P)\3\2\2\2P\63\3\2\2\2P=\3\2\2\2PG\3\2\2\2Q\7\3\2\2\2RS\5\n\6\2"+
		"SU\7\n\2\2TV\7\6\2\2UT\3\2\2\2UV\3\2\2\2VW\3\2\2\2WX\5\n\6\2Xh\3\2\2\2"+
		"YZ\5\n\6\2Z\\\7\3\2\2[]\7\6\2\2\\[\3\2\2\2\\]\3\2\2\2]^\3\2\2\2^_\5\n"+
		"\6\2_h\3\2\2\2`a\5\n\6\2ac\7\13\2\2bd\7\6\2\2cb\3\2\2\2cd\3\2\2\2de\3"+
		"\2\2\2ef\5\n\6\2fh\3\2\2\2gR\3\2\2\2gY\3\2\2\2g`\3\2\2\2h\t\3\2\2\2il"+
		"\7\17\2\2jl\7\20\2\2ki\3\2\2\2kj\3\2\2\2l\13\3\2\2\2\23\22\"%).\638=B"+
		"GLPU\\cgk";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}