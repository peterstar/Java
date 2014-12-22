package intro;

import java.util.Arrays;

public class IntroMain {
	public static void main(String[] args) {
		System.out.println("Factorial 5: " + factorial(5));
		String input = "Reverse";
		System.out.println("Reverse of " + input + " is " + revStrByArray(input));
		System.out.println("Reverse of " + input + " is " + revStr(input));
	}
	
	public static int factorial(int n) {
		if (n==0)
			return 1;
		else 
		{
			return n * factorial(n-1);
		}
			
	}
	// using char array	
    public static String revStrByArray(String input) {
    	char[] temp = input.toCharArray();
    	int index = temp.length-1;
    	char[] result = new char[temp.length];    	
    	//System.out.println(Arrays.toString(result));
    	for(int i=index; i>=0; i--){
    		//System.out.println("temp[" + i + "]: " + temp[i]);
    		result[index-i] = temp[i];
    		//System.out.println("result[" + (index-i) + "]: " + result[i]);
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
}