package sakila.vo;

public class Staff {
	//	11���� �ʵ尡 �ʿ��ϴ�. (�Ӽ�, �ɹ� ����)
	//	toString �ż��� �������̵�
	
	private int staffId;
	private String username;
	private String password;
	private String email;
	
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", username=" + username + ", password=" + password + ", email=" + email + "]";
	}
	
}
