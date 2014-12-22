package sample;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class DataFilterStream {
	public static void main(String[] args) throws IOException{
		
		OutputStream out = new FileOutputStream("data.txt");		
		DataOutputStream outFilter = new DataOutputStream(out);
		outFilter.writeChars("import java.io.DataOutputStream");
		outFilter.writeInt(100);
		outFilter.close();
		
		InputStream in = new FileInputStream("data.txt");
		DataInputStream inFilter = new DataInputStream(in);
		String str = inFilter.readLine();		
		int x = inFilter.readInt();
		inFilter.close();
		
		System.out.println("Str: " + str);
		System.out.println("X: " + x);
		
	}
}

class ByteBufferStream {
	public static void main(String[] args) throws IOException {
		InputStream in = new FileInputStream("data.txt");
		OutputStream out = new FileOutputStream("data.txt");
		
		BufferedInputStream bIn = new BufferedInputStream(in);
		BufferedOutputStream bOut = new BufferedOutputStream(out);
		
		int bData;
		
		while(true) {
			bData = bIn.read();
			if(bData == -1)
				break;
			
			bOut.write(bData);
		}
		
		bIn.close();
		bOut.close();		
	}
}

class PrintWriterStream {
	public static void main(String[] args) throws IOException{
		PrintWriter writer = new PrintWriter(new FileWriter("printf.txt"));
		writer.printf("This is PrintWriterStream class %d", 1);
		writer.println("");
		writer.println("I like Java");
		writer.print("...");
		writer.close();
		
	}
}



