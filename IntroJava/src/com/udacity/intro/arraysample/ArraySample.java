package com.udacity.intro.arraysample;

import java.util.Arrays;
import java.util.Random;

public class ArraySample {
	public static void main(String[] args) {
		String[] sample = { "" };		
		int matrix[][] = new int[4][5];
		int rows = matrix.length;
		int columns = matrix[0].length;
		matrix[matrix.length-1][matrix[0].length-1] = 54; // last row of last column
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				System.out.printf("%6d", matrix[i][j]);
			}
		}
		double[] values = // new double[10];
		{ 1, 2, 3, 4, 5, 4, 3, 2, 1, 9 };
		double sum = 0;
		for (int i = 0; i < 9; i++)
			sum = sum + values[i];
		System.out.println(sum);
		// partial array
		if (values.length < values.length + 10)
			values = Arrays.copyOf(values, values.length * 2);

		// insert and remove array
		int size = 0, pos = 0, newValue = 0;
		size++;
		for (int i = size - 1; i > pos; i--) {
			values[i] = values[i - 1];
		}
		values[pos] = newValue;
	}

	/**
	 * Returns a string with the elements of the array in reverse order
	 * separated by a space
	 * 
	 * @param values
	 *            the array to reverse
	 * @return the string containing the elements in reverse order
	 */
	public String inReverse(int[] values) {
		String message = "";
		for (int i = values.length - 1; i >= 0; i--) // finish the loop header
		{
			// TODO: concatenate the elements to message in reverse order
			message += values[i] + " ";
		}
		return message;
	}

	private Random generator;

	// do not change the constructor
	public void arrayProcessor() {
		generator = new Random();
		generator.setSeed(1234); // do not change the seed
	}

	/**
	 * Fills the array with random integers between 0 and 100 (exclusive)
	 * 
	 * @param values
	 *            , the int[] that you need to fill with random integers
	 */
	public void fill(int[] values) {
		// TODO: Write code to fill the array, values, with random numbers
		// between 0 and 100(exclusive)
		arrayProcessor();
		for (int i = 0; i < values.length; i++) {
			values[i] = generator.nextInt(100);
		}
	}
	
    public void swapHalves()
    {
        int[] elements = { 1, 4, 9, 7, 3, 2, 5, 11, 0, 9 };
        //int[] saved = new int[elements.length];        	
        // TODO: Swap the first and second half
        for(int i=0; i<elements.length/2; i++) {        	
        		int saved = elements[i];
        		elements[i] = elements[i + elements.length/2];
        		elements[i + elements.length/2] = saved;
        	
        	
        }
        // Print all elements
        System.out.println(Arrays.toString(elements));
    }
}