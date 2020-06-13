package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.AlarmViewDTO;

public class AlarmViewDAOImpl extends BaseDAO implements AlarmViewDAO {
	private final static String GET_ALARM_VIEW_SQL = "SELECT * FROM alarm_view ORDER BY activity_date DESC";
	private final static String GET_ALARM_VIEW_BY_DATE_SQL = "SELECT * FROM alarm_view WHERE activity_date >= TO_DATE(?,'YYYYMMDDHH24MISS') AND activity_date <= TO_DATE(?,'YYYYMMDDHH24MISS') ORDER BY activity_date DESC";
	private final static String GET_ALARM_VIEW_BY_SINCE_DATE_SQL = "SELECT * FROM alarm_view WHERE activity_date >= TO_DATE(?,'YYYYMMDDHH24MISS') AND activity_date <= sysdate ORDER BY activity_date DESC";
	private final static String GET_ALARM_VIEW_BY_SINCE_DAY_SQL = "SELECT * FROM alarm_view WHERE activity_date >= sysdate-? AND activity_date <= sysdate ORDER BY activity_date DESC";
	private final static String GET_ALARM_VIEW_BY_ALARM_NO_SQL = "SELECT * FROM alarm_view WHERE alarm_no = ?";
	private final static String GET_ALARM_VIEW_BY_RECEIVER_ID_SQL = "SELECT * FROM alarm_view WHERE receiver_id =? ORDER BY activity_date DESC";
	private final static String GET_ALARM_VIEW_BY_RECEIVER_ID_CHECK_SQL = "SELECT * FROM alarm_view WHERE receiver_id =? AND check_alarm =? ORDER BY activity_date DESC";
	private final static String GET_ALARM_VIEW_BY_RECEIVER_ID_ORDER_BUKKU_SQL = "SELECT * FROM alarm_view WHERE receiver_id = ? ORDER BY  (sender_bukku_index + receiver_bukku_index)";
	private final static String GET_ALARM_VIEW_BY_RECEIVER_ID_ATTI_SQL = "SELECT * FROM alarm_view WHERE receiver_id = ? AND ROUND((sender_bukku_index + receiver_bukku_index)/2) < 50";
	private final static String GET_ALARM_VIEW_BY_RECEIVER_ID_NOT_FRIEND_SQL = "SELECT * FROM alarm_view WHERE receiver_id = ? AND (sender_bukku_index IS NULL OR receiver_bukku_index IS NULL)";

	@Override
	public List<AlarmViewDTO> getAlarmView() throws DAOException {
		// TODO Auto-generated method stub

		List<AlarmViewDTO> alarmViewDTOs = new ArrayList<AlarmViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_ALARM_VIEW_SQL );
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				AlarmViewDTO alarmViewDTO = new AlarmViewDTO();
				alarmViewDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				alarmViewDTO.setSenderId(resultSet.getString("sender_id"));
				alarmViewDTO.setSenderName(resultSet.getString("sender_name"));
				alarmViewDTO.setSenderProfileImg(resultSet.getString("sender_profile_img"));
				alarmViewDTO.setSenderBukkuIndex(resultSet.getInt("sender_bukku_index"));
				alarmViewDTO.setActivityKind(resultSet.getString("activity_kind"));
				alarmViewDTO.setReceiverId(resultSet.getString("receiver_id"));
				alarmViewDTO.setReceiverBukkuIndex(resultSet.getInt("receiver_bukku_index"));
				alarmViewDTO.setActivityDate(resultSet.getString("activity_date"));
				alarmViewDTO.setCheckAlarm(resultSet.getInt("check_alarm"));
				alarmViewDTO.setPostNo(resultSet.getInt("post_no"));
				alarmViewDTO.setGroupNo(resultSet.getInt("group_no"));
				alarmViewDTO.setMypageTitle(resultSet.getString("mypage_title"));
				
