package dao;

import java.util.List;

import dto.ConfigurationViewDTO;


public interface ConfigurationViewDAO extends DAO{
	public List<ConfigurationViewDTO> getConfigurationView() throws DAOException;

	public ConfigurationViewDTO getConfigurationViewByUserId(String userId) throws DAOException;
	
	public List<ConfigurationViewDTO> getConfigurationViewByPrivacyLevel(Integer privacyLevel) throws DAOException;
}