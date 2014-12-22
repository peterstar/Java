package collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class StrLenComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return o1.length() - o2.length();
	}
	
}


public class IntroComparator {
	public static void main(String[] args) {
		TreeSet<String> sTree = new TreeSet<String>(new StrLenComparator());
		sTree.add("Orange");
		sTree.add("Apple");
		sTree.add("Dog");
		sTree.add("Individual");
		
		Iterator<String> itr = sTree.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}