package dto;

import java.io.Serializable;


public class TagViewDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6882455145039257572L;
	private int commentNo;
	private String commentContent;
	private String writerId;
	private String writerProfileImg;
	private String writerName;
	private String taggedUserId;
	private String taggedUserName;
	private int postNo;
	public TagViewDTO() {
	
	}
	
	

	public TagViewDTO(int commentNo, String commentContent, String writerId,
			String writerProfileImg, String writerName, String taggedUserId,
			String taggedUserName, int postNo) {
		super();
		this.commentNo = commentNo;
		this.commentContent = commentContent;
		this.writerId = writerId;
		this.writerProfileImg = writerProfileImg;
		this.writerName = writerName;
		this.taggedUserId = taggedUserId;
		this.taggedUserName = taggedUserName;
		this.postNo = postNo;
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
	public String getTaggedUserId() {
		return taggedUserId;
	}
	public void setTaggedUserId(String taggedUserId) {
		this.taggedUserId = taggedUserId;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}



	public String getTaggedUserName() {
		return taggedUserName;
	}



	public void setTaggedUserName(String taggedUserName) {
		this.taggedUserName = taggedUserName;
	}



	@Override
	public String toString() {
		return "TagViewDTO [commentNo=" + commentNo + ", commentContent="
				+ commentContent + ", writerId=" + writerId
				+ ", writerProfileImg=" + writerProfileImg + ", writerName="
				+ writerName + ", taggedUserId=" + taggedUserId
				+ ", taggedUserName=" + taggedUserName + ", postNo=" + postNo
				+ "]";
	}

	
}
