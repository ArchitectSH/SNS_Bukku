package model;

public class GroupPost extends UserPost{
	private int groupNo;
	public GroupPost() {
		// TODO Auto-generated constructor stub
	}
	public GroupPost(int postNo, PostContent postContent, UserPublicInfo writer,
			PrivacyLevel privacyLevel, String postingTime, int groupNo) {
		super(postNo, postContent, writer, privacyLevel, postingTime);
		this.groupNo = groupNo;
	}
	public int getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
	@Override
	public String toString() {
		return "GroupPost [groupNo=" + groupNo + "]";
	}
	
}
