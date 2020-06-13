package dto;

import java.io.Serializable;


public class MyPageUserKindDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6227585665446330026L;
	private int myPageKindNo;
	private String myPageUserKind;
	
	public MyPageUserKindDTO() {
		// TODO Auto-generated constructor stub
	}

	public MyPageUserKindDTO(int myPageKindNo, String myPageUserKind) {
		super();
		this.myPageKindNo = myPageKindNo;
		this.myPageUserKind = myPageUserKind;
	}

	public int getMyPageKindNo() {
		return myPageKindNo;
	}

	public void setMyPageKindNo(int myPageKindNo) {
		this.myPageKindNo = myPageKindNo;
	}

	public String getMyPageUserKind() {
		return myPageUserKind;
	}

	public void setMyPageUserKind(String myPageUserKind) {
		this.myPageUserKind = myPageUserKind;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MyPageUserKindDTO [myPageKindNo=" + myPageKindNo
				+ ", myPageUserKind=" + myPageUserKind + "]";
	}
	
}
