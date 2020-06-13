package form;

public class HelpForm {
	private String helpTitle;
	private String helpContent;
	public HelpForm() {
		// TODO Auto-generated constructor stub
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
	public String toString() {
		return "HelperForm [helpTitle=" + helpTitle + ", helpContent="
				+ helpContent + "]";
	}
	
}
