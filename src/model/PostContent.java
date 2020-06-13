package model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class PostContent implements Serializable{
	private static final long serialVersionUID = 338310254503956950L;
	private Map<String, String> tagFriends;
	private List<String> img;
	private String video;
	private String content;
	public PostContent() {
		// TODO Auto-generated constructor stub
	}
	public PostContent(Map<String, String> tagFriends, List<String> img,
			String video, String content) {
		super();
		this.tagFriends = tagFriends;
		this.img = img;
		this.video = video;
		this.content = content;
	}
	public Map<String, String> getTagFriends() {
		return tagFriends;
	}
	public void setTagFriends(Map<String, String> tagFriends) {
		this.tagFriends = tagFriends;
	}
	public List<String> getImg() {
		return img;
	}
	public void setImg(List<String> img) {
		this.img = img;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "PostContent [tagFriends=" + tagFriends + ", img=" + img
				+ ", video=" + video + ", content=" + content + "]";
	}
	
}
