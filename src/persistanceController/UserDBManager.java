package persistanceController;

import injector.DataSourceManager;
import injector.MyPageDependencyInjector;
import injector.UserDependencyInjector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.BlockedMyPageList;
import model.BlockedUserList;
import model.BukkuLevel;
import model.Friend;
import model.FriendRelation;
import model.MyPagePublicInfo;
import model.Profile;
import model.SearchLevel;
import model.UserInfo;
import model.UserPrivateInfo;
import model.UserPublicInfo;
import model.UserSetting;
import action.BlockUserAction;
import action.CommonRelationAction;
import action.FriendAddingUserAction;
import action.FriendInfoViewAction;
import action.FriendReceiveViewAction;
import action.FriendRelationAction;
import action.MyPageInfoViewAction;
import action.MyPageUserAction;
import action.ReceiveAlarmSettingAction;
import action.UserAction;
import action.UserEnvironmentSettingAction;
import dto.BlockUserDTO;
import dto.CommonRelationDTO;
import dto.FriendInfoViewDTO;
import dto.FriendReceiveViewDTO;
import dto.FriendRelationDTO;
import dto.MyPageInfoViewDTO;
import dto.MyPageUserDTO;
import dto.ReceiveAlarmSettingDTO;
import dto.UserDTO;
import dto.UserEnvironmentSettingDTO;

public class UserDBManager {
	private UserDependencyInjector userDependencyInjector;
	private static UserDBManager instance;
	static{
		instance = new UserDBManager();
	}
	private UserDBManager() {
		DataSourceManager dataSourceManager = DataSourceManager.getInstance();
		userDependencyInjector = new UserDependencyInjector(dataSourceManager.getDataSource());
	}
	
	public static UserDBManager getInstance() {
		if(instance == null){
			instance = new UserDBManager();
			return instance;
		}
		return instance;	
	}
	
	public Integer joinDB(String id, String name, String password, Integer gender, String email, String phoneNumber, String birth) {
	/*	System.out.println("DBManager -> joinDB");*/
		UserAction userAction = (UserAction)userDependencyInjector.getObject(UserAction.class);
		userAction.insertUser(id, name, password, email, phoneNumber, gender, birth, null, null);
		
		return 1;
	}
	

	/*
	public Integer joinDB(UserInfo userInfo) {
	
	}
	
	private int valid(String id, String name, String password, Integer gender, String email, String phoneNumber, String birth) {
	
	}
	*/
	public UserPublicInfo loginDB(String id, String password) {
		UserAction userAction = (UserAction)userDependencyInjector.getObject(UserAction.class);
		UserDTO userDTO = userAction.getUserById(id);
		if(password.equals(userDTO.getPassword())==false){
			return null;
		}else{			
			return new UserPublicInfo(userDTO.getName(),userDTO.getId(),userDTO.getProfileImg());
		}
		
	}
	
/*	public UserPublicInfo loginDB(UserInfo userInfo) {
		return null;
	
	}
	
	public String findIdByEmailDB(String name, String email) {
	
	}
	
	public String findIdByEmailDB(UserInfo userInfo) {
	
	}
	
	public String findIdByPhoneNumberDB(String name, String phoneNumber) {
	
	}
	
	public String findIdByPhoneNumberDB(UserInfo userInfo) {
	
	}
	
	public String) findPwByPhoneNumberDB(String name, String phoneNumber) {
	
	}
	
	public String) findPwByPhoneNumberDB(UserInfo userInfo) {
	
	}
	
	public String findPwByEmailDB(String name, String email) {
	
	}
	
	public String findPwByEmailDB(UserInfo userInfo) {
	
	}
	
	public Integer modifyInfoDB(String id, String password, String newPassword, Integer gender, String email, String phoneNumber) {
	
	}
	
	public Integer modifyInfoDB(UserInfo userInfo) {
	
	}
	
	private int valid(String email, String phoneNumber) {
	
	}
	*/
	public Integer modifyInfoDB(String id, String password, String newPassword, Integer gender, String email, String phoneNumber) {
		UserAction userAction = (UserAction)userDependencyInjector.getObject(UserAction.class);
		
		userAction.updateUserInfo(newPassword, email, phoneNumber, gender, id, password);
		
		return 1;		
	}
	/*

	public Integer withdrawDB(String id, String pw) {
	
	}
	*/
	public Integer withdrawDB(String id, String pw) {
		UserAction userAction = (UserAction)userDependencyInjector.getObject(UserAction.class);
		userAction.deleteUser(id, pw);
		
		return 1;		
	}
	
