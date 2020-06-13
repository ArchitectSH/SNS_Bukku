package dao;

import java.util.List;

import dto.AdminDTO;


public interface AdminDAO extends DAO {

	public List<AdminDTO> getAdmin() throws DAOException;
	
	public AdminDTO getAdminById(String adminId) throws DAOException;
	
	public void updateAdmin(String password, String adminId) throws DAOException;
	
	public void deleteAdmin(String adminId, String password) throws DAOException;
	
	public void insertAdmin(String adminId,String password) throws DAOException;
}
