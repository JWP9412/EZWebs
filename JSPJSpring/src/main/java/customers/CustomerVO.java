package customers;

public class CustomerVO {
	private String cno;
	private String cname;
	private String ctel;
	private String address;
	
	public CustomerVO() {}
	
	public CustomerVO(String cno,String cname,String ctel,String address) {
		this.cno = cno;
		this.cname = cname;
		this.ctel = ctel;
		this.address = address;
	}
	
	
	
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCtel() {
		return ctel;
	}
	public void setCtel(String ctel) {
		this.ctel = ctel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
