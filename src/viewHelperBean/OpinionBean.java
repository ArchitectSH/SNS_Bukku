package viewHelperBean;

public class OpinionBean {
	private String opinionTitle;
	private String opinionContent;
	private int postNo;
	private String writer;
	private String opinionDate;
	private String email;
	public OpinionBean() {
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
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getOpinionDate() {
		return opinionDate;
	}
	public void setOpinionDate(String opinionDate) {
		this.opinionDate = opinionDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String toString() {
		return "OpinionBean [opinionTitle=" + opinionTitle
				+ ", opinionContent=" + opinionContent + ", postNo=" + postNo
				+ ", writer=" + writer + ", opinionDate=" + opinionDate
				+ ", email=" + email + "]";
	}
	
}
