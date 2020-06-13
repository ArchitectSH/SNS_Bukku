package injector;

import javax.sql.DataSource;

import action.AdminAction;
import action.BlockUserAction;
import action.CommonRelationAction;
import action.ConfigurationViewAction;
import action.FriendAddingUserAction;
import action.FriendInfoViewAction;
import action.FriendReceiveViewAction;
import action.FriendRelationAction;
import action.ReceiveAlarmSettingAction;
import action.StopViewAction;
import action.UserAction;
import action.UserEnvironmentSettingAction;
import dao.AdminDAO;
import dao.AdminDAOImpl;
import dao.BlockUserDAO;
import dao.BlockUserDAOImpl;
import dao.CommonRelationDAO;
import dao.CommonRelationDAOImpl;
import dao.ConfigurationViewDAO;
import dao.ConfigurationViewDAOImpl;
import dao.FriendAddingUserDAO;
import dao.FriendAddingUserDAOImpl;
import dao.FriendInfoViewDAO;
import dao.FriendInfoViewDAOImpl;
import dao.FriendReceiveViewDAO;
import dao.FriendReceiveViewDAOImpl;
import dao.FriendRelationDAO;
import dao.FriendRelationDAOImpl;
import dao.ReceiveAlarmSettingDAO;
import dao.ReceiveAlarmSettingDAOImpl;
import dao.StopViewDAO;
import dao.StopViewDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import dao.UserEnvironmentSettingDAO;
import dao.UserEnvironmentSettingDAOImpl;

public class UserDependencyInjector {

	private DataSource dataSource;

