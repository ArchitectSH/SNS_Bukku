package applicationController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.MyPage;
import model.MyPageList;
import model.MyPagePublicInfo;
import model.UserPublicInfo;
import persistanceController.MyPageDBManager;
import viewHelperBean.FollowingMyPageViewBean;
import viewHelperBean.MyPagePublicBean;
import viewHelperBean.MyPageViewBean;
import viewHelperBean.UserPublicBean;
import dto.ApprovalPageViewDTO;
import dto.FollowingMyPageViewDTO;
import dto.FriendInfoViewDTO;
import dto.MyPageInfoViewDTO;
import form.MyPageForm;
/**
 * 마이페이지 application Layer의 컨트롤러이다. 마이페이지 만들기, 수정, 찾기 등
 * 마이페이지와 관련된 여러 일들을 하는데에 있어서 중간에서 control 하는 역할을 한다.
 * @author 희빈
 *
 */
public class MyPageController {
	/*자신의 타입인 MyPageController를 static멤버로 가지고있다.*/
	private static MyPageController myPageController;
	/*model패키지 소속인 MyPageList객체를 멤버로 캡슐화 하고 있다.*/
	private MyPageList myPageList;
	
	/**
	 * 해당 클래스형의 객체를 외부 클래스에서 사용하고자 할 때, 생성하지 않고 이미 생성되있는 상태라면
	 * 기존에 생성된 객체를 리턴하여 주고, 한번도 생성된 적이 없다면 생성해서 리턴해 주는 메소드로, static이다.
	 * @return
	 */
	public static synchronized MyPageController getInstance() {
		if(myPageController == null){
			myPageController = new MyPageController();
			return myPageController;
		}
		return myPageController;
	}
	/**
	 * 생성자로, 생성이 해당 클래스 내부에서만 가능하므로 외부 클래스에서 사용할 수 없는 private 형태이다.
	 */
	private MyPageController() {
		myPageList = new MyPageList();
		Map<String, MyPage> mapMyPageList = new HashMap<String, MyPage>();
		List<MyPage> mpList = getMyPageDB();
		for(MyPage mp : mpList){
			//System.out.println(mp);
			mapMyPageList.put(mp.getMyPagePublicInfo().getMyPageTitle(), mp);
		}
		myPageList.setMyPageList(mapMyPageList);
	}
	
	/**
	 * 캡슐화 하고 있는 멤버인 myPageList를 외부 클래스에서 사용하고자 할 때 이용되는 메소드이다.
	 * @return the myPageList
	 */
	public MyPageList getMyPageList() {
		return myPageList;
	}
	/**
	 * DB에 저장되어있는 마이페이지의 모든 정보를 가져올 때 사용되는 메소드로, MyPageDBManager에 있는 같은 형태의 메소드를 간접호출해서
	 * 값을 받아와, 모든 마이페이지 정보를 List형태로 바꾸어 리턴한다.
	 * @return List<MyPage> 모든 마이페이지의 정보
	 */
	public List<MyPage> getMyPageDB() {
		MyPageDBManager myPageDBManager = MyPageDBManager.getInstance();
		
		List<MyPage> myPageList = new ArrayList<MyPage>();
		List<MyPageInfoViewDTO> myPageInfoViewDTOList = myPageDBManager.getMyPage();
		for(MyPageInfoViewDTO myPageInfoViewDTO:myPageInfoViewDTOList){
			MyPagePublicInfo info = new MyPagePublicInfo();
			info.setMyPageTitle(myPageInfoViewDTO.getMyPageTitle());
			info.setMyPageImg(myPageInfoViewDTO.getMyPageImg());
			
			MyPage myPage = new MyPage(myPageInfoViewDTO.getMyPageIntroduction(), myPageInfoViewDTO.getMasterId(), info);
			myPageList.add(myPage);
		}
		return myPageList;
	}
	/**
	 * 마이페이지의 소개글이 변경될 때 호출되는 메소드이다.
	 * @param introduction
	 * @param title
	 * @return int 성공적으로 변경되었는지 여부
	 */
	public int updateMyPageIntroDB(String introduction, String title){
		MyPageDBManager myPageDBManager = MyPageDBManager.getInstance();
		int check = myPageDBManager.updateMyPageIntro(introduction, title);
		return check;
	}
	public int makeMyPageDB(String title, String img, String myPageIntroduction, String id) {
		return 1;
	}
	
	public int makeMyPageDB(MyPageForm myPageForm, String id) {
		MyPageDBManager dbManager = MyPageDBManager.getInstance();
		
		MyPage myPage = new MyPage(myPageForm.getMyPageIntroduction(), id, 
				new MyPagePublicInfo(myPageForm.getTitle(), myPageForm.getImg()));
		int check = dbManager.makeMyPage(myPage);
		
		return check;
	}
	
