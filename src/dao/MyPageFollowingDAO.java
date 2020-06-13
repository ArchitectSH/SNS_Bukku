package dao;

import java.util.*;

import dto.*;


public interface MyPageFollowingDAO extends DAO{
	public List<MyPageFollowingDTO> getMyPageFollowing() throws DAOException;
	public List<MyPageFollowingDTO> getMyPageFollowingByTitle(String title) throws DAOException;
	public List<MyPageFollowingDTO> getMyPageFollowingById(String id) throws DAOException;
	public void deleteMyPageFollowing(String myPageTitle) throws DAOException;
	public void deleteMyPageFollowingByTitleId(String myPageTitle, String id) throws DAOException;
	public void deleteMyPageFollowingById(String id) throws DAOException;
	public void insertMyPageFollowing(String myPageTitle, String id) throws DAOException;
}