	public Integer modifyProfileDB(String id, String picture, String school, String location) {
		UserAction userAction = (UserAction)userDependencyInjector.getObject(UserAction.class);
		UserDTO user =  userAction.getUserById(id);
		userAction.updateUserProfile(picture, school, location, id,user.getPassword());
		
		return 1;		
	}
	// 회원 차단
	public Integer blockDB(String requestId, String blockId) {
		BlockUserAction blockUserAction = (BlockUserAction)userDependencyInjector.getObject(BlockUserAction.class);
		blockUserAction.insertBlockUser(blockId, requestId);
		removeFriendDB(requestId,blockId);		
		return 1;
	}
	
	// 회원 차단 해제
	public Integer cancelBlockDB(String requestId, String blockId) {
		BlockUserAction blockUserAction = (BlockUserAction)userDependencyInjector.getObject(BlockUserAction.class);
		blockUserAction.deleteBlockUserPair(requestId, blockId);
		
		return 1;
	}
/*	
	public Integer blockDB(UserPublicInfo requestUserPublicInfo, UserPublicInfo blockUserPublicInfo) {
	
	}
	
	public Integer stopUserDB(String id) {
	
	}
	
	public Integer stopUserDB(UserPublicInfo userPublicInfo) {
	
	}
	
	public Integer setSearchLevelDB(String id, Integer searchLevel) {
	
	}
	
	public Integer setSearchLevelDB(UserPublicInfo userPublicInfo, UserSetting userSetting) {
	
	}
	
	public Integer setAcceptingAlarmDB(String id, Boolean postAlarm, Boolean commentAlarm, Boolean communityAlarm, Boolean warningAlarm) {
	
	}
	
	public Integer setAcceptingAlarmDB(UserPublicInfo userPublicInfo, UserSetting userSetting) {
	
	}*/
	
	public Integer addFriendDB(String requestId, String receiveId) {
		System.out.println("디비매니저"+requestId+"/"+receiveId);
		FriendAddingUserAction friendAddingUserAction = (FriendAddingUserAction)userDependencyInjector.getObject(FriendAddingUserAction.class);
		friendAddingUserAction.insertFriendAddingUser(requestId, receiveId);
	
		return 1;
	
	}

	public Integer addFriendDB(UserPublicInfo requestId, UserPublicInfo receiveId) {
		return null;
	}
	
	//친구요청에 응답하거나 친구요청을 취소한 경우 사용
	public Integer responseFriendDB(String receiveId, String requestId, Boolean response) {
		System.out.println("(친구응답)디비매니저"+requestId+"/"+receiveId+"/"+response);
		if(response==false){ //거절 혹은 친구요청 취소
			FriendAddingUserAction friendAddingUserAction = (FriendAddingUserAction)userDependencyInjector.getObject(FriendAddingUserAction.class);
			friendAddingUserAction.deleteByFriendAddingUser(requestId, receiveId);
			return 1;
		}else{ // 친구수락  (모델에 친구 추가시켜주어야한다.)
			
			FriendRelationAction friendRelationAction = (FriendRelationAction)userDependencyInjector.getObject(FriendRelationAction.class);
			friendRelationAction.insertFriendRelationBoth(receiveId, requestId);
			
			return 1;
		}
	
	}
	
	public Integer responseFriendDB(UserPublicInfo receiveId, UserPublicInfo requestId, Boolean response) {
		return 0;
	}

	public Integer removeFriendDB(String id, String removeId) {
		FriendRelationAction friendRelationAction = (FriendRelationAction)userDependencyInjector.getObject(FriendRelationAction.class);
		Integer friendNum = friendRelationAction.getFriendNumByIdNFriendId(id, removeId);
		
		if(friendNum != null){
			CommonRelationAction commonRelationAction = (CommonRelationAction)userDependencyInjector.getObject(CommonRelationAction.class);
			friendRelationAction.deleteFriendRelation(friendNum);
			commonRelationAction.deleteCommonRelation(friendNum);
		}		
		return 1;
	}
/*	
	public Integer removeFriendDB(userPublicInfo id, userPublicInfo removeId) {
	
	}
	
	public List<FriendInfoViewDTO> getFriendListDB(String id) {
	
	}
	
	public List<FriendInfoViewDTO> getFriendViewListDB(UserPublicInfo userPublicInfo) {
	
	}
	*/
	
