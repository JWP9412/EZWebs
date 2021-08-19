package soldb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class OracleSQL {
	
	static public void main(String[] args) {
		OracleSQL oracle = new OracleSQL();
		// oracle.insertPrepared();
		// oracle.insert("1000", "abc", "010-0101-0111");
		
		// oracle.delete("2000");
		// oracle.delete("2100");
		// oracle.delete("2200");
		
		// oracle.update("3100", "삼돌이", "3100-0003-3333");
		// oracle.select();
		// oracle.select();
		oracle.select("사%");
	}
	
	public void update(String hid, String hname, String htel) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			String sql = "UPDATE hello SET hname = ?, htel = ? WHERE hid = ?";

			conn = OracleConnector.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, hname);
			stmt.setString(2, htel);
			stmt.setString(3, hid);
				
			int success = stmt.executeUpdate();
			if(success > 0) {
				System.out.println("[OracleSQL] update succeed : hid=" + hid);
			}
			else {
				System.out.println("[OracleSQL] update failed : hid=" + hid);
			}
		}
		catch(SQLException e) {
			System.out.println("[OracleSQL] update exception" + e.toString());
		}
		finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
			}
			catch(Exception e) {
				System.out.println("[sqlQuery] finally SQLException: " + e.toString());
			}
			
			OracleConnector.closeConnection();
		}		
	}
	
	
	public void delete(String hid) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			String sql = "DELETE FROM hello WHERE hid = ?";

			conn = OracleConnector.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, hid);
				
			int success = stmt.executeUpdate();
			if(success > 0) {
				System.out.println("[OracleSQL] delete succeed : hid=" + hid);
			}
			else {
				System.out.println("[OracleSQL] delete failed : hid=" + hid);
			}
		}
		catch(SQLException e) {
			System.out.println("[OracleSQL] delete exception" + e.toString());
		}
		finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
			}
			catch(Exception e) {
				System.out.println("[sqlQuery] finally SQLException: " + e.toString());
			}
			
			OracleConnector.closeConnection();
		}		
	}

	
	public void insertPrepared() {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			String sql = "INSERT INTO hello VALUES(?, ?, ?)";

			conn = OracleConnector.getConnection();
			stmt = conn.prepareStatement(sql);
			
			for(int cnt=4000; cnt <= 4010; cnt++) {
				String hid = String.valueOf(cnt);
				String hname = String.format("사오정%d", cnt);
				String htel = String.format("010-4000-%d", cnt);
				
				stmt.setString(1, hid);
				stmt.setString(2, hname);
				stmt.setString(3, htel);
				
				int success = stmt.executeUpdate();
				if(success > 0) {
					System.out.println("[OracleSQL] insertPrepared succeed!");
				}
				else {
					System.out.println("[OracleSQL] insertPrepared failed?");
				}
			}
		}
		catch(SQLException e) {
			System.out.println("[OracleSQL] insert exception" + e.toString());
		}
		finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
			}
			catch(Exception e) {
				System.out.println("[sqlQuery] finally SQLException: " + e.toString());
			}
			
			OracleConnector.closeConnection();
		}		
	}
	
	
	public void insert(String hid, String hname, String htel) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = OracleConnector.getConnection();
			stmt = conn.createStatement();
			
			String sql = String.format("INSERT INTO hello VALUES('%s', '%s', '%s')", hid, hname, htel);
			int success = stmt.executeUpdate(sql);
			if(success > 0) {
				System.out.println("[OracleSQL] insert succeed!");
			}
			else {
				System.out.println("[OracleSQL] insert failed?");
			}
		}
		catch(SQLException e) {
			System.out.println("[OracleSQL] insert exception" + e.toString());
		}
		finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
			}
			catch(Exception e) {
				System.out.println("[sqlQuery] finally SQLException: " + e.toString());
			}
			
			OracleConnector.closeConnection();
		}		
	}
	
	public void select() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM hello ORDER BY hid";
			
			conn = OracleConnector.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			System.out.printf("[ID]  [NAME]  [TEL]%n");
			
			while(rs.next()) {
				String hid = rs.getString(1);
				String hname = rs.getString(2);
				String htel = rs.getString(3);
				
				System.out.printf("[%s][%s][%s]%n", hid, hname, htel);
			}
		}
		catch(SQLException e) {
			System.out.println("[sqlQuery] SQLException: " + e.toString());
		}
		finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
			}
			catch(Exception e) {
				System.out.println("[sqlQuery] finally SQLException: " + e.toString());
			}
			
			OracleConnector.closeConnection();
		}
	}
	
	public void select(String query) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM hello WHERE hname like ? ORDER BY hid";
			
			conn = OracleConnector.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, query);
			
			rs = stmt.executeQuery();
			
			System.out.printf("[ID]  [NAME]  [TEL]%n");
			
			while(rs.next()) {
				String hid = rs.getString(1);
				String hname = rs.getString(2);
				String htel = rs.getString(3);
				
				System.out.printf("[%s][%s][%s]%n", hid, hname, htel);
			}
		}
		catch(SQLException e) {
			System.out.println("[sqlQuery] SQLException: " + e.toString());
		}
		finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
			}
			catch(Exception e) {
				System.out.println("[sqlQuery] finally SQLException: " + e.toString());
			}
			
			OracleConnector.closeConnection();
		}
	}
	

}
