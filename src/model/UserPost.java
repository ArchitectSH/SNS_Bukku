package model;

import java.io.Serializable;

public class UserPost implements Serializable{

	private static final long serialVersionUID = -5118438068882097197L;
	private int postNo;
	private PostContent postContent;
	private UserPublicInfo writer;
	private PrivacyLevel privacyLevel;
	private String postingTime;
	public UserPost() {
		// TODO Auto-generated constructor stub
	}
	public UserPost(int postNo, PostContent postContent, UserPublicInfo writer,
			PrivacyLevel privacyLevel, String postingTime) {
		super();
		this.postNo = postNo;
		this.postContent = postContent;
		this.writer = writer;
		this.privacyLevel = privacyLevel;
		this.postingTime = postingTime;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public PostContent getPostContent() {
		return postContent;
	}
	public void setPostContent(PostContent postContent) {
		this.postContent = postContent;
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
	public String getPostingTime() {
		return postingTime;
	}
	public void setPostingTime(String postingtime) {
		this.postingTime = postingTime;
	}
	@Override
	public String toString() {
		return "UserPost [postNo=" + postNo + ", postContent=" + postContent
				+ ", writer=" + writer + ", privacyLevel=" + privacyLevel
				+ ", postingtime=" + postingTime + "]";
	}
	
}
