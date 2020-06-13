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
 * ���������� application Layer�� ��Ʈ�ѷ��̴�. ���������� �����, ����, ã�� ��
 * ������������ ���õ� ���� �ϵ��� �ϴµ��� �־ �߰����� control �ϴ� ������ �Ѵ�.
 * @author ���
 *
 */
public class MyPageController {
	/*�ڽ��� Ÿ���� MyPageController�� static����� �������ִ�.*/
	private static MyPageController myPageController;
	/*model��Ű�� �Ҽ��� MyPageList��ü�� ����� ĸ��ȭ �ϰ� �ִ�.*/
	private MyPageList myPageList;
	
	/**
	 * �ش� Ŭ�������� ��ü�� �ܺ� Ŭ�������� ����ϰ��� �� ��, �������� �ʰ� �̹� �������ִ� ���¶��
	 * ������ ������ ��ü�� �����Ͽ� �ְ�, �ѹ��� ������ ���� ���ٸ� �����ؼ� ������ �ִ� �޼ҵ��, static�̴�.
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
	 * �����ڷ�, ������ �ش� Ŭ���� ���ο����� �����ϹǷ� �ܺ� Ŭ�������� ����� �� ���� private �����̴�.
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
	 * ĸ��ȭ �ϰ� �ִ� ����� myPageList�� �ܺ� Ŭ�������� ����ϰ��� �� �� �̿�Ǵ� �޼ҵ��̴�.
	 * @return the myPageList
	 */
	public MyPageList getMyPageList() {
		return myPageList;
	}
	/**
	 * DB�� ����Ǿ��ִ� ������������ ��� ������ ������ �� ���Ǵ� �޼ҵ��, MyPageDBManager�� �ִ� ���� ������ �޼ҵ带 ����ȣ���ؼ�
	 * ���� �޾ƿ�, ��� ���������� ������ List���·� �ٲپ� �����Ѵ�.
	 * @return List<MyPage> ��� ������������ ����
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
	 * ������������ �Ұ����� ����� �� ȣ��Ǵ� �޼ҵ��̴�.
	 * @param introduction
	 * @param title
	 * @return int ���������� ����Ǿ����� ����
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
		System.out.println("��Ʈ�ѷ������´�!");
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
		List<FriendInfoViewDTO> list2 = myPageDBManager.checkInvite(title, list);	//����, �̹� �ʴ�� ģ���� ������ ģ������� ���Ϲ���
		//System.out.println("�������ϴ�1 "+title);
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
