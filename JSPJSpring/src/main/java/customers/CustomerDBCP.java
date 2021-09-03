package customers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CustomerDBCP {
	private DataSource datasource = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	
	public CustomerDBCP() {
		try {
			Context ctx = new InitialContext();
			Context env = (Context)ctx.lookup("java:/comp/env");
			datasource =  (DataSource)env.lookup("jdbc/oracle");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 입력
	public void insertCustomer(CustomerVO customerVO) {
		String sql = "INSERT INTO customer (cno, cname, ctel, address) VALUES(?, ?, ?, ?)";
		
		try {
			conn = datasource.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, customerVO.getCno());
			stmt.setString(2, customerVO.getCname());
			stmt.setString(3, customerVO.getCtel());
			stmt.setString(4, customerVO.getAddress());
			
			stmt.executeUpdate();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 수정
	public void editCustomer(CustomerVO customerVO) {
		String sql = "UPDATE customer SET cname=?, ctel=?, address=? WHRER cno=?";
		
		try {
			conn = datasource.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, customerVO.getCname());
			stmt.setString(2, customerVO.getCtel());
			stmt.setString(3, customerVO.getAddress());
			stmt.setString(4, customerVO.getCno());
			
			stmt.executeUpdate();
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	// 삭제
	public void delCustomer(String cno) {
		String sql = "DELETE FROM customer WHERE cno = ?";
		
		try {
			conn = datasource.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, cno);
			stmt.executeUpdate();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// 조회
	public List<CustomerVO> getCustomer(){
		List<CustomerVO> listCustomers = new ArrayList<CustomerVO>();
		
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM customer ORDER BY cno";
			
			conn = datasource.getConnection();
			
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				String cno = rs.getString("cno");
				String cname = rs.getString("cname");
				String ctel = rs.getString("ctel");
				String address = rs.getString("address");
				
				CustomerVO customer = new CustomerVO();
				customer.setCno(cno);
				customer.setCname(cname);
				customer.setCtel(ctel);
				customer.setAddress(address);
				
				listCustomers.add(customer);
			}
		} catch (SQLException e) {
			System.out.println("[getCustomers] SQLException : "+e.toString());
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				conn.close();
			}catch (Exception e) {
				System.out.println("[getCustomers] finally SQLException : "+e.toString());
			}
		}
		return listCustomers;
	}
	
}
