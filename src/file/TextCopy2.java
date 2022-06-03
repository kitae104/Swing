package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextCopy2 {

	public static void main(String[] args) {
		File src = new File("C:/Temp/java.jpg");
		File dest = new File("C:/Temp/my.jpg");
		
		try {
			FileReader fr = new FileReader(src);
			FileWriter fw = new FileWriter(dest);
			int c = 0;
			while((c=fr.read()) != -1) {
				fw.write((char)c);
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