	public List<MyPagePublicBean> searchMyPageDB(String title) {
		MyPageDBManager dbManager = MyPageDBManager.getInstance();
		List<MyPageInfoViewDTO> ilist = dbManager.getMyPageInfoViewLike(title);
		List<MyPagePublicBean> list = new ArrayList<MyPagePublicBean>();
		for(MyPageInfoViewDTO dto : ilist){
			MyPagePublicBean bean = new MyPagePublicBean();
			bean.setTitle(dto.getMyPageTitle());
			bean.setImg(dto.getMyPageImg());		
			
			list.add(bean);
		}
		return list;
	}
	
	public List<MyPagePublicBean> searchMyPageDB(MyPagePublicBean myPagePublicBean) {
		return null;
	}
	
	public int followMyPageDB(String title, String id) {
		MyPageDBManager dbManager = MyPageDBManager.getInstance();
		int check = dbManager.followMyPage(title, id);
		return check;
	}
	
	public int followMyPageDB(MyPagePublicBean myPagePublicBean, String id) {
		return 1;
	}
	
	public int cancelFollowingDB(String title, String id) {
		MyPageDBManager dbManager = MyPageDBManager.getInstance();
		int check = dbManager.cancelFollowing(title, id); 
		return check;
	}
	
	public int cancelFollowingDB(MyPagePublicBean myPagePublicBean, String id) {
		return 1;
	}
	
	public MyPageViewBean getMyPageInfoViewDB(String title) {
		MyPageDBManager dbManager = MyPageDBManager.getInstance();
		MyPageInfoViewDTO myPageInfoViewDTO = dbManager.getMyPageInfoView(title);
		MyPageViewBean myPageViewBean =null;
		if(myPageInfoViewDTO!=null)
		myPageViewBean = new MyPageViewBean(myPageInfoViewDTO.getMyPageTitle(), myPageInfoViewDTO.getMyPageImg(),
				myPageInfoViewDTO.getMyPageIntroduction(), myPageInfoViewDTO.getMyPageFollower(), myPageInfoViewDTO.getMasterId());
		return myPageViewBean;
	}
	
	public List<MyPageViewBean> getMyPageInfoViewById(String id){
		MyPageDBManager dbManager = MyPageDBManager.getInstance();
		List<MyPageInfoViewDTO> ilist = dbManager.getMyPageInfoViewById(id);
		List<MyPageViewBean> list = new ArrayList<MyPageViewBean>();
		for(MyPageInfoViewDTO dto : ilist){
			MyPageViewBean bean = new MyPageViewBean();
			bean.setTitle(dto.getMyPageTitle());
			bean.setFollowerNum(dto.getMyPageFollower());
			bean.setImg(dto.getMyPageImg());
			bean.setIntroduction(dto.getMyPageIntroduction());
			bean.setMasterId(dto.getMasterId());
			
			list.add(bean);
		}
		
		return list;
	}
	
	public MyPageViewBean getMyPageInfoViewDB(MyPagePublicBean myPagePublicBean) {
		return null;
	}
	
	public int removeMyPageDB(String title) {
		MyPageDBManager dbManager = MyPageDBManager.getInstance();
		int check = dbManager.removeMyPage(title);
		
		return check;
	}
	
	public int removeMyPageDB(MyPagePublicBean myPagePublicBean) {
		return 1;
	}
	
	public int blockMyPageDB(String title, String id) {
		return 1;
	}
	
	public int blockMyPageDB(MyPagePublicBean myPagePublicBean, String id) {
		return 1;
	}
	
	public int inviteMyPageDB(String title, String id) {
		
		return 1;
	}
	
	public List<FollowingMyPageViewBean> getFollowingMyPageDB(String id) {
		MyPageDBManager dbManager = MyPageDBManager.getInstance();
		List<FollowingMyPageViewDTO> ilist = dbManager.getFollowingMyPage(id);
		List<FollowingMyPageViewBean> list = new ArrayList<FollowingMyPageViewBean>();
		for(FollowingMyPageViewDTO dto : ilist){
			FollowingMyPageViewBean bean = new FollowingMyPageViewBean();
			bean.setFollowerId(dto.getFollowerId());
			bean.setImg(dto.getMyPageImg());
			bean.setTitle(dto.getMyPageTitle());
			bean.setMasterId(dto.getMasterId());
			
			list.add(bean);
		}
		return list;
	}
	
	public int inviteMyPageDB(viewHelperBean.MyPagePublicBean myPagePublicBean, String id) {
		return 1;
	}
	
	
	public List<MyPagePublicBean> getInvitingMyPageDB(String id) {
		return null;
	}
	
	public int responseMyPageDB(String title, String id, boolean response) {
		MyPageDBManager manager = MyPageDBManager.getInstance();
		manager.responseMyPage(title, id, response);
		return 1;
	}
	
