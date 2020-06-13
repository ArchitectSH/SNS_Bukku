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
 * ���������� ������ ��ɵ��� �����ϴ� �����̴�.
 * ���������� �����, ��������, ��� ���� ����� �����ϴ�.
 * @author ���
 *
 */
@WebServlet({ "/page_servlet.do", "/page_main.do", "/make_page.do", "/set_page.do", "/setting_intro_page.do",
	"/remove_page.do", "/invite_page.do", "/inviting_friend.do", "/follow_member.do",
	"/myPage_Accept_Invite.do", "/myPage_Accept.do", "/myPage_remove_Invite.do", "/myPage_list.do",
	"/page_go.do", "/follow_page_go.do", "/cancel_follow.do","/myPage_follow.do","/cancel_list_follow.do"})
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * ȭ������ ���� ���ƿ� �����Ͱ� get����� �� ���ȴ�.
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
	 * ȭ������ ���� ���ƿ� �����Ͱ� post����� �� ���ȴ�.
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
//���������� �� ����
	private String mainPage(HttpServletRequest request, HttpServletResponse response){
		String title = request.getParameter("title");
		MyPageController controller = MyPageController.getInstance();
		MyPageViewBean myPageViewBean = controller.getMyPageInfoViewDB(title);
		request.setAttribute("myPageInfo",myPageViewBean);
		return "showMyPagePost";
	}
	
	/**
	 * �������� ������ �� �Ҹ��� �޼ҵ��, ���������� �̸�, �Ұ���, �̹����� ����� �ԷµǾ������� Ȯ���ϰ�
	 * ���������� ������ ���´�.
	 * @param request ù��° �������ڷ� ��û��ü�� �޴´�.
	 * @param response �ι�° �������ڷ� ���䰴ü�� �޴´�.
	 * @return String �������� ��ȯ�� url�� �����Ѵ�.
	 * @throws ServletException 
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	private String makePage(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException, ServletException{
		HttpSession session = request.getSession();
		UserPublicBean user = (UserPublicBean)session.getAttribute("userPublicBean");
		//��
		MyPageForm form = new MyPageForm();
		form.setTitle(request.getParameter("myPageTitle"));
		form.setImg("image/mypage/"+request.getParameter("file"));
		form.setMyPageIntroduction(request.getParameter("intro"));
		
		//System.out.println(form);
		
		MyPageValidator myPageValidator = new MyPageValidator();
		List<String> errors = myPageValidator.validate(form);
		System.out.println(form);
		if(errors.isEmpty()){
			//�𵨻���
			//MyPage myPage = new MyPage(form.getMyPageIntroduction(), "id4",
			//		new MyPagePublicInfo(form.getTitle(), form.getImg()));
			MyPageController controller = MyPageController.getInstance();
			int check = controller.makeMyPageDB(form, user.getId());	//db�� �߰�
			check = controller.makeMyPage(user.getId(), form);	//�𵨿� �߰�
			
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
	 * ������������ ���� ȭ���� �����Ѵ�.
	 * ���������� ���������� �Ұ���, �̹��� ������ �����ϸ�, ���������� ��⵵ �����ϴ�.
	 * @param request ù��° �������ڷ� ��û��ü�� �޴´�.
	 * @param response �ι�° �������ڷ� ���䰴ü�� �޴´�.
	 * @return String �������� ��ȯ�� url�� �����Ѵ�.
	 */
	private String settingMyPage(HttpServletRequest request, HttpServletResponse response){
		String title = request.getParameter("title");
		MyPageController controller = MyPageController.getInstance();
		MyPageViewBean myPageViewBean = controller.getMyPageInfoViewDB(title);
		request.setAttribute("myPageInfo",myPageViewBean);
		return "myPageSetting.jsp";
	}
	/**
	 * �������� �Ұ����� ������ �� ����ȴ�.
	 * @param request ù��° �������ڷ� ��û��ü�� �޴´�.
	 * @param response �ι�° �������ڷ� ���䰴ü�� �޴´�.
	 * @return String �������� ��ȯ�� url�� �����Ѵ�.
	 */
	private String settingIntro(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String title = request.getParameter("hiddenTitle");
		String intro = request.getParameter("changeIntroText");
		MyPageController controller = MyPageController.getInstance();
		controller.updateMyPageIntroDB(intro, title);	//������
		controller.updateMyPageIntro(title, intro);	//�𵨼���
		
		MyPageViewBean myPageViewBean = controller.getMyPageInfoViewDB(title);
		request.setAttribute("myPageInfo",myPageViewBean);
		return "showMyPagePost";
	}
	private String removePage(HttpServletRequest request, HttpServletResponse response) {
		String pw = request.getParameter("passwordInput");
		String pwCheck = request.getParameter("passwordCheck");
		
		System.out.println(pw+" / "+pwCheck+" / "+request.getParameter("hiddenTitle"));
		
		//���������ͷο����˻��ؾߴ�
		
		MyPageController controller = MyPageController.getInstance();
		controller.removeMyPageDB(request.getParameter("hiddenTitle"));	//��񿡼� ����
		controller.removeMyPage(request.getParameter("hiddenTitle"));	//�𵨿��� ����
		
		return "home";
	}
	private String invitePage(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String id = request.getParameter("masterId");
		MyPageController controller = MyPageController.getInstance();
		System.out.println(id);
		MyPageViewBean myPageViewBean = controller.getMyPageInfoViewDB(title);
		//�ϴ��� ��Ʈ�ѷ� �Ȱ�ġ�� db���� ģ���ٷ� �޾ƿ�
		UserDependencyInjector userDependencyInjector = new UserDependencyInjector(DataSourceManager.getInstance().getDataSource());
		FriendInfoViewAction friendInfoViewAction = (FriendInfoViewAction)userDependencyInjector.getObject(FriendInfoViewAction.class);
		List<FriendInfoViewDTO> fiv = friendInfoViewAction.getFriendInfoViewByUserId(id);
		
		List<UserPublicBean> friends = controller.checkInvite(title,fiv);	//�ʴ��� �� �ִ� ģ���� �޾ƿ�
	
		List<UserPublicBean> inviteFriends = controller.getMyPageUserByKindTitle(1, title);

		request.setAttribute("myPageInfo",myPageViewBean);
		request.setAttribute("inviteList", inviteFriends);
		request.setAttribute("list", friends);	//�ʴ�ȵ� ģ����� ������
		return "myPageInvite.jsp";
	}
	private String invitingFriend(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String id = request.getParameter("id");
		String masterId = request.getParameter("masterId");//�������� �ؾ��� �κ�
		System.out.println(masterId);
		MyPageController controller = MyPageController.getInstance();
		controller.inviteMyPage(id, title);
		
		MyPageViewBean myPageViewBean = controller.getMyPageInfoViewDB(title);
		//�ϴ��� ��Ʈ�ѷ� �Ȱ�ġ�� db���� ģ���ٷ� �޾ƿ�
		UserDependencyInjector userDependencyInjector = new UserDependencyInjector(DataSourceManager.getInstance().getDataSource());
		FriendInfoViewAction friendInfoViewAction = (FriendInfoViewAction)userDependencyInjector.getObject(FriendInfoViewAction.class);
		List<FriendInfoViewDTO> fiv = friendInfoViewAction.getFriendInfoViewByUserId(((UserPublicBean)request.getSession().getAttribute("userPublicBean")).getId());
		
		List<UserPublicBean> friends = controller.checkInvite(title,fiv);	//�ʴ��� �� �ִ� ģ���� �޾ƿ�
	
		List<UserPublicBean> inviteFriends = controller.getMyPageUserByKindTitle(1, title);
		
		//�˶�������
		AlarmController alarmController = AlarmController.getInstance();
		alarmController.addMyPageInviteAlarmDB(id, myPageViewBean.getMasterId(), title);
				
		
		
		request.setAttribute("myPageInfo",myPageViewBean);
		request.setAttribute("inviteList", inviteFriends);
		request.setAttribute("list", friends);	//�ʴ�ȵ� ģ����� ������
		return "myPageInvite.jsp";
	}

	private String followMember(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		System.out.println(title);
		MyPageController controller = MyPageController.getInstance();
		
		MyPageViewBean myPageViewBean = controller.getMyPageInfoViewDB(title);
		
		List<UserPublicBean> list = controller.getMyPageFollowingByTitle(title);
		
		request.setAttribute("myPageInfo",myPageViewBean);
		request.setAttribute("list", list);	//�ȷ������� ������
		return "mypageFollower.jsp";
	}

