package members;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDBCP {
	private DataSource datasource = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;

	public MemberDBCP() {
		try {
			Context ctx = new InitialContext();
			Context env = (Context) ctx.lookup("java:/comp/env");
			datasource = (DataSource) env.lookup("jdbc/oracle");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addMember(MemberVO memberVO) {
		String sql = "INSERT INTO member (mid, mname, pwd, email) VALUES (?, ?, ?, ?)";
		
		try {
			conn = datasource.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, memberVO.getMid());
			stmt.setString(2, memberVO.getMname());
			stmt.setString(3, memberVO.getPwd());
			stmt.setString(4, memberVO.getEmail());
			
			stmt.executeUpdate();
			stmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<MemberVO> getMembers() {
		List<MemberVO> listMembers = new ArrayList<MemberVO>();

		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM member ORDER BY mid";

//				conn = OracleConnector.getConnection();
			conn = datasource.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			System.out.printf("[ID]  [NAME]  [TEL]%n");

			while (rs.next()) {
				String mid = rs.getString("mid");
				String mname = rs.getString("mname");
				String pwd = rs.getString("pwd");
				String email = rs.getString("email");
				Date regdate = rs.getDate("regdate");

				MemberVO member = new MemberVO();
				member.setMid(mid);
				member.setMname(mname);
				member.setPwd(pwd);
				member.setEmail(email);
				member.setRegdate(regdate);

				listMembers.add(member);
			}
		} catch (SQLException e) {
			System.out.println("[sqlQuery] SQLException: " + e.toString());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				conn.close();
			} catch (Exception e) {
				System.out.println("[sqlQuery] finally SQLException: " + e.toString());
			}

//				OracleConnector.closeConnection();

		}

		return listMembers;
	}
	public void delMember(String mid) {
		String sql = "DELETE FROM member WHERE mid = ?";
		
		try {
			conn = datasource.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, mid);
			stmt.executeUpdate();
			stmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
