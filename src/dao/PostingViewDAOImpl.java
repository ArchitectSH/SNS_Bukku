package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.PostingViewDTO;
import dto.PostingViewDTO;

public class PostingViewDAOImpl extends BaseDAO implements PostingViewDAO {
	private final static String GET_POSTING_VIEW_SQL = "SELECT p.*, p.post_date standard_time FROM posting_view p ORDER BY post_date DESC";
	private final static String GET_POSTING_VIEW_BY_ID_SQL = "SELECT p.*, p.post_date standard_time FROM posting_view p WHERE id=? ORDER BY post_date DESC";
	private final static String GET_POSTING_VIEW_BY_POST_NO_SQL = "SELECT p.*, p.post_date standard_time FROM posting_view p WHERE post_no = ?";
	private final static String GET_POSTING_VIEW_BY_DATE_SQL = "SELECT p.*, p.post_date standard_time FROM posting_view p WHERE post_date >= TO_DATE(?,'yyyy-MM-dd') AND post_date <= TO_DATE(?,'yyyy-MM-dd') ORDER BY post_date DESC";
	private final static String GET_POSTING_VIEW_BY_SYSDATE_SQL = "SELECT p.*, p.post_date standard_time FROM posting_view p WHERE post_date >= sysdate-? AND post_date <= sysdate ORDER BY post_date DESC";
	private final static String GET_POSTING_VIEW_BY_POST_CONTENT_SQL = "SELECT p.*, p.post_date standard_time FROM posting_view p WHERE post_content LIKE ? ORDER BY post_date DESC";
	private final static String GET_POSTING_VIEW_BY_POST_CONTENT_NO_SQL = "SELECT p.*, p.post_date standard_time FROM posting_view p WHERE post_content_no = ?";
	private final static String GET_POSTING_VIEW_BY_MYPAGE_TITLE_SQL = "SELECT p.*, p.post_date standard_time FROM posting_view p WHERE mypage_title=? ORDER BY post_date DESC";
	private final static String GET_POSTING_VIEW_BY_GROUP_NO_SQL = "SELECT p.*, p.post_date standard_time FROM posting_view p WHERE group_no=? ORDER BY post_date DESC";
	private final static String GET_POSTING_VIEW_BY_GUEST_ID_SQL = "SELECT p.*, p.post_date standard_time FROM posting_view p WHERE guest_id=? ORDER BY post_date DESC";
	private final static String GET_POSTING_VIEW_BY_ID_AND_GUEST_ID_SQL = "SELECT p.*, p.post_date standard_time FROM posting_view p WHERE id=? AND guest_id=? ORDER BY post_date DESC";
	private final static String GET_POSTING_VIEW_BY_ORIGIN_POST_NO_SQL = "SELECT p.*, p.post_date standard_time FROM posting_view p WHERE origin_post_no=? ORDER BY post_date DESC";
	private final static String GET_POSTING_VIEW_BY_CONTENT_DATE_SQL = "SELECT p.*, p.post_date standard_time FROM posting_view p WHERE post_content LIKE ? AND post_date >= TO_DATE(?,'yyyy-MM-dd') AND post_date <= TO_DATE(?,'yyyy-MM-dd') ORDER BY post_date DESC";
	//친구가 쓴 글 중 전체공개 또는 친구공개인 글(o)
	private final static String GET_FRIEND_POSTING_VIEW_SQL="SELECT p.*, p.post_date standard_time FROM posting_view p WHERE id IN (SELECT friend_id FROM friend_info_view WHERE user_id=?) AND privacy_level <=2 ORDER BY post_date DESC";
	//친구가 글에 태그한 글 (o)
	private final static String GET_TAGGED_FRIEND_POSTING_VIEW_SQL="SELECT p.*, p.post_date standard_time FROM posting_view p WHERE post_no IN (SELECT post_no FROM post_tag_user_tb WHERE id=?) ORDER BY post_date DESC";
	//친구가 댓글에 태그한 글 (o)
	private final static String GET_TAGGED_POSTING_VIEW_SQL="SELECT p.*, p.post_date standard_time FROM posting_view p WHERE post_no IN (SELECT post_no FROM comment_tb WHERE comment_no IN (SELECT comment_no FROM comment_tag_user_tb WHERE id=?)) ORDER BY post_date DESC";
	//친구가 댓글을 남긴 글 중 전체공개인 글 (ㅁ)
	private final static String GET_FRIEND_COMMENTED_POSTING_VIEW_SQL="SELECT p.*, c.comment_date standard_time, c.id friend_id FROM posting_view p, comment_tb c WHERE p.post_no IN (SELECT post_no FROM comment_tb WHERE id IN(SELECT friend_id FROM friend_info_view WHERE user_id=?)) AND p.privacy_level = 1 ORDER BY c.comment_date DESC";
	//친구가 좋아요 한 글 중 전체공개인 글 (ㅁ)
	private final static String GET_FRIEND_LIKE_POSTING_VIEW_SQL="SELECT p.*, r.recommend_time standard_time, r.id friend_id, u.name friend_name FROM posting_view p, recommendation_user_tb r, user_tb u  WHERE p.post_no IN (SELECT post_no FROM recommendation_user_tb WHERE id IN(SELECT friend_id FROM friend_info_view WHERE user_id=?) AND recommendation_kind_no=1) AND privacy_level = 1 AND r.id IN (SELECT friend_id FROM friend_info_view WHERE user_id=?) AND p.post_no = r.post_no AND r.id=u.id ORDER BY post_date DESC";
	//내가 팔로잉 하는 페이지 글
	private final static String GET_MYPAGE_POSTING_VIEW_SQL="SELECT p.*, p.post_date standard_time FROM posting_view p WHERE mypage_title IN (SELECT mypage_title FROM mypage_following_tb WHERE id=?) ORDER BY post_date DESC";
	//내가 가입한 그룹 글
	private final static String GET_GROUP_POSTING_VIEW_SQL ="SELECT p.*, p.post_date standard_time FROM posting_view p WHERE group_no IN (SELECT group_no FROM group_member_tb WHERE id=?) ORDER BY post_date DESC";
	