	public FriendInfoViewDTO getFriendViewDB(String id, String friendId) {
		FriendInfoViewAction action = (FriendInfoViewAction)userDependencyInjector.getObject(FriendInfoViewAction.class);
		FriendInfoViewDTO bean = action.getFriendInfoViewByUserAndFriend(id, friendId);
		
		return bean;
	}
	/*
	public FriendInfoViewDTO getFriendDB(userPublicInfo id, UserPublicInfo friendId) {
	
	}
	*/
	public List<UserPublicInfo> getRequestFriendsDB(String id) {
		FriendReceiveViewAction friendReceiveViewAction = (FriendReceiveViewAction)userDependencyInjector.getObject(FriendReceiveViewAction.class);
		List<FriendReceiveViewDTO> friendReceiveViewDTOs = friendReceiveViewAction.getFriendReceiveViewByRequestId(id);
		
		
		List<UserPublicInfo> infos = new ArrayList<UserPublicInfo>();
		for(FriendReceiveViewDTO friendReceiveViewDTO :friendReceiveViewDTOs){
			infos.add(new UserPublicInfo(friendReceiveViewDTO.getReceiveName(),friendReceiveViewDTO.getReceiveId(),
					friendReceiveViewDTO.getReceiveProfileImg()));
		}		
		return infos;
	}
	
	public List<UserPublicInfo> getRequestFriendsDB(UserPublicInfo id) {
	return null;
	}
	
	public List<UserPublicInfo> getReceiveFriendsDB(UserPublicInfo id) {
	return null;
	}
	
	public List<UserPublicInfo> getReceiveFriendsDB(String id) {
		FriendReceiveViewAction friendReceiveViewAction = (FriendReceiveViewAction)userDependencyInjector.getObject(FriendReceiveViewAction.class);
		List<FriendReceiveViewDTO> friendReceiveViewDTOs = friendReceiveViewAction.getFriendReceiveViewByReceiveId(id);
				
		List<UserPublicInfo> infos = new ArrayList<UserPublicInfo>();
		for(FriendReceiveViewDTO friendReceiveViewDTO :friendReceiveViewDTOs){
			infos.add(new UserPublicInfo(friendReceiveViewDTO.getRequestName(),friendReceiveViewDTO.getRequestId(),
					friendReceiveViewDTO.getRequestProfileImg()));
		}	
		
		return infos;
	}
	
	public BlockedUserList getBlockedUserListDB(String id) {
		BlockUserAction blockUserAction = (BlockUserAction)userDependencyInjector.getObject(BlockUserAction.class);
		List<BlockUserDTO> blockRequests = blockUserAction.getBlockUserByReqId(id);
		List<BlockUserDTO> blockReceives = blockUserAction.getBlockUserByBlockedId(id);
		Map<String,List<UserPublicInfo>> blockingList = new HashMap<String,List<UserPublicInfo>>();
		Map<String,List<UserPublicInfo>> blockedList = new HashMap<String,List<UserPublicInfo>>();
		for(BlockUserDTO blockRequest : blockRequests){
			UserAction userAction = (UserAction)userDependencyInjector.getObject(UserAction.class);
			UserDTO userDTO = userAction.getUserById(blockRequest.getBlockedId());
			if(blockingList.containsKey(id)==false){
				blockingList.put(id,new ArrayList<UserPublicInfo>());
			}
			blockingList.get(id).add(new UserPublicInfo(userDTO.getName(),userDTO.getId(),userDTO.getProfileImg()));

		}
		for(BlockUserDTO blockReceive : blockReceives){
			UserAction userAction = (UserAction)userDependencyInjector.getObject(UserAction.class);
			UserDTO userDTO = userAction.getUserById(blockReceive.getBlockRequestId());
			if(blockedList.containsKey(id)==false){
				blockedList.put(id,new ArrayList<UserPublicInfo>());
			}
			blockedList.get(id).add(new UserPublicInfo(userDTO.getName(),userDTO.getId(),userDTO.getProfileImg()));
		}
		/*System.out.println("디비ing"+blockingList);
		System.out.println("디비ed"+blockedList);*/
		return new BlockedUserList(blockingList,blockedList);
	}
	
