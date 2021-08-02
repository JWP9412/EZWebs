package soldb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public final class OracleSQL {
	
	static public void main(String[] args) {
		OracleSQL oracle = new OracleSQL();
		oracle.sqlQuery();
	}
	
	public void sqlQuery() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM hello";
			
			conn = OracleConnector.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			System.out.printf("[ID] [NAME] [TEL]%n");
			
			while(rs.next()) {
				String hid = rs.getString(1);
				String hname = rs.getString(2);
				String htel = rs.getString(3);
				
				System.out.printf("[%s][%s][%s]%n",hid,hname,htel);
				
			}
		}
		catch (SQLException e) {
			System.out.println("[sqlQuery] SQLException : " + e.toString());
		}
		finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
			} catch (Exception e) {
				System.out.println("[sqlQuery] finally SQLException : " + e.toString());
			}
			
			OracleConnector.closeConnection();
		}
	}
}
