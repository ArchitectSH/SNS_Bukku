package dao;

import java.util.List;

import dto.PostTagUserDTO;


public interface PostTagUserDAO extends DAO{
	public List<PostTagUserDTO> getPostTagUser() throws DAOException;
	public List<PostTagUserDTO> getPostTagUserByPostNum(Integer postNum) throws DAOException;
	
	public List<String> getTaggedId(Integer postNum)  throws DAOException;
	public PostTagUserDTO getPostTagUserByPostNumId(Integer postNum, String id) throws DAOException;
	
	public void deletePostTagUser(Integer postNum) throws DAOException;
	public void deletePostTagUser(String id)  throws DAOException;
	public void insertPostTagUser(Integer postNum, String id)  throws DAOException;
}
