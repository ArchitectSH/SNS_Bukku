package model;

public class Comment {
	private CommentContent commentContent;
	private String commentDate;
	private int commentNo;
	private UserPublicInfo writer;
	private PrivacyLevel privacyLevel;
	public Comment() {
		// TODO Auto-generated constructor stub
	}
	public Comment(CommentContent commentContent, String commentDate,
			int commentNo, UserPublicInfo writer, PrivacyLevel privacyLevel) {
		super();
		this.commentContent = commentContent;
		this.commentDate = commentDate;
		this.commentNo = commentNo;
		this.writer = writer;
		this.privacyLevel = privacyLevel;
	}
	public CommentContent getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(CommentContent commentContent) {
		this.commentContent = commentContent;
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
	public UserPublicInfo getWriter() {
		return writer;
	}
	public void setWriter(UserPublicInfo writer) {
		this.writer = writer;
	}
	public PrivacyLevel getPrivacyLevel() {
		return privacyLevel;
	}
	public void setPrivacyLevel(PrivacyLevel privacyLevel) {
		this.privacyLevel = privacyLevel;
	}
	@Override
	public String toString() {
		return "Comment [commentContent=" + commentContent + ", commentDate="
				+ commentDate + ", commentNo=" + commentNo + ", writer="
				+ writer + ", privacyLevel=" + privacyLevel + "]";
	}
	

}
