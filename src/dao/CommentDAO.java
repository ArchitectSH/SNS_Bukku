package dao;
import java.util.List;

import dto.CommentDTO;

public interface CommentDAO extends DAO{
	public List<CommentDTO> getComment() throws DAOException;
	public CommentDTO getCommentByNum(Integer commentNum) throws DAOException;
	public List<CommentDTO> getCommentByPostNum(Integer postNum) throws DAOException;
	public List<CommentDTO> getCommentById(String id) throws DAOException;
	
	public List<CommentDTO> getCommentByIdPostNum(String id, Integer postNum) throws DAOException;
	public void updateCommentByCommentNum(String content, Integer commentNum) throws DAOException;
	
	public void deleteCommentByCommentNum(Integer commentNum) throws DAOException;
	
	public void deleteCommentByPostNum(Integer postNum) throws DAOException;
	public void deleteCommentById(String id) throws DAOException;
	
	public Integer insertComment(String content, Integer postNum, String id, Integer privacyLevel) throws DAOException;
}
