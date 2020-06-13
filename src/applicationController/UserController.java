package applicationController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dto.FriendInfoViewDTO;
import model.AdminInfoList;
import model.BlockedMyPageList;
import model.BlockedUserList;
import model.Friend;
import model.FriendList;
import model.MyPagePublicInfo;
import model.Profile;
import model.UserInfo;
import model.UserInfoList;
import model.UserPublicInfo;
import model.UserSetting;
import model.UserSettingList;
import persistanceController.UserDBManager;
import validator.UserValidator;
import viewHelperBean.FriendInfoViewBean;
import viewHelperBean.UserBean;
import viewHelperBean.UserPublicBean;
import form.UserInfoForm;
import form.UserProfileForm;
import form.UserSearchForm;



public class UserController {
	private UserInfoList userInfoList;
	private UserSettingList userSettingList;
	private FriendList friendList;
	private AdminInfoList adminInfoList;
	private BlockedMyPageList blockedMyPageList;
	private BlockedUserList blockedUserList;
	private static UserController instance;
	/*static{
		instance = new UserController();
	}*/
	private UserController() {
		/*초기화해주어야*/
		this.userInfoList = new UserInfoList();
		this.userSettingList = new UserSettingList();
		this.friendList = new FriendList();
		this.adminInfoList = new AdminInfoList();
		this.blockedMyPageList = new BlockedMyPageList();
		this.blockedUserList = new BlockedUserList();	
	}
	
	public static UserController getInstance() {
		if(instance==null)
		{
			
			instance= new UserController();
			return instance;
		}
		return instance;
	
	}
	
	private void addUserInfo(String id) {
	
		//DB로부터 초기화시킬 정보 받아오기(id사용자에 관한 User정보들)
		UserDBManager userDBmanager = UserDBManager.getInstance();
		UserInfo userInfo = userDBmanager.getUserInfoDB(id);
		UserSetting userSetting = userDBmanager.getUserSettingDB(id);
		List<Friend> friends = userDBmanager.getFriendListDB(id);
		BlockedUserList blockedUserListDB = userDBmanager.getBlockedUserListDB(id);
		BlockedMyPageList blockedMyPageListDB = userDBmanager.getBlockedMyPageListDB(id);
		
		//모델에 초기화 시키기	
		this.userInfoList.joinMemeber(userInfo);
		this.userSettingList.addUserSetting(id, userSetting);
		/*Map<String,List<Friend>> friendM=this.friendList.getFriends();*/
		
		for(Friend friend : friends){
			/*if(friendM.containsKey(friend.getUserPublicInfo().getId())==false){
				
			}*/
			this.friendList.addFriend(id, friend);
		}
		
		//blockedUserList모델의 blockedList,blockingList
		Map<String,List<UserPublicInfo>> blockedList = this.blockedUserList.getBlockedList();
		Map<String,List<UserPublicInfo>> blockingList = this.blockedUserList.getBlockingList();
		
		//db에서 받아온 정보들 모델에 넣어주기
		Map<String,List<UserPublicInfo>> userblockedList = blockedUserListDB.getBlockedList();
		List<String> blockedUserKeys = new ArrayList<String>(userblockedList.keySet());
		for(String blockedUserKey :blockedUserKeys){
			blockedList.put(blockedUserKey, userblockedList.get(blockedUserKey));
		}
		Map<String,List<UserPublicInfo>> userblockingList = blockedUserListDB.getBlockingList();
		List<String> blockingUserKeys = new ArrayList<String>(userblockingList.keySet());
		for(String blockingUserKey :blockingUserKeys){
			blockingList.put(blockingUserKey, userblockingList.get(blockingUserKey));
		}
		
		//모델
		Map<String,List<UserPublicInfo>> myPageBlockedList = this.blockedMyPageList.getBlockedList();
		Map<String,List<MyPagePublicInfo>> myPageBlockingList = this.blockedMyPageList.getBlockingList();
		//db에서 받아온 정보들 모델에 넣어주기
		Map<String,List<UserPublicInfo>> myblockedList = blockedMyPageListDB.getBlockedList();
		List<String> myblockedKeys = new ArrayList<String>(myblockedList.keySet());
		for(String myblockedKey :myblockedKeys){
			myPageBlockedList.put(myblockedKey, myblockedList.get(myblockedKey));
		}
		Map<String,List<MyPagePublicInfo>> myblockingList = blockedMyPageListDB.getBlockingList();
		List<String> myblockingKeys = new ArrayList<String>(myblockingList.keySet());
		for(String myblockingKey :myblockingKeys){
			myPageBlockingList.put(myblockingKey, myblockingList.get(myblockingKey));
		}
		
	
	}
	
