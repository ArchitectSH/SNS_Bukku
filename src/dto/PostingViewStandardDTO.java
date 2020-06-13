package dto;

import java.io.Serializable;

public class PostingViewStandardDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 487540228262418678L;
	private int postNo;
	private String id;
	private String profileImg;
	private String name;
	private String postDate;
	private String postContent;
	private String video;
	private int commentNum;
	private int shareNum;
	private int reportNum;
	private int likeNBukkuNum;
	private int HateNum;
	private String mypageTitle;
	private int groupNo;
	private String guestId;
	private int originPostNo;
	private int postContentNo;
	private int privacyLevel;
	private String friendName;
	private String standardTime;
	public PostingViewStandardDTO() {
		// TODO Auto-generated constructor stub
	}
	public PostingViewStandardDTO(int postNo, String id, String profileImg,
			String name, String postDate, String postContent, String video,
			int commentNum, int shareNum, int reportNum, int likeNBukkuNum,
			int hateNum, String mypageTitle, int groupNo, String guestId,
			int originPostNo, int postContentNo, int privacyLevel,
			String friendName, String standardTime) {
		super();
		this.postNo = postNo;
		this.id = id;
		this.profileImg = profileImg;
		this.name = name;
		this.postDate = postDate;
		this.postContent = postContent;
		this.video = video;
		this.commentNum = commentNum;
		this.shareNum = shareNum;
		this.reportNum = reportNum;
		this.likeNBukkuNum = likeNBukkuNum;
		HateNum = hateNum;
		this.mypageTitle = mypageTitle;
		this.groupNo = groupNo;
		this.guestId = guestId;
		this.originPostNo = originPostNo;
		this.postContentNo = postContentNo;
		this.privacyLevel = privacyLevel;
		this.friendName = friendName;
		this.standardTime = standardTime;
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
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public int getShareNum() {
		return shareNum;
	}
	public void setShareNum(int shareNum) {
		this.shareNum = shareNum;
	}
	public int getReportNum() {
		return reportNum;
	}
	public void setReportNum(int reportNum) {
		this.reportNum = reportNum;
	}
	public int getLikeNBukkuNum() {
		return likeNBukkuNum;
	}
	public void setLikeNBukkuNum(int likeNBukkuNum) {
		this.likeNBukkuNum = likeNBukkuNum;
	}
	public int getHateNum() {
		return HateNum;
	}
	public void setHateNum(int hateNum) {
		HateNum = hateNum;
	}
	public String getMypageTitle() {
		return mypageTitle;
	}
	public void setMypageTitle(String mypageTitle) {
		this.mypageTitle = mypageTitle;
	}
	public int getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
	public String getGuestId() {
		return guestId;
	}
	public void setGuestId(String guestId) {
		this.guestId = guestId;
	}
	public int getOriginPostNo() {
		return originPostNo;
	}
	public void setOriginPostNo(int originPostNo) {
		this.originPostNo = originPostNo;
	}
	public int getPostContentNo() {
		return postContentNo;
	}
	public void setPostContentNo(int postContentNo) {
		this.postContentNo = postContentNo;
	}
	public int getPrivacyLevel() {
		return privacyLevel;
	}
	public void setPrivacyLevel(int privacyLevel) {
		this.privacyLevel = privacyLevel;
	}
	public String getFriendName() {
		return friendName;
	}
	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}
	public String getStandardTime() {
		return standardTime;
	}
	public void setStandardTime(String standardTime) {
		this.standardTime = standardTime;
	}
	public String toString() {
		return "PostingViewStandardDTO [postNo=" + postNo + ", id=" + id
				+ ", profileImg=" + profileImg + ", name=" + name
				+ ", postDate=" + postDate + ", postContent=" + postContent
				+ ", video=" + video + ", commentNum=" + commentNum
				+ ", shareNum=" + shareNum + ", reportNum=" + reportNum
				+ ", likeNBukkuNum=" + likeNBukkuNum + ", HateNum=" + HateNum
				+ ", mypageTitle=" + mypageTitle + ", groupNo=" + groupNo
				+ ", guestId=" + guestId + ", originPostNo=" + originPostNo
				+ ", postContentNo=" + postContentNo + ", privacyLevel="
				+ privacyLevel + ", friendName=" + friendName
				+ ", standardTime=" + standardTime + "]";
	}
	
}
