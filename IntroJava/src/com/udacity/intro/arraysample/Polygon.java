package com.udacity.intro.arraysample;

//Create a Polygon class. A polygon is a closed shape with lines joining the corner points.
//You will keep the points in an array list. Use object of java.awt.Point for the point.

//Polygon will have as an instance variable an ArrayList of Points to hold the points
//The constructor takes no parameters but initializes the instance variable
//
//The add method adds a Point to the polygon
//
//The perimeter method returns the perimeter of the polygon
//
//The draw method draws the polygon by connecting consecutive points and then
//connecting the last point to the first.
//
//No methods headers or javadoc is provided this time. You get to try your hand at writing a class almost from scratch
//
//Need help starting this question? In the lesson titled 
//"Starting points: Problem Set Questions", go to the
//problem titled "Problem Set 6 - Question 3" for some tips on 
//how to begin.
//

import java.util.ArrayList;
import java.awt.Point;
import java.awt.Canvas;

public class Polygon
{
  // TODO: provide the required constructor, instance variable, and methods
	ArrayList<Point> points;
	public Polygon() {
		points = new ArrayList<Point>();
	}
	
	public void add(Point point) {
		points.add(point);
	}
	
	public double perimeter() {
		double retVal = 0;
		for(int i=0; i<points.size()-1; i++) {
			retVal += points.get(i).distance(points.get(i+1));
		}
		return retVal;
	}
	
	public void draw() {
		int lastIndex = points.size()-1;
		Point first = points.get(0);
		Point last = points.get(lastIndex);
		// need Line class to draw line
		//Line lastLine = new Line(first.getX(), first.getY(), last.getX(), last.getY());
		for(int i=0; i<lastIndex; i++) {
			//points.get(i).translate((int)points.get(i+1).getX(), (int)points.get(i+1).getY());
			//points.get(i).setLocation(points.get(i+1));
			//points.get(i).move((int)points.get(i+1).getX(), (int)points.get(i+1).getY());
			
			//Line line = new Line(points.get(i).getX(), points.get(i).getY(), points.get(i+1).getX(), points.get(i+1).getY());
			//line.draw();
		}
		//lastLine.draw();
		
		//points.get(lastIndex).translate((int)points.get(0).getX(), (int)points.get(0).getY());
	}
}
