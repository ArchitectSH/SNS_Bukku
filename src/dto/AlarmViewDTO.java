package dto;

public class AlarmViewDTO {
	private int alarmNo;
	private String senderId;
	private String senderName;
	private String senderProfileImg;
	private int senderBukkuIndex;
	private String activityKind;
	private String receiverId;;
	private int receiverBukkuIndex;
	private String activityDate;
	private int checkAlarm;
	private int postNo;
	private int groupNo;
	private String mypageTitle;
	public AlarmViewDTO() {
		super();
	}
	public AlarmViewDTO(int alarmNo, String senderId, String senderName,
			String senderProfileImg, int senderBukkuIndex, String activityKind,
			String receiverId, int receiverBukkuIndex, String activityDate,
			int checkAlarm, int postNo, int groupNo, String mypageTitle) {
		super();
		this.alarmNo = alarmNo;
		this.senderId = senderId;
		this.senderName = senderName;
		this.senderProfileImg = senderProfileImg;
		this.senderBukkuIndex = senderBukkuIndex;
		this.activityKind = activityKind;
		this.receiverId = receiverId;
		this.receiverBukkuIndex = receiverBukkuIndex;
		this.activityDate = activityDate;
		this.checkAlarm = checkAlarm;
		this.postNo = postNo;
		this.groupNo = groupNo;
		this.mypageTitle = mypageTitle;
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
	public int getSenderBukkuIndex() {
		return senderBukkuIndex;
	}
	public void setSenderBukkuIndex(int senderBukkuIndex) {
		this.senderBukkuIndex = senderBukkuIndex;
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
	public int getReceiverBukkuIndex() {
		return receiverBukkuIndex;
	}
	public void setReceiverBukkuIndex(int receiverBukkuIndex) {
		this.receiverBukkuIndex = receiverBukkuIndex;
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
	public String toString() {
		return "AlarmViewDTO [alarmNo=" + alarmNo + ", senderId=" + senderId
				+ ", senderName=" + senderName + ", senderProfileImg="
				+ senderProfileImg + ", senderBukkuIndex=" + senderBukkuIndex
				+ ", activityKind=" + activityKind + ", receiverId="
				+ receiverId + ", receiverBukkuIndex=" + receiverBukkuIndex
				+ ", activityDate=" + activityDate + ", checkAlarm="
				+ checkAlarm + ", postNo=" + postNo + ", groupNo=" + groupNo
				+ ", mypageTitle=" + mypageTitle + "]";
	}
	
}