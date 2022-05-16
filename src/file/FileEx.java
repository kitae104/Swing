package file;

import java.io.File;

public class FileEx {

	public static void main(String[] args) {
		File f1 = new File("C:/Temp/");
		File f2 = new File("C:/Temp/My");
		if(!f2.exists()) {
			f2.mkdir();
		} 
		
		File[] listFiles = f1.listFiles();	
		for (File file : listFiles) {
			System.out.println(file.getName());
		}

	}

}