	public void setAdminList() {
	
	}
	
	public int joinDB(String id, String name, String password, int gender, String email, String phoneNumber, String birth) {
	 
		return 0;
	}
	
	public int joinDB(UserInfoForm userInfoForm) {
		UserValidator userValidator = new UserValidator();
		/*System.out.println("컨트롤러의 joinDB");*/
	
		if(userValidator.validate(userInfoForm).isEmpty() ==true){
			UserDBManager userDBmanager = UserDBManager.getInstance();
			int gender = 0;
			try{
				gender=Integer.parseInt( userInfoForm.getGender());
			}catch(NumberFormatException e){			
			}
		
			userDBmanager.joinDB(userInfoForm.getId(), userInfoForm.getName(), userInfoForm.getPassword(),
					gender,userInfoForm.getEmail(), userInfoForm.getPhoneNumber(),userInfoForm.getBirth());
			return 1;
		}else{
			return 0;
		}		
	}
	
	public UserPublicBean loginDB(String id, String password) {
		UserValidator userValidator = new UserValidator();
		/*System.out.println("컨트롤러의 loginDB");*/
	
		UserDBManager userDBmanager = UserDBManager.getInstance();
		UserPublicInfo userPublicInfo =userDBmanager.loginDB(id, password);
		if(userPublicInfo==null){
			return null;
		}
		
		addUserInfo(id);
		UserPublicBean bean = new UserPublicBean();
		bean.setId(userPublicInfo.getId());
		bean.setName(userPublicInfo.getName());
		bean.setProfileImg(userPublicInfo.getPicture());
		return bean;

	}
	
	public String findIdByEmailDB(String name, String email) {
		return email;
	
	}
	
	public String findIdByPhoneNumberDB(String name, String phoneNumber) {
		return null;
	}
	
	public String findPwByEmailDB(String name, String email) {
		return null;
	}
	
	public String findPwByPhoneNumberDB(String name, String phoneNumber) {
		return null;
	}
	
	public List<UserPublicBean> searchUserDB(String id, String name, int gender, String school, String location, String email, String phoneNumber) {
		return null;
	}
	
	public List<UserPublicBean> searchUserDB(UserSearchForm userSearchForm) {
		UserValidator userValidator = new UserValidator();
		if(userValidator.validate(userSearchForm).isEmpty() == true){ //유효성검증
			UserDBManager userDBmanager = UserDBManager.getInstance();	
			
			//학교바꿔주는거 여기서 일단 합니다
			String school = userSearchForm.getSchool();
			if(school.equals("soongsilUni")){
				school = "숭실대학교";
			}else if(school.equals("shamyookUni")){
				school = "삼육대학교";
			}else if(school.equals("sechoHigh")){
				school = "서초고등학교";
			}else if(school.equals("sechoMiddle")){
				school = "서초중학교";
			}else if(school.equals("geongmoonHigh")){
				school = "경문고등학교";
			}
				
			List<UserPublicInfo> users = userDBmanager.searchUser(userSearchForm.getId(),userSearchForm.getName(),Integer.parseInt(userSearchForm.getGender()),
					userSearchForm.getBirth(),school,userSearchForm.getLocation(),userSearchForm.getEmail(),userSearchForm.getPhoneNumber());
			if(users == null){
				return null;
			}else if(users.isEmpty()){
				return null;
			}
			List<UserPublicBean> beans = new ArrayList<UserPublicBean>();
			for(UserPublicInfo user :users){
				UserPublicBean bean =  new UserPublicBean();
				bean.setId(user.getId());
				bean.setName(user.getName());
				bean.setProfileImg(user.getPicture());
				beans.add(bean);
			}
			return beans;
		}else{
			return null;
		}		
	}
	
