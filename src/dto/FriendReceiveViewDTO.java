package dto;

public class FriendReceiveViewDTO {
	private String requestId;
	private String requestProfileImg;
	private String requestName;
	private String receiveId;
	private String receiveProfileImg;
	private String receiveName;
	public FriendReceiveViewDTO() {
		super();
	}
	public FriendReceiveViewDTO(String requestId, String requestProfileImg,
			String requestName, String receiveId, String receiveProfileImg,
			String receiveName) {
		super();
		this.requestId = requestId;
		this.requestProfileImg = requestProfileImg;
		this.requestName = requestName;
		this.receiveId = receiveId;
		this.receiveProfileImg = receiveProfileImg;
		this.receiveName = receiveName;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getRequestProfileImg() {
		return requestProfileImg;
	}
	public void setRequestProfileImg(String requestProfileImg) {
		this.requestProfileImg = requestProfileImg;
	}
	public String getRequestName() {
		return requestName;
	}
	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}
	public String getReceiveId() {
		return receiveId;
	}
	public void setReceiveId(String receiveId) {
		this.receiveId = receiveId;
	}
	public String getReceiveProfileImg() {
		return receiveProfileImg;
	}
	public void setReceiveProfileImg(String receiveProfileImg) {
		this.receiveProfileImg = receiveProfileImg;
	}
	public String getReceiveName() {
		return receiveName;
	}
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}
	
	public String toString() {
		return "FriendReceiveViewDTO [requestId=" + requestId
				+ ", requestProfileImg=" + requestProfileImg + ", requestName="
				+ requestName + ", receiveId=" + receiveId
				+ ", receiveProfileImg=" + receiveProfileImg + ", receiveName="
				+ receiveName + "]";
	}
	
	

}
