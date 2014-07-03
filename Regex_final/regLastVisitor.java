import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class regLastVisitor extends regularExpressionBaseVisitor<Boolean> {
    
    private ArrayList<Leaf> leafs;
    private int counter;
    private boolean isLast;

    public regLastVisitor (ArrayList<Leaf> leafs) {
        super();
        this.leafs = leafs;
        this.counter = 0;
        this.isLast = true;
        Collections.reverse(this.leafs);
    }

    public ArrayList<Leaf> getLeafs(ParseTree tree){
        this.visit(tree);
        Collections.reverse(this.leafs);
        return this.leafs;
    }

    @Override
    public Boolean visitStart(regularExpressionParser.StartContext ctx) { 
        visit(ctx.altn()); 
        return true;
    }
    
    @Override
    public Boolean visitAltn(regularExpressionParser.AltnContext ctx) { 
        boolean last = this.isLast;
        int i = 0;
        List<regularExpressionParser.ConcatContext> con = ctx.concat();
        Collections.reverse(con);
        for(regularExpressionParser.ConcatContext c : con) {
            this.isLast = last;
            if (!visit(c)){
                i++;
            }
        }       
        return i == 0;
    }   

    @Override
    public Boolean visitConcat(regularExpressionParser.ConcatContext ctx) { 
        boolean last = this.isLast;
        int i = 0;
        List<regularExpressionParser.StarredContext> sta = ctx.starred();
        Collections.reverse(sta);
        for(regularExpressionParser.StarredContext s : sta) {
            if (i == 0){
                this.isLast = last;
            }
            else {
                this.isLast = false;
            }
            if (visit(s)){
                i++;
            }
        }       
        return i != 0; 
    }

    @Override   
    public Boolean visitExpr(regularExpressionParser.ExprContext ctx) { 
        return visit(ctx.exp());
    }

    @Override
    public Boolean visitStar(regularExpressionParser.StarContext ctx) { 
        visit(ctx.exp());
        return false;
    }
    
    @Override
    public Boolean visitPlus(regularExpressionParser.PlusContext ctx) { 
    	return visit(ctx.exp());
    }
    
    @Override 
    public Boolean visitQues(regularExpressionParser.QuesContext ctx) { 
    	visit(ctx.exp()); 
    	return false; 
    }

    @Override
    public Boolean visitGroup(regularExpressionParser.GroupContext ctx) { 
        return visit(ctx.altn());
    }
    
    @Override 
    public Boolean visitOrexp(regularExpressionParser.OrexpContext ctx) { 
    	List<TerminalNode> symbols = ctx.SYMB();
    	for(TerminalNode s : symbols) {
    		Leaf leaf = this.leafs.get(this.counter);
            leaf.setLast(this.isLast);
            this.leafs.set(this.counter,leaf);
            this.counter++;
    	}
    	return true; 
    }

    @Override
    public Boolean visitSymbol(regularExpressionParser.SymbolContext ctx) { 
        Leaf leaf = this.leafs.get(this.counter);
        leaf.setLast(isLast);
        this.leafs.set(this.counter,leaf);
        this.counter++;
        return true;
    }
    
    @Override
    public Boolean visitReku(regularExpressionParser.RekuContext ctx) {
        Leaf leaf = this.leafs.get(this.counter);
        leaf.setLast(isLast);
        this.leafs.set(this.counter,leaf);
        this.counter++;
        return true;
    }
}
