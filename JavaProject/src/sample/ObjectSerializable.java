package sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Circle implements Serializable {
	int xPos;
	int yPos;
	double rad;
	// hide from serializable
	transient int secretInfo;
	
	public Circle(int x, int y, double r){
		xPos = x;
		yPos = y;
		rad = r;
		secretInfo = 100;
	}
	
	public void showCircleInfo() {
		System.out.printf("[%d, %d] \n", xPos, yPos);
		System.out.println("rad: " + rad);
		System.out.println("Secret Info: " + secretInfo);
	}
}

public class ObjectSerializable {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("object.ser"));
		out.writeObject(new Circle(1,1,2.4));
		out.writeObject(new Circle(2,2,4.8));
		out.writeObject(new String("String implements Serializable"));
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("object.ser"));
		Circle circle1 = (Circle)in.readObject();
		Circle circle2 = (Circle)in.readObject();
		String message = (String)in.readObject();
		in.close();
		
		circle1.showCircleInfo();
		circle2.showCircleInfo();
		System.out.println(message);
	}
}