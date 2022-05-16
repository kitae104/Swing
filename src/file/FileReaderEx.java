package file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {

	public static void main(String[] args) {
		FileReader fr = null;
		try {
			fr = new FileReader("C:\\Temp\\a.txt");
			int c = 0;
			while((c = fr.read()) != -1) {
				System.out.print((char)c);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("예외 발생 : 파일이 존재하지 않습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("예외 발생 : 입출력시 오류 발생.");
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
