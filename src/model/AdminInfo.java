package model;

public class AdminInfo {
	private String id;
	private String password;
	public AdminInfo() {
		this.id = "���̵����";
		this.password = "�н��������";
	
	}
	
	public AdminInfo(String id, String password) {
		this.id = id;
		this.password = password;
	
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AdminInfo [id=" + id + ", password=" + password + "]";
	}
	
}
