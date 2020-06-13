package viewHelperBean;

public class FriendInfoViewBean {
	private String userId;
	private String friendId;
	private String friendProfileImg;
	private String friendName;
	private String friendSchool;
	private String friendLocation;
	private int friendGender;
	private int bukkuIndex;
	private int needCommunicationCnt;
	private String bukkuLevel;
	private String nextBukkuLevel;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFriendId() {
		return friendId;
	}
	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}
	public String getFriendProfileImg() {
		return friendProfileImg;
	}
	public void setFriendProfileImg(String friendProfileImg) {
		this.friendProfileImg = friendProfileImg;
	}
	public String getFriendName() {
		return friendName;
	}
	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}
	public String getFriendSchool() {
		return friendSchool;
	}
	public void setFriendSchool(String friendSchool) {
		this.friendSchool = friendSchool;
	}
	public String getFriendLocation() {
		return friendLocation;
	}
	public void setFriendLocation(String friendLocation) {
		this.friendLocation = friendLocation;
	}
	public int getFriendGender() {
		return friendGender;
	}
	public void setFriendGender(int friendGender) {
		this.friendGender = friendGender;
	}
	public int getBukkuIndex() {
		return bukkuIndex;
	}
	public void setBukkuIndex(int bukkuIndex) {
		this.bukkuIndex = bukkuIndex;
	}
	public int getNeedCommunicationCnt() {
		return needCommunicationCnt;
	}
	public void setNeedCommunicationCnt(int needCommunicationCnt) {
		this.needCommunicationCnt = needCommunicationCnt;
	}
	public String getBukkuLevel() {
		return bukkuLevel;
	}
	public void setBukkuLevel(String bukkuLevel) {
		this.bukkuLevel = bukkuLevel;
	}
	public String getNextBukkuLevel() {
		return nextBukkuLevel;
	}
	public void setNextBukkuLevel(String nextBukkuLevel) {
		this.nextBukkuLevel = nextBukkuLevel;
	}
	
	public String toString() {
		return "FriendInfoViewBean [userId=" + userId + ", friendId="
				+ friendId + ", friendProfileImg=" + friendProfileImg
				+ ", friendName=" + friendName + ", friendSchool="
				+ friendSchool + ", friendLocation=" + friendLocation
				+ ", friendGender=" + friendGender + ", bukkuIndex="
				+ bukkuIndex + ", needCommunicationCnt=" + needCommunicationCnt
				+ ", bukkuLevel=" + bukkuLevel + ", nextBukkuLevel="
				+ nextBukkuLevel + "]";
	}
	

}
