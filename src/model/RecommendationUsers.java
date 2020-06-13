package model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class RecommendationUsers implements Serializable{
	private static final long serialVersionUID = -9114838608967808541L;
	private LikeUserList likeUserList;
	private BukkuUserList bukkuUserList;
	private HateUserList hateUserList;
	public RecommendationUsers() {
		// TODO Auto-generated constructor stub
		likeUserList = new LikeUserList();
		bukkuUserList = new BukkuUserList();
		hateUserList = new HateUserList();
	}
	public RecommendationUsers(LikeUserList likeUserList,
			BukkuUserList bukkuUserList, HateUserList hateUserList) {
		super();
		this.likeUserList = likeUserList;
		this.bukkuUserList = bukkuUserList;
		this.hateUserList = hateUserList;
	}
	public LikeUserList getLikeUserList() {
		return likeUserList;
	}
	public void setLikeUserList(LikeUserList likeUserList) {
		this.likeUserList = likeUserList;
	}
	public BukkuUserList getBukkuUserList() {
		return bukkuUserList;
	}
	public void setBukkuUserList(BukkuUserList bukkuUserList) {
		this.bukkuUserList = bukkuUserList;
	}
	public HateUserList getHateUserList() {
		return hateUserList;
	}
	public void setHateUserList(HateUserList hateUserList) {
		this.hateUserList = hateUserList;
	}
	public int addLike(UserPublicInfo likeUserInfo){
		this.likeUserList.addLikeUser(likeUserInfo);
		return 1;
	}
	public int addBukku(UserPublicInfo bukkuUserInfo){
		this.bukkuUserList.addBukkuUser(bukkuUserInfo);
		return 1;
	}
	public int addHate(UserPublicInfo hateUserInfo){
		this.hateUserList.addHateUser(hateUserInfo);
		return 1;
	}
	public int cancelLike(UserPublicInfo likeUserInfo){
		List<UserPublicInfo> list = this.likeUserList.getLikeUserInfos();
		Iterator<UserPublicInfo> it = list.iterator();
		int index=0;
		while(it.hasNext()){
			if(it.next().getId().equals(likeUserInfo.getId())){
				list.remove(index);
			}
		}
		return 1;
	}
	public int cancelBukku(UserPublicInfo likeUserInfo){
		List<UserPublicInfo> list = this.bukkuUserList.getBukkuUserInfos();
		Iterator<UserPublicInfo> it = list.iterator();
		int index=0;
		while(it.hasNext()){
			if(it.next().getId().equals(likeUserInfo.getId())){
				list.remove(index);
			}
		}
		return 1;
	}
	public int cancelHate(UserPublicInfo likeUserInfo){
		List<UserPublicInfo> list = this.hateUserList.getHateUserInfos();
		Iterator<UserPublicInfo> it = list.iterator();
		int index=0;
		while(it.hasNext()){
			if(it.next().getId().equals(likeUserInfo.getId())){
				list.remove(index);
			}
		}
		return 1;
	}
	@Override
	public String toString() {
		return "RecommendationUsers [likeUserList=" + likeUserList
				+ ", bukkuUserList=" + bukkuUserList + ", hateUserList="
				+ hateUserList + "]";
	}
	

}
