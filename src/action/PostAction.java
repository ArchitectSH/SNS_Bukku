//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : PostAction.java
//  @ Date : 2015-01-28
//  @ Author : 
//
//



package action;

import java.util.List;

import dao.DAOException;
import dao.PostDAO;
import dto.PostDTO;


public class PostAction {
	private PostDAO postDAO;
	public void setPostDAO(PostDAO postDAO) {
		this.postDAO = postDAO;
	}
	
	public List<PostDTO> getPost() {
		return null;
	}
	
	public List<PostDTO> getPostByDate(String startDate, String lastDate) {
		List<PostDTO> list = null;
		try{
			list = postDAO.getPostByDate(startDate, lastDate);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<PostDTO> getPostByCurrentDate() {
		return null;
	}
	
	public PostDTO getPostByNum(Integer postNum) {
		PostDTO pd =null;
		try{
			 pd = postDAO.getPostByNum(postNum);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return pd;
	}
	
	public void updatePost(Integer privacyLevel, Integer postNo) {
		try{
			 postDAO.updatePost(privacyLevel, postNo);
		}catch(DAOException e){
			e.printStackTrace();
		}
	}	
	
	public void deletePost(Integer postNo) {
		try{
			 postDAO.deletePost(postNo);
		}catch(DAOException e){
			e.printStackTrace();
		}
	}
	
	public Integer insertPost(Integer privacyLevel, String id, Integer contentNo) {
		Integer postNum = null;
		try{
			postNum = postDAO.insertPost(privacyLevel, id, contentNo);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return postNum;
	}
}