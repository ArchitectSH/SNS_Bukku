package dto;

public class GroupAlarmDTO {
	private int alarmNo;
	private int groupNo;
	public GroupAlarmDTO() {
		// TODO Auto-generated constructor stub
	}
	public GroupAlarmDTO(int alarmNo, int groupNo) {
		super();
		this.alarmNo = alarmNo;
		this.groupNo = groupNo;
	}
	public int getAlarmNo() {
		return alarmNo;
	}
	public void setAlarmNo(int alarmNo) {
		this.alarmNo = alarmNo;
	}
	public int getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
	@Override
	public String toString() {
		return "GroupAlarmDTO [alarmNo=" + alarmNo + ", groupNo=" + groupNo
				+ "]";
	}
	
	
}
