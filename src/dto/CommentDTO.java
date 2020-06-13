package dto;

import java.io.Serializable;

public class CommentDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4391827089099868414L;
	private int commentNo;
	private String commentContent;
	private String commentDate;
	private int postNo;
	private String id;
	private int privacyLevel;
	public CommentDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public CommentDTO(int commentNo, String commentContent, String commentDate,
			int postNo, String id, int privacyLevel) {
		super();
		this.commentNo = commentNo;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
		this.postNo = postNo;
		this.id = id;
		this.privacyLevel = privacyLevel;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}


	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
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
	public int getPrivacyLevel() {
		return privacyLevel;
	}
	public void setPrivacyLevel(int privacyLevel) {
		this.privacyLevel = privacyLevel;
	}

	@Override
	public String toString() {
		return "CommentDTO [commentNo=" + commentNo + ", commentContent="
				+ commentContent + ", commentDate=" + commentDate + ", postNo="
				+ postNo + ", id=" + id + ", privacyLevel=" + privacyLevel
				+ "]";
	}
	
}
