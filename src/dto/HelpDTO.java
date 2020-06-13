package dto;

import java.io.Serializable;

public class HelpDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8502385419242833359L;
	private int helpNo;
	private String adminId;
	private String helpTitle;
	private String helpContent;
	public HelpDTO() {
		// TODO Auto-generated constructor stub
	}
	public HelpDTO(int helpNo, String adminId, String helpTitle,
			String helpContent) {
		super();
		this.helpNo = helpNo;
		this.adminId = adminId;
		this.helpTitle = helpTitle;
		this.helpContent = helpContent;
	}
	public int getHelpNo() {
		return helpNo;
	}
	public void setHelpNo(int helpNo) {
		this.helpNo = helpNo;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getHelpTitle() {
		return helpTitle;
	}
	public void setHelpTitle(String helpTitle) {
		this.helpTitle = helpTitle;
	}
	public String getHelpContent() {
		return helpContent;
	}
	public void setHelpContent(String helpContent) {
		this.helpContent = helpContent;
	}
	@Override
	public String toString() {
		return "HelpDTO [helpNo=" + helpNo + ", adminId=" + adminId
				+ ", helpTitle=" + helpTitle + ", helpContent=" + helpContent
				+ "]";
	}
	
}
