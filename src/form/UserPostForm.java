package form;

import java.util.List;
import java.util.Map;

import model.PrivacyLevel;

public class UserPostForm {
	private String contents;
	private Map<String, String> tagFriends;
	private List<String> imageList;
	private String video;
	private PrivacyLevel privacyLevel;
	public UserPostForm() {
		// TODO Auto-generated constructor stub
	}
	
	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Map<String, String> getTagFriends() {
		return tagFriends;
	}

	public void setTagFriends(Map<String, String> tagFriends) {
		this.tagFriends = tagFriends;
	}

	public List<String> getimageList() {
		return imageList;
	}

	public void setImg(List<String> imageList) {
		this.imageList = imageList;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public PrivacyLevel getPrivacyLevel() {
		return privacyLevel;
	}

	public void setPrivacyLevel(PrivacyLevel privacyLevel) {
		this.privacyLevel = privacyLevel;
	}
	public String toString() {
		return "UserPostForm [contents=" + contents + ", tagFriends="
				+ tagFriends + ", img=" + imageList + ", video=" + video + "]";
	}
	
}
