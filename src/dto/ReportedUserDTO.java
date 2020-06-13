package dto;
public class ReportedUserDTO {
	private int reportNo;
	private int postNo;
	private String id;
	public ReportedUserDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public ReportedUserDTO(int reportNo, int postNo, String id) {
		super();
		this.reportNo = reportNo;
		this.postNo = postNo;
		this.id = id;
	}

	public int getReportNo() {
		return reportNo;
	}
	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
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
		return "ReportedUserDTO [reportNo=" + reportNo + ", postNo=" + postNo
				+ ", id=" + id + "]";
	}
	
	
}
