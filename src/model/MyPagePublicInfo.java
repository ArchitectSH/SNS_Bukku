package model;

public class MyPagePublicInfo {
	private String myPageTitle;
	private String myPageImg;
	public MyPagePublicInfo() {
		// TODO Auto-generated constructor stub
	}
	public MyPagePublicInfo(String myPageTitle, String myPageImg) {
		super();
		this.myPageTitle = myPageTitle;
		this.myPageImg = myPageImg;
	}
	/**
	 * @return the myPageTitle
	 */
	public String getMyPageTitle() {
		return myPageTitle;
	}
	/**
	 * @param myPageTitle the myPageTitle to set
	 */
	public void setMyPageTitle(String myPageTitle) {
		this.myPageTitle = myPageTitle;
	}
	/**
	 * @return the myPageImg
	 */
	public String getMyPageImg() {
		return myPageImg;
	}
	/**
	 * @param myPageImg the myPageImg to set
	 */
	public void setMyPageImg(String myPageImg) {
		this.myPageImg = myPageImg;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MyPagePublicInfo [myPageTitle=" + myPageTitle + ", myPageImg="
				+ myPageImg + "]";
	}
	
}
