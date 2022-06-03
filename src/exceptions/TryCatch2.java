package exceptions;

public class TryCatch2 {

	public static void main(String[] args) {
		
		try {
			divide();
			System.out.println("잘 나누어 집니다.");
		} catch (ArithmeticException e) {			
			System.out.println("ArithmeticException 예외 처리1 : " + e.getMessage());			
		} catch (Exception e) {
			System.out.println("그외 예외 처리2 : " + e.getMessage());	
		} finally {
			System.out.println("finally는 무조건 실행됨");
		}
		
		System.out.println("프로그램 종료");
		divide();
	}

	private static void divide() {
		int a = 0;
		a = 10 / a;	
		System.out.println(a);
	}

}
