// Generated from GOTO.g4 by ANTLR 4.2.2
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GOTOParser}.
 */
public interface GOTOListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GOTOParser#istKleinerNumber}.
	 * @param ctx the parse tree
	 */
	void enterIstKleinerNumber(@NotNull GOTOParser.IstKleinerNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link GOTOParser#istKleinerNumber}.
	 * @param ctx the parse tree
	 */
	void exitIstKleinerNumber(@NotNull GOTOParser.IstKleinerNumberContext ctx);

	/**
	 * Enter a parse tree produced by {@link GOTOParser#Multiplication}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication(@NotNull GOTOParser.MultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GOTOParser#Multiplication}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication(@NotNull GOTOParser.MultiplicationContext ctx);

	/**
	 * Enter a parse tree produced by {@link GOTOParser#Variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(@NotNull GOTOParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link GOTOParser#Variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(@NotNull GOTOParser.VariableContext ctx);

	/**
	 * Enter a parse tree produced by {@link GOTOParser#Number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(@NotNull GOTOParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link GOTOParser#Number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(@NotNull GOTOParser.NumberContext ctx);

	/**
	 * Enter a parse tree produced by {@link GOTOParser#Goto}.
	 * @param ctx the parse tree
	 */
	void enterGoto(@NotNull GOTOParser.GotoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GOTOParser#Goto}.
	 * @param ctx the parse tree
	 */
	void exitGoto(@NotNull GOTOParser.GotoContext ctx);

	/**
	 * Enter a parse tree produced by {@link GOTOParser#istIdentischNumber}.
	 * @param ctx the parse tree
	 */
	void enterIstIdentischNumber(@NotNull GOTOParser.IstIdentischNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link GOTOParser#istIdentischNumber}.
	 * @param ctx the parse tree
	 */
	void exitIstIdentischNumber(@NotNull GOTOParser.IstIdentischNumberContext ctx);

	/**
	 * Enter a parse tree produced by {@link GOTOParser#Druck}.
	 * @param ctx the parse tree
	 */
	void enterDruck(@NotNull GOTOParser.DruckContext ctx);
	/**
	 * Exit a parse tree produced by {@link GOTOParser#Druck}.
	 * @param ctx the parse tree
	 */
	void exitDruck(@NotNull GOTOParser.DruckContext ctx);

	/**
	 * Enter a parse tree produced by {@link GOTOParser#Bedingung}.
	 * @param ctx the parse tree
	 */
	void enterBedingung(@NotNull GOTOParser.BedingungContext ctx);
	/**
	 * Exit a parse tree produced by {@link GOTOParser#Bedingung}.
	 * @param ctx the parse tree
	 */
	void exitBedingung(@NotNull GOTOParser.BedingungContext ctx);

	/**
	 * Enter a parse tree produced by {@link GOTOParser#Subtraction}.
	 * @param ctx the parse tree
	 */
	void enterSubtraction(@NotNull GOTOParser.SubtractionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GOTOParser#Subtraction}.
	 * @param ctx the parse tree
	 */
	void exitSubtraction(@NotNull GOTOParser.SubtractionContext ctx);

	/**
	 * Enter a parse tree produced by {@link GOTOParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(@NotNull GOTOParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link GOTOParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(@NotNull GOTOParser.StartContext ctx);

	/**
	 * Enter a parse tree produced by {@link GOTOParser#Zuweisung}.
	 * @param ctx the parse tree
	 */
	void enterZuweisung(@NotNull GOTOParser.ZuweisungContext ctx);
	/**
	 * Exit a parse tree produced by {@link GOTOParser#Zuweisung}.
	 * @param ctx the parse tree
	 */
	void exitZuweisung(@NotNull GOTOParser.ZuweisungContext ctx);

	/**
	 * Enter a parse tree produced by {@link GOTOParser#Division}.
	 * @param ctx the parse tree
	 */
	void enterDivision(@NotNull GOTOParser.DivisionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GOTOParser#Division}.
	 * @param ctx the parse tree
	 */
	void exitDivision(@NotNull GOTOParser.DivisionContext ctx);

	/**
	 * Enter a parse tree produced by {@link GOTOParser#Ausdruck}.
	 * @param ctx the parse tree
	 */
	void enterAusdruck(@NotNull GOTOParser.AusdruckContext ctx);
	/**
	 * Exit a parse tree produced by {@link GOTOParser#Ausdruck}.
	 * @param ctx the parse tree
	 */
	void exitAusdruck(@NotNull GOTOParser.AusdruckContext ctx);

	/**
	 * Enter a parse tree produced by {@link GOTOParser#istGroesserNumber}.
	 * @param ctx the parse tree
	 */
	void enterIstGroesserNumber(@NotNull GOTOParser.IstGroesserNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link GOTOParser#istGroesserNumber}.
	 * @param ctx the parse tree
	 */
	void exitIstGroesserNumber(@NotNull GOTOParser.IstGroesserNumberContext ctx);

	/**
	 * Enter a parse tree produced by {@link GOTOParser#Addition}.
	 * @param ctx the parse tree
	 */
	void enterAddition(@NotNull GOTOParser.AdditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GOTOParser#Addition}.
	 * @param ctx the parse tree
	 */
	void exitAddition(@NotNull GOTOParser.AdditionContext ctx);
}