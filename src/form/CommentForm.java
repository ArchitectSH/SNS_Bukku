package form;

import java.util.Map;

import model.PrivacyLevel;

public class CommentForm {
	private String comment;
	private Map<String,String> tagFriends;
	private PrivacyLevel privacyLevel;
	public CommentForm() {
		// TODO Auto-generated constructor stub
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
	public PrivacyLevel getPrivacyLevel() {
		return privacyLevel;
	}
	public void setPrivacyLevel(PrivacyLevel privacyLevel) {
		this.privacyLevel = privacyLevel;
	}
	public String toString() {
		return "CommentForm [comment=" + comment + ", tagFriends=" + tagFriends
				+ ", writerId=" +  ", privacyLevel=" + privacyLevel
				+ "]";
	}
	
}
