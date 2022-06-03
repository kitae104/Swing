package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BinaryCopy {

	public static void main(String[] args) {
		File src = new File("C:/Windows/explorer.exe");
		File dest = new File("C:/Temp/my.exe");
		
		try {
			FileInputStream fr = new FileInputStream(src);
			FileOutputStream fw = new FileOutputStream(dest);
			int c = 0;
			while((c=fr.read()) != -1) {
				fw.write((byte)c);
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
