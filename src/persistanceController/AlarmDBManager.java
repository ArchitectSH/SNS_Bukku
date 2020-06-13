package persistanceController;

import injector.AlarmDependencyInjector;
import injector.DataSourceManager;

import java.util.ArrayList;
import java.util.List;

import viewHelperBean.AlarmViewBean;
import action.AlarmAction;
import action.AlarmViewAction;
import action.MyPageAlarmAction;
import action.PostAlarmAction;
import dto.AlarmViewDTO;


public class AlarmDBManager {
	private static AlarmDBManager alarmDBManager;
	private AlarmDependencyInjector alarmDependencyInjector;
	
	public static AlarmDBManager getInstance() {
		if(alarmDBManager == null){
			alarmDBManager = new AlarmDBManager();
			return alarmDBManager;
		}
		return alarmDBManager;
	}
	private AlarmDBManager() {
		DataSourceManager dataSourceManager = DataSourceManager.getInstance();
		alarmDependencyInjector = new AlarmDependencyInjector(dataSourceManager.getInstance().getDataSource());
	}
	public List<AlarmViewBean> getAlarmsDB(String id){
		//AlarmAction action =(AlarmAction)alarmDependencyInjector.getObject(AlarmAction.class);
		AlarmViewAction action =(AlarmViewAction)alarmDependencyInjector.getObject(AlarmViewAction.class);
		List<AlarmViewDTO> listv = action.getAlarmViewByReceiverId(id);
		//List<AlarmDTO> listd = action.getAlarmByReceiverId(id);
		List<AlarmViewBean> list = new ArrayList<AlarmViewBean>();
		for(AlarmViewDTO dto : listv){
			AlarmViewBean bean = new AlarmViewBean();
			bean.setActivityDate(dto.getActivityDate());
			bean.setActivityKind(dto.getActivityKind());
			bean.setAlarmNo(dto.getAlarmNo());
			bean.setBukkuIndex(dto.getSenderBukkuIndex());
			bean.setCheckAlarm(dto.getCheckAlarm());
			bean.setCheckAlarm(dto.getCheckAlarm());
			bean.setGroupNo(dto.getGroupNo());
			bean.setMypageTitle(dto.getMypageTitle());
			bean.setPostNo(dto.getPostNo());
			bean.setReceiverId(dto.getReceiverId());
			bean.setSenderId(dto.getSenderId());
			bean.setSenderName(dto.getSenderName());
			bean.setSenderProfileImg(dto.getSenderProfileImg());
			
			list.add(bean);
		}
		return list;
	}
	public void updateCheckAlarm(Integer i, Integer alarmNo) {
		// TODO Auto-generated method stub
		AlarmAction alarmAction = (AlarmAction)alarmDependencyInjector.getObject(AlarmAction.class);
		alarmAction.updateCheckAlarm(i, alarmNo);
	}
	public Integer addMyPageInviteAlarmDB(String receiverId, String senderId, String myPageTitle){
		AlarmAction alarmAction = (AlarmAction)alarmDependencyInjector.getObject(AlarmAction.class);
		int alarmNum = alarmAction.insertAlarm(0, receiverId, 12, senderId);
		MyPageAlarmAction myPageAlarmAction = (MyPageAlarmAction)alarmDependencyInjector.getObject(MyPageAlarmAction.class);
		myPageAlarmAction.insertMyPageAlarm(alarmNum, myPageTitle);
		return 1;
	}
	public Integer addMyPageFollowAlarmDB(String receiverId, String senderId, String myPageTitle){
		AlarmAction alarmAction = (AlarmAction)alarmDependencyInjector.getObject(AlarmAction.class);
		int alarmNum = alarmAction.insertAlarm(0, receiverId, 19, senderId);
		MyPageAlarmAction myPageAlarmAction = (MyPageAlarmAction)alarmDependencyInjector.getObject(MyPageAlarmAction.class);
		myPageAlarmAction.insertMyPageAlarm(alarmNum, myPageTitle);
		return 1;
	}
	//승하추가
	public Integer addWriteCommentAlarmDB(String receiverId, String senderId, Integer postNo){
		AlarmAction alarmAction = (AlarmAction)alarmDependencyInjector.getObject(AlarmAction.class);
		PostAlarmAction postAlarmAction = (PostAlarmAction)alarmDependencyInjector.getObject(PostAlarmAction.class);  
		postAlarmAction.insertPostAlarm(alarmAction.insertAlarm(0, receiverId, 2, senderId), postNo);
		return 1;
	}
	public Integer addRecommendAlarmDB(String receiverId, String senderId, Integer postNo){
		AlarmAction alarmAction = (AlarmAction)alarmDependencyInjector.getObject(AlarmAction.class);
		PostAlarmAction postAlarmAction = (PostAlarmAction)alarmDependencyInjector.getObject(PostAlarmAction.class);  
		postAlarmAction.insertPostAlarm(alarmAction.insertAlarm(0, receiverId, 1, senderId), postNo);
		return 1;
	}
	public Integer addWritePostAlarmDB(String receiverId, String senderId, Integer postNo){
		AlarmAction alarmAction = (AlarmAction)alarmDependencyInjector.getObject(AlarmAction.class);
		PostAlarmAction postAlarmAction = (PostAlarmAction)alarmDependencyInjector.getObject(PostAlarmAction.class);  
		postAlarmAction.insertPostAlarm(alarmAction.insertAlarm(0, receiverId, 3, senderId), postNo);
		return 1;
	}
	public Integer addBukkuLevelUpAlarmDB(String receiverId, String senderId){
		AlarmAction alarmAction = (AlarmAction)alarmDependencyInjector.getObject(AlarmAction.class);  
		return alarmAction.insertAlarm(0, receiverId, 8, senderId);
	}
	//메소드 바디 채워놓음 1일 6시(장)
		public Integer addFriendRequestAlarmDB(String receiverId, String senderId) {
			AlarmAction alarmAction = (AlarmAction)alarmDependencyInjector.getObject(AlarmAction.class);
			Integer result = alarmAction.insertAlarm(0, receiverId, 9, senderId);
			return result;
		}
		public Integer addFriendAcceptAlarmDB(String receiverId, String senderId) {
			AlarmAction alarmAction = (AlarmAction)alarmDependencyInjector.getObject(AlarmAction.class);
			Integer result = alarmAction.insertAlarm(0, receiverId, 10, senderId);
			return result;
		}
		//1일 5시 30분 새로 추가된 메소드(장영은) // 차단당하거나 친구 끊으면 사용
		public Integer deleteUserAlarmDB(String userId,String receiveId){
			AlarmAction alarmAction = (AlarmAction)alarmDependencyInjector.getObject(AlarmAction.class);
			alarmAction.deleteAlarmBySenderAndReceiver(userId, receiveId);
			return 1;
			
		}
}
