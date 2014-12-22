package sample;

class Orange {
	int sugarContent;
	public Orange(int n) {
		sugarContent = n;
	}
	
	public void showSugarContent() {
		System.out.println("Sugar: " + sugarContent);
	}
}

class Apple {
	int weight;
	public Apple(int n){
		weight = n;		
	}
	
	public void showWeight() {
		System.out.println("Weight: " + weight);
	}
}

class FruitBox <T> {
	T item;
	void setItem(T item) {
		this.item = item;
	}
	T getItem() {
		return item;
	}
}

class GenericBaseFruitBox {
	
	public static void main(String[] args) {
		FruitBox<Orange> ora = new FruitBox<Orange>();
		ora.setItem(new Orange(10));
		Orange orange = ora.getItem();
		orange.showSugarContent();
				
		FruitBox<Apple> app = new FruitBox<Apple>();
		app.setItem(new Apple(100));
		Apple apple = app.getItem();
		apple.showWeight();
	}

	
}