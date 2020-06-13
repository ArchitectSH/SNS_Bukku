package model;



public class Profile {
	private int gender;
	private String birth;
	private String school;
	private String location;
	public Profile() {
		this.gender = 0;
		this.birth = "000000";
		this.school = "학교없음";
		this.location = "주소없음";
	}
	


	public Profile(int gender) {
		super();
		this.gender = gender;
		this.birth = "000000";
		this.school = "학교없음";
		this.location = "주소없음";
	}



	public Profile(int gender, String birth, String school, String location) {
		super();
		this.gender = gender;
		this.birth = birth;
		this.school = school;
		this.location = location;
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

	@Override
	public String toString() {
		return "Profile [gender=" + gender + ", birth=" + birth + ", school="
				+ school + ", location=" + location + "]";
	}
	
}
