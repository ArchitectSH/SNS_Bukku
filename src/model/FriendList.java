package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendList {
	private Map<String,List<Friend>> friends;
	public FriendList() {
		this.friends = new HashMap<String,List<Friend>>();
	}
	public FriendList(Map<String, List<Friend>> friends) {
		super();
		this.friends = friends;
	}
	public Map<String, List<Friend>> getFriends() {
		return friends;
	}
	public void setFriends(Map<String, List<Friend>> friends) {
		this.friends = friends;
	}
	@Override
	public String toString() {
		return "FriendList [friends=" + friends + "]";
	}
	
	
	public int addFriend(String id, Friend friend) {
		if(friends.containsKey(id)==false){
			friends.put(id, new ArrayList<Friend>());
		}
		friends.get(id).add(friend);
		 return 1;
	}
	
	public int addFriend(String id, UserPublicInfo userPublicInfo) {
		return 0;
	}
	
	public int removeFriend(String id, Friend friend) {
		return 0;
	}
	
	public List<Friend> searchFriend(String id) {
		return null;
	}

	
	public int checkFriend(String userId, String friendId) {
		return 0;
	}
	
	public BukkuLevel getBukkuLevel(String userId, String friendId) {
		return null;
	}
	
	public int decreaseBukkuIndex(String userId, String friendId) {
		return 0;
	}
}
