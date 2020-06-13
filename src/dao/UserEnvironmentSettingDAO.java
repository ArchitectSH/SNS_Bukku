package dao;

import java.util.List;

import dto.UserEnvironmentSettingDTO ;

public interface UserEnvironmentSettingDAO extends DAO{
	public List<UserEnvironmentSettingDTO> getUserSetting() throws DAOException;
		
	 
	
	public UserEnvironmentSettingDTO getUserSettingById(String id) throws DAOException;
	
	 
	
	public void updateUserSetting(Integer privacy,Boolean deactivation, Boolean userStop, String id) throws DAOException;
	
	 
	
	public void updateSearchPrivacy(Integer privacyLevel, String id) throws DAOException;
	
	 
	
	public void updateDeactivation(Boolean deactivation, String id) throws DAOException;
	
	 
	
	public void updateUserStop(Boolean userStop, String id) throws DAOException;
	
	 
	
	public void deleteUserSetting(String id) throws DAOException;
	
	 
	
	public void insertUserSetting(String id, Integer searchPrivacy, Boolean deactivation, Boolean userStop) throws DAOException;
	
	}
 
