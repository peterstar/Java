package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferFileCopy {
	public static void main(String[] args){
		try {
			InputStream in = new FileInputStream("org.bin");
			OutputStream out = new FileOutputStream("cpy.bin");
			
			int readLen;
			byte buffer[] = new byte[1024];
			int copyByte = 0;
			
			while(true){
				readLen = in.read(buffer);
				if(readLen == -1)
					break;
				out.write(buffer, 0, readLen);
				copyByte += readLen;
			}
			
			in.close();
			out.close();
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