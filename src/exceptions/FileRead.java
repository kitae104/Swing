package exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileRead {

	public static void main(String[] args) {
		
		try {
			FileReader fr = new FileReader("C:\\Temp\\a.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
