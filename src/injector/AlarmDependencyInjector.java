package injector;

import javax.sql.DataSource;

import action.ActivityAction;
import action.AlarmAction;
import action.AlarmViewAction;
import action.GroupAlarmAction;
import action.MyPageAlarmAction;
import action.PostAlarmAction;
import dao.ActivityDAO;
import dao.ActivityDAOImpl;
import dao.AlarmDAO;
import dao.AlarmDAOImpl;
import dao.AlarmViewDAO;
import dao.AlarmViewDAOImpl;
import dao.GroupAlarmDAO;
import dao.GroupAlarmDAOImpl;
import dao.MyPageAlarmDAO;
import dao.MyPageAlarmDAOImpl;
import dao.PostAlarmDAO;
import dao.PostAlarmDAOImpl;


public class AlarmDependencyInjector {
	private DataSource dataSource;

	public AlarmDependencyInjector(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public Object getObject(Class type) {
		if(type == AlarmDAO.class){
			return createAlarmDAO();
		}else if(type == GroupAlarmDAO.class){
			return createGroupAlarmDAO();
		}else if(type == MyPageAlarmDAO.class){
			return createMyPageAlarmDAO();
		}else if(type == PostAlarmDAO.class){
			return createPostAlarmDAO();
		}else if(type == AlarmViewDAO.class){
			return createAlarmViewDAO();
		}else if (type == ActivityDAO.class) {
			return createActivityDAO();
		}else if(type == AlarmAction.class){
			return createAlarmAction();
		}else if(type == GroupAlarmAction.class){
			return createGroupAlarmAction();
		}else if(type == MyPageAlarmAction.class){
			return createMyPageAlarmAction();
		}else if(type == PostAlarmAction.class){
			return createPostAlarmAction();
		}else if(type == AlarmViewAction.class){
			return createAlarmViewAction();
		}else if (type == ActivityAction.class) {
			return createActivityAction();
		}
		return null;
	}

	private AlarmViewDAO createAlarmViewDAO(){
		AlarmViewDAO alarmViewDAO = new AlarmViewDAOImpl();
		alarmViewDAO.setDataSource(dataSource);
		return alarmViewDAO;
	}
	private AlarmDAO createAlarmDAO(){
		AlarmDAO alarmDAO = new AlarmDAOImpl();
		alarmDAO.setDataSource(dataSource);
		return alarmDAO;
	}
	private GroupAlarmDAO createGroupAlarmDAO(){
		GroupAlarmDAO groupAlarmDAO = new GroupAlarmDAOImpl();
		groupAlarmDAO.setDataSource(dataSource);
		return groupAlarmDAO;
	}
	private MyPageAlarmDAO createMyPageAlarmDAO(){
		MyPageAlarmDAO myPageAlarmDAO = new MyPageAlarmDAOImpl();
		myPageAlarmDAO.setDataSource(dataSource);
		return myPageAlarmDAO;
	}
	private PostAlarmDAO createPostAlarmDAO(){
		PostAlarmDAO postAlarmDAO = new PostAlarmDAOImpl();
		postAlarmDAO.setDataSource(dataSource);
		return postAlarmDAO;
	}
	private ActivityDAO createActivityDAO(){
		ActivityDAO activityDAO = new ActivityDAOImpl();
		activityDAO.setDataSource(dataSource);
		return activityDAO;
	}
	private AlarmViewAction createAlarmViewAction(){
		AlarmViewAction alarmViewAction = new AlarmViewAction();
		alarmViewAction.setAlarmViewDAO(createAlarmViewDAO());
		return alarmViewAction;
	}
	private AlarmAction createAlarmAction(){
		AlarmAction alarmAction = new AlarmAction();
		alarmAction.setAlarmDAO(createAlarmDAO());
		return alarmAction;
	}
	private GroupAlarmAction createGroupAlarmAction(){
		GroupAlarmAction groupAlarmAction = new GroupAlarmAction();
		groupAlarmAction.setGroupAlarmDAO(createGroupAlarmDAO());
		return groupAlarmAction;
	}
	private MyPageAlarmAction createMyPageAlarmAction(){
		MyPageAlarmAction myPageAlarmAction = new MyPageAlarmAction();
		myPageAlarmAction.setMyPageAlarmDAO(createMyPageAlarmDAO());
		return myPageAlarmAction;
	}
	private PostAlarmAction createPostAlarmAction(){
		PostAlarmAction postAlarmAction = new PostAlarmAction();
		postAlarmAction.setPostAlarmDAO(createPostAlarmDAO());
		return postAlarmAction;
	}
	private ActivityAction createActivityAction(){
		ActivityAction activityAction = new ActivityAction();
		activityAction.setActivityDAO(createActivityDAO());
		return activityAction;
	}
}