	public BlockedMyPageList getBlockedMyPageListDB(String id){
		Map<String,List<MyPagePublicInfo>> blockingList = new HashMap<String,List<MyPagePublicInfo>>();
		Map<String,List<UserPublicInfo>> blockedList = new HashMap<String,List<UserPublicInfo>>();
		
		DataSourceManager dataSourceManager = DataSourceManager.getInstance();
		MyPageDependencyInjector myPageDependencyInjector = new MyPageDependencyInjector(dataSourceManager.getDataSource());
		MyPageUserAction myPageUserAction = (MyPageUserAction)myPageDependencyInjector.getObject(MyPageUserAction.class);
		
		MyPageInfoViewAction myPageInfoViewAction = (MyPageInfoViewAction)myPageDependencyInjector.getObject(MyPageInfoViewAction.class);
		UserAction userAction = (UserAction)userDependencyInjector.getObject(UserAction.class);
		UserDTO userDTO = userAction.getUserById(id);
		
		List<MyPageUserDTO> myPageUserDTOs = myPageUserAction.getMyPageUserById(id);
		for(MyPageUserDTO myPageUserDTO : myPageUserDTOs){
			if(myPageUserDTO.getMyPageKindNo()==2){ //차단 한 경우
				String title = myPageUserDTO.getMyPageTitle();
				List<MyPageInfoViewDTO> mypageInfos = myPageInfoViewAction.getMyPageInfoViewByTitle(title);
				MyPageInfoViewDTO mypageInfo = mypageInfos.get(0);
				//blockingList넣기
				if(blockingList.containsKey(id)==false){
					blockingList.put(id, new ArrayList<MyPagePublicInfo>());
				}
				blockingList.get(id).add(new MyPagePublicInfo(title,mypageInfo.getMyPageImg()));
				//blockedList넣기
				if(blockedList.containsKey(title)==false){
					blockedList.put(title, new ArrayList<UserPublicInfo>());
				}
				blockedList.get(title).add(new UserPublicInfo(userDTO.getName(),userDTO.getId(),userDTO.getProfileImg()));
			}
		}
		return new BlockedMyPageList(blockingList,blockedList);
	
	}
	
	public UserInfo getUserInfoDB(String id) {
		UserAction userAction = (UserAction)userDependencyInjector.getObject(UserAction.class);
		UserDTO userDTO = userAction.getUserById(id);
		UserPublicInfo publicInfo = new UserPublicInfo(userDTO.getName(),userDTO.getId(),userDTO.getProfileImg());
		Profile profile= new Profile(userDTO.getGender(),userDTO.getBirth(),userDTO.getSchool(),userDTO.getLocation());
		UserPrivateInfo userPrivateInfo = new UserPrivateInfo(userDTO.getPassword(),userDTO.getEmail(),userDTO.getPhoneNumber(),userDTO.getJoinDate());
		
		UserInfo userInfo = new UserInfo(publicInfo,profile,userPrivateInfo);		
		return userInfo;
	}
	
	public UserSetting getUserSettingDB(String id) {
		UserEnvironmentSettingAction userEnvironmentSettingAction = (UserEnvironmentSettingAction)userDependencyInjector.getObject(UserEnvironmentSettingAction.class);
		UserEnvironmentSettingDTO userEnvironmentSettingDTO =  userEnvironmentSettingAction.getUserSettingById(id);
		ReceiveAlarmSettingAction receiveAlarmSettingAction = (ReceiveAlarmSettingAction)userDependencyInjector.getObject(ReceiveAlarmSettingAction.class);
		ReceiveAlarmSettingDTO ReceiveAlarmSettingDTO = receiveAlarmSettingAction.getAlarmSettingById(id);
		int privacyLevel = userEnvironmentSettingDTO.getPrivacyLevel();
		SearchLevel searchLevel =null;
		if(privacyLevel == 1){
			searchLevel = SearchLevel.ALL;
		}else if(privacyLevel == 2){
			searchLevel = SearchLevel.ONLY_FRIENDS;
		}else if(privacyLevel == 3){
			searchLevel = SearchLevel.NO_SEARCH;
		}
		List<Boolean> acceptingAlarm = new ArrayList<Boolean>();
		acceptingAlarm.add(ReceiveAlarmSettingDTO.isPostReceiveAlarm());
		acceptingAlarm.add(ReceiveAlarmSettingDTO.isCommentReceiveAlarm());
		acceptingAlarm.add(ReceiveAlarmSettingDTO.isCommunityReceiveAlarm());
		acceptingAlarm.add(ReceiveAlarmSettingDTO.isWarningReceiveAlarm());
		
		return new UserSetting(userEnvironmentSettingDTO.isDeactivation(),userEnvironmentSettingDTO.isUserStop(),searchLevel,acceptingAlarm);
	}
	
