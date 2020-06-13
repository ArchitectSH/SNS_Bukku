package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import viewHelperBean.AlarmViewBean;
import viewHelperBean.UserPublicBean;
import applicationController.AlarmController;

/**
 * Servlet implementation class AlarmServlet
 */
@WebServlet(urlPatterns = { "/alarmServlet.do", "/alarm_page_main.do", "/alarm_page_go.do", "/alarm.do", "/alarm_post_go.do", "/alarm_friend_accpet_go.do", "/alarm_friend_go.do",
		"/gogo"})
public class AlarmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String disPatchUrl = null;
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		
		System.out.println("요청 : "+action);
		if(action.equals("alarmServlet.do")){
			disPatchUrl = "home.jsp";
		}
		else if(action.equals("alarm.do")){
			allAlarm(request, response);
		}
		else if(action.equals("alarm_page_main.do")){
			disPatchUrl = alarmPageMain(request,response);
		}
		else if(action.equals("alarm_page_go.do")){
			disPatchUrl = alarmPageGo(request,response);
		}else if(action.equals("alarm_post_go.do")){
			disPatchUrl = alarmPostGo(request, response);
		}else if(action.equals("alarm_friend_accpet_go.do")){
			disPatchUrl = alarmFriendAcceptGo(request, response);
		}else if(action.equals("alarm_friend_go.do")){
			disPatchUrl = alarmFriendPostGo(request, response);
		}
		
		if(disPatchUrl != null){
			RequestDispatcher rd = request.getRequestDispatcher(disPatchUrl);
			rd.forward(request, response);
		}
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String disPatchUrl = null;
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		
		System.out.println("요청 : "+action);
		if(action.equals("alarmServlet.do")){
			//disPatchUrl = allAlarm(request, response);
			allAlarm(request, response);
		}
		else if(action.equals("alarm.do")){
			allAlarm(request, response);
		}
		else if(action.equals("alarm_page_main.do")){
			disPatchUrl = alarmPageMain(request,response);
		}
		else if(action.equals("alarm_page_go.do")){
			disPatchUrl = alarmPageGo(request,response);
		}else if(action.equals("alarm_friend_accpet_go.do")){
			disPatchUrl = alarmFriendAcceptGo(request, response);
		}else if(action.equals("alarm_friend_go.do")){
			disPatchUrl = alarmFriendPostGo(request, response);
		}
		
		
		if(disPatchUrl != null){
			RequestDispatcher rd = request.getRequestDispatcher(disPatchUrl);
			rd.forward(request, response);
		}
	}
	
	/*private String gogo(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String alarmNoString = request.getParameter("alarmNo");
		String check = request.getParameter("checkAlarm");
		int alarmNo = 0;
		try{
			alarmNo = Integer.parseInt(alarmNoString);
		}
		catch(NumberFormatException e){
			e.printStackTrace();
		}
		System.out.println("check : "+check+" / alarmNo : "+alarmNo);
		if(check.equals("0")){
			System.out.println("체크 0");
			AlarmController alarmController = AlarmController.getInstance();
			alarmController.updateCheckAlarm(1,alarmNo);
		}
		
		if(request.getParameter("postNo") != null){
			System.out.println("포스트로 갈거당 : "+request.getParameter("postNo"));
			request.setAttribute("postNo", request.getParameter("postNo"));
			return "goPost.do";
		}
		else if(request.getParameter("senderId") != null){
			request.setAttribute("senderId", request.getParameter("senderId"));
			return "goFriend.do";
		}
		else{
			return "friendManager";
		}
	}
*/

	private void allAlarm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserPublicBean userPublicBean = (UserPublicBean)session.getAttribute("userPublicBean");
		
		AlarmController alarmController = AlarmController.getInstance();
		List<AlarmViewBean> list = alarmController.getAlarmsDB(userPublicBean.getId());
		System.out.println(list);
		
		JSONArray ja = new JSONArray();
		for(AlarmViewBean b : list){
			JSONObject obj = new JSONObject(); // 여기서 제이선 쓰긴썼는데 제이썬 포맷은
		    // 이런식으로 된다말이야 그래서 아까 헤더가 ㅁㅇapplication/json ㅇ이였는데  출력은 에이치티엠에로 하고있었으닝 ㅗ류가 난거였고
			obj.put("alarmNo", b.getAlarmNo());
			obj.put("checkAlarm",b.getCheckAlarm());
			obj.put("bukkuIndex",b.getBukkuIndex());
		    obj.put("mypageTitle", b.getMypageTitle());
		    obj.put("postNo", b.getPostNo());
		    obj.put("senderId", b.getSenderId());
			obj.put("senderProfileImg",b.getSenderProfileImg());
		    obj.put("senderName",b.getSenderName());
		    obj.put("activityKind",b.getActivityKind());
		    ja.add(obj);
		    //System.out.println("요:"+obj);
		}
		//JSONObject obj = new JSONObject(); // 여기서 제이선 쓰긴썼는데 제이썬 포맷은
		//obj.put("length",list.size());
		//ja.add(obj);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.print(ja);
		writer.flush();
	    writer.close();
		//request.setAttribute("alarmList", list);
		//request.setAttribute("userPublicBean", UserPublicBean);
		
		//return "home.jsp";
	}
	
	private String alarmPageGo(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		checkAlarm(request, response);

		request.setAttribute("title", request.getAttribute("title"));
		return "page_go.do";
	}
	private void checkAlarm(HttpServletRequest request,
			HttpServletResponse response) {
		String alarmNoString = request.getParameter("alarmNo");
		String check = request.getParameter("checkAlarm");
		int alarmNo = 0;
		try{
			alarmNo = Integer.parseInt(alarmNoString);
		}
		catch(NumberFormatException e){
			e.printStackTrace();
		}
		System.out.println("check : "+check+"alarmNo : "+alarmNo);
		if(check.equals("0")){
			AlarmController alarmController = AlarmController.getInstance();
			alarmController.updateCheckAlarm(1,alarmNo);
			System.out.println("checkAlarm");
		}
	}
	private String alarmPageMain(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		checkAlarm(request, response);
		request.setAttribute("title", request.getAttribute("title"));
		return "page_main.do";
	}
	private String alarmPostGo(HttpServletRequest request,
			HttpServletResponse response) {
		checkAlarm(request, response);
		return "goPost";
	}
	private String alarmFriendAcceptGo(HttpServletRequest request,
	HttpServletResponse response) {
		System.out.println("asdf");
		checkAlarm(request, response);
		return "friendManage";
	}
	private String alarmFriendPostGo(HttpServletRequest request,
			HttpServletResponse response) {
			checkAlarm(request, response);
			return "showUserPost";
	}
}
