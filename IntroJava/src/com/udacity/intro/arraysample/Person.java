package com.udacity.intro.arraysample;

import java.util.ArrayList;

public class Person {
	private String name;
	private ArrayList<Person> friends;
	
	public Person(String name) {
		this.name = name;
		friends = new ArrayList<Person>();
	}
	
    /**
     * Adds the given friend to this Person's friends list.
     * @param friend the friend to add.
     */
	public void addFriend(Person friend) {
		friends.add(friend);
	}
	
    /**
     * Gets a list of all of this Person's friends.
     * @return the names of the friends separated by a comma and a space.
     *     e.g. "Sara, Cheng-Han, Cay"
     */
	public String getFriends() {
		String temp = friends.toString();
		return temp.substring(1, friends.size()-1);
		// return getFriends(", ");
	}
	
    /**
     * Returns the names of the friends with separator between them.
     * @param separator string to put between names.
     * @return the names of the friends.
     */
	public String getFriends(String separator) {
		String separatedFriends = "";
		if(friends.size()>0)
		{
			separatedFriends = separatedFriends + friends.get(0).name;
		}
		for(int i=1; i<friends.size(); i++) {
			separatedFriends = separatedFriends + separator + friends.get(i).name;
		}
		
		return separatedFriends;		
	}
	
    /**
     * Gets a friend at a given index
     * @param friendIndex the index at which to find the friend (starting at 0)
     * @return the name of the friend at friendIndex
     */
	public String getFriend(int friendIndex) {
		return friends.get(friendIndex).name;
	}
	
    /**
     * Gets the number of friends this Person has.
     * @return the number of friends.
     */
	public int getNumFriends() {
		return friends.size();
	}
	
    /**
     * Removes nonFriend from the list of friends.
     * @param nonFriend the friend to remove
     */
	public void unfriend(Person nonFriend) {
		int nonFriendIndex = find(nonFriend);
		if(nonFriendIndex != -1)
			friends.remove(nonFriendIndex);		
	}
	
    /**
     * When a person talks to some one, if that person is already
     * a friend, they move to the front of the list. Otherwise nothing
     * changes.
     * @param the person to potentially move to the front of the friends list.
     */
	public void talkTo(Person person) {
		int personIndex = find(person);		
		if(personIndex != -1) {			
			friends.remove(personIndex);
			friends.add(0, person);
		}
			
	}
	
    /**
     * Removes unrequited friendships. All Persons who do not have this
     * Person as a friend, are removed from this Person's friend list.
     */
	public void removeMeanFriends() {
		int i = 0;
		while(i < friends.size()) {
			if(friends.get(i).find(this) == -1)
				friends.remove(i);
			else
				i++;					
		}
	}
	
	private int find(Person friend) {
		for(int i=0; i<friends.size(); i++) {
			if(friends.get(i).equals(friend))
				return i;
		}
		return -1;
	}
	
	public String toString() {
		return name;
	}
		
}