	//통합검색용 (이름검색)
	public List<UserPublicBean> searchUserByNameDB(String name) {
		UserDBManager userDBmanager = UserDBManager.getInstance();	
		List<UserPublicInfo> users = userDBmanager.searchUser(name);
		if(users == null){
			return null;
		}else if(users.isEmpty()){
			return null;
		}
		List<UserPublicBean> beans = new ArrayList<UserPublicBean>();
		for(UserPublicInfo user :users){
			UserPublicBean bean =  new UserPublicBean();
			bean.setId(user.getId());
			bean.setName(user.getName());
			bean.setProfileImg(user.getPicture());
			beans.add(bean);
		}
		return beans;	
	}
	
	
	public int modifyInfoDB(String id, String password, String newPassword, int gender, String email, String phoneNumber) {
		UserDBManager userDBmanager = UserDBManager.getInstance();	
		int result = userDBmanager.modifyInfoDB(id, password, newPassword, gender, email, phoneNumber);

		return result;
	}
	
	public int modifyInfoDB(UserInfoForm userInfoForm, String password) {
		return 0;
	}
	
	public int modifyProfileDB(String id, String picture, String school, String location) {
		return 0;
	}
	
	// 2월 1일 메소드 내부 채워놓음 
		public int modifyProfileDB(String id, UserProfileForm userProfileForm) {
			UserDBManager userDBmanager = UserDBManager.getInstance();	
			int result = userDBmanager.modifyProfileDB(id,userProfileForm.getProfileImg(),userProfileForm.getSchool(),userProfileForm.getLocation());

			return result;
		}
		
		
		//탈퇴
		public int withdrawDB(String id, String pw) {
			UserDBManager userDBmanager = UserDBManager.getInstance();	
			int result = userDBmanager.withdrawDB(id,pw);

			return result;
		}
	
	//회원 차단
	public int blockDB(String requestId, String blockId) {
		
		UserDBManager userDBmanager = UserDBManager.getInstance();
		Integer result = userDBmanager.blockDB(requestId,blockId);
		
		return 1;
	}
	
	//회원 차단 해제
		public int cancelBlockDB(String requestId, String blockId) {
			
			UserDBManager userDBmanager = UserDBManager.getInstance();
			Integer result = userDBmanager.cancelBlockDB(requestId,blockId);
			
			return 1;
		}
	
	public int stopUserDB(String id) {
		return 0;
	}
	
	public int setSearchLevelDB(String id, Integer searchLevel){
		return 0;
	}
	
	
	public int setAcceptingAlarmDB(String id, boolean postAlarm, boolean commentAlarm, boolean communityAlarm, boolean warningAlarm) {
		return 0;
	}
	
	/*친구추가 요청*/
	public int addFriendDB(String requestId, String receiveId) {

		UserDBManager userDBmanager = UserDBManager.getInstance();
		Integer result =userDBmanager.addFriendDB(requestId,receiveId);
		
	
		return result;
		
		
	}
	//친구요청에 응답하거나 요청 취소
	public int responseFriendDB(String receiveId, String requestId, boolean response) {

		UserDBManager userDBmanager = UserDBManager.getInstance();
		Integer result =userDBmanager.responseFriendDB(receiveId, requestId, response);
	
		if(response==true){
			//모델부분 초기화  일단 보류
	/*		FriendRelation fr = new FriendRelation();
			fr.setBukkuActDate(bukkuActDate);
			this.friendList.addFriend(receiveId, requestId);
			this.friendList.addFriend(requestId, receiveId);*/
		}
	
		return result;
		
	}
	
