package model;

public class OriginPost {
	private int originPostNo;
	private PostContent originContent;
	private String originWriterId;
	public OriginPost() {
		// TODO Auto-generated constructor stub
	}
	
	public OriginPost(int originPostNo, PostContent originContent,
			String originWriterId) {
		super();
		this.originPostNo = originPostNo;
		this.originContent = originContent;
		this.originWriterId = originWriterId;
	}

	public int getOriginPostNo() {
		return originPostNo;
	}
	public void setOriginPostNo(int originPostNo) {
		this.originPostNo = originPostNo;
	}
	public PostContent getOriginContent() {
		return originContent;
	}
	public void setOriginContent(PostContent originContent) {
		this.originContent = originContent;
	}
	public String getOriginWriterId() {
		return originWriterId;
	}
	public void setOriginWriterId(String originWriterId) {
		this.originWriterId = originWriterId;
	}
	@Override
	public String toString() {
		return "OriginPost [originPostNo=" + originPostNo + ", originContent="
				+ originContent + ", originWriterId=" + originWriterId + "]";
	}
	
}
