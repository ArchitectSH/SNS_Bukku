package model;

import java.util.List;
import java.util.Map;

import enums.AlarmAct;


public class PostAlarmList {
	private Map<String,List<PostAlarm>> postAlarmList;
	public PostAlarmList() {
		// TODO Auto-generated constructor stub
	}
	public PostAlarmList(Map<String, List<PostAlarm>> postAlarmList) {
		super();
		this.postAlarmList = postAlarmList;
	}
	/*
	public int addAlarm(String id, PostAlarm postAlarm) {
	
	}
	
	public int addAlarm(int postNo, AlarmAct alarmAct, String senderId, String receiverId) {
	
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
