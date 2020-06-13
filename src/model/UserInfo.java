package model;

public class UserInfo {
	private UserPublicInfo userPublicInfo;
	private Profile profile;
	private UserPrivateInfo userPrivateInfo;
	public UserInfo() {
		
	}
	
	
	
	public UserInfo(UserPublicInfo userPublicInfo, Profile profile,
			UserPrivateInfo userPrivateInfo) {
		super();
		this.userPublicInfo = userPublicInfo;
		this.profile = profile;
		this.userPrivateInfo = userPrivateInfo;
	}



	public UserInfo(UserPublicInfo userPublicInfo, int gender, UserPrivateInfo userPrivateInfo) {
		this.userPublicInfo = userPublicInfo;
		this.profile = new Profile(gender);
		this.userPrivateInfo = userPrivateInfo;
	}
	
	public UserInfo(String id, String password, String email, String phoneNumber, String name, int gender, String picture, String joinDate) {
		this.userPublicInfo = new UserPublicInfo(name,id,picture);
		this.profile = new Profile(gender);
		this.userPrivateInfo = new UserPrivateInfo(password,email,phoneNumber,joinDate);
	}
	/*
	public int login(String id, String password) {
	
	}
	
	public UserPublicInfo searchUserByName(String name) {
	
	}
	
	public UserPublicInfo searchUserBySchool(String school) {
	
	}
	
	public UserPublicInfo searchUserByLocation(String location) {
	
	}
	
	public UserPublicInfo searchUserByBirth(String birth) {
	
	}
	
	public UserPublicInfo searchUserById(String id) {
	
	}
	
	public UserPublicInfo searchUserByGender(int gender) {
	
	}
	
	public UserPublicInfo searchUserByPhoneNumber(String phoneNumber) {
	
	}
	
	public UserPublicInfo searchUserByEmail(String email) {
	
	}
	
	public int setProfile(String id, String school, String location, String picture) {
	
	}
	
	public int modifyUserInfo(String id, String password, String email, String phoneNumber) {
	
	}
	
	public String offerAccountIdByPhoneNumber(String name, String phoneNumber) {
	
	}
	
	public String offerAccountIdByEmail(String name, String email) {
	
	}
	
	public String offerAccountPwByPhoneNumber(String id, String phoneNumber) {
	
	}
	
	public int withdrawUser(String id, String password) {
	
	}
	
	public int stopUser(String id, boolean stopSetting) {
	
	}
	
	public int activateUser(String id, boolean activateSetting) {
	
	}
	
	public int setSearchLevel(String id, SearchLevel searchLevel) {
	
	}
	
	public int setAcceptingAlarm(String id, boolean acceptSetting) {
	
	}
	
	public int checkStopped(String id) {
	
	}
	
	public int checkActivated(String id) {
	
	}
	
	public int checkSearchLevel(String id) {
	
	}
	
	public int checkAcceptingAlarm(String id) {
	
	}*/

	public UserPublicInfo getUserPublicInfo() {
		return userPublicInfo;
	}

	public void setUserPublicInfo(UserPublicInfo userPublicInfo) {
		this.userPublicInfo = userPublicInfo;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public UserPrivateInfo getUserPrivateInfo() {
		return userPrivateInfo;
	}

	public void setUserPrivateInfo(UserPrivateInfo userPrivateInfo) {
		this.userPrivateInfo = userPrivateInfo;
	}

	@Override
	public String toString() {
		return "UserInfo [userPublicInfo=" + userPublicInfo + ", profile="
				+ profile + ", userPrivateInfo=" + userPrivateInfo + "]";
	}
	
}
