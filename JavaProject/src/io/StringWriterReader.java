package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StringWriterReader {
	public static void main(String[] args){
		try {
			BufferedWriter bWriter = new BufferedWriter(new FileWriter("string.txt"));
			String str = "I make the web a little faster, safer, smarter, better.";
			bWriter.write(str);
			bWriter.newLine();
			str = "Did you know? 1/5 of Websites & apps collect your data, ";
			bWriter.write(str);
			bWriter.newLine();
			str = "but don't tell you how they handle it. Here's our policy";
			bWriter.write(str);
			bWriter.newLine();
			
			bWriter.close();
			System.out.println("String Writer Complete\n");
			
			BufferedReader bReader = new BufferedReader(new FileReader("string.txt"));
			String output;
			while(true){
				output = bReader.readLine();
				if(output == null)
					break;
				System.out.println(output);
			}
			
			bReader.close();
			System.out.println("\nString Reader Complete");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}