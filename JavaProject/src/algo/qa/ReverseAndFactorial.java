package algo.qa;

import java.util.Arrays;

public class ReverseAndFactorial {
	public static void main(String[] args) {
		String input = "Reverse";
		int numOfFactorial = 5;
		
		String output = revStr(input);
		System.out.println("Reverse: " + output);
		int resultFactorial = factorial(numOfFactorial);
		System.out.println("Factorial: " + resultFactorial);
	}
	
	// using char array	
    public static String revStrByArray(String input) {
    	char[] temp = input.toCharArray();
    	int index = temp.length-1;
    	char[] result = new char[temp.length];    	
    	for(int i=index; i>=0; i--){    		
    		result[index-i] = temp[i];    		
    	}    	
    	String ret = Arrays.toString(result);
    	ret = new String(result);
    	return ret;    	 
    }
    
    // using StringBuilder
    public static String revStr(String input) {
    	StringBuilder sb = new StringBuilder();
    	for(int i=input.length()-1; i>=0; i--) {
    		sb.append(input.charAt(i));
    	}
    	return sb.toString();
    }
	
	public static int factorial(int number) {
		
		if(number == 0)
			return 1;
		
		return number * factorial(number-1);
	}
}