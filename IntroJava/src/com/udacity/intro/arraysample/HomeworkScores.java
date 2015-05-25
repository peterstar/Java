package com.udacity.intro.arraysample;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Holds the homework scores for a student.
 */
public class HomeworkScores
{
    private double[] scores;
    private int currentSize; // The currentSize of the array of scores.

    /**
     * @param maxScores the maximum number of scores this object can hold.
     */
    public HomeworkScores(int maxScores)
    {
        scores = new double[maxScores];
        currentSize = 0;
    }

    /**
     * Calculates the Sum of all the scores entered.
     * @return the sum of all the scores in scores.
     */
    public double sumScores()
    {
        // YOUR CODE HERE
        // Sum all the scores that have been entered so far and
        // return the result.
    	double sum = 0;
    	for(int i=0; i<currentSize; i++)
    		sum += scores[i];
        return sum;
    }
    
    /**
     * Calculates the average of all the scores collected so far.
     * @return the average of the scores in scores.
     */
    public double averageScore()
    {
        // TODO: Calculate the average score.
        // Add up all the scores and divide by the number of scores.
        // return the result.
        double average = 0;
        if(currentSize != 0)
        	average = sumScores() / currentSize;
        
    	return average;
    }
    
    public void readScores(Scanner userInput)
    {
        // YOUR CODE HERE
        // Read (userInput) scores between 0 and 100 until a non number is entered.
        // Use the scanner passed in in the argument userInput.
        // Save each score that is read in the partially filled scores array.
        // Make sure not to lose track of how filled the array is.
    	
    	while(userInput.hasNextDouble()) {
    		scores[currentSize] = userInput.nextDouble();
    		currentSize++;
    	}
    }
            
    public void removeLowest()
    {
        // YOUR CODE HERE
        // Remove the lowest score.
        // You can use any of the other methods in this class.
    	double lowest = lowScore();
    	int index = find(lowest);
    	remove(index);
    }
    
    /**
     * Finds the index of the lowest score.
     * @return the index of the lowest score.
     */
    public int getLowScoreIndex()
    {
        // TODO: Find and return the index of the lowest score in scores.
        int index = 0;
        double lowest = scores[0];
    	for(int i=1; i<scores.length; i++) {
    		if(scores[i]<lowest) {
    			lowest = scores[i];
    			index = i;
    		}
    	}    	
    	        
        return index;
    }

    /**
     * Finds the first occurrence of the given score.
     * @param searchedValue the score to look for
     * @return the position of scoreToFind, -1 if it's not there
     */
    public int find(double searchedValue) {
    	int firstOccur = -1;
    	for(int i=0; i<scores.length; i++) {
    		if(scores[i] == searchedValue)
    			firstOccur = i;
    	}
    	return firstOccur;
    }
    
    // using while loop - given code
    public int findOne(double searchedValue)
    {
        int pos = 0;
        boolean found = false;
        while (pos < currentSize && !found)
        {
            if (scores[pos] == searchedValue)
            {
                found = true;
            }
            else
            {
                pos++;
            }
        }
        if (found)
        {
            return pos;
        }
        else
        {
            return -1;
        }
    }
    
    /**
     * Returns the lowest of the scores.
     * @return the lowest score
     */
    public double lowScore() {
    	double lowest = scores[0];
    	for(int i=1; i<scores.length; i++) {
    		if(scores[i]<lowest)
    			lowest = scores[i];
    	}    	
    	return lowest;
    }
    
    /**
     * Removes the score at the given position.
     * @param pos the position of the value to remove.
     */    
    public void remove(int pos)
    {
        for (int i = pos + 1; i < currentSize; i++)
        {
            scores[i - 1] = scores[i];
        }
        currentSize--;
    }

    
    /**
     * Builds an easy-to-read description of the scores in the object.
     * @return A description of the scores.
     */
    public String toString()
    {
        return Arrays.toString(Arrays.copyOf(scores, currentSize));
    }
}
