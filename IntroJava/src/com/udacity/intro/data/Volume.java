package com.udacity.intro.data;

public class Volume {
	public static void main(String[] args) {
		System.out.println("Volume: " + getVolume());
		System.out.println("Last digit: " + getLastDigit());
		getText();
	}

	private static int getLastDigit() {
		// TODO Auto-generated method stub
		int retVal = 0;
		int num = 201;
		//while(num != 0) {
			retVal = num % 10;
			//num = num / 10;
			//if(num<10)
				//break;
		//}

		return retVal;
	}

	private static double getVolume() {
		// TODO Auto-generated method stub
		double retVal = 0.0;
		int r = 2;
		int h = 10;
	    System.out.println("r: " + (r*r)); // ^ is XOR
		retVal = (double)((r*r) * h);	    
	    System.out.println("Volume-1: " + retVal);
	    retVal = (1/3) * Math.PI;	    
	    System.out.println("Volume-2: " + retVal);
	    retVal = (1/3) * Math.PI * r*r * h;	    
	    System.out.println("Volume-3: " + retVal);
	    retVal = (Math.PI * r*r * h)/3;	    
	    System.out.println("Volume-3: " + retVal);
		return retVal;
	}
	
	private static void getText() {
		String book = "My favorite book is, \"Warrior\'s Apprentice\"";
		System.out.println(book);
		System.out.println(String.valueOf(book.charAt(0)));
		System.out.println(String.valueOf(book.charAt(book.length()-1)));		
	}
	
}