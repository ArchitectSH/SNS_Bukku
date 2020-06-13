package viewHelperBean;

public class AlarmViewBean {
	private int alarmNo;
	private String senderId;
	private String senderName;
	private String senderProfileImg;
	private int bukkuIndex;
	private String activityKind;
	private String receiverId;
	private String activityDate;
	private int checkAlarm;
	private int postNo;
	private int groupNo;
	private String mypageTitle;
	public AlarmViewBean() {
		super();
	}
	public int getAlarmNo() {
		return alarmNo;
	}
	public void setAlarmNo(int alarmNo) {
		this.alarmNo = alarmNo;
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSenderProfileImg() {
		return senderProfileImg;
	}
	public void setSenderProfileImg(String senderProfileImg) {
		this.senderProfileImg = senderProfileImg;
	}
	public int getBukkuIndex() {
		return bukkuIndex;
	}
	public void setBukkuIndex(int bukkuIndex) {
		this.bukkuIndex = bukkuIndex;
	}
	public String getActivityKind() {
		return activityKind;
	}
	public void setActivityKind(String activityKind) {
		this.activityKind = activityKind;
	}
	public String getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
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
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public int getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
	public String getMypageTitle() {
		return mypageTitle;
	}
	public void setMypageTitle(String mypageTitle) {
		this.mypageTitle = mypageTitle;
	}
	@Override
	public String toString() {
		return "AlarmViewBean [alarmNo=" + alarmNo + ", senderId=" + senderId
				+ ", senderName=" + senderName + ", senderProfileImg="
				+ senderProfileImg + ", bukkuIndex=" + bukkuIndex
				+ ", activityKind=" + activityKind + ", receiverId="
				+ receiverId + ", activityDate=" + activityDate
				+ ", checkAlarm=" + checkAlarm + ", postNo=" + postNo
				+ ", groupNo=" + groupNo + ", mypageTitle=" + mypageTitle + "]";
	}
	
	

}
