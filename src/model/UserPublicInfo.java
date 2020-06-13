package model;



public class UserPublicInfo {
	private String name;
	private String id;
	private String picture;
	public UserPublicInfo() {
		this.name = "이름없음";
		this.id = "아이디없음";
		this.picture= "image/profileDefault.jsp";
	
	}
	
	public UserPublicInfo(String name, String id) {
		this.name = name;
		this.id = id;
		this.picture= "image/profileDefault.jsp";
	}
	
	public UserPublicInfo(String name, String id, String picture) {
		this.name = name;
		this.id = id;
		this.picture= picture;
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "UserPublicInfo [name=" + name + ", id=" + id + ", picture="
				+ picture + "]";
	}
	
}
