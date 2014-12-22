package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteFileCopy {
	public static void main(String[] args){
		try {
			InputStream is = new FileInputStream("org.bin");
			OutputStream os = new FileOutputStream("cpy.bin");
			
			int copyByte = 0;
			int bData;
			
			while(true){
				bData = is.read();				
				if(bData == -1)
					break;
				os.write(bData);
				copyByte++;
			}
			
			is.close();
			os.close();
			
			System.out.println("Copyed Byte size: " + copyByte);
						
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}