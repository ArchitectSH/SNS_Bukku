package model;



public class Friend {
	private UserPublicInfo userPublicInfo;
	private FriendRelation friendRelation;
	public Friend() {
		this.userPublicInfo = new UserPublicInfo();
		this.friendRelation = new FriendRelation();
	
	}
	public Friend(UserPublicInfo userPublicInfo, FriendRelation friendRelation) {
		super();
		this.userPublicInfo = userPublicInfo;
		this.friendRelation = friendRelation;
	}
	public UserPublicInfo getUserPublicInfo() {
		return userPublicInfo;
	}
	public void setUserPublicInfo(UserPublicInfo userPublicInfo) {
		this.userPublicInfo = userPublicInfo;
	}
	public FriendRelation getFriendRelation() {
		return friendRelation;
	}
	public void setFriendRelation(FriendRelation friendRelation) {
		this.friendRelation = friendRelation;
	}
	@Override
	public String toString() {
		return "Friend [userPublicInfo=" + userPublicInfo + ", friendRelation="
				+ friendRelation + "]";
	}
	
	
	
/*	
	public BukkuLevel getBukkuLevel() {
	
	}
	
	public int decreaseBukkuIndex() {
	
	}
	
	public int decreaseBukkuIndex(int num) {
	
	}
	
	public int increaseBukkuIndex() {
	
	}
	
	public int increaseBukkuIndex(int num) {
	
	}
	
	public int beAtti() {
	
	}*/
}
