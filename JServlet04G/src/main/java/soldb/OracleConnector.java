package soldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnector {
	static final String driver = "oracle.jdbc.driver.OracleDriver";
	static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	// static final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	static final String userid = "SOLUSER";
	static final String password = "SOLUSER";
	
	private static Connection stconn = null;
	
	public static void main(String[] args) {
		try {
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, userid, password);
			System.out.println("Connection: success: " + (conn != null));
			
			boolean dbclosed = conn.isClosed();
			System.out.println("Connection: closed: " + dbclosed);
			
			conn.close();
			System.out.println("Close: closed: " + conn.isClosed());
		}
		catch(ClassNotFoundException e) {
			System.out.println("[main] ClassNotFoundException: " + e.toString());
		}
		catch(SQLException e) {
			System.out.println("[main] SQLException: " + e.toString());
		}
		catch(Exception e) {
			System.out.println("[main] Exception: " + e.toString());
		}
	}	
	
	public static Connection getConnection() {
		try {
			if(stconn != null) {
				return stconn;
			}
			
			Class.forName(driver);
			stconn = DriverManager.getConnection(url, userid, password);
		}
		catch(ClassNotFoundException e) {
			System.out.println("[getConnection] ClassNotFoundException: " + e.toString());
		}
		catch(SQLException e) {
			System.out.println("[getConnection] SQLException: " + e.toString());
		}
		catch(Exception e) {
			System.out.println("[getConnection] Exception: " + e.toString());
		}
		
		return stconn;
	}
	
	public static void closeConnection() {
		try {
			if(stconn != null && stconn.isClosed() != true) {
				stconn.close();
			}
			stconn = null;
		}
		catch(SQLException e) {
			System.out.println("[closeConnection] SQLException: " + e.toString());
		}
		catch(Exception e) {
			System.out.println("[closeConnection] Exception: " + e.toString());
		}
	}
	

}
