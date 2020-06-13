package model;

import java.util.HashMap;
import java.util.Map;


public class UserSettingList {
	private Map<String,UserSetting> userSettingList;
	public UserSettingList() {
		this.userSettingList = new HashMap<String,UserSetting>();
	}



	public void setUserSettingList(Map<String, UserSetting> userSettingList) {
		this.userSettingList = userSettingList;
	}


	public UserSettingList(Map<String, UserSetting> userSettingList) {
		super();
		this.userSettingList = userSettingList;
	}

	
	public Map<String, UserSetting> getUserSettingList() {
		return userSettingList;
	}



	@Override
	public String toString() {
		return "UserSettingList [userSettingList=" + userSettingList + "]";
	}
	



	public void addUserSetting(String id, UserSetting userSetting) {
		if(userSettingList.containsKey(id)==false){
			userSettingList.put(id, userSetting);
		}
	}
	
	public void removeUserSetting(String id) {
		
	}
	
	public int stopUser(String id, boolean stopSetting) {
		return 0;
	}
	
	public int activateUser(String id, boolean activateSetting) {
		return 0;
	}
	
	public int setSearchLevel(String id, SearchLevel searchLevel) {
		return 0;
	}
	
	public int setAcceptingAlarm(String id, boolean acceptSetting) {
		return 0;
	}
	
	public int checkStopped(String id) {
		return 0;
	}
	
	public int checkActivated(String id) {
		return 0;
	}
	
	public int checkSearchLevel(String id) {
		return 0;
	}
	
	public int checkAcceptingAlarm(String id) {
		return 0;
	
	}
}
