package action;

import java.util.List;

import dao.DAOException;
import dao.PostContentDAO;
import dto.PostContentDTO;


public class PostContentAction {
	private PostContentDAO postContentDAO;
	public void setPostContentDAO(PostContentDAO postContentDAO) {
		this.postContentDAO = postContentDAO;
	}
	
	public List<PostContentDTO> getPostContent(String keyword) {
		List<PostContentDTO> list = null;
		try{
			list = postContentDAO.getPostContent(keyword);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public PostContentDTO getPostContentByNum(Integer contentNum) {
		PostContentDTO pcd = null;
		try{
			pcd = postContentDAO.getPostContentByNum(contentNum);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return pcd;
	
	}
	
	public PostContentDTO getPostContentByPostNum(Integer postNum) {
		PostContentDTO pcd = null;
		try{
			pcd = postContentDAO.getPostContentByPostNum(postNum);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return pcd;
	}
	
	public void updatePostContentByPostNum(String postContent, String video, Integer postNum) {
		try{
			postContentDAO.updatePostContentByPostNum(postContent, video,  postNum);
		}catch(DAOException e){
			e.printStackTrace();
		}
	}
	
	public void updatePostContent(String postContent, String video, Integer postContentNum) {
		try{
			postContentDAO.updatePostContent(postContent, video, postContentNum);
		}catch(DAOException e){
			e.printStackTrace();
		}
	}
	
	public void deletePostContentByPostNum(Integer postNum) {
		try{
			postContentDAO.deletePostContentByPostNum(postNum);
		}catch(DAOException e){
			e.printStackTrace();
		}
	}
	
	public void deletePostContent(Integer postContentNum) {
		try{
			postContentDAO.deletePostContent(postContentNum);
		}catch(DAOException e){
			e.printStackTrace();
		}
	}
	
	public Integer insertPostContent(String postContent, String video) {
		Integer contentNo =null;
		try{
			contentNo = postContentDAO.insertPostContent(postContent, video);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return contentNo;
	}
}
