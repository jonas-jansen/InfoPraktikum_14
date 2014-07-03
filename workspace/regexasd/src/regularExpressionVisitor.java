// Generated from regularExpression.g4 by ANTLR 4.1
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link regularExpressionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface regularExpressionVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link regularExpressionParser#reku}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReku(@NotNull regularExpressionParser.RekuContext ctx);

	/**
	 * Visit a parse tree produced by {@link regularExpressionParser#plus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlus(@NotNull regularExpressionParser.PlusContext ctx);

	/**
	 * Visit a parse tree produced by {@link regularExpressionParser#symbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbol(@NotNull regularExpressionParser.SymbolContext ctx);

	/**
	 * Visit a parse tree produced by {@link regularExpressionParser#orexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrexp(@NotNull regularExpressionParser.OrexpContext ctx);

	/**
	 * Visit a parse tree produced by {@link regularExpressionParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(@NotNull regularExpressionParser.StartContext ctx);

	/**
	 * Visit a parse tree produced by {@link regularExpressionParser#star}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStar(@NotNull regularExpressionParser.StarContext ctx);

	/**
	 * Visit a parse tree produced by {@link regularExpressionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(@NotNull regularExpressionParser.ExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link regularExpressionParser#group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup(@NotNull regularExpressionParser.GroupContext ctx);

	/**
	 * Visit a parse tree produced by {@link regularExpressionParser#concat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcat(@NotNull regularExpressionParser.ConcatContext ctx);

	/**
	 * Visit a parse tree produced by {@link regularExpressionParser#altn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAltn(@NotNull regularExpressionParser.AltnContext ctx);

	/**
	 * Visit a parse tree produced by {@link regularExpressionParser#ques}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQues(@NotNull regularExpressionParser.QuesContext ctx);
}