package dao;

import java.util.List;

import dto.FriendRelationDTO;

public interface FriendRelationDAO extends DAO{
	public List<FriendRelationDTO> getFriendRelation()  throws DAOException;
		
	 
	
	public List<FriendRelationDTO> getFriendRelationById(String id)  throws DAOException;
	
	 
	
	public List<Integer> getFriendNumById(String id)  throws DAOException;
	
	public Integer getFriendNumByIdNFriendId(String id,String friendId) throws DAOException;
	
	public List<FriendRelationDTO> getFriendRelationByFriendNum(Integer friendNum)  throws DAOException;
	
	 
	
	public void updateBukkuIndex(Integer friendNum, String id)  throws DAOException;
	
	 
	public FriendRelationDTO getFriendRelationByFriendNumID(
			Integer friendNum,String id) throws DAOException;
	public void deleteFriendRelation(Integer friendNum)  throws DAOException;
	
	 
	
	public void deleteFriendRelationByFriendNumID(Integer friendNum, String id)  throws DAOException;
	
	 
	
	public void insertFriendRelation(Integer friendNum, String id)  throws DAOException;
	public void insertFriendRelationBoth(String userId,String friendId) throws DAOException;
}
	 
 
