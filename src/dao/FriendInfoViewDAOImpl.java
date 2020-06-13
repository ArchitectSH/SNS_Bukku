package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.FriendInfoViewDTO;

public class FriendInfoViewDAOImpl extends BaseDAO implements FriendInfoViewDAO {
	private final static String GET_FRIEND_INFO_VIEW_SQL = "SELECT * FROM friend_info_view";
	private final static String GET_FRIEND_INFO_VIEW_BY_USER_ID_SQL = "SELECT * FROM friend_info_view WHERE user_id = ?";
	private final static String GET_FRIEND_INFO_VIEW_BY_USER_ID_ORDER_BUKKU_SQL = "SELECT * FROM friend_info_view WHERE user_id =? ORDER BY (user_bukku_index + friend_bukku_index)";
	private final static String GET_FRIEND_INFO_VIEW_BY_FRIEND_ID_SQL = "SELECT * FROM friend_info_view WHERE friend_id = ?";
	private final static String GET_FRIEND_INFO_VIEW_BY_USER_FRIEND_SQL = "SELECT * FROM friend_info_view WHERE user_id = ? AND friend_id = ?";
	private final static String GET_FRIEND_INFO_VIEW_BY_USER_FRIEND_ATTI_SQL = "SELECT * FROM friend_info_view WHERE user_id = ? AND friend_id = ? AND ROUND((user_bukku_index + friend_bukku_index)/2) < 50";
	@Override
	public List<FriendInfoViewDTO> getFriendInfoView() throws DAOException {
		// TODO Auto-generated method stub
		List<FriendInfoViewDTO> friendInfoViewDTOs = new ArrayList<FriendInfoViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_FRIEND_INFO_VIEW_SQL );
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				FriendInfoViewDTO friendInfoViewDTO = new FriendInfoViewDTO();
				friendInfoViewDTO.setUserId(resultSet.getString("user_id"));
				friendInfoViewDTO.setFriendId(resultSet.getString("friend_id"));
				friendInfoViewDTO.setFriendProfileImg(resultSet.getString("friend_profile_img"));
				friendInfoViewDTO.setFriendName(resultSet.getString("friend_name"));
				friendInfoViewDTO.setFriendSchool(resultSet.getString("friend_school"));
				friendInfoViewDTO.setFriendLocation(resultSet.getString("friend_location"));
				friendInfoViewDTO.setFriendGender(resultSet.getInt("friend_gender"));
				friendInfoViewDTO.setUserBukkuIndex(resultSet.getInt("user_bukku_index"));
				friendInfoViewDTO.setFriendBukkuIndex(resultSet.getInt("friend_bukku_index"));
				