	public List<Friend> getFriendListDB(String id) {
		List<Friend> friends = new ArrayList<Friend>();
		FriendRelationAction friendRelationAction = (FriendRelationAction)userDependencyInjector.getObject(FriendRelationAction.class);
		List<FriendRelationDTO> friendRelationDTOs = friendRelationAction.getFriendRelationById(id);
		
		for(FriendRelationDTO dto : friendRelationDTOs){
			FriendRelationDTO friendRelationDTO = friendRelationAction.getFriendRelationByFriendNumID(dto.getFriendNo(), id);
			UserAction userAction = (UserAction)userDependencyInjector.getObject(UserAction.class);
			UserDTO friendUserDTO = userAction.getUserById(friendRelationDTO.getId());
		/*	UserDTO userDTO = userAction.getUserById(id);*/
			
			
			CommonRelationAction commonRelationAction = (CommonRelationAction)userDependencyInjector.getObject(CommonRelationAction.class);
			CommonRelationDTO commonRelationDTO = commonRelationAction.getCommonRelationByFriendNum(dto.getFriendNo());
			int bukku = (int)Math.round((dto.getBukkuIndex() + friendRelationDTO.getBukkuIndex())/2.0);
		
			BukkuLevel bukkuLevel = BukkuLevel.NOT_FRIEND;
			if(bukku >= 300){
				bukkuLevel=BukkuLevel.NOT_FRIEND;
			}else if(bukku >=201){
				bukkuLevel=BukkuLevel.JUST_FRIEND;
			}else if(bukku >=151){
				bukkuLevel=BukkuLevel.AWKWARD_FRIEND;
			}else if(bukku >=101){
				bukkuLevel=BukkuLevel.KNOWING_FRIEND;
			}else if(bukku >=51){
				bukkuLevel=BukkuLevel.CLOSE_FRIEND;
			}else if(bukku >=0){
				bukkuLevel=BukkuLevel.ATTI;
			}			
			Friend friend = new Friend(new UserPublicInfo(friendUserDTO.getName(),friendUserDTO.getId(),friendUserDTO.getProfileImg()),
					new FriendRelation(dto.getBukkuIndex(),friendRelationDTO.getBukkuIndex(),commonRelationDTO.getBukkuLimit(),commonRelationDTO.getBukkuActDate(),bukkuLevel));
			friends.add(friend);
		}
		
	
		return friends;
	}
	
	public List<UserPublicInfo> searchUser(String id, String name, Integer gender,String birth, String school, String location, String email, String phoneNumber) {
		UserAction userAction = (UserAction)userDependencyInjector.getObject(UserAction.class);
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		UserDTO user = null;
		
		if(name.isEmpty() && gender ==0 && birth.isEmpty() && school.isEmpty() && location.isEmpty() &&   email.isEmpty() && phoneNumber.isEmpty()){
			//아이디
				user = userAction.getUserById(id);
				userDTOs.add(user);
			}else if(id.isEmpty() && gender ==0 && birth.isEmpty() && school.isEmpty() && location.isEmpty() &&   email.isEmpty() && phoneNumber.isEmpty()){
			//이름
			
				userDTOs = userAction.getUserByName(name);
			}else if(id.isEmpty() && name.isEmpty() &&birth.isEmpty() && school.isEmpty() && location.isEmpty() &&   email.isEmpty() && phoneNumber.isEmpty()){
			//성별
				
				userDTOs = userAction.getUserByGender(gender);
			}else if(id.isEmpty() && name.isEmpty() && gender ==0 &&school.isEmpty() && location.isEmpty() &&   email.isEmpty() && phoneNumber.isEmpty()){
			//생년월일
				userDTOs = userAction.getUserByBirth(birth);
			}else if(id.isEmpty() && name.isEmpty() && gender ==0 && birth.isEmpty() && location.isEmpty() &&   email.isEmpty() && phoneNumber.isEmpty()){
			// 학교
				userDTOs = userAction.getUserBySchool(school);
			}else if(id.isEmpty() && name.isEmpty() && gender ==0 && birth.isEmpty() && school.isEmpty() &&  email.isEmpty() && phoneNumber.isEmpty()){
			// 지역
				userDTOs = userAction.getUserByLocation(location);
			}else if(id.isEmpty() && name.isEmpty() && gender ==0 && birth.isEmpty() && school.isEmpty() && location.isEmpty() && phoneNumber.isEmpty()){
			// 이메일
				user = userAction.getUserByEmail(email);
				userDTOs.add(user);
			}else if(id.isEmpty() && name.isEmpty() && gender ==0 && birth.isEmpty() && school.isEmpty() && location.isEmpty() &&   email.isEmpty() ){
			// 핸폰번호
				user = userAction.getUserByPhoneNumber(phoneNumber);
				userDTOs.add(user);
			}
			else if(id.isEmpty() && location.isEmpty() && school.isEmpty() && email.isEmpty() && phoneNumber.isEmpty()){
		//이름 성별 생년월일로 찾기
			userDTOs = userAction.getUserByNameGenderBirth(name, gender, birth);
		}else if(id.isEmpty() && location.isEmpty() && birth.isEmpty() && gender ==0 && email.isEmpty() && phoneNumber.isEmpty()){
		// 이름 학교로 찾기
			userDTOs = userAction.getUserByNameSchool(name, school);
		}else{
			/*System.out.println("서치 안함 ");*/
		}
		List<UserPublicInfo> infos = new ArrayList<UserPublicInfo>();
		for(UserDTO userDTO :userDTOs){
			infos.add(new UserPublicInfo(userDTO.getName(),userDTO.getId(),userDTO.getProfileImg()));
		}	
		
		return infos;
	}
	
