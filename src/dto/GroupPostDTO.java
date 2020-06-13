package dto;

import java.io.Serializable;

public class GroupPostDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1516482847186008969L;
	private int PostNo;
	private int groupNo;
	public GroupPostDTO() {
		// TODO Auto-generated constructor stub
	}
	public GroupPostDTO(int postNo, int groupNo) {
		super();
		PostNo = postNo;
		this.groupNo = groupNo;
	}
	public int getPostNo() {
		return PostNo;
	}
	public void setPostNo(int postNo) {
		PostNo = postNo;
	}
	public int getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
	@Override
	public String toString() {
		return "GroupPostDTO [PostNo=" + PostNo + ", groupNo=" + groupNo + "]";
	}
	
}
