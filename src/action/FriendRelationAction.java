package action;

import java.util.List;

import dao.DAOException;
import dao.FriendRelationDAO;
import dto.FriendRelationDTO;

public class FriendRelationAction {
	private FriendRelationDAO friendRelationDAO;

	public void setFriendRelationDAO(FriendRelationDAO friendRelationDAO) {
		this.friendRelationDAO = friendRelationDAO;
	}

	public List<FriendRelationDTO> getFriendRelation() {
		List<FriendRelationDTO> friendRelationDTOs = null;
		try {
			friendRelationDTOs = friendRelationDAO.getFriendRelation();
		} catch (DAOException e) {
		}
		return friendRelationDTOs;
	}

	public List<FriendRelationDTO> getFriendRelationById(String id) {List<FriendRelationDTO> friendRelationDTOs = null;
	try {
		friendRelationDTOs = friendRelationDAO.getFriendRelationById(id);
	} catch (DAOException e) {
	}
	return friendRelationDTOs;

	}
	public Integer getFriendNumByIdNFriendId(String id,String friendId){
		Integer friendNo = null;
		try {
			friendNo = friendRelationDAO.getFriendNumByIdNFriendId(id, friendId);
		} catch (DAOException e) {
		}
		return friendNo;

	}

	public List<Integer> getFriendNumById(String id) {
		List<Integer> friendRelations = null;
	try {
		friendRelations = friendRelationDAO.getFriendNumById(id);
	} catch (DAOException e) {
	}
	return friendRelations;

	}

	public List<FriendRelationDTO> getFriendRelationByFriendNum(Integer friendNum) {
		
			List<FriendRelationDTO> friendRelationDTOs = null;
	try {
		friendRelationDTOs = friendRelationDAO.getFriendRelationByFriendNum(friendNum);
	} catch (DAOException e) {
	}
	return friendRelationDTOs;

			}
	public FriendRelationDTO getFriendRelationByFriendNumID(
			Integer friendNum,String id) {
		FriendRelationDTO friendRelationDTO = null;
		try {
			friendRelationDTO = friendRelationDAO.getFriendRelationByFriendNumID(friendNum, id);
		} catch (DAOException e) {
		}
		return friendRelationDTO;
	}

	public void updateBukkuIndex(Integer friendNum, String id) {
	try {
		friendRelationDAO.updateBukkuIndex(friendNum, id);
	} catch (DAOException e) {
	}
	

	}

	public void deleteFriendRelation(Integer friendNum) {try {
		friendRelationDAO.deleteFriendRelation(friendNum);
	} catch (DAOException e) {
	}

	}

	public void deleteFriendRelationByFriendNumID(Integer friendNum, String id) {try {
		friendRelationDAO.deleteFriendRelationByFriendNumID(friendNum, id);
	} catch (DAOException e) {
	}

	}

	public void insertFriendRelation(Integer friendNum, String id) {try {
		friendRelationDAO.insertFriendRelation(friendNum, id);
	} catch (DAOException e) {
	}

	}

	public void insertFriendRelationBoth(String userId, String friendId) {try {
		friendRelationDAO.insertFriendRelationBoth(userId, friendId);
	} catch (DAOException e) {
	}

	}

}
