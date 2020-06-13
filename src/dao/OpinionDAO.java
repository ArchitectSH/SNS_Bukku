package dao;

import java.util.List;

import dto.OpinionDTO;

public interface OpinionDAO extends DAO{
	public List<OpinionDTO> getOpinion() throws DAOException;
	
	public List<OpinionDTO> getOpinionById(String id) throws DAOException;
	public OpinionDTO getOpinionByNum(Integer opinionNum) throws DAOException;
	public List<OpinionDTO> getOpinionByTitle(String title) throws DAOException;
	
	public void deleteOpinion(String id) throws DAOException;
	
	public void insertOpinion(String title, String content, String id) throws DAOException;
}
