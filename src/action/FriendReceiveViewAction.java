package action;

import java.util.List;

import dao.DAOException;
import dao.FriendReceiveViewDAO;
import dto.FriendReceiveViewDTO;

public class FriendReceiveViewAction {

	private FriendReceiveViewDAO friendReceiveViewDAO;

	public void setFriendReceiveViewDAO(
			FriendReceiveViewDAO friendReceiveViewDAO) {
		this.friendReceiveViewDAO = friendReceiveViewDAO;
	}

	public List<FriendReceiveViewDTO> getFriendReceiveView() {
		List<FriendReceiveViewDTO> friendReceiveViewDTOs = null;
		try {
			friendReceiveViewDTOs = friendReceiveViewDAO.getFriendReceiveView();
		} catch (DAOException e) {
		}
		return friendReceiveViewDTOs;
	}

	public List<FriendReceiveViewDTO> getFriendReceiveViewByRequestId(
			String requestId) {
		List<FriendReceiveViewDTO> friendReceiveViewDTOs = null;
		try {
			friendReceiveViewDTOs = friendReceiveViewDAO
					.getFriendReceiveViewByRequestId(requestId);
		} catch (DAOException e) {
		}
		return friendReceiveViewDTOs;
	}

	public List<FriendReceiveViewDTO> getFriendReceiveViewByReceiveId(
			String receiveId) {
		List<FriendReceiveViewDTO> friendReceiveViewDTOs = null;
		try {
			friendReceiveViewDTOs = friendReceiveViewDAO
					.getFriendReceiveViewByReceiveId(receiveId);
		} catch (DAOException e) {
		}
		return friendReceiveViewDTOs;
	}

	public FriendReceiveViewDTO getFriendReceiveViewRequestAndReceive(
			String requestId, String receiveId) {
		FriendReceiveViewDTO friendReceiveViewDTO = null;
		try {
			friendReceiveViewDTO = friendReceiveViewDAO
					.getFriendReceiveViewRequestAndReceive(requestId, receiveId);
		} catch (DAOException e) {
		}
		return friendReceiveViewDTO;
	}

}
