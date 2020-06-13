package dto;

public class MyPageAlarmDTO {
	private int alarmNo;
	private String myPageTitle;
	public MyPageAlarmDTO() {
		// TODO Auto-generated constructor stub
	}
	public MyPageAlarmDTO(int alarmNo, String myPageTitle) {
		super();
		this.alarmNo = alarmNo;
		this.myPageTitle = myPageTitle;
	}
	public int getAlarmNo() {
		return alarmNo;
	}
	public void setAlarmNo(int alarmNo) {
		this.alarmNo = alarmNo;
	}
	public String getMyPageTitle() {
		return myPageTitle;
	}
	public void setMyPageTitle(String myPageTitle) {
		this.myPageTitle = myPageTitle;
	}
	@Override
	public String toString() {
		return "MyPageAlarmDTO [alarmNo=" + alarmNo + ", myPageTitle="
				+ myPageTitle + "]";
	}
	
	
}
