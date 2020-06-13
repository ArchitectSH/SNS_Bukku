package dao;

import java.util.List;

import dto.PostAlarmDTO;

public interface PostAlarmDAO extends DAO{
	public List<PostAlarmDTO> getPostAlarm()  throws DAOException;	
	public List<PostAlarmDTO> getPostAlarmByDate(String startDate, String lastDate)  throws DAOException;
	public List<PostAlarmDTO> getPostAlarmBySinceDate(String beforeDate)  throws DAOException;
	public List<PostAlarmDTO> getPostAlarmBySinceDay(Integer beforeDay)  throws DAOException;
	public PostAlarmDTO getPostAlarmByAlarmNum(Integer alarmNum)  throws DAOException;	
	public List<PostAlarmDTO> getPostAlarmByPostNum(Integer postNum)  throws DAOException;	 
	public void deletePostAlarmByAlarmNum(Integer alarmNum)  throws DAOException;	
	public void deletePostAlarmByPostNum(Integer postNum)  throws DAOException;		
	public void insertPostAlarm(Integer alarmNum, Integer postNum)  throws DAOException;
}
