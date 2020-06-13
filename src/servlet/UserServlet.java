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
		
		})	//goFriend.do <황 추가 -> 친구정보 가는것>
/**
 * 
 * @author 장영은
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
		System.out.println("User/GET 입니다.");
		System.out.println("대체 뭘로 오는거야: "+action);
		//친구목록보기
		if (action.equals("friendList")) {  showFriendList(request,response);}
			
		//친구요청 수락 또는 거절 
		else if(action.equals("acceptFriend")){responseFriend(request,response,true);}
		//친구요청 수락 또는 거절 
		else if(action.equals("refuseFriend")){responseFriend(request,response,false);}
		// 수락취소
		else if(action.equals("cancelFriend")){cancelFriend(request,response);}
		//친구요청받은것과 요청전송한것 보여줄때 
		else if(action.equals("friendManage")){friendManage(request,response);}
		//회원차단
		else if(action.equals("blockUser")){blockUser(request,response);}
		//친구끊기
		else if(action.equals("removeFriend")){removeFriend(request,response);}
		//통합검색
		else if(action.equals("searchTotal")){searchTotal(request,response);}
		//통합검색
		else if(action.equals("logout")){logout(request,response);}
		//회원찾기 화면으로 가는 부분
		else if(action.equals("search")){request.setAttribute("first",new Boolean(true));
		dispatchUrl = "/search.jsp"; go(request,response,dispatchUrl);}
		//프로필설정(설정화면 보기)
		else if(action.equals("profileModify")){profileModifyShow(request,response);}
		//내프로필 보기
		else if(action.equals("myProfile")){myProfile(request,response);}
		//계정관리로 가기
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
			System.out.println("User/Post 입니다.");
			System.out.println("뭘로오냐"+action);
			
			
			if (action.equals("join")) {  join(request,response);	}
			else if(action.equals("login")){ login(request,response);}
			else if(action.equals("searchMember")){ searchMember(request,response);}
			
			else if(action.equals("friendManage")){friendManage(request,response);}
			//친구추가
			else if(action.equals("addFriend")){ addFriend(request,response);}
			//친구끊기
			else if(action.equals("removeFriend")){removeFriend(request,response);}
			//회원차단
			else if(action.equals("blockUser")){blockUser(request,response);}
			//차단해제
			else if(action.equals("cancelBlockUser")){cancelBlockUser(request,response);}
			//통합검색
			else if(action.equals("searchTotal")){searchTotal(request,response);}
			//프로필설정(실제설정)
			else if(action.equals("profileModify")){profileModify(request,response);}
			
			//회원 탈퇴
			else if(action.equals("withdraw")){ withdraw(request,response);}
			//회원정보 수정
			else if(action.equals("modifyUserInfo")){modifyUserInfo(request,response);}
			//계정 비활성화
			else if(action.equals("deacti")){deacti(request,response);}
			//계정 활성화
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
			System.out.println("가입성공");
		}else{
			System.out.println("가입실패");
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
			System.out.println("로그인실패");
			dispatchUrl = "/login.jsp";
		}else{
			HttpSession session = request.getSession();
			//세션에 로그인한 회원정보 저장
			session.setAttribute("userPublicBean", userPublicBean);
			session.setMaxInactiveInterval(60*60);
			
			if(userController.checkDeactiDB(id)==true){
				dispatchUrl = "deactivate.jsp";
			}
			
			//이후에 PostCommentServlet으로 전송
			//30일 현재 임의로 home.jsp로 갑니다 ~~원래는 home 서블릿으로 
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
		//세션에서 회원정보 가져오기
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
		//유저 찾기 리스트 얻어오기
		List<UserPublicBean> userPublicBeans = userController.searchUserDB(userSearchForm);
		if(userPublicBeans!=null){  //이거 추가해주세요

		
		//친구리스트 얻어오기
		List<FriendInfoViewBean> friendInfoViewBeans = userController.getFriendListDB(userPublicBean.getId());
	/*	
		if(userPublicBeans==null){
			System.out.println("검색결과없음");
		}else{
			System.out.println("검색 완료");
			System.out.println(userPublicBeans);
		}
		if(friendInfoViewBeans==null){
			System.out.println("친구없음");
		}else{
			System.out.println("친구 검색 완료");
			System.out.println(friendInfoViewBeans);
		}*/
		//친구요청 한적이있는지 확인해야(내가 요청한 회원들)		
		List<UserPublicBean> requestList = userController.getRequestFriendsDB(userPublicBean.getId());
	/*	System.out.println("친구요청목록:"+requestList);
		*/
		//내가 차단한 회원이 있는지 확인해야(차단회원목록들)
	//	List<UserPublicBean> blocking = userController.searchBlockingUser(userPublicBean.getId()); // 모델으로부터
		//System.out.println("차단회원목록 :"+ blocking);
		List<UserPublicBean> blocking = userController.searchBlockingUserDB(userPublicBean.getId()); //DB로부터
		
		//상대방이 날 차단하면 검색 창에서 보이지 않아야
	//	List<UserPublicBean> blocked = userController.searchBlockedUser(userPublicBean.getId()); // 모델으로부터
	/*	System.out.println("날 차단회원목록 :"+ blocked);*/
		List<UserPublicBean> blocked = userController.searchBlockedUserDB(userPublicBean.getId()); //DB로부터
		
		/*System.out.println("내가차단:"+blocking);		
		System.out.println("날차단:"+blocked);*/
		
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
		//세션에서 회원정보 가져오기
		UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
	
		
		UserController userController = UserController.getInstance();
	
		List<FriendInfoViewBean> friendInfoViewBeans = userController.getFriendListDB(userPublicBean.getId());
	
		/*if(friendInfoViewBeans==null){
			System.out.println("친구없음");
		}else{
			System.out.println("친구 검색 완료");
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
		//세션에서 회원정보 가져오기
		UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
		String userId = request.getParameter("userId");
	
		System.out.println("친구요청아이디: " +userId);
		

		UserController userController = UserController.getInstance();		
		int result = userController.addFriendDB(userPublicBean.getId(), userId);
	
		
		//친구추가시 알림
		AlarmController alarmController = AlarmController.getInstance();		
		int result2 = alarmController.addFriendRequestAlarmDB(userId, userPublicBean.getId());
	/*	
		System.out.println("알림번호:"+result2);
		*/
	}
	//친구요청받은것과 요청전송한것 보여줄때 
	private void friendManage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String dispatchUrl = null;
		HttpSession session = request.getSession();
		//세션에서 회원정보 가져오기
		UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
	

		UserController userController = UserController.getInstance();
		
		//친구요청 받은적이있는지 (내가 요청받은 회원들)
	
		List<UserPublicBean> receiveList = userController.getReceiveFriendsDB(userPublicBean.getId());

		
		//친구요청 한적이있는지 (내가 요청한 회원들)		
		List<UserPublicBean> requestList = userController.getRequestFriendsDB(userPublicBean.getId());
	

		
		request.setAttribute("receiveList",receiveList);
		request.setAttribute("requestList",requestList);		
		
				
		dispatchUrl = "/friendManage.jsp";
		if (dispatchUrl != null) {
			RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
			rd.forward(request, response);
		}
	}
	
	//친구요청 받아서 수락또는 거절할때
	private void responseFriend(HttpServletRequest request, HttpServletResponse response,boolean answer)
			throws ServletException, IOException {
		String dispatchUrl = null;
	
		HttpSession session = request.getSession();
		//세션에서 회원정보 가져오기
		UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
		
		String requestUserId = request.getParameter("id");
		UserController userController = UserController.getInstance();
		int result = userController.responseFriendDB(userPublicBean.getId(),requestUserId, answer);
	/*	System.out.println("응답성공여부:"+result);*/
		if(answer==true){ // 수락시 알림 add 
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
		//세션에서 회원정보 가져오기
		UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
		UserController userController = UserController.getInstance();
		
		//사용자 기준으로 요청을 한 아이디
		String receiveUserId = request.getParameter("requestUserId");
		
		int result = userController.responseFriendDB(receiveUserId,userPublicBean.getId(), false);
			
		dispatchUrl = "/friendManage";
		if (dispatchUrl != null) {
			RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
			rd.forward(request, response);
		}
	}
	
	
	
	
	//회원차단
	private void blockUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
	
		String dispatchUrl = null;
		HttpSession session = request.getSession();
		//세션에서 회원정보 가져오기
		UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
		UserController userController = UserController.getInstance();
		
		//사용자 기준으로 요청을 한 아이디	
		String receiveId = request.getParameter("userId");
	
		Integer result = userController.blockDB(userPublicBean.getId(), receiveId); // 차단하기
		dispatchUrl = "home";
		RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
		rd.forward(request, response);
	}
	

	//차단해제
	private void cancelBlockUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
	
		String dispatchUrl = null;
		HttpSession session = request.getSession();
		//세션에서 회원정보 가져오기
		UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
		UserController userController = UserController.getInstance();
		
		//사용자 기준으로 요청을 한 아이디	
		String receiveId = request.getParameter("userId");
		int result = userController.cancelBlockDB(userPublicBean.getId(), receiveId);
		//Integer result = userController.blockDB(userPublicBean.getId(), receiveId); // 차단하기

	}
	//친구끊기
	private void removeFriend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
			
		String dispatchUrl = null;
		HttpSession session = request.getSession();
		//세션에서 회원정보 가져오기
		UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
		UserController userController = UserController.getInstance();
		
		//사용자 기준으로 요청을 한 아이디
		String receiveUserId = request.getParameter("userId");
		/*System.out.println("친구끊기 아이디:"+ receiveUserId);*/
		int result = userController.removeFriendDB(userPublicBean.getId(), receiveUserId);

	}
	//통합검색 
	private void searchTotal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dispatchUrl = null;
		HttpSession session = request.getSession();
		//세션에서 회원정보 가져오기
		UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
		String keyword = request.getParameter("keyword");
		
		/* 유저관련 */
	
		UserController userController = UserController.getInstance();
		//친구목록 
		List<FriendInfoViewBean> friendInfoViewBeans = userController.getFriendListDB(userPublicBean.getId());
		
		//친구요청 한적이있는지 확인해야(내가 요청한 회원들)		
		List<UserPublicBean> requestList = userController.getRequestFriendsDB(userPublicBean.getId());
	/*	System.out.println("친구요청목록:"+requestList);
		*/
		//내가 차단한 회원이 있는지 확인해야(차단회원목록들)
	//	List<UserPublicBean> blocking = userController.searchBlockingUser(userPublicBean.getId()); // 모델으로부터
		//System.out.println("차단회원목록 :"+ blocking);
		List<UserPublicBean> blocking = userController.searchBlockingUserDB(userPublicBean.getId()); //DB로부터
		
		//상대방이 날 차단하면 검색 창에서 보이지 않아야
	//	List<UserPublicBean> blocked = userController.searchBlockedUser(userPublicBean.getId()); // 모델으로부터
	/*	System.out.println("날 차단회원목록 :"+ blocked);*/
		List<UserPublicBean> blocked = userController.searchBlockedUserDB(userPublicBean.getId()); //DB로부터
		
		//이름 검색 결과
		List<UserPublicBean> userSearchResults = userController.searchUserByNameDB(keyword);	
		
		List<UserPublicBean> friendSearch = new ArrayList<UserPublicBean>(); //검색결과중 친구만
		List<UserPublicBean> onlyUserSearch = new ArrayList<UserPublicBean>(); //검색결과중 친구아닌회원만
			
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
		System.out.println("블락드"+blocked);
		System.out.println("블락킹"+blocking);*/
		request.setAttribute("blocking",blocking);
		request.setAttribute("blocked",blocked);
		request.setAttribute("requestList",requestList);
		//request.setAttribute("friendInfoViewBeans",friendInfoViewBeans);
		//request.setAttribute("userSearchResults",userSearchResults);
		request.setAttribute("friendSearch",friendSearch); //검색결과중 친구만
		request.setAttribute("onlyUserSearch",onlyUserSearch); //검색결과중 친구아닌회원만
		System.out.println(friendSearch.isEmpty());
		
		
		/*마이페이지 관련*/
		MyPageController myPageController = MyPageController.getInstance();
		List<MyPagePublicBean> myPages= myPageController.searchMyPageDB(keyword); //타이틀 검색(LIKE)
		List<FollowingMyPageViewBean> following=  myPageController.getFollowingMyPageDB(userPublicBean.getId()); //팔로잉한 마이페이지 
		
		
		System.out.println("팔로잉"+following);
		List<MyPagePublicBean> followingSearch = new ArrayList<MyPagePublicBean>(); //검색결과중 팔로잉한것만
		List<MyPagePublicBean> onlyMypageSearch = new ArrayList<MyPagePublicBean>(); //검색결과중 팔로잉 안한것만
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
		
	
		
		request.setAttribute("followingSearch",followingSearch); //검색결과중 팔로잉한것만
		request.setAttribute("onlyMypageSearch",onlyMypageSearch); //검색결과중 팔로잉 안한것만
		//System.out.println(followingSearch);
		//System.out.println(onlyMypageSearch);

		dispatchUrl = "/totalSearch.jsp";
		if (dispatchUrl != null){
			RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
			rd.forward(request, response);
		}
	}
	//프로필 수정 //2월 1일 추가
		private void profileModify(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String dispatchUrl = null;
			HttpSession session = request.getSession();
			//세션에서 회원정보 가져오기
			UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
			UserController userController = UserController.getInstance();
			String location = request.getParameter("location");
			String school = request.getParameter("school");
			if(location.equals("area1")){
				location = "서울시";
			}else if(location.equals("area2")){
				location = "경기도";
			}else if(location.equals("area3")){
				location = "함경도";
			}else if(location.equals("area4")){
				location = "평안도";
			}else if(location.equals("area5")){
				location = "강원도";
			}else if(location.equals("area6")){
				location = "황해도";
			}else if(location.equals("area7")){
				location = "충청도";
			}else if(location.equals("area8")){
				location = "경상도";
			}else if(location.equals("area9")){
				location = "전라도";
			}else if(location.equals("area10")){
				location = "인천시";
			}else if(location.equals("area11")){
				location = "제주시";
			}
			
			if(school.equals("banghakPri")){
				school = "방학초등학교";
			}else if(school.equals("seonlinHigh")){
				school = "선린인터넷고등학교";
			}else if(school.equals("soongsilUni")){
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

			
			UserProfileForm userProfileForm = new UserProfileForm();
			userProfileForm.setLocation(location);
			userProfileForm.setProfileImg("image/profileImg/"+request.getParameter("file"));
			userProfileForm.setSchool(school);
			System.out.println("프로필 변경:"+ userProfileForm);
			
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
		//2월 1일 새로 추가된 메소드
		private void profileModifyShow(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String dispatchUrl = null;
			HttpSession session = request.getSession();
			//세션에서 회원정보 가져오기
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
		
		//2월 1일 새로 추가된 메소드 (내 정보 보는 페이지)
		private void myProfile(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String dispatchUrl = null;
			
			//세션에서 회원정보 가져오기
			HttpSession session = request.getSession();
			UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
			UserController userController = UserController.getInstance();
			if(request.getParameter("id")!=null&&!request.getParameter("id").equals(userPublicBean.getId())){
				FriendInfoViewBean fvb = userController.getFriendDB(userPublicBean.getId(), request.getParameter("id"));
				if(fvb!=null){ //친구이면
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
		
		//2월 1일 // 회원정보 수정
		private void modifyUserInfo(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String dispatchUrl = null;
			HttpSession session = request.getSession();
			//세션에서 회원정보 가져오기
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
			System.out.println("회원정보수정"+result);
			
		
			//에이젝스 써야겠다...? 흑
			dispatchUrl = "/accountManage.jsp";
			if (dispatchUrl != null) {
				RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
				rd.forward(request, response);
			}
			
			
		}
		//2월 1일 // 비활성화 
			private void deacti(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				String dispatchUrl = null;
				HttpSession session = request.getSession();
				//세션에서 회원정보 가져오기
				UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
				
				UserController userController = UserController.getInstance();
			
				int result = userController.deactiDB(userPublicBean.getId());
				
				
			
				//에이젝스 써야겠다...? 흑
				dispatchUrl = "login.jsp";
				if (dispatchUrl != null) {
					RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
					rd.forward(request, response);
				}
				
				
			}
			
			//활성화 (페이지 안만듬)
			private void acti(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				String dispatchUrl = null;
				HttpSession session = request.getSession();
				//세션에서 회원정보 가져오기
				UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
				
				UserController userController = UserController.getInstance();
				int result = userController.actiDB(userPublicBean.getId());
				
	//home.jsp 말고 서블릿으로 가도록 (통합시)			
				dispatchUrl = "home"; 
				if (dispatchUrl != null) {
					RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
					rd.forward(request, response);
				}
			}
			
			//회원 탈퇴
			private void withdraw(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				String dispatchUrl = null;
				HttpSession session = request.getSession();
				//세션에서 회원정보 가져오기
				UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
				
				UserController userController = UserController.getInstance();
				int result = userController.withdrawDB(userPublicBean.getId(),request.getParameter("pwd"));
				
			
				//에이젝스 필요
				dispatchUrl = "/login.jsp"; 
				if (dispatchUrl != null) {
					RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
					rd.forward(request, response);
				}
			}
	//황추가
	private void goFriend(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dispatchUrl = null;
		//HttpSession session = request.getSession();
		//세션에서 회원정보 가져오기
		//UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
		String id = "id2";	//세션처리 하믄 치워야함
		
		String friendId = request.getParameter("userId");	//프로필 찾아갈 친구 아이디
		System.out.println("친구목록 등 에서 : "+friendId);
		if(friendId == null){	//널이면 알람쪽에서 요청 보낸것!! senderId로 가져오기
			friendId = request.getParameter("senderId");	//알람에서 친구정보 볼 때
			System.out.println("알림목록 에서 : "+friendId);
		}
		
		UserController controller = UserController.getInstance();
		FriendInfoViewBean bean = controller.getFriendDB(id, friendId);
		
		System.out.println("친구 정보 : "+bean);
		request.setAttribute("friendInfo", bean);
		
		dispatchUrl = "/profileShowFriend.jsp";
		if (dispatchUrl != null){
			RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
			rd.forward(request, response);
		}
	}
}
