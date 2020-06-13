package action;

import java.util.List;

import dao.AdminDAO;
import dao.DAOException;
import dto.AdminDTO;

public class AdminAction {
	private AdminDAO adminDAO;

	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	public List<AdminDTO> getAdmin() {
		List<AdminDTO> adminDTOs = null;
		try {
			adminDTOs = adminDAO.getAdmin();
		} catch (DAOException e) {
		}
		return adminDTOs;
	}

	public AdminDTO getAdminById(String adminId) {
		AdminDTO adminDTO = null;
		try {
			adminDTO = adminDAO.getAdminById(adminId);
		} catch (DAOException e) {
		}
		return adminDTO;
	}

	public void updateAdmin(String password, String adminId) {
		try {
			adminDAO.updateAdmin(password, adminId);
		} catch (DAOException e) {
		}
	}

	public void deleteAdmin(String adminId, String password) {
		try {
			adminDAO.deleteAdmin(adminId, password);
		} catch (DAOException e) {
		}
	}

	public void insertAdmin(String adminId, String password) {
		try {
			adminDAO.insertAdmin(adminId, password);
		} catch (DAOException e) {
		}
	}

}
