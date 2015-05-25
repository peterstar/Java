package com.udacity.intro.moreclass;

//BlueJ project: lesson8/carshare3

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation
{
 private ArrayList<Car> cars;
 private ArrayList<Person> people;

 public Simulation()
 {
     cars = new ArrayList<Car>();
     people = new ArrayList<Person>();
 }
 
 public static void main(String[] args) {	 
	 Simulation sim = new Simulation();
	 File file = new File("C:/Users/David/workspace/IntroJava/src/com/udacity/intro/moreclass/CarSimulationData.txt");
	 try {
		sim.read(new Scanner(file));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 sim.loadPassengers();
	 sim.driveCars();
 }

 /**
    Reads the car and person data. Each row has the format
    n    Driver or Passenger Name   Destination
    where n is the number of seats for a car,
    0 for a passenger, -1 to signify the end of input.
    @param in the scanner to read from
 */
 public void read(Scanner in)
 {
     boolean done = false;
     System.out.println("Enter input of the form n Name Destination");
     System.out.println("n > 0: Car with n seats, n = 0: Passenger, n = -1: End of input");
     while (!done)
     {
         int capacity = in.nextInt();
         if (capacity == -1)
         {
             done = true;
         }
         else
         {
             String name = in.next();
             int destination = in.nextInt();
             if (capacity == 0)
             {
                 people.add(new Person(name, destination));
             }
             else
             {
                 cars.add(new Car(name, capacity, destination));
             }
         }
     }
 }

 /**
    Load all passengers into cars.
 */
 public void loadPassengers()
 {
     // Complete this method
	 for(Person p : people) {
		 boolean isAdded = false;
		 for(int i=0; !isAdded && i<cars.size(); i++) {
			 isAdded = cars.get(i).tryToAdd(p);
			 if(isAdded)
				 System.out.println(cars.get(i).getDriverName() + " picks up " + p.getName());
		 }
	 }
 }

 /**
    Drive all cars until they have arrived.
 */
 public void driveCars()
 {	 
	 ArrayList<Person> droppedPeople = new ArrayList<Person>();
	 while(cars.size()>0) {		 
		 for(int i=0; i<cars.size(); i++) {
			 Car c = cars.get(i);
			 for(Person p : c.drive()) {
				 System.out.println(c.getDriverName() + " drops off " + p.getName());
			 }
			 //c.driveSolution();
			 if(c.hasArrived())
				 cars.remove(i);
			 else
				 i++;
		 }
	 }	 
 }
 
 public String toString()
 {
     return cars.toString();
 }
}
