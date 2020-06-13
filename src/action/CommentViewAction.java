package action;

import java.util.List;

import dao.CommentViewDAO;
import dao.DAOException;
import dto.CommentViewDTO;


public class CommentViewAction {
	private CommentViewDAO commentViewDAO;
	public void setCommentViewDAO(CommentViewDAO commentViewDAO) {
		this.commentViewDAO = commentViewDAO;
	}
	
	public List<CommentViewDTO> getCommentView() {
		return null;
	}
	
	public List<CommentViewDTO> getCommentViewByPostNo(Integer postNo) {
		List<CommentViewDTO> list = null;
		try{
			list = commentViewDAO.getCommentViewByPostNo(postNo);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<CommentViewDTO> getCommentViewWirterId(String writerId) {
		return null;
	}
	
	public CommentViewDTO getCommentViewCommentNo(Integer commentNo) {
		return null;
	}
}
