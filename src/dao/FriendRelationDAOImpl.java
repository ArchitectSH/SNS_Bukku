package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.FriendRelationDTO;

public class FriendRelationDAOImpl extends BaseDAO implements FriendRelationDAO {
	private final static String GET_FRIEND_RELATION_SQL = "SELECT * FROM friend_relation_tb";
	private final static String GET_FRIEND_RELATION_BY_ID_SQL = "SELECT * FROM friend_relation_tb WHERE id=?";
	private final static String GET_FRIEND_RELATION_BY_FRIEND_NUM_ID_SQL = "SELECT * FROM friend_relation_tb WHERE friend_no = ? AND id != ?";
	private final static String GET_FRIEND_NUM_BY_ID_SQL = "SELECT friend_no FROM friend_relation_tb WHERE id=?";
	private final static String GET_FRIEND_RELATION_BY_FRIEND_NUM_SQL = "SELECT * FROM friend_relation_tb WHERE friend_no=?";
	private final static String UPDATE_BUKKU_INDEX_SQL = "UPDATE friend_relation_tb SET bukku_index = bukku_index-1 WHERE friend_no=? AND id=?";
	private final static String DELETE_FRIEND_RELATION_SQL = "DELETE FROM friend_relation_tb WHERE friend_no=?";
	private final static String DELETE_FRIEND_RELATION_BY_FRIEND_NUM_ID_SQL = "DELETE FROM friend_relation_tb WHERE friend_no=? OR id=?";
	private final static String INSERT_FRIEND_RELATION_SQL = "INSERT INTO friend_relation_tb VALUES(friend_relation_seq.nextval,250,?,?)";

