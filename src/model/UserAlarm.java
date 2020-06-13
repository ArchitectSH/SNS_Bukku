package model;

import enums.AlarmAct;

public class UserAlarm {
	private String actTime;
	private boolean alarmCheck;
	private int alarmNo;
	private AlarmAct alarmAct;
	private String senderId;
	public UserAlarm() {
		// TODO Auto-generated constructor stub
	}
	public UserAlarm(String actTime, boolean alarmCheck, int alarmNo,
			AlarmAct alarmAct, String senderId) {
		super();
		this.actTime = actTime;
		this.alarmCheck = alarmCheck;
		this.alarmNo = alarmNo;
		this.alarmAct = alarmAct;
		this.senderId = senderId;
	}
	/**
	 * @return the actTime
	 */
	public String getActTime() {
		return actTime;
	}
	/**
	 * @param actTime the actTime to set
	 */
	public void setActTime(String actTime) {
		this.actTime = actTime;
	}
	/**
	 * @return the alarmCheck
	 */
	public boolean isAlarmCheck() {
		return alarmCheck;
	}
	/**
	 * @param alarmCheck the alarmCheck to set
	 */
	public void setAlarmCheck(boolean alarmCheck) {
		this.alarmCheck = alarmCheck;
	}
	/**
	 * @return the alarmNo
	 */
	public int getAlarmNo() {
		return alarmNo;
	}
	/**
	 * @param alarmNo the alarmNo to set
	 */
	public void setAlarmNo(int alarmNo) {
		this.alarmNo = alarmNo;
	}
	/**
	 * @return the alarmAct
	 */
	public AlarmAct getAlarmAct() {
		return alarmAct;
	}
	/**
	 * @param alarmAct the alarmAct to set
	 */
	public void setAlarmAct(AlarmAct alarmAct) {
		this.alarmAct = alarmAct;
	}
	/**
	 * @return the senderId
	 */
	public String getSenderId() {
		return senderId;
	}
	/**
	 * @param senderId the senderId to set
	 */
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserAlarm [actTime=" + actTime + ", alarmCheck=" + alarmCheck
				+ ", alarmNo=" + alarmNo + ", senderId=" + senderId + "]";
	}
}
