package model;

import java.util.List;
import java.util.Map;

import enums.AlarmAct;

public class UserAlarmList {
	private Map<String,List<UserAlarm>> userAlarmList;
	public UserAlarmList() {
		// TODO Auto-generated constructor stub
	}
	
	public UserAlarmList(Map<String, List<UserAlarm>> userAlarmList) {
		super();
		this.userAlarmList = userAlarmList;
	}
/*
	public int addAlarm(String id, UserAlarm userAlarm) {
	
	}
	
	public int addAlarm(AlarmAct alarmAct, String senderId, String receiverId) {
	
	}
	
	public List<UserAlarm> searchAlarm(String id) {
	
	}
	
	public int deleteAlarm(String id, int alarmNo) {
	
	}
	
	public int updateAlarm(String id, int alarmNo, UserAlarm userAlarm) {
	
	}
	
	public int checkAlarm(int alarmNo) {
	
	}*/
}
