package servlet;

import injector.DataSourceManager;
import injector.UserDependencyInjector;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserPublicInfo;
import validator.MyPageValidator;
import viewHelperBean.FollowingMyPageViewBean;
import viewHelperBean.MyPagePublicBean;
import viewHelperBean.MyPageViewBean;
import viewHelperBean.UserPublicBean;
import action.FriendInfoViewAction;
import applicationController.AlarmController;
import applicationController.MyPageController;
import dto.FriendInfoViewDTO;
import form.MyPageForm;

/**
 * 마이페이지 관련한 기능들을 조작하는 서블릿이다.
 * 마이페이지 만들기, 정보수정, 폐쇄 등의 기능이 가능하다.
 * @author 희빈
 *
 */
@WebServlet({ "/page_servlet.do", "/page_main.do", "/make_page.do", "/set_page.do", "/setting_intro_page.do",
	"/remove_page.do", "/invite_page.do", "/inviting_friend.do", "/follow_member.do",
	"/myPage_Accept_Invite.do", "/myPage_Accept.do", "/myPage_remove_Invite.do", "/myPage_list.do",
	"/page_go.do", "/follow_page_go.do", "/cancel_follow.do","/myPage_follow.do","/cancel_list_follow.do"})
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 화면으로 부터 날아온 데이터가 get방식일 때 사용된다.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String disPatchUrl = null;
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		
		System.out.println(action);
		if(action.equals("page_servlet.do")){
			disPatchUrl = "home.jsp";
			mypageInvited(request, response);
			//disPatchUrl = "myPageMainUserVer.jsp";
		}
		else if(action.equals("page_main.do")){
			disPatchUrl = mainPage(request,response);
		}
		else if(action.equals("set_page.do")){
			disPatchUrl = settingMyPage(request, response);
		}
		else if(action.equals("invite_page.do")){
			disPatchUrl = invitePage(request, response);
		}
		else if(action.equals("inviting_friend.do")){
			disPatchUrl = invitingFriend(request,response);
		}
		else if(action.equals("follow_member.do")){
			disPatchUrl = followMember(request,response);
		}
		else if(action.equals("myPage_Accept.do")){
			disPatchUrl = mypageInvited(request, response);
		}
		else if(action.equals("myPage_Accept_Invite.do")){
			disPatchUrl = acceptInviteMyPage(request,response);
		}
		else if(action.equals("myPage_remove_Invite.do")){
			disPatchUrl = removeInviteMyPage(request,response);
		}
		else if(action.equals("myPage_list.do")){
			disPatchUrl = showListMyPage(request,response);
		}
		else if(action.equals("follow_page_go.do")){
			disPatchUrl = goFollowPage(request,response);
		}
		else if(action.equals("cancel_follow.do")){
			disPatchUrl = cancelFollow(request,response);
		}
		else if(action.equals("page_go.do")){
			disPatchUrl = goPage(request,response);
		}
		else if(action.equals("myPage_follow.do")){
			disPatchUrl = followPage(request,response);
		}
		else if(action.equals("cancel_list_follow.do")){
			disPatchUrl = cancelListFollow(request, response);
		}
		
		if(disPatchUrl != null){
			RequestDispatcher rd = request.getRequestDispatcher(disPatchUrl);
			rd.forward(request, response);
		}
	}

	/**
	 * 화면으로 부터 날아온 데이터가 post방식일 때 사용된다.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String disPatchUrl = null;
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		
		System.out.println(action);
		if(action.equals("make_page.do")){
			disPatchUrl = makePage(request,response);
		}
		else if(action.equals("setting_intro_page.do")){
			disPatchUrl = settingIntro(request,response);
		}
		else if(action.equals("remove_page.do")){
			disPatchUrl = removePage(request,response);
		}
		else if(action.equals("myPage_Accept.do")){
			disPatchUrl = acceptInviteMyPage(request,response);
		}
		
		if(disPatchUrl != null){
			RequestDispatcher rd = request.getRequestDispatcher(disPatchUrl);
			rd.forward(request, response);
		}
	}
//마이페이지 장 입장
	private String mainPage(HttpServletRequest request, HttpServletResponse response){
		String title = request.getParameter("title");
		MyPageController controller = MyPageController.getInstance();
		MyPageViewBean myPageViewBean = controller.getMyPageInfoViewDB(title);
		request.setAttribute("myPageInfo",myPageViewBean);
		return "showMyPagePost";
	}
	
	/**
	 * 페이지를 개설할 때 불리는 메소드로, 마이페이지 이름, 소개글, 이미지가 제대로 입력되었는지를 확인하고
	 * 마이페이지 생성을 돕는다.
	 * @param request 첫번째 전달인자로 요청객체를 받는다.
	 * @param response 두번째 전달인자로 응답객체를 받는다.
	 * @return String 페이지를 전환할 url을 리턴한다.
	 * @throws ServletException 
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	private String makePage(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException, ServletException{
		HttpSession session = request.getSession();
		UserPublicBean user = (UserPublicBean)session.getAttribute("userPublicBean");
		//폼
		MyPageForm form = new MyPageForm();
		form.setTitle(request.getParameter("myPageTitle"));
		form.setImg("image/mypage/"+request.getParameter("file"));
		form.setMyPageIntroduction(request.getParameter("intro"));
		
		//System.out.println(form);
		
		MyPageValidator myPageValidator = new MyPageValidator();
		List<String> errors = myPageValidator.validate(form);
		System.out.println(form);
		if(errors.isEmpty()){
			//모델생성
			//MyPage myPage = new MyPage(form.getMyPageIntroduction(), "id4",
			//		new MyPagePublicInfo(form.getTitle(), form.getImg()));
			MyPageController controller = MyPageController.getInstance();
			int check = controller.makeMyPageDB(form, user.getId());	//db에 추가
			check = controller.makeMyPage(user.getId(), form);	//모델에 추가
			
			if(check == 1){		    
				MyPageViewBean myPageViewBean = controller.getMyPageInfoViewDB(form.getTitle());
				request.setAttribute("myPageInfo",myPageViewBean);
				return "showMyPagePost";
			}
			else{
				return "home";
			}
		}
		else{
			request.setAttribute("myPage",form);
			request.setAttribute("errors", errors);
			return "home";
		}
	}
	/**
	 * 마이페이지의 설정 화면을 제공한다.
	 * 설정에서는 마이페이지 소개글, 이미지 변경이 가능하며, 마이페이지 폐쇄도 가능하다.
	 * @param request 첫번째 전달인자로 요청객체를 받는다.
	 * @param response 두번째 전달인자로 응답객체를 받는다.
	 * @return String 페이지를 전환할 url을 리턴한다.
	 */
	private String settingMyPage(HttpServletRequest request, HttpServletResponse response){
		String title = request.getParameter("title");
		MyPageController controller = MyPageController.getInstance();
		MyPageViewBean myPageViewBean = controller.getMyPageInfoViewDB(title);
		request.setAttribute("myPageInfo",myPageViewBean);
		return "myPageSetting.jsp";
	}
	/**
	 * 페이지의 소개글을 수정할 때 실행된다.
	 * @param request 첫번째 전달인자로 요청객체를 받는다.
	 * @param response 두번째 전달인자로 응답객체를 받는다.
	 * @return String 페이지를 전환할 url을 리턴한다.
	 */
	private String settingIntro(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String title = request.getParameter("hiddenTitle");
		String intro = request.getParameter("changeIntroText");
		MyPageController controller = MyPageController.getInstance();
		controller.updateMyPageIntroDB(intro, title);	//디비수정
		controller.updateMyPageIntro(title, intro);	//모델수정
		
		MyPageViewBean myPageViewBean = controller.getMyPageInfoViewDB(title);
		request.setAttribute("myPageInfo",myPageViewBean);
		return "showMyPagePost";
	}
	private String removePage(HttpServletRequest request, HttpServletResponse response) {
		String pw = request.getParameter("passwordInput");
		String pwCheck = request.getParameter("passwordCheck");
		
		System.out.println(pw+" / "+pwCheck+" / "+request.getParameter("hiddenTitle"));
		
		//벨리데이터로원래검사해야댐
		
		MyPageController controller = MyPageController.getInstance();
		controller.removeMyPageDB(request.getParameter("hiddenTitle"));	//디비에서 삭제
		controller.removeMyPage(request.getParameter("hiddenTitle"));	//모델에서 삭제
		
		return "home";
	}
	private String invitePage(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String id = request.getParameter("masterId");
		MyPageController controller = MyPageController.getInstance();
		System.out.println(id);
		MyPageViewBean myPageViewBean = controller.getMyPageInfoViewDB(title);
		//일단은 컨트롤러 안거치고 db에서 친구바로 받아옴
		UserDependencyInjector userDependencyInjector = new UserDependencyInjector(DataSourceManager.getInstance().getDataSource());
		FriendInfoViewAction friendInfoViewAction = (FriendInfoViewAction)userDependencyInjector.getObject(FriendInfoViewAction.class);
		List<FriendInfoViewDTO> fiv = friendInfoViewAction.getFriendInfoViewByUserId(id);
		
		List<UserPublicBean> friends = controller.checkInvite(title,fiv);	//초대할 수 있는 친구만 받아옴
	
		List<UserPublicBean> inviteFriends = controller.getMyPageUserByKindTitle(1, title);

		request.setAttribute("myPageInfo",myPageViewBean);
		request.setAttribute("inviteList", inviteFriends);
		request.setAttribute("list", friends);	//초대안된 친구목록 보내줌
		return "myPageInvite.jsp";
	}
	private String invitingFriend(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String id = request.getParameter("id");
		String masterId = request.getParameter("masterId");//세션으로 해야할 부분
		System.out.println(masterId);
		MyPageController controller = MyPageController.getInstance();
		controller.inviteMyPage(id, title);
		
		MyPageViewBean myPageViewBean = controller.getMyPageInfoViewDB(title);
		//일단은 컨트롤러 안거치고 db에서 친구바로 받아옴
		UserDependencyInjector userDependencyInjector = new UserDependencyInjector(DataSourceManager.getInstance().getDataSource());
		FriendInfoViewAction friendInfoViewAction = (FriendInfoViewAction)userDependencyInjector.getObject(FriendInfoViewAction.class);
		List<FriendInfoViewDTO> fiv = friendInfoViewAction.getFriendInfoViewByUserId(((UserPublicBean)request.getSession().getAttribute("userPublicBean")).getId());
		
		List<UserPublicBean> friends = controller.checkInvite(title,fiv);	//초대할 수 있는 친구만 받아옴
	
		List<UserPublicBean> inviteFriends = controller.getMyPageUserByKindTitle(1, title);
		
		//알람보내기
		AlarmController alarmController = AlarmController.getInstance();
		alarmController.addMyPageInviteAlarmDB(id, myPageViewBean.getMasterId(), title);
				
		
		
		request.setAttribute("myPageInfo",myPageViewBean);
		request.setAttribute("inviteList", inviteFriends);
		request.setAttribute("list", friends);	//초대안된 친구목록 보내줌
		return "myPageInvite.jsp";
	}

	private String followMember(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		System.out.println(title);
		MyPageController controller = MyPageController.getInstance();
		
		MyPageViewBean myPageViewBean = controller.getMyPageInfoViewDB(title);
		
		List<UserPublicBean> list = controller.getMyPageFollowingByTitle(title);
		
		request.setAttribute("myPageInfo",myPageViewBean);
		request.setAttribute("list", list);	//팔로잉중인 사람목록
		return "mypageFollower.jsp";
	}

