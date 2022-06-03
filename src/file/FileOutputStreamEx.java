package file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamEx {

	public static void main(String[] args) {
		byte[] b = {7, 51, 3, 4, -1, 24};
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("C:/Temp/test.out");
			for (int i = 0; i < b.length; i++) {
				fos.write(b[i]);
			}
			System.out.println("파일 쓰기 완료!");
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {		
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
