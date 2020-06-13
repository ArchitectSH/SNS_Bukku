package dto;

import java.io.Serializable;

public class MyPagePostDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5450017885134517405L;
	private int postNo;
	private String myPageTitle;
	public MyPagePostDTO() {
		// TODO Auto-generated constructor stub
	}
	public MyPagePostDTO(int postNo, String myPageTitle) {
		super();
		this.postNo = postNo;
		this.myPageTitle = myPageTitle;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public String getMyPageTitle() {
		return myPageTitle;
	}
	public void setMyPageTitle(String myPageTitle) {
		this.myPageTitle = myPageTitle;
	}
	@Override
	public String toString() {
		return "MyPagePostDTO [postNo=" + postNo + ", myPageTitle="
				+ myPageTitle + "]";
	}
	
}