//팔로워, 비팔로워 입장
	private String mypageInvited(HttpServletRequest request, HttpServletResponse response) {
		String userId=((UserPublicBean)request.getSession().getAttribute("userPublicBean")).getId();	//세션처리
		
		//초대받은 마이페이지 목록 받아오기
		MyPageController controller = MyPageController.getInstance();
		List<MyPagePublicBean> list = controller.getApprovalPageViewById(userId);
		
		request.setAttribute("list", list);
		request.setAttribute("id", userId);
		return "myPageAcceptInvite.jsp";
	}
	private String acceptInviteMyPage(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		System.out.println("승낙이당"+title);
		String id =  ((UserPublicBean)request.getSession().getAttribute("userPublicBean")).getId(); //세션처리
		
		MyPageController controller = MyPageController.getInstance();
		controller.responseMyPageDB(title, id, true);
		MyPageViewBean myPageViewBean = controller.getMyPageInfoViewDB(title);
		
		AlarmController alarmController = AlarmController.getInstance();
		alarmController.addMyPageFollowAlarmDB(myPageViewBean.getMasterId(), id, title);	//알람추가	
		
		//초대받은 마이페이지 목록 받아오기
		List<MyPagePublicBean> list = controller.getApprovalPageViewById(id);
				
		request.setAttribute("list", list);
		request.setAttribute("id", id);
		
		return "myPageAcceptInvite.jsp";
	}
	private String removeInviteMyPage(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		System.out.println("거절이당"+title);
		String id =  ((UserPublicBean)request.getSession().getAttribute("userPublicBean")).getId();  //세션처리
		
		MyPageController controller = MyPageController.getInstance();
		controller.responseMyPageDB(title, id, false);
		
		//초대받은 마이페이지 목록 받아오기
		List<MyPagePublicBean> list = controller.getApprovalPageViewById(id);
				
		request.setAttribute("list", list);
		request.setAttribute("id", id);
		
		return "myPageAcceptInvite.jsp";
	}
	private String showListMyPage(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
		String id=userPublicBean.getId();
		MyPageController controller = MyPageController.getInstance();
		List<MyPageViewBean> blist = controller.getMyPageInfoViewById(id);	//내가 만든 마이페이지 받아오기
		List<FollowingMyPageViewBean> flist = controller.getFollowingMyPageDB(id);	//팔로잉중인 마이페이지 가져오기
		
		request.setAttribute("followList", flist);
		request.setAttribute("makeList", blist);
		return "mypageList.jsp";
	}
	private String goFollowPage(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		MyPageController controller = MyPageController.getInstance();
		MyPageViewBean myPageViewBean = controller.getMyPageInfoViewDB(title);
		request.setAttribute("myPageInfo",myPageViewBean);
		request.setAttribute("follow", true);
		return "showMyPagePost";
	}
	private String cancelFollow(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
		String id = userPublicBean.getId();
		
		String title = request.getParameter("title");
		MyPageController controller = MyPageController.getInstance();
		controller.cancelFollowingDB(title, id);
		
		MyPageViewBean myPageViewBean = controller.getMyPageInfoViewDB(title);
		request.setAttribute("myPageInfo",myPageViewBean);
		request.setAttribute("follow", false);

		return "showMyPagePost";
	}
	private String goPage(HttpServletRequest request, HttpServletResponse response) {
		
		String title = request.getParameter("title");
		System.out.println(title);
		
		MyPageController controller = MyPageController.getInstance();
		MyPageViewBean myPageViewBean = controller.getMyPageInfoViewDB(title);
		request.setAttribute("myPageInfo",myPageViewBean);
		request.setAttribute("follow", request.getParameter("follow"));
		
		return "showMyPagePost";
	}
	private String followPage(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		System.out.println("팔로우당"+title);
		HttpSession session = request.getSession();
		UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
		String id = userPublicBean.getId();
		
		MyPageController controller = MyPageController.getInstance();
		controller.followMyPageDB(title, id);
		MyPageViewBean myPageViewBean = controller.getMyPageInfoViewDB(title);
		
		AlarmController alarmController = AlarmController.getInstance();
		alarmController.addMyPageFollowAlarmDB(myPageViewBean.getMasterId(), id, title);	//알람추가	
		
		request.setAttribute("myPageInfo",myPageViewBean);
		request.setAttribute("follow", true);
		request.setAttribute("id", id);
		//request.setAttribute("userPublicBean", UserPublicBean);
		
		return "showMyPagePost";
	}
	
	private String cancelListFollow(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
		String id = userPublicBean.getId();
		
		String title = request.getParameter("title");
		MyPageController controller = MyPageController.getInstance();
		controller.cancelFollowingDB(title, id);
		
		List<MyPageViewBean> blist = controller.getMyPageInfoViewById(id);	//내가 만든 마이페이지 받아오기
		List<FollowingMyPageViewBean> flist = controller.getFollowingMyPageDB(id);	//팔로잉중인 마이페이지 가져오기
		
		request.setAttribute("followList", flist);
		request.setAttribute("makeList", blist);
		
		//request.setAttribute("userPublicBean", UserPublicBean);

		return "mypageList.jsp";
	}
}
