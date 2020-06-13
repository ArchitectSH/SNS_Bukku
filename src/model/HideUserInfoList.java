package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HideUserInfoList {
	private Map<Integer,List<UserPublicInfo>> hideUserInfos;
	public HideUserInfoList() {
		// TODO Auto-generated constructor stub
		hideUserInfos = new HashMap<Integer,List<UserPublicInfo>>();
	}
	public HideUserInfoList(Map<Integer, List<UserPublicInfo>> hideUserInfos) {
		super();
		this.hideUserInfos = hideUserInfos;
	}
	
	public Map<Integer, List<UserPublicInfo>> getHideUserInfos() {
		return hideUserInfos;
	}
	public void setHideUserInfos(Map<Integer, List<UserPublicInfo>> hideUserInfos) {
		this.hideUserInfos = hideUserInfos;
	}
	public Map<Integer, List<UserPublicInfo>> gethideUserInfos() {
		return hideUserInfos;
	}
	public void sethideUserInfos(
			Map<Integer, List<UserPublicInfo>> hideUserInfos) {
		this.hideUserInfos = hideUserInfos;
	}
	public int addHidingUser(int postNo, UserPublicInfo userPublicInfo){
		if(hideUserInfos.get(postNo)==null){
			ArrayList<UserPublicInfo> list = new ArrayList<UserPublicInfo>();
			list.add(userPublicInfo);
			hideUserInfos.put(postNo, list);
		}else{
			List<UserPublicInfo> list = hideUserInfos.get(postNo);
			list.add(userPublicInfo);
		}
		return hideUserInfos.size();
	}
	public List<UserPublicInfo> searchHidingUsers(int postNo){
		return hideUserInfos.get(postNo);
	}
	public int deleteHidingUser(int postNo, String userId){
		List<UserPublicInfo> list = hideUserInfos.get(postNo);
		if(list!=null){
			Iterator<UserPublicInfo> it = list.iterator();
			int index = 0;
			while(it.hasNext()){
				UserPublicInfo upi = it.next();
				if(upi.getId().equals(userId)){
					list.remove(index);
				}
				index++;
			}
		}
		return list.size();
	}
	@Override
	public String toString() {
		return "HideUserInfoList [hideUserInfos=" + hideUserInfos + "]";
	}
	
}
