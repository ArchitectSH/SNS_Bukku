package dto;

import java.io.Serializable;


public class CommentViewDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7696807775810391356L;
	private int postNo;
	private String writerId;
	private String writerProfileImg;
	private String writerName;
	private String commentDate;
	private String commentContent;
	private int commentNo;
	private int privacyLevel;
	public CommentViewDTO() {
	
	}
	
	public CommentViewDTO(int postNo, String writerId, String writerProfileImg,
			String writerName, String commentDate, String commentContent,
			int commentNo, int privacyLevel) {
		super();
		this.postNo = postNo;
		this.writerId = writerId;
		this.writerProfileImg = writerProfileImg;
		this.writerName = writerName;
		this.commentDate = commentDate;
		this.commentContent = commentContent;
		this.commentNo = commentNo;
		this.privacyLevel = privacyLevel;
	}

	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public String getWriterProfileImg() {
		return writerProfileImg;
	}
	public void setWriterProfileImg(String writerProfileImg) {
		this.writerProfileImg = writerProfileImg;
	}
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public int getPrivacyLevel() {
		return privacyLevel;
	}
	public void setPrivacyLevel(int privacyLevel) {
		this.privacyLevel = privacyLevel;
	}

	@Override
	public String toString() {
		return "CommentViewDTO [postNo=" + postNo + ", writerId=" + writerId
				+ ", writerProfileImg=" + writerProfileImg + ", writerName="
				+ writerName + ", commentDate=" + commentDate
				+ ", commentContent=" + commentContent + ", commentNo="
				+ commentNo + ", privacyLevel=" + privacyLevel + "]";
	}
	
}
