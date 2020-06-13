package model;




public class UserPrivateInfo {
	private String password;
	private String email;
	private String phoneNumber;
	private String joinDate;
	public UserPrivateInfo() {
	
	}
	
	

	public UserPrivateInfo(String password, String email, String phoneNumber,
			String joinDate) {
		super();
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.joinDate = joinDate;
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "UserPrivateInfo [password=" + password + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", joinDate=" + joinDate
				+ "]";
	}
	
}
