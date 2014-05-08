import java.util.*;

public class regFirstVisitor extends regularExpressionBaseVisitor<T> {
	
	ArrayList<Leaf> leafs;

	public regFirstVisitor (ArrayList<Leaf> leafs) {
		super();
		this.leafs = leafs;
	}

	@Override
	public T visitStart(regularExpressionParser.StartContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override
	public T visitAltn(regularExpressionParser.AltnContext ctx) { 
		return visitChildren(ctx); 
	}	

	@Override
	public T visitConcat(regularExpressionParser.ConcatContext ctx) { 
		return visitChildren(ctx); 
	}

	@Override
	public T visitStar(regularExpressionParser.StarContext ctx) { 
		return visitChildren(ctx); 
	}

	@Override	
	public T visitExpr(regularExpressionParser.ExprContext ctx) { 
		return visitChildren(ctx); 
	}

	@Override
	public T visitGroup(regularExpressionParser.GroupContext ctx) { 
		return visitChildren(ctx); 
	}

	@Override
	public T visitSymbol(regularExpressionParser.SymbolContext ctx) { 
		return visitChildren(ctx); 
	}
}
