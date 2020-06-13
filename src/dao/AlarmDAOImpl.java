package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.AlarmDTO;



public class AlarmDAOImpl extends BaseDAO implements AlarmDAO {
	private final static String GET_ALARM_SQL = "SELECT * from alarm_tb ORDER BY activity_date DESC";
	private final static String GET_ALARM_BY_DATE_SQL = "SELECT * FROM alarm_tb WHERE activity_date >= TO_DATE(?,'YYYYMMDDHH24MISS') AND activity_date <= TO_DATE(?,'YYYYMMDDHH24MISS') ORDER BY activity_date DESC";
	private final static String GET_ALARM_BY_SINCE_DATE_SQL = "SELECT * FROM alarm_tb WHERE activity_date >= TO_DATE(?,'YYYYMMDDHH24MISS') AND activity_date <= sysdate ORDER BY activity_date DESC";
	private final static String GET_ALARM_BY_SINCE_DAY_SQL = "SELECT * FROM alarm_tb WHERE activity_date >= sysdate-? AND activity_date <= sysdate ORDER BY activity_date DESC";
	private final static String GET_ALARM_BY_NUM_SQL = "SELECT * FROM alarm_tb WHERE alarm_no = ?";
	private final static String GET_ALARM_BY_CHECK_SQL = "SELECT * FROM alarm_tb WHERE check_alarm=? ORDER BY activity_date DESC";
	private final static String GET_ALARM_BY_RECEIVER_ID_SQL = "SELECT * FROM alarm_tb WHERE receiver_id =? ORDER BY activity_date DESC";
	private final static String GET_ALARM_BY_ID_CHECK_SQL = "SELECT * FROM alarm_tb WHERE receiver_id =? AND check_alarm =? ORDER BY activity_date DESC";
	private final static String GET_ALARM_BY_ID_ACTIVITYNUM_SQL = "SELECT * FROM alarm_tb WHERE receiver_id =? AND activity_no=? ORDER BY activity_date DESC";
	private final static String UPDATE_ALARM_SQL = "UPDATE alarm_tb SET check_alarm= ? WHERE alarm_no = ?";
	private final static String DELETE_ALARM_SQL = "DELETE alarm_tb WHERE alarm_no =?";
	private final static String DELETE_ALARM_BY_DATE_SQL = "DELETE alarm_tb WHERE activity_date <= sysdate-?";
	private final static String DELETE_ALARM_BY_CHECK_SQL = "DELETE alarm_tb WHERE check_alarm =?";
	private final static String DELETE_ALARM_BY_RECEIVER_ID_SQL = "DELETE alarm_tb WHERE receiver_id =?";
	private final static String DELETE_ALARM_BY_SENDER_ID_SQL = "DELETE alarm_tb WHERE id =?";
	private final static String DELETE_ALARM_BY_SENDER_RECEIVER_ID_SQL = "DELETE alarm_tb WHERE id =? AND receiver_id =?";
	private final static String DELETE_ALARM_BY_SENDER_RECEIVER_ACTNUM_SQL = "DELETE alarm_tb WHERE id =? AND receiver_id =? AND activity_no = ?";
	private final static String INSERT_ALARM_SQL = "INSERT INTO alarm_tb VALUES(alarm_seq.NEXTVAL,sysdate,?,?,?,?)";
	@Override
	public List<AlarmDTO> getAlarm() throws DAOException {
		// TODO Auto-generated method stub
		List<AlarmDTO> alarmDTOs = new ArrayList<AlarmDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_ALARM_SQL );
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				AlarmDTO alarmDTO = new AlarmDTO();
				alarmDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				alarmDTO.setActivityDate(resultSet.getString("activity_date"));
				alarmDTO.setCheckAlarm(resultSet.getInt("check_alarm"));
				alarmDTO.setReceiverId(resultSet.getString("receiver_id"));
				alarmDTO.setActivityNo(resultSet.getInt("activity_no"));
				alarmDTO.setId(resultSet.getString("id"));
			
