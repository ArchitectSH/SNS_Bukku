package dto;

import java.io.Serializable;

public class PostDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1759346757477220207L;
	private int postNo;
	private int privacyLevel;
	private String postDate;
	private String id;
	private int postContentNo;
	public PostDTO() {
		// TODO Auto-generated constructor stub
	}
	public PostDTO(int postNo, int privacyLevel, String postDate, String id,
			int postContentNo) {
		super();
		this.postNo = postNo;
		this.privacyLevel = privacyLevel;
		this.postDate = postDate;
		this.id = id;
		this.postContentNo = postContentNo;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public int getPrivacyLevel() {
		return privacyLevel;
	}
	public void setPrivacyLevel(int privacyLevel) {
		this.privacyLevel = privacyLevel;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPostContentNo() {
		return postContentNo;
	}
	public void setPostContentNo(int postContentNo) {
		this.postContentNo = postContentNo;
	}
	@Override
	public String toString() {
		return "PostDTO [postNo=" + postNo + ", privacyLevel=" + privacyLevel
				+ ", postDate=" + postDate + ", id=" + id + ", postContentNo="
				+ postContentNo + "]";
	}
}
