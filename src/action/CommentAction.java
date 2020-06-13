package action;

import java.util.List;

import dao.CommentDAO;
import dao.DAOException;
import dto.CommentDTO;


public class CommentAction {
	private CommentDAO commentDAO;
	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}
	
	public List<CommentDTO> getComment(){
		List<CommentDTO> commentList=null;
		try{
			commentList=commentDAO.getComment();
		}catch(DAOException e){
			e.printStackTrace();
		}
		
		return commentList;
	}
	
	public CommentDTO getCommentByNum(Integer commentNum) {
		CommentDTO comment=null;
		try{
			comment =  commentDAO.getCommentByNum(commentNum);
		}catch(DAOException e){
			e.printStackTrace();
		}
		
		return comment;
	}
	
	public List<CommentDTO> getCommentByPostNum(Integer postNum) {
		List<CommentDTO> list = null;
		try{
			list = commentDAO.getCommentByPostNum(postNum);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<CommentDTO> getCommentById(String id) {
		List<CommentDTO> list = null;
		try{
			list = commentDAO.getCommentById(id);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<CommentDTO> getCommentByIdPostNum(String id, Integer postNum) {
		List<CommentDTO> list = null;
		try{
			list = commentDAO.getCommentByIdPostNum(id, postNum);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public void updateCommentByCommentNum(String content, Integer commentNum) {
		try{
			commentDAO.updateCommentByCommentNum(content, commentNum);
		}catch(DAOException e){
			e.printStackTrace();
		}
	}
	
	public void deleteCommentByCommentNum(Integer commentNum) {
		try{
			commentDAO.deleteCommentByCommentNum(commentNum);
		}catch(DAOException e){
			e.printStackTrace();
		}
	}
	
	public void deleteCommentByPostNum(Integer postNum) {
		try{
			commentDAO.deleteCommentByPostNum(postNum);
		}catch(DAOException e){
			e.printStackTrace();
		}
	}
	
	public void deleteCommentById(String id) {
		try{
			commentDAO.deleteCommentById(id);
		}catch(DAOException e){
			e.printStackTrace();
		}
	}
	
	public Integer insertComment(String content, Integer postNum, String id, Integer privacyLevel) {
		Integer commentNo=null;
		try{
			commentNo = commentDAO.insertComment(content, postNum, id, privacyLevel);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return commentNo;
	}
}
