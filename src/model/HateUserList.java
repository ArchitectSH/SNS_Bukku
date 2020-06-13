package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HateUserList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<UserPublicInfo> hateUserInfos;
	public HateUserList() {
		// TODO Auto-generated constructor stub
		hateUserInfos = new ArrayList<UserPublicInfo>();
	}
	public HateUserList(List<UserPublicInfo> hateUserInfos) {
		super();
		this.hateUserInfos = hateUserInfos;
	}
	public List<UserPublicInfo> getHateUserInfos() {
		return hateUserInfos;
	}
	public void setHateUserInfos(List<UserPublicInfo> hateUserInfos) {
		this.hateUserInfos = hateUserInfos;
	}
	@Override
	public String toString() {
		return "HateUserList [hateUserInfos=" + hateUserInfos + "]";
	}
	public int addHateUser(UserPublicInfo hateUserInfo){
		hateUserInfos.add(hateUserInfo);
		return hateUserInfos.size();
	}
}
