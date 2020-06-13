package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.FriendReceiveViewDTO;




public class FriendReceiveViewDAOImpl extends BaseDAO implements FriendReceiveViewDAO {
	private final static String GET_FRIEND_RECEIVE_VIEW_SQL = "SELECT * FROM friend_receive_view";
	private final static String GET_FRIEND_RECEIVE_VIEW_BY_REQUEST_ID_SQL = "SELECT * FROM friend_receive_view WHERE request_id=?";
	private final static String GET_FRIEND_RECEIVE_VIEW_BY_RECEIVE_ID_SQL = "SELECT * FROM friend_receive_view WHERE receive_id=?";
	private final static String GET_FRIEND_RECEIVE_VIEW_BY_REQUEST_RECEIVE_SQL = "SELECT * FROM friend_receive_view WHERE receive_id=? AND request_id=?";
	@Override
	public List<FriendReceiveViewDTO> getFriendReceiveView()
			throws DAOException {
		// TODO Auto-generated method stub
		List<FriendReceiveViewDTO> friendReceiveViewDTOs = new ArrayList<FriendReceiveViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_FRIEND_RECEIVE_VIEW_SQL );
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				FriendReceiveViewDTO friendReceiveViewDTO = new FriendReceiveViewDTO();
				friendReceiveViewDTO.setRequestId(resultSet.getString("request_id"));
				friendReceiveViewDTO.setRequestProfileImg(resultSet.getString("request_profile_img"));
				friendReceiveViewDTO.setRequestName(resultSet.getString("request_name"));
				friendReceiveViewDTO.setReceiveId(resultSet.getString("receive_id"));
				friendReceiveViewDTO.setReceiveProfileImg(resultSet.getString("receive_profile_img"));
				friendReceiveViewDTO.setReceiveName(resultSet.getString("receive_name"));
				friendReceiveViewDTOs.add(friendReceiveViewDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting FriendReceiveViewDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return friendReceiveViewDTOs;

	}
	@Override
	public List<FriendReceiveViewDTO> getFriendReceiveViewByRequestId(
			String requestId) throws DAOException {
		// TODO Auto-generated method stub
		List<FriendReceiveViewDTO> friendReceiveViewDTOs = new ArrayList<FriendReceiveViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_FRIEND_RECEIVE_VIEW_BY_REQUEST_ID_SQL );
			pStatement.setString(1,requestId);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				FriendReceiveViewDTO friendReceiveViewDTO = new FriendReceiveViewDTO();
				friendReceiveViewDTO.setRequestId(resultSet.getString("request_id"));
				friendReceiveViewDTO.setRequestProfileImg(resultSet.getString("request_profile_img"));
				friendReceiveViewDTO.setRequestName(resultSet.getString("request_name"));
				friendReceiveViewDTO.setReceiveId(resultSet.getString("receive_id"));
				friendReceiveViewDTO.setReceiveProfileImg(resultSet.getString("receive_profile_img"));
				friendReceiveViewDTO.setReceiveName(resultSet.getString("receive_name"));
				friendReceiveViewDTOs.add(friendReceiveViewDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting FriendReceiveViewDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return friendReceiveViewDTOs;
	}
	@Override
	public List<FriendReceiveViewDTO> getFriendReceiveViewByReceiveId(
			String receiveId) throws DAOException {
		// TODO Auto-generated method stub
		List<FriendReceiveViewDTO> friendReceiveViewDTOs = new ArrayList<FriendReceiveViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_FRIEND_RECEIVE_VIEW_BY_RECEIVE_ID_SQL );
			pStatement.setString(1,receiveId);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				FriendReceiveViewDTO friendReceiveViewDTO = new FriendReceiveViewDTO();
				friendReceiveViewDTO.setRequestId(resultSet.getString("request_id"));
				friendReceiveViewDTO.setRequestProfileImg(resultSet.getString("request_profile_img"));
				friendReceiveViewDTO.setRequestName(resultSet.getString("request_name"));
				friendReceiveViewDTO.setReceiveId(resultSet.getString("receive_id"));
				friendReceiveViewDTO.setReceiveProfileImg(resultSet.getString("receive_profile_img"));
				friendReceiveViewDTO.setReceiveName(resultSet.getString("receive_name"));
				friendReceiveViewDTOs.add(friendReceiveViewDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting FriendReceiveViewDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return friendReceiveViewDTOs;
	}
	@Override
	public FriendReceiveViewDTO getFriendReceiveViewRequestAndReceive(
			String requestId, String receiveId) throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		FriendReceiveViewDTO friendReceiveViewDTO=null;
		try{
			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_FRIEND_RECEIVE_VIEW_BY_REQUEST_RECEIVE_SQL );
			pStatement.setString(1,requestId);
			pStatement.setString(2,receiveId);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				friendReceiveViewDTO = new FriendReceiveViewDTO();
				friendReceiveViewDTO.setRequestId(resultSet.getString("request_id"));
				friendReceiveViewDTO.setRequestProfileImg(resultSet.getString("request_profile_img"));
				friendReceiveViewDTO.setRequestName(resultSet.getString("request_name"));
				friendReceiveViewDTO.setReceiveId(resultSet.getString("receive_id"));
				friendReceiveViewDTO.setReceiveProfileImg(resultSet.getString("receive_profile_img"));
				friendReceiveViewDTO.setReceiveName(resultSet.getString("receive_name"));
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting friendReceiveViewDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return friendReceiveViewDTO;

	}

}