package viewHelperBean;

public class MyPageViewBean {
	private String title;
	private String img;
	private String introduction;
	private int followerNum;
	private String masterId;
	
	public MyPageViewBean() {
		// TODO Auto-generated constructor stub
	}
	public MyPageViewBean(String title, String img, String introduction,
			int followerNum, String masterId) {
		super();
		this.title = title;
		this.img = img;
		this.introduction = introduction;
		this.followerNum = followerNum;
		this.masterId = masterId;
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
	 * @return the introduction
	 */
	public String getIntroduction() {
		return introduction;
	}
	/**
	 * @param introduction the introduction to set
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	/**
	 * @return the followerNum
	 */
	public int getFollowerNum() {
		return followerNum;
	}
	/**
	 * @param followerNum the followerNum to set
	 */
	public void setFollowerNum(int followerNum) {
		this.followerNum = followerNum;
	}
	/**
	 * @return the masterId
	 */
	public String getMasterId() {
		return masterId;
	}
	/**
	 * @param masterId the masterId to set
	 */
	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "MyPageViewBean [title=" + title + ", img=" + img
				+ ", introduction=" + introduction + ", followerNum="
				+ followerNum + ", masterId=" + masterId + "]";
	}
	
}
