package dto;

import java.io.Serializable;

public class MyPageInfoViewDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7991742722590098346L;
	private String myPageTitle;
	private String myPageImg;
	private String myPageIntroduction;
	private int myPageFollower;
	private String masterId;
	
	public MyPageInfoViewDTO() {
		// TODO Auto-generated constructor stub
	}

	public MyPageInfoViewDTO(String myPageTitle, String myPageImg,
			String myPageIntroduction, int myPageFollower, String masterId) {
		super();
		this.myPageTitle = myPageTitle;
		this.myPageImg = myPageImg;
		this.myPageIntroduction = myPageIntroduction;
		this.myPageFollower = myPageFollower;
		this.masterId = masterId;
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

	public String getMyPageIntroduction() {
		return myPageIntroduction;
	}

	public void setMyPageIntroduction(String myPageIntroduction) {
		this.myPageIntroduction = myPageIntroduction;
	}

	public int getMyPageFollower() {
		return myPageFollower;
	}

	public void setMyPageFollower(int myPageFollower) {
		this.myPageFollower = myPageFollower;
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
		return "MyPageInfoViewDTO [myPageTitle=" + myPageTitle + ", myPageImg="
				+ myPageImg + ", myPageIntroduction=" + myPageIntroduction
				+ ", myPageFollower=" + myPageFollower + ", masterId="
				+ masterId + "]";
	}
	
}
