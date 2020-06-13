package model;

public class MyPagePost extends UserPost{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2097148380896077690L;
	private String myPageTitle;
	public MyPagePost() {
		// TODO Auto-generated constructor stub
	}
	public MyPagePost(String myPageTitle, int postNo, PostContent postContent, UserPublicInfo writer,
			PrivacyLevel privacyLevel, String postingTime) {
		super(postNo, postContent, writer, privacyLevel, postingTime);
		this.myPageTitle = myPageTitle;
	}
	public String getMyPageTitle() {
		return myPageTitle;
	}
	public void setMyPageTitle(String myPageTitle) {
		this.myPageTitle = myPageTitle;
	}
	@Override
	public String toString() {
		return "MyPagePost [myPageTitle=" + myPageTitle + "]";
	}
	
}
