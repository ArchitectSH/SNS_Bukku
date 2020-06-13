package dto;
import java.util.Date;

public class UserDTO {
	private String id;
	private String name;
	private String profileImg;
	private String password;
	private String email;
	private String phoneNumber;
	private int gender;
	private String birth;
	private String school;
	private String location;
	private String joinDate;
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}
	public UserDTO(String id, String name, String profileImg, String password,
			String email, String phoneNumber, int gender, String birth,
			String school, String location, String joinDate) {
		super();
		this.id = id;
		this.name = name;
		this.profileImg = profileImg;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.birth = birth;
		this.school = school;
		this.location = location;
		this.joinDate = joinDate;
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
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
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
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
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

	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", profileImg="
				+ profileImg + ", password=" + password + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", gender=" + gender
				+ ", birth=" + birth + ", school=" + school + ", location="
				+ location + ", joinDate=" + joinDate + "]";
	}
	
	
}
