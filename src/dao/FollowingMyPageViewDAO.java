package dao;

import java.util.List;

import dto.*;

public interface FollowingMyPageViewDAO extends DAO{
	public List<FollowingMyPageViewDTO> getFollowingMyPageView() throws DAOException;
	public List<FollowingMyPageViewDTO> getFollowingMyPageViewById(String id) throws DAOException;	
	public List<FollowingMyPageViewDTO> getFollowingMyPageViewByTitleId(String title, String id) throws DAOException;
}
