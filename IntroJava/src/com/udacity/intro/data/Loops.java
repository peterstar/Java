package com.udacity.intro.data;

import java.util.Random;
import java.util.Scanner;

public class Loops {

	public static void main(String[] args) {
		getCount();
		getCountOne();
		trianglePattern();
		
		String testText = "rum";		
		Word word = new Word(testText);
		System.out.println(word.getSubstrings());
		
		DiceGame dicegame = new DiceGame();
		System.out.println("Game1: " + dicegame.game1());
		System.out.println("Game2: " + dicegame.game2());
		DiceGame.printNumberWins();
		
		BuffonPiEstimation piEstimate = new BuffonPiEstimation();
		piEstimate.piEstimate();
		
		RandomWord rWord = new RandomWord();
		String testWord = "randomword";
		System.out.println(rWord.swapByArray(1, 5, testWord));
		System.out.println(rWord.swap(1, 5, testWord));
	}

	private static void getCountOne() {
		// TODO Auto-generated method stub
		int count = 0;
		for (count = 0; count <= 10; count = count + 2) {
			System.out.print(count + " ");
		}
		System.out.println(count);
	}

	private static void getCount() {
		int count = 0;
		for (count = 5; count >= 0; count--) {
			System.out.print(count + " ");
		}
		System.out.println(count);
	}

	private static void trianglePattern() {
		int numOfRows = 5;
		for (int row = 1; row <= numOfRows; row++) {
			for (int column = 1; column <= row; column++) {
				System.out.print("[]");
			}
			System.out.println();
		}
	}

	// works
	private static void trianglePatternOk() {
		int numOfRows = 5;
		for (int i = 0; i < numOfRows; i++) {
			// System.out.print("[]");
			for (int j = i; j >= 0; j--) {
				System.out.print("[]");
			}
			System.out.println();
		}
	}
}

class Word {
	private String sample;
	private int length;

	public Word(String sample) {
		this.sample = sample;
		length = sample.length();
	}

	/**
	 * Gets all the substrings of this Word.
	 * 
	 * @return all substrings of this Word separated by newline
	 */

	// working
	public String getSubstringsOk() {
		String temp = "";

		for (int i = 0; i < sample.length(); i++) {
			for (int j = 1; j <= sample.length() - i; j++) {
				temp = temp + sample.substring(i, i + j) + "\n";
			}
		}
		return temp;
	}

	public String getSubstrings() {
		String temp = "";
		
		for (int substringLength = 1; substringLength <= length; substringLength++) {
			for (int substringIndex = 0; substringIndex <= length - substringLength; substringIndex++) {
				temp = temp + sample.substring(substringIndex, substringIndex + substringLength) + "\n";
			}
		}

		return temp;
	}
}

class DiceGame {
	Random generator;
	public static int numOfGame1Win = 0;
	public static int numOfGame2Win = 0;
	
	public DiceGame() {
		generator = new Random(45);
	}
    /** 
     * Throw a dice four times and bet on at least one 6. 
     * @return true if the chevalier wins. 
     */
	public boolean game1() {
		boolean isWon = false;
		int dice = 0;
		for(int i=0; i<4; i++) {
			dice = 1 + generator.nextInt(6); // 0...5 without adding 1
			if(dice == 6) {
				isWon = true;
				// different result when return true
				//return true;
				numOfGame1Win++;
			}
		}
		return isWon;
		//return false;
	}
    /**
     * Throw two dice 24 times and bet on at least one double-six.
     * @return true if the chevalier wins. 
     */
	public boolean game2() {
		boolean isWon = false;
		int dice1 = 0;
		int dice2 = 0;
		for(int i=0; i<23; i++) {
			dice1 = 1 + generator.nextInt(6);
			dice2 = 1 + generator.nextInt(6);
			if((dice1 == 6) && (dice2 == 6)) {
				isWon = true;
				// different result when return true
				//return true;
				numOfGame2Win++;
			}
		}
		return isWon;
		//return false;
	}
	
	public static void printNumberWins() {
		System.out.println("Game 1 Wins so far: " + numOfGame1Win);
		System.out.println("Game 2 Wins so far: " + numOfGame2Win);
	}
}

class BuffonPiEstimation
{	
	Random generator;
	
	public BuffonPiEstimation() {		
		generator = new Random(42);
	}
	
    public void piEstimate() 
    {
        System.out.println("Buffon Pi Estimation");
        //System.out.println("Enter the number of tries: ");
        //Scanner in = new Scanner(System.in);
        int tries = 60000; //in.nextInt();
        int hits = 1;
        
        // YOUR CODE HERE
        // Calculate the number of hits. 
        // generate a yLow, the lowest point, or the farthest point on 
        // the needle from the line (a number between 0 and 2).
        // generate a random angle a between 0 and 180 degrees. 
        // yHigh is yLow plus the sine of a. 
        // if yHigh is above the line (the line is at a height of 2), 
        // the needle is touching the line, and counts as a hit.
        // Hint: Math.sin takes an angle in radians.    
        
        for(int i=0; i<tries; i++) {
            double yLow = generator.nextDouble() * 2;
            double angle = generator.nextDouble() * 180;
        	double yHigh = yLow + Math.sin(Math.toRadians(angle));
        	//System.out.println(yHigh);
        	if(yHigh>=2.0) {
        		hits++;     
        	}
        }
        
        double piEstimate = tries/hits;
        System.out.println(hits);
        System.out.println(piEstimate);
    }   
}

class RandomWord
{
   private Random generator = new Random();

   public RandomWord()  //leave the constructor alone
   {
        generator = new Random();
        final long SEED = 42;
        generator.setSeed(SEED);
   }
   /**
    * Gets a version of this word with the leters scrambled
    * @param word the string to scramble
    * @return the scrabled string
    */
   public String scramble(String word)
   {
	   String retWord = "";
       //TODO scramble the letters following the pseudocode
	   for(int r=0; r<word.length(); r++) {
		   int i = generator.nextInt(word.length()-1);
		   int j = generator.nextInt(i);
		   swap(i, j, word); 
	   }
	   return retWord;
   }
      
   public String swap(int i, int j, String word) {
	   StringBuilder sb = new StringBuilder(word);
	   char iChar = sb.charAt(i); 
	   char jChar = sb.charAt(j);
	   sb.setCharAt(i, jChar);
	   sb.setCharAt(j, iChar);
	   return sb.toString();
   }
   
   public String swapByArray(int i, int j, String word) {
	   char[] wordArray = word.toCharArray();
	   char temp = wordArray[i];
	   wordArray[i] = wordArray[j];
	   wordArray[j] = temp;
	   //return wordArray.toString();
	   return new String(wordArray);
   }


}
