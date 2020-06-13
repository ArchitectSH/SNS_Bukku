package dto;

import java.io.Serializable;

public class PostContentDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1497175501866181900L;
	private int postContentNo;
	private String postContent;
	private String video;
	public PostContentDTO() {
		// TODO Auto-generated constructor stub
	}
	public PostContentDTO(int postContentNo, String postContent, String video) {
		super();
		this.postContentNo = postContentNo;
		this.postContent = postContent;
		this.video = video;
	}
	public int getPostContentNo() {
		return postContentNo;
	}
	public void setPostContentNo(int postContentNo) {
		this.postContentNo = postContentNo;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	@Override
	public String toString() {
		return "PostContentDTO [postContentNo=" + postContentNo
				+ ", postContent=" + postContent + ", video=" + video + "]";
	}
	
}
