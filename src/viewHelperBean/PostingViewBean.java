package viewHelperBean;

import java.util.List;
import java.util.Map;

public class PostingViewBean {
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
	private int hateNum;
	private String mypageTitle;
	private String mypageImg;
	private int groupNo;
	private String groupName;
	private String guestId;
	private String guestName;
	private int originPostNo;
	private String originPostContent;
	private Map<String, String> originTagUsers;
	private List<String> originPostImg;
	private String originVideo;
	private int postContentNo;
	private int privacyLevel;
	private String friendId;
	private String friendName;
	private String standardTime;
	public PostingViewBean() {
		// TODO Auto-generated constructor stub
	}
	
	

	public PostingViewBean(int postNo, String id, String profileImg,
			String name, String postDate, String postContent, String video,
			int commentNum, int shareNum, int reportNum, int likeNBukkuNum,
			int hateNum, String mypageTitle, String mypageImg, int groupNo,
			String groupName, String guestId, String guestName,
			int originPostNo, String originPostContent,
			Map<String, String> originTagUsers, List<String> originPostImg,
			String originVideo, int postContentNo, int privacyLevel,
			String friendId, String friendName, String standardTime) {
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
		this.hateNum = hateNum;
		this.mypageTitle = mypageTitle;
		this.mypageImg = mypageImg;
		this.groupNo = groupNo;
		this.groupName = groupName;
		this.guestId = guestId;
		this.guestName = guestName;
		this.originPostNo = originPostNo;
		this.originPostContent = originPostContent;
		this.originTagUsers = originTagUsers;
		this.originPostImg = originPostImg;
		this.originVideo = originVideo;
		this.postContentNo = postContentNo;
		this.privacyLevel = privacyLevel;
		this.friendId = friendId;
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
		return hateNum;
	}
	public void setHateNum(int hateNum) {
		this.hateNum = hateNum;
	}
	public String getMypageTitle() {
		return mypageTitle;
	}
	public void setMypageTitle(String mypageTitle) {
		this.mypageTitle = mypageTitle;
	}
	public String getMypageImg() {
		return mypageImg;
	}
	public void setMypageImg(String mypageImg) {
		this.mypageImg = mypageImg;
	}
	public int getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGuestId() {
		return guestId;
	}
	public void setGuestId(String guestId) {
		this.guestId = guestId;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public int getOriginPostNo() {
		return originPostNo;
	}
	public void setOriginPostNo(int originPostNo) {
		this.originPostNo = originPostNo;
	}
	public String getOriginPostContent() {
		return originPostContent;
	}
	public void setOriginPostContent(String originPostContent) {
		this.originPostContent = originPostContent;
	}
	public List<String> getOriginPostImg() {
		return originPostImg;
	}
	public void setOriginPostImg(List<String> originPostImg) {
		this.originPostImg = originPostImg;
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
	public String getFriendId() {
		return friendId;
	}
	public void setFriendId(String friendId) {
		this.friendId = friendId;
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

	public String getOriginVideo() {
		return originVideo;
	}

	public void setOriginVideo(String originVideo) {
		this.originVideo = originVideo;
	}

	public Map<String, String> getOriginTagUsers() {
		return originTagUsers;
	}



	public void setOriginTagUsers(Map<String, String> originTagUsers) {
		this.originTagUsers = originTagUsers;
	}



	@Override
	public String toString() {
		return "PostingViewBean [postNo=" + postNo + ", id=" + id
				+ ", profileImg=" + profileImg + ", name=" + name
				+ ", postDate=" + postDate + ", postContent=" + postContent
				+ ", video=" + video + ", commentNum=" + commentNum
				+ ", shareNum=" + shareNum + ", reportNum=" + reportNum
				+ ", likeNBukkuNum=" + likeNBukkuNum + ", hateNum=" + hateNum
				+ ", mypageTitle=" + mypageTitle + ", mypageImg=" + mypageImg
				+ ", groupNo=" + groupNo + ", groupName=" + groupName
				+ ", guestId=" + guestId + ", guestName=" + guestName
				+ ", originPostNo=" + originPostNo + ", originPostContent="
				+ originPostContent + ", originPostImg=" + originPostImg
				+ ", originVideo=" + originVideo + ", postContentNo="
				+ postContentNo + ", privacyLevel=" + privacyLevel
				+ ", friendId=" + friendId + ", friendName=" + friendName
				+ ", standardTime=" + standardTime + "]";
	}



	
	
	
	
	
}