	//통합검색용
	public List<UserPublicInfo> searchUser(String name) {
		UserAction userAction = (UserAction)userDependencyInjector.getObject(UserAction.class);
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();	
		userDTOs = userAction.getUserByName(name);
	
		List<UserPublicInfo> infos = new ArrayList<UserPublicInfo>();
		for(UserDTO userDTO :userDTOs){
			infos.add(new UserPublicInfo(userDTO.getName(),userDTO.getId(),userDTO.getProfileImg()));
		}	
		
		return infos;
	}
	/*
	public List<UserPublicInfo> searchUser(UserInfo userInfo) {
		
		return null;
	
	}*/
	//2월 1일 (비활성화)
		public Integer deactiDB(String id){
			UserEnvironmentSettingAction userEnvironmentSettingAction = (UserEnvironmentSettingAction)userDependencyInjector.getObject(UserEnvironmentSettingAction.class);
			userEnvironmentSettingAction.updateDeactivation(true, id);
			return 1;
		}
		public Boolean checkDeactiDB(String id){
			UserEnvironmentSettingAction userEnvironmentSettingAction = (UserEnvironmentSettingAction)userDependencyInjector.getObject(UserEnvironmentSettingAction.class);
			UserEnvironmentSettingDTO uesa = userEnvironmentSettingAction.getUserSettingById(id);
			
			return uesa.isDeactivation();
	}
		
		//2월 1일 (활성화)
		public Integer actiDB(String id){
			UserEnvironmentSettingAction userEnvironmentSettingAction = (UserEnvironmentSettingAction)userDependencyInjector.getObject(UserEnvironmentSettingAction.class);
			userEnvironmentSettingAction.updateDeactivation(false, id);
			return 1;
		}
	//승하
	public Long decreaseBukkuIndex(String userId, String friendId){
		FriendRelationAction fra = (FriendRelationAction)userDependencyInjector.getObject(FriendRelationAction.class);
		System.out.println(userId+" / "+friendId);
		Integer friendNum = fra.getFriendNumByIdNFriendId(userId, friendId);
		
		List<FriendRelationDTO> friendRelationList = fra.getFriendRelationByFriendNum(friendNum);
		FriendRelationDTO myFrd = null;
		FriendRelationDTO friendFrd = null;
		if(friendRelationList!=null){
			if(friendRelationList.get(0).equals(userId)){
				myFrd = friendRelationList.get(0);
				friendFrd = friendRelationList.get(1);
			}
			else{
				myFrd = friendRelationList.get(1);
				friendFrd = friendRelationList.get(0);
			}
			if(myFrd.getBukkuIndex()>=friendFrd.getBukkuIndex()){
				fra.updateBukkuIndex(friendNum, userId);
				CommonRelationAction cra = (CommonRelationAction)userDependencyInjector.getObject(CommonRelationAction.class);
				cra.updateBukku(friendNum);
			}
		}
		if(myFrd!=null)
			return Math.round((myFrd.getBukkuIndex()+friendFrd.getBukkuIndex())/2.0);
		else
			return Long.valueOf("-1");
	}
	public FriendInfoViewDTO getAttiFriend(String id, String friendId){
		FriendInfoViewAction fiva = (FriendInfoViewAction)userDependencyInjector.getObject(FriendInfoViewAction.class);
		FriendInfoViewDTO fivd = fiva.getFriendInfoViewByUserAndFriendAtti(id, friendId);
		return fivd;
	}
}
