package dto;

public class AdminDTO {
	private String adminId;
	private String adminPass;
	public AdminDTO() {
		// TODO Auto-generated constructor stub
	}
	public AdminDTO(String adminId, String adminPass) {
		super();
		this.adminId = adminId;
		this.adminPass = adminPass;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPass() {
		return adminPass;
	}
	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}
	@Override
	public String toString() {
		return "AdminDTO [adminId=" + adminId + ", adminPass=" + adminPass
				+ "]";
	}
	
}
