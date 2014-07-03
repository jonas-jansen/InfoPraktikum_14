import java.util.*;

public class Leaf {
    
    private String leaf, star;
    private boolean isFirst, isLast;
    private boolean[] isFirstOfKlammer, isLastOfKlammer;
    private ArrayList<Integer> next;
    private ArrayList<Integer> klammer;

    public Leaf(String a) {
        this(a, 0, false, false, new ArrayList<Integer>(), new ArrayList<Integer>());
    }

    public Leaf(String a, int kC, ArrayList<Integer> klammer) {
        this(a, kC, false, false, new ArrayList<Integer>(), klammer);
    }

    public Leaf(String a, int kC, boolean first, boolean last, ArrayList<Integer> next, ArrayList<Integer> klammer) {
        this.leaf = a;
        this.isFirstOfKlammer = new boolean[kC];
        this.isLastOfKlammer = new boolean[kC];
        this.isFirst = first;
        this.isLast = last;
        this.next = next;
        this.klammer = klammer;
        this.star = "";
    }

    public String getLeaf() {
        return this.leaf;
    }

    public boolean isFirst() {
        return this.isFirst;
    }

    public void setFirst(boolean first) {
        this.isFirst = first;
    } 

    public boolean isLast() {
        return this.isLast;
    }

    public void setLast(boolean last) {
        this.isLast = last;
    }

    public ArrayList<Integer> getNext() {
        return this.next;
    }

    public void setNext(ArrayList<Integer> next) {
        this.next = next;
    }

    public ArrayList<Integer> getKlammer() {
        return this.klammer;
    }

    public boolean[] isFirstOfKlammer() {
        return this.isFirstOfKlammer;
    }

    public boolean isFirstOfKlammer(int i) {
        return this.isFirstOfKlammer[i];
    }

    public void setFirstOfKlammer(int i, boolean first) {
        this.isFirstOfKlammer[i] = first;
    }
    
    public boolean[] isLastOfKlammer() {
        return this.isLastOfKlammer();
    }
    
    public boolean isLastOfKlammer(int i) {
        return this.isLastOfKlammer[i];
    }
    
    public void setLastOfKlammer(int i, boolean last) {
        this.isLastOfKlammer[i] = last;
    }
    
    public String getStar() {
        return this.star;
    }
    
    public void setStar(String str) {
        this.star = str;
    }

}
