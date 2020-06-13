package viewHelperBean;

public class UserPublicBean {
	private String id;
	private String name;
	private String profileImg;
	public UserPublicBean() {
		// TODO Auto-generated constructor stub
	}
	
	public UserPublicBean(String id, String name, String profileImg) {
		super();
		this.id = id;
		this.name = name;
		this.profileImg = profileImg;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
		return "UserPublicBean [id=" + id + ", name=" + name + ", profileImg="
				+ profileImg + "]";
	}
	
}
