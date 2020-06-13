package model;

import java.util.List;
import java.util.Map;

public class MyPageFollowers {
	private Map<String,List<MyPagePublicInfo>> myPageFollowingList;
	private Map<String,List<UserPublicInfo>> myPageFollowedList;
	
	public MyPageFollowers() {
	
	}
	
	public MyPageFollowers(Map<String, List<MyPagePublicInfo>> myPageFollowingList, Map<String, List<UserPublicInfo>> myPageFollowedList) {
		this.myPageFollowingList = myPageFollowingList;
		this.myPageFollowedList = myPageFollowedList;
	}
	
	public int addFollowingInfo(String id, MyPagePublicInfo myPagePublicInfo) {
		return 1;
	}
	
	public int addFollowedInfo(String myPageTitle, UserPublicInfo userPublicInfo) {
		return 1;
	}
	
	public int removeFollowingInfo(String id, MyPagePublicInfo myPagePublicInfo) {
		return 1;
	}
	
	public int removeFollowedInfo(String myPageTitle, UserPublicInfo userPublicInfo) {
		return 1;
	}
	
	public int checkFollowingInfo(String id, String myPageTitle) {
		return 1;
	}
	
	public List<MyPagePublicInfo> searchFollowingInfo(String id) {
		return null;
	}
	
	public List<UserPublicInfo> searchFollowedInfo(String myPageTitle) {
		return null;
	}
	
	public int updateFollowedInfo(String myPageTitle, MyPagePublicInfo myPagePublicInfo) {
		return 1;
	}
	
	public int updateFollowingInfo(String id, UserPublicInfo userPublicInfo) {
		return 1;
	}
}
