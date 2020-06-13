package model;

import java.util.Map;

public class CommentContent {
	private String comment;
	private Map<String, String> tagFriends;
	public CommentContent() {
		// TODO Auto-generated constructor stub
	}
	public CommentContent(String comment, Map<String, String> tagFriends) {
		super();
		this.comment = comment;
		this.tagFriends = tagFriends;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Map<String, String> getTagFriends() {
		return tagFriends;
	}
	public void setTagFriends(Map<String, String> tagFriends) {
		this.tagFriends = tagFriends;
	}
	@Override
	public String toString() {
		return "CommentContent [comment=" + comment + ", tagFriends="
				+ tagFriends + "]";
	}
}
