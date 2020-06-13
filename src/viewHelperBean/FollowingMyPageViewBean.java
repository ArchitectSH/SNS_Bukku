package viewHelperBean;

public class FollowingMyPageViewBean {
	private String followerId;
	private String title;
	private String img;
	private String masterId;
	
	public FollowingMyPageViewBean() {
		// TODO Auto-generated constructor stub
	}
	public FollowingMyPageViewBean(String followerId, String title, String img,
			String masterId) {
		super();
		this.followerId = followerId;
		this.title = title;
		this.img = img;
		this.masterId = masterId;
	}
	/**
	 * @return the followerId
	 */
	public String getFollowerId() {
		return followerId;
	}
	/**
	 * @param followerId the followerId to set
	 */
	public void setFollowerId(String followerId) {
		this.followerId = followerId;
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
		return "FollowingMyPageViewBean [followerId=" + followerId + ", title="
				+ title + ", img=" + img + ", masterId=" + masterId + "]";
	}
}