	public UserDependencyInjector(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public Object getObject(Class type) {
		if(type == UserDAO.class){
			return createUserDAO();
		}else if(type == CommonRelationDAO.class){
			return createCommonRelationDAO();
		}else if(type == FriendRelationDAO.class){
			return createFriendRelationDAO();
		}else if(type == UserEnvironmentSettingDAO.class){
			return createUserEnvironmentSettingDAO();
		}else if(type == ReceiveAlarmSettingDAO.class){
			return createReceiveAlarmSettingDAO();
		}else if(type == FriendAddingUserDAO.class){
			return createFriendAddingUserDAO();
		}else if(type == BlockUserDAO.class){
			return createBlockUserDAO();
		}else if(type == FriendInfoViewDAO.class){
			return createFriendInfoViewDAO();
		}else if(type == FriendReceiveViewDAO.class){
			return createFriendReceiveViewDAO();
		}else if(type == ConfigurationViewDAO.class){
			return createConfigurationViewDAO();
		}else if(type == StopViewDAO.class){
			return createStopViewDAO();
		}else 	if(type == UserAction.class){
			return createUserAction();
		}else if(type == CommonRelationAction.class){
			return createCommonRelationAction();
		}else if(type == FriendRelationAction.class){
			return createFriendRelationAction();
		}else if(type == UserEnvironmentSettingAction.class){
			return createUserEnvironmentSettingAction();
		}else if(type == ReceiveAlarmSettingAction.class){
			return createReceiveAlarmSettingAction();
		}else if(type == FriendAddingUserAction.class){
			return createFriendAddingUserAction();
		}else if(type == BlockUserAction.class){
			return createBlockUserAction();
		}else if(type == FriendInfoViewAction.class){
			return createFriendInfoViewAction();
		}else if(type == FriendReceiveViewAction.class){
			return createFriendReceiveViewAction();
		}else if(type == ConfigurationViewAction.class){
			return createConfigurationViewAction();
		}else if(type == StopViewAction.class){
			return createStopViewAction();
		}else if(type == AdminAction.class){
			return createAdminAction();
		}else if(type == AdminDAO.class){
			return createAdminDAO();
		}
		return null;
	}

	private UserDAO createUserDAO(){
		UserDAO userDAO = new UserDAOImpl();
		userDAO.setDataSource(dataSource);
		return userDAO;
	}
	private CommonRelationDAO createCommonRelationDAO(){
		CommonRelationDAO commonRelationDAO = new CommonRelationDAOImpl();
		commonRelationDAO.setDataSource(dataSource);
		return commonRelationDAO;
	}
	private FriendRelationDAO createFriendRelationDAO(){
		FriendRelationDAO friendRelationDAO = new FriendRelationDAOImpl();
		friendRelationDAO.setDataSource(dataSource);
		return friendRelationDAO;
	}
	private UserEnvironmentSettingDAO createUserEnvironmentSettingDAO(){
		UserEnvironmentSettingDAO userEnvironmentSettingDAO = new UserEnvironmentSettingDAOImpl();
		userEnvironmentSettingDAO.setDataSource(dataSource);
		return userEnvironmentSettingDAO;
	}

	private ReceiveAlarmSettingDAO createReceiveAlarmSettingDAO(){
		ReceiveAlarmSettingDAO receiveAlarmSettingDAO = new ReceiveAlarmSettingDAOImpl();
		receiveAlarmSettingDAO.setDataSource(dataSource);
		return receiveAlarmSettingDAO;
	}
	private FriendAddingUserDAO createFriendAddingUserDAO(){
		FriendAddingUserDAO friendAddingUserDAO = new FriendAddingUserDAOImpl();
		friendAddingUserDAO.setDataSource(dataSource);
		return friendAddingUserDAO;
	}
	private BlockUserDAO createBlockUserDAO(){
		BlockUserDAO blockUserDAO = new BlockUserDAOImpl();
		blockUserDAO.setDataSource(dataSource);
		return blockUserDAO;
	}

	private FriendInfoViewDAO createFriendInfoViewDAO(){
		FriendInfoViewDAO friendInfoViewDAO = new FriendInfoViewDAOImpl();
		friendInfoViewDAO.setDataSource(dataSource);
		return friendInfoViewDAO;
	}
	private FriendReceiveViewDAO createFriendReceiveViewDAO(){
		FriendReceiveViewDAO friendReceiveViewDAO = new FriendReceiveViewDAOImpl();
		friendReceiveViewDAO.setDataSource(dataSource);
		return friendReceiveViewDAO;
	}
	private ConfigurationViewDAO createConfigurationViewDAO(){
		ConfigurationViewDAO configurationViewDAO = new ConfigurationViewDAOImpl();
		configurationViewDAO.setDataSource(dataSource);
		return configurationViewDAO;
	}
	private StopViewDAO createStopViewDAO(){
		StopViewDAO stopViewDAO = new StopViewDAOImpl();
		stopViewDAO.setDataSource(dataSource);
		return stopViewDAO;
	}
	private UserAction createUserAction(){
		action.UserAction userAction = new UserAction();
		userAction.setUserDAO(createUserDAO());
		return userAction;		
	}
	private CommonRelationAction createCommonRelationAction(){
		CommonRelationAction commonRelationAction = new CommonRelationAction();
		commonRelationAction.setCommonRelationDAO(createCommonRelationDAO());
		return commonRelationAction;
	}
	private FriendRelationAction createFriendRelationAction(){
		FriendRelationAction friendRelationAction = new FriendRelationAction();
		friendRelationAction.setFriendRelationDAO(createFriendRelationDAO());
		return friendRelationAction;
	}
	private UserEnvironmentSettingAction createUserEnvironmentSettingAction(){
		UserEnvironmentSettingAction userEnvironmentSettingAction = new UserEnvironmentSettingAction();
		userEnvironmentSettingAction.setUserEnvironmentSettingDAO(createUserEnvironmentSettingDAO());
		return userEnvironmentSettingAction;
	}

	private ReceiveAlarmSettingAction createReceiveAlarmSettingAction(){
		ReceiveAlarmSettingAction receiveAlarmSettingAction = new ReceiveAlarmSettingAction();
		receiveAlarmSettingAction.setReceiveAlarmSettingDAO(createReceiveAlarmSettingDAO());
		return receiveAlarmSettingAction;
	}
	private FriendAddingUserAction createFriendAddingUserAction(){
		FriendAddingUserAction friendAddingUserAction = new FriendAddingUserAction();
		friendAddingUserAction.setFriendAddingUserDAO(createFriendAddingUserDAO());
		return friendAddingUserAction;
	}
	private BlockUserAction createBlockUserAction(){
		BlockUserAction blockUserAction = new BlockUserAction();
		blockUserAction.setBlockUserDAO(createBlockUserDAO());
		return blockUserAction;
	}

	private FriendInfoViewAction createFriendInfoViewAction(){
		FriendInfoViewAction friendInfoViewAction = new FriendInfoViewAction();
		friendInfoViewAction.setFriendInfoViewDAO(createFriendInfoViewDAO());
		return friendInfoViewAction;
	}
	private FriendReceiveViewAction createFriendReceiveViewAction(){
		FriendReceiveViewAction friendReceiveViewAction = new FriendReceiveViewAction();
		friendReceiveViewAction.setFriendReceiveViewDAO(createFriendReceiveViewDAO());
		return friendReceiveViewAction;
	}
	private ConfigurationViewAction createConfigurationViewAction(){
		ConfigurationViewAction configurationViewAction = new ConfigurationViewAction();
		configurationViewAction.setConfigurationViewDAO(createConfigurationViewDAO());
		return configurationViewAction;
	}
	private StopViewAction createStopViewAction(){
		StopViewAction stopViewAction = new StopViewAction();
		stopViewAction.setStopViewDAO(createStopViewDAO());
		return stopViewAction;
	}
	private AdminAction createAdminAction(){
		AdminAction adminAction = new AdminAction();
		adminAction.setAdminDAO(createAdminDAO());
		return adminAction;
	}
	private AdminDAO createAdminDAO(){
		AdminDAO adminDAO = new AdminDAOImpl();
		adminDAO.setDataSource(dataSource);
		return adminDAO;
	}
	
	
	

}
