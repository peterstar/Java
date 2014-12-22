package algo.data;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
	private int number;
	private Node<Item> first;
	 	
	private class Node<Item> {
		private Item item;
		private Node<Item> next;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
}