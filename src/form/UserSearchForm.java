package form;

public class UserSearchForm {	
	private String id;
	private String name;
	private String gender;
	private String school;
	private String location;
	private String birth;
	private String email;
	private String phoneNumber;
	public UserSearchForm() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
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
	@Override
	public String toString() {
		return "UserSearchForm [id=" + id + ", name=" + name + ", gender="
				+ gender + ", school=" + school + ", location=" + location
				+ ", birth=" + birth + ", email=" + email + ", phoneNumber="
				+ phoneNumber + "]";
	}
	
	
}
