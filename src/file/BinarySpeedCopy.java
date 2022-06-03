package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BinarySpeedCopy {

	public static void main(String[] args) {
		File src = new File("C:/Windows/explorer.exe");
		File dest = new File("C:/Temp/my2.exe");
		
		try {
			FileInputStream fr = new FileInputStream(src);
			FileOutputStream fw = new FileOutputStream(dest);
			
			byte[] buf = new byte[1024 * 10];
			while(true) {
				int n = fr.read(buf);
				fw.write(buf, 0, n);
				if(n < buf.length) {
					break;
				}
			}
			System.out.println("복사 완료!");	
			fr.close();
			fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