				friendInfoViewDTOs.add(friendInfoViewDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting FriendInfoViewDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return friendInfoViewDTOs;
	}
	@Override
	public List<FriendInfoViewDTO> getFriendInfoViewByUserId(String userId)
			throws DAOException {
		// TODO Auto-generated method stub
		List<FriendInfoViewDTO> friendInfoViewDTOs = new ArrayList<FriendInfoViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_FRIEND_INFO_VIEW_BY_USER_ID_SQL );
			pStatement.setString(1,userId);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				FriendInfoViewDTO friendInfoViewDTO = new FriendInfoViewDTO();
				friendInfoViewDTO.setUserId(resultSet.getString("user_id"));
				friendInfoViewDTO.setFriendId(resultSet.getString("friend_id"));
				friendInfoViewDTO.setFriendProfileImg(resultSet.getString("friend_profile_img"));
				friendInfoViewDTO.setFriendName(resultSet.getString("friend_name"));
				friendInfoViewDTO.setFriendSchool(resultSet.getString("friend_school"));
				friendInfoViewDTO.setFriendLocation(resultSet.getString("friend_location"));
				friendInfoViewDTO.setFriendGender(resultSet.getInt("friend_gender"));
				friendInfoViewDTO.setUserBukkuIndex(resultSet.getInt("user_bukku_index"));
				friendInfoViewDTO.setFriendBukkuIndex(resultSet.getInt("friend_bukku_index"));
				friendInfoViewDTOs.add(friendInfoViewDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting FriendInfoViewDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return friendInfoViewDTOs;
	}
	@Override
	public List<FriendInfoViewDTO> getFriendInfoViewByUserIdOrderBukku(
			String userId) throws DAOException {
		// TODO Auto-generated method stub
		List<FriendInfoViewDTO> friendInfoViewDTOs = new ArrayList<FriendInfoViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_FRIEND_INFO_VIEW_BY_USER_ID_ORDER_BUKKU_SQL );
			pStatement.setString(1,userId);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				FriendInfoViewDTO friendInfoViewDTO = new FriendInfoViewDTO();
				friendInfoViewDTO.setUserId(resultSet.getString("user_id"));
				friendInfoViewDTO.setFriendId(resultSet.getString("friend_id"));
				friendInfoViewDTO.setFriendProfileImg(resultSet.getString("friend_profile_img"));
				friendInfoViewDTO.setFriendName(resultSet.getString("friend_name"));
				friendInfoViewDTO.setFriendSchool(resultSet.getString("friend_school"));
				friendInfoViewDTO.setFriendLocation(resultSet.getString("friend_location"));
				friendInfoViewDTO.setFriendGender(resultSet.getInt("friend_gender"));
				friendInfoViewDTO.setUserBukkuIndex(resultSet.getInt("user_bukku_index"));
				friendInfoViewDTO.setFriendBukkuIndex(resultSet.getInt("friend_bukku_index"));
				friendInfoViewDTOs.add(friendInfoViewDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting FriendInfoViewDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return friendInfoViewDTOs;
	}
	@Override
	public List<FriendInfoViewDTO> getFriendInfoViewByFriendId(String friendId)
			throws DAOException {
		// TODO Auto-generated method stub
		List<FriendInfoViewDTO> friendInfoViewDTOs = new ArrayList<FriendInfoViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_FRIEND_INFO_VIEW_BY_FRIEND_ID_SQL );
			pStatement.setString(1,friendId);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				FriendInfoViewDTO friendInfoViewDTO = new FriendInfoViewDTO();
				friendInfoViewDTO.setUserId(resultSet.getString("user_id"));
				friendInfoViewDTO.setFriendId(resultSet.getString("friend_id"));
				friendInfoViewDTO.setFriendProfileImg(resultSet.getString("friend_profile_img"));
				friendInfoViewDTO.setFriendName(resultSet.getString("friend_name"));
				friendInfoViewDTO.setFriendSchool(resultSet.getString("friend_school"));
				friendInfoViewDTO.setFriendLocation(resultSet.getString("friend_location"));
				friendInfoViewDTO.setFriendGender(resultSet.getInt("friend_gender"));
				friendInfoViewDTO.setUserBukkuIndex(resultSet.getInt("user_bukku_index"));
				friendInfoViewDTO.setFriendBukkuIndex(resultSet.getInt("friend_bukku_index"));
				friendInfoViewDTOs.add(friendInfoViewDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting FriendInfoViewDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return friendInfoViewDTOs;
	}
	@Override
	public FriendInfoViewDTO getFriendInfoViewByUserAndFriend(String userId,
			String friendId) throws DAOException {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		FriendInfoViewDTO friendInfoViewDTO=null;
		try{
			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_FRIEND_INFO_VIEW_BY_USER_FRIEND_SQL );
			pStatement.setString(1,userId);
			pStatement.setString(2,friendId);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				friendInfoViewDTO = new FriendInfoViewDTO();
				friendInfoViewDTO.setUserId(resultSet.getString("user_id"));
				friendInfoViewDTO.setFriendId(resultSet.getString("friend_id"));
				friendInfoViewDTO.setFriendProfileImg(resultSet.getString("friend_profile_img"));
				friendInfoViewDTO.setFriendName(resultSet.getString("friend_name"));
				friendInfoViewDTO.setFriendSchool(resultSet.getString("friend_school"));
				friendInfoViewDTO.setFriendLocation(resultSet.getString("friend_location"));
				friendInfoViewDTO.setFriendGender(resultSet.getInt("friend_gender"));
				friendInfoViewDTO.setUserBukkuIndex(resultSet.getInt("user_bukku_index"));
				friendInfoViewDTO.setFriendBukkuIndex(resultSet.getInt("friend_bukku_index"));
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting friendInfoViewDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return friendInfoViewDTO;

	}
	@Override
	public FriendInfoViewDTO getFriendInfoViewByUserAndFriendAtti(
			String userId, String friendId) throws DAOException {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		FriendInfoViewDTO friendInfoViewDTO=null;
		try{
			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_FRIEND_INFO_VIEW_BY_USER_FRIEND_ATTI_SQL );
			pStatement.setString(1,userId);
			pStatement.setString(2,friendId);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				friendInfoViewDTO = new FriendInfoViewDTO();
				friendInfoViewDTO.setUserId(resultSet.getString("user_id"));
				friendInfoViewDTO.setFriendId(resultSet.getString("friend_id"));
				friendInfoViewDTO.setFriendProfileImg(resultSet.getString("friend_profile_img"));
				friendInfoViewDTO.setFriendName(resultSet.getString("friend_name"));
				friendInfoViewDTO.setFriendSchool(resultSet.getString("friend_school"));
				friendInfoViewDTO.setFriendLocation(resultSet.getString("friend_location"));
				friendInfoViewDTO.setFriendGender(resultSet.getInt("friend_gender"));
				friendInfoViewDTO.setUserBukkuIndex(resultSet.getInt("user_bukku_index"));
				friendInfoViewDTO.setFriendBukkuIndex(resultSet.getInt("friend_bukku_index"));
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting friendInfoViewDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return friendInfoViewDTO;

	}
	 /*public static void main(String[] args) {
	      // TODO Auto-generated method stub
	      DependencyInjector injector = new DependencyInjector();
	      try{
	         injector.start();
	         FriendInfoViewDAO friendInfoViewDAO = (FriendInfoViewDAO)injector.getObject(FriendInfoViewDAO.class);
	         
	         try{
	            System.out.println(friendInfoViewDAO.getFriendInfoView());
	            System.out.println("=============================");
	            System.out.println(friendInfoViewDAO.getFriendInfoViewByFriendId("id1"));
	            System.out.println("=============================");
	            System.out.println(friendInfoViewDAO.getFriendInfoViewByUserAndFriend("id1", "id2"));
	            System.out.println("=============================");
	            System.out.println(friendInfoViewDAO.getFriendInfoViewByUserAndFriendAtti("id1", "id2"));
	            System.out.println("=============================");
	            System.out.println(friendInfoViewDAO.getFriendInfoViewByUserId("id2"));
	            System.out.println("=============================");
	            System.out.println(friendInfoViewDAO.getFriendInfoViewByUserIdOrderBukku("id4"));
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