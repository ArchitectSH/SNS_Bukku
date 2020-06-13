package viewHelperBean;

public class NoticeBean {
	private String noticeTitle;
	private String writerId;
	private String noticeContent;
	private int postNo;
	private String noticeDate;
	public NoticeBean() {
		// TODO Auto-generated constructor stub
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public String getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}
	public String toString() {
		return "NoticeBean [noticeTitle=" + noticeTitle + ", writerId="
				+ writerId + ", noticeContent=" + noticeContent + ", postNo="
				+ postNo + ", noticeDate=" + noticeDate + "]";
	}
	
}	
