package dao;

import injector.DataSourceManager;
import injector.UserDependencyInjector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import action.UserAction;
import dto.UserDTO;

public class UserDAOImpl extends BaseDAO implements UserDAO {
	private final static String GET_USER_SQL = "SELECT * FROM user_tb";
	private final static String GET_USER_BY_ID_SQL = "SELECT * FROM user_tb WHERE id=?";
	private final static String GET_USER_BY_NAME_SQL = "SELECT * FROM user_tb WHERE name LIKE ?";
	private final static String GET_USER_BY_EMAIL_SQL = "SELECT * FROM user_tb WHERE email=?";
	private final static String GET_USER_BY_PHONE_NUMBER_SQL = "SELECT * FROM user_tb WHERE phone_number=?";
	private final static String GET_USER_BY_GENDER_SQL = "SELECT * FROM user_tb WHERE gender=?";
	private final static String GET_USER_BY_BIRTH_SQL = "SELECT * FROM user_tb WHERE birth=?";
	private final static String GET_USER_BY_SCHOOL_SQL = "SELECT * FROM user_tb WHERE school LIKE ?";
	private final static String GET_USER_BY_LOCATION_SQL = "SELECT * FROM user_tb WHERE location LIKE ?";
	private final static String GET_USER_BY_ALLINFO_SQL = "SELECT * FROM user_tb WHERE id=? AND name LIKE ? AND email=? AND phone_number=? AND gender=? AND birth=? AND school LIKE ? AND location LIKE ?";
	private final static String GET_USER_ID_BY_NAME_EMAIL_SQL = "SELECT id FROM user_tb WHERE name=? AND email=?";
	private final static String GET_USER_ID_BY_NAME_PHONE_SQL = "SELECT id FROM user_tb WHERE name=? AND phone_number=?";
	private final static String GET_USER_PW_BY_ID_PHONE_SQL = "SELECT password FROM user_tb WHERE id=? AND phone_number=?";
	private final static String GET_USER_PW_BY_ID_EMAIL_SQL = "SELECT password FROM user_tb WHERE id=? AND email=?";
	private final static String GET_USER_BY_NAME_SCHOOL_SQL = "SELECT * FROM user_tb WHERE name= ? AND school LIKE ?";
	private final static String GET_USER_BY_NAME_GENDER_BIRTH_SQL = "SELECT * FROM user_tb WHERE name= ? AND gender = ? AND birth = ?";
	private final static String UPDATE_USER_PASSWORD_SQL = "UPDATE user_tb SET password=? WHERE id=? AND password=?";
	private final static String UPDATE_USER_PROFILE_IMG_SQL = "UPDATE user_tb SET profile_img=? WHERE id=? AND password=?";
	private final static String UPDATE_USER_EMAIL_SQL = "UPDATE user_tb SET email=? WHERE id=? AND password=?";
	private final static String UPDATE_USER_PHONE_NUMBER_SQL = "UPDATE user_tb SET phone_number=? WHERE id=? AND password=?";
	private final static String UPDATE_USER_GENDER_SQL = "UPDATE user_tb SET gender=? WHERE id=? AND password=?";
	private final static String UPDATE_USER_SCHOOL_SQL = "UPDATE user_tb SET school =? WHERE id=? AND password=?";
	private final static String UPDATE_USER_LOCATION_SQL = "UPDATE user_tb SET location=? WHERE id=? AND password=?";
	private final static String UPDATE_USER_INFO_SQL = "UPDATE user_tb SET password=?, email=?, phone_number=?, gender=? WHERE id=? AND password=?";
	private final static String UPDATE_USER_PROFILE_SQL = "UPDATE user_tb SET profile_img=?, school = ?, location= ? WHERE id=? AND password=?";
	private final static String DELETE_USER_SQL = "DELETE FROM user_tb WHERE id=? AND password=?";
	private final static String INSERT_USER_SQL = "INSERT INTO user_tb VALUES(?,?,'image/profileImg/profileDefault.jpg',?,?,?,?,?,?,?,sysdate)";
	@Override
	public List<UserDTO> getUser() throws DAOException {
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_USER_SQL);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				UserDTO userDTO = new UserDTO();
				userDTO.setId(resultSet.getString("id"));
				userDTO.setName(resultSet.getString("name"));
				userDTO.setProfileImg(resultSet.getString("profile_img"));
				userDTO.setPassword(resultSet.getString("password"));
				userDTO.setEmail(resultSet.getString("email"));
				userDTO.setPhoneNumber(resultSet.getString("phone_number"));
				userDTO.setGender(resultSet.getInt("gender"));
				userDTO.setBirth(resultSet.getString("birth"));
				userDTO.setSchool(resultSet.getString("school"));
				userDTO.setLocation(resultSet.getString("location"));
				userDTO.setJoinDate(resultSet.getString("join_date"));
				userDTOs.add(userDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting UserDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return userDTOs;
	}
	@Override
	public UserDTO getUserById(String id) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		UserDTO userDTO=null;
		try{
			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_USER_BY_ID_SQL);
			pStatement.setString(1,id);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				userDTO = new UserDTO();
				userDTO.setId(resultSet.getString("id"));
				userDTO.setName(resultSet.getString("name"));
				userDTO.setProfileImg(resultSet.getString("profile_img"));
				userDTO.setPassword(resultSet.getString("password"));
				userDTO.setEmail(resultSet.getString("email"));
				userDTO.setPhoneNumber(resultSet.getString("phone_number"));
				userDTO.setGender(resultSet.getInt("gender"));
				userDTO.setBirth(resultSet.getString("birth"));
				userDTO.setSchool(resultSet.getString("school"));
				userDTO.setLocation(resultSet.getString("location"));
				userDTO.setJoinDate(resultSet.getString("join_date"));
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting userDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return userDTO;
	}
	@Override
	public List<UserDTO> getUserByName(String name) throws DAOException {
		// TODO Auto-generated method stub
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_USER_BY_NAME_SQL);
			pStatement.setString(1,"%"+name+"%");
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				UserDTO userDTO = new UserDTO();
				userDTO.setId(resultSet.getString("id"));
				userDTO.setName(resultSet.getString("name"));
				userDTO.setProfileImg(resultSet.getString("profile_img"));
				userDTO.setPassword(resultSet.getString("password"));
				userDTO.setEmail(resultSet.getString("email"));
				userDTO.setPhoneNumber(resultSet.getString("phone_number"));
				userDTO.setGender(resultSet.getInt("gender"));
				userDTO.setBirth(resultSet.getString("birth"));
				userDTO.setSchool(resultSet.getString("school"));
				userDTO.setLocation(resultSet.getString("location"));
				userDTO.setJoinDate(resultSet.getString("join_date"));
				userDTOs.add(userDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting UserDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return userDTOs;
	}
	@Override
	public UserDTO getUserByEmail(String email) throws DAOException {
		// TODO Auto-generated method stub
		UserDTO userDTO=null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_USER_BY_EMAIL_SQL);
			pStatement.setString(1,email);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				userDTO = new UserDTO();
				userDTO.setId(resultSet.getString("id"));
				userDTO.setName(resultSet.getString("name"));
				userDTO.setProfileImg(resultSet.getString("profile_img"));
				userDTO.setPassword(resultSet.getString("password"));
				userDTO.setEmail(resultSet.getString("email"));
				userDTO.setPhoneNumber(resultSet.getString("phone_number"));
				userDTO.setGender(resultSet.getInt("gender"));
				userDTO.setBirth(resultSet.getString("birth"));
				userDTO.setSchool(resultSet.getString("school"));
				userDTO.setLocation(resultSet.getString("location"));
				userDTO.setJoinDate(resultSet.getString("join_date"));
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting UserDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return userDTO;
	}
	@Override
	public UserDTO getUserByPhoneNumber(String phoneNumber) throws DAOException {
		// TODO Auto-generated method stub
		UserDTO userDTO=null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_USER_BY_PHONE_NUMBER_SQL );
			pStatement.setString(1,phoneNumber);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				userDTO = new UserDTO();
				userDTO.setId(resultSet.getString("id"));
				userDTO.setName(resultSet.getString("name"));
				userDTO.setProfileImg(resultSet.getString("profile_img"));
				userDTO.setPassword(resultSet.getString("password"));
				userDTO.setEmail(resultSet.getString("email"));
				userDTO.setPhoneNumber(resultSet.getString("phone_number"));
				userDTO.setGender(resultSet.getInt("gender"));
				userDTO.setBirth(resultSet.getString("birth"));
				userDTO.setSchool(resultSet.getString("school"));
				userDTO.setLocation(resultSet.getString("location"));
				userDTO.setJoinDate(resultSet.getString("join_date"));
				
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting UserDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return userDTO;
	}
	@Override
	public List<UserDTO> getUserByGender(Integer gender) throws DAOException {
		// TODO Auto-generated method stub
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_USER_BY_GENDER_SQL );
			pStatement.setInt(1,gender);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				UserDTO userDTO = new UserDTO();
				userDTO.setId(resultSet.getString("id"));
				userDTO.setName(resultSet.getString("name"));
				userDTO.setProfileImg(resultSet.getString("profile_img"));
				userDTO.setPassword(resultSet.getString("password"));
				userDTO.setEmail(resultSet.getString("email"));
				userDTO.setPhoneNumber(resultSet.getString("phone_number"));
				userDTO.setGender(resultSet.getInt("gender"));
				userDTO.setBirth(resultSet.getString("birth"));
				userDTO.setSchool(resultSet.getString("school"));
				userDTO.setLocation(resultSet.getString("location"));
				userDTO.setJoinDate(resultSet.getString("join_date"));
				userDTOs.add(userDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting UserDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return userDTOs;
	}
	@Override
	public List<UserDTO> getUserByBirth(String birth) throws DAOException {
		// TODO Auto-generated method stub
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_USER_BY_BIRTH_SQL );
			pStatement.setString(1,birth);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				UserDTO userDTO = new UserDTO();
				userDTO.setId(resultSet.getString("id"));
				userDTO.setName(resultSet.getString("name"));
				userDTO.setProfileImg(resultSet.getString("profile_img"));
				userDTO.setPassword(resultSet.getString("password"));
				userDTO.setEmail(resultSet.getString("email"));
				userDTO.setPhoneNumber(resultSet.getString("phone_number"));
				userDTO.setGender(resultSet.getInt("gender"));
				userDTO.setBirth(resultSet.getString("birth"));
				userDTO.setSchool(resultSet.getString("school"));
				userDTO.setLocation(resultSet.getString("location"));
				userDTO.setJoinDate(resultSet.getString("join_date"));
				userDTOs.add(userDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting UserDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return userDTOs;
	}
	@Override
	public List<UserDTO> getUserBySchool(String school) throws DAOException {
		// TODO Auto-generated method stub
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_USER_BY_SCHOOL_SQL );
			pStatement.setString(1,"%"+school+"%");
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				UserDTO userDTO = new UserDTO();
				userDTO.setId(resultSet.getString("id"));
				userDTO.setName(resultSet.getString("name"));
				userDTO.setProfileImg(resultSet.getString("profile_img"));
				userDTO.setPassword(resultSet.getString("password"));
				userDTO.setEmail(resultSet.getString("email"));
				userDTO.setPhoneNumber(resultSet.getString("phone_number"));
				userDTO.setGender(resultSet.getInt("gender"));
				userDTO.setBirth(resultSet.getString("birth"));
				userDTO.setSchool(resultSet.getString("school"));
				userDTO.setLocation(resultSet.getString("location"));
				userDTO.setJoinDate(resultSet.getString("join_date"));
				userDTOs.add(userDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting UserDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return userDTOs;
	}
	@Override
	public List<UserDTO> getUserByLocation(String location) throws DAOException {
		// TODO Auto-generated method stub
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_USER_BY_LOCATION_SQL );
			pStatement.setString(1,"%"+location+"%");
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				UserDTO userDTO = new UserDTO();
				userDTO.setId(resultSet.getString("id"));
				userDTO.setName(resultSet.getString("name"));
				userDTO.setProfileImg(resultSet.getString("profile_img"));
				userDTO.setPassword(resultSet.getString("password"));
				userDTO.setEmail(resultSet.getString("email"));
				userDTO.setPhoneNumber(resultSet.getString("phone_number"));
				userDTO.setGender(resultSet.getInt("gender"));
				userDTO.setBirth(resultSet.getString("birth"));
				userDTO.setSchool(resultSet.getString("school"));
				userDTO.setLocation(resultSet.getString("location"));
				userDTO.setJoinDate(resultSet.getString("join_date"));
				userDTOs.add(userDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting UserDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return userDTOs;
	}
	@Override
	public List<UserDTO> getUserByAllInfo(String id, String name, String email,
			String phoneNumber, Integer gender, String birth, String school,
			String location) throws DAOException {
		// TODO Auto-generated method stub
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_USER_BY_ALLINFO_SQL );
			pStatement.setString(1,id);
			pStatement.setString(2,"%"+name+"%");
			pStatement.setString(3,email);
			pStatement.setString(4,phoneNumber);
			pStatement.setInt(5,gender);
			pStatement.setString(6,birth);
			pStatement.setString(7,"%"+school+"%");
			pStatement.setString(8,"%"+location+"%");
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				UserDTO userDTO = new UserDTO();
				userDTO.setId(resultSet.getString("id"));
				userDTO.setName(resultSet.getString("name"));
				userDTO.setProfileImg(resultSet.getString("profile_img"));
				userDTO.setPassword(resultSet.getString("password"));
				userDTO.setEmail(resultSet.getString("email"));
				userDTO.setPhoneNumber(resultSet.getString("phone_number"));
				userDTO.setGender(resultSet.getInt("gender"));
				userDTO.setBirth(resultSet.getString("birth"));
				userDTO.setSchool(resultSet.getString("school"));
				userDTO.setLocation(resultSet.getString("location"));
				userDTO.setJoinDate(resultSet.getString("join_date"));
				userDTOs.add(userDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting UserDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return userDTOs;
	}
	@Override
	public void updateUserPassword(String id, String password,
			String newPassword) throws DAOException {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_USER_PASSWORD_SQL );
			pStatement.setString(1, newPassword);
			pStatement.setString(2, id);
			pStatement.setString(3, password);

		    pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error updating userDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}
	}
	@Override
	public void updateUserProfileImg(String id, String password,
			String newProfileImg) throws DAOException {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_USER_PROFILE_IMG_SQL );
			pStatement.setString(1, newProfileImg);
			pStatement.setString(2, id);
			pStatement.setString(3, password);
			
		    pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error updating userDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}
	}
	@Override
	public void updateUserEmail(String id, String password, String newEmail)
			throws DAOException {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_USER_EMAIL_SQL );
			pStatement.setString(1, newEmail);
			pStatement.setString(2, id);
			pStatement.setString(3, password);
			
		    pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error updating userDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}
	}
	@Override
	public void updateUserPhoneNumber(String id, String password,
			String newPhoneNumber) throws DAOException {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_USER_PHONE_NUMBER_SQL );
			pStatement.setString(1, newPhoneNumber);
			pStatement.setString(2, id);
			pStatement.setString(3, password);
			
		    pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error updating userDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}
	}
	@Override
	public void updateUserGender(String id, String password, Integer newGender)
			throws DAOException {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_USER_GENDER_SQL );
			pStatement.setInt(1, newGender);
			pStatement.setString(2, id);
			pStatement.setString(3, password);
			
		    pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error updating userDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}
	}
	@Override
	public void updateUserSchool(String id, String password, String newSchool)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_USER_SCHOOL_SQL  );
			pStatement.setString(1, newSchool);
			pStatement.setString(2, id);
			pStatement.setString(3, password);
			
		
		    pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error updating userDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}
	}
	@Override
	public void updateUserLocation(String id, String password,
			String newLocation) throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_USER_LOCATION_SQL);
			pStatement.setString(1, newLocation);
			pStatement.setString(2, id);
			pStatement.setString(3, password);
			
		
		    pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error updating userDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}
	}
	@Override
	public void updateUserInfo(String newPassword, String newEmail,String newPhoneNumber, Integer newGender, String id, String password) throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_USER_INFO_SQL);
			pStatement.setString(1,newPassword);
			pStatement.setString(2,newEmail);
			pStatement.setString(3,newPhoneNumber);
			pStatement.setInt(4,newGender);

			pStatement.setString(5, id);
			pStatement.setString(6, password);
		    pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error updating userDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}
	}
	@Override
	public void updateUserProfile(String newProfileImg, String newSchool,String newLocation,String id, String password) throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_USER_PROFILE_SQL);
		
			pStatement.setString(1,newProfileImg);
			pStatement.setString(2,newSchool);
			pStatement.setString(3,newLocation);

			pStatement.setString(4, id);
			pStatement.setString(5, password);
		
		    pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error updating userDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}
	}
	

	@Override
	public void deleteUser(String id, String password) throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_USER_SQL );
			pStatement.setString(1, id);
			pStatement.setString(2, password);
		
			pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error deleting userDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}	
	}
	@Override
	public void insertUser(String id, String name, String password,
			String email, String phoneNumber, Integer gender,String birth, String school,
			String location) throws DAOException {
		/*System.out.println("UserDAOImpl-> insertUser");
		System.out.println("확인:"+id+name+password+email+phoneNumber+gender+birth);*/
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(INSERT_USER_SQL);
			pStatement.setString(1,id);
			pStatement.setString(2,name);
			pStatement.setString(3,password);
			pStatement.setString(4,email);
			pStatement.setString(5,phoneNumber);
			pStatement.setInt(6,gender);
			pStatement.setString(7,birth);
			pStatement.setString(8,school);
			pStatement.setString(9,location);
		   pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error inserting userDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}	
		System.out.println("UserDAOImpl-> insertUser22");
	}
	
	  public static void main(String[] args) {
	      // TODO Auto-generated method stub
		  DataSourceManager dataSourceManager = DataSourceManager.getInstance();
		
	      UserDependencyInjector injector = new UserDependencyInjector(dataSourceManager.getDataSource());
	      try{
	       /*  injector.start();*/
	         UserAction userAction = (UserAction)injector.getObject(UserAction.class);
	         
	         try{
	     /*       System.out.println(userDAO.getUser());
	            System.out.println("=============================");
	            System.out.println(userDAO.getUserById("id1"));
	            System.out.println("=============================");
	            System.out.println(userDAO.getUserByName("nam"));
	            System.out.println("=============================");
	            System.out.println(userDAO.getUserByEmail("email3@google.com"));
	            System.out.println("=============================");
	            System.out.println(userDAO.getUserByPhoneNumber("01033002222"));
	            System.out.println("=============================");
	            System.out.println(userDAO.getUserByBirth("222222"));
	            System.out.println("=============================");
	            System.out.println(userDAO.getUserByGender(1));
	            System.out.println("=============================");
	            System.out.println(userDAO.getUserByLocation("2지역"));
	            System.out.println("=============================");
	            System.out.println(userDAO.getUserByAllInfo("id1","name","email1@google.com", "01033001111",1,"111111","1초등학교", "1지역"));
	            System.out.println("=============================");
	            userDAO.updateUserInfo("pw61", "email66@google.com", "01033006665", 1, "id6","pw6");
	            System.out.println("=============================");
	            userDAO.updateUserProfile("img66", "66초등학교", "66지역", "id6", "pw6");
	            System.out.println("=============================");
	           userDAO.insertUser("id7", "name", "password", "email11", "01033", 1, "birth", "school", "location");
	            System.out.println("=============================");
	            System.out.println(userDAO.getUserById("id7"));
	            System.out.println("=============================");
	           userDAO.deleteUser("id7", "password");
	            System.out.println("=============================");
	            System.out.println(userDAO.getUserById("id7"));*/
	        
	        	 
	            //productDAO.insert(product);
	        	 userAction.insertUser("idTest", "name", "password", "ema123#sdf121", "0102341827", 1, "birth",null,null);
	         }catch(Exception e){
	            e.printStackTrace();
	         }
	      }finally{
	       /*  injector.shutDown();*/
	      }

	   }
	  //추가중
