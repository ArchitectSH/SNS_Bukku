package model;

import java.util.List;
import java.util.Map;

import enums.AlarmAct;

public class MyPageAlarmList {
	private Map<String,List<MyPageAlarm>> myPageAlarmList;
	public MyPageAlarmList() {
		// TODO Auto-generated constructor stub
	}
	
	public MyPageAlarmList(Map<String, List<MyPageAlarm>> myPageAlarmList) {
		super();
		this.myPageAlarmList = myPageAlarmList;
	}
/*
	public int addAlarm(String id, MyPageAlarm myPageAlarm) {
	
	}
	
	public int addAlarm(String myPageTitle, AlarmAct alarmAct, String senderId, String receiverId) {
	
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
