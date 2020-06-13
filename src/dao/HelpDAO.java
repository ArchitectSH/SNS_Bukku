package dao;
import java.util.List;

import dto.HelpDTO;
public interface HelpDAO extends DAO{
	public List<HelpDTO> getHelp() throws DAOException;
	public HelpDTO getHelpByNum(Integer helpNum) throws DAOException;
	public List<HelpDTO> getHelpByTitle(String helpTitle) throws DAOException;
	public void updateHelp(String helpTitle, String helpContent, Integer helpNum) throws DAOException;
	public void updateHelpTitle(String helpTitle, Integer helpNum) throws DAOException;
	public void updateHelpContent(String helpContent, Integer helpNum) throws DAOException;
	public void deleteHelpById(String adminId) throws DAOException;
	public void deleteHelpByNum(Integer helpNum) throws DAOException;
	public void insertHelp(String adminId, String helpTitle, String helpContent) throws DAOException;
}
