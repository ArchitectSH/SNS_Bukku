package dao;

import java.util.List;

import dto.FriendReceiveViewDTO;



public interface FriendReceiveViewDAO extends DAO{
	public List<FriendReceiveViewDTO> getFriendReceiveView() throws DAOException;
	
	
	
	public List<FriendReceiveViewDTO> getFriendReceiveViewByRequestId(String requestId) throws DAOException;
	
	
	
	public List<FriendReceiveViewDTO> getFriendReceiveViewByReceiveId(String receiveId) throws DAOException;
	
	
	
	public FriendReceiveViewDTO getFriendReceiveViewRequestAndReceive(String requestId, String receiveId) throws DAOException;
	
	
	}
