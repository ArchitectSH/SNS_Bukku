package persistanceController;

import injector.DataSourceManager;
import injector.MyPageDependencyInjector;
import injector.UserDependencyInjector;

import java.util.ArrayList;
import java.util.List;

import model.MyPage;
import model.MyPagePublicInfo;
import model.UserPublicInfo;
import action.ApprovalPageViewAction;
import action.FriendInfoViewAction;
import action.MyPageAction;
import action.MyPageFollowingAction;
import action.MyPageInfoViewAction;
import action.MyPageUserAction;
import action.MyPageUserKindAction;
import action.UserAction;
import dto.ApprovalPageViewDTO;
import dto.FollowingMyPageViewDTO;
import dto.FriendInfoViewDTO;
import dto.MyPageDTO;
import dto.MyPageFollowingDTO;
import dto.MyPageInfoViewDTO;
import dto.MyPageUserDTO;
import dto.UserDTO;

public class MyPageDBManager {
	private static MyPageDBManager myPageDBManager;
	private MyPageDependencyInjector myPageDependencyInjector;
	public static MyPageDBManager getInstance() {
		if(myPageDBManager == null){
			myPageDBManager = new MyPageDBManager();
			return myPageDBManager;
		}
		return myPageDBManager;
	}
	
	private MyPageDBManager() {
		DataSourceManager dataSourceManager = DataSourceManager.getInstance();
		myPageDependencyInjector = new MyPageDependencyInjector(dataSourceManager.getDataSource());
	}
	
	public List<MyPageInfoViewDTO> getMyPage() {
		MyPageAction myPageAction = (MyPageAction)myPageDependencyInjector.getObject(MyPageAction.class);
		
		List<MyPageInfoViewDTO> myPageInfoViewList = new ArrayList<MyPageInfoViewDTO>();
		List<MyPageDTO> myPageDTOList = myPageAction.getMyPage();
	
		for(MyPageDTO md : myPageDTOList){
			MyPageInfoViewDTO myPageInfoViewDTO = new MyPageInfoViewDTO();
			myPageInfoViewDTO.setMyPageTitle(md.getMyPageTitle());
			myPageInfoViewDTO.setMyPageImg(md.getImg());
			myPageInfoViewDTO.setMyPageIntroduction(md.getMyPageIntroduction());
			myPageInfoViewDTO.setMasterId(md.getId());
			
			myPageInfoViewList.add(myPageInfoViewDTO);
		}
		
		return myPageInfoViewList;
	}
	public Integer updateMyPageIntro(String introduction, String title){
		MyPageAction myPageAction = (MyPageAction)myPageDependencyInjector.getObject(MyPageAction.class);
		myPageAction.updateMyPageIntro(introduction, title);
		return 1;
	}
	
	public Integer makeMyPage(String title, String img, String myPageIntroduction, String id) {
		return null;
	}
	
	public Integer makeMyPage(MyPage myPage) {
		
		int check = valid(myPage.getMyPagePublicInfo().getMyPageTitle());
		if(check == 1){
			MyPageAction myPageAction = (MyPageAction)myPageDependencyInjector.getObject(MyPageAction.class);
			myPageAction.insertMyPage(myPage.getMyPagePublicInfo().getMyPageTitle(), myPage.getMyPagePublicInfo().getMyPageImg(),
					myPage.getMyPageIntroduction(), myPage.getMyPageMaster());
		}
		
		return new Integer(check);
	}
	
	private int valid(String title) {
		MyPageAction myPageAction = (MyPageAction)myPageDependencyInjector.getObject(MyPageAction.class);
		MyPageDTO myPageDTO = myPageAction.getMyPageByTitle(title);
		if(myPageDTO == null){
			return 1;
		}
		return 0;
	}
	
	public List<MyPagePublicInfo> searchMyPage(String title) {
		return null;
	}
	
	public List<MyPagePublicInfo> searchMyPage(MyPagePublicInfo myPagePublicInfo) {
		return null;
	}
	
	public Integer followMyPage(String title, String id) {
		MyPageFollowingAction myPageFollowingAction = (MyPageFollowingAction)myPageDependencyInjector.getObject(MyPageFollowingAction.class);
		myPageFollowingAction.insertMyPageFollowing(title, id);
		return 1;
	}
	
	public Integer followMyPage(MyPage myPage) {
		return null;
	}
	
	public Integer cancelFollowing(String title, String id) {
		MyPageFollowingAction action = (MyPageFollowingAction)myPageDependencyInjector.getObject(MyPageFollowingAction.class);
		action.deleteMyPageFollowingByTitleId(title, id);
		return 1;
	}
	
	public Integer cancelFollowing(MyPage myPage) {
		return null;
	}
	
	public MyPageInfoViewDTO getMyPageInfoView(String title) {
		MyPageInfoViewAction myPageInfoViewAction = (MyPageInfoViewAction)myPageDependencyInjector.getObject(MyPageInfoViewAction.class);
		List<MyPageInfoViewDTO> myPageInfoViewDTOs= myPageInfoViewAction.getMyPageInfoViewByTitle(title);
		if(myPageInfoViewDTOs != null && myPageInfoViewDTOs.size()>0){
			return myPageInfoViewDTOs.get(0);
		}
		return null;
	}
	
