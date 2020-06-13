package applicationController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import persistanceController.AlarmDBManager;
import model.MyPageAlarmList;
import model.PostAlarm;
import model.PostAlarmList;
import model.UserAlarm;
import model.UserAlarmList;
import viewHelperBean.AlarmViewBean;
import enums.AlarmAct;


public class AlarmController {
	//private PostAlarmList postAlarmList;
	//private UserAlarmList userAlarmList;
	//private MyPageAlarmList myPageAlarmList;
	//private GroupAlarmList groupAlarmList;
	private static AlarmController alarmController;
	
	public static synchronized AlarmController getInstance() {
		if(alarmController == null){
			alarmController = new AlarmController();
			return alarmController;
		}
		return alarmController;
	}
	private AlarmController() {
		//postAlarmList = new PostAlarmList();
		//Map<String,List<PostAlarm>> mapPostAlarmList = new HashMap<String,List<PostAlarm>>();
		
	}
	//Èñºó
	public int addMyPageInviteAlarmDB(String receiverId, String senderId, String myPageTitle){
		AlarmDBManager alarmDBManager = AlarmDBManager.getInstance();
		alarmDBManager.addMyPageInviteAlarmDB(receiverId, senderId, myPageTitle);
		return 1;
	}
	public int addMyPageFollowAlarmDB(String receiverId, String senderId, String myPageTitle){
		AlarmDBManager alarmDBManager = AlarmDBManager.getInstance();
		alarmDBManager.addMyPageFollowAlarmDB(receiverId, senderId, myPageTitle);
		return 1;
	}
	public List<AlarmViewBean> getAlarmsDB(String id) {
		AlarmDBManager alarmDBManager = AlarmDBManager.getInstance();
		List<AlarmViewBean> list = alarmDBManager.getAlarmsDB(id);
		return list;
	}
	public void updateCheckAlarm(int i, int alarmNo) {
		// TODO Auto-generated method stub
		AlarmDBManager dbManager = AlarmDBManager.getInstance();
		dbManager.updateCheckAlarm(i,alarmNo);
	}
	//½ÂÇÏÃß°¡
	public int addWriteCommentAlarmDB(String receiverId, String senderId, int postNo){
		AlarmDBManager dbManager = AlarmDBManager.getInstance();
		return dbManager.addWriteCommentAlarmDB(receiverId, senderId, postNo);
	}
	public int addRecommendAlarmDB(String receiverId, String senderId, int postNo){
		AlarmDBManager dbManager = AlarmDBManager.getInstance();
		return dbManager.addRecommendAlarmDB(receiverId, senderId, postNo);
	}
	public int addWritePostAlarmDB(String receiverId, String senderId, int postNo){
		AlarmDBManager dbManager = AlarmDBManager.getInstance();
		return dbManager.addWritePostAlarmDB(receiverId, senderId, postNo);
	}
	public int addBukkuLevelUpAlarmDB(String receiverId, String senderId){
		AlarmDBManager dbManager = AlarmDBManager.getInstance();
		return dbManager.addBukkuLevelUpAlarmDB(receiverId, senderId);
	}
	//¿µÀº
	public int addFriendRequestAlarmDB(String receiverId, String senderId) {
		AlarmDBManager alarmDBManager = AlarmDBManager.getInstance();
		Integer result = alarmDBManager.addFriendRequestAlarmDB(receiverId, senderId);
		return result;
	}
	public int addFriendAcceptAlarmDB(String receiverId, String senderId) {
		AlarmDBManager alarmDBManager = AlarmDBManager.getInstance();
		Integer result = alarmDBManager.addFriendAcceptAlarmDB(receiverId, senderId);
		return result;
	}
	public int deleteUserAlarmDB(String userId,String receiveId){
		AlarmDBManager alarmDBManager = AlarmDBManager.getInstance();
		Integer result = alarmDBManager.deleteUserAlarmDB(userId,receiveId);
		return result;		
	}
}
