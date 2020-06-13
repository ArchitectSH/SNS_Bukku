package dao;

import java.util.List ;

import dto.ReceiveAlarmSettingDTO;

public interface ReceiveAlarmSettingDAO extends DAO{
	public List<ReceiveAlarmSettingDTO> getAlarmSetting()  throws DAOException;
		
	 

	public ReceiveAlarmSettingDTO getAlarmSettingById(String id)  throws DAOException;
	
	 

	public void updateAlarmSetting(Boolean postReceive,Boolean commentReceive, Boolean communityReceive, Boolean warningReceive, String id) throws DAOException;
	
	 

	public void updatePostReceive(Boolean postReceive, String id)  throws DAOException;
	
	 

	public void updateCommentReceive(Boolean commentReceive, String id)  throws DAOException;
	
	 

	public void updateCommunityReceive(Boolean communityReceive, String id)  throws DAOException;
	
	 

	public void updateWarningReceive(Boolean warningReceive, String id)  throws DAOException;
	
	 

	public void deleteAlarmSetting(String id)  throws DAOException;
	
	 

	public void insertAlarmSetting(String id, Boolean post, Boolean comment, Boolean community, Boolean warning)  throws DAOException;
	
	 
	}
