package dao;

import java.util.List;

import dto.RecommendationKindDTO;

public interface RecommendationKindDAO extends DAO{
	public List<RecommendationKindDTO> getRecommendationKind() throws DAOException;
	
	public RecommendationKindDTO getRecommendationKindByNum(Integer recommendationKindNum) throws DAOException;
	
	public void updateRecommendationKind(String recommendationKind, Integer recommendationKindNum) throws DAOException;
	
	public void deleteRecommendationKind(Integer recommendationKindNum)  throws DAOException;
	
	public void insertRecommendationKind(Integer recommendationKindNum, String recommendationKind) throws DAOException;
}