//�ȷο�, ���ȷο� ����
	private String mypageInvited(HttpServletRequest request, HttpServletResponse response) {
		String userId=((UserPublicBean)request.getSession().getAttribute("userPublicBean")).getId();	//����ó��
		
		//�ʴ���� ���������� ��� �޾ƿ���
		MyPageController controller = MyPageController.getInstance();
		List<MyPagePublicBean> list = controller.getApprovalPageViewById(userId);
		
		request.setAttribute("list", list);
		request.setAttribute("id", userId);
		return "myPageAcceptInvite.jsp";
	}
	private String acceptInviteMyPage(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		System.out.println("�³��̴�"+title);
		String id =  ((UserPublicBean)request.getSession().getAttribute("userPublicBean")).getId(); //����ó��
		
		MyPageController controller = MyPageController.getInstance();
		controller.responseMyPageDB(title, id, true);
		MyPageViewBean myPageViewBean = controller.getMyPageInfoViewDB(title);
		
		AlarmController alarmController = AlarmController.getInstance();
		alarmController.addMyPageFollowAlarmDB(myPageViewBean.getMasterId(), id, title);	//�˶��߰�	
		
		//�ʴ���� ���������� ��� �޾ƿ���
		List<MyPagePublicBean> list = controller.getApprovalPageViewById(id);
				
		request.setAttribute("list", list);
		request.setAttribute("id", id);
		
		return "myPageAcceptInvite.jsp";
	}
	private String removeInviteMyPage(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		System.out.println("�����̴�"+title);
		String id =  ((UserPublicBean)request.getSession().getAttribute("userPublicBean")).getId();  //����ó��
		
		MyPageController controller = MyPageController.getInstance();
		controller.responseMyPageDB(title, id, false);
		
		//�ʴ���� ���������� ��� �޾ƿ���
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
		List<MyPageViewBean> blist = controller.getMyPageInfoViewById(id);	//���� ���� ���������� �޾ƿ���
		List<FollowingMyPageViewBean> flist = controller.getFollowingMyPageDB(id);	//�ȷ������� ���������� ��������
		
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
		System.out.println("�ȷο��"+title);
		HttpSession session = request.getSession();
		UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
		String id = userPublicBean.getId();
		
		MyPageController controller = MyPageController.getInstance();
		controller.followMyPageDB(title, id);
		MyPageViewBean myPageViewBean = controller.getMyPageInfoViewDB(title);
		
		AlarmController alarmController = AlarmController.getInstance();
		alarmController.addMyPageFollowAlarmDB(myPageViewBean.getMasterId(), id, title);	//�˶��߰�	
		
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
		
		List<MyPageViewBean> blist = controller.getMyPageInfoViewById(id);	//���� ���� ���������� �޾ƿ���
		List<FollowingMyPageViewBean> flist = controller.getFollowingMyPageDB(id);	//�ȷ������� ���������� ��������
		
		request.setAttribute("followList", flist);
		request.setAttribute("makeList", blist);
		
		//request.setAttribute("userPublicBean", UserPublicBean);

		return "mypageList.jsp";
	}
}
