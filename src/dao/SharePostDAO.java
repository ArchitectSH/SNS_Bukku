package dao;

import java.util.List;

import dto.SharePostDTO;



public interface SharePostDAO extends DAO{
	public List<SharePostDTO> getSharePost() throws DAOException;
	
	public List<SharePostDTO> getSharePostByPostNum(Integer postNum) throws DAOException;
	
	public List<SharePostDTO> getSharePostByOriginPostNum(Integer originPostNum) throws DAOException;
	
	public void deleteSharePostByPostNum(Integer postNum)  throws DAOException;
	
	public void deleteSharePostByOriginPostNum(Integer originPostNum) throws DAOException;
	public void insertSharePost(Integer postNum, Integer originPostNum) throws DAOException;
}
