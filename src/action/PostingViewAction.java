//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : PostingViewAction.java
//  @ Date : 2015-01-28
//  @ Author : 
//
//



package action;

import java.util.List;

import dao.DAOException;
import dao.PostingViewDAO;
import dto.PostingViewDTO;


public class PostingViewAction {
	private PostingViewDAO postingViewDAO;
	public void setPostingViewDAO(PostingViewDAO postingViewDAO) {
		this.postingViewDAO = postingViewDAO;
	}
	
	public List<PostingViewDTO> getPostingView() {
		return null;
	}
	
	public List<PostingViewDTO> getPostingViewById(String id) {
		List<PostingViewDTO> list = null;
		try{
			list = postingViewDAO.getPostingViewById(id);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public PostingViewDTO getPostingViewByPostNo(Integer postNo) {
		PostingViewDTO pvd = null;
		try{
			pvd = postingViewDAO.getPostingViewByPostNo(postNo);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return pvd;
	}
	
	public List<PostingViewDTO> getPostingViewByDate(String startDate, String lastDate) {
		List<PostingViewDTO> list = null;
		try{
			list = postingViewDAO.getPostingViewByDate(startDate, lastDate);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<PostingViewDTO> getPostingViewByCurrentDate(Integer beforeDays) {
		return null;
	}
	
	public List<PostingViewDTO> getPostingViewByPostContent(String postContent) {
		List<PostingViewDTO> list = null;
		try{
			list = postingViewDAO.getPostingViewByPostContent(postContent);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public PostingViewDTO getPostingViewBypostContentNo(Integer postContentNo) {
		return null;
	}
	
	public List<PostingViewDTO> getPostingViewByMyPageTitle(String mypageTitle) {
		List<PostingViewDTO> list = null;
		try{
			list = postingViewDAO.getPostingViewByMyPageTitle(mypageTitle);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<PostingViewDTO> getPostingViewByGroupNo(Integer groupNo) {
		List<PostingViewDTO> list = null;
		try{
			list = postingViewDAO.getPostingViewByGroupNo(groupNo);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<PostingViewDTO> getPostingViewByGuestId(String guestId) {
		List<PostingViewDTO> list = null;
		try{
			list = postingViewDAO.getPostingViewByGuestId(guestId);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<PostingViewDTO> getPostingViewByIdAndGuestId(String id, String guestId) {
		List<PostingViewDTO> list = null;
		try{
			list = postingViewDAO.getPostingViewByIdAndGuestId(id, guestId);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<PostingViewDTO> getPostingViewByOriginPostNo(Integer originPostNo) {
		List<PostingViewDTO> list = null;
		try{
			list = postingViewDAO.getPostingViewByOriginPostNo(originPostNo);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<PostingViewDTO> getMyPagePostingView(String id) {
		List<PostingViewDTO> list = null;
		try{
			list = postingViewDAO.getMyPagePostingView(id);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<PostingViewDTO> getGroupPostingView(String id) {
		List<PostingViewDTO> list = null;
		try{
			list = postingViewDAO.getGroupPostingView(id);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<PostingViewDTO> getFriendLikeView(String id) {
		List<PostingViewDTO> list = null;
		try{
			list = postingViewDAO.getFriendLikeView(id);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<PostingViewDTO> getFriendCommentedView(String id) {
		List<PostingViewDTO> list = null;
		try{
			list = postingViewDAO.getFriendCommentedView(id);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<PostingViewDTO> getFriendTaggedView(String id) {
		List<PostingViewDTO> list = null;
		try{
			list = postingViewDAO.getFriendTaggedView(id);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<PostingViewDTO> getFriendPostingView(String id) {
		List<PostingViewDTO> list = null;
		try{
			list = postingViewDAO.getFriendPostingView(id);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<PostingViewDTO> getPostingViewByContentDate(String content, String startDate, String lastDate){
		List<PostingViewDTO> list = null;
		try{
			list = postingViewDAO.getPostingViewByContentDate(content, startDate, lastDate);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return list;
	}
}
