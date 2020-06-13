package dao;

import java.util.List;

import dto.AlarmDTO;



public interface AlarmDAO extends DAO{
	public List<AlarmDTO> getAlarm() throws DAOException;

	public List<AlarmDTO> getAlarmByDate(String startDate, String lastDate) throws DAOException;

	public List<AlarmDTO> getAlarmBySinceDate(String beforeDate) throws DAOException;

	public List<AlarmDTO> getAlarmBySinceDay(Integer beforeDay) throws DAOException;

	public AlarmDTO getAlarmByNum(Integer alarmNum) throws DAOException;
	

	public List<AlarmDTO> getAlarmByCheck(Integer check) throws DAOException;

	public List<AlarmDTO> getAlarmByReceiverId(String receiverId) throws DAOException;

	public List<AlarmDTO> getAlarmByReceiverIdAndCheck(String receiverId, Integer check) throws DAOException;

	public List<AlarmDTO> getAlarmByReceiverIdActNum(String receiverId, Integer activityNum) throws DAOException;

	
	public void updateCheckAlarm(Integer check, Integer alarmNum) throws DAOException;

	
	public void deleteAlarm(Integer alarmNum) throws DAOException;

	
	public void deleteAlarmByBeforeDate(Integer beforeDate) throws DAOException;

	
	public void deleteAlarmByCheck(Integer check) throws DAOException;

	
	public void deleteAlarmByReceiverId(String receiverId) throws DAOException;

	
	public void deleteAlarmBySenderId(String senderId) throws DAOException;

	public void deleteAlarmBySenderAndReceiver(String senderId, String receiverId) throws DAOException;

	
	public void deleteAlarmBySenderAndReceiverAndActNum(String senderId, String receiverId, Integer activityNum) throws DAOException;

	public Integer insertAlarm(Integer check, String receiverId, Integer activityNum, String id) throws DAOException;

}
