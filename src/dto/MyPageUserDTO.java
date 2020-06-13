package dto;

import java.io.Serializable;


public class MyPageUserDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5310456413661176993L;
	private int myPageUserNo;
	private String myPageTitle;
	private int myPageKindNo;
	private String id;
	
	public MyPageUserDTO() {
		// TODO Auto-generated constructor stub
	}

	public MyPageUserDTO(int myPageUserNo, String myPageTitle,
			int myPageKindNo, String id) {
		super();
		this.myPageUserNo = myPageUserNo;
		this.myPageTitle = myPageTitle;
		this.myPageKindNo = myPageKindNo;
		this.id = id;
	}

	public int getMyPageUserNo() {
		return myPageUserNo;
	}

	public void setMyPageUserNo(int myPageUserNo) {
		this.myPageUserNo = myPageUserNo;
	}

	public String getMyPageTitle() {
		return myPageTitle;
	}

	public void setMyPageTitle(String myPageTitle) {
		this.myPageTitle = myPageTitle;
	}

	public int getMyPageKindNo() {
		return myPageKindNo;
	}

	public void setMyPageKindNo(int myPageKindNo) {
		this.myPageKindNo = myPageKindNo;
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
		return "MyPageUserDTO [myPageUserNo=" + myPageUserNo + ", myPageTitle="
				+ myPageTitle + ", myPageKindNo=" + myPageKindNo + ", id=" + id
				+ "]";
	}
	
}
