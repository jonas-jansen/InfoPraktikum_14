import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class regNextVisitor extends regularExpressionBaseVisitor<Boolean> {
    
    private ArrayList<Leaf> leafs;
    private int counter, position, level;
    private boolean isNext, reverse, star;

    public regNextVisitor (ArrayList<Leaf> leafs) {
        super();
        this.leafs = leafs;
        this.counter = 0;
        this.level = 0;
        this.isNext = false;
        this.star = false;
    }

    public ArrayList<Leaf> getLeafs(ParseTree tree){
        reverse = false;
        for (int i=0; i<leafs.size(); i++){
            position = i;
            this.counter = 0;
            this.isNext = false;
            this.visit(tree);
        }
        reverse = true;
        Collections.reverse(this.leafs);
        for (int i=0; i<leafs.size(); i++){
            position = i;
            this.counter = 0;
            this.isNext = false;
            this.visit(tree);
            
            Leaf leaf = this.leafs.get(i);
            ArrayList<Integer> list = leaf.getNext();
            Collections.sort(list);
            HashSet<Integer> hashSet = new HashSet<Integer>(list);
            list.clear();
            list.addAll(hashSet);
            leaf.setNext(list);
            this.leafs.set(i,leaf);
        }
        
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
        if (reverse){
            boolean next = this.isNext, back = false;
            List<regularExpressionParser.ConcatContext> con = ctx.concat();
            Collections.reverse(con);
            for(regularExpressionParser.ConcatContext c : con) {
                this.isNext = next;
                back = !visit(c) || back;
                next = (back && this.star && this.level == 0) || next;
            }
            return !back;
        }        
        
        boolean next = this.isNext;
        boolean back = false;
        int i = 0;
        for(regularExpressionParser.ConcatContext c : ctx.concat()) {
            this.isNext = next;
            if (back && this.star && this.level == 0){
                this.isNext = true;
            }
            if (!visit(c)){
                back = true;
                i++;
            }
        }       
        return i == 0;
    }   

    @Override
    public Boolean visitConcat(regularExpressionParser.ConcatContext ctx) { 
        if (reverse){
            boolean back = false;
            int i = 0, j = 0;
            List<regularExpressionParser.StarredContext> sta = ctx.starred();
            for (regularExpressionParser.StarredContext s : sta) {
                if (s.getChildCount() != 2 || s.getChild(1).getText().equals("+")){
                    break;
                }
                j++;
            }
            Collections.reverse(sta);
            int size = sta.size() - j;
            
            if (this.isNext){            
                for(regularExpressionParser.StarredContext s : sta) {
                    this.isNext = false;
                    if (i >= size-1){
                        this.isNext = true;
                    }
                    visit(s);
                    i++;
                }
                return true;
            }
            
            j = 0;
            for(regularExpressionParser.StarredContext s : sta) {
                this.isNext = false;
                if (back && i+j >= size-1 && this.level == 0){
                    this.isNext = true;
                }
                if (!visit(s) && this.star && i == 0){
                    back = true;
                    if (size == 1 && this.level == 0){
                        Leaf leaf = this.leafs.get(this.position);
                        ArrayList<Integer> next = leaf.getNext();
                        next.add(this.leafs.size()-1-this.position);
                        leaf.setNext(next);
                        this.leafs.set(this.position,leaf);
                    }
                }
                if (s.getChildCount() != 2 || s.getChild(1).getText().equals("+")){
                    i++;
                }
                else {
                    j++;
                }
            }
            
            return !back;
        }
        
        for(regularExpressionParser.StarredContext s : ctx.starred()) {
            this.isNext = !visit(s);
        }       
        return !this.isNext; 
    }

    @Override   
    public Boolean visitExpr(regularExpressionParser.ExprContext ctx) { 
//         if (reverse){
//             
//             return true;
//         }
        this.level++;
        boolean back = visit(ctx.exp());
        this.level--;
        return back;
    }

    @Override
    public Boolean visitStar(regularExpressionParser.StarContext ctx) { 
        if (reverse){
            boolean pstar = this.star;
            boolean back;
            int lev = this.level;
            this.star = true;
            this.level = 0;
            back = visit(ctx.exp());
            this.star = pstar;
            this.level = lev;
            return back;
        }
        
        boolean next = this.isNext;
        boolean pstar = this.star;
        int lev = this.level;
        this.star = true;
        this.level = 0;
        next = !visit(ctx.exp()) || next;
        this.star = pstar;
        this.level = lev;
        return !(this.isNext || next);
    }
    
    @Override
    public Boolean visitPlus(regularExpressionParser.PlusContext ctx) { 
        if (reverse){
            boolean pstar = this.star;
            boolean back;
            int lev = this.level;
            this.star = true;
            this.level = 0;
            back = visit(ctx.exp());
            this.star = pstar;
            this.level = lev;
            return back;
        }
        
        boolean pstar = this.star;           //wenn in einem + ist das Verhalten gleich wie in einem *
        int lev = this.level;
        this.star = true;
        this.level = 0;
        visit(ctx.exp());
        this.star = pstar;
        this.level = lev;
        return !this.isNext;
    }
    
    @Override 
    public Boolean visitQues(regularExpressionParser.QuesContext ctx) { 
        this.level++;
        if (reverse){
            boolean back = visit(ctx.exp());
            this.level--;
            return back;
        }
        
        boolean next = this.isNext;
        next = !visit(ctx.exp()) || next;
        this.level--;
        return !(this.isNext || next);
    }

    @Override
    public Boolean visitGroup(regularExpressionParser.GroupContext ctx) { 
//         if (reverse){
//             
//             return true;
//         }
        return visit(ctx.altn());
    }
    
    @Override 
    public Boolean visitOrexp(regularExpressionParser.OrexpContext ctx) { 
        if (reverse){
            List<TerminalNode> symbols = ctx.SYMB();
            Collections.reverse(symbols);
            boolean localNext = this.isNext, localNext2 = false;
            for (TerminalNode s : symbols){
                if (this.counter == this.position && ctx.getParent().getChildCount() == 2 && !ctx.getParent().getChild(1).getText().equals("?")){
                    this.isNext = true;
                }
                if (this.isNext){
                    Leaf leaf = this.leafs.get(this.position);
                    ArrayList<Integer> next = leaf.getNext();
                    next.add(this.leafs.size()-1-this.counter);
                    leaf.setNext(next);
                    this.leafs.set(this.position,leaf);
                    localNext = false;
                }
                if (this.counter == this.position){
                    localNext2 = true;
                }
                this.counter++;
            }
            this.isNext = localNext || localNext2;
            return !this.isNext;
        }
        
        List<TerminalNode> symbols = ctx.SYMB();
        boolean localNext = this.isNext, localNext2 = false;
        for (TerminalNode s : symbols){
            if (this.counter == this.position && ctx.getParent().getChildCount() == 2 && !ctx.getParent().getChild(1).getText().equals("?")){
                this.isNext = true;
            }
            if (this.isNext){
                Leaf leaf = this.leafs.get(this.position);
                ArrayList<Integer> next = leaf.getNext();
                next.add(this.counter);
                leaf.setNext(next);
                this.leafs.set(this.position,leaf);
                localNext = false;
            }
            if (this.counter == this.position){
                localNext2 = true;
            }
            this.counter++;         
        }
        this.isNext = localNext || localNext2;
        return !this.isNext;
    }

    @Override
    public Boolean visitSymbol(regularExpressionParser.SymbolContext ctx) { 
        if (reverse){
            if (this.counter == this.position && ctx.getParent().getChildCount() == 2 && !ctx.getParent().getChild(1).getText().equals("?")){
                this.isNext = true;
            }
            if (this.isNext){
                Leaf leaf = this.leafs.get(this.position);
                ArrayList<Integer> next = leaf.getNext();
                next.add(this.leafs.size()-1-this.counter);
                leaf.setNext(next);
                this.leafs.set(this.position,leaf);
                this.isNext = false;
            }
            if (this.counter == this.position){
                this.counter++;
                return false;
            }
            this.counter++;
            return true;            
        }
        
        if (this.isNext){
            Leaf leaf = this.leafs.get(this.position);
            ArrayList<Integer> next = leaf.getNext();
            next.add(this.counter);
            leaf.setNext(next);
            this.leafs.set(this.position,leaf);
            this.isNext = false;
        }
        if (this.counter == this.position){
            this.isNext = true;
        }
        this.counter++;
        return !isNext;
    }
}
