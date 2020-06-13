package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.CommentTagUserDTO;
import dto.CommentViewDTO;

public class CommentViewDAOImpl extends BaseDAO implements CommentViewDAO {
	private final static String GET_COMMENT_VIEW_SQL = "SELECT * FROM comment_view ORDER BY comment_date";
	private final static String GET_COMMENT_VIEW_BY_POST_NO_SQL = "SELECT * FROM comment_view WHERE post_no=? ORDER BY comment_date";
	private final static String GET_COMMENT_VIEW_BY_WRITER_ID_SQL = "SELECT * FROM comment_view WHERE writer_id=? ORDER BY comment_date";
	private final static String GET_COMMENT_VIEW_BY_COMMENT_NO_SQL = "SELECT * FROM comment_view WHERE comment_no=? ORDER BY comment_date";
	public List<CommentViewDTO> getCommentView() throws DAOException {
		List<CommentViewDTO> comments = new ArrayList<CommentViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_COMMENT_VIEW_SQL);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				CommentViewDTO comment = new CommentViewDTO();
				comment.setPostNo(resultSet.getInt("post_no"));
				comment.setWriterId(resultSet.getString("writer_id"));
				comment.setWriterProfileImg(resultSet.getString("writer_profile_img"));
				comment.setWriterName(resultSet.getString("writer_name"));
				comment.setCommentDate(resultSet.getString("comment_date"));
				comment.setCommentContent(resultSet.getString("comment_content"));
				comment.setCommentNo(resultSet.getInt("comment_no"));
				comment.setPrivacyLevel(resultSet.getInt("privacy_level"));
				comments.add(comment);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return comments;
	}
	
	public List<CommentViewDTO> getCommentViewByPostNo(Integer postNo) throws DAOException {
		List<CommentViewDTO> comments = new ArrayList<CommentViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_COMMENT_VIEW_BY_POST_NO_SQL);
			pStatement.setInt(1, postNo);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				CommentViewDTO comment = new CommentViewDTO();
				comment.setPostNo(resultSet.getInt("post_no"));
				comment.setWriterId(resultSet.getString("writer_id"));
				comment.setWriterProfileImg(resultSet.getString("writer_profile_img"));
				comment.setWriterName(resultSet.getString("writer_name"));
				comment.setCommentDate(resultSet.getString("comment_date"));
				comment.setCommentContent(resultSet.getString("comment_content"));
				comment.setCommentNo(resultSet.getInt("comment_no"));
				comment.setPrivacyLevel(resultSet.getInt("privacy_level"));
				comments.add(comment);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return comments;
	}
	
	public List<CommentViewDTO> getCommentViewWirterId(String writerId) throws DAOException {
		List<CommentViewDTO> comments = new ArrayList<CommentViewDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_COMMENT_VIEW_BY_WRITER_ID_SQL);
			pStatement.setString(1, writerId);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				CommentViewDTO comment = new CommentViewDTO();
				comment.setPostNo(resultSet.getInt("post_no"));
				comment.setWriterId(resultSet.getString("writer_id"));
				comment.setWriterProfileImg(resultSet.getString("writer_profile_img"));
				comment.setWriterName(resultSet.getString("writer_name"));
				comment.setCommentDate(resultSet.getString("comment_date"));
				comment.setCommentContent(resultSet.getString("comment_content"));
				comment.setCommentNo(resultSet.getInt("comment_no"));
				comment.setPrivacyLevel(resultSet.getInt("privacy_level"));
				comments.add(comment);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return comments;
	}
	
	public CommentViewDTO getCommentViewCommentNo(Integer commentNo) throws DAOException {
		CommentViewDTO comment = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_COMMENT_VIEW_BY_COMMENT_NO_SQL);
			pStatement.setInt(1, commentNo);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				comment = new CommentViewDTO();
				comment.setPostNo(resultSet.getInt("post_no"));
				comment.setWriterId(resultSet.getString("writer_id"));
				comment.setWriterProfileImg(resultSet.getString("writer_profile_img"));
				comment.setWriterName(resultSet.getString("writer_name"));
				comment.setCommentDate(resultSet.getString("comment_date"));
				comment.setCommentContent(resultSet.getString("comment_content"));
				comment.setCommentNo(resultSet.getInt("comment_no"));
				comment.setPrivacyLevel(resultSet.getInt("privacy_level"));
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return comment;
	}
	
	public static void main(String[] args){
		DependencyInjector di = new DependencyInjector();
		di.start();
		CommentViewDAO commentViewDAO = di.createCommentViewDAO();
		try{
			System.out.println(commentViewDAO.getCommentView());
			System.out.println(commentViewDAO.getCommentViewByPostNo(1));
			System.out.println(commentViewDAO.getCommentViewCommentNo(1));
			System.out.println(commentViewDAO.getCommentViewWirterId("id2"));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
