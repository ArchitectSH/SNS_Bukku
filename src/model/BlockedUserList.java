package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BlockedUserList {
	private Map<String,List<UserPublicInfo>> blockingList;
	private Map<String,List<UserPublicInfo>> blockedList;
	
	public BlockedUserList() {
		super();
	
		this.blockingList = new HashMap<String,List<UserPublicInfo>>();
		this.blockedList = new HashMap<String,List<UserPublicInfo>>();
	}

	public BlockedUserList(Map<String, List<UserPublicInfo>> blockingList,
			Map<String, List<UserPublicInfo>> blockedList) {
		super();
		this.blockingList = blockingList;
		this.blockedList = blockedList;
	}

	public Map<String, List<UserPublicInfo>> getBlockingList() {
		return blockingList;
	}

	public void setBlockingList(Map<String, List<UserPublicInfo>> blockingList) {
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
		return "BlockedUserList [blockingList=" + blockingList
				+ ", blockedList=" + blockedList + "]";
	}

	
	public int addBlockingUser(String id, UserPublicInfo userPublicInfo) {
		if(blockingList.containsKey(id)==false){
			blockingList.put(id, new ArrayList<UserPublicInfo>());
		}
		blockingList.get(id).add(userPublicInfo);
		 return 1;
	}
	
	public int addBlockedUser(String id, UserPublicInfo userPublicInfo) {
		if(blockedList.containsKey(id)==false){
			blockedList.put(id, new ArrayList<UserPublicInfo>());
		}
		blockedList.get(id).add(userPublicInfo);
		 return 1;
	}
	
	public int removeBlockingUser(String id, UserPublicInfo userPublicInfo) {
		return 0;
	}
	
	public int removeBlockedUser(String id, UserPublicInfo userPublicInfo) {
		return 0;
	}
	
	public int checkBlockingUser(String blockRequestId, String blockedId) {
		return 0;
	}
	
	public List<UserPublicInfo> searchBlockingUser(String blockRequestId) {
		return blockingList.get(blockRequestId);		
	}
	
	public List<UserPublicInfo> searchBlockedUser(String blockedId) {
		return blockedList.get(blockedId);
	}
}
