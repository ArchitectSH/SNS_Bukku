package dto;

import java.io.Serializable;

public class FollowingMyPageViewDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3291411409612437441L;
	private String followerId;
	private String myPageTitle;
	private String myPageImg;
	private String masterId;
	public FollowingMyPageViewDTO() {
		// TODO Auto-generated constructor stub
	}
	public FollowingMyPageViewDTO(String followerId, String myPageTitle,
			String myPageImg, String masterId) {
		super();
		this.followerId = followerId;
		this.myPageTitle = myPageTitle;
		this.myPageImg = myPageImg;
		this.masterId = masterId;
	}
	public String getFollowerId() {
		return followerId;
	}
	public void setFollowerId(String followerId) {
		this.followerId = followerId;
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
		return "FollowingMyPageViewDTO [followerId=" + followerId
				+ ", myPageTitle=" + myPageTitle + ", myPageImg=" + myPageImg
				+ ", masterId=" + masterId + "]";
	}
	
	
}	
