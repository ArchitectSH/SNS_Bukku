package dao;

import java.util.List;

import dto.GroupPostDTO;
public interface GroupPostDAO extends DAO{
	public List<GroupPostDTO> getGroupPost() throws DAOException;
	public List<GroupPostDTO> getGroupPostById(String id) throws DAOException;
	public List<GroupPostDTO> getGroupPostByGroupNum(Integer groupNum) throws DAOException;
	public void deleteGroupPostByPostNum(Integer postNum) throws DAOException;
	public void deleteGroupPostByGroupNum(Integer groupNum) throws DAOException;
	public void insertGroupPost(Integer postNum, Integer groupNum) throws DAOException;
}
