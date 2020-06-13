package dto;

import java.io.Serializable;

public class MyPageFollowingDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6089730214632242153L;
	private int followingNo;
	private String myPageTitle;
	private String id;
	
	public MyPageFollowingDTO() {
		// TODO Auto-generated constructor stub
	}

	public MyPageFollowingDTO(int followingNo, String myPageTitle,
			String id) {
		super();
		this.followingNo = followingNo;
		this.myPageTitle = myPageTitle;
		this.id = id;
	}

	public int getFollowingNo() {
		return followingNo;
	}

	public void setFollowingNo(int followingNo) {
		this.followingNo = followingNo;
	}

	public String getMyPageTitle() {
		return myPageTitle;
	}

	public void setMyPageTitle(String myPageTitle) {
		this.myPageTitle = myPageTitle;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MyPageFollowingDTO [followingNo=" + followingNo
				+ ", myPageTitle=" + myPageTitle + ", id=" + id + "]";
	}
	
}
