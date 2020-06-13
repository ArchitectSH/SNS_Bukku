package dao;

import java.util.List;

import dto.FriendAddingUserDTO;

public interface FriendAddingUserDAO extends DAO{
	public List<FriendAddingUserDTO> getFriendAddingUser() throws DAOException;
		
	 
	
	public List<FriendAddingUserDTO> getFriendAddingUserByReqId(String requestId) throws DAOException;
	
	 
	
	public List<FriendAddingUserDTO> getFriendAddingUserByRecId(String receiveId) throws DAOException;
	
	 
	
	public List<String> getReceiveUser(String requestId) throws DAOException;
	
	 
	
	public List<String> getRequestUser(String receiveId) throws DAOException;
	
	 
	
	public void deleteByReqId(String requestId) throws DAOException;
	
	 
	
	public void deleteByRecId(String receiveId) throws DAOException;
	
	 
	
	public void deleteByFriendAddingUser(String requestId, String receiveId) throws DAOException;
	
	 
	
	public void insertFriendAddingUser(String requestId, String receiveId) throws DAOException;
	
	 
	}
