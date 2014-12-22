package collection;

import java.util.LinkedList;

public class IntroLinkedList {
	public static void main(String[] args) {
		LinkedList<Integer> linkList = new LinkedList<Integer>();
		
		linkList.add(new Integer(11));
		linkList.add(new Integer(22));
		linkList.add(new Integer(33));
		linkList.add(new Integer(11));
				
		System.out.println("Linked List: ");
		for(int i=0; i<linkList.size(); i++){
			System.out.println(linkList.get(i));
		}
		
		linkList.remove(3);
		System.out.println("Linked List 2nd: ");
		for(int i=0; i<linkList.size(); i++){
			System.out.println(linkList.get(i));
		}
		
	}
}