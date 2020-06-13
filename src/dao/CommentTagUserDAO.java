package dao;

import java.util.List;

import dto.CommentTagUserDTO;


public interface CommentTagUserDAO extends DAO {
	public List<CommentTagUserDTO> getCommentTagUser() throws DAOException;
	public List<CommentTagUserDTO> getCommentTagByNum(Integer commentNum) throws DAOException;
	public List<String> getTaggedId(Integer commentNum) throws DAOException;
	public CommentTagUserDTO getCommentTagUserByComNumId(Integer commentNum, String id) throws DAOException;
	public void deleteCommentTagUser(Integer commentNum) throws DAOException;
	public void deleteCommentTagUserById(String id) throws DAOException;
	public void insertComment(Integer commentNum, String id) throws DAOException; 
}
