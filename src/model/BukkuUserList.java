package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BukkuUserList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<UserPublicInfo> bukkuUserInfos;
	public BukkuUserList() {
		// TODO Auto-generated constructor stub
		bukkuUserInfos = new ArrayList<UserPublicInfo>();
	}
	
	public BukkuUserList(List<UserPublicInfo> bukkuUserInfos) {
		super();
		this.bukkuUserInfos = bukkuUserInfos;
	}

	public List<UserPublicInfo> getBukkuUserInfos() {
		return bukkuUserInfos;
	}
	public void setBukkuUserInfos(List<UserPublicInfo> bukkuUserInfos) {
		this.bukkuUserInfos = bukkuUserInfos;
	}
	@Override
	public String toString() {
		return "BukkuUserList [bukkuUserInfos=" + bukkuUserInfos + "]";
	}
	public int addBukkuUser(UserPublicInfo bukkuUserInfo){
		bukkuUserInfos.add(bukkuUserInfo);
		return bukkuUserInfos.size();
	}

}
