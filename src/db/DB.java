package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	
	public static Connection conn;
	public static Statement stmt;

	public static void init() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:XE", 
					"bban", 
					"1111");
			
			stmt = conn.createStatement();	
			
			
			System.out.println("DB 연결 OK!");
			
		} catch (ClassNotFoundException e) {
			System.out.println("예외 발생 : 클래스가 존재하지 않습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("예외 발생 : DB접속 시 오류 발생.");
			e.printStackTrace();
		}

	}
	
	// 조회용 
	public static ResultSet getResultSet(String sql) {
		try {
			Statement stmt = conn.createStatement();
			return stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// 수정용 
	public static void executeSql(String sql) {
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
}