	@Override
	public List<FriendRelationDTO> getFriendRelation() throws DAOException {
		// TODO Auto-generated method stub

		List<FriendRelationDTO> friendRelationDTOs = new ArrayList<FriendRelationDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_FRIEND_RELATION_SQL);
			resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				FriendRelationDTO friendRelationDTO = new FriendRelationDTO();
				friendRelationDTO.setFriendRelationCode(resultSet
						.getInt("friend_relation_code"));
				friendRelationDTO.setFriendNo(resultSet.getInt("friend_no"));
				friendRelationDTO.setBukkuIndex(resultSet.getInt("bukku_index"));
				friendRelationDTO.setId(resultSet.getString("id"));
				friendRelationDTOs.add(friendRelationDTO);
			}
		} catch (Exception e) {
			throw new DAOException("Error getting FriendRelationDTOs."
					+ e.getMessage());
		} finally {
			closeDBObjects(resultSet, pStatement, connection);
		}
		return friendRelationDTOs;

	}

	@Override
	public List<FriendRelationDTO> getFriendRelationById(String id)
			throws DAOException {
		// TODO Auto-generated method stub
		List<FriendRelationDTO> friendRelationDTOs = new ArrayList<FriendRelationDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			pStatement = connection
					.prepareStatement(GET_FRIEND_RELATION_BY_ID_SQL);
			pStatement.setString(1, id);
			resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				FriendRelationDTO friendRelationDTO = new FriendRelationDTO();
				friendRelationDTO.setFriendRelationCode(resultSet
						.getInt("friend_relation_code"));
				friendRelationDTO.setFriendNo(resultSet.getInt("friend_no"));
				friendRelationDTO.setBukkuIndex(resultSet.getInt("bukku_index"));
				friendRelationDTO.setId(resultSet.getString("id"));
				friendRelationDTOs.add(friendRelationDTO);
			}
		} catch (Exception e) {
			throw new DAOException("Error getting FriendRelationDTOs."
					+ e.getMessage());
		} finally {
			closeDBObjects(resultSet, pStatement, connection);
		}
		return friendRelationDTOs;

	}

	@Override
	public List<Integer> getFriendNumById(String id) throws DAOException {
		// TODO Auto-generated method stub
		List<Integer> friendNums = new ArrayList<Integer>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_FRIEND_NUM_BY_ID_SQL);
			pStatement.setString(1, id);
			resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				int friendNum = resultSet.getInt("friend_no");
				friendNums.add(new Integer(friendNum));
			}
		} catch (Exception e) {
			throw new DAOException("Error getting FriendRelationDTOs."
					+ e.getMessage());
		} finally {
			closeDBObjects(resultSet, pStatement, connection);
		}
		return friendNums;

	}
	
	@Override
	public Integer getFriendNumByIdNFriendId(String id,String friendId) throws DAOException {
		// TODO Auto-generated method stub
		Integer friendNum = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement("SELECT friend_no FROM (SELECT f1.id user_id,f2.id friend_id,f1.friend_no friend_no FROM friend_relation_tb f1, friend_relation_tb f2 WHERE f1.friend_no = f2.friend_no AND f1.friend_relation_code != f2.friend_relation_code) Where user_id = ? AND friend_id = ?");
			pStatement.setString(1, id);
			pStatement.setString(2, friendId);
			resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				friendNum = resultSet.getInt("friend_no");			
			}
		} catch (Exception e) {
			throw new DAOException("Error getting FriendRelationDTOs."
					+ e.getMessage());
		} finally {
			closeDBObjects(resultSet, pStatement, connection);
		}
		return friendNum;
	}
	
	

	@Override
	public List<FriendRelationDTO> getFriendRelationByFriendNum(
			Integer friendNum) throws DAOException {
		// TODO Auto-generated method stub
		List<FriendRelationDTO> friendRelationDTOs = new ArrayList<FriendRelationDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			pStatement = connection
					.prepareStatement(GET_FRIEND_RELATION_BY_FRIEND_NUM_SQL);
			pStatement.setInt(1, friendNum);
			resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				FriendRelationDTO friendRelationDTO = new FriendRelationDTO();
				friendRelationDTO.setFriendRelationCode(resultSet
						.getInt("friend_relation_code"));
				friendRelationDTO.setFriendNo(resultSet.getInt("friend_no"));
				friendRelationDTO.setBukkuIndex(resultSet.getInt("bukku_index"));
				friendRelationDTO.setId(resultSet.getString("id"));
				friendRelationDTOs.add(friendRelationDTO);
			}
		} catch (Exception e) {
			throw new DAOException("Error getting FriendRelationDTOs."
					+ e.getMessage());
		} finally {
			closeDBObjects(resultSet, pStatement, connection);
		}
		return friendRelationDTOs;

	}
	public FriendRelationDTO getFriendRelationByFriendNumID(
			Integer friendNum,String id) throws DAOException {
		// TODO Auto-generated method stub
		FriendRelationDTO friendRelationDTO = new FriendRelationDTO();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			pStatement = connection
					.prepareStatement(GET_FRIEND_RELATION_BY_FRIEND_NUM_ID_SQL);
			pStatement.setInt(1, friendNum);
			pStatement.setString(2,id);
			resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				friendRelationDTO.setFriendRelationCode(resultSet
						.getInt("friend_relation_code"));
				friendRelationDTO.setFriendNo(resultSet.getInt("friend_no"));
				friendRelationDTO.setBukkuIndex(resultSet.getInt("bukku_index"));
				friendRelationDTO.setId(resultSet.getString("id"));
				
			}
		} catch (Exception e) {
			throw new DAOException("Error getting FriendRelationDTOs."
					+ e.getMessage());
		} finally {
			closeDBObjects(resultSet, pStatement, connection);
		}
		return friendRelationDTO;

	}

	

	@Override
	public void updateBukkuIndex(Integer friendNum, String id)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_BUKKU_INDEX_SQL);

			pStatement.setInt(1, friendNum);
			pStatement.setString(2, id);
			pStatement.executeUpdate();
		} catch (Exception e) {
			throw new DAOException("Error updating friendRelationDTO."
					+ e.getMessage());
		} finally {
			closeDBObjects(null, pStatement, connection);
		}

	}

	@Override
	public void deleteFriendRelation(Integer friendNum) throws DAOException {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection
					.prepareStatement(DELETE_FRIEND_RELATION_SQL);
			pStatement.setInt(1, friendNum);
			pStatement.executeUpdate();
		} catch (Exception e) {
			throw new DAOException("Error deleting friendRelationDTO."
					+ e.getMessage());
		} finally {
			closeDBObjects(null, pStatement, connection);
		}

	}

	@Override
	public void deleteFriendRelationByFriendNumID(Integer friendNum, String id)
			throws DAOException {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection
					.prepareStatement(DELETE_FRIEND_RELATION_BY_FRIEND_NUM_ID_SQL);
			pStatement.setInt(1, friendNum);
			pStatement.setString(2, id);
			pStatement.executeUpdate();
		} catch (Exception e) {
			throw new DAOException("Error deleting friendRelationDTO."
					+ e.getMessage());
		} finally {
			closeDBObjects(null, pStatement, connection);
		}

	}

	@Override
	public void insertFriendRelation(Integer friendNum, String id)
			throws DAOException {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection
					.prepareStatement(INSERT_FRIEND_RELATION_SQL);

			pStatement.setInt(1, friendNum);
			pStatement.setString(2, id);
			pStatement.executeUpdate();
		} catch (Exception e) {
			throw new DAOException("Error inserting friendRelationDTO."
					+ e.getMessage());
		} finally {
			closeDBObjects(null, pStatement, connection);
		}
	}

	@Override
	public void insertFriendRelationBoth(String userId,String friendId) throws DAOException {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement pStatement1 = null;
		PreparedStatement pStatement2 = null;
		PreparedStatement pStatement3 = null;
		PreparedStatement pStatement4 = null;
		PreparedStatement pStatement5 = null;
		try{			
			connection = getConnection();

			pStatement1 = connection.prepareStatement("INSERT INTO common_relation_tb VALUES(common_relation_seq.nextval,5,sysdate)");
			pStatement2 = connection.prepareStatement("INSERT INTO friend_relation_tb VALUES(friend_relation_seq.nextval,250,common_relation_seq.CURRVAL ,?)");
			pStatement3 = connection.prepareStatement("INSERT INTO friend_relation_tb VALUES(friend_relation_seq.nextval,250,common_relation_seq.CURRVAL ,?)");
			pStatement4 = connection.prepareStatement("DELETE friend_adding_user_tb WHERE request_id=? AND receive_id=?");
			pStatement5 = connection.prepareStatement("DELETE friend_adding_user_tb WHERE request_id=? AND receive_id=?");

			pStatement2.setString(1,userId);
			pStatement3.setString(1,friendId);
			pStatement4.setString(1,userId);
			pStatement4.setString(2,friendId);
			pStatement5.setString(2,userId);
			pStatement5.setString(1,friendId);
		   pStatement1.executeUpdate();
		   pStatement2.executeUpdate();
		   pStatement3.executeUpdate();
		   pStatement4.executeUpdate();
		   pStatement5.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error inserting friendRelationDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement1,connection);
			
		}
	}

	
}