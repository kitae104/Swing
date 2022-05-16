package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:XE", 
					"bban", 
					"1111");
			
			Statement stmt = conn.createStatement();
			
//			Scanner sc = new Scanner(System.in);
//			System.out.println("검색할 ID를 입력하세요.");
//			String key = sc.nextLine();
			
			// 자료 삽입 
			String sqlInsert = "insert into tb (id, pw, grade, dept) "
					+ "values('cc', '00', 2, '기계설계과')";
			
			// 수정 처리
			String sqlUpdate = "update tb set dept = '컴퓨터시스템'";
			
			// 삭제 처리
			String sqlDelete = "delete from tb where id ='cc'";
			System.out.println(sqlDelete);
			stmt.executeUpdate(sqlDelete);
			
			
			String sql = "select * from tb ";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("아이디" + "\t" + "패스워드" + "\t" + "학년" + "\t" + "학과");
			System.out.println("=================================");
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				int grade = rs.getInt("grade");
				String dept = rs.getString(4);
				System.out.println(id + "\t" + pw + "\t" + grade + "\t" + dept);
			}
			System.out.println("=================================");
			rs.close();
			
			System.out.println("OK!");
		} catch (ClassNotFoundException e) {
			System.out.println("예외 발생 : 클래스가 존재하지 않습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("예외 발생 : DB접속 시 오류 발생.");
			e.printStackTrace();
		}

	}

}
