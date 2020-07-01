package member.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBconn {
	
	private static Connection conn=null;
	
	public static Connection getConnetion() {
		try {
			if(conn == null || conn.isClosed()) {
				String driver = "oracle.jdbc.driver.OracleDriver";
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String id = "c##admin1234";
				String pwd = "admin1234";
				
				Class.forName(driver);
				conn = DriverManager.getConnection(url,id,pwd);
					
			}
		} catch (ClassNotFoundException e) {
			System.out.println("driver 못 찾음, ojdbc lib 확인");
			e.printStackTrace(); //driver 못 찾음, ojdbc lib 확인
		} catch (SQLException e) {
			System.out.println("url, id, pwd 입력 확인");
			e.printStackTrace(); //url, id, pwd 입력 확인
		}
		
		return conn;
		
	}
	
	public static void close(PreparedStatement pstmt, ResultSet rs) {
		try {
			if(conn!=null) {
				conn.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
