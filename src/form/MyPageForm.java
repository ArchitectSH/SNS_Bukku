package form;

public class MyPageForm {
	private String title;
	private String img;
	private String myPageIntroduction;
	public MyPageForm() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the img
	 */
	public String getImg() {
		return img;
	}
	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}
	/**
	 * @return the myPageIntroduction
	 */
	public String getMyPageIntroduction() {
		return myPageIntroduction;
	}
	/**
	 * @param myPageIntroduction the myPageIntroduction to set
	 */
	public void setMyPageIntroduction(String myPageIntroduction) {
		this.myPageIntroduction = myPageIntroduction;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MyPageForm [title=" + title + ", img=" + img
				+ ", myPageIntroduction=" + myPageIntroduction + "]";
	}
	
}
