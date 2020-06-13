package form;
public class UserProfileForm {
	private String profileImg;
	private String school;
	private String location;
	public UserProfileForm() {
		super();
	}
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
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
	@Override
	public String toString() {
		return "UserProfileForm [profileImg=" + profileImg + ", school="
				+ school + ", location=" + location + "]";
	}
	
	
}
