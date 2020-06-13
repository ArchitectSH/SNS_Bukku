package dao;

import java.util.List;

import dto.PostContentDTO;

public interface PostContentDAO extends DAO{
	public List<PostContentDTO> getPostContent() throws DAOException;
	public List<PostContentDTO> getPostContent(String keyword) throws DAOException;
	public PostContentDTO getPostContentByNum(Integer contentNum) throws DAOException;
	
	public PostContentDTO getPostContentByPostNum(Integer postNum) throws DAOException;
	
	public void updatePostContentByPostNum(String postContent, String video, Integer postNum) throws DAOException;
	
	public void updatePostContent(String postContent, String video, Integer postContentNum)  throws DAOException;
	
	public void deletePostContentByPostNum(Integer postNum) throws DAOException;
	
	public void deletePostContent(Integer postContentNum)  throws DAOException;
	
	public Integer insertPostContent(String postContent, String video) throws DAOException;
}
