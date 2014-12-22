package collection;

class Box<T> {
	public Box<T> nextBox;
	T item;
	
	public void store(T item) {
		this.item = item;
	}
	
	public T pullOut() {
		return item;
	}
}

public class SoSimpleLinkedListImpl {
	public static void main(String[] args) {
		Box<String> box = new Box<String>();
		box.store("first");
		
		box.nextBox = new Box<String>();		
		box.nextBox.store("second");
		
		box.nextBox.nextBox = new Box<String>();
		box.nextBox.nextBox.store("third");
		
		Box<String> boxRef;
		boxRef = box;
		String str = boxRef.pullOut();
		System.out.println(str);
		
		boxRef = box.nextBox;
		str = boxRef.pullOut();
		System.out.println(str);
		
		boxRef = box.nextBox.nextBox;
		str = boxRef.pullOut();
		System.out.println(str);
		
	}
}