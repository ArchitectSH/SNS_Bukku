package viewHelperBean;

public class MyPagePublicBean {
	private String title;
	private String img;
	public MyPagePublicBean() {
		// TODO Auto-generated constructor stub
	}
	public MyPagePublicBean(String title, String img) {
		super();
		this.title = title;
		this.img = img;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "MyPagePublicBean [title=" + title + ", img=" + img + "]";
	}
}
