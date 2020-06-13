package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ShareUserInfoList {
	private Map<Integer, List<UserPublicInfo>> shareUserInfos;
	public ShareUserInfoList() {
		// TODO Auto-generated constructor stub
		shareUserInfos = new HashMap<Integer, List<UserPublicInfo>>();
	}
	public ShareUserInfoList(Map<Integer, List<UserPublicInfo>> shareUserInfos) {
		super();
		this.shareUserInfos = shareUserInfos;
	}
	public Map<Integer, List<UserPublicInfo>> getShareUserInfos() {
		return shareUserInfos;
	}
	public int addReportingUser(int postNo, UserPublicInfo userPublicInfo){
		if(shareUserInfos.get(postNo)==null){
			ArrayList<UserPublicInfo> list = new ArrayList<UserPublicInfo>();
			list.add(userPublicInfo);
			shareUserInfos.put(postNo, list);
		}else{
			List<UserPublicInfo> list = shareUserInfos.get(postNo);
			list.add(userPublicInfo);
		}
		return shareUserInfos.size();
	}
	public List<UserPublicInfo> searchReportUsers(int postNo){
		return shareUserInfos.get(postNo);
	}
	public int deleteReportUser(int postNo, String userId){
		List<UserPublicInfo> list = shareUserInfos.get(postNo);
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
	public void setShareUserInfos(Map<Integer, List<UserPublicInfo>> shareUserInfos) {
		this.shareUserInfos = shareUserInfos;
	}

}
