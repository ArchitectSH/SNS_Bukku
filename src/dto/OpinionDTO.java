package dto;

import java.io.Serializable;

public class OpinionDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3743941648277091966L;
	private int opinionNo;
	private String opinionTitle;
	private String opinionContent;
	private String opinionDate;
	private String id;
	public OpinionDTO() {
		// TODO Auto-generated constructor stub
	}
	public OpinionDTO(int opinionNo, String opinionTitle,
			String opinionContent, String opinionDate, String id) {
		super();
		this.opinionNo = opinionNo;
		this.opinionTitle = opinionTitle;
		this.opinionContent = opinionContent;
		this.opinionDate = opinionDate;
		this.id = id;
	}
	public int getOpinionNo() {
		return opinionNo;
	}
	public void setOpinionNo(int opinionNo) {
		this.opinionNo = opinionNo;
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
	public String getOpinionDate() {
		return opinionDate;
	}
	public void setOpinionDate(String opinionDate) {
		this.opinionDate = opinionDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "OpinionDTO [opinionNo=" + opinionNo + ", opinionTitle="
				+ opinionTitle + ", opinionContent=" + opinionContent
				+ ", opinionDate=" + opinionDate + ", id=" + id + "]";
	}
	
	
}
