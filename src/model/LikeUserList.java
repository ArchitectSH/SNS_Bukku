package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LikeUserList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<UserPublicInfo> likeUserInfos;
	public LikeUserList() {
		// TODO Auto-generated constructor stub
		likeUserInfos = new ArrayList<UserPublicInfo>();
	}
	public LikeUserList(List<UserPublicInfo> likeUserInfos) {
		super();
		this.likeUserInfos = likeUserInfos;
	}
	public List<UserPublicInfo> getLikeUserInfos() {
		return likeUserInfos;
	}
	public void setLikeUserInfos(List<UserPublicInfo> likeUserInfos) {
		this.likeUserInfos = likeUserInfos;
	}
	@Override
	public String toString() {
		return "LikeUserList [likeUserInfos=" + likeUserInfos + "]";
	}
	public int addLikeUser(UserPublicInfo likeUserInfo){
		likeUserInfos.add(likeUserInfo);
		return likeUserInfos.size();
	}
}
