package com.udacity.intro.moreclass;

import java.util.ArrayList;

public class Car {
	private int numberOfSeats;
	private String driverName;
	private ArrayList<Person> passengers;
	private int location;
	private int destination;

	/**
	 * Constructs a car with a given number of seats
	 * 
	 * @param numberOfSeats
	 *            the number of seats in this car.
	 */
	public Car(String driverName, int numberOfSeats, int destination) {
		passengers = new ArrayList<Person>();
		this.driverName = driverName;
		this.numberOfSeats = numberOfSeats;
		location = 0;
		this.destination = destination;
	}

	public void setDriverName(String name) {
		driverName = name;
	}

	public String getDriverName() {
		return driverName;
	}

	/**
	 * Checks whether this car has arrived at its destination.
	 * 
	 * @return true if the car has arrived
	 */
	public boolean hasArrived() {
		return location == destination;
	}

	/**
	 * Tries to add a passenger.
	 * 
	 * @param p
	 *            the new passenger
	 * @return true if there is room in the car and the passenger's destination
	 *         on the way to this car's destination
	 */
	public boolean tryToAdd(Person p) {
		// TODO: Complete this method
		boolean addOk = false;
		if ((passengers.size() + 2 <= numberOfSeats)
				&& (p.getDestination() <= destination)) {
			passengers.add(p);
			System.out.println(getDriverName() + " picks up " + p.getName());
			addOk = true;
		}
		return addOk;
	}

	/**
	 * Drives this car to the next location and drops off any passengers whose
	 * destination is that location
	 */
	// it works
	// it is failed on print statement on line 78 because of index error when using without Person p
	public ArrayList<Person> drive() {
		// TODO: Implement this method
		location++;
		ArrayList<Person> droppedPeople = new ArrayList<Person>();
		for(int i=0; i<passengers.size(); i++) {
			Person p = passengers.get(i);
			if(p.getDestination() == location)
			{
				passengers.remove(i);
				droppedPeople.add(p);
				//System.out.println(getDriverName() + " drops off " + p.getName());
				numberOfSeats++; // it is not present in solution				
			}
		}
		
		return droppedPeople;
	}
	
	public void driveSolution() {
		location++;
		int i = 0;
		while(i<passengers.size()) {
			Person p = passengers.get(i);
			if(p.getDestination() == location) {
				passengers.remove(i);
				System.out.println(getDriverName() + " drops off " + p.getName());
			}
			else
				i++;
		}
	}
	
    public String toString()
    {
        return "Car[location=" + location + ",driverName=" + driverName + ",passengers=" + passengers + "]";
    }

	/**
	 * Adds a passenger to this car, provided that there is space.
	 */
	public void addPassenger(Person p) {
		if (passengers.size() + 1 < numberOfSeats)
			passengers.add(p);
	}

	/**
	 * Gets the number of passengers in this car (not counting the driver).
	 * 
	 * @return the number of passengers
	 */
	public int getPassengerCount() {
		return passengers.size();
	}

	/**
	 * Gets a list of all passengers in this car.
	 * 
	 * @return a list of the form [name1, name2, ...]
	 */
	public String getPassengerList() {
		return passengers.toString();
	}
	
}
