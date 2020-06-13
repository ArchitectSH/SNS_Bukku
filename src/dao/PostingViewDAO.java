package dao;

import java.util.List;

import dto.PostingViewDTO;
import dto.PostingViewDTO;

public interface PostingViewDAO extends DAO{
	public List<PostingViewDTO> getPostingView()throws DAOException;
	public List<PostingViewDTO> getPostingViewById(String id) throws DAOException;
	public PostingViewDTO getPostingViewByPostNo(Integer postNo) throws DAOException;
	
	public List<PostingViewDTO> getPostingViewByDate(String startDate, String lastDate) throws DAOException;
	
	public List<PostingViewDTO> getPostingViewByCurrentDate(Integer beforeDays) throws DAOException;
	public List<PostingViewDTO> getPostingViewByPostContent(String postContent) throws DAOException;
	public PostingViewDTO getPostingViewBypostContentNo(Integer postContentNo) throws DAOException;
	
	public List<PostingViewDTO> getPostingViewByMyPageTitle(String mypageTitle) throws DAOException;
	
	public List<PostingViewDTO> getPostingViewByGroupNo(Integer groupNo) throws DAOException;
	
	public List<PostingViewDTO> getPostingViewByGuestId(String guestId) throws DAOException;
	public List<PostingViewDTO> getPostingViewByIdAndGuestId(String id, String guestId) throws DAOException;
	
	public List<PostingViewDTO> getPostingViewByOriginPostNo(Integer originPostNo) throws DAOException;
	
	public List<PostingViewDTO> getTaggedFriendPostingView(String id) throws DAOException;
	public List<PostingViewDTO> getMyPagePostingView(String id) throws DAOException;
	public List<PostingViewDTO> getGroupPostingView(String id) throws DAOException;
	public List<PostingViewDTO> getFriendLikeView(String id) throws DAOException;
	public List<PostingViewDTO> getFriendCommentedView(String id) throws DAOException;
	public List<PostingViewDTO> getFriendTaggedView(String id) throws DAOException;
	public List<PostingViewDTO> getFriendPostingView(String id) throws DAOException;
	public List<PostingViewDTO> getPostingViewByContentDate(String content, String startDate, String lastDate) throws DAOException;
}
