package action;

import java.util.List;

import dao.DAOException;
import dao.FriendInfoViewDAO;
import dto.FriendInfoViewDTO;

public class FriendInfoViewAction {
	
	private FriendInfoViewDAO friendInfoViewDAO;
	
public void setFriendInfoViewDAO(FriendInfoViewDAO friendInfoViewDAO) {
		this.friendInfoViewDAO = friendInfoViewDAO;
	}



public List<FriendInfoViewDTO> getFriendInfoView() { 	
	List<FriendInfoViewDTO> friendInfoViewDTOs = null;
try {
	friendInfoViewDTOs = friendInfoViewDAO.getFriendInfoView();
} catch (DAOException e) {
}
return friendInfoViewDTOs; }
	
	
	
	public List<FriendInfoViewDTO> getFriendInfoViewByUserId(String userId) {  	List<FriendInfoViewDTO> friendInfoViewDTOs = null;
	try {
		friendInfoViewDTOs = friendInfoViewDAO.getFriendInfoViewByUserId(userId);
	} catch (DAOException e) {
	}
	return friendInfoViewDTOs;}
	
	
	
	public List<FriendInfoViewDTO> getFriendInfoViewByUserIdOrderBukku(String userId) {	List<FriendInfoViewDTO> friendInfoViewDTOs = null;
	try {
		friendInfoViewDTOs = friendInfoViewDAO.getFriendInfoViewByUserIdOrderBukku(userId);
	} catch (DAOException e) {
	}
	return friendInfoViewDTOs;  }
	
	
	
	public List<FriendInfoViewDTO> getFriendInfoViewByFriendId(String friendId) { 	List<FriendInfoViewDTO> friendInfoViewDTOs = null;
	try {
		friendInfoViewDTOs = friendInfoViewDAO.getFriendInfoViewByFriendId(friendId);
	} catch (DAOException e) {
	}
	return friendInfoViewDTOs; }
	
	
	
	public FriendInfoViewDTO getFriendInfoViewByUserAndFriend(String userId, String friendId) {	
		FriendInfoViewDTO friendInfoViewDTO = null;
	try {
		friendInfoViewDTO = friendInfoViewDAO.getFriendInfoViewByUserAndFriend(userId, friendId);
	} catch (DAOException e) {
	}
	return friendInfoViewDTO;  }
	
	
	
	public FriendInfoViewDTO getFriendInfoViewByUserAndFriendAtti(String userId, String friendId) {		FriendInfoViewDTO friendInfoViewDTO = null;
	try {
		friendInfoViewDTO = friendInfoViewDAO.getFriendInfoViewByUserAndFriendAtti(userId, friendId);
	} catch (DAOException e) {
	}
	return friendInfoViewDTO;  }
	

}
