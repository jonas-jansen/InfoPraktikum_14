import org.antlr.v4.runtime.tree.ParseTree;
import java.util.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BNFAEngine {

    private ArrayList<Leaf> leafs;
    private char[] text;
    
    public BNFAEngine(ParseTree tree, String text) {
        MasterVisitor m = new MasterVisitor();
        this.leafs = m.getLeafs(tree);
        this.text = text.toCharArray();
        
    }

    public MatchingResult run() {   
//         this.showLeaf();
        ArrayList<Leaf> first = new ArrayList<Leaf>();
        for (Leaf l : this.leafs){
            if (l.isFirst()){
                first.add(l);
            }
        }
        Collections.reverse(first);
		boolean back;
        Stack stack;
        stackEntry next;
		ArrayList<Integer> nextInt = new ArrayList<Integer>();
        
        for (int i=0; i<this.text.length; i++){
            stack = new Stack();
            for (Leaf l : first){
                stack.push(new stackEntry(i,l));
            }
            int j=i;
            while (!stack.isEmpty()){
				back = false;
                next = (stackEntry)stack.pop();
                j = next.getI();
                if (j >= this.text.length || !(next.getLeaf().getLeaf().equals(String.valueOf(this.text[j])) 
                							  || next.getLeaf().getLeaf().equals("."))) {
                    continue;
                }
                j++;
                nextInt = next.getLeaf().getNext();
                Collections.reverse(nextInt);
                for (Integer in : nextInt){
                    stack.push(new stackEntry(j,this.leafs.get(in)));
					if (j < this.text.length && (this.leafs.get(in).getLeaf().equals(String.valueOf(this.text[j])) 
												||  this.leafs.get(in).getLeaf().equals("."))){
						back = true;
					}
                }
                Collections.sort(nextInt);
                if (!back && next.getLeaf().isLast()){
                    return new MatchingResult(i,String.valueOf(this.text).substring(i,j));
 				}
            }
		}
        
        return new MatchingResult(-1,"");
    }
    
    public void showLeaf() {
        int j = 0;
        for(Leaf l : leafs) {
            System.out.print(((j<10)?" ":"") + j + ": " + l.getLeaf() + "\tfirst: " + l.isFirst() + 
                                 "\tlast: " + l.isLast() + "\tnext: ");
            for (Integer i : l.getNext()){
                System.out.print(i + " ");
            }
            System.out.print("\n");
            j++;
        }
    }

}

class stackEntry{
    
    private Leaf leaf;
    private int i;
    
    public stackEntry(int i, Leaf leaf){
        this.leaf = leaf;
        this.i = i;
    }
    
    public Leaf getLeaf(){
        return this.leaf;
    }
    
    public int getI(){
        return this.i;
    }
}
