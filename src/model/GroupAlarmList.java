package model;

import java.util.List;
import java.util.Map;

import enums.AlarmAct;

public class GroupAlarmList {
	public Map<String,List<GroupAlarm>> groupAlarmList;
	public GroupAlarmList() {
		// TODO Auto-generated constructor stub
	}
	public GroupAlarmList(Map<String, List<GroupAlarm>> groupAlarmList) {
		super();
		this.groupAlarmList = groupAlarmList;
	}


/*
	public int addAlarm(String id, GroupAlarm groupAlarm) {
	
	}
	
	public int addAlarm(int groupNo, AlarmAct alarmAct, String senderId, String receiverId) {
	
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
