package dao;

import java.util.List;

import dto.CommonRelationDTO;

public interface CommonRelationDAO extends DAO{
	public List<CommonRelationDTO> getCommonRelation() throws DAOException;
		
	
	public CommonRelationDTO getCommonRelationByFriendNum(Integer friendNum) throws DAOException;
	
	
	
	public Integer getBukkuLimit(Integer friendNum) throws DAOException;

	public void updateBukku(Integer friendNum) throws DAOException;

	public void resetBukkuLimit() throws DAOException;

	
	public void deleteCommonRelation(Integer friendNum) throws DAOException;

	public Integer insertCommonRelation() throws DAOException;

}
