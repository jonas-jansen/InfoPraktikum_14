import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

public class klammerVisitor extends regularExpressionBaseVisitor<Boolean> {
    
    private ArrayList<Leaf> leafs;
    private ArrayList<Integer> klammer;
    private int counter, klammerCounter;
//     private boolean isFirst;

    public klammerVisitor (ArrayList<Leaf> leafs) {
        super();
        this.leafs = leafs;
        this.klammer = new ArrayList<Integer>();
        this.counter = 0;
        this.klammerCounter = -1;
//         this.isFirst = false;
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
//         boolean first = this.isFirst;
        ArrayList<Integer> kl = new ArrayList<Integer>(this.klammer);
        int i = 0;
        for(regularExpressionParser.ConcatContext c : ctx.concat()) {
//             this.isFirst = first;
            this.klammer = new ArrayList<Integer>(kl);
            if (!visit(c)){
                i++;
            }
        }    
        this.klammer = kl;
        return i == 0;
    }   

    @Override
    public Boolean visitConcat(regularExpressionParser.ConcatContext ctx) { 
//         boolean first = this.isFirst;
        ArrayList<Integer> kl = new ArrayList<Integer>(this.klammer);
        int i = 0;
        for(regularExpressionParser.StarredContext s : ctx.starred()) {
            if (i == 0){
//                 this.isFirst = first;
                this.klammer = new ArrayList<Integer>(kl);
            }
            else {
//                 this.isFirst = false;
                this.klammer = new ArrayList<Integer>();
            }
            if (visit(s)){
                i++;
            }
        }
        this.klammer = new ArrayList<Integer>(kl);
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
        this.klammerCounter++;
        int kC = this.klammerCounter;
        this.klammer.add(kC);
        boolean back = visit(ctx.altn());
        this.klammer.remove(new Integer(kC));
        return back;
    }
    
    @Override 
    public Boolean visitOrexp(regularExpressionParser.OrexpContext ctx) { 
    	List<TerminalNode> symbols = ctx.SYMB();
    	for(TerminalNode s : symbols) {
    		Leaf leaf = this.leafs.get(this.counter);
            for (Integer i : this.klammer){
                leaf.setFirstOfKlammer(i,true);
            }
            this.leafs.set(this.counter,leaf);
            this.counter++;
    	}
    	return true;
    }

    @Override
    public Boolean visitSymbol(regularExpressionParser.SymbolContext ctx) { 
        Leaf leaf = this.leafs.get(this.counter);
        for (Integer i : this.klammer){
            leaf.setFirstOfKlammer(i,true);
        }
        this.leafs.set(this.counter,leaf);
        this.counter++;
        return true;
    }
    
    @Override
    public Boolean visitReku(regularExpressionParser.RekuContext ctx) {
        Leaf leaf = this.leafs.get(this.counter);
        for (Integer i : this.klammer){
            leaf.setFirstOfKlammer(i,true);
        }
        this.leafs.set(this.counter,leaf);
        this.counter++;
        return true;
    }
}
