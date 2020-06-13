package dao;

import java.util.List;

import dto.CommentViewDTO;

public interface CommentViewDAO extends DAO{
	public List<CommentViewDTO> getCommentView() throws DAOException;
	public List<CommentViewDTO> getCommentViewByPostNo(Integer postNo)throws DAOException;
	
	public List<CommentViewDTO> getCommentViewWirterId(String writerId)throws DAOException;
	public CommentViewDTO getCommentViewCommentNo(Integer commentNo)throws DAOException;
}
