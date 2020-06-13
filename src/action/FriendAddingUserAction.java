package action;

import java.util.List;

import dao.DAOException;
import dao.FriendAddingUserDAO;
import dto.FriendAddingUserDTO;

public class FriendAddingUserAction {
	private FriendAddingUserDAO friendAddingUserDAO;

	public void setFriendAddingUserDAO(FriendAddingUserDAO friendAddingUserDAO) {
		this.friendAddingUserDAO = friendAddingUserDAO;
	}

	public List<FriendAddingUserDTO> getFriendAddingUser() {
		List<FriendAddingUserDTO> friendAddingUserDTOs = null;
		try {
			friendAddingUserDTOs = friendAddingUserDAO.getFriendAddingUser();
		} catch (DAOException e) {
		}
		return friendAddingUserDTOs;
	}

	public List<FriendAddingUserDTO> getFriendAddingUserByReqId(String requestId) {
		List<FriendAddingUserDTO> friendAddingUserDTOs = null;
		try {
			friendAddingUserDTOs = friendAddingUserDAO.getFriendAddingUserByReqId(requestId);
		} catch (DAOException e) {
		}
		return friendAddingUserDTOs;
	}

	public List<FriendAddingUserDTO> getFriendAddingUserByRecId(String receiveId) {
		List<FriendAddingUserDTO> friendAddingUserDTOs = null;
		try {
			friendAddingUserDTOs = friendAddingUserDAO.getFriendAddingUserByRecId(receiveId);
		} catch (DAOException e) {
		}
		return friendAddingUserDTOs;
	}

	public List<String> getReceiveUser(String requestId) {
		List<String> friendAddingUsers = null;
		try {
			friendAddingUsers = friendAddingUserDAO.getReceiveUser(requestId);
		} catch (DAOException e) {
		}
		return friendAddingUsers;
	}

	public List<String> getRequestUser(String receiveId) {
		List<String> friendAddingUsers = null;
		try {
			friendAddingUsers = friendAddingUserDAO.getRequestUser(receiveId);
		} catch (DAOException e) {
		}
		return friendAddingUsers;
	}

	public void deleteByReqId(String requestId) {

		try {
			friendAddingUserDAO.deleteByReqId(requestId);;
		} catch (DAOException e) {
		}
	}

	public void deleteByRecId(String receiveId) {
		try {
			friendAddingUserDAO.deleteByRecId(receiveId);
		} catch (DAOException e) {
		}
	}

	public void deleteByFriendAddingUser(String requestId, String receiveId) {
		try {
			friendAddingUserDAO.deleteByFriendAddingUser(requestId, receiveId);
		} catch (DAOException e) {
		}
	}

	public void insertFriendAddingUser(String requestId, String receiveId) {
		try {
			friendAddingUserDAO.insertFriendAddingUser(requestId, receiveId);
		} catch (DAOException e) {
		}
	}

}