				alarmViewDTOs.add(alarmViewDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting AlarmViewDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return alarmViewDTOs;

	}
	@Override
	public List<AlarmViewDTO> getAlarmViewByDate(String startDate,
			String endDate) throws DAOException {
		// TODO Auto-generated method stub

		List<AlarmViewDTO> alarmViewDTOs = new ArrayList<AlarmViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_ALARM_VIEW_BY_DATE_SQL );
			pStatement.setString(1,startDate);
			pStatement.setString(2,endDate);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				AlarmViewDTO alarmViewDTO = new AlarmViewDTO();
				alarmViewDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				alarmViewDTO.setSenderId(resultSet.getString("sender_id"));
				alarmViewDTO.setSenderName(resultSet.getString("sender_name"));
				alarmViewDTO.setSenderProfileImg(resultSet.getString("sender_profile_img"));
				alarmViewDTO.setSenderBukkuIndex(resultSet.getInt("sender_bukku_index"));
				alarmViewDTO.setActivityKind(resultSet.getString("activity_kind"));
				alarmViewDTO.setReceiverId(resultSet.getString("receiver_id"));
				alarmViewDTO.setReceiverBukkuIndex(resultSet.getInt("receiver_bukku_index"));
				alarmViewDTO.setActivityDate(resultSet.getString("activity_date"));
				alarmViewDTO.setCheckAlarm(resultSet.getInt("check_alarm"));
				alarmViewDTO.setPostNo(resultSet.getInt("post_no"));
				alarmViewDTO.setGroupNo(resultSet.getInt("group_no"));
				alarmViewDTO.setMypageTitle(resultSet.getString("mypage_title"));
				alarmViewDTOs.add(alarmViewDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting AlarmViewDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return alarmViewDTOs;
	}
	@Override
	public List<AlarmViewDTO> getAlarmViewBySinceDate(String beforeDate)
			throws DAOException {
		// TODO Auto-generated method stub

		List<AlarmViewDTO> alarmViewDTOs = new ArrayList<AlarmViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_ALARM_VIEW_BY_SINCE_DATE_SQL );
			pStatement.setString(1,beforeDate);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				AlarmViewDTO alarmViewDTO = new AlarmViewDTO();
				alarmViewDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				alarmViewDTO.setSenderId(resultSet.getString("sender_id"));
				alarmViewDTO.setSenderName(resultSet.getString("sender_name"));
				alarmViewDTO.setSenderProfileImg(resultSet.getString("sender_profile_img"));
				alarmViewDTO.setSenderBukkuIndex(resultSet.getInt("sender_bukku_index"));
				alarmViewDTO.setActivityKind(resultSet.getString("activity_kind"));
				alarmViewDTO.setReceiverId(resultSet.getString("receiver_id"));
				alarmViewDTO.setReceiverBukkuIndex(resultSet.getInt("receiver_bukku_index"));
				alarmViewDTO.setActivityDate(resultSet.getString("activity_date"));
				alarmViewDTO.setCheckAlarm(resultSet.getInt("check_alarm"));
				alarmViewDTO.setPostNo(resultSet.getInt("post_no"));
				alarmViewDTO.setGroupNo(resultSet.getInt("group_no"));
				alarmViewDTO.setMypageTitle(resultSet.getString("mypage_title"));
				alarmViewDTOs.add(alarmViewDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting AlarmViewDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return alarmViewDTOs;
	}
	@Override
	public List<AlarmViewDTO> getAlarmViewBySinceDay(Integer beforeDay)
			throws DAOException {
		// TODO Auto-generated method stub

		List<AlarmViewDTO> alarmViewDTOs = new ArrayList<AlarmViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_ALARM_VIEW_BY_SINCE_DAY_SQL );
			pStatement.setInt(1,beforeDay);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				AlarmViewDTO alarmViewDTO = new AlarmViewDTO();
				alarmViewDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				alarmViewDTO.setSenderId(resultSet.getString("sender_id"));
				alarmViewDTO.setSenderName(resultSet.getString("sender_name"));
				alarmViewDTO.setSenderProfileImg(resultSet.getString("sender_profile_img"));
				alarmViewDTO.setSenderBukkuIndex(resultSet.getInt("sender_bukku_index"));
				alarmViewDTO.setActivityKind(resultSet.getString("activity_kind"));
				alarmViewDTO.setReceiverId(resultSet.getString("receiver_id"));
				alarmViewDTO.setReceiverBukkuIndex(resultSet.getInt("receiver_bukku_index"));
				alarmViewDTO.setActivityDate(resultSet.getString("activity_date"));
				alarmViewDTO.setCheckAlarm(resultSet.getInt("check_alarm"));
				alarmViewDTO.setPostNo(resultSet.getInt("post_no"));
				alarmViewDTO.setGroupNo(resultSet.getInt("group_no"));
				alarmViewDTO.setMypageTitle(resultSet.getString("mypage_title"));
				alarmViewDTOs.add(alarmViewDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting AlarmViewDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return alarmViewDTOs;
	}
	@Override
	public AlarmViewDTO getAlarmViewByAlarmNo(Integer alarmNo)
			throws DAOException {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		AlarmViewDTO alarmViewDTO=null;
		try{
			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_ALARM_VIEW_BY_ALARM_NO_SQL );
			pStatement.setInt(1,alarmNo);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				alarmViewDTO = new AlarmViewDTO();
				alarmViewDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				alarmViewDTO.setSenderId(resultSet.getString("sender_id"));
				alarmViewDTO.setSenderName(resultSet.getString("sender_name"));
				alarmViewDTO.setSenderProfileImg(resultSet.getString("sender_profile_img"));
				alarmViewDTO.setSenderBukkuIndex(resultSet.getInt("sender_bukku_index"));
				alarmViewDTO.setActivityKind(resultSet.getString("activity_kind"));
				alarmViewDTO.setReceiverId(resultSet.getString("receiver_id"));
				alarmViewDTO.setReceiverBukkuIndex(resultSet.getInt("receiver_bukku_index"));
				alarmViewDTO.setActivityDate(resultSet.getString("activity_date"));
				alarmViewDTO.setCheckAlarm(resultSet.getInt("check_alarm"));
				alarmViewDTO.setPostNo(resultSet.getInt("post_no"));
				alarmViewDTO.setGroupNo(resultSet.getInt("group_no"));
				alarmViewDTO.setMypageTitle(resultSet.getString("mypage_title"));
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting alarmViewDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return alarmViewDTO;
	}
	@Override
	public List<AlarmViewDTO> getAlarmViewByReceiverIdAndCheck(
			String receiverId, Integer check) throws DAOException {
		// TODO Auto-generated method stub
		List<AlarmViewDTO> alarmViewDTOs = new ArrayList<AlarmViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_ALARM_VIEW_BY_RECEIVER_ID_CHECK_SQL );
			pStatement.setString(1,receiverId);
			pStatement.setInt(2,check);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				AlarmViewDTO alarmViewDTO = new AlarmViewDTO();
				alarmViewDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				alarmViewDTO.setSenderId(resultSet.getString("sender_id"));
				alarmViewDTO.setSenderName(resultSet.getString("sender_name"));
				alarmViewDTO.setSenderProfileImg(resultSet.getString("sender_profile_img"));
				alarmViewDTO.setSenderBukkuIndex(resultSet.getInt("sender_bukku_index"));
				alarmViewDTO.setActivityKind(resultSet.getString("activity_kind"));
				alarmViewDTO.setReceiverId(resultSet.getString("receiver_id"));
				alarmViewDTO.setReceiverBukkuIndex(resultSet.getInt("receiver_bukku_index"));
				alarmViewDTO.setActivityDate(resultSet.getString("activity_date"));
				alarmViewDTO.setCheckAlarm(resultSet.getInt("check_alarm"));
				alarmViewDTO.setPostNo(resultSet.getInt("post_no"));
				alarmViewDTO.setGroupNo(resultSet.getInt("group_no"));
				alarmViewDTO.setMypageTitle(resultSet.getString("mypage_title"));
				alarmViewDTOs.add(alarmViewDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting AlarmViewDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return alarmViewDTOs;
	}
	@Override
	public List<AlarmViewDTO> getAlarmViewByReceiverIdOrderBukku(
			String receiverId) throws DAOException {
		// TODO Auto-generated method stub

		List<AlarmViewDTO> alarmViewDTOs = new ArrayList<AlarmViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_ALARM_VIEW_BY_RECEIVER_ID_ORDER_BUKKU_SQL );
			pStatement.setString(1,receiverId);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				AlarmViewDTO alarmViewDTO = new AlarmViewDTO();
				alarmViewDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				alarmViewDTO.setSenderId(resultSet.getString("sender_id"));
				alarmViewDTO.setSenderName(resultSet.getString("sender_name"));
				alarmViewDTO.setSenderProfileImg(resultSet.getString("sender_profile_img"));
				alarmViewDTO.setSenderBukkuIndex(resultSet.getInt("sender_bukku_index"));
				alarmViewDTO.setActivityKind(resultSet.getString("activity_kind"));
				alarmViewDTO.setReceiverId(resultSet.getString("receiver_id"));
				alarmViewDTO.setReceiverBukkuIndex(resultSet.getInt("receiver_bukku_index"));
				alarmViewDTO.setActivityDate(resultSet.getString("activity_date"));
				alarmViewDTO.setCheckAlarm(resultSet.getInt("check_alarm"));
				alarmViewDTO.setPostNo(resultSet.getInt("post_no"));
				alarmViewDTO.setGroupNo(resultSet.getInt("group_no"));
				alarmViewDTO.setMypageTitle(resultSet.getString("mypage_title"));
				alarmViewDTOs.add(alarmViewDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting AlarmViewDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return alarmViewDTOs;
	}
	@Override
	public List<AlarmViewDTO> getAlarmViewByReceiverIdAtti(String receiverId)
			throws DAOException {
		// TODO Auto-generated method stub

		List<AlarmViewDTO> alarmViewDTOs = new ArrayList<AlarmViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_ALARM_VIEW_BY_RECEIVER_ID_ATTI_SQL  );
			pStatement.setString(1,receiverId);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				AlarmViewDTO alarmViewDTO = new AlarmViewDTO();
				alarmViewDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				alarmViewDTO.setSenderId(resultSet.getString("sender_id"));
				alarmViewDTO.setSenderName(resultSet.getString("sender_name"));
				alarmViewDTO.setSenderProfileImg(resultSet.getString("sender_profile_img"));
				alarmViewDTO.setSenderBukkuIndex(resultSet.getInt("sender_bukku_index"));
				alarmViewDTO.setActivityKind(resultSet.getString("activity_kind"));
				alarmViewDTO.setReceiverId(resultSet.getString("receiver_id"));
				alarmViewDTO.setReceiverBukkuIndex(resultSet.getInt("receiver_bukku_index"));
				alarmViewDTO.setActivityDate(resultSet.getString("activity_date"));
				alarmViewDTO.setCheckAlarm(resultSet.getInt("check_alarm"));
				alarmViewDTO.setPostNo(resultSet.getInt("post_no"));
				alarmViewDTO.setGroupNo(resultSet.getInt("group_no"));
				alarmViewDTO.setMypageTitle(resultSet.getString("mypage_title"));
				alarmViewDTOs.add(alarmViewDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting AlarmViewDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return alarmViewDTOs;
	}
	@Override
	public List<AlarmViewDTO> getAlarmViewByReceiverIdNotFriend(
			String receiverId) throws DAOException {
		// TODO Auto-generated method stub

		List<AlarmViewDTO> alarmViewDTOs = new ArrayList<AlarmViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_ALARM_VIEW_BY_RECEIVER_ID_NOT_FRIEND_SQL );
			pStatement.setString(1,receiverId);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				AlarmViewDTO alarmViewDTO = new AlarmViewDTO();
				alarmViewDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				alarmViewDTO.setSenderId(resultSet.getString("sender_id"));
				alarmViewDTO.setSenderName(resultSet.getString("sender_name"));
				alarmViewDTO.setSenderProfileImg(resultSet.getString("sender_profile_img"));
				alarmViewDTO.setSenderBukkuIndex(resultSet.getInt("sender_bukku_index"));
				alarmViewDTO.setActivityKind(resultSet.getString("activity_kind"));
				alarmViewDTO.setReceiverId(resultSet.getString("receiver_id"));
				alarmViewDTO.setReceiverBukkuIndex(resultSet.getInt("receiver_bukku_index"));
				alarmViewDTO.setActivityDate(resultSet.getString("activity_date"));
				alarmViewDTO.setCheckAlarm(resultSet.getInt("check_alarm"));
				alarmViewDTO.setPostNo(resultSet.getInt("post_no"));
				alarmViewDTO.setGroupNo(resultSet.getInt("group_no"));
				alarmViewDTO.setMypageTitle(resultSet.getString("mypage_title"));
				alarmViewDTOs.add(alarmViewDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting AlarmViewDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return alarmViewDTOs;
	}
	  
