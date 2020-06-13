package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.ConfigurationViewDTO;


public class ConfigurationViewDAOImpl extends BaseDAO implements ConfigurationViewDAO {
	private final static String GET_CONFIGURATION_VIEW_SQL = "SELECT * FROM configuration_view";
	private final static String GET_CONFIGURATION_VIEW_BY_USER_ID_SQL = "SELECT * FROM  configuration_view WHERE user_id = ?";
	private final static String GET_CONFIGURATION_VIEW_BY_PRIVACY_LEVEL_SQL = "SELECT * FROM  configuration_view  WHERE privacy_level = ?";
	@Override
	public List<ConfigurationViewDTO> getConfigurationView()
			throws DAOException {
		// TODO Auto-generated method stub
		List<ConfigurationViewDTO> configurationViewDTOs = new ArrayList<ConfigurationViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_CONFIGURATION_VIEW_SQL );
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				ConfigurationViewDTO configurationViewDTO = new ConfigurationViewDTO();
				configurationViewDTO.setUserId(resultSet.getString("user_id"));
				configurationViewDTO.setPrivacyLevel(resultSet.getInt("privacy_level"));
				configurationViewDTO.setPostReceiveAlarm(resultSet.getBoolean("post_receive_alarm"));
				configurationViewDTO.setCommentReceiveAlarm(resultSet.getBoolean("comment_receive_alarm"));
				configurationViewDTO.setCommunityReceiveAlarm(resultSet.getBoolean("community_receive_alarm"));
				configurationViewDTO.setWarningReceiveAlarm(resultSet.getBoolean("warning_receive_alarm"));
				configurationViewDTOs.add(configurationViewDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting ConfigurationViewDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return configurationViewDTOs;
	}
	@Override
	public ConfigurationViewDTO getConfigurationViewByUserId(String userId)
			throws DAOException {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		ConfigurationViewDTO configurationViewDTO=null;
		try{
			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_CONFIGURATION_VIEW_BY_USER_ID_SQL );
			pStatement.setString(1,userId);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				configurationViewDTO = new ConfigurationViewDTO();
				configurationViewDTO.setUserId(resultSet.getString("user_id"));
				configurationViewDTO.setPrivacyLevel(resultSet.getInt("privacy_level"));
				configurationViewDTO.setPostReceiveAlarm(resultSet.getBoolean("post_receive_alarm"));
				configurationViewDTO.setCommentReceiveAlarm(resultSet.getBoolean("comment_receive_alarm"));
				configurationViewDTO.setCommunityReceiveAlarm(resultSet.getBoolean("community_receive_alarm"));
				configurationViewDTO.setWarningReceiveAlarm(resultSet.getBoolean("warning_receive_alarm"));
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting configurationViewDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return configurationViewDTO;

	}
	@Override
	public List<ConfigurationViewDTO> getConfigurationViewByPrivacyLevel(
			Integer privacyLevel) throws DAOException {
		// TODO Auto-generated method stub
		List<ConfigurationViewDTO> configurationViewDTOs = new ArrayList<ConfigurationViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_CONFIGURATION_VIEW_BY_PRIVACY_LEVEL_SQL );
			pStatement.setInt(1,privacyLevel);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				ConfigurationViewDTO configurationViewDTO = new ConfigurationViewDTO();
				configurationViewDTO.setUserId(resultSet.getString("user_id"));
				configurationViewDTO.setPrivacyLevel(resultSet.getInt("privacy_level"));
				configurationViewDTO.setPostReceiveAlarm(resultSet.getBoolean("post_receive_alarm"));
				configurationViewDTO.setCommentReceiveAlarm(resultSet.getBoolean("comment_receive_alarm"));
				configurationViewDTO.setCommunityReceiveAlarm(resultSet.getBoolean("community_receive_alarm"));
				configurationViewDTO.setWarningReceiveAlarm(resultSet.getBoolean("warning_receive_alarm"));
				configurationViewDTOs.add(configurationViewDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting ConfigurationViewDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return configurationViewDTOs;
	}
	/* public static void main(String[] args) {
	      // TODO Auto-generated method stub
	      DependencyInjector injector = new DependencyInjector();
	      try{
	         injector.start();
	         ConfigurationViewDAO configurationViewDAO = (ConfigurationViewDAO)injector.getObject(ConfigurationViewDAO.class);
	         
	         try{
	            System.out.println(configurationViewDAO.getConfigurationView());
	            System.out.println("=============================");
	            System.out.println(configurationViewDAO.getConfigurationViewByPrivacyLevel(1));
	            System.out.println("=============================");
	            System.out.println(configurationViewDAO.getConfigurationViewByUserId("id2"));
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
