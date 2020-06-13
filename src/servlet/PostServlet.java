package servlet;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.PrivacyLevel;

import org.json.simple.JSONObject;

import viewHelperBean.FollowingMyPageViewBean;
import viewHelperBean.FriendInfoViewBean;
import viewHelperBean.MyPageViewBean;
import viewHelperBean.PostAllInfoBean;
import viewHelperBean.UserBean;
import viewHelperBean.UserPublicBean;
import applicationController.AlarmController;
import applicationController.MyPageController;
import applicationController.PostCommentController;
import applicationController.UserController;
import form.CommentForm;
import form.UserPostForm;
/**
 * Servlet implementation class PostServlet
 */
@WebServlet(name = "postServlet", urlPatterns = { "/home", "/writePost", "/writeGuestPost","/deletePost", "/writeComment", 
																							"/deleteComment", "/myPost", "/recommendPost","/modifyPost","/filterPost",
																							"/searchMyPost","/showUserPost","/showMyPagePost", "/writeMyPagePost", "/goPost"})
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		if(action.equals("home")){
			showHome(request, response);
		}else if(action.equals("deletePost")){
			deletePost(request,response);
		}else if(action.equals("deleteComment")){
			deleteComment(request, response);
		}else if(action.equals("myPost")){
			myNews(request,response);
		}else if(action.equals("recommendPost")){
			recommend(request, response);
		}else if(action.equals("showUserPost")){
			showUserPost(request, response);
		}else if(action.equals("showMyPagePost")){
			showMyPagePost(request, response);
		}else if(action.equals("goPost")){
			goPost(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		if(action.equals("home")){
			showHome(request, response);
		}else if(action.equals("writePost")){
			writePost(request, response);
			reForward(request, response, request.getParameter("currentPage"));
		}else if(action.equals("writeComment")){
			writeComment(request, response);
		}else if(action.equals("modifyPost")){
			modifyPost(request, response);
		}else if(action.equals("filterPost")){
			filterPost(request, response);
		}else if(action.equals("searchMyPost")){
			searchMyPost(request, response);
		}else if(action.equals("writeGuestPost")){
			writeGuestPost(request, response);
		}else if(action.equals("writeMyPagePost")){
			writeMyPagePost(request, response);
		}else if(action.equals("showMyPagePost")){
			showMyPagePost(request, response);
		}
	}
	private void showHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = ((UserPublicBean) request.getSession().getAttribute("userPublicBean")).getId();
		List<PostAllInfoBean> homePosts = PostCommentController.getInstance().showHomePost(id);
		request.setAttribute("homePosts", homePosts);
		String dispatchUrl = "/home.jsp";
		RequestDispatcher view = request.getRequestDispatcher(dispatchUrl);
		view.forward(request, response);
	}
	private void writePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserPostForm upf = makePost(request, response);
		
		PostCommentController.getInstance().writePostDB(upf, (UserPublicBean) request.getSession().getAttribute("userPublicBean"));
		
		//showHome(request,response);
	}
	private void deletePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostCommentController.getInstance().deletePostDB(Integer.parseInt(request.getParameter("postNo")));
		//showHome(request,response);
	}
	private void writeComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommentForm cf = new CommentForm();
		cf.setComment(request.getParameter("commentText"));
		
		if(request.getParameter("commentPrivacy")==null)
			cf.setPrivacyLevel(PrivacyLevel.ALL);
		else
			cf.setPrivacyLevel(PrivacyLevel.CLOSED);
		
		int commentNo = PostCommentController.getInstance().writeComment(cf, Integer.parseInt(request.getParameter("postNo")), (UserPublicBean) request.getSession().getAttribute("userPublicBean"));		
		String writerId = PostCommentController.getInstance().getPostWriter(Integer.parseInt(request.getParameter("postNo")));
		String myId = ((UserPublicBean) request.getSession().getAttribute("userPublicBean")).getId();
		if(!writerId.equals(myId))
			AlarmController.getInstance().addWriteCommentAlarmDB(writerId,myId, Integer.parseInt(request.getParameter("postNo")));
		
		long currentBukkuIndex = UserController.getInstance().decreaseBukkuIndex(myId, writerId);
		if(currentBukkuIndex==50|| currentBukkuIndex==100 || currentBukkuIndex==150 || currentBukkuIndex==200){
			AlarmController.getInstance().addBukkuLevelUpAlarmDB(writerId, myId);
			AlarmController.getInstance().addBukkuLevelUpAlarmDB(myId, writerId);
		}
			
		
		JSONObject obj = new JSONObject(); // 여기서 제이선 쓰긴썼는데 제이썬 포맷은
		// 이런식으로 된다말이야 그래서 아까 헤더가 ㅁㅇapplication/json ㅇ이였는데  출력은 에이치티엠에로 하고있었으닝 ㅗ류가 난거였고
		obj.put("content", cf.getComment());
		obj.put("writer", ((UserPublicBean) request.getSession().getAttribute("userPublicBean")).getName());
		obj.put("img", ((UserPublicBean) request.getSession().getAttribute("userPublicBean")).getProfileImg());
		obj.put("commentNo", commentNo);
		obj.put("commentDate", "지금 막");
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write(obj.toString());
		writer.flush();
		writer.close();
		//showHome(request,response);
	}
	private void deleteComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		PostCommentController.getInstance().deleteComment(commentNo);
		showHome(request,response);
	}
	private void myNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PostAllInfoBean> myPosts = PostCommentController.getInstance().showMyPost(((UserPublicBean) request.getSession().getAttribute("userPublicBean")).getId());
		UserBean ub = UserController.getInstance().getUserProfileDB(((UserPublicBean) request.getSession().getAttribute("userPublicBean")).getId());
		request.setAttribute("myPosts", myPosts);
		request.setAttribute("userBean", ub);
		String dispatchUrl = "/myPost.jsp";
		RequestDispatcher view = request.getRequestDispatcher(dispatchUrl);
		view.forward(request, response);
	}
	private void recommend(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostCommentController.getInstance().recommendPost(Integer.parseInt(request.getParameter("postNo")), Integer.parseInt(request.getParameter("recommendKind")), ((UserPublicBean) request.getSession().getAttribute("userPublicBean")).getId());
		
		String writerId = PostCommentController.getInstance().getPostWriter(Integer.parseInt(request.getParameter("postNo")));
		if(!writerId.equals(((UserPublicBean) request.getSession().getAttribute("userPublicBean")).getId()) && Integer.parseInt(request.getParameter("recommendKind"))==1)
			AlarmController.getInstance().addRecommendAlarmDB(writerId, ((UserPublicBean) request.getSession().getAttribute("userPublicBean")).getId(), Integer.parseInt(request.getParameter("postNo"))); 
	}
	private void modifyPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String img = null;
		String video = null;
		Collection<Part> coll = request.getParts();
		for (Part part : coll) {
			String name = part.getName();
			if(name.equals("contents") || name.equals("privacyLevel")) continue;
			String contentType = part.getContentType();
			System.out.println("파라미터명:" + name + "=" + contentType + "<br/>");
			if (contentType == null) {
				// 경로로 입력된 파일일 경우
				InputStreamReader isr = new InputStreamReader(
						part.getInputStream(), "UTF-8");
				// euc-kr케릭터셋의 InputStreamReader를 호출
				char[] buffer = new char[512];
				// 한번에 이동시킬 byte수 지정
				StringBuffer stringBuffer = new StringBuffer();
				// text파일을 읽어 담을 곳을 지정..text파일만 가능
				int n = -1;
				while ((n = isr.read(buffer)) != -1) {
					// 파일 내용이 존재할경우 계속 실행
					stringBuffer.append(buffer, 0, n);
					// 읽어 온 내용을 버퍼에 담는다.
				}
			} else {
				String header = part.getHeader("Content-Disposition");
				// form-data;name;filename 세가지 정보를 가져온다
				String str = header.split(";")[2].split("=")[1];
				// filename에서 값을 가져온다
				// 컬렉션은 순서가 없으므로 항상 2번에 이름이있지 않을수도 있다(잘못된 로직?)
				String filename = str.replaceAll("\"", "");
				// "를 없앤다.
				System.out.println("파일명:" + filename + "<br/>");
				System.out.println(filename);
				
				if (part.getSize() > 0) {
					// 파일이 내용이 있다면.
					if(name.equals("f1")) img = filename;
					if(name.equals("f2")) video = filename;
					part.write(filename);
					// 위의 경로로 저장한다.
					part.delete();
				}
			}
		}

		UserPostForm upf = new UserPostForm();
		List<String> imgList = new ArrayList<String>();
		if(img!=null)
			imgList.add("image/postImg/"+img);
		upf.setImg(imgList);
		int level = Integer.parseInt(request.getParameter("privacyLevel"));
		if(level==1){
			upf.setPrivacyLevel(PrivacyLevel.ALL);
		}else if(level==2){
			upf.setPrivacyLevel(PrivacyLevel.ONLY_FRIEND);
		}else if(level==3){
			upf.setPrivacyLevel(PrivacyLevel.CLOSED);
		}
		if(video!=null)
			upf.setVideo("image/video/"+video);
		if(request.getParameter("contents")!=null)
			upf.setContents(request.getParameter("contents"));

		PostCommentController.getInstance().modifyPost(upf, Integer.parseInt(request.getParameter("postNo")));
	}
	
	private void filterPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean[] filtering =new boolean[4];
		if(request.getParameter("myPost")!=null)
			filtering[0]=true;
		if(request.getParameter("friendPost")!=null)
			filtering[1]=true;
		if(request.getParameter("friendActPost")!=null)
			filtering[2]=true;
		if(request.getParameter("pagePost")!=null)
			filtering[3]=true;
		request.setAttribute("filtering", filtering);
		showHome(request, response);
	}
	
	
	private void reForward(HttpServletRequest request, HttpServletResponse response, String currentPage) throws ServletException, IOException{
		if(currentPage.equals("myPost")){
			myNews(request, response);
		}else if(currentPage.equals("home")){
			showHome(request,response);
		}
	}
	
	private void searchMyPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String searchContent = request.getParameter("content");
		String startDate = request.getParameter("startDate");
		String lastDate = request.getParameter("lastDate");
		List<PostAllInfoBean> searchedList = PostCommentController.getInstance().searchMyPosts(((UserPublicBean) request.getSession().getAttribute("userPublicBean")).getId(), searchContent, startDate, lastDate);
		UserBean ub = UserController.getInstance().getUserProfileDB(((UserPublicBean) request.getSession().getAttribute("userPublicBean")).getId());
		request.setAttribute("myPosts", searchedList);
		request.setAttribute("userBean", ub);
		String dispatchUrl = "/myPost.jsp";
		RequestDispatcher view = request.getRequestDispatcher(dispatchUrl);
		view.forward(request, response);
	}
	
	private void showUserPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String linkedId = request.getParameter("id");
		if(linkedId==null)
			linkedId = request.getParameter("guestId");
		List<FriendInfoViewBean> fvbList = UserController.getInstance().getFriendListDB(((UserPublicBean) request.getSession().getAttribute("userPublicBean")).getId());
		
		List<PostAllInfoBean> userPosts = null;
		if(linkedId.equals(((UserPublicBean) request.getSession().getAttribute("userPublicBean")).getId())){
			myNews(request, response); 
			return;
		}
		else{
			userPosts = PostCommentController.getInstance().showMyPost(linkedId);
			UserBean ub = UserController.getInstance().getUserProfileDB(linkedId);
			request.setAttribute("myPosts", userPosts);
			request.setAttribute("userBean", ub);
			int limitPrivacy=1;
			for(FriendInfoViewBean fvb : fvbList){
				if(fvb.getFriendId().equals(linkedId)){
					limitPrivacy=2;
					request.setAttribute("bukkuLevel", fvb.getBukkuLevel());
				}
			}
			request.setAttribute("limitPrivacy", limitPrivacy);
			
		}
			
		String dispatchUrl = "/friendPost.jsp";
		RequestDispatcher view = request.getRequestDispatcher(dispatchUrl);
		view.forward(request, response);
	}
	private UserPostForm makePost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
			Collection<Part> coll = request.getParts();
			// 파라미터 값을 Collection의Part값으로 받는다.
			
			String img = null;
			String video = null;
			
			for (Part part : coll) {
				String name = part.getName();
				if(name.equals("contents") || name.equals("privacyLevel")) continue;
				String contentType = part.getContentType();
				System.out.println("파라미터명:" + name + "=" + contentType + "<br/>");
				if (contentType == null) {
					// 경로로 입력된 파일일 경우
					InputStreamReader isr = new InputStreamReader(
							part.getInputStream(), "UTF-8");
					// euc-kr케릭터셋의 InputStreamReader를 호출
					char[] buffer = new char[512];
					// 한번에 이동시킬 byte수 지정
					StringBuffer stringBuffer = new StringBuffer();
					// text파일을 읽어 담을 곳을 지정..text파일만 가능
					int n = -1;
					while ((n = isr.read(buffer)) != -1) {
						// 파일 내용이 존재할경우 계속 실행
						stringBuffer.append(buffer, 0, n);
						// 읽어 온 내용을 버퍼에 담는다.
					}
				} else {
					String header = part.getHeader("Content-Disposition");
					// form-data;name;filename 세가지 정보를 가져온다
					String str = header.split(";")[2].split("=")[1];
					// filename에서 값을 가져온다
					// 컬렉션은 순서가 없으므로 항상 2번에 이름이있지 않을수도 있다(잘못된 로직?)
					String filename = str.replaceAll("\"", "");
					// "를 없앤다.
					System.out.println("파일명:" + filename + "<br/>");
					System.out.println(filename);
					
					if (part.getSize() > 0) {
						// 파일이 내용이 있다면.
						if(name.equals("f1")) img = filename;
						if(name.equals("f2")) video = filename;
						part.write(filename);
						// 위의 경로로 저장한다.
						part.delete();
					}
				}
			}
	
			UserPostForm upf = new UserPostForm();
			List<String> imgList = new ArrayList<String>();
			if(img!=null)
				imgList.add("image/postImg/"+img);
			upf.setImg(imgList);
			int level = Integer.parseInt(request.getParameter("privacyLevel"));
			if(level==1){
				upf.setPrivacyLevel(PrivacyLevel.ALL);
			}else if(level==2){
				upf.setPrivacyLevel(PrivacyLevel.ONLY_FRIEND);
			}else if(level==3){
				upf.setPrivacyLevel(PrivacyLevel.CLOSED);
			}
			if(video!=null)
				upf.setVideo("image/video/"+video);
			if(request.getParameter("contents")!=null)
				upf.setContents(request.getParameter("contents"));
			
			return upf;
	}
	private void writeGuestPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		UserPostForm upf = makePost(request, response);
		
		String guestId = request.getParameter("guestId");
		System.out.println(guestId);
		String myId = ((UserPublicBean) request.getSession().getAttribute("userPublicBean")).getId();
		AlarmController.getInstance().addWritePostAlarmDB(guestId, myId, PostCommentController.getInstance().writeGuestPostDB(upf, (UserPublicBean) request.getSession().getAttribute("userPublicBean"), request.getParameter("guestId")));
		
		long currentBukkuIndex = UserController.getInstance().decreaseBukkuIndex(myId, guestId);
		if(currentBukkuIndex==50|| currentBukkuIndex==100 || currentBukkuIndex==150 || currentBukkuIndex==200){
			AlarmController.getInstance().addBukkuLevelUpAlarmDB(guestId, myId);
			AlarmController.getInstance().addBukkuLevelUpAlarmDB(myId, guestId);
		}
		
		showUserPost(request, response);
		//showHome(request,response);
	}
	private void showMyPagePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String linkedTitle = request.getParameter("title");
	
		if(linkedTitle==null){
			MyPageViewBean myPageInfo = (MyPageViewBean) request.getAttribute("myPageInfo");
			linkedTitle = myPageInfo.getTitle();
		}
		List<PostAllInfoBean> myPosts = PostCommentController.getInstance().showMyPagePost(((UserPublicBean) request.getSession().getAttribute("userPublicBean")).getId(), linkedTitle);
		
		List<FollowingMyPageViewBean> followingList = MyPageController.getInstance().getFollowingMyPageDB(((UserPublicBean) request.getSession().getAttribute("userPublicBean")).getId());
		request.setAttribute("follow", false);
		if(followingList==null)
			request.setAttribute("follow", false);
		for(FollowingMyPageViewBean f : followingList){
			if(f.getTitle().equals(linkedTitle)){
				request.setAttribute("follow", true);
			}
		}
		System.out.println("showMyPagePost");
		request.setAttribute("myPosts", myPosts);
		String dispatchUrl = "/myPageMain.jsp";
		RequestDispatcher view = request.getRequestDispatcher(dispatchUrl);
		view.forward(request, response);
	}
	private void writeMyPagePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserPostForm upf = makePost(request, response);
		
		PostCommentController.getInstance().writeMyPagePostDB(upf, (UserPublicBean)request.getSession().getAttribute("userPublicBean"), request.getParameter("title"));
		
		showMyPagePost(request, response);
	}
	private void goPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostAllInfoBean paib = PostCommentController.getInstance().showOnePost(((UserPublicBean)request.getSession().getAttribute("userPublicBean")).getId(), Integer.parseInt(request.getParameter("postNo")));
		request.setAttribute("postAllInfoBean", paib);
		String dispatchUrl = "/goPost.jsp";
		RequestDispatcher view = request.getRequestDispatcher(dispatchUrl);
		view.forward(request, response);
	}
}
