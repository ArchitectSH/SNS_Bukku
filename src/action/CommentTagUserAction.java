package action;

import java.util.List;

import dao.CommentTagUserDAO;
import dao.DAOException;
import dto.CommentTagUserDTO;


public class CommentTagUserAction {
	private CommentTagUserDAO commentTagUserDAO;
	public void setCommentTagUserDAO(CommentTagUserDAO commentTagUserDAO) {
		this.commentTagUserDAO = commentTagUserDAO;
	}
	
	public List<CommentTagUserDTO> getCommentTagUser() {
		return null;
	}
	
	public List<CommentTagUserDTO> getCommentTagByNum(Integer commentNum) {
		List<CommentTagUserDTO> list = null;
		try{
			list = commentTagUserDAO.getCommentTagByNum(commentNum);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<String> getTaggedId(Integer commentNum) {
		return null;
	}
	
	public void getCommentTagUserByComNumId(Integer commentNum, String id) {
		
	}
	
	public void deleteCommentTagUser(Integer commentNum) {
		try{
			commentTagUserDAO.deleteCommentTagUser(commentNum);
		}catch(DAOException e){
			e.printStackTrace();
		}
	}
	
	public void deleteCommentTagUserById(String id) {
		try{
			commentTagUserDAO.deleteCommentTagUserById(id);
		}catch(DAOException e){
			e.printStackTrace();
		}
	}
	
	public void insertComment(Integer commentNum, String id) {
		try{
			commentTagUserDAO.insertComment(commentNum, id);
		}catch(DAOException e){
			e.printStackTrace();
		}
	}
}