	public int removeFriendDB(String id, String removeId) {
		UserDBManager userDBmanager = UserDBManager.getInstance();
		Integer result =userDBmanager.removeFriendDB(id, removeId);
		return result;
	}
	
	public List<FriendInfoViewBean> getFriendListDB(String id) {
		List<FriendInfoViewBean> beans = new ArrayList<FriendInfoViewBean>();
		UserDBManager userDBmanager = UserDBManager.getInstance();
		List<Friend> friends =userDBmanager.getFriendListDB(id);
		if(friends==null){
			return null;
		}		
		for(Friend friend : friends){
			FriendInfoViewBean bean = new FriendInfoViewBean();
			bean.setBukkuIndex((int)Math.round((friend.getFriendRelation().getFriendBukkuIndex()+friend.getFriendRelation().getUserBukkuIndex())/2.0));
			bean.setBukkuLevel(friend.getFriendRelation().getBukkuLevel().getBukkuLevel());
		/*	bean.setFriendGender();*/
			bean.setFriendId(friend.getUserPublicInfo().getId());
		/*	bean.setFriendLocation(friendLocation);*/
			bean.setFriendName(friend.getUserPublicInfo().getName());
			bean.setFriendProfileImg(friend.getUserPublicInfo().getPicture());
		/*	bean.setFriendSchool(friendSchool);*/
		/*	bean.setNeedCommunicationCnt(needCommunicationCnt);
			bean.setNextBukkuLevel(nextBukkuLevel);*/
			bean.setUserId(id);
			beans.add(bean);			
		}
		return beans;
	}
	
	public FriendInfoViewBean getFriendDB(String id, String friendId) {
		UserDBManager userDBManager = UserDBManager.getInstance();
		
		FriendInfoViewDTO dto = userDBManager.getFriendViewDB(id, friendId);
		FriendInfoViewBean bean = new FriendInfoViewBean();

			bean.setBukkuIndex(dto.getFriendBukkuIndex());
			System.out.println(bean.getBukkuIndex());
			if(201<=bean.getBukkuIndex() && bean.getBukkuIndex()<=250){
				bean.setBukkuLevel("이제 막 친구가 된 사이");
				bean.setNeedCommunicationCnt(bean.getBukkuIndex()-200);
				bean.setNextBukkuLevel("어색한 친구 사이");
			}
			else if(151<=bean.getBukkuIndex()){
				bean.setBukkuLevel("어색한 친구 사이");
				bean.setNeedCommunicationCnt(bean.getBukkuIndex()-150);
				bean.setNextBukkuLevel("서로를 알아가는 사이");
			}
			else if(101<=bean.getBukkuIndex()){
				bean.setBukkuLevel("서로를 알아가는 사이");
				bean.setNeedCommunicationCnt(bean.getBukkuIndex()-100);
				bean.setNextBukkuLevel("터울없는 사이");
			}
			else if(51<=bean.getBukkuIndex()){
				bean.setBukkuLevel("터울없는 사이");
				bean.setNeedCommunicationCnt(bean.getBukkuIndex()-50);
				bean.setNextBukkuLevel("아띠");
			}
			else{
				bean.setBukkuLevel("아띠");
				bean.setNeedCommunicationCnt(50-bean.getBukkuIndex());
				bean.setNextBukkuLevel("완전한 아띠");
			}
		bean.setFriendGender(dto.getFriendGender());
		bean.setFriendId(dto.getFriendId());
		bean.setFriendLocation(dto.getFriendLocation());
		bean.setFriendName(dto.getFriendName());
		bean.setFriendProfileImg(dto.getFriendProfileImg());
		bean.setFriendSchool(dto.getFriendSchool());
		bean.setUserId(dto.getUserId());
		
		return bean;
	}
	
