package dto;

public class AlarmDTO {
	private int alarmNo;
	private String activityDate;
	private int checkAlarm;
	private String receiverId;
	private int activityNo;
	private String id;
	public AlarmDTO() {
		// TODO Auto-generated constructor stub
	}
	public AlarmDTO(int alarmNo, String activityDate, int checkAlarm,
			String receiverId, int activityNo, String id) {
		super();
		this.alarmNo = alarmNo;
		this.activityDate = activityDate;
		this.checkAlarm = checkAlarm;
		this.receiverId = receiverId;
		this.activityNo = activityNo;
		this.id = id;
	}
	public int getAlarmNo() {
		return alarmNo;
	}
	public void setAlarmNo(int alarmNo) {
		this.alarmNo = alarmNo;
	}
	public String getActivityDate() {
		return activityDate;
	}
	public void setActivityDate(String activityDate) {
		this.activityDate = activityDate;
	}
	public int getCheckAlarm() {
		return checkAlarm;
	}
	public void setCheckAlarm(int checkAlarm) {
		this.checkAlarm = checkAlarm;
	}
	public String getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	public int getActivityNo() {
		return activityNo;
	}
	public void setActivityNo(int activityNo) {
		this.activityNo = activityNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "AlarmDTO [alarmNo=" + alarmNo + ", activityDate="
				+ activityDate + ", checkAlarm=" + checkAlarm + ", receiverId="
				+ receiverId + ", activityNo=" + activityNo + ", id=" + id
				+ "]";
	}
	
}
