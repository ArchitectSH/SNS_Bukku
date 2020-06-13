package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlockedMyPageList {
	private Map<String,List<MyPagePublicInfo>> blockingList;
	private Map<String,List<UserPublicInfo>> blockedList;
	
	
	public BlockedMyPageList() {
		super();
		this.blockingList = new HashMap<String,List<MyPagePublicInfo>>();
		this.blockedList = new HashMap<String,List<UserPublicInfo>>();
	}


	public BlockedMyPageList(Map<String, List<MyPagePublicInfo>> blockingList,
			Map<String, List<UserPublicInfo>> blockedList) {
		super();
		this.blockingList = blockingList;
		this.blockedList = blockedList;
	}


	public Map<String, List<MyPagePublicInfo>> getBlockingList() {
		return blockingList;
	}


	public void setBlockingList(Map<String, List<MyPagePublicInfo>> blockingList) {
		this.blockingList = blockingList;
	}


	public Map<String, List<UserPublicInfo>> getBlockedList() {
		return blockedList;
	}


	public void setBlockedList(Map<String, List<UserPublicInfo>> blockedList) {
		this.blockedList = blockedList;
	}


	@Override
	public String toString() {
		return "BlockedMyPageList [blockingList=" + blockingList
				+ ", blockedList=" + blockedList + "]";
	}


	public int addBlockingMyPage(String id, MyPagePublicInfo myPagePublicInfo) {
		if(blockingList.containsKey(id)==false){
			blockingList.put(id, new ArrayList<MyPagePublicInfo>());
		}
		blockingList.get(id).add(myPagePublicInfo);
		 return 1;
	}
	
	public int addBlockedMyPage(String myPageTitle, UserPublicInfo userPublicInfo) {
		if(blockedList.containsKey(myPageTitle)==false){
			blockedList.put(myPageTitle, new ArrayList<UserPublicInfo>());
		}
		blockedList.get(myPageTitle).add(userPublicInfo);
		 return 1;
	}
	
	public int removeBlockingMyPage(String id, MyPagePublicInfo myPagePublicInfo) {
	 return 0;
	}
	
	public int removeBlockedMyPage(String myPageTitle, UserPublicInfo userPublicInfo) {
		 return 0;
	}
	
	public int checkBlockingMyPage(String id, String mypageTitle) {
		 return 0;
	}
	
	public List<MyPagePublicInfo> searchBlockingMyPage(String id) {
		 return null;
	}
	
	public List<UserPublicInfo> searchBlockedMyPage(String myPageTitle) {
		return null;
	}
	
}