	//내가 친구요청한 회원 정보 가지고오기
	public List<UserPublicBean> getRequestFriendsDB(String id) {
		
		UserDBManager userDBmanager = UserDBManager.getInstance();	

			
		List<UserPublicInfo> users = userDBmanager.getRequestFriendsDB(id);
		if(users == null){
			return null;
		}else if(users.isEmpty()){
			return null;
		}
		List<UserPublicBean> beans = new ArrayList<UserPublicBean>();
		for(UserPublicInfo user :users){
			UserPublicBean bean =  new UserPublicBean();
			bean.setId(user.getId());
			bean.setName(user.getName());
			bean.setProfileImg(user.getPicture());
			beans.add(bean);
		}
		return beans;
			
	}
	//나에게 친구요청한 회원정보 가지고오기
	public List<UserPublicBean> getReceiveFriendsDB(String id) {
		
		UserDBManager userDBmanager = UserDBManager.getInstance();				
		List<UserPublicInfo> users = userDBmanager.getReceiveFriendsDB(id);
		if(users == null){
			return null;
		}else if(users.isEmpty()){
			return null;
		}
		List<UserPublicBean> beans = new ArrayList<UserPublicBean>();
		for(UserPublicInfo user :users){
			UserPublicBean bean =  new UserPublicBean();
			bean.setId(user.getId());
			bean.setName(user.getName());
			bean.setProfileImg(user.getPicture());
			beans.add(bean);
		}
		return beans;
	}
	
