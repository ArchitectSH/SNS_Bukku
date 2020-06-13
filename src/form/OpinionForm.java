package form;

public class OpinionForm {
	private String opinionTitle;
	private String opinionContent;
	private String email;
	public OpinionForm() {
		// TODO Auto-generated constructor stub
	}
	
	public String getOpinionTitle() {
		return opinionTitle;
	}

	public void setOpinionTitle(String opinionTitle) {
		this.opinionTitle = opinionTitle;
	}

	public String getOpinionContent() {
		return opinionContent;
	}

	public void setOpinionContent(String opinionContent) {
		this.opinionContent = opinionContent;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return "OpinionForm [opinionTitle=" + opinionTitle
				+ ", opinionContent=" + opinionContent + ", email=" + email
				+ "]";
	}
	
}
