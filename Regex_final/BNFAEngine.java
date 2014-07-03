import org.antlr.v4.runtime.tree.ParseTree;
import java.util.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BNFAEngine {

    private ArrayList<Leaf> leafs;
	private boolean[] greatStar, lastVisited;
	private String[] klammerMatch;
    private char[] text;
    
    public BNFAEngine(ParseTree tree, String text, String regex) {
        MasterVisitorBNFA m = new MasterVisitorBNFA(this.klammerCount(regex));
        this.leafs = m.getLeafs(tree);
		this.greatStar = m.getGreatStar();
        this.text = text.toCharArray();
		
        this.lastVisited = new boolean[this.greatStar.length];
        this.klammerMatch = new String[this.greatStar.length];
	}

    public MatchingResult run() {   
        // this.showLeaf();
        ArrayList<Leaf> first = new ArrayList<Leaf>();
        for (Leaf l : this.leafs){
            if (l.isFirst()){
                first.add(l);
            }
        }
        Collections.reverse(first);
		boolean reku;
		int result;
        Stack stack, stringStack;
        stackEntry next;
		ArrayList<Integer> nextInt = new ArrayList<Integer>();
        
        for (int i=0; i<this.text.length; i++){
            stack = new Stack();
			stringStack = new Stack();
			result = -1;
			for (int k=0; k<this.klammerMatch.length; k++){
    			this.klammerMatch[k] = "";
    			this.lastVisited[k] = false;
    		}
            for (Leaf l : first){
                stack.push(new stackEntry(i,l));
				stringStack.push(this.klammerMatch.clone());
            }
            int j=i;
            while (!stack.isEmpty()){
				next = (stackEntry)stack.pop();
				this.klammerMatch = (String[])stringStack.pop();
                j = next.getI();
				reku = next.getLeaf().getLeaf().substring(0,1).equals("#");
                
				if (j >= this.text.length || !(next.getLeaf().getLeaf().equals(String.valueOf(this.text[j])) 
                							  || next.getLeaf().getLeaf().equals(".") || reku)) {
                    continue;
                }
                int k = 0; String match = "";
				if (reku) {
					k = Integer.valueOf(next.getLeaf().getLeaf().substring(1,next.getLeaf().getLeaf().length())) - 1;
					match = this.klammerMatch[k];
					
					if (j + match.length() - 1 >= this.text.length 
							|| !match.equals(String.valueOf(this.text).substring(j,j+match.length()))) {
						continue;
					}
					if (match.length() > 0) {
						j = j + match.length() - 1;
					}
				}
				
				for (Integer in : next.getLeaf().getKlammer()) {
					if (next.getLeaf().isFirstOfKlammer(in) && this.lastVisited[in] && !this.greatStar[in]) {
						this.klammerMatch[in] = "";
						this.lastVisited[in] = false;
					}
					if (reku) {
						this.klammerMatch[in] = this.klammerMatch[in] + match;
					}
					else {
						this.klammerMatch[in] = this.klammerMatch[in] + String.valueOf(text[j]);
					}
					if (next.getLeaf().isLastOfKlammer(in)) {
						this.lastVisited[in] = true;
					}
				}
				
                j++;
				if (next.getLeaf().isLast()){
                    result = j;
                    stack = new Stack();
					stringStack = new Stack();
 				}
                nextInt = next.getLeaf().getNext();
                Collections.reverse(nextInt);
                for (Integer in : nextInt){
                    stack.push(new stackEntry(j,this.leafs.get(in)));
					stringStack.push(this.klammerMatch.clone());
				}
                Collections.sort(nextInt);
            }
			if (result != -1 && result != i+1){
				return new MatchingResult(i,String.valueOf(this.text).substring(i,result));
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
			System.out.print("\tklammer: ");
			for (Integer i : l.getKlammer()){
				System.out.print(i + " ");
			}
			System.out.print("\tfKlammer: ");
			for (Boolean b : l.isFirstOfKlammer()){
				System.out.print(b + " ");
			}
            System.out.print("\tlKlammer: ");
			for (Boolean b : l.isLastOfKlammer()){
				System.out.print(b + " ");
			}
            System.out.print("\n");
            j++;
        }
		for (int i=0; i<this.greatStar.length; i++) {
			System.out.println(((i<10)?" ":"") + i + ": " + this.greatStar[i]);
		}
    }
	
	public int klammerCount(String text) {
		int count = 0;
		char[] t = text.toCharArray();
		
		for (char c : t) {
			if (c == '('){
				count++;
			}
		}
		
		return count;
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
