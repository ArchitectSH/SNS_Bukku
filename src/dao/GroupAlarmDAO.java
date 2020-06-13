package dao ;

import java.util.List ;

import dto.GroupAlarmDTO ;

public interface GroupAlarmDAO  extends DAO{
	public List<GroupAlarmDTO> getGroupAlarm()  throws DAOException;
		
	 
	
	public List<GroupAlarmDTO> getGroupAlarmByDate(String startDate, String lastDate)  throws DAOException;
	
	 
	
	public List<GroupAlarmDTO> getGroupAlarmBySinceDate(String beforeDate)  throws DAOException;
	
	 
	
	public List<GroupAlarmDTO> getGroupAlarmBySinceDay(Integer beforeDay)  throws DAOException;
	
	 
	
	public GroupAlarmDTO getGroupAlarmByAlarmNum(Integer alarmNum)  throws DAOException;
	
	 
	
	public List<GroupAlarmDTO> getGroupAlarmByGroupNum(Integer groupNum)  throws DAOException;
	
	 
	
	public void deleteGroupAlarmByAlarmNum(Integer alarmNum)  throws DAOException;
	
	 
	
	public void deleteGroupAlarmByGroupNum(Integer groupNum)  throws DAOException;
	
	 
	
	public void insertGroupAlarm(Integer alarmNum, Integer groupNum)  throws DAOException;
	
	 
	}
