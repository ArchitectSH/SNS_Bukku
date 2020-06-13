package dao;

import java.util.List;

import dto.PrivacyDTO;

public interface PrivacyDAO extends DAO{
	public List<PrivacyDTO> getPrivacy() throws DAOException;
	public Integer getPrivacyLevel(String privacyContent) throws DAOException;
	public String getPrivacyContent(Integer privacyLevel) throws DAOException;
	public void updatePrivacy(String privacyContent, Integer privacyLevel) throws DAOException;
	public void deletePrivacy(Integer privacyLevel) throws DAOException;
	public void deletePrivacyByContent(String privacyContent) throws DAOException;
	public void insertPrivacy(Integer privacyLevel, String privacyContent) throws DAOException;
}
