import org.antlr.v4.runtime.tree.ParseTree;
import java.util.*;

public class DFAEngine {
    
    private ArrayList<Leaf> leafs;
    private char[] text;
    
    public DFAEngine(ParseTree tree, String text) {
        MasterVisitorDFA m = new MasterVisitorDFA();
        this.leafs = m.getLeafs(tree);
        this.text = text.toCharArray();
        
    }

    public MatchingResult run() {   
        this.showLeaf();
        int result;
        ArrayList<Leaf> first = new ArrayList<Leaf>();
        for (Leaf l : this.leafs){
            if (l.isFirst()){
                first.add(l);
            }
        }
        ArrayList<Leaf> curr = new ArrayList<Leaf>();
        ArrayList<Leaf> next = new ArrayList<Leaf>();
        ArrayList<Integer> nextInt = new ArrayList<Integer>();
        
        for (int i=0; i<this.text.length; i++){
            result = -1;
            curr.clear();
            for (Leaf l : first){
                curr.add(l);
            }
            for (int j=i; j<this.text.length; j++){
                next.clear();
                for (Leaf l : curr){
                    if (l.getLeaf().equals(String.valueOf(this.text[j])) || l.getLeaf().equals(".")){
                        next.add(l);
                    }
                }
                if (next.isEmpty()){
                    break;
                }
                nextInt.clear();
                for (Leaf l : next){
                    nextInt.addAll(l.getNext());
                    if (l.isLast()){
                        result = j+1;
                    }
                }
                HashSet<Integer> hashSet = new HashSet<Integer>(nextInt);
                nextInt.clear();
                nextInt.addAll(hashSet);
                curr.clear();
                for (Integer in : nextInt){
                    curr.add(this.leafs.get(in));
                }
            }
            if (result != -1){
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
            System.out.print("\n");
            j++;
        }
    }
        

}
