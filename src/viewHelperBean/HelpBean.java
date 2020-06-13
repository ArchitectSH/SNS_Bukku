package viewHelperBean;

public class HelpBean {
	private String helpTitle;
	private String writerId;
	private String helpContent;
	private int postNo;
	public HelpBean() {
		// TODO Auto-generated constructor stub
	}
	public String getHelpTitle() {
		return helpTitle;
	}
	public void setHelpTitle(String helpTitle) {
		this.helpTitle = helpTitle;
	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public String getHelpContent() {
		return helpContent;
	}
	public void setHelpContent(String helpContent) {
		this.helpContent = helpContent;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public String toString() {
		return "HelpBean [helpTitle=" + helpTitle + ", writerId=" + writerId
				+ ", helpContent=" + helpContent + ", postNo=" + postNo + "]";
	}
	
}