	public UserBean getUserProfileDB(String id) {
		UserInfo ui = UserDBManager.getInstance().getUserInfoDB(id);
		Profile profile = ui.getProfile();
		UserBean ub = new UserBean();
		ub.setId(id);
		ub.setBirth(profile.getBirth());
		ub.setEmail(ui.getUserPrivateInfo().getEmail());
		ub.setGender(profile.getGender());
		ub.setLocation(profile.getLocation());
		ub.setName(ui.getUserPublicInfo().getName());
		ub.setPhoneNumber(ui.getUserPrivateInfo().getPhoneNumber());
		ub.setProfileImg(ui.getUserPublicInfo().getPicture());
		ub.setSchool(ui.getProfile().getSchool());
		return ub;
	}
	//(파라미터기준)내가 블락한 사람들 가져오기(DB)
	public List<UserPublicBean> searchBlockingUserDB(String blockRequestId)
	{			
		UserDBManager userDBmanager = UserDBManager.getInstance();	
	
		BlockedUserList blockedUserListDB = userDBmanager.getBlockedUserListDB(blockRequestId);
	
				
	//	Map<String,List<UserPublicInfo>> userblockedList = blockedUserListDB.getBlockedList();
		Map<String,List<UserPublicInfo>> userblockingList = blockedUserListDB.getBlockingList();
		List<UserPublicInfo> blockingUsers = userblockingList.get(blockRequestId);
		List<UserPublicBean> beans = new ArrayList<UserPublicBean>();
		
		if(blockingUsers !=null){				
			for(UserPublicInfo user :blockingUsers){
				UserPublicBean bean =  new UserPublicBean();
				bean.setId(user.getId());
				bean.setName(user.getName());
				bean.setProfileImg(user.getPicture());
				beans.add(bean);
			}
		}
		return beans;
	}
	//나(파라미터)를 블락시킨 유저들 가져오기(DB)
	public List<UserPublicBean> searchBlockedUserDB(String blockedId)
	{			
		UserDBManager userDBmanager = UserDBManager.getInstance();	
	
		BlockedUserList blockedUserListDB = userDBmanager.getBlockedUserListDB(blockedId);
	
				
		Map<String,List<UserPublicInfo>> userblockedList = blockedUserListDB.getBlockedList();
		List<UserPublicInfo> blockedUsers = userblockedList.get(blockedId);
		List<UserPublicBean> beans = new ArrayList<UserPublicBean>();	
		if(blockedUsers !=null){				
			for(UserPublicInfo user :blockedUsers){
				UserPublicBean bean =  new UserPublicBean();
				bean.setId(user.getId());
				bean.setName(user.getName());
				bean.setProfileImg(user.getPicture());
				beans.add(bean);
			}
		}
		return beans;
	}
	//새로만든 메소드 2월 1일 비활성화
		public int deactiDB(String id) {
			UserDBManager userDBmanager = UserDBManager.getInstance();	 
			int result = userDBmanager.deactiDB(id);

			return result;
		}
		//새로만든 메소드 2월 1일 활성화
			public int actiDB(String id) {
				UserDBManager userDBmanager = UserDBManager.getInstance();	 
				int result = userDBmanager.actiDB(id);
				return result;
			}
	/*public int login(String id, String password) {
		return null;
	}
	
	public List<UserPublicBean> searchUserByName(String name) {
		return null;
	}
	
	private List<UserPublicBean> searchUserByName(List<UserPublicBean> allInfo, String name) {
		return null;
	}
	
	public List<UserPublicBean> searchUserBySchool(String school) {
		return null;
	}
	
	private List<UserPublicBean> searchUserBySchool(List<UserPublicBean> allInfo, String school) {
		return null;
	}
	
	public List<UserPublicBean> searchUserByLocation(String location) {
		return null;
	}
	
	private List<UserPublicBean> searchUserByLocation(List<UserPublicBean> allInfo, String location) {
		return null;
	}
	
	public List<UserPublicBean> searchUserByBirth(String birth) {
		return null;
	}
	
	private List<UserPublicBean> searchUserByBirth(List<UserPublicBean> allInfo, String birth) {
		return null;
	}
	
	public UserPublicBean searchUserById(String id) {
		return null;
	}
	
	private List<UserPublicBean> searchUserById(List<UserPublicBean> allInfo, String id) {
		return null;
	}
	
	public List<UserPublicBean> searchUserByGender(int gender) {
		return null;
	}
	
	private List<UserPublicBean> searchUserByGender(List<UserPublicBean> allInfo, int gender) {
		return null;
	}
	
	public UserPublicBean searchUserByPhoneNumber(String phoneNumber) {
		return null;
	}
	
	private List<UserPublicBean> searchUserByPhoneNumber(List<UserPublicBean> allInfo, String phoneNumber) {
		return null;
	}
	
	public UserPublicBean searchUserByEmail(String email) {
		return null;
	}
	
	private List<UserPublicBean> searchUserByEmail(List<UserPublicBean> allInfo, String email) {
		return null;
	}
	
	public UserPublicBean searchUser(String name, String school, String location, String birth, String id, int gender, String phoneNumbrt, String email) {
		return null;
	}
	
	public int setProfile(String id, String school, String location, String picture) {
		return null;
	}
	
	public int setProfile(String id, UserProfileForm userProfileForm) {
		return null;
	}
	
	public int modifyUserInfo(String id, String password, String email, String phoneNumber) {
		return null;
	}
	
	public String offerAccountIdByPhoneNumber(String name, String phoneNumber) {
		return null;
	}
	
	public String offerAccountIdByEmail(String name, String email) {
		return null;
	}
	
	public String offerAccountPwByPhoneNumber(String id, String phoneNumber) {
		return null;
	}
	
	public int withdrawUser(String id, String password) {
		return 0;
	}
	
	public int joinMember(String id, String password, String birth, int gender, String email, String phoneNumber) {
		return 0;
	}
	
	public int joinMember(UserInfoForm userInfoForm) {
		return 0;
	}
	
	public int stopUser(String id, boolean stopSetting) {
		return 0;
	}
	
	public int activateUser(String id, boolean activateSetting) {
		return 0;
	}
	
	public int setSearchLevel(String id, SearchLevel searchLevel) {
		return 0;
	}
	
	public int setAcceptingAlarm(String id, boolean acceptSetting) {
		return 0;
	}
	
	public int checkStopped(String id) {
		return 0;
	}
	
	public int checkActivated(String id) {
		return 0;
	}
	
	public int checkSearchLevel(String id) {
		return 0;
	}
	
	public int checkAcceptingAlarm(String id) {
		return 0;
	}
	
	public int addFriend(String id, String friendId) {
		return 0;
	}
	
	public int addFriend(String id, String friendId, String friendPicture, String friendName) {
		return 0;
	}
	
	public int removeFriend(String id, String friendId) {
		return 0;
	}
	
	public List<FriendInfoViewBean> searchFriend(String id) {
		return null;
	}
	
	public int checkFriend(String userId, String friendId) {
		return 0;
	}
	
	public String getBukkuLevel(String userId, String friendId) {
		return null;
	}*/
	