	public MyPageInfoViewDTO getMyPageInfoView(MyPagePublicInfo myPagePublicInfo) {
		return null;
	}
	/*통합검색 에 쓰이는 메소드 31일 6시 새로 추가(장영은)*/
	public List<MyPageInfoViewDTO> getMyPageInfoViewLike(String title) {
		MyPageInfoViewAction myPageInfoViewAction = (MyPageInfoViewAction)myPageDependencyInjector.getObject(MyPageInfoViewAction.class);
		List<MyPageInfoViewDTO> myPageInfoViewDTOs= myPageInfoViewAction.getMyPageInfoViewByTitle(title);
		if(myPageInfoViewDTOs != null){
			return myPageInfoViewDTOs;
		}
		return null;
	}
	public List<MyPageInfoViewDTO> getMyPageInfoViewById(String id){
		MyPageInfoViewAction myPageInfoViewAction = (MyPageInfoViewAction)myPageDependencyInjector.getObject(MyPageInfoViewAction.class);
		List<MyPageInfoViewDTO> list = myPageInfoViewAction.getMyPageInfoViewById(id);
		return list;
	}
	public Integer removeMyPage(String title) {
		MyPageAction myPageAction = (MyPageAction)myPageDependencyInjector.getObject(MyPageAction.class);
		myPageAction.deleteMyPage(title);
		
		return 1;
	}
	
	public Integer removeMyPage(MyPagePublicInfo myPagePublicInfo) {
		return null;
	}
	
	public Integer blockMyPage(String title, String id) {
		return null;
	}
	
	public Integer blockMyPage(MyPage myPage) {
		return null;
	}
	
	public Integer inviteMyPage(String title, String id) {
		System.out.println("웅라인");
		MyPageUserAction myPageUserAction = (MyPageUserAction)myPageDependencyInjector.getObject(MyPageUserAction.class);
		myPageUserAction.insertMyPageUser(title, 1, id);
		return 1;
	}
	
	public Integer inviteMyPage(MyPage myPage) {
		return null;
	}
	
	public List<FollowingMyPageViewDTO> getFollowingMyPage(String id) {
		MyPageFollowingAction myPageFollowingAction = (MyPageFollowingAction)myPageDependencyInjector.getObject(MyPageFollowingAction.class);
		List<MyPageFollowingDTO> flist = myPageFollowingAction.getMyPageFollowingById(id);
		
		MyPageAction myPageAction = (MyPageAction)myPageDependencyInjector.getObject(MyPageAction.class);
		List<MyPageDTO> vlist = new ArrayList<MyPageDTO>();
		for(MyPageFollowingDTO dto : flist){
			MyPageDTO md = new MyPageDTO();
			md = myPageAction.getMyPageByTitle(dto.getMyPageTitle());
			vlist.add(md);
		}
			
		List<FollowingMyPageViewDTO> list = new ArrayList<FollowingMyPageViewDTO>();
		for(MyPageDTO dto : vlist){
			FollowingMyPageViewDTO vdto = new FollowingMyPageViewDTO();
			vdto.setFollowerId(id);
			vdto.setMasterId(dto.getId());
			vdto.setMyPageImg(dto.getImg());
			vdto.setMyPageTitle(dto.getMyPageTitle());
			list.add(vdto);
		}
		return list;
	}
	
	public List<FollowingMyPageViewDTO> getFollowingMyPage(MyPage myPage) {
		return null;
	}
	
	public List<MyPagePublicInfo> getInvitingMyPage(String id) {
		return null;
	}
	
	public List<MyPagePublicInfo> getInvitingMyPage(MyPage myPage) {
		return null;
	}
	
	public Integer modifyMyPage(String title, String image, String intro) {
		return null;
	}
	
	public Integer modifyMyPage(MyPage myPage) {
		return null;
	}
	
	public Integer responseMyPage(String title, String id, boolean response) {
		if(response == true){	//승낙이면
			MyPageFollowingAction myPageFollowingAction = (MyPageFollowingAction)myPageDependencyInjector.getObject(MyPageFollowingAction.class);
			myPageFollowingAction.insertMyPageFollowing(title, id);
		}
		MyPageUserAction myPageUserAction = (MyPageUserAction)myPageDependencyInjector.getObject(MyPageUserAction.class);
		myPageUserAction.deleteMyPageUserByTitleId(id, title); //공통적으로 초대목록에서 지워주기
		return 1;
	}
	
	public Integer responseMyPage(MyPagePublicInfo myPagePublicInfo, boolean response) {
		return null;
	}
	
