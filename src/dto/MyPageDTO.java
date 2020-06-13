package dto;

import java.io.Serializable;


public class MyPageDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4292263492306482798L;
	private String myPageTitle;
	private String img;
	private String myPageIntroduction;
	private String id;
	
	public MyPageDTO() {
		// TODO Auto-generated constructor stub
	}

	public MyPageDTO(String myPageTitle, String img, String myPageIntroduction,
			String id) {
		super();
		this.myPageTitle = myPageTitle;
		this.img = img;
		this.myPageIntroduction = myPageIntroduction;
		this.id = id;
	}

	public String getMyPageTitle() {
		return myPageTitle;
	}

	public void setMyPageTitle(String myPageTitle) {
		this.myPageTitle = myPageTitle;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getMyPageIntroduction() {
		return myPageIntroduction;
	}

	public void setMyPageIntroduction(String myPageIntroduction) {
		this.myPageIntroduction = myPageIntroduction;
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
		return "MyPageDTO [myPageTitle=" + myPageTitle + ", img=" + img
				+ ", myPageIntroduction=" + myPageIntroduction + ", id=" + id
				+ "]";
	}
	
}