	public long decreaseBukkuIndex(String userId, String friendId) {
		return UserDBManager.getInstance().decreaseBukkuIndex(userId, friendId);
	}
	
	/*public UserBean getUserProfile(String id) {
		return null;
	}
	
	public void setUserSettingList(UserSettingList userSettingList) {
	
	}
	
	public void setFriendList(FriendList friendList) {
	
	}
	
	public void setAdminInfoList(AdminInfoList adminInfoList) {
	
	}
	
	public void setUserInfoList(UserInfoList userInfoList) {
	
	}
	
	public void setBlockedUserList(BlockedUserList blockedUserList) {
	
	}
	
	public void setBlockedMyPageList(BlockedMyPageList blockedMyPageList) {
	
	}
	
	public int addBlockingUser(String id, UserPublicBean userPublicBean) {
	
	}
	
	public int addBlockedUser(String id, UserPublicBean userPublicBean) {
	
	}
	
	public int removeBlockingUser(String id, UserPublicBean userPublicBean) {
	
	}
	
	public int removeBlockedUser(String id, UserPublicBean userPublicBean) {
	
	}
	
	public int checkBlockingUser(String blockRequestId, String blockedId) {
	
	}
	*/
	//(파라미터기준)내가 블락한 사람들 가져오기(모델에서 가져온다)
	public List<UserPublicBean> searchBlockingUser(String blockRequestId) {
		
		List<UserPublicInfo> blockedUsers = this.blockedUserList.getBlockedList().get(blockRequestId);
		
		List<UserPublicBean> beans = new ArrayList<UserPublicBean>();		
		for(UserPublicInfo user :blockedUsers){
			UserPublicBean bean =  new UserPublicBean();
			bean.setId(user.getId());
			bean.setName(user.getName());
			bean.setProfileImg(user.getPicture());
			beans.add(bean);
		}
		return beans;
	
	}
	//나(파라미터)를 블락시킨 유저들 가져오기(모델에서 가져온다)
	public List<UserPublicBean> searchBlockedUser(String blockedId) {
		
		List<UserPublicInfo> blockingUsers = this.blockedUserList.getBlockingList().get(blockedId);
				
		
		List<UserPublicBean> beans = new ArrayList<UserPublicBean>();
		
		for(UserPublicInfo user :blockingUsers){
			UserPublicBean bean =  new UserPublicBean();
			bean.setId(user.getId());
			bean.setName(user.getName());
			bean.setProfileImg(user.getPicture());
			beans.add(bean);
		}
		return beans;
	
	}
	
	//2월 2일 (비활성화 체크)
		public boolean checkDeactiDB(String id){
				UserDBManager userDBmanager = UserDBManager.getInstance();	 
		
				return userDBmanager.checkDeactiDB(id);
		}
	
/*	
	public int addBlockingMyPage(String id, MyPagePublicBean myPagePublicBean) {
	
	}
	
	public int addBlockedMyPage(String myPageTitle, UserPublicBean userPublicBean) {
	
	}
	
	public int removeBlockingMyPage(String id, MyPagePublicBean myPagePublicBean) {
	
	}
	
	public int removeBlockedMyPage(String myPageTitle, UserPublicBean userPublicBean) {
	
	}
	
	public int checkBlockingMyPage(String id, String mypageTitle) {
	
	}
	
	public List<MyPagePublicBean> searchBlockingMyPage(String id) {
	
	}
	
	public List<UserPublicBean> searchBlockedMyPage(String myPageTitle) {
	
	}*/
}
