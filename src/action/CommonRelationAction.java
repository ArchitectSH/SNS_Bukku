package action;

import java.util.List;

import dao.CommonRelationDAO;
import dao.DAOException;
import dto.CommonRelationDTO;

public class CommonRelationAction {
	private CommonRelationDAO commonRelationDAO;

	public void setCommonRelationDAO(CommonRelationDAO commonRelationDAO) {
		this.commonRelationDAO = commonRelationDAO;
	}

	public List<CommonRelationDTO> getCommonRelation() {
		List<CommonRelationDTO> commonRelationDTOs = null;
		try {
			commonRelationDTOs = commonRelationDAO.getCommonRelation();
		} catch (DAOException e) {
		}
		return commonRelationDTOs;
	}

	public CommonRelationDTO getCommonRelationByFriendNum(Integer friendNum) {
		CommonRelationDTO commonRelationDTO = null;
		try {
			commonRelationDTO = commonRelationDAO
					.getCommonRelationByFriendNum(friendNum);
		} catch (DAOException e) {
		}
		return commonRelationDTO;
	}

	public Integer getBukkuLimit(Integer friendNum) {
		Integer bukkuLimit = null;
		try {
			bukkuLimit = commonRelationDAO.getBukkuLimit(friendNum);
		} catch (DAOException e) {
		}
		return bukkuLimit;
	}

	public void updateBukku(Integer friendNum) {
		try {
			commonRelationDAO.updateBukku(friendNum);
		} catch (DAOException e) {
		}
	}

	public void resetBukkuLimit() {
		try {
			commonRelationDAO.resetBukkuLimit();
		} catch (DAOException e) {
		}
	}

	public void deleteCommonRelation(Integer friendNum) {
		try {
			commonRelationDAO.deleteCommonRelation(friendNum);
		} catch (DAOException e) {
		}
	}

	public Integer insertCommonRelation() {
		Integer no = null;
		try {
			no=commonRelationDAO.insertCommonRelation();
		} catch (DAOException e) {
		}
		return no;
	}
}
