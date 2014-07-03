import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MasterVisitorBNFA extends regularExpressionBaseVisitor<Boolean> {

    private ArrayList<Leaf> leafs = new ArrayList<Leaf>();
    private ArrayList<Integer> klammer = new ArrayList<Integer>();
    private Stack stack = new Stack();
	private boolean[] greatStar;
    private int klammerCounter;

    public MasterVisitorBNFA(int klammerCounter) {
        super();
        this.greatStar = new boolean[klammerCounter];
        this.klammerCounter = -1;
    }

    public ArrayList<Leaf> getLeafs(ParseTree tree){
        this.visit(tree);
        regFirstVisitor fv = new regFirstVisitor(leafs);
        this.leafs = fv.getLeafs(tree);
        regLastVisitor lv = new regLastVisitor(leafs);
        this.leafs = lv.getLeafs(tree);
        regNextVisitor nv = new regNextVisitor(leafs);
        this.leafs = nv.getLeafs(tree);
        klammerVisitor kv = new klammerVisitor(leafs);
        this.leafs = kv.getLeafs(tree);
        
        return this.leafs;
    }

    public boolean[] getGreatStar() {
		while (!stack.empty()) {
			int kC = (Integer)stack.pop();
			this.greatStar[kC] = this.greatStar[kC + 1];
		}
		return this.greatStar;
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
        this.klammerCounter++;
        int kC = this.klammerCounter;
        this.klammer.add(kC);       
        if (ctx.altn().getChildCount() == 1 
                && ctx.altn().getChild(0).getChildCount() == 1 
                && ctx.altn().getChild(0).getChild(0).getChildCount() == 2 
                && !ctx.altn().getChild(0).getChild(0).getChild(1).getText().equals("?")){
            this.greatStar[kC] = true;
        }
		else if (ctx.altn().getChildCount() == 1 
                && ctx.altn().getChild(0).getChildCount() == 1 
                && ctx.altn().getChild(0).getChild(0).getChildCount() == 1 
                && ctx.altn().getChild(0).getChild(0).getChild(0) instanceof regularExpressionParser.GroupContext  ){
			stack.push(kC);
		}
        else {
            this.greatStar[kC] = false;
        }
        visit(ctx.altn());
        this.klammer.remove(new Integer(kC));
        return true;
    }
    
    @Override 
    public Boolean visitOrexp(regularExpressionParser.OrexpContext ctx) { 
        List<TerminalNode> symbols = ctx.SYMB();
        for(TerminalNode s : symbols) {
            this.leafs.add(new Leaf(s.getText(),this.greatStar.length,new ArrayList<Integer>(this.klammer)));
        }
        return true;
    }

    @Override
    public Boolean visitSymbol(regularExpressionParser.SymbolContext ctx) { 
        this.leafs.add(new Leaf(ctx.SYMB().getText(),this.greatStar.length,new ArrayList<Integer>(this.klammer)));
        return true;
    }
    
    @Override
    public Boolean visitReku(regularExpressionParser.RekuContext ctx) {
		List<TerminalNode> symbols = ctx.SYMB();
        String str = "";
		for(TerminalNode s : symbols) {
            str = str + s.getText();
        }
        this.leafs.add(new Leaf("#" + str,this.greatStar.length,new ArrayList<Integer>(this.klammer)));
        return true;
    }
}
