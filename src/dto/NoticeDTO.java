package dto;

import java.io.Serializable;

public class NoticeDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3285925809324978914L;
	private int noticeNo;
	private String adminId;
	private String noticeTitle;
	private String noticeContent;
	private String noticeDate;
	public NoticeDTO() {
		// TODO Auto-generated constructor stub
	}
	public NoticeDTO(int noticeNo, String adminId, String noticeTitle,
			String noticeContent, String noticeDate) {
		super();
		this.noticeNo = noticeNo;
		this.adminId = adminId;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeDate = noticeDate;
	}
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
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
	public String getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}
	@Override
	public String toString() {
		return "NoticeDTO [noticeNo=" + noticeNo + ", adminId=" + adminId
				+ ", noticeTitle=" + noticeTitle + ", noticeContent="
				+ noticeContent + ", noticeDate=" + noticeDate + "]";
	}
	
}
