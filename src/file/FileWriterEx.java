package file;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileWriterEx {

	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		FileWriter fw = null;
		try {
			fw = new FileWriter("C:/Temp/a.txt");
			int c = 0;
			while( (c = isr.read()) != -1) {
				fw.write(c);
			}
			System.out.println("파일 쓰기 끝!");
		} catch (IOException e) {
			System.out.println("예외 발생 : 파일 쓰기 중 오류 발생");
			e.printStackTrace();
		} finally {			
			try {
				fw.close();
				isr.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}

	}

}