	public int responseMyPageDB(MyPageForm myPageForm, boolean response) {
		return 1;
	}
	
	public int makeMyPage(String masterId, String myPageTitle, String myPageImg, String myPageIntroduction) {
		return 1;
	}
	
	public int makeMyPage(String masterId, MyPageForm myPageForm) {
		System.out.println("컨트롤러에들어온다!");
		myPageList.makeMyPage(masterId, myPageForm.getTitle(), myPageForm.getImg(), myPageForm.getMyPageIntroduction());
		return 1;
	}
	
	public int blockMyPage(String blockId, String myPageTitle) {
		return 1;
	}
	
	public int blockMyPage(String blockId, viewHelperBean.MyPagePublicBean myPagePublicBean) {
		return 1;
	}
	
	public int inviteMyPage(String invitedId, String myPageTitle) {
		MyPageDBManager myPageDBManager = MyPageDBManager.getInstance();
		int check = myPageDBManager.inviteMyPage(myPageTitle, invitedId);
		return check;
	}
	
	public int inviteMyPage(String invitedId, MyPagePublicBean myPagePublicBean) {
		return 1;
	}
	
	public int removeMyPage(String myPageTitle) {
		return 1;
	}
	
	public int removeMyPage(viewHelperBean.MyPagePublicBean myPagePublicBean) {
		return 1;
	}
	
	public List<MyPagePublicBean> searchMyPageByMyPageTitle(String myPageTitle) {
		return null;
	}
	
	public List<MyPagePublicBean> searchMyPageByMyPageTitle(viewHelperBean.MyPagePublicBean myPagePublicBean) {
		return null;
	}
	
	public List<MyPagePublicBean> searchMyPageById(String masterId) {
		return null;
	}
	
	public int updateMyPageIntro(String title, String intro){
		myPageList.updateMyPageIntro(title, intro);
		return 1;
	}
	
	public List<UserPublicBean> checkInvite(String title, List<FriendInfoViewDTO> list){
		MyPageDBManager myPageDBManager = MyPageDBManager.getInstance();
		List<FriendInfoViewDTO> list2 = myPageDBManager.checkInvite(title, list);	//차단, 이미 초대된 친구를 제외한 친구목록을 리턴받음
		//System.out.println("들어오긴하니1 "+title);
		List<UserPublicBean> beanList = new ArrayList<UserPublicBean>();
		for(FriendInfoViewDTO fdto : list2){
			UserPublicBean upb = new UserPublicBean();
			upb.setId(fdto.getFriendId());
			upb.setName(fdto.getFriendName());
			upb.setProfileImg(fdto.getFriendProfileImg());
			beanList.add(upb);
			System.out.println(upb);
		}
		return beanList;
	}
	
	public List<UserPublicBean> getMyPageUserByKindTitle(Integer kind, String title){
		MyPageDBManager myPageDBManager = MyPageDBManager.getInstance();
		List<UserPublicInfo> list = myPageDBManager.getMyPageUserByKindTitle(kind, title);
		
		List<UserPublicBean> bList = new ArrayList<UserPublicBean>();
		for(UserPublicInfo info : list){
			UserPublicBean b = new UserPublicBean();
			b.setId(info.getId());
			b.setName(info.getName());
			b.setProfileImg(info.getPicture());
			bList.add(b);
		}
		
		return bList;
	}
	public List<UserPublicBean> getMyPageFollowingByTitle(String title){
		MyPageDBManager myPageDBManager = MyPageDBManager.getInstance();
		List<UserPublicInfo> list = myPageDBManager.getMyPageFollowingByTitle(title);
		List<UserPublicBean> bList = new ArrayList<UserPublicBean>();
		for(UserPublicInfo info : list){
			UserPublicBean b = new UserPublicBean();
			b.setId(info.getId());
			b.setName(info.getName());
			b.setProfileImg(info.getPicture());
			bList.add(b);
		}
		return bList;
	}
	public List<MyPagePublicBean> getApprovalPageViewById(String id){
		MyPageDBManager myPageDBManager = MyPageDBManager.getInstance();
		List<ApprovalPageViewDTO> list = myPageDBManager.getApprovalPageViewById(id);
		List<MyPagePublicBean> blist = new ArrayList<MyPagePublicBean>();
		
		for(ApprovalPageViewDTO dto : list){
			MyPagePublicBean mb = new MyPagePublicBean();
			mb.setTitle(dto.getMyPageTitle());
			mb.setImg(dto.getMyPageImg());
			blist.add(mb);
		}
		return blist;
	}

	public static void main(String[] args){
		MyPageController m = MyPageController.getInstance();
		
		Map<String, MyPage> mm = m.getMyPageList().getMyPageList();
		System.out.println(mm.get("dd"));
	}
	
	
}
