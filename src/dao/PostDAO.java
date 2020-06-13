package dao;

import java.util.List;

import dto.PostDTO;

public interface PostDAO extends DAO{
	public List<PostDTO> getPost() throws DAOException;
	
	public List<PostDTO> getPostByDate(String startDate, String lastDate) throws DAOException;
	public List<PostDTO> getPostByCurrentDate(Integer beforeDays) throws DAOException;
	
	public PostDTO getPostByNum(Integer postNum) throws DAOException;
	
	public void updatePost(Integer privacyLevel, Integer postNo) throws DAOException;
	public void deletePost(Integer postNo)  throws DAOException;
	public void deletePostById(String id) throws DAOException;
	public Integer insertPost(Integer privacyLevel, String id, Integer contentNo)  throws DAOException;
}