				alarmDTOs.add(alarmDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting AlarmDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return alarmDTOs;
	}
	@Override
	public List<AlarmDTO> getAlarmByDate(String startDate, String lastDate)
			throws DAOException {
		// TODO Auto-generated method stub
		List<AlarmDTO> alarmDTOs = new ArrayList<AlarmDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_ALARM_BY_DATE_SQL );
			pStatement.setString(1,startDate);
			pStatement.setString(2,lastDate);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				AlarmDTO alarmDTO = new AlarmDTO();
				alarmDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				alarmDTO.setActivityDate(resultSet.getString("activity_date"));
				alarmDTO.setCheckAlarm(resultSet.getInt("check_alarm"));
				alarmDTO.setReceiverId(resultSet.getString("receiver_id"));
				alarmDTO.setActivityNo(resultSet.getInt("activity_no"));
				alarmDTO.setId(resultSet.getString("id"));
				alarmDTOs.add(alarmDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting AlarmDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return alarmDTOs;
	}
	@Override
	public List<AlarmDTO> getAlarmBySinceDate(String beforeDate)
			throws DAOException {
		// TODO Auto-generated method stub
		List<AlarmDTO> alarmDTOs = new ArrayList<AlarmDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_ALARM_BY_SINCE_DATE_SQL );
			pStatement.setString(1,beforeDate);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				AlarmDTO alarmDTO = new AlarmDTO();
				alarmDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				alarmDTO.setActivityDate(resultSet.getString("activity_date"));
				alarmDTO.setCheckAlarm(resultSet.getInt("check_alarm"));
				alarmDTO.setReceiverId(resultSet.getString("receiver_id"));
				alarmDTO.setActivityNo(resultSet.getInt("activity_no"));
				alarmDTO.setId(resultSet.getString("id"));
				alarmDTOs.add(alarmDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting AlarmDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return alarmDTOs;
	}
	@Override
	public List<AlarmDTO> getAlarmBySinceDay(Integer beforeDay)
			throws DAOException {
		// TODO Auto-generated method stub
		List<AlarmDTO> alarmDTOs = new ArrayList<AlarmDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_ALARM_BY_SINCE_DAY_SQL  );
			pStatement.setInt(1,beforeDay);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				AlarmDTO alarmDTO = new AlarmDTO();
				alarmDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				alarmDTO.setActivityDate(resultSet.getString("activity_date"));
				alarmDTO.setCheckAlarm(resultSet.getInt("check_alarm"));
				alarmDTO.setReceiverId(resultSet.getString("receiver_id"));
				alarmDTO.setActivityNo(resultSet.getInt("activity_no"));
				alarmDTO.setId(resultSet.getString("id"));
				alarmDTOs.add(alarmDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting AlarmDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return alarmDTOs;
	}
	@Override
	public AlarmDTO getAlarmByNum(Integer alarmNum) throws DAOException {
		// TODO Auto-generated method stub


		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		AlarmDTO alarmDTO=null;
		try{
			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_ALARM_BY_NUM_SQL );
			pStatement.setInt(1,alarmNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				alarmDTO = new AlarmDTO();
				alarmDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				alarmDTO.setActivityDate(resultSet.getString("activity_date"));
				alarmDTO.setCheckAlarm(resultSet.getInt("check_alarm"));
				alarmDTO.setReceiverId(resultSet.getString("receiver_id"));
				alarmDTO.setActivityNo(resultSet.getInt("activity_no"));
				alarmDTO.setId(resultSet.getString("id"));
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting alarmDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return alarmDTO;

	}
	@Override
	public List<AlarmDTO> getAlarmByCheck(Integer check) throws DAOException {
		// TODO Auto-generated method stub

		List<AlarmDTO> alarmDTOs = new ArrayList<AlarmDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_ALARM_BY_CHECK_SQL );
			pStatement.setInt(1,check);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				AlarmDTO alarmDTO = new AlarmDTO();
				alarmDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				alarmDTO.setActivityDate(resultSet.getString("activity_date"));
				alarmDTO.setCheckAlarm(resultSet.getInt("check_alarm"));
				alarmDTO.setReceiverId(resultSet.getString("receiver_id"));
				alarmDTO.setActivityNo(resultSet.getInt("activity_no"));
				alarmDTO.setId(resultSet.getString("id"));
				alarmDTOs.add(alarmDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting AlarmDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return alarmDTOs;

	}
	@Override
	public List<AlarmDTO> getAlarmByReceiverId(String receiverId)
			throws DAOException {
		// TODO Auto-generated method stub

		List<AlarmDTO> alarmDTOs = new ArrayList<AlarmDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_ALARM_BY_RECEIVER_ID_SQL );
			pStatement.setString(1,receiverId);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				AlarmDTO alarmDTO = new AlarmDTO();
				alarmDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				alarmDTO.setActivityDate(resultSet.getString("activity_date"));
				alarmDTO.setCheckAlarm(resultSet.getInt("check_alarm"));
				alarmDTO.setReceiverId(resultSet.getString("receiver_id"));
				alarmDTO.setActivityNo(resultSet.getInt("activity_no"));
				alarmDTO.setId(resultSet.getString("id"));
				alarmDTOs.add(alarmDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting AlarmDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return alarmDTOs;

	}
	@Override
	public List<AlarmDTO> getAlarmByReceiverIdAndCheck(String receiverId,
			Integer check) throws DAOException {
		// TODO Auto-generated method stub

		List<AlarmDTO> alarmDTOs = new ArrayList<AlarmDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_ALARM_BY_ID_CHECK_SQL );
			pStatement.setString(1,receiverId);
			pStatement.setInt(2,check);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				AlarmDTO alarmDTO = new AlarmDTO();
				alarmDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				alarmDTO.setActivityDate(resultSet.getString("activity_date"));
				alarmDTO.setCheckAlarm(resultSet.getInt("check_alarm"));
				alarmDTO.setReceiverId(resultSet.getString("receiver_id"));
				alarmDTO.setActivityNo(resultSet.getInt("activity_no"));
				alarmDTO.setId(resultSet.getString("id"));
				alarmDTOs.add(alarmDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting AlarmDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return alarmDTOs;

	}
	@Override
	public List<AlarmDTO> getAlarmByReceiverIdActNum(String receiverId,
			Integer activityNum) throws DAOException {
		// TODO Auto-generated method stub

		List<AlarmDTO> alarmDTOs = new ArrayList<AlarmDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_ALARM_BY_ID_ACTIVITYNUM_SQL );
			
			pStatement.setString(1,receiverId);
			pStatement.setInt(2,activityNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				AlarmDTO alarmDTO = new AlarmDTO();
				alarmDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				alarmDTO.setActivityDate(resultSet.getString("activity_date"));
				alarmDTO.setCheckAlarm(resultSet.getInt("check_alarm"));
				alarmDTO.setReceiverId(resultSet.getString("receiver_id"));
				alarmDTO.setActivityNo(resultSet.getInt("activity_no"));
				alarmDTO.setId(resultSet.getString("id"));
				alarmDTOs.add(alarmDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting AlarmDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return alarmDTOs;

	}
	@Override
	public void updateCheckAlarm(Integer check, Integer alarmNum)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		System.out.println("check : "+check+"/alarmNo : "+alarmNum);
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_ALARM_SQL );
		
			pStatement.setInt(1, check);
			pStatement.setInt(2, alarmNum);
		    pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error updating alarmDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}
		
	}
	@Override
	public void deleteAlarm(Integer alarmNum) throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_ALARM_SQL );
			pStatement.setInt(1, alarmNum);
			pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error deleting alarmDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}	
	}
	@Override
	public void deleteAlarmByBeforeDate(Integer beforeDate) throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_ALARM_BY_DATE_SQL );
			pStatement.setInt(1, beforeDate);
			pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error deleting alarmDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}	
	}
	@Override
	public void deleteAlarmByCheck(Integer check) throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_ALARM_BY_CHECK_SQL );
			pStatement.setInt(1, check);
			pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error deleting alarmDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}	
	}
	@Override
	public void deleteAlarmByReceiverId(String receiverId) throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_ALARM_BY_RECEIVER_ID_SQL );
			pStatement.setString(1, receiverId);
			pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error deleting alarmDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}	
	}
	@Override
	public void deleteAlarmBySenderId(String senderId) throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_ALARM_BY_SENDER_ID_SQL );
			pStatement.setString(1, senderId);
			pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error deleting alarmDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}	
	}
	@Override
	public void deleteAlarmBySenderAndReceiver(String senderId,
			String receiverId) throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_ALARM_BY_SENDER_RECEIVER_ID_SQL );
			pStatement.setString(1, senderId);
			pStatement.setString(2, receiverId);
			pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error deleting alarmDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}	
	}
	@Override
	public void deleteAlarmBySenderAndReceiverAndActNum(String senderId,
			String receiverId, Integer activityNum) throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_ALARM_BY_SENDER_RECEIVER_ACTNUM_SQL );
			pStatement.setString(1, senderId);
			pStatement.setString(2, receiverId);
			pStatement.setInt(3, activityNum);
			pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error deleting alarmDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}	
	}
	@Override
	public Integer insertAlarm(Integer check, String receiverId,
			Integer activityNum, String id) throws DAOException {
		// TODO Auto-generated method stub
		int num =0;
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement pStatement = null;
		PreparedStatement pStatement2 = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(INSERT_ALARM_SQL );
			pStatement.setInt(1, check);
			pStatement.setString(2,receiverId);
			pStatement.setInt(3, activityNum);
			pStatement.setString(4,id);
		    pStatement.executeUpdate();

		     pStatement2 = connection.prepareStatement("SELECT alarm_seq.CURRVAL from dual");
	         resultSet= pStatement2.executeQuery();
	   
	         while(resultSet.next()){            
	            num= resultSet.getInt("CURRVAL");
	         }
		}catch(Exception e)
		{
			throw new DAOException("Error inserting alarmDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}
		return num;
	}
}