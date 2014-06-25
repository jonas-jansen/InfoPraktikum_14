import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

public class regFirstVisitor extends regularExpressionBaseVisitor<Boolean> {
    
    private ArrayList<Leaf> leafs;
    private int counter;
    private boolean isFirst;

    public regFirstVisitor (ArrayList<Leaf> leafs) {
        super();
        this.leafs = leafs;
        this.counter = 0;
        this.isFirst = true;
    }

    public ArrayList<Leaf> getLeafs(ParseTree tree){
        this.visit(tree);
        return this.leafs;
    }

    @Override
    public Boolean visitStart(regularExpressionParser.StartContext ctx) { 
        visit(ctx.altn()); 
        return true;
    }
    
    @Override
    public Boolean visitAltn(regularExpressionParser.AltnContext ctx) { 
        boolean first = this.isFirst;
        int i = 0;
        for(regularExpressionParser.ConcatContext c : ctx.concat()) {
            this.isFirst = first;
            if (!visit(c)){
                i++;
            }
        }       
        return i == 0;
    }   

    @Override
    public Boolean visitConcat(regularExpressionParser.ConcatContext ctx) { 
        boolean first = this.isFirst;
        int i = 0;
        for(regularExpressionParser.StarredContext s : ctx.starred()) {
            if (i == 0){
                this.isFirst = first;
            }
            else {
                this.isFirst = false;
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
            leaf.setFirst(isFirst);
            this.leafs.set(this.counter,leaf);
            this.counter++;
    	}
    	return true;
    }

    @Override
    public Boolean visitSymbol(regularExpressionParser.SymbolContext ctx) { 
        Leaf leaf = this.leafs.get(this.counter);
        leaf.setFirst(isFirst);
        this.leafs.set(this.counter,leaf);
        this.counter++;
        return true;
    }
    
    @Override
    public Boolean visitReku(regularExpressionParser.RekuContext ctx) {
        Leaf leaf = this.leafs.get(this.counter);
        leaf.setFirst(isFirst);
        this.leafs.set(this.counter,leaf);
        this.counter++;
        return true;
    }
}
