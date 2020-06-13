package form;

public class NoticeForm {
	private String noticeTitle;
	private String noticeContent;
	public NoticeForm() {
		// TODO Auto-generated constructor stub
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public String toString() {
		return "NoticeForm [noticeTitle=" + noticeTitle + ", noticeContent="
				+ noticeContent + "]";
	}
	
}
