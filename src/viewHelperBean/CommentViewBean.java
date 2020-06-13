package viewHelperBean;

public class CommentViewBean {
	private int postNo;
	private String writerId;
	private String writerPorifleImg;
	private String writerName;
	private String commentDate;
	private String commentContent;
	private int commentNo;
	private int privacyLevel;
	public CommentViewBean() {
		// TODO Auto-generated constructor stub
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
	public String getWriterPorifleImg() {
		return writerPorifleImg;
	}
	public void setWriterPorifleImg(String writerPorifleImg) {
		this.writerPorifleImg = writerPorifleImg;
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
	public String toString() {
		return "CommentViewBean [postNo=" + postNo + ", writerId=" + writerId
				+ ", writerPorifleImg=" + writerPorifleImg + ", writerName="
				+ writerName + ", commentDate=" + commentDate
				+ ", commentContent=" + commentContent + ", commentNo="
				+ commentNo + ", privacyLevel=" + privacyLevel + "]";
	}
	
}
