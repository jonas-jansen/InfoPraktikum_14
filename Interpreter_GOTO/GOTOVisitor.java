// Generated from GOTO.g4 by ANTLR 4.1
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GOTOParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GOTOVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GOTOParser#istKleinerNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIstKleinerNumber(@NotNull GOTOParser.IstKleinerNumberContext ctx);

	/**
	 * Visit a parse tree produced by {@link GOTOParser#Multiplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplication(@NotNull GOTOParser.MultiplicationContext ctx);

	/**
	 * Visit a parse tree produced by {@link GOTOParser#Variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(@NotNull GOTOParser.VariableContext ctx);

	/**
	 * Visit a parse tree produced by {@link GOTOParser#Number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(@NotNull GOTOParser.NumberContext ctx);

	/**
	 * Visit a parse tree produced by {@link GOTOParser#Goto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoto(@NotNull GOTOParser.GotoContext ctx);

	/**
	 * Visit a parse tree produced by {@link GOTOParser#Druck}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDruck(@NotNull GOTOParser.DruckContext ctx);

	/**
	 * Visit a parse tree produced by {@link GOTOParser#istIdentischNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIstIdentischNumber(@NotNull GOTOParser.IstIdentischNumberContext ctx);

	/**
	 * Visit a parse tree produced by {@link GOTOParser#Bedingung}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBedingung(@NotNull GOTOParser.BedingungContext ctx);

	/**
	 * Visit a parse tree produced by {@link GOTOParser#Subtraction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtraction(@NotNull GOTOParser.SubtractionContext ctx);

	/**
	 * Visit a parse tree produced by {@link GOTOParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(@NotNull GOTOParser.StartContext ctx);

	/**
	 * Visit a parse tree produced by {@link GOTOParser#Zuweisung}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitZuweisung(@NotNull GOTOParser.ZuweisungContext ctx);

	/**
	 * Visit a parse tree produced by {@link GOTOParser#Division}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivision(@NotNull GOTOParser.DivisionContext ctx);

	/**
	 * Visit a parse tree produced by {@link GOTOParser#Ausdruck}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAusdruck(@NotNull GOTOParser.AusdruckContext ctx);

	/**
	 * Visit a parse tree produced by {@link GOTOParser#istGroesserNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIstGroesserNumber(@NotNull GOTOParser.IstGroesserNumberContext ctx);

	/**
	 * Visit a parse tree produced by {@link GOTOParser#Addition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddition(@NotNull GOTOParser.AdditionContext ctx);
}