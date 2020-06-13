package dto;
public class CommonRelationDTO {
	private int friendNo;
	private int bukkuLimit;
	private String bukkuActDate;
	public CommonRelationDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public CommonRelationDTO(int friendNo, int bukkuLimit, String bukkuActDate) {
		super();
		this.friendNo = friendNo;
		this.bukkuLimit = bukkuLimit;
		this.bukkuActDate = bukkuActDate;
	}
	public int getFriendNo() {
		return friendNo;
	}
	public void setFriendNo(int friendNo) {
		this.friendNo = friendNo;
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

	@Override
	public String toString() {
		return "CommonRelationDTO [friendNo=" + friendNo + ", bukkuLimit="
				+ bukkuLimit + ", bukkuActString=" + bukkuActDate + "]";
	}
	
}