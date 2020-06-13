package viewHelperBean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PostAllInfoBean {
	private PostingViewBean postingViewBean;
	private Map<String, String> postTagFriends;
	private List<String> imageList;
	private List<CommentViewBean> commentViewBeanList;
	private Map<String, String> commentTagFriends;
	private boolean block;
	private boolean hide;
	private boolean atti;
	private int recommend;
	private int activityKind; 
	public PostAllInfoBean() {
		// TODO Auto-generated constructor stub
		postingViewBean = new PostingViewBean();
	}
	public PostingViewBean getPostingViewBean() {
		return postingViewBean;
	}
	public void setPostingViewBean(PostingViewBean postingViewBean) {
		this.postingViewBean = postingViewBean;
	}
	public Map<String, String> getPostTagFriends() {
		return postTagFriends;
	}
	public void setPostTagFriends(Map<String, String> postTagFriends) {
		this.postTagFriends = postTagFriends;
	}
	public List<String> getImageList() {
		return imageList;
	}
	public void setImageList(List<String> imageList) {
		this.imageList = imageList;
	}
	public List<CommentViewBean> getCommentViewBeanList() {
		return commentViewBeanList;
	}
	public void setCommentViewBeanList(List<CommentViewBean> commentViewBeanList) {
		this.commentViewBeanList = commentViewBeanList;
	}
	public Map<String, String> getCommentTagFriends() {
		return commentTagFriends;
	}
	public void setCommentTagFriends(Map<String, String> commentTagFriends) {
		this.commentTagFriends = commentTagFriends;
	}
	public boolean isBlock() {
		return block;
	}
	public void setBlock(boolean block) {
		this.block = block;
	}
	public boolean isHide() {
		return hide;
	}
	public void setHide(boolean hide) {
		this.hide = hide;
	}
	public int getActivityKind() {
		return activityKind;
	}
	public void setActivityKind(int activityKind) {
		this.activityKind = activityKind;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	
	public boolean isAtti() {
		return atti;
	}
	public void setAtti(boolean atti) {
		this.atti = atti;
	}
	@Override
	public String toString() {
		return "PostAllInfoBean [postingViewBean=" + postingViewBean
				+ ", postTagFriends=" + postTagFriends + ", imageList="
				+ imageList + ", commentViewBeanList=" + commentViewBeanList
				+ ", commentTagFriends=" + commentTagFriends + ", block="
				+ block + ", hide=" + hide + ", atti=" + atti + ", recommend="
				+ recommend + ", activityKind=" + activityKind + "]";
	}
	
	
}
