package dto;

public class FriendAddingUserDTO {
	private int friendAddingNo;
	private String requestId;
	private String receiveId;
	public FriendAddingUserDTO() {
		// TODO Auto-generated constructor stub
	}
	public FriendAddingUserDTO(int friendAddingNo, String requestId,
			String receiveId) {
		super();
		this.friendAddingNo = friendAddingNo;
		this.requestId = requestId;
		this.receiveId = receiveId;
	}
	public int getFriendAddingNo() {
		return friendAddingNo;
	}
	public void setFriendAddingNo(int friendAddingNo) {
		this.friendAddingNo = friendAddingNo;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getReceiveId() {
		return receiveId;
	}
	public void setReceiveId(String receiveId) {
		this.receiveId = receiveId;
	}
	@Override
	public String toString() {
		return "FriendAddingUserDTO [friendAddingNo=" + friendAddingNo
				+ ", requestId=" + requestId + ", receiveId=" + receiveId + "]";
	}
	
	
}
