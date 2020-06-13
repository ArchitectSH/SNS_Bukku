package dao;

import java.util.List;

import dto.RecommendationUserDTO;

public interface RecommendationUserDAO extends DAO{
	public List<RecommendationUserDTO> getRecommendationUser() throws DAOException;
	
	public List<RecommendationUserDTO> getRecommendationUserByPostNum(Integer postNum) throws DAOException;
	public RecommendationUserDTO getRecommendationUserByRecoNum(Integer recommendationNum) throws DAOException;
	public Integer getLikeBukkuCount(Integer postNum) throws DAOException;
	
	public Integer getHateCount(Integer postNum)  throws DAOException;
	
	public void updateRecommendationUser(Integer kind, Integer postNum, String id) throws DAOException;
	public void deleteRecommendationUserByPostNum(Integer postNum)  throws DAOException;
	public void deleteRecommendationUserByRecoNum(Integer recommendationNum) throws DAOException;
	public void deleteRecommendationUserById(String id)  throws DAOException;
	
	public void deleteRecommendationUserByPostNumId(Integer postNum, String id)  throws DAOException;
	
	public void insertRecommendationUser(Integer recommendationKind, Integer postNum, String id) throws DAOException;
}
