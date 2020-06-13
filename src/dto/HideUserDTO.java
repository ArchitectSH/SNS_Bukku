package dto;

public class HideUserDTO {
	private int hideNo;
	private int postNo;
	private String id;
	public HideUserDTO() {
		// TODO Auto-generated constructor stub
	}
	public HideUserDTO(int hideNo, int postNo, String id) {
		super();
		this.hideNo = hideNo;
		this.postNo = postNo;
		this.id = id;
	}
	public int getHideNo() {
		return hideNo;
	}
	public void setHideNo(int hideNo) {
		this.hideNo = hideNo;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "HideUserDTO [hideNo=" + hideNo + ", postNo=" + postNo + ", id="
				+ id + "]";
	}
	
	
}
