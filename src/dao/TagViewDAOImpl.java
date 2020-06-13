package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.TagViewDTO;

public class TagViewDAOImpl extends BaseDAO implements TagViewDAO {
	private final static String GET_TAG_VIEW_SQL = "SELECT * FROM tag_view";
	private final static String GET_TAG_VIEW_BY_COMMENT_NO_SQL = "SELECT * FROM tag_view WHERE comment_no=?";
	private final static String GET_TAG_VIEW_BY_POST_NO_SQL = "SELECT * FROM tag_view WHERE post_no=?";
	private final static String GET_TAG_VIEW_BY_POST_NO_TAGGED_USER_ID_SQL = "SELECT * FROM tag_view WHERE post_no=? AND tagged_user_id=?";
	private final static String GET_TAG_VIEW_BY_TAGGED_USER_SQL = "SELECT * FROM tag_view WHERE tagged_user_id=?";
	public List<TagViewDTO> getTagView() throws DAOException {
		List<TagViewDTO> tagViews = new ArrayList<TagViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_TAG_VIEW_SQL);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				TagViewDTO tagView = new TagViewDTO();
				tagView.setCommentNo(resultSet.getInt("comment_no"));
				tagView.setCommentContent(resultSet.getString("comment_content"));
				tagView.setWriterId(resultSet.getString("writer_id"));
				tagView.setWriterProfileImg(resultSet.getString("writer_profile_img"));
				tagView.setWriterName(resultSet.getString("writer_name"));
				tagView.setTaggedUserId(resultSet.getString("tagged_user_id"));
				tagView.setTaggedUserId(resultSet.getString("tagged_user_name"));
				tagView.setPostNo(resultSet.getInt("post_no"));
				tagViews.add(tagView);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return tagViews;
	}
	
	public List<TagViewDTO> getTagViewByCommentNo(Integer commentNo) throws DAOException {
		List<TagViewDTO> tagViews = new ArrayList<TagViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_TAG_VIEW_BY_COMMENT_NO_SQL);
			pStatement.setInt(1, commentNo);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				TagViewDTO tagView = new TagViewDTO();
				tagView.setCommentNo(resultSet.getInt("comment_no"));
				tagView.setCommentContent(resultSet.getString("comment_content"));
				tagView.setWriterId(resultSet.getString("writer_id"));
				tagView.setWriterProfileImg(resultSet.getString("writer_profile_img"));
				tagView.setWriterName(resultSet.getString("writer_name"));
				tagView.setTaggedUserId(resultSet.getString("tagged_user_id"));
				tagView.setTaggedUserId(resultSet.getString("tagged_user_name"));
				tagView.setPostNo(resultSet.getInt("post_no"));
				tagViews.add(tagView);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return tagViews;
	}
	
	public List<TagViewDTO> getTagViewByPostNo(Integer postNo) throws DAOException {
		List<TagViewDTO> tagViews = new ArrayList<TagViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_TAG_VIEW_BY_POST_NO_SQL);
			pStatement.setInt(1, postNo);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				TagViewDTO tagView = new TagViewDTO();
				tagView.setCommentNo(resultSet.getInt("comment_no"));
				tagView.setCommentContent(resultSet.getString("comment_content"));
				tagView.setWriterId(resultSet.getString("writer_id"));
				tagView.setWriterProfileImg(resultSet.getString("writer_profile_img"));
				tagView.setWriterName(resultSet.getString("writer_name"));
				tagView.setTaggedUserId(resultSet.getString("tagged_user_id"));
				tagView.setTaggedUserId(resultSet.getString("tagged_user_name"));
				tagView.setPostNo(resultSet.getInt("post_no"));
				tagViews.add(tagView);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return tagViews;
	}
	
	public List<TagViewDTO> getTagViewByPostNoAndTaggedUserId(Integer postNo, String taggedUserId) throws DAOException {
		List<TagViewDTO> tagViews = new ArrayList<TagViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_TAG_VIEW_BY_POST_NO_TAGGED_USER_ID_SQL);
			pStatement.setInt(1, postNo);
			pStatement.setString(2, taggedUserId);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				TagViewDTO tagView = new TagViewDTO();
				tagView.setCommentNo(resultSet.getInt("comment_no"));
				tagView.setCommentContent(resultSet.getString("comment_content"));
				tagView.setWriterId(resultSet.getString("writer_id"));
				tagView.setWriterProfileImg(resultSet.getString("writer_profile_img"));
				tagView.setWriterName(resultSet.getString("writer_name"));
				tagView.setTaggedUserId(resultSet.getString("tagged_user_id"));
				tagView.setTaggedUserId(resultSet.getString("tagged_user_name"));
				tagView.setPostNo(resultSet.getInt("post_no"));
				tagViews.add(tagView);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return tagViews;
	}
	
	public List<TagViewDTO> getTagViewByTaggedUserId(String taggedUserId) throws DAOException {
		List<TagViewDTO> tagViews = new ArrayList<TagViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_TAG_VIEW_BY_TAGGED_USER_SQL);
			pStatement.setString(1, taggedUserId);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				TagViewDTO tagView = new TagViewDTO();
				tagView.setCommentNo(resultSet.getInt("comment_no"));
				tagView.setCommentContent(resultSet.getString("comment_content"));
				tagView.setWriterId(resultSet.getString("writer_id"));
				tagView.setWriterProfileImg(resultSet.getString("writer_profile_img"));
				tagView.setWriterName(resultSet.getString("writer_name"));
				tagView.setTaggedUserId(resultSet.getString("tagged_user_id"));
				tagView.setTaggedUserId(resultSet.getString("tagged_user_name"));
				tagView.setPostNo(resultSet.getInt("post_no"));
				tagViews.add(tagView);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return tagViews;
	}
	
	public static void main(String[] args) {
		DependencyInjector di = new DependencyInjector();
		di.start();
		TagViewDAO tagViewDAO = di.createTagViewDAO();
		try {
			System.out.println(tagViewDAO.getTagView());
			System.out.println(tagViewDAO.getTagViewByCommentNo(1));
			System.out.println(tagViewDAO.getTagViewByPostNo(1));
			System.out.println(tagViewDAO.getTagViewByPostNoAndTaggedUserId(1, "id1"));
			System.out.println(tagViewDAO.getTagViewByTaggedUserId("id1"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
