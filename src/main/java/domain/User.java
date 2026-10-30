package domain;

public class User {

	private String id;
	private String pw;
	private int role;
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + ", role=" + role + "]";
	}
	
	
}
