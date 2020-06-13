package action;

import java.util.List;

import dao.ConfigurationViewDAO;
import dao.DAOException;
import dto.ConfigurationViewDTO;

public class ConfigurationViewAction {
	private ConfigurationViewDAO configurationViewDAO;

	public void setConfigurationViewDAO(
			ConfigurationViewDAO configurationViewDAO) {
		this.configurationViewDAO = configurationViewDAO;
	}

	public List<ConfigurationViewDTO> getConfigurationView() {
		List<ConfigurationViewDTO> configurationViewDTOs = null;
		try {
			configurationViewDTOs = configurationViewDAO.getConfigurationView();
		} catch (DAOException e) {
		}
		return configurationViewDTOs;
	}

	public ConfigurationViewDTO getConfigurationViewByUserId(String userId) {
		ConfigurationViewDTO configurationViewDTO = null;
		try {
			configurationViewDTO = configurationViewDAO
					.getConfigurationViewByUserId(userId);
		} catch (DAOException e) {
		}
		return configurationViewDTO;
	}

	public List<ConfigurationViewDTO> getConfigurationViewByPrivacyLevel(
			Integer privacyLevel) {
		List<ConfigurationViewDTO> configurationViewDTOs = null;
		try {
			configurationViewDTOs = configurationViewDAO
					.getConfigurationViewByPrivacyLevel(privacyLevel);
		} catch (DAOException e) {
		}
		return configurationViewDTOs;
	}
}
