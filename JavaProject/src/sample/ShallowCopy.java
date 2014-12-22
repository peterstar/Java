package sample;

class Point implements Cloneable {
	private int xPos;
	private int yPos;
	
	public Point(int x, int y){
		xPos = x;
		yPos = y;
	}
	
	public void showPosition() {
		System.out.println("x : " + xPos + ", y: " + yPos);
	}
	
	public void setPos(int x, int y){
		xPos = x;
		yPos = y;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class Rectangle implements Cloneable {
	Point upperLeft, lowerRight;
	
	public Rectangle(int x1, int x2, int y1, int y2){
		upperLeft = new Point(x1, y1);
		lowerRight = new Point(x2, y2);
	}
	
	public void showPosition(){
		upperLeft.showPosition();
		lowerRight.showPosition();
	}
	
	public void setPos(int x1, int x2, int y1, int y2){
		upperLeft = new Point(x1, y1);
		lowerRight = new Point(x2, y2);
	}
	
	public Object clone() throws CloneNotSupportedException {
		Rectangle copy = (Rectangle)super.clone();
		copy.upperLeft = (Point)upperLeft.clone();
		copy.lowerRight = (Point)lowerRight.clone();		
		return copy;
		//return super.clone();
	}
}

class ShallowCopy {
	public static void main(String[] args){
		Rectangle org = new Rectangle(1, 1, 9, 9);
		Rectangle cpy;
		try {
			cpy = (Rectangle)org.clone();
			System.out.println("Orginal");
			org.showPosition();
			System.out.println("Copy");
			cpy.showPosition();
			org.setPos(2, 2, 7, 7);
			System.out.println("Orginal");
			org.showPosition();
			System.out.println("Copy");
			cpy.showPosition();
		} catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
	}
}