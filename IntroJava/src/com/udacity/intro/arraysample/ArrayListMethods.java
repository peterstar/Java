package com.udacity.intro.arraysample;

//
//Complete the class ArrayListMethods. It consists of four short methods to manipulate an array list of strings.
//The method header and javadoc are given to you.
//
// Need help starting this question? In the lesson titled 
// "Starting points: Problem Set Questions", go to the
// problem titled "Problem Set 6 - Question 1" for some tips on 
// how to begin.
//

import java.util.ArrayList;
public class ArrayListMethods
{
    ArrayList<String> list; //instance variable
    /**
     * Constructor for objects of class ArrayListMethods
     */
    public ArrayListMethods(ArrayList<String> arrayList)
    {
        // initialise instance variables
        list = arrayList;
    }

    /**
     * Determines if the array list is sorted (do not sort)
     * When Strings are sorted, they are in alphabetical order
     * Use the compareTo method to determine which string comes first
     * You can look at the String compareTo method in the Java API
     * @return true if the array list is sorted else false.
     */
    public boolean isSorted()
    {
        boolean sorted = true;

        // TODO: Determine if the array is sorted.
               
        for(int i=0; i<list.size()-1; i++) {
        	 String temp = list.get(i);
        	if(temp.compareTo(list.get(i+1))<0) {
        		sorted = false;        	
        	}
        }
        return sorted;
    }

    /**
     * Replaces all but the first and last elements with the larger of its two neighbors
     * You can use the compareTo() method to determine which string is larger (larger in alphabetical
     * order).
     * Example: if the list is originally
     *    ["cat", "ape", "dog", "horse", "zebra"]
     * after this method it should be: 
     *    ["cat", "dog", "horse", "zebra", "zebra"]
     */
    public void replaceWithLargerNeighbor()
    {

        // TODO: Replace all but the first and last elements with the larger of its to neighbors
    	String temp = "";
    	for(int i=1; i<list.size()-1; i++) {
    		if(list.get(i).compareTo(list.get(i-1))<0)    			
    			temp = list.get(i-1);
    		else if(list.get(i).compareTo(list.get(i+1))<0)
    			temp = list.get(i+1);
    		else
    			temp = list.get(i);
    		
    		list.set(i, temp);	
    	}
    }

    /**
     * Gets the number of duplicates in the list.
     * Be careful to only count each duplicate once. Start at index 0. (Does it match any of the other elements?)
     * Get the next word. It is at index i. (Does it match any of the words with index > i?)
     * @return the number of duplicate words in the list
     */
    public int countDuplicates()
    {
        int duplicates = 0;

        // TODO: Write the code to get the number of duplicates in the list
        for(int i=0; i<list.size(); i++) {
        	for(int j=0; j<list.size(); j++) {
        		if(list.get(i).equals(list.get(j)))
        			duplicates++;
        	}
        }
        return duplicates;
    }

     /**
     * Moves any word that starts with x, y, or z to the front of the ArrayList, but
     * otherwise preserves the order
     * Example: if the list is orginially
     *   ["ape", "dog", "xantus", "zebra", "cat", "yak"]
     * after this method is called it should be
     *   ["xantus", "zebra", "yak", "ape", "dog", "cat"]
     */
    public void xyzToFront()
    {
        int insertAt = 0;

        // TODO:  Move any word that starts with x, y, or z to the front of the ArrayList, but otherwise preserves the order
        for(int i=0; i<list.size(); i++) {
        	if(list.get(i).startsWith("x") || list.get(i).startsWith("y") || list.get(i).startsWith("z")) {        		
        		list.add(insertAt, list.get(i));
        		list.remove(i);
        	}
        		
        }
    }

    /**
     * gets the string representation of this array list
     * @returns the string representation of this array list in
     * standard collection format
     */
    public String toString()
    {
        return list.toString();
    }
    
    // Write the code to print the elements in the array list in reverse order, one to a line.
    public void reversePrint(ArrayList<String> text)
    {
    	for(int i=text.size()-1; i>=0; i--) {
    		System.out.println(text.get(i));
    	}
    }
    
    /**
     * Gets the index of the first String that starts with the target
     * @param text the array list to process
     * @param target the desired letter
     * @return the index of first string starting with target or -1 if not found
     */
     public int getIndex(ArrayList<String> text, String target)
     {    	 
         int i = 0;
         int index = -1;
         boolean found = false;
         while (i<text.size()) //supply condition
         //for(i=0; i<text.size(); i++) // easier, but can't use found boolean
         {
             // TODO: Adapt an ArrayList algorithm to return the index of the first string that start with the target
             // TODO: Return -1 if no string starts with the target
             if(!found && text.get(i).startsWith(target)) {
                 //return i;
                 index = i;
                 found = true;
             }
             i++;
         }
         return index;
         //return -1;
     }
    
    public static void main(String[] args)
    {
        //set up
        ArrayList<String> animals = new ArrayList<String>();
        ArrayListMethods zoo = new ArrayListMethods(animals); 
        animals.add("ape");
        animals.add("dog");
        animals.add("zebra");
        
        //test isSorted
        System.out.println(zoo.isSorted());
        System.out.println("Expected: true");
        
        animals.add("cat");
        System.out.println(zoo.isSorted());
        System.out.println("Expected: false");
        
        animals.remove("cat");
        animals.add(0,"cat");
        System.out.println(zoo.isSorted());
        System.out.println("Expected: false");
        
        
        
        animals.add(3,"horse");
        
        //test replaceWithLargerNeighbor
        zoo.replaceWithLargerNeighbor();
        System.out.println(zoo.toString());
        System.out.println("Expected: [cat, dog, horse, zebra, zebra]");
        
        animals.add(0,"cat");
        
        //test count duplicates;
        System.out.println(zoo.countDuplicates());
        System.out.println("Expected: 2");
        animals.add(4,"dog");
        System.out.println(zoo.countDuplicates());
        System.out.println("Expected: 3");
        
        
        //start with fresh array list
        animals = new ArrayList<String>();
        zoo = new ArrayListMethods(animals); 
        
        //does empty array list work?
         System.out.println(zoo.isSorted());
         System.out.println("Expected: true");
         zoo.replaceWithLargerNeighbor();
         System.out.println(zoo.toString());
         System.out.println("Expected: []");
         System.out.println(zoo.countDuplicates());
         System.out.println("Expected: 0");
        
        //test xyzToFront
        animals.add("ape");
        animals.add("dog");
        animals.add("xantus");
        animals.add("zebra");
        animals.add("cat");
        animals.add("yak");
        
        zoo.xyzToFront();
        System.out.println(zoo.toString());
        System.out.println("Expected: [xantus, zebra, yak, ape, dog, cat]");    
        
        
    }
    
}

