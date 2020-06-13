package dto;

import java.io.Serializable;

public class PostTagUserDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1569746190867535941L;
	private int postTagNo;
	private int postNo;
	private String id;
	public PostTagUserDTO() {
		// TODO Auto-generated constructor stub
	}
	public PostTagUserDTO(int postTagNo, int postNo, String id) {
		super();
		this.postTagNo = postTagNo;
		this.postNo = postNo;
		this.id = id;
	}
	public int getPostTagNo() {
		return postTagNo;
	}
	public void setPostTagNo(int postTagNo) {
		this.postTagNo = postTagNo;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "PostTagUserDTO [postTagNo=" + postTagNo + ", postNo=" + postNo
				+ ", id=" + id + "]";
	}
	
}
