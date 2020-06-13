package dto;
public class FriendRelationDTO {
	private int friendRelationCode;
	private int bukkuIndex;
	private int friendNo;
	private String id;
	public FriendRelationDTO() {
		// TODO Auto-generated constructor stub
	}
	public FriendRelationDTO(int friendRelationCode, int bukkuIndex,
			int friendNo, String id) {
		super();
		this.friendRelationCode = friendRelationCode;
		this.bukkuIndex = bukkuIndex;
		this.friendNo = friendNo;
		this.id = id;
	}
	public int getFriendRelationCode() {
		return friendRelationCode;
	}
	public void setFriendRelationCode(int friendRelationCode) {
		this.friendRelationCode = friendRelationCode;
	}
	public int getBukkuIndex() {
		return bukkuIndex;
	}
	public void setBukkuIndex(int bukkuIndex) {
		this.bukkuIndex = bukkuIndex;
	}
	public int getFriendNo() {
		return friendNo;
	}
	public void setFriendNo(int friendNo) {
		this.friendNo = friendNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "FriendRelationDTO [friendRelationCode=" + friendRelationCode
				+ ", bukkuIndex=" + bukkuIndex + ", friendNo=" + friendNo
				+ ", id=" + id + "]";
	}
	
}