	@Override
	public List<AlarmViewDTO> getAlarmViewByReceiverId(String receiverId)
			throws DAOException {
		// TODO Auto-generated method stub
		List<AlarmViewDTO> alarmViewDTOs = new ArrayList<AlarmViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_ALARM_VIEW_BY_RECEIVER_ID_SQL );
			pStatement.setString(1,receiverId);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				AlarmViewDTO alarmViewDTO = new AlarmViewDTO();
				alarmViewDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				alarmViewDTO.setSenderId(resultSet.getString("sender_id"));
				alarmViewDTO.setSenderName(resultSet.getString("sender_name"));
				alarmViewDTO.setSenderProfileImg(resultSet.getString("sender_profile_img"));
				alarmViewDTO.setSenderBukkuIndex(resultSet.getInt("sender_bukku_index"));
				alarmViewDTO.setActivityKind(resultSet.getString("activity_kind"));
				alarmViewDTO.setReceiverId(resultSet.getString("receiver_id"));
				alarmViewDTO.setReceiverBukkuIndex(resultSet.getInt("receiver_bukku_index"));
				alarmViewDTO.setActivityDate(resultSet.getString("activity_date"));
				alarmViewDTO.setCheckAlarm(resultSet.getInt("check_alarm"));
				alarmViewDTO.setPostNo(resultSet.getInt("post_no"));
				alarmViewDTO.setGroupNo(resultSet.getInt("group_no"));
				alarmViewDTO.setMypageTitle(resultSet.getString("mypage_title"));
				alarmViewDTOs.add(alarmViewDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting AlarmViewDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return alarmViewDTOs;
	}

}