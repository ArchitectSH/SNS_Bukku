package model;



public class FriendRelation {
	private int userBukkuIndex;
	private int friendBukkuIndex;
	private int bukkuLimit;
	private String bukkuActDate;
	private BukkuLevel bukkuLevel;
	
	public FriendRelation() {
		super();
		this.userBukkuIndex = 300;
		this.friendBukkuIndex = 300;
		this.bukkuLimit = 0;
		this.bukkuActDate = "¾øÀ½";
		this.bukkuLevel = null;
	}

	public FriendRelation(int userBukkuIndex, int friendBukkuIndex,
			int bukkuLimit, String bukkuActDate, BukkuLevel bukkuLevel) {
		super();
		this.userBukkuIndex = userBukkuIndex;
		this.friendBukkuIndex = friendBukkuIndex;
		this.bukkuLimit = bukkuLimit;
		this.bukkuActDate = bukkuActDate;
		this.bukkuLevel = bukkuLevel;
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

	public int getBukkuLimit() {
		return bukkuLimit;
	}

	public void setBukkuLimit(int bukkuLimit) {
		this.bukkuLimit = bukkuLimit;
	}

	public String getBukkuActDate() {
		return bukkuActDate;
	}

	public void setBukkuActDate(String bukkuActDate) {
		this.bukkuActDate = bukkuActDate;
	}

	public BukkuLevel getBukkuLevel() {
		return bukkuLevel;
	}

	public void setBukkuLevel(BukkuLevel bukkuLevel) {
		this.bukkuLevel = bukkuLevel;
	}

	@Override
	public String toString() {
		return "FriendRelation [userBukkuIndex=" + userBukkuIndex
				+ ", friendBukkuIndex=" + friendBukkuIndex + ", bukkuLimit="
				+ bukkuLimit + ", bukkuActDate=" + bukkuActDate
				+ ", bukkuLevel=" + bukkuLevel + "]";
	}
	

}
