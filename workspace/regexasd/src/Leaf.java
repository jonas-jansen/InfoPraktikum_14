import java.util.*;

public class Leaf {
	
	private String leaf;
	private boolean isFirst, isLast;
	private ArrayList<Integer> next;

	public Leaf(String a) {
		this.leaf = a;
		this.isFirst = false;
		this.isLast = false;
		this.next = new ArrayList<Integer>();
	}

	public Leaf(String a, boolean first, boolean last, ArrayList<Integer> next) {
		this.leaf = a;
		this.isFirst = first;
		this.isLast = last;
		this.next = next;
	}

	public String getLeaf() {
		return leaf;
	}

	public boolean isFirst() {
		return isFirst;
	}

	public void setFirst(boolean first) {
		this.isFirst = first;
	} 

	public boolean isLast() {
		return isLast;
	}

	public void setLast(boolean last) {
		this.isLast = last;
	}

	public ArrayList<Integer> getNext() {
		return next;
	}

	public void setNext(ArrayList<Integer> next) {
		this.next = next;
	}


}
