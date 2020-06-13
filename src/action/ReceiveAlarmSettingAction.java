package action;

import java.util.List;

import dao.DAOException;
import dao.ReceiveAlarmSettingDAO;
import dto.ReceiveAlarmSettingDTO;

public class ReceiveAlarmSettingAction {
	private ReceiveAlarmSettingDAO receiveAlarmSettingDAO;

	public void setReceiveAlarmSettingDAO(
			ReceiveAlarmSettingDAO receiveAlarmSettingDAO) {
		this.receiveAlarmSettingDAO = receiveAlarmSettingDAO;
	}

	public List<ReceiveAlarmSettingDTO> getAlarmSetting() {
		List<ReceiveAlarmSettingDTO> receiveAlarmSettingDTOs = null;
		try {
			receiveAlarmSettingDTOs = receiveAlarmSettingDAO.getAlarmSetting();
		} catch (DAOException e) {
		}
		return receiveAlarmSettingDTOs;
	}

	public ReceiveAlarmSettingDTO getAlarmSettingById(String id) {
		ReceiveAlarmSettingDTO receiveAlarmSettingDTO = null;
		try {
			receiveAlarmSettingDTO = receiveAlarmSettingDAO
					.getAlarmSettingById(id);
		} catch (DAOException e) {
		}
		return receiveAlarmSettingDTO;
	}

	public void updateAlarmSetting(Boolean postReceive, Boolean commentReceive,
			Boolean communityReceive, Boolean warningReceive, String id) {
		try {
			receiveAlarmSettingDAO.updateAlarmSetting(postReceive,
					commentReceive, communityReceive, warningReceive, id);
		} catch (DAOException e) {
		}
	}

	public void updatePostReceive(Boolean postReceive, String id) {
		try {
			receiveAlarmSettingDAO.updatePostReceive(postReceive, id);
		} catch (DAOException e) {
		}
	}

	public void updateCommentReceive(Boolean commentReceive, String id) {
		try {
			receiveAlarmSettingDAO.updateCommentReceive(commentReceive, id);
		} catch (DAOException e) {
		}
	}

	public void updateCommunityReceive(Boolean communityReceive, String id) {
		try {
			receiveAlarmSettingDAO.updateCommunityReceive(communityReceive, id);
		} catch (DAOException e) {
		}
	}

	public void updateWarningReceive(Boolean warningReceive, String id) {
		try {
			receiveAlarmSettingDAO.updateWarningReceive(warningReceive, id);
		} catch (DAOException e) {
		}
	}

	public void deleteAlarmSetting(String id) {
		try {
			receiveAlarmSettingDAO.deleteAlarmSetting(id);
		} catch (DAOException e) {
		}
	}

	public void insertAlarmSetting(String id, Boolean post, Boolean comment,
			Boolean community, Boolean warning) {
		try {
			receiveAlarmSettingDAO.insertAlarmSetting(id, post, comment,
					community, warning);
		} catch (DAOException e) {
		}
	}

}
