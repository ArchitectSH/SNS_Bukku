package model;

import java.util.HashMap;
import java.util.Map;

public class UserInfoList {
	private Map<String, UserInfo> userInfoList;
		
	public UserInfoList() {
		this.userInfoList = new HashMap<String,UserInfo>();
	}

	public UserInfoList(Map<String,UserInfo> userInfoList) {
		this.userInfoList=userInfoList;
	
	}
		/*
	
	public int login(String id, String password) {
	
	}
	
	public List<UserPublicInfo> searchUserByName(String name) {
	
	}
	
	public List<UserPublicInfo> searchUserByName(List<UserPublicInfo> allInfo, String name) {
	
	}
	
	public List<UserPublicInfo> searchUserBySchool(String school) {
	
	}
	
	public List<UserPublicInfo> searchUserBySchool(List<UserPublicInfo> allInfo, String school) {
	
	}
	
	public List<UserPublicInfo> searchUserByLocation(String location) {
	
	}
	
	public List<UserPublicInfo> searchUserByLocation(List<UserPublicInfo> allInfo, String location) {
	
	}
	
	public List<UserPublicInfo> searchUserByBirth(String birth) {
	
	}
	
	public List<UserPublicInfo> searchUserByBirth(List<UserPublicInfo> allInfo, String birth) {
	
	}
	
	public UserPublicInfo searchUserById(String id) {
	
	}
	
	public List<UserPublicInfo> searchUserById(List<UserPublicInfo> allInfo, String id) {
	
	}
	
	public List<UserPublicInfo> searchUserByGender(int gender) {
	
	}
	
	public List<UserPublicInfo> searchUserByGender(List<UserPublicInfo> allInfo, int gender) {
	
	}
	
	public UserPublicInfo searchUserByPhoneNumber(String phoneNumber) {
	
	}
	
	public List<UserPublicInfo> searchUserByPhoneNumber(List<UserPublicInfo> allInfo, String phoneNumber) {
	
	}
	
	public UserPublicInfo searchUserByEmail(String email) {
	
	}
	
	public List<UserPublicInfo> searchUserByEmail(List<UserPublicInfo> allInfo, String email) {
	
	}
	
	public UserPublicInfo searchUser(String name, String school, String location, String birth, String id, int gender, String phoneNumbrt, String email) {
	
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
	
	public String offerAccountPwByEmail(String id, String email) {
	
	}
	
	public int withdrawUser(String id, String password) {
	
	}*/
	
	public int joinMemeber(UserInfo userInfo) {
		if(userInfoList.containsKey(userInfo.getUserPublicInfo().getId())==false){
			
			userInfoList.put(userInfo.getUserPublicInfo().getId(),userInfo);
			return 1;
		}
		return 0;
	}
	
	/*public int joinMemeber(String id, String name, String birth, int gender, UserPrivateInfo userPrivateInfo) {
	
	}
	
	public int joinMemeber(UserPublicInfo userPublicInfo, UserPrivateInfo userPrivateInfo, String birth, int gender) {
	
	}
	
	public int joinMemeber(UserPublicInfo userPublicInfo, String password, String birth, int gender, String email, String phoneNumber) {
	
	}
	
	public int joinMemeber(String id, String password, String name, String birth, int gender, String email, String phoneNumber) {
	
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


	public Map<String, UserInfo> getUserInfoList() {
		return userInfoList;
	}

	@Override
	public String toString() {
		return "UserInfoList [userInfoList=" + userInfoList + "]";
	}

	public void setUserInfoList(Map<String, UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}
}
