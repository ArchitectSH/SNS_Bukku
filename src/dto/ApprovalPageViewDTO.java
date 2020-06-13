package dto;

import java.io.Serializable;

public class ApprovalPageViewDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8633471520564196623L;
	private String invitedId;
	private String myPageTitle;
	private String myPageImg;
	private String masterId;
	public ApprovalPageViewDTO() {
		// TODO Auto-generated constructor stub
	}
	public ApprovalPageViewDTO(String invitedId, String myPageTitle,
			String myPageImg, String masterId) {
		super();
		this.invitedId = invitedId;
		this.myPageTitle = myPageTitle;
		this.myPageImg = myPageImg;
		this.masterId = masterId;
	}
	public String getInvitedId() {
		return invitedId;
	}
	public void setInvitedId(String invitedId) {
		this.invitedId = invitedId;
	}
	public String getMyPageTitle() {
		return myPageTitle;
	}
	public void setMyPageTitle(String myPageTitle) {
		this.myPageTitle = myPageTitle;
	}
	public String getMyPageImg() {
		return myPageImg;
	}
	public void setMyPageImg(String myPageImg) {
		this.myPageImg = myPageImg;
	}
	public String getMasterId() {
		return masterId;
	}
	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ApprovalPageViewDTO [invitedId=" + invitedId + ", myPageTitle="
				+ myPageTitle + ", myPageImg=" + myPageImg + ", masterId="
				+ masterId + "]";
	}
	
}
