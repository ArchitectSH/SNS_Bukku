package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.FriendAddingUserDTO;



public class FriendAddingUserDAOImpl extends BaseDAO implements FriendAddingUserDAO {
	private final static String GET_FRIEND_ADDING_USER_SQL = "SELECT * FROM friend_adding_user_tb";
	private final static String GET_FRIEND_ADDING_USER_BY_REQID_SQL = "SELECT * FROM friend_adding_user_tb WHERE request_id =?";
	private final static String GET_FRIEND_ADDING_USER_BY_RECID_SQL = "SELECT * FROM friend_adding_user_tb WHERE receive_id =?";
	private final static String GET_RECEIVE_USER_SQL = "SELECT receive_id FROM friend_adding_user_tb WHERE request_id =?";
	private final static String GET_REQUEST_USER_SQL = "SELECT request_id FROM friend_adding_user_tb WHERE receive_id =?";
	private final static String DELETE_BY_REQ_ID_SQL = "DELETE FROM friend_adding_user_tb WHERE request_id=?";
	private final static String DELETE_BY_REC_ID_SQL = "DELETE FROM friend_adding_user_tb WHERE receive_id=?";
	private final static String DELETE_BY_FRIEND_ADDING_USER_SQL = "DELETE FROM friend_adding_user_tb WHERE request_id=? AND receive_id=?";
	private final static String INSERT_FRIEND_ADDING_USER_SQL = "INSERT INTO friend_adding_user_tb VALUES(friend_adding_user_seq.nextval,?,?)";
	@Override
	public List<FriendAddingUserDTO> getFriendAddingUser() throws DAOException {
		// TODO Auto-generated method stub
		List<FriendAddingUserDTO> friendAddingUserDTOs = new ArrayList<FriendAddingUserDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_FRIEND_ADDING_USER_SQL );
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				FriendAddingUserDTO friendAddingUserDTO = new FriendAddingUserDTO();
				friendAddingUserDTO.setFriendAddingNo(resultSet.getInt("friend_adding_no"));
				friendAddingUserDTO.setRequestId(resultSet.getString("request_id"));
				friendAddingUserDTO.setReceiveId(resultSet.getString("receive_id"));
				friendAddingUserDTOs.add(friendAddingUserDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting FriendAddingUserDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return friendAddingUserDTOs;
	}
	@Override
	public List<FriendAddingUserDTO> getFriendAddingUserByReqId(String requestId)
			throws DAOException {
		// TODO Auto-generated method stub

		List<FriendAddingUserDTO> friendAddingUserDTOs = new ArrayList<FriendAddingUserDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_FRIEND_ADDING_USER_BY_REQID_SQL );
			pStatement.setString(1,requestId);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				FriendAddingUserDTO friendAddingUserDTO = new FriendAddingUserDTO();
				friendAddingUserDTO.setFriendAddingNo(resultSet.getInt("friend_adding_no"));
				friendAddingUserDTO.setRequestId(resultSet.getString("request_id"));
				friendAddingUserDTO.setReceiveId(resultSet.getString("receive_id"));
				friendAddingUserDTOs.add(friendAddingUserDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting FriendAddingUserDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return friendAddingUserDTOs;
	}
	@Override
	public List<FriendAddingUserDTO> getFriendAddingUserByRecId(String receiveId)
			throws DAOException {
		// TODO Auto-generated method stub

		List<FriendAddingUserDTO> friendAddingUserDTOs = new ArrayList<FriendAddingUserDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_FRIEND_ADDING_USER_BY_RECID_SQL );
			pStatement.setString(1,receiveId);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				FriendAddingUserDTO friendAddingUserDTO = new FriendAddingUserDTO();
				friendAddingUserDTO.setFriendAddingNo(resultSet.getInt("friend_adding_no"));
				friendAddingUserDTO.setRequestId(resultSet.getString("request_id"));
				friendAddingUserDTO.setReceiveId(resultSet.getString("receive_id"));
				friendAddingUserDTOs.add(friendAddingUserDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting FriendAddingUserDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return friendAddingUserDTOs;
	}
	@Override
	public List<String> getReceiveUser(String requestId) throws DAOException {
		// TODO Auto-generated method stub

		List<String> friendAddingUsers = new ArrayList<String>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_RECEIVE_USER_SQL );
			pStatement.setString(1,requestId);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				
				String friendAddingUser = resultSet.getString("receive_id");
				friendAddingUsers.add(friendAddingUser);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting FriendAddingUserDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return friendAddingUsers;
	}
	@Override
	public List<String> getRequestUser(String receiveId) throws DAOException {
		// TODO Auto-generated method stub

		List<String> friendAddingUsers = new ArrayList<String>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_REQUEST_USER_SQL );
			pStatement.setString(1,receiveId);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				
				String friendAddingUser = resultSet.getString("request_id");
				
				friendAddingUsers.add(friendAddingUser);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting FriendAddingUserDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return friendAddingUsers;
	}
	@Override
	public void deleteByReqId(String requestId) throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_BY_REQ_ID_SQL );
			pStatement.setString(1, requestId);
			pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error deleting friendAddingUserDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}	
		
	}
	@Override
	public void deleteByRecId(String receiveId) throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_BY_REC_ID_SQL );
			pStatement.setString(1, receiveId);
			pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error deleting friendAddingUserDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}	
	}
	@Override
	public void deleteByFriendAddingUser(String requestId, String receiveId)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_BY_FRIEND_ADDING_USER_SQL );
			pStatement.setString(1, requestId);
			pStatement.setString(2, receiveId);
			pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error deleting friendAddingUserDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}	
	}
	@Override
	public void insertFriendAddingUser(String requestId, String receiveId)
			throws DAOException {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(INSERT_FRIEND_ADDING_USER_SQL );
			pStatement.setString(1, requestId);
			pStatement.setString(2,receiveId);
		   pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error inserting friendAddingUserDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}
	}
	 /*public static void main(String[] args) {
	      // TODO Auto-generated method stub
	      DependencyInjector injector = new DependencyInjector();
	      try{
	         injector.start();
	         FriendAddingUserDAO friendAddingUserDAO = (FriendAddingUserDAO)injector.getObject(FriendAddingUserDAO.class);
	         
	         try{
	        /*    friendAddingUserDAO.insertFriendAddingUser("id1", "id4");
	            friendAddingUserDAO.insertFriendAddingUser("id2", "id5");
	            friendAddingUserDAO.insertFriendAddingUser("id5", "id1");
	            System.out.println("=============================");
	            System.out.println(friendAddingUserDAO.getFriendAddingUser());
	            System.out.println("=============================");
	            System.out.println(friendAddingUserDAO.getFriendAddingUserByRecId("id1"));
	            System.out.println("=============================");
	            System.out.println(friendAddingUserDAO.getFriendAddingUserByReqId("id2"));
	            System.out.println("=============================");
	            System.out.println(friendAddingUserDAO.getReceiveUser("id1"));
	            System.out.println("=============================");
	            System.out.println(friendAddingUserDAO.getRequestUser("id4"));
	            System.out.println("=============================");
	            friendAddingUserDAO.deleteByFriendAddingUser("id1", "id4");
	            System.out.println("=============================");
	            friendAddingUserDAO.deleteByRecId("id5");
	            friendAddingUserDAO.deleteByReqId("id5");
	            System.out.println("=============================");
	            System.out.println(friendAddingUserDAO.getFriendAddingUser());
	            
	            
	            //productDAO.insert(product);
	         }catch(Exception e){
	            e.printStackTrace();
	         }
	      }finally{
	         injector.shutDown();
	      }

	   }*/
}