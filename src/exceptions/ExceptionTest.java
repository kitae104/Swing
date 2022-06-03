package exceptions;

import java.util.Scanner;

public class ExceptionTest {

	public static void main(String[] args) {
		String[] db_id = {"java", "AAA", "BBB"};
		
		System.out.println("다음 ID중 입력하세요");
		System.out.println("java, AAA, BBB");
		
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		if(db_id[0].equals(id) || db_id[1].equals(id) || db_id[2].equals(id)) {
			System.out.println("로그인 성공");
		} else {
			try {
				throw new DuplicateException("예외 발생");				
			} catch (DuplicateException e) {
				System.out.println("DuplicateException 예외 발생");
			}
			 
		}

	}

}