	public List<FriendInfoViewDTO> checkInvite(String title, List<FriendInfoViewDTO> list){
		MyPageFollowingAction myPageFollowingAction = (MyPageFollowingAction)myPageDependencyInjector.getObject(MyPageFollowingAction.class);
		List<MyPageFollowingDTO> flist = myPageFollowingAction.getMyPageFollowingByTitle(title);
		MyPageUserAction myPageUserAction = (MyPageUserAction)myPageDependencyInjector.getObject(MyPageUserAction.class);
		List<MyPageUserDTO> ulist = myPageUserAction.getMyPageUserByTitle(title);
		int cnt = 0;
		List<FriendInfoViewDTO> rlist = new ArrayList<FriendInfoViewDTO>();
		System.out.println("flist.size() : "+flist.size()+" / "+title);
		if(flist.size()>0){
			for(FriendInfoViewDTO dto : list){
				String id1 = dto.getFriendId();
				for(MyPageFollowingDTO fdto : flist){	//팔로잉 중인애 빼고 고르기
					String id2 = fdto.getId();
					//System.out.println(id1+" "+id2+" "+cnt);
					
					if(id1.equals(id2)){
						cnt++;
						//System.out.println(cnt);
					}
				}
				if(cnt == 0){
					rlist.add(dto);
				}
				//System.out.println(cnt);
				cnt=0;
			}
		}
		else{
			rlist = list;
		}
		cnt=0;
		List<FriendInfoViewDTO> rrlist = new ArrayList<FriendInfoViewDTO>();
		System.out.println("ulist.size() : "+ulist.size()+" / "+title);
		if(ulist.size() >0){
			for(FriendInfoViewDTO dto : rlist){
				String id1 = dto.getFriendId();
				for(MyPageUserDTO udto : ulist){	//차단or 이미 초대한 애 빼고 고르기
					String id2 = udto.getId();
					//System.out.println(id1+" "+id2+" "+cnt);
					if(id1.equals(id2)){
						cnt++;
					}
				}
				if(cnt == 0){
					rrlist.add(dto);
				}
				cnt=0;
			}
		}
		else{
			rrlist = rlist;
		}
		return rrlist;
	}
	
	public List<UserPublicInfo> getMyPageUserByKindTitle(Integer kind, String title){
		MyPageUserAction myPageUserAction = (MyPageUserAction)myPageDependencyInjector.getObject(MyPageUserAction.class);
		List<MyPageUserDTO> getList = myPageUserAction.getMyPageUserByKindTitle(kind, title);
		UserDependencyInjector userDependencyInjector = new UserDependencyInjector(DataSourceManager.getInstance().getDataSource());
		UserAction userAction = (UserAction)userDependencyInjector.getObject(UserAction.class);	//user 인젝터없어서 일단 걍 넣음
		//System.out.println(userAction);
		List<UserDTO> userList = new ArrayList<UserDTO>(); 
		
		for(MyPageUserDTO dto : getList){
			String uid = dto.getId();
			//System.out.println("옹 : "+uid);
			UserDTO u = new UserDTO();
			u = userAction.getUserById(uid);
			//System.out.println("옹 : "+uid+" "+u);
			userList.add(u);
		}
		
		List<UserPublicInfo> list = new ArrayList<UserPublicInfo>();
		for(UserDTO udto : userList){
			UserPublicInfo up = new UserPublicInfo();
			up.setId(udto.getId());
			up.setName(udto.getName());
			up.setPicture(udto.getProfileImg());
			list.add(up);
		}
		
		return list;
	}
	public List<UserPublicInfo> getMyPageFollowingByTitle(String title){
		MyPageFollowingAction myPageFollowingAction = (MyPageFollowingAction)myPageDependencyInjector.getObject(MyPageFollowingAction.class);
		List<MyPageFollowingDTO> getlist = myPageFollowingAction.getMyPageFollowingByTitle(title);
		 
		UserDependencyInjector userDependencyInjector = new UserDependencyInjector(DataSourceManager.getInstance().getDataSource());
		UserAction userAction = (UserAction)userDependencyInjector.getObject(UserAction.class);	//user 인젝터없어서 일단 걍 넣음
		//System.out.println(userAction);
		List<UserDTO> userList = new ArrayList<UserDTO>(); 
		
		for(MyPageFollowingDTO dto : getlist){
			String uid = dto.getId();
			//System.out.println("옹 : "+uid);
			UserDTO u = new UserDTO();
			u = userAction.getUserById(uid);
			//System.out.println("옹 : "+uid+" "+u);
			userList.add(u);
		}
		
		List<UserPublicInfo> list = new ArrayList<UserPublicInfo>();
		for(UserDTO udto : userList){
			UserPublicInfo up = new UserPublicInfo();
			up.setId(udto.getId());
			up.setName(udto.getName());
			up.setPicture(udto.getProfileImg());
			list.add(up);
		}
		return list;
	}
	
	public List<ApprovalPageViewDTO> getApprovalPageViewById(String id){
		ApprovalPageViewAction action = (ApprovalPageViewAction)myPageDependencyInjector.getObject(ApprovalPageViewAction.class);
		List<ApprovalPageViewDTO> list = action.getApprovalPageViewById(id);
		
		return list;
	}
}
