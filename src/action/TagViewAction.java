//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : TagViewAction.java
//  @ Date : 2015-01-28
//  @ Author : 
//
//



package action;

import java.util.List;

import dao.DAOException;
import dao.TagViewDAO;
import dto.SharePostDTO;
import dto.TagViewDTO;


public class TagViewAction {
	private TagViewDAO tagViewDAO;
	public void setTagViewDAO(TagViewDAO tagViewDAO) {
		this.tagViewDAO = tagViewDAO;
	}
	
	public List<TagViewDTO> getTagView() {
		return null;
	}
	
	public List<TagViewDTO> getTagViewByCommentNo(Integer commentNo) {
		List<TagViewDTO> list = null;
		try{
			list =  tagViewDAO.getTagViewByCommentNo(commentNo);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<TagViewDTO> getTagViewByPostNo(Integer postNo) {
		List<TagViewDTO> list = null;
		try{
			list =  tagViewDAO.getTagViewByPostNo(postNo);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<TagViewDTO> getTagViewByPostNoAndTaggedUserId(Integer postNo, String taggedUserId) {
		List<TagViewDTO> list = null;
		try{
			list =  tagViewDAO.getTagViewByPostNoAndTaggedUserId(postNo, taggedUserId);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<TagViewDTO> getTagViewByTaggedUserId(String taggedUserId) {
		List<TagViewDTO> list = null;
		try{
			list =  tagViewDAO.getTagViewByTaggedUserId(taggedUserId);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return list;
	}
}