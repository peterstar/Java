package com.udacity.intro.moreclass;

// implement without array
public class HomeworkScores
{
    private double[] scores;
    private int currentSize; // The current size of the array of scores
    private static final int MAX_SIZE = 1000;
    
    private int numOfScore;
    private double sum;
    private double lowest;
    
    public HomeworkScores()
    {
        scores = new double[MAX_SIZE];
        currentSize = 0;
        
        numOfScore = 0;
        sum = 0;
        lowest = -1;
    }

    /**
       Adds a score.
       @param score the score to add
    */
    public void addScore(double score)
    {
        if (currentSize < scores.length)
        {
            scores[currentSize] = score;
            currentSize++;
        }
        
        if(numOfScore == 0 || lowest < score)
        	lowest = score;        
        sum += score;
        numOfScore++;
    }

    /**
       Calculates the sum of all the scores entered, dropping the lowest
       score if there is more than one.
       @return the sum of all the scores in scores.
    */
    public double getTotalExcludingLowestUsingArray()
    {
        if (currentSize == 0)
        {
            return 0;
        }
        else if (currentSize == 1)
        {
            return scores[0];
        }
        else
        {
            double sum = 0;
            for (int i = 0; i < currentSize; i++)
            {
                sum = sum + scores[i];
            }
            return sum - getLowest();
        }
    }
    
    public double getTotalExcludingLowest()
    {
    	if(numOfScore == 0)
    		return 0;
    	else if(numOfScore == 1)
    		return sum;
    	else
    		return sum - lowest;
    }

    /**
       Calculates the lowest score.
       @return the lowest score or 0 if there are no scores 
    */
    private double getLowest()
    {
        if (currentSize == 0) 
        {
            return 0;
        }
        else
        {
            double lowest = scores[0];
            for (int i = 1; i < currentSize; i++)
            {
                if (scores[i] < lowest)
                {
                    lowest = scores[i];
                }
            }
            return lowest;
        }
    }       
}