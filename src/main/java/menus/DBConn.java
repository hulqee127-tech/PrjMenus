package menus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	// 연결 문자열
	private String ora_driver = "oracle.jdbc.driver.OracleDriver";
	//private String ora_url = "jdbc:oracle:thin:@192.168.0.41:1521:xe";
	private String ora_url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String ora_username = "sky";
	private String ora_password = "1234";
	
	private Connection ora_conn = null;
	
	// DB 연결
	public Connection getConnection() {
		try {
			Class.forName(ora_driver);
			ora_conn = DriverManager.getConnection(ora_url,ora_username,ora_password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 설정을 확인하세요.");
		} catch (SQLException e) {
			System.out.println("DB연결이 잘못되었습니다.");
		}
		return ora_conn;
	}
	
}
