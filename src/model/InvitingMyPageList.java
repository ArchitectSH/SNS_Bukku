package model;

import java.util.List;
import java.util.Map;

public class InvitingMyPageList {
	private Map<String,List<MyPagePublicInfo>> invitedList;
	private Map<String,List<UserPublicInfo>> invitingList;
	
	public InvitingMyPageList() {
		super();
	}
	
	public InvitingMyPageList(Map<String, List<MyPagePublicInfo>> invitedList,
			Map<String, List<UserPublicInfo>> invitingList) {
		super();
		this.invitedList = invitedList;
		this.invitingList = invitingList;
	}

	public int addInvitingMyPage(String myPageTitle, UserPublicInfo userPublicInfo) {
		return 1;
	}
	
	public int addInvitedMyPage(String id, MyPagePublicInfo myPagePublicInfo) {
		return 1;
	}
	
	public int removeInvitedMyPage(String myPageTitle, UserPublicInfo userPublicInfo) {
		return 1;
	}
	
	public int removeInvitingMyPage(String id, MyPagePublicInfo myPagePublicInfo) {
		return 1;
	}
	
	public int checkInvitingUsers(String myPageTitle, String invitedUserId) {
		return 1;
	}
	
	public List<MyPagePublicInfo> searchInvitedMyPage(String userId) {
		return null;
	}
	
	public List<UserPublicInfo> searchInvitingUsers(String myPageTitle) {
		return null;
	}
}
