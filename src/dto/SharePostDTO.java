package dto;

import java.io.Serializable;

public class SharePostDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6961819526473244706L;
	private int postNo;
	private String originPostNo;
	public SharePostDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public SharePostDTO(int postNo, String originPostNo) {
		super();
		this.postNo = postNo;
		this.originPostNo = originPostNo;
	}

	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public String getOriginPostNo() {
		return originPostNo;
	}
	public void setOriginPostNo(String originPostNo) {
		this.originPostNo = originPostNo;
	}

	@Override
	public String toString() {
		return "SharePostDTO [postNo=" + postNo + ", originPostNo="
				+ originPostNo + "]";
	}
	
}
