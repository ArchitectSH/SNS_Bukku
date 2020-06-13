package dto;

import java.io.Serializable;

public class GuestPostDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 10277865769065443L;
	private int postNo;
	private String id;
	public GuestPostDTO() {
		// TODO Auto-generated constructor stub
	}
	public GuestPostDTO(int postNo, String id) {
		super();
		this.postNo = postNo;
		this.id = id;
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
		return "GuestPostDTO [postNo=" + postNo + ", id=" + id + "]";
	}
	
}
