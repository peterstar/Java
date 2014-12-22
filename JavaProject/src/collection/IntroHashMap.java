package collection;

import java.util.HashMap;

public class IntroHashMap {
	public static void main(String[] args) {
		HashMap<Integer, String> hMap = new HashMap<Integer, String>();
		hMap.put(new Integer(3), "3");
		hMap.put(5, "5");
		hMap.put(8, "8");
		
		System.out.println("Num: " + hMap.get(new Integer(3)));
		System.out.println("Num: " + hMap.get(5));
		System.out.println("Num: " + hMap.get(8));
		
		hMap.remove(5);
		System.out.println("Num: " + hMap.get(5));
	}
	
}