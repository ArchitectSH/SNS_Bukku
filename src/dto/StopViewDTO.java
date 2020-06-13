package dto;

public class StopViewDTO {
	private String id;
	private boolean userStop;
	private String name;
	private String profileImg;
	public StopViewDTO() {
		super();
	}
	public StopViewDTO(String id, boolean userStop, String name,
			String profileImg) {
		super();
		this.id = id;
		this.userStop = userStop;
		this.name = name;
		this.profileImg = profileImg;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isUserStop() {
		return userStop;
	}
	public void setUserStop(boolean userStop) {
		this.userStop = userStop;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public String toString() {
		return "StopViewDTO [id=" + id + ", userStop=" + userStop + ", name="
				+ name + ", profileImg=" + profileImg + "]";
	}

	
}
