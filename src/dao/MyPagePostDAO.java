package dao;

import java.util.List;

import dto.MyPagePostDTO;

public interface MyPagePostDAO extends DAO{
	public List<MyPagePostDTO> getMyPagePost() throws DAOException;
	public List<MyPagePostDTO> getMyPagePostById(String id) throws DAOException;
	public List<MyPagePostDTO> getMyPagePostByTitle(String title) throws DAOException;
	public void deleteMyPagePost(Integer postNum) throws DAOException;
	public void deleteMyPagePostByTitle(String myPageTitle) throws DAOException;
	public void insertMyPagePost(Integer postNum, String myPageTitle) throws DAOException;
}
