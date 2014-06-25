import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

public class MasterVisitorDFA extends regularExpressionBaseVisitor<Boolean> {

    private ArrayList<Leaf> leafs = new ArrayList<Leaf>();
	
	public ArrayList<Leaf> getLeafs(ParseTree tree){
        this.visit(tree);
        regFirstVisitor fv = new regFirstVisitor(leafs);
        this.leafs = fv.getLeafs(tree);
        regLastVisitor lv = new regLastVisitor(leafs);
        this.leafs = lv.getLeafs(tree);
        regNextVisitor nv = new regNextVisitor(leafs);
        this.leafs = nv.getLeafs(tree);
        
        return this.leafs;
    }

	@Override
    public Boolean visitStart(regularExpressionParser.StartContext ctx) { 
        visit(ctx.altn()); 
        return true;
    }
    
    @Override
    public Boolean visitAltn(regularExpressionParser.AltnContext ctx) { 
        for(regularExpressionParser.ConcatContext c : ctx.concat()) {
            visit(c);
        }       
        return true;
    }   

    @Override
    public Boolean visitConcat(regularExpressionParser.ConcatContext ctx) { 
        for(regularExpressionParser.StarredContext s : ctx.starred()) {
            visit(s);
        }       
        return true; 
    }

    @Override
    public Boolean visitStar(regularExpressionParser.StarContext ctx) { 
        visit(ctx.exp());
        return true;
    }
    
    @Override
    public Boolean visitPlus(regularExpressionParser.PlusContext ctx) { 
    	visit(ctx.exp());
    	return true;
    }
    
    @Override 
    public Boolean visitQues(regularExpressionParser.QuesContext ctx) { 
    	visit(ctx.exp());
    	return true;
    }

    @Override   
    public Boolean visitExpr(regularExpressionParser.ExprContext ctx) { 
        visit(ctx.exp());
        return true;
    }

    @Override
    public Boolean visitGroup(regularExpressionParser.GroupContext ctx) { 
        visit(ctx.altn());
		return true;
    }
    
    @Override 
    public Boolean visitOrexp(regularExpressionParser.OrexpContext ctx) { 
    	List<TerminalNode> symbols = ctx.SYMB();
    	for(TerminalNode s : symbols) {
    		this.leafs.add(new Leaf(s.getText()));
    	}
    	return true;
    }

    @Override
    public Boolean visitSymbol(regularExpressionParser.SymbolContext ctx) { 
        this.leafs.add(new Leaf(ctx.SYMB().getText()));
        return true;
    }
    
    @Override
    public Boolean visitReku(regularExpressionParser.RekuContext ctx) {
        this.leafs.add(new Leaf("#" + ctx.INT().getText()));
        return true;
    }
}
