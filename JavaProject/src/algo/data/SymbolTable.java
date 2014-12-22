package algo.data;

import java.util.Iterator;
import java.util.TreeMap;

class ST<Key extends Comparable<Key>, Value> implements Iterable<Key> {
	private TreeMap<Key, Value> st;

	@Override
	public Iterator<Key> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int size(){
		return st.size();
	}
}

public class SymbolTable {
	
}