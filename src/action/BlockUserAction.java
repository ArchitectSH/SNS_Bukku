package action;

import java.util.List;

import dao.BlockUserDAO;
import dao.DAOException;
import dto.BlockUserDTO;

public class BlockUserAction {
	private BlockUserDAO blockUserDAO;

	public void setBlockUserDAO(BlockUserDAO blockUserDAO) {
		this.blockUserDAO = blockUserDAO;
	}

	public List<BlockUserDTO> getBlockUser() {
		List<BlockUserDTO> blockUserDTOs = null;
		try {
			blockUserDTOs = blockUserDAO.getBlockUser();
		} catch (DAOException e) {
		}
		return blockUserDTOs;
	}

	public List<BlockUserDTO> getBlockUserByReqId(String requestId) {	
	List<BlockUserDTO> blockUserDTOs = null;
	try {
		blockUserDTOs = blockUserDAO.getBlockUserByReqId(requestId);
	} catch (DAOException e) {
	}
	return blockUserDTOs;
	}

	public List<BlockUserDTO> getBlockUserByBlockedId(String blockedId) {	
	List<BlockUserDTO> blockUserDTOs = null;
	try {
		blockUserDTOs = blockUserDAO.getBlockUserByBlockedId(blockedId);
	} catch (DAOException e) {
	}
	return blockUserDTOs;
	}

	public BlockUserDTO getBlockUserPair(String requestId, String blockedId) {
	BlockUserDTO blockUserDTO = null;
	try {
		blockUserDTO = blockUserDAO.getBlockUserPair(requestId, blockedId);
	} catch (DAOException e) {
	}
	return blockUserDTO;
	}

	public void deleteBlockedUser(String blockedId) {	
	try {
		 blockUserDAO.deleteBlockedUser(blockedId);
	} catch (DAOException e) {
	}
		}

	public void deleteBlockRequestUser(String requestId) {
		try {
			 blockUserDAO.deleteBlockRequestUser(requestId);
		} catch (DAOException e) {
		}
	}

	public void deleteBlockUserPair(String requestId, String blockedId) {
		try {
			 blockUserDAO.deleteBlockUserPair(requestId, blockedId);
		} catch (DAOException e) {
		}
	}

	public void insertBlockUser(String blockedId, String blockRequestId) {
		try {
			 blockUserDAO.insertBlockUser(blockedId, blockRequestId);
		} catch (DAOException e) {
		}
	}
}