/*	@Override
	public String getUserIdByNameAndPhone(String name, String phoneNumber)
			throws DAOException {
		// TODO Auto-generated method stub
		UserDTO userDTO=null;
		String id = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_USER_BY_PHONE_NUMBER_SQL );
			pStatement.setString(1,phoneNumber);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				userDTO = new UserDTO();
				userDTO.setId(resultSet.getString("id"));
				userDTO.setName(resultSet.getString("name"));
				userDTO.setProfileImg(resultSet.getString("profile_img"));
				userDTO.setPassword(resultSet.getString("password"));
				userDTO.setEmail(resultSet.getString("email"));
				userDTO.setPhoneNumber(resultSet.getString("phone_number"));
				userDTO.setGender(resultSet.getInt("gender"));
				userDTO.setBirth(resultSet.getString("birth"));
				userDTO.setSchool(resultSet.getString("school"));
				userDTO.setLocation(resultSet.getString("location"));
				userDTO.setJoinDate(resultSet.getString("join_date"));
				
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting UserDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return userDTO;
	}
	@Override
	public String getUserIdByNameAndEmail(String name, String email)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUserPwByIdAndEmail(String id, String email)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUserPwByIdAndPhone(String id, String phoneNumber)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}*/
	@Override
	public List<UserDTO> getUserByNameSchool(String name, String school)
			throws DAOException {
		// TODO Auto-generated method stub
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_USER_BY_NAME_SCHOOL_SQL );
			pStatement.setString(1,name);
			pStatement.setString(2,"%"+school+"%");
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				UserDTO userDTO = new UserDTO();
				userDTO.setId(resultSet.getString("id"));
				userDTO.setName(resultSet.getString("name"));
				userDTO.setProfileImg(resultSet.getString("profile_img"));
				userDTO.setPassword(resultSet.getString("password"));
				userDTO.setEmail(resultSet.getString("email"));
				userDTO.setPhoneNumber(resultSet.getString("phone_number"));
				userDTO.setGender(resultSet.getInt("gender"));
				userDTO.setBirth(resultSet.getString("birth"));
				userDTO.setSchool(resultSet.getString("school"));
				userDTO.setLocation(resultSet.getString("location"));
				userDTO.setJoinDate(resultSet.getString("join_date"));
				userDTOs.add(userDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting UserDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return userDTOs;
	}
	@Override
	public List<UserDTO> getUserByNameGenderBirth(String name, Integer gender,
			String birth) throws DAOException {
		// TODO Auto-generated method stub
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_USER_BY_NAME_GENDER_BIRTH_SQL );
			pStatement.setString(1,name);
			pStatement.setInt(2,gender);
			pStatement.setString(3,birth);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				UserDTO userDTO = new UserDTO();
				userDTO.setId(resultSet.getString("id"));
				userDTO.setName(resultSet.getString("name"));
				userDTO.setProfileImg(resultSet.getString("profile_img"));
				userDTO.setPassword(resultSet.getString("password"));
				userDTO.setEmail(resultSet.getString("email"));
				userDTO.setPhoneNumber(resultSet.getString("phone_number"));
				userDTO.setGender(resultSet.getInt("gender"));
				userDTO.setBirth(resultSet.getString("birth"));
				userDTO.setSchool(resultSet.getString("school"));
				userDTO.setLocation(resultSet.getString("location"));
				userDTO.setJoinDate(resultSet.getString("join_date"));
				userDTOs.add(userDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting UserDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return userDTOs;
	}
	
}