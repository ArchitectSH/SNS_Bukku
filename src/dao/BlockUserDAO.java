package dao;

import java.util.List;

import dto.BlockUserDTO;

public interface BlockUserDAO extends DAO{
	public List<BlockUserDTO> getBlockUser() throws DAOException;

	public List<BlockUserDTO> getBlockUserByReqId(String requestId) throws DAOException;

	public List<BlockUserDTO> getBlockUserByBlockedId(String blockedId) throws DAOException;

	public BlockUserDTO getBlockUserPair(String requestId, String blockedId) throws DAOException;
	

	public void deleteBlockedUser(String blockedId) throws DAOException;

	public void deleteBlockRequestUser(String requestId) throws DAOException;

	
	public void deleteBlockUserPair(String requestId, String blockedId) throws DAOException;

	public void insertBlockUser(String blockedId, String blockRequestId) throws DAOException;

}
