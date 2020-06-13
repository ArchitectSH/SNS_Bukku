package dao ;

import java.util.List;

import dto.MyPageAlarmDTO;

public interface MyPageAlarmDAO extends DAO{
	public List<MyPageAlarmDTO> getMyPageAlarm()  throws DAOException;
		
	 
	
	public List<MyPageAlarmDTO> getMyPageAlarmByDate(String startDate, String lastDate)  throws DAOException;
	
	 
	
	public List<MyPageAlarmDTO> getMyPageAlarmBySinceDate(String beforeDate)  throws DAOException;
	
	 
	
	public List<MyPageAlarmDTO> getMyPageAlarmBySinceDay(Integer beforeDay)  throws DAOException;
	
	 
	
	public List<MyPageAlarmDTO> getMyPageAlarmByTitle(String myPageTitle)  throws DAOException;
	
	 
	
	public MyPageAlarmDTO getMyPageAlarmByAlarmNum(Integer alarmNum)  throws DAOException;
	
	 
	
	public void deleteMyPageAlarmByAlarmNum(Integer alarmNum)  throws DAOException;
	
	 
	
	public void deleteMyPageAlarmByTitle(String myPageTitle)  throws DAOException;
	
	 
	
	public void insertMyPageAlarm(Integer alarmNum, String myPageTitle)  throws DAOException;
	
	 
	}
