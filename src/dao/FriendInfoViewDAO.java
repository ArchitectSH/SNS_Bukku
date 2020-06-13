package dao;

import java.util.List;

import dto.FriendInfoViewDTO;



public interface FriendInfoViewDAO extends DAO{
	public List<FriendInfoViewDTO> getFriendInfoView() throws DAOException;
	
	
	
	public List<FriendInfoViewDTO> getFriendInfoViewByUserId(String userId) throws DAOException;
	
	
	
	public List<FriendInfoViewDTO> getFriendInfoViewByUserIdOrderBukku(String userId) throws DAOException;
	
	
	
	public List<FriendInfoViewDTO> getFriendInfoViewByFriendId(String friendId) throws DAOException;
	
	
	
	public FriendInfoViewDTO getFriendInfoViewByUserAndFriend(String userId, String friendId) throws DAOException;
	
	
	
	public FriendInfoViewDTO getFriendInfoViewByUserAndFriendAtti(String userId, String friendId) throws DAOException;
	
	
	}
