package dto;

public class PostAlarmDTO {
	private int alarmNo;
	private int postNo;
	public PostAlarmDTO() {
		// TODO Auto-generated constructor stub
	}
	public PostAlarmDTO(int alarmNo, int postNo) {
		super();
		this.alarmNo = alarmNo;
		this.postNo = postNo;
	}
	public int getAlarmNo() {
		return alarmNo;
	}
	public void setAlarmNo(int alarmNo) {
		this.alarmNo = alarmNo;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	@Override
	public String toString() {
		return "PostAlarmDTO [alarmNo=" + alarmNo + ", postNo=" + postNo + "]";
	}
	
	
}
