package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteBufferedFileCopy {
	public static void main(String[] args){
		try {
			InputStream in = new FileInputStream("org.bin");
			OutputStream out = new FileOutputStream("cpy.bin");
			
			BufferedInputStream is = new BufferedInputStream(in);
			BufferedOutputStream os = new BufferedOutputStream(out);
			
			int copyByte = 0;
			int bData;
			
			while(true){
				bData = is.read();
				if(bData == -1)
					break;
				os.write(bData);
			}
			
			is.close();
			os.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}