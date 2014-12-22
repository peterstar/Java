package sample;

import java.util.Scanner;

// print pyramid with hash 
// pyramid height is non-negative integer and it is less than 23
public class Mario {
	public static void main(String[] args) {
		int h = 0;
		while(true) {
			System.out.println("Give a pyramid height: ");
			Scanner keyboard = new Scanner(System.in);
			h = keyboard.nextInt();
			keyboard.nextLine();
			System.out.println("Height: " + h);
			if(h>0 && h<23) {
				showPyramid(h);
				//System.out.println("Show pyramid\n");
				break;
			} else {
				System.out.println("Wrong input");
			}
		}
	}
	
	// space pattern s=0,1,2,...,n  
	// ## pattern 2h=2h,3h,...,(n+2)h
	
	static void showPyramid(int h) {
						
			for(int i=0; i<h; i++) {			
				
				for(int j=0; j<h; j++) {
					System.out.print(" ");
				}
								
				for(int j=0; j<i+2; j++) {
					System.out.print("#");
				}
				
				//System.out.print("##");
				System.out.println("");
			}
			
	

	}
}