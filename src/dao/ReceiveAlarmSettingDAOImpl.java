package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.ReceiveAlarmSettingDTO;



public class ReceiveAlarmSettingDAOImpl extends BaseDAO implements ReceiveAlarmSettingDAO {
	private final static String GET_ALARM_SETTING_SQL = "SELECT * FROM receive_alarm_setting_tb";
	private final static String GET_ALARM_SETTING_BY_ID_SQL = "SELECT * FROM receive_alarm_setting_tb WHERE id=?";
	private final static String UPDATE_ALARM_SETTING_SQL = "UPDATE receive_alarm_setting_tb SET post_receive_alarm = ?, comment_receive_alarm = ?, community_receive_alarm = ?, warning_receive_alarm = ? WHERE id=?";
	private final static String UPDATE_POST_RECEIVE_SQL = "UPDATE receive_alarm_setting_tb SET post_receive_alarm =? WHERE id=";
	private final static String UPDATE_COMMENT_RECEIVE_SQL = "UPDATE receive_alarm_setting_tb SET comment_receive_alarm =? WHERE id=?";
	private final static String UPDATE_COMMUNITY_RECEIVE_SQL = "UPDATE receive_alarm_setting_tb SET community_receive_alarm =? WHERE id=?";
	private final static String UPDATE_WARNING_RECEIVE_SQL = "UPDATE receive_alarm_setting_tb SET warning_receive_alarm =? WHERE id=?";
	private final static String DELETE_ALARM_SETTING_SQL = "DELETE FROM receive_alarm_setting_tb WHERE id=?";
	private final static String INSERT_ALARM_SETTING_SQL = "INSERT INTO receive_alarm_setting_tb VALUES(?,?,?,?,?)";
	@Override
	public List<ReceiveAlarmSettingDTO> getAlarmSetting() throws DAOException {
		// TODO Auto-generated method stub

		List<ReceiveAlarmSettingDTO> receiveAlarmSettingDTOs = new ArrayList<ReceiveAlarmSettingDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_ALARM_SETTING_SQL );
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				ReceiveAlarmSettingDTO receiveAlarmSettingDTO = new ReceiveAlarmSettingDTO();
				receiveAlarmSettingDTO.setId(resultSet.getString("id"));
				receiveAlarmSettingDTO.setPostReceiveAlarm(resultSet.getBoolean("post_receive_alarm"));
				receiveAlarmSettingDTO.setCommentReceiveAlarm(resultSet.getBoolean("comment_receive_alarm"));
				receiveAlarmSettingDTO.setCommunityReceiveAlarm(resultSet.getBoolean("community_receive_alarm"));
				receiveAlarmSettingDTO.setWarningReceiveAlarm(resultSet.getBoolean("warning_receive_alarm"));
				receiveAlarmSettingDTOs.add(receiveAlarmSettingDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting ReceiveAlarmSettingDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return receiveAlarmSettingDTOs;
	}
	@Override
	public ReceiveAlarmSettingDTO getAlarmSettingById(String id)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		ReceiveAlarmSettingDTO receiveAlarmSettingDTO=null;
		try{
			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_ALARM_SETTING_BY_ID_SQL );
			pStatement.setString(1,id);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				receiveAlarmSettingDTO = new ReceiveAlarmSettingDTO();
				receiveAlarmSettingDTO.setId(resultSet.getString("id"));
				receiveAlarmSettingDTO.setPostReceiveAlarm(resultSet.getBoolean("post_receive_alarm"));
				receiveAlarmSettingDTO.setCommentReceiveAlarm(resultSet.getBoolean("comment_receive_alarm"));
				receiveAlarmSettingDTO.setCommunityReceiveAlarm(resultSet.getBoolean("community_receive_alarm"));
				receiveAlarmSettingDTO.setWarningReceiveAlarm(resultSet.getBoolean("warning_receive_alarm"));
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting receiveAlarmSettingDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return receiveAlarmSettingDTO;
	}
	@Override
	public void updateAlarmSetting(Boolean postReceive,Boolean commentReceive, Boolean communityReceive, Boolean warningReceive, String id) throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_ALARM_SETTING_SQL );
			pStatement.setBoolean(1, postReceive);
			pStatement.setBoolean(2, commentReceive);
			pStatement.setBoolean(3, communityReceive);
			pStatement.setBoolean(4, warningReceive);
			pStatement.setString(5, id);
		    pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error updating receiveAlarmSettingDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}
	
	}
	@Override
	public void updatePostReceive(Boolean postReceive, String id)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_POST_RECEIVE_SQL );
		
			pStatement.setBoolean(1, postReceive);
			pStatement.setString(2,id);
		    pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error updating receiveAlarmSettingDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}
	
	}
	@Override
	public void updateCommentReceive(Boolean commentReceive, String id)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_COMMENT_RECEIVE_SQL );
		
			pStatement.setBoolean(1, commentReceive);
			pStatement.setString(2,id);
		    pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error updating receiveAlarmSettingDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}
	
	}
	@Override
	public void updateCommunityReceive(Boolean communityReceive, String id)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_COMMUNITY_RECEIVE_SQL );
		
			pStatement.setBoolean(1, communityReceive);
			pStatement.setString(2,id);
		    pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error updating receiveAlarmSettingDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}
	}
	@Override
	public void updateWarningReceive(Boolean warningReceive, String id)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_WARNING_RECEIVE_SQL  );
		
			pStatement.setBoolean(1, warningReceive);
			pStatement.setString(2,id);
		    pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error updating receiveAlarmSettingDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}
	
	}
	@Override
	public void deleteAlarmSetting(String id) throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_ALARM_SETTING_SQL  );
			pStatement.setString(1, id);
			pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error deleting receiveAlarmSettingDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}	



	
	}
	@Override
	public void insertAlarmSetting(String id, Boolean post, Boolean comment,
			Boolean community, Boolean warning) throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(INSERT_ALARM_SETTING_SQL );
			pStatement.setString(1, id);
			pStatement.setBoolean(2, post);
			pStatement.setBoolean(3, comment);
			pStatement.setBoolean(4, community);
			pStatement.setBoolean(5, warning);
	
		   pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error inserting receiveAlarmSettingDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}

	}
	  /*public static void main(String[] args) {
	      // TODO Auto-generated method stub
	      DependencyInjector injector = new DependencyInjector();
	      try{
	         injector.start();
	         ReceiveAlarmSettingDAO receiveAlarmSettingDAO = (ReceiveAlarmSettingDAO)injector.getObject(ReceiveAlarmSettingDAO.class);
	         
	         try{
	            System.out.println(receiveAlarmSettingDAO.getAlarmSetting());
	            System.out.println("=============================");
	            System.out.println(receiveAlarmSettingDAO.getAlarmSettingById("id1"));
	            System.out.println("=============================");
	            receiveAlarmSettingDAO.updateAlarmSetting(true,false,true,false,"id1");
	            System.out.println("=============================");
	           
	            //productDAO.insert(product);
	         }catch(Exception e){
	            e.printStackTrace();
	         }
	      }finally{
	         injector.shutDown();
	      }

	   }*/
	
}