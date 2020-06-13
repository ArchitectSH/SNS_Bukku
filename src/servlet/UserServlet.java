package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import viewHelperBean.FollowingMyPageViewBean;
import viewHelperBean.FriendInfoViewBean;
import viewHelperBean.MyPagePublicBean;
import viewHelperBean.UserBean;
import viewHelperBean.UserPublicBean;
import applicationController.AlarmController;
import applicationController.MyPageController;
import applicationController.UserController;
import form.UserInfoForm;
import form.UserProfileForm;
import form.UserSearchForm;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(name = "UserServlet",
urlPatterns = {"/UserServlet", "/join","/login","/searchMember" ,"/search",
		"/friendList","/addFriend","/responseFriend" ,"/friendManage","/cancelFriend",
		"/refuseFriend","/acceptFriend","/blockUser","/removeFriend","/cancelBlockUser",
		"/searchTotal","/logout",
		"/myProfile","/profileModify","/withdraw","/deacti","/modifyUserInfo","/acti",
		"/accountManage","/cancelBlock"
		
		})	//goFriend.do <Ȳ �߰� -> ģ������ ���°�>
/**
 * 
 * @author �念��
 *
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String dispatchUrl = null;
		String uri = request.getRequestURI();

		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		System.out.println("User/GET �Դϴ�.");
		System.out.println("��ü ���� ���°ž�: "+action);
		//ģ����Ϻ���
		if (action.equals("friendList")) {  showFriendList(request,response);}
			
		//ģ����û ���� �Ǵ� ���� 
		else if(action.equals("acceptFriend")){responseFriend(request,response,true);}
		//ģ����û ���� �Ǵ� ���� 
		else if(action.equals("refuseFriend")){responseFriend(request,response,false);}
		// �������
		else if(action.equals("cancelFriend")){cancelFriend(request,response);}
		//ģ����û�����Ͱ� ��û�����Ѱ� �����ٶ� 
		else if(action.equals("friendManage")){friendManage(request,response);}
		//ȸ������
		else if(action.equals("blockUser")){blockUser(request,response);}
		//ģ������
		else if(action.equals("removeFriend")){removeFriend(request,response);}
		//���հ˻�
		else if(action.equals("searchTotal")){searchTotal(request,response);}
		//���հ˻�
		else if(action.equals("logout")){logout(request,response);}
		//ȸ��ã�� ȭ������ ���� �κ�
		else if(action.equals("search")){request.setAttribute("first",new Boolean(true));
		dispatchUrl = "/search.jsp"; go(request,response,dispatchUrl);}
		//�����ʼ���(����ȭ�� ����)
		else if(action.equals("profileModify")){profileModifyShow(request,response);}
		//�������� ����
		else if(action.equals("myProfile")){myProfile(request,response);}
		//���������� ����
		else if(action.equals("accountManage")){dispatchUrl = "/accountManage.jsp";
		go(request,response,dispatchUrl);}
		else if(action.equals("cancelBlockUser")){cancelBlockUser(request,response);}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			String uri = request.getRequestURI();

			int lastIndex = uri.lastIndexOf("/");
			String action = uri.substring(lastIndex + 1);
			System.out.println("User/Post �Դϴ�.");
			System.out.println("���ο���"+action);
			
			
			if (action.equals("join")) {  join(request,response);	}
			else if(action.equals("login")){ login(request,response);}
			else if(action.equals("searchMember")){ searchMember(request,response);}
			
			else if(action.equals("friendManage")){friendManage(request,response);}
			//ģ���߰�
			else if(action.equals("addFriend")){ addFriend(request,response);}
			//ģ������
			else if(action.equals("removeFriend")){removeFriend(request,response);}
			//ȸ������
			else if(action.equals("blockUser")){blockUser(request,response);}
			//��������
			else if(action.equals("cancelBlockUser")){cancelBlockUser(request,response);}
			//���հ˻�
			else if(action.equals("searchTotal")){searchTotal(request,response);}
			//�����ʼ���(��������)
			else if(action.equals("profileModify")){profileModify(request,response);}
			
			//ȸ�� Ż��
			else if(action.equals("withdraw")){ withdraw(request,response);}
			//ȸ������ ����
			else if(action.equals("modifyUserInfo")){modifyUserInfo(request,response);}
			//���� ��Ȱ��ȭ
			else if(action.equals("deacti")){deacti(request,response);}
			//���� Ȱ��ȭ
			else if(action.equals("acti")){acti(request,response);}
		
	}
	
	private void go(HttpServletRequest request,HttpServletResponse response,String dispatchUrl)	throws ServletException, IOException
	{
		if (dispatchUrl != null) {
			
			RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
			rd.forward(request, response);
		}
	}
	
	private void logout(HttpServletRequest request,HttpServletResponse response)	throws ServletException, IOException
	{
		String dispatchUrl = null;
		
		HttpSession session = request.getSession();
		session.invalidate();
		dispatchUrl = "/login.jsp";
		if (dispatchUrl != null) {
			RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
			rd.forward(request, response);
		}
	}

	private void join(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*GetProductsAction getProductsAction = (GetProductsAction) dependencyInjector
				.getObject(GetProductsAction.class);
		List<Product> products = getProductsAction.getProducts();
		request.setAttribute("products", products);*/
		String dispatchUrl = null;
		int gender = 0;
		UserInfoForm userInfoForm = new UserInfoForm();
		userInfoForm.setId(request.getParameter("id"));
		String year = request.getParameter("year");
		userInfoForm.setBirth(year.substring(year.length()-2)+request.getParameter("month")+request.getParameter("day"));
		userInfoForm.setEmail(request.getParameter("email")+"@"+request.getParameter("emailAddr"));
		
		userInfoForm.setGender(request.getParameter("gender"));
		userInfoForm.setName(request.getParameter("name"));
		userInfoForm.setPassword(request.getParameter("pwd"));
		userInfoForm.setPhoneNumber(request.getParameter("phoneNum1")+request.getParameter("phoneNum2")+request.getParameter("phoneNum3"));
		
		/*System.out.println(userInfoForm);*/
		UserController userController = UserController.getInstance();
		int joinCheck =userController.joinDB(userInfoForm);
		if(joinCheck==1){
			System.out.println("���Լ���");
		}else{
			System.out.println("���Խ���");
		}		
		dispatchUrl = "/login.jsp";
		if (dispatchUrl != null) {
			RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
			rd.forward(request, response);
		}
	
	}
	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dispatchUrl = null;
		String id = request.getParameter("id");
		String pw = request.getParameter("pwd");
		
		UserController userController = UserController.getInstance();
		UserPublicBean userPublicBean = userController.loginDB(id, pw);
		if(userPublicBean ==null){
			System.out.println("�α��ν���");
			dispatchUrl = "/login.jsp";
		}else{
			HttpSession session = request.getSession();
			//���ǿ� �α����� ȸ������ ����
			session.setAttribute("userPublicBean", userPublicBean);
			session.setMaxInactiveInterval(60*60);
			
			if(userController.checkDeactiDB(id)==true){
				dispatchUrl = "deactivate.jsp";
			}
			
			//���Ŀ� PostCommentServlet���� ����
			//30�� ���� ���Ƿ� home.jsp�� ���ϴ� ~~������ home �������� 
			else{
				dispatchUrl = "home";
			}
		}
		if (dispatchUrl != null) {
			RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
			rd.forward(request, response);
		}	
	}
	
	private void searchMember(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dispatchUrl = null;
		HttpSession session = request.getSession();
		//���ǿ��� ȸ������ ��������
		UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");

		UserSearchForm userSearchForm = new UserSearchForm();
		userSearchForm.setId(request.getParameter("id"));
		String year = request.getParameter("year");

		if(year.length()<2){
		}else{
			year = year.substring(year.length()-2);
		}
	
		userSearchForm.setBirth(year+request.getParameter("month")+request.getParameter("day"));
		userSearchForm.setEmail(request.getParameter("email")+request.getParameter("emailAddr"));
		String gender = request.getParameter("gender");
		if(gender==null){
			gender = "0";
		}
		userSearchForm.setGender(gender);

		userSearchForm.setName(request.getParameter("name"));
		userSearchForm.setPhoneNumber(request.getParameter("phoneNum1")+request.getParameter("phoneNum2")+request.getParameter("phoneNum3"));
		userSearchForm.setLocation(request.getParameter("location"));
		userSearchForm.setSchool(request.getParameter("school"));
		
		UserController userController = UserController.getInstance();
		//���� ã�� ����Ʈ ������
		List<UserPublicBean> userPublicBeans = userController.searchUserDB(userSearchForm);
		if(userPublicBeans!=null){  //�̰� �߰����ּ���

		
		//ģ������Ʈ ������
		List<FriendInfoViewBean> friendInfoViewBeans = userController.getFriendListDB(userPublicBean.getId());
	/*	
		if(userPublicBeans==null){
			System.out.println("�˻��������");
		}else{
			System.out.println("�˻� �Ϸ�");
			System.out.println(userPublicBeans);
		}
		if(friendInfoViewBeans==null){
			System.out.println("ģ������");
		}else{
			System.out.println("ģ�� �˻� �Ϸ�");
			System.out.println(friendInfoViewBeans);
		}*/
		//ģ����û �������ִ��� Ȯ���ؾ�(���� ��û�� ȸ����)		
		List<UserPublicBean> requestList = userController.getRequestFriendsDB(userPublicBean.getId());
	/*	System.out.println("ģ����û���:"+requestList);
		*/
		//���� ������ ȸ���� �ִ��� Ȯ���ؾ�(����ȸ����ϵ�)
	//	List<UserPublicBean> blocking = userController.searchBlockingUser(userPublicBean.getId()); // �����κ���
		//System.out.println("����ȸ����� :"+ blocking);
		List<UserPublicBean> blocking = userController.searchBlockingUserDB(userPublicBean.getId()); //DB�κ���
		
		//������ �� �����ϸ� �˻� â���� ������ �ʾƾ�
	//	List<UserPublicBean> blocked = userController.searchBlockedUser(userPublicBean.getId()); // �����κ���
	/*	System.out.println("�� ����ȸ����� :"+ blocked);*/
		List<UserPublicBean> blocked = userController.searchBlockedUserDB(userPublicBean.getId()); //DB�κ���
		
		/*System.out.println("��������:"+blocking);		
		System.out.println("������:"+blocked);*/
		
		request.setAttribute("blocking",blocking);
		request.setAttribute("blocked",blocked);
		request.setAttribute("requestList",requestList);		
		request.setAttribute("friendInfoViewBeans",friendInfoViewBeans);
		request.setAttribute("userPublicBeans",userPublicBeans);
		request.setAttribute("first",new Boolean(false));		
		}
		dispatchUrl = "/search.jsp";
		if (dispatchUrl != null) {
			RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
			rd.forward(request, response);
		}
	}
	private void showFriendList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dispatchUrl = null;
		HttpSession session = request.getSession();
		//���ǿ��� ȸ������ ��������
		UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
	
		
		UserController userController = UserController.getInstance();
	
		List<FriendInfoViewBean> friendInfoViewBeans = userController.getFriendListDB(userPublicBean.getId());
	
		/*if(friendInfoViewBeans==null){
			System.out.println("ģ������");
		}else{
			System.out.println("ģ�� �˻� �Ϸ�");
			/*System.out.println(friendInfoViewBeans);
		}*/
		request.setAttribute("friendInfoViewBeans",friendInfoViewBeans);
		
		
		UserBean userBean = userController.getUserProfileDB(userPublicBean.getId());
		request.setAttribute("userBean",userBean);
		
		dispatchUrl = "/friendList.jsp";
		if (dispatchUrl != null) {
			RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
			rd.forward(request, response);
		}
	}
	
	private void addFriend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		//���ǿ��� ȸ������ ��������
		UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
		String userId = request.getParameter("userId");
	
		System.out.println("ģ����û���̵�: " +userId);
		

		UserController userController = UserController.getInstance();		
		int result = userController.addFriendDB(userPublicBean.getId(), userId);
	
		
		//ģ���߰��� �˸�
		AlarmController alarmController = AlarmController.getInstance();		
		int result2 = alarmController.addFriendRequestAlarmDB(userId, userPublicBean.getId());
	/*	
		System.out.println("�˸���ȣ:"+result2);
		*/
	}
	//ģ����û�����Ͱ� ��û�����Ѱ� �����ٶ� 
	private void friendManage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String dispatchUrl = null;
		HttpSession session = request.getSession();
		//���ǿ��� ȸ������ ��������
		UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
	

		UserController userController = UserController.getInstance();
		
		//ģ����û ���������ִ��� (���� ��û���� ȸ����)
	
		List<UserPublicBean> receiveList = userController.getReceiveFriendsDB(userPublicBean.getId());

		
		//ģ����û �������ִ��� (���� ��û�� ȸ����)		
		List<UserPublicBean> requestList = userController.getRequestFriendsDB(userPublicBean.getId());
	

		
		request.setAttribute("receiveList",receiveList);
		request.setAttribute("requestList",requestList);		
		
				
		dispatchUrl = "/friendManage.jsp";
		if (dispatchUrl != null) {
			RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
			rd.forward(request, response);
		}
	}
	
	//ģ����û �޾Ƽ� �����Ǵ� �����Ҷ�
	private void responseFriend(HttpServletRequest request, HttpServletResponse response,boolean answer)
			throws ServletException, IOException {
		String dispatchUrl = null;
	
		HttpSession session = request.getSession();
		//���ǿ��� ȸ������ ��������
		UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
		
		String requestUserId = request.getParameter("id");
		UserController userController = UserController.getInstance();
		int result = userController.responseFriendDB(userPublicBean.getId(),requestUserId, answer);
	/*	System.out.println("���伺������:"+result);*/
		if(answer==true){ // ������ �˸� add 
			AlarmController alarmController = AlarmController.getInstance();		
			int result2 = alarmController.addFriendAcceptAlarmDB(requestUserId, userPublicBean.getId());
			
		}
		
		dispatchUrl = "/friendManage";
		if (dispatchUrl != null) {
			RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
			rd.forward(request, response);
		}
	}
	
	private void cancelFriend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String dispatchUrl = null;
		HttpSession session = request.getSession();
		//���ǿ��� ȸ������ ��������
		UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
		UserController userController = UserController.getInstance();
		
		//����� �������� ��û�� �� ���̵�
		String receiveUserId = request.getParameter("requestUserId");
		
		int result = userController.responseFriendDB(receiveUserId,userPublicBean.getId(), false);
			
		dispatchUrl = "/friendManage";
		if (dispatchUrl != null) {
			RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
			rd.forward(request, response);
		}
	}
	
	
	
	
	//ȸ������
	private void blockUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
	
		String dispatchUrl = null;
		HttpSession session = request.getSession();
		//���ǿ��� ȸ������ ��������
		UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
		UserController userController = UserController.getInstance();
		
		//����� �������� ��û�� �� ���̵�	
		String receiveId = request.getParameter("userId");
	
		Integer result = userController.blockDB(userPublicBean.getId(), receiveId); // �����ϱ�
		dispatchUrl = "home";
		RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
		rd.forward(request, response);
	}
	

	//��������
	private void cancelBlockUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
	
		String dispatchUrl = null;
		HttpSession session = request.getSession();
		//���ǿ��� ȸ������ ��������
		UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
		UserController userController = UserController.getInstance();
		
		//����� �������� ��û�� �� ���̵�	
		String receiveId = request.getParameter("userId");
		int result = userController.cancelBlockDB(userPublicBean.getId(), receiveId);
		//Integer result = userController.blockDB(userPublicBean.getId(), receiveId); // �����ϱ�

	}
	//ģ������
	private void removeFriend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
			
		String dispatchUrl = null;
		HttpSession session = request.getSession();
		//���ǿ��� ȸ������ ��������
		UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
		UserController userController = UserController.getInstance();
		
		//����� �������� ��û�� �� ���̵�
		String receiveUserId = request.getParameter("userId");
		/*System.out.println("ģ������ ���̵�:"+ receiveUserId);*/
		int result = userController.removeFriendDB(userPublicBean.getId(), receiveUserId);

	}
	//���հ˻� 
	private void searchTotal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dispatchUrl = null;
		HttpSession session = request.getSession();
		//���ǿ��� ȸ������ ��������
		UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
		String keyword = request.getParameter("keyword");
		
		/* �������� */
	
		UserController userController = UserController.getInstance();
		//ģ����� 
		List<FriendInfoViewBean> friendInfoViewBeans = userController.getFriendListDB(userPublicBean.getId());
		
		//ģ����û �������ִ��� Ȯ���ؾ�(���� ��û�� ȸ����)		
		List<UserPublicBean> requestList = userController.getRequestFriendsDB(userPublicBean.getId());
	/*	System.out.println("ģ����û���:"+requestList);
		*/
		//���� ������ ȸ���� �ִ��� Ȯ���ؾ�(����ȸ����ϵ�)
	//	List<UserPublicBean> blocking = userController.searchBlockingUser(userPublicBean.getId()); // �����κ���
		//System.out.println("����ȸ����� :"+ blocking);
		List<UserPublicBean> blocking = userController.searchBlockingUserDB(userPublicBean.getId()); //DB�κ���
		
		//������ �� �����ϸ� �˻� â���� ������ �ʾƾ�
	//	List<UserPublicBean> blocked = userController.searchBlockedUser(userPublicBean.getId()); // �����κ���
	/*	System.out.println("�� ����ȸ����� :"+ blocked);*/
		List<UserPublicBean> blocked = userController.searchBlockedUserDB(userPublicBean.getId()); //DB�κ���
		
		//�̸� �˻� ���
		List<UserPublicBean> userSearchResults = userController.searchUserByNameDB(keyword);	
		
		List<UserPublicBean> friendSearch = new ArrayList<UserPublicBean>(); //�˻������ ģ����
		List<UserPublicBean> onlyUserSearch = new ArrayList<UserPublicBean>(); //�˻������ ģ���ƴ�ȸ����
			
		boolean flag = true;
		if(userSearchResults!=null){
			for(UserPublicBean resultBean:userSearchResults){
				flag = true;
				for(FriendInfoViewBean friendInfoViewBean:friendInfoViewBeans){
					if(resultBean.getId().equals(friendInfoViewBean.getFriendId())){
						friendSearch.add(resultBean);
						flag=false;
						break;
					}
				}
				if(flag==true){
					onlyUserSearch.add(resultBean);
				}			
			}
		}
	/*	System.out.println(friendSearch);
		System.out.println(onlyUserSearch);
		System.out.println("�����"+blocked);
		System.out.println("���ŷ"+blocking);*/
		request.setAttribute("blocking",blocking);
		request.setAttribute("blocked",blocked);
		request.setAttribute("requestList",requestList);
		//request.setAttribute("friendInfoViewBeans",friendInfoViewBeans);
		//request.setAttribute("userSearchResults",userSearchResults);
		request.setAttribute("friendSearch",friendSearch); //�˻������ ģ����
		request.setAttribute("onlyUserSearch",onlyUserSearch); //�˻������ ģ���ƴ�ȸ����
		System.out.println(friendSearch.isEmpty());
		
		
		/*���������� ����*/
		MyPageController myPageController = MyPageController.getInstance();
		List<MyPagePublicBean> myPages= myPageController.searchMyPageDB(keyword); //Ÿ��Ʋ �˻�(LIKE)
		List<FollowingMyPageViewBean> following=  myPageController.getFollowingMyPageDB(userPublicBean.getId()); //�ȷ����� ���������� 
		
		
		System.out.println("�ȷ���"+following);
		List<MyPagePublicBean> followingSearch = new ArrayList<MyPagePublicBean>(); //�˻������ �ȷ����Ѱ͸�
		List<MyPagePublicBean> onlyMypageSearch = new ArrayList<MyPagePublicBean>(); //�˻������ �ȷ��� ���Ѱ͸�
		boolean flag2 = true;
		if(followingSearch!=null){
			for(MyPagePublicBean resultBean:myPages){
				flag2 = true;
				for(FollowingMyPageViewBean foll:following){
					if(resultBean.getTitle().equals(foll.getTitle())){
						followingSearch.add(resultBean);
						flag2=false;
						break;
					}
				}
				if(flag2==true){
					onlyMypageSearch.add(resultBean);
				}			
			}
		}
		
	
		
		request.setAttribute("followingSearch",followingSearch); //�˻������ �ȷ����Ѱ͸�
		request.setAttribute("onlyMypageSearch",onlyMypageSearch); //�˻������ �ȷ��� ���Ѱ͸�
		//System.out.println(followingSearch);
		//System.out.println(onlyMypageSearch);

		dispatchUrl = "/totalSearch.jsp";
		if (dispatchUrl != null){
			RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
			rd.forward(request, response);
		}
	}
	//������ ���� //2�� 1�� �߰�
		private void profileModify(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String dispatchUrl = null;
			HttpSession session = request.getSession();
			//���ǿ��� ȸ������ ��������
			UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
			UserController userController = UserController.getInstance();
			String location = request.getParameter("location");
			String school = request.getParameter("school");
			if(location.equals("area1")){
				location = "�����";
			}else if(location.equals("area2")){
				location = "��⵵";
			}else if(location.equals("area3")){
				location = "�԰浵";
			}else if(location.equals("area4")){
				location = "��ȵ�";
			}else if(location.equals("area5")){
				location = "������";
			}else if(location.equals("area6")){
				location = "Ȳ�ص�";
			}else if(location.equals("area7")){
				location = "��û��";
			}else if(location.equals("area8")){
				location = "���";
			}else if(location.equals("area9")){
				location = "����";
			}else if(location.equals("area10")){
				location = "��õ��";
			}else if(location.equals("area11")){
				location = "���ֽ�";
			}
			
			if(school.equals("banghakPri")){
				school = "�����ʵ��б�";
			}else if(school.equals("seonlinHigh")){
				school = "�������ͳݰ���б�";
			}else if(school.equals("soongsilUni")){
				school = "���Ǵ��б�";
			}else if(school.equals("shamyookUni")){
				school = "�������б�";
			}else if(school.equals("sechoHigh")){
				school = "���ʰ���б�";
			}else if(school.equals("sechoMiddle")){
				school = "�������б�";
			}else if(school.equals("geongmoonHigh")){
				school = "�湮����б�";
			}

			
			UserProfileForm userProfileForm = new UserProfileForm();
			userProfileForm.setLocation(location);
			userProfileForm.setProfileImg("image/profileImg/"+request.getParameter("file"));
			userProfileForm.setSchool(school);
			System.out.println("������ ����:"+ userProfileForm);
			
			int result = userController.modifyProfileDB(userPublicBean.getId(), userProfileForm);
			UserBean userBean = userController.getUserProfileDB(userPublicBean.getId());
			UserPublicBean newPublicBean = new UserPublicBean();
			
			newPublicBean.setId(userBean.getId());
			newPublicBean.setName(userBean.getName());
			newPublicBean.setProfileImg(userBean.getProfileImg());
			session.setAttribute("userPublicBean",newPublicBean);
			request.setAttribute("userBean",userBean);
			dispatchUrl = "/profileShow.jsp";
			if (dispatchUrl != null){
				RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
				rd.forward(request, response);
			}
			
		}
		//2�� 1�� ���� �߰��� �޼ҵ�
		private void profileModifyShow(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String dispatchUrl = null;
			HttpSession session = request.getSession();
			//���ǿ��� ȸ������ ��������
			UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
			
			UserController userController = UserController.getInstance();
			UserBean userBean = userController.getUserProfileDB(userPublicBean.getId());
		
			request.setAttribute("userBean",userBean);
			dispatchUrl = "profileModify.jsp";
			if (dispatchUrl != null) {
				RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
				rd.forward(request, response);
			}
			
		}
		
		//2�� 1�� ���� �߰��� �޼ҵ� (�� ���� ���� ������)
		private void myProfile(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String dispatchUrl = null;
			
			//���ǿ��� ȸ������ ��������
			HttpSession session = request.getSession();
			UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
			UserController userController = UserController.getInstance();
			if(request.getParameter("id")!=null&&!request.getParameter("id").equals(userPublicBean.getId())){
				FriendInfoViewBean fvb = userController.getFriendDB(userPublicBean.getId(), request.getParameter("id"));
				if(fvb!=null){ //ģ���̸�
					request.setAttribute("friendInfo", fvb);
					RequestDispatcher rd = request.getRequestDispatcher("profileShowFriend.jsp");
					rd.forward(request, response);
					return ;
				}
			}
			
			
			UserBean userBean = userController.getUserProfileDB(userPublicBean.getId());
			
			request.setAttribute("userBean",userBean);
			dispatchUrl = "profileShow.jsp";
			if (dispatchUrl != null) {
				RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
				rd.forward(request, response);
			}
			
		}
		
		//2�� 1�� // ȸ������ ����
		private void modifyUserInfo(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String dispatchUrl = null;
			HttpSession session = request.getSession();
			//���ǿ��� ȸ������ ��������
			UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
			
			UserController userController = UserController.getInstance();
			String password = request.getParameter("pwd");
			String newPassword = request.getParameter("pwd2");
			String genderS = request.getParameter("gender");
			String email = request.getParameter("email")+ request.getParameter("emailAddr");
			String phoneNumber = request.getParameter("phoneNum1")+request.getParameter("phoneNum2")+request.getParameter("phoneNum3");
			int gender =1;
			if(genderS!=null){
				if(genderS.equals("woman")){
					gender = 2;
				}else if(genderS.equals("man")){
					gender = 1;
				}
			}
			int result = userController.modifyInfoDB(userPublicBean.getId(), password, newPassword, gender, email, phoneNumber);
			System.out.println("ȸ����������"+result);
			
		
			//�������� ��߰ڴ�...? ��
			dispatchUrl = "/accountManage.jsp";
			if (dispatchUrl != null) {
				RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
				rd.forward(request, response);
			}
			
			
		}
		//2�� 1�� // ��Ȱ��ȭ 
			private void deacti(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				String dispatchUrl = null;
				HttpSession session = request.getSession();
				//���ǿ��� ȸ������ ��������
				UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
				
				UserController userController = UserController.getInstance();
			
				int result = userController.deactiDB(userPublicBean.getId());
				
				
			
				//�������� ��߰ڴ�...? ��
				dispatchUrl = "login.jsp";
				if (dispatchUrl != null) {
					RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
					rd.forward(request, response);
				}
				
				
			}
			
			//Ȱ��ȭ (������ �ȸ���)
			private void acti(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				String dispatchUrl = null;
				HttpSession session = request.getSession();
				//���ǿ��� ȸ������ ��������
				UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
				
				UserController userController = UserController.getInstance();
				int result = userController.actiDB(userPublicBean.getId());
				
	//home.jsp ���� �������� ������ (���ս�)			
				dispatchUrl = "home"; 
				if (dispatchUrl != null) {
					RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
					rd.forward(request, response);
				}
			}
			
			//ȸ�� Ż��
			private void withdraw(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				String dispatchUrl = null;
				HttpSession session = request.getSession();
				//���ǿ��� ȸ������ ��������
				UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
				
				UserController userController = UserController.getInstance();
				int result = userController.withdrawDB(userPublicBean.getId(),request.getParameter("pwd"));
				
			
				//�������� �ʿ�
				dispatchUrl = "/login.jsp"; 
				if (dispatchUrl != null) {
					RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
					rd.forward(request, response);
				}
			}
	//Ȳ�߰�
	private void goFriend(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dispatchUrl = null;
		//HttpSession session = request.getSession();
		//���ǿ��� ȸ������ ��������
		//UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
		String id = "id2";	//����ó�� �Ϲ� ġ������
		
		String friendId = request.getParameter("userId");	//������ ã�ư� ģ�� ���̵�
		System.out.println("ģ����� �� ���� : "+friendId);
		if(friendId == null){	//���̸� �˶��ʿ��� ��û ������!! senderId�� ��������
			friendId = request.getParameter("senderId");	//�˶����� ģ������ �� ��
			System.out.println("�˸���� ���� : "+friendId);
		}
		
		UserController controller = UserController.getInstance();
		FriendInfoViewBean bean = controller.getFriendDB(id, friendId);
		
		System.out.println("ģ�� ���� : "+bean);
		request.setAttribute("friendInfo", bean);
		
		dispatchUrl = "/profileShowFriend.jsp";
		if (dispatchUrl != null){
			RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
			rd.forward(request, response);
		}
	}
}
