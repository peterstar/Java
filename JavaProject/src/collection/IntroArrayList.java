package collection;

import java.util.ArrayList;

public class IntroArrayList {
	public static void main(String[] args) {
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		
		arrlist.add(new Integer(1));
		arrlist.add(new Integer(2));
		arrlist.add(new Integer(3));
		// allow duplicate 
		arrlist.add(new Integer(3));
		
		System.out.println("ArrayList: ");
		for(int i=0; i<arrlist.size(); i++){
			System.out.println(arrlist.get(i));
		}
 
		arrlist.remove(2);
		// maintain sequence
		System.out.println("ArrayList 2nd: ");
		for(int i=0; i<arrlist.size(); i++){
			System.out.println(arrlist.get(i));			
		}

	}
}