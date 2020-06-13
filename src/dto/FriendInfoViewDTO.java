package dto;

public class FriendInfoViewDTO {
	private String userId;
	private String friendId;
	private String friendProfileImg;
	private String friendName;
	private String friendSchool;
	private String friendLocation;
	private int friendGender;
	private int userBukkuIndex;
	private int friendBukkuIndex;
	public FriendInfoViewDTO() {
		super();
	}
	public FriendInfoViewDTO(String userId, String friendId,
			String friendProfileImg, String friendName, String friendSchool,
			String friendLocation, int friendGender, int userBukkuIndex,
			int friendBukkuIndex) {
		super();
		this.userId = userId;
		this.friendId = friendId;
		this.friendProfileImg = friendProfileImg;
		this.friendName = friendName;
		this.friendSchool = friendSchool;
		this.friendLocation = friendLocation;
		this.friendGender = friendGender;
		this.userBukkuIndex = userBukkuIndex;
		this.friendBukkuIndex = friendBukkuIndex;
	}
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
	public int getUserBukkuIndex() {
		return userBukkuIndex;
	}
	public void setUserBukkuIndex(int userBukkuIndex) {
		this.userBukkuIndex = userBukkuIndex;
	}
	public int getFriendBukkuIndex() {
		return friendBukkuIndex;
	}
	public void setFriendBukkuIndex(int friendBukkuIndex) {
		this.friendBukkuIndex = friendBukkuIndex;
	}
	
	public String toString() {
		return "FriendInfoViewDTO [userId=" + userId + ", friendId=" + friendId
				+ ", friendProfileImg=" + friendProfileImg + ", friendName="
				+ friendName + ", friendSchool=" + friendSchool
				+ ", friendLocation=" + friendLocation + ", friendGender="
				+ friendGender + ", userBukkuIndex=" + userBukkuIndex
				+ ", friendBukkuIndex=" + friendBukkuIndex + "]";
	}
	
}