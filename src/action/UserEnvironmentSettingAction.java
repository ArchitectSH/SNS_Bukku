package action;

import java.util.List;

import dao.DAOException;
import dao.UserEnvironmentSettingDAO;
import dto.UserEnvironmentSettingDTO;

public class UserEnvironmentSettingAction {
	private UserEnvironmentSettingDAO userEnvironmentSettingDAO;

	public void setUserEnvironmentSettingDAO(
			UserEnvironmentSettingDAO userEnvironmentSettingDAO) {
		this.userEnvironmentSettingDAO = userEnvironmentSettingDAO;
	}

	public List<UserEnvironmentSettingDTO> getUserSetting() {
		List<UserEnvironmentSettingDTO> userEnvironmentSettingDTOs = null;
		try {
			userEnvironmentSettingDTOs = userEnvironmentSettingDAO
					.getUserSetting();
		} catch (DAOException e) {
		}
		return userEnvironmentSettingDTOs;
	}

	public UserEnvironmentSettingDTO getUserSettingById(String id) {
		UserEnvironmentSettingDTO userEnvironmentSettingDTO = null;
		try {
			userEnvironmentSettingDTO = userEnvironmentSettingDAO
					.getUserSettingById(id);
		} catch (DAOException e) {
		}
		return userEnvironmentSettingDTO;
	}

	public void updateUserSetting(Integer privacy, Boolean deactivation,
			Boolean userStop, String id) {
		try {
			userEnvironmentSettingDAO.updateUserSetting(privacy, deactivation,
					userStop, id);
		} catch (DAOException e) {
		}
	}

	public void updateSearchPrivacy(Integer privacyLevel, String id) {
		try {
			userEnvironmentSettingDAO.updateSearchPrivacy(privacyLevel, id);
		} catch (DAOException e) {
		}
	}

	public void updateDeactivation(Boolean deactivation, String id) {
		try {
			userEnvironmentSettingDAO.updateDeactivation(deactivation, id);
		} catch (DAOException e) {
		}
	}

	public void updateUserStop(Boolean userStop, String id) {
		try {
			userEnvironmentSettingDAO.updateUserStop(userStop, id);
		} catch (DAOException e) {
		}
	}

	public void deleteUserSetting(String id) {
		try {
			userEnvironmentSettingDAO.deleteUserSetting(id);
		} catch (DAOException e) {
		}
	}

	public void insertUserSetting(String id, Integer searchPrivacy,
			Boolean deactivation, Boolean userStop) {
		try {
			userEnvironmentSettingDAO.insertUserSetting(id, searchPrivacy,
					deactivation, userStop);
		} catch (DAOException e) {
		}
	}

}
