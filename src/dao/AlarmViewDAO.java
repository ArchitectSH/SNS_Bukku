package dao;

import java.util.List;

import dto.AlarmViewDTO;

public interface AlarmViewDAO extends DAO{
	public List<AlarmViewDTO> getAlarmView() throws DAOException;
	
	public List<AlarmViewDTO> getAlarmViewByDate(String startDate, String endDate) throws DAOException;
	
	
	
	public List<AlarmViewDTO> getAlarmViewBySinceDate(String beforeDate) throws DAOException;
	
	
	
	public List<AlarmViewDTO> getAlarmViewBySinceDay(Integer beforeDay) throws DAOException;
	
	
	
	public AlarmViewDTO getAlarmViewByAlarmNo(Integer alarmNo) throws DAOException;
	
	
	
	public List<AlarmViewDTO> getAlarmViewByReceiverIdAndCheck(String receiverId, Integer check) throws DAOException;
	
	
	public List<AlarmViewDTO> getAlarmViewByReceiverId(String receiverId) throws DAOException;
	public List<AlarmViewDTO> getAlarmViewByReceiverIdOrderBukku(String receiverId) throws DAOException;
	
	
	
	public List<AlarmViewDTO> getAlarmViewByReceiverIdAtti(String receiverId) throws DAOException;
	
	
	
	
	
	public List<AlarmViewDTO> getAlarmViewByReceiverIdNotFriend(String receiverId) throws DAOException;
	
	
	}
