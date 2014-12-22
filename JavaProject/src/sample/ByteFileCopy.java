package sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteFileCopy {
	public static void main(String[] args) throws IOException {
		try {
			InputStream in = new FileInputStream("string.txt");
			OutputStream out = new FileOutputStream("copy.txt");

			int bData;

			while (true) {
				bData = in.read();
				if (bData == -1)
					break;

				out.write(bData);
			}
			
			in.close();
			out.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

class BufferFileCopy {
	public static void main(String[] args) throws IOException {
		InputStream in = new FileInputStream("string.txt");
		OutputStream out = new FileOutputStream("copy.txt");
		
		int readLen;
		byte[] buffer = new byte[1024];
		
		while(true){
			readLen = in.read(buffer);
			if(readLen == -1)
				break;
			out.write(buffer, 0, readLen);			
		}
		in.close();
		out.close();
	}
}