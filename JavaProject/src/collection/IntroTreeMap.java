package collection;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeMap;

public class IntroTreeMap {
	public static void main(String[] args) {
		TreeMap<Integer, String> tMap = new TreeMap<Integer, String>();
		tMap.put(3, "sam");
		tMap.put(5, "oh");
		tMap.put(8, "pal");
		tMap.put(7, "chil");
		
		NavigableSet<Integer> navi = tMap.navigableKeySet();
		Iterator<Integer> itr = navi.iterator();
		while(itr.hasNext()){
			System.out.println(tMap.get(itr.next()));
		}
		
		itr = navi.descendingIterator();
		while(itr.hasNext()){
			System.out.println(tMap.get(itr.next()));
		}
	}
}