	public List<PostingViewDTO> getPostingView() throws DAOException {
		List<PostingViewDTO> posts = new ArrayList<PostingViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_POSTING_VIEW_SQL);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				posts.add(addPost(resultSet));
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return posts;
	}
	
	public List<PostingViewDTO> getPostingViewById(String id) throws DAOException {
		List<PostingViewDTO> posts = new ArrayList<PostingViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_POSTING_VIEW_BY_ID_SQL);
			pStatement.setString(1, id);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				posts.add(addPost(resultSet));
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return posts;
	}
	
	public PostingViewDTO getPostingViewByPostNo(Integer postNo) throws DAOException {
		PostingViewDTO post = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_POSTING_VIEW_BY_POST_NO_SQL);
			pStatement.setInt(1, postNo);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				post = new PostingViewDTO();
				post.setPostNo(resultSet.getInt("post_no"));
				post.setId(resultSet.getString("id"));
				post.setProfileImg(resultSet.getString("profile_img"));
				post.setName(resultSet.getString("name"));
				post.setPostDate(resultSet.getString("post_date"));
				post.setPostContent(resultSet.getString("post_content"));
				post.setVideo(resultSet.getString("video"));
				post.setCommentNum(resultSet.getInt("comment_num"));
				post.setShareNum(resultSet.getInt("share_num"));
				post.setReportNum(resultSet.getInt("report_num"));
				post.setLikeNBukkuNum(resultSet.getInt("like_n_bukku_num"));
				post.setHateNum(resultSet.getInt("hate_num"));
				post.setMypageTitle(resultSet.getString("mypage_title"));
				post.setGroupNo(resultSet.getInt("group_no"));
				post.setGuestId(resultSet.getString("guest_id"));
				post.setOriginPostNo(resultSet.getInt("origin_post_no"));
				post.setPostContentNo(resultSet.getInt("post_content_no"));
				post.setPrivacyLevel(resultSet.getInt("privacy_level"));
				post.setStandardTime(resultSet.getString("standard_time"));
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return post;
	}
	
	public List<PostingViewDTO> getPostingViewByDate(String startDate, String lastDate) throws DAOException {
		List<PostingViewDTO> posts = new ArrayList<PostingViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_POSTING_VIEW_BY_DATE_SQL);
			pStatement.setString(1, startDate);
			pStatement.setString(2, lastDate);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				posts.add(addPost(resultSet));
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return posts;
	}
	
	public List<PostingViewDTO> getPostingViewByCurrentDate(Integer beforeDays) throws DAOException {
		List<PostingViewDTO> posts = new ArrayList<PostingViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_POSTING_VIEW_BY_SYSDATE_SQL);
			pStatement.setInt(1, beforeDays);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				posts.add(addPost(resultSet));
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return posts;
	}
	
	public List<PostingViewDTO> getPostingViewByPostContent(String postContent) throws DAOException {
		List<PostingViewDTO> posts = new ArrayList<PostingViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_POSTING_VIEW_BY_POST_CONTENT_SQL);
			pStatement.setString(1,'%'+postContent+'%');
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				posts.add(addPost(resultSet));
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return posts;
	}
	
	public PostingViewDTO getPostingViewBypostContentNo(Integer postContentNo) throws DAOException {
		PostingViewDTO post = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_POSTING_VIEW_BY_POST_CONTENT_NO_SQL);
			pStatement.setInt(1,postContentNo);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				post = new PostingViewDTO();
				post.setPostNo(resultSet.getInt("post_no"));
				post.setId(resultSet.getString("id"));
				post.setProfileImg(resultSet.getString("profile_img"));
				post.setName(resultSet.getString("name"));
				post.setPostDate(resultSet.getString("post_date"));
				post.setPostContent(resultSet.getString("post_content"));
				post.setVideo(resultSet.getString("video"));
				post.setCommentNum(resultSet.getInt("comment_num"));
				post.setShareNum(resultSet.getInt("share_num"));
				post.setReportNum(resultSet.getInt("report_num"));
				post.setLikeNBukkuNum(resultSet.getInt("like_n_bukku_num"));
				post.setHateNum(resultSet.getInt("hate_num"));
				post.setMypageTitle(resultSet.getString("mypage_title"));
				post.setGroupNo(resultSet.getInt("group_no"));
				post.setGuestId(resultSet.getString("guest_id"));
				post.setOriginPostNo(resultSet.getInt("origin_post_no"));
				post.setPostContentNo(resultSet.getInt("post_content_no"));
				post.setPrivacyLevel(resultSet.getInt("privacy_level"));
				post.setStandardTime(resultSet.getString("standard_time"));
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return post;
	}

	public List<PostingViewDTO> getPostingViewByMyPageTitle(String mypageTitle) throws DAOException {
		List<PostingViewDTO> posts = new ArrayList<PostingViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_POSTING_VIEW_BY_MYPAGE_TITLE_SQL);
			pStatement.setString(1,mypageTitle);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				posts.add(addPost(resultSet));
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return posts;
	}
	
	public List<PostingViewDTO> getPostingViewByGroupNo(Integer groupNo) throws DAOException {
		List<PostingViewDTO> posts = new ArrayList<PostingViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_POSTING_VIEW_BY_GROUP_NO_SQL);
			pStatement.setInt(1,groupNo);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				posts.add(addPost(resultSet));
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return posts;
	}
	
	public List<PostingViewDTO> getPostingViewByGuestId(String guestId) throws DAOException {
		List<PostingViewDTO> posts = new ArrayList<PostingViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_POSTING_VIEW_BY_GUEST_ID_SQL);
			pStatement.setString(1,guestId);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				posts.add(addPost(resultSet));
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return posts;
	}
	
	public List<PostingViewDTO> getPostingViewByIdAndGuestId(String id, String guestId) throws DAOException {
		List<PostingViewDTO> posts = new ArrayList<PostingViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_POSTING_VIEW_BY_ID_AND_GUEST_ID_SQL);
			pStatement.setString(1,id);
			pStatement.setString(2, guestId);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				posts.add(addPost(resultSet));
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return posts;
	}
	
	public List<PostingViewDTO> getPostingViewByOriginPostNo(Integer originPostNo) throws DAOException {
		List<PostingViewDTO> posts = new ArrayList<PostingViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_POSTING_VIEW_BY_ORIGIN_POST_NO_SQL);
			pStatement.setInt(1, originPostNo);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				posts.add(addPost(resultSet));
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return posts;
	}
	
	public List<PostingViewDTO> getPostingViewByContentDate(String content, String startDate, String lastDate) throws DAOException {
		List<PostingViewDTO> posts = new ArrayList<PostingViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_POSTING_VIEW_BY_CONTENT_DATE_SQL);
			pStatement.setString(1, '%'+content+'%');
			pStatement.setString(2, startDate);
			pStatement.setString(3, lastDate);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				posts.add(addPost(resultSet));
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return posts;
	}
	
	
	public List<PostingViewDTO> getFriendPostingView(String id) throws DAOException{
		List<PostingViewDTO> posts = new ArrayList<PostingViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			
			pStatement = connection.prepareStatement(GET_FRIEND_POSTING_VIEW_SQL);
			pStatement.setString(1, id);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				posts.add(addPost(resultSet));
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return posts;
	}
	public List<PostingViewDTO> getTaggedFriendPostingView(String id) throws DAOException{
		List<PostingViewDTO> posts = new ArrayList<PostingViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_TAGGED_FRIEND_POSTING_VIEW_SQL);
			pStatement.setString(1, id);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				PostingViewDTO pv = new PostingViewDTO();
				pv = addPost(resultSet);
				posts.add(pv);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return posts;
	}
	public List<PostingViewDTO> getFriendTaggedView(String id) throws DAOException{
		List<PostingViewDTO> posts = new ArrayList<PostingViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_TAGGED_POSTING_VIEW_SQL);
			pStatement.setString(1, id);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				PostingViewDTO pv = new PostingViewDTO();
				pv = addPost(resultSet);
				pStatement = connection.prepareStatement("SELECT id, comment_date  FROM comment_tb WHERE comment_no IN (SELECT comment_no FROM comment_tag_user_tb WHERE id=?) AND post_no = ?");
				pStatement.setString(1, id);
				pStatement.setInt(2, pv.getPostNo());
				resultSet2 = pStatement.executeQuery();
				if(resultSet2.next()){
					pv.setFriendId(resultSet2.getString("id"));
					pv.setStandardTime(resultSet2.getString("comment_date"));
				}
				pStatement = connection.prepareStatement("SELECT name FROM user_tb WHERE id = ?");
				pStatement.setString(1, pv.getFriendId());
				resultSet3 = pStatement.executeQuery();
				resultSet3.next();
				pv.setFriendName(resultSet3.getString("name"));
				posts.add(pv);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
			closeDBObjects(resultSet2, null, null);
			closeDBObjects(resultSet3, null, null);
		}
		return posts;
	}
	
	public List<PostingViewDTO> getFriendCommentedView(String id) throws DAOException{
		List<PostingViewDTO> posts = new ArrayList<PostingViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_FRIEND_COMMENTED_POSTING_VIEW_SQL);
			pStatement.setString(1, id);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				PostingViewDTO pv =  addPost(resultSet);
				pv.setFriendId(resultSet.getString("friend_id"));
				pStatement = connection.prepareStatement("SELECT name FROM user_tb WHERE id = ?");
				pStatement.setString(1, pv.getFriendId());
				resultSet2 = pStatement.executeQuery();
				resultSet2.next();
				pv.setFriendName(resultSet2.getString("name"));
				posts.add(pv);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return posts;
	}
	
	public List<PostingViewDTO> getFriendLikeView(String id) throws DAOException{
		List<PostingViewDTO> posts = new ArrayList<PostingViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_FRIEND_LIKE_POSTING_VIEW_SQL);
			pStatement.setString(1, id);
			pStatement.setString(2, id);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				PostingViewDTO pv = addPost(resultSet);
				pv.setFriendId(resultSet.getString("friend_id"));
				pv.setFriendName(resultSet.getString("friend_name"));
				posts.add(pv);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return posts;
	}
		
		public List<PostingViewDTO> getMyPagePostingView(String id) throws DAOException{
			List<PostingViewDTO> posts = new ArrayList<PostingViewDTO>();
			Connection connection = null;
			PreparedStatement pStatement = null;
			ResultSet resultSet = null;
			try{
				connection = getConnection();
				pStatement = connection.prepareStatement(GET_MYPAGE_POSTING_VIEW_SQL);
				pStatement.setString(1, id);
				resultSet = pStatement.executeQuery();
				while(resultSet.next()){
					posts.add(addPost(resultSet));
				}
			}catch(SQLException e){
				throw new DAOException(e.getMessage());
			}finally{
				closeDBObjects(resultSet, pStatement, connection);
			}
			return posts;
		}
						
		public List<PostingViewDTO> getGroupPostingView(String id) throws DAOException{
					List<PostingViewDTO> posts = new ArrayList<PostingViewDTO>();
					Connection connection = null;
					PreparedStatement pStatement = null;
					ResultSet resultSet = null;
					try{
						connection = getConnection();
						pStatement = connection.prepareStatement(GET_GROUP_POSTING_VIEW_SQL);
						pStatement.setString(1, id);
						resultSet = pStatement.executeQuery();
						while(resultSet.next()){
							posts.add(addPost(resultSet));
						}
					}catch(SQLException e){
						throw new DAOException(e.getMessage());
					}finally{
						closeDBObjects(resultSet, pStatement, connection);
				}
			return posts;
		}
	
		private PostingViewDTO addPost(ResultSet resultSet) throws DAOException, SQLException{
			PostingViewDTO post = new PostingViewDTO();
			post.setPostNo(resultSet.getInt("post_no"));
			post.setId(resultSet.getString("id"));
			post.setProfileImg(resultSet.getString("profile_img"));
			post.setName(resultSet.getString("name"));
			post.setPostDate(resultSet.getString("post_date"));
			post.setPostContent(resultSet.getString("post_content"));
			post.setVideo(resultSet.getString("video"));
			post.setCommentNum(resultSet.getInt("comment_num"));
			post.setShareNum(resultSet.getInt("share_num"));
			post.setReportNum(resultSet.getInt("report_num"));
			post.setLikeNBukkuNum(resultSet.getInt("like_n_bukku_num"));
			post.setHateNum(resultSet.getInt("hate_num"));
			post.setMypageTitle(resultSet.getString("mypage_title"));
			post.setGroupNo(resultSet.getInt("group_no"));
			post.setGuestId(resultSet.getString("guest_id"));
			post.setOriginPostNo(resultSet.getInt("origin_post_no"));
			post.setPostContentNo(resultSet.getInt("post_content_no"));
			post.setPrivacyLevel(resultSet.getInt("privacy_level"));
			post.setStandardTime(resultSet.getString("standard_time"));
			return post;
		}
		
		
	public static void main(String[] args){
		DependencyInjector di = new DependencyInjector();
		di.start();
		PostingViewDAO postingViewDAO = di.createPostingViewDAO();
		try{
			System.out.println(postingViewDAO.getPostingView());
			System.out.println(postingViewDAO.getPostingViewByCurrentDate(1));
			System.out.println(postingViewDAO.getPostingViewByDate("20150122", "20150124230000"));
			System.out.println(postingViewDAO.getPostingViewByGroupNo(1));
			System.out.println(postingViewDAO.getPostingViewByGuestId("id4"));
			System.out.println(postingViewDAO.getPostingViewById("id2"));
			System.out.println(postingViewDAO.getPostingViewByIdAndGuestId("id3", "id4"));
			System.out.println(postingViewDAO.getPostingViewByMyPageTitle("mypage2"));
			System.out.println(postingViewDAO.getPostingViewByOriginPostNo(1));
			System.out.println(postingViewDAO.getPostingViewByPostContent("내용"));
			System.out.println(postingViewDAO.getPostingViewBypostContentNo(8));
			System.out.println(postingViewDAO.getPostingViewByPostNo(1));
			System.out.println(postingViewDAO.getGroupPostingView("id2"));
			System.out.println(postingViewDAO.getMyPagePostingView("id1"));
			System.out.println(postingViewDAO.getFriendTaggedView("id4"));
			System.out.println(postingViewDAO.getFriendCommentedView("id1"));
			System.out.println(postingViewDAO.getFriendLikeView("id1"));
			System.out.println(postingViewDAO.getFriendPostingView("id1"));
			//System.out.println(postingViewDAO.getFriendPostingView("id4"));
			//System.out.println(postingViewDAO.getFriendLikeView("id1"));
			//System.out.println(postingViewDAO.getFriendCommentedView("id1"));
			//System.out.println(postingViewDAO.getFriendTaggedView("id1"));
			//System.out.println(postingViewDAO.getFriendPostingView("id1"));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
}
