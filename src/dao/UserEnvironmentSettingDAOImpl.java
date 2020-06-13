package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.UserEnvironmentSettingDTO;



public class UserEnvironmentSettingDAOImpl extends BaseDAO implements UserEnvironmentSettingDAO {
	private final static String GET_USER_SETTING_SQL = "SELECT * FROM user_environment_setting_tb";
	private final static String GET_USER_SETTING_BY_ID_SQL = "SELECT * FROM user_environment_setting_tb WHERE id=?";
	private final static String UPDATE_USER_SETTING_SQL = "UPDATE user_environment_setting_tb SET privacy_level = ?, deactivation = ?, user_stop = ? WHERE id=?";
	private final static String UPDATE_SEARCH_PRIVACY_SQL = "UPDATE user_environment_setting_tb SET privacy_level = ? WHERE id=?";
	private final static String UPDATE_DEACTIVATION_SQL = "UPDATE user_environment_setting_tb SET deactivation = ? WHERE id=?";
	private final static String UPDATE_USER_STOP_SQL = "UPDATE user_environment_setting_tb SET user_stop = ? WHERE id=?";
	private final static String DELETE_USER_SETTING_SQL = "DELETE FROM user_environment_setting_tb WHERE id=?";
	private final static String INSERT_USER_SETTING_SQL = "INSERT INTO user_environment_setting_tb VALUES(?,?,?,?)";
	@Override
	public List<UserEnvironmentSettingDTO> getUserSetting() throws DAOException {
		// TODO Auto-generated method stub
		List<UserEnvironmentSettingDTO> userEnvironmentSettingDTOs = new ArrayList<UserEnvironmentSettingDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_USER_SETTING_SQL );
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				UserEnvironmentSettingDTO userEnvironmentSettingDTO = new UserEnvironmentSettingDTO();
				userEnvironmentSettingDTO.setId(resultSet.getString("id"));
				userEnvironmentSettingDTO.setPrivacyLevel(resultSet.getInt("privacy_level"));
				userEnvironmentSettingDTO.setDeactivation(resultSet.getBoolean("deactivation"));
				userEnvironmentSettingDTO.setUserStop(resultSet.getBoolean("user_stop"));
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting UserEnvironmentSettingDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return userEnvironmentSettingDTOs;
	}
	@Override
	public UserEnvironmentSettingDTO getUserSettingById(String id)
			throws DAOException {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		UserEnvironmentSettingDTO userEnvironmentSettingDTO=null;
		try{
			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_USER_SETTING_BY_ID_SQL );
			pStatement.setString(1,id);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				userEnvironmentSettingDTO = new UserEnvironmentSettingDTO();
				userEnvironmentSettingDTO.setId(resultSet.getString("id"));
				userEnvironmentSettingDTO.setPrivacyLevel(resultSet.getInt("privacy_level"));
				userEnvironmentSettingDTO.setDeactivation(resultSet.getBoolean("deactivation"));
				userEnvironmentSettingDTO.setUserStop(resultSet.getBoolean("user_stop"));
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting userEnvironmentSettingDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return userEnvironmentSettingDTO;
	}
	@Override
	public void updateUserSetting(Integer privacy,Boolean deactivation,
			Boolean userStop, String id) throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_USER_SETTING_SQL );
		
			pStatement.setInt(1, privacy);
			pStatement.setBoolean(2, deactivation);
			pStatement.setBoolean(3, userStop);
			pStatement.setString(4, id);
		    pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error updating userEnvironmentSettingDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}
	
	}
	@Override
	public void updateSearchPrivacy(Integer privacyLevel, String id)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_SEARCH_PRIVACY_SQL );
		
			pStatement.setInt(1, privacyLevel);
			pStatement.setString(2, id);
		    pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error updating userEnvironmentSettingDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}
	
	}
	@Override
	public void updateDeactivation(Boolean deactivation, String id)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_DEACTIVATION_SQL );
		
			pStatement.setBoolean(1, deactivation);
			pStatement.setString(2, id);
		    pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error updating userEnvironmentSettingDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}
	
	}
	@Override
	public void updateUserStop(Boolean userStop, String id) throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_USER_STOP_SQL );
		
			pStatement.setBoolean(1, userStop);
			pStatement.setString(2, id);
		    pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error updating userEnvironmentSettingDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}
	
	}
	@Override
	public void deleteUserSetting(String id) throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_USER_SETTING_SQL );
			pStatement.setString(1, id);
			pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error deleting userEnvironmentSettingDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}	


	}
	@Override
	public void insertUserSetting(String id, Integer searchPrivacy,
			Boolean deactivation, Boolean userStop) throws DAOException {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(INSERT_USER_SETTING_SQL );
			pStatement.setString(1, id);
			pStatement.setInt(2,searchPrivacy);
			pStatement.setBoolean(3,deactivation);
			pStatement.setBoolean(4,userStop);
			
		   pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error inserting userEnvironmentSettingDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}
	}
	
	/*public static void main(String[] args) {
	      // TODO Auto-generated method stub
	      DependencyInjector injector = new DependencyInjector();
	      try{
	         injector.start();
	         UserEnvironmentSettingDAOImpl userEnvironmentSettingDAOImpl = (UserEnvironmentSettingDAOImpl)injector.getObject(UserEnvironmentSettingDAO.class);
	         
	         try{
	      
	            System.out.println(userEnvironmentSettingDAOImpl.getUserSetting());
	            System.out.println("=============================");
	            System.out.println(userEnvironmentSettingDAOImpl.getUserSettingById("id1"));
	            System.out.println("=============================");
	            userEnvironmentSettingDAOImpl.updateUserSetting(3, true, false, "id3");
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