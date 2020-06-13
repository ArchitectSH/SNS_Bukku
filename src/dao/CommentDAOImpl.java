package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.CommentDTO;

public class CommentDAOImpl extends BaseDAO implements CommentDAO {
	private final static String GET_COMMENT_SQL = "SELECT * FROM comment_tb ORDER BY comment_date";
	private final static String GET_COMMENT_BY_COMMENTNUM_SQL = "SELECT * FROM comment_tb WHERE comment_no=? ORDER BY comment_date";
	private final static String GET_COMMENT_BY_POSTNUM_SQL = "SELECT * FROM comment_tb WHERE post_no=? ORDER BY comment_date";
	private final static String GET_COMMENT_BY_ID_SQL = "SELECT * FROM comment_tb WHERE id=? ORDER BY comment_date";
	private final static String GET_COMMENT_BY_ID_POSTNUM_SQL = "SELECT * FROM comment_tb WHERE id=? AND post_no=? ORDER BY comment_date";
	private final static String UPDATE_COMMENT_BY_COMMENTNUM_SQL = "UPDATE comment_tb SET comment_content=? WHERE comment_no=?";
	private final static String DELETE_COMMENT_BY_COMMENTNUM_SQL = "DELETE FROM comment_tb WHERE comment_no=?";
	private final static String DELETE_COMMENT_BY_POSTNUM_SQL = "DELETE FROM comment_tb WHERE post_no=?";
	private final static String DELETE_COMMENT_BY_ID_SQL = "DELETE FROM comment_tb WHERE id=?";
	private final static String INSERT_COMMENT_SQL = "INSERT INTO comment_tb VALUES(comment_seq.nextval, ?, sysdate, ?, ?,?)";

	public List<CommentDTO> getComment() throws DAOException {
		List<CommentDTO> comments = new ArrayList<CommentDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_COMMENT_SQL);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				CommentDTO comment = new CommentDTO();
				comment.setCommentNo(resultSet.getInt("comment_no"));
				comment.setCommentContent(resultSet.getString("comment_content"));
				comment.setCommentDate(resultSet.getString("comment_date"));
				comment.setPostNo(resultSet.getInt("post_no"));
				comment.setId(resultSet.getString("id"));
				comment.setPrivacyLevel(resultSet.getInt("privacy_Level"));
				comments.add(comment);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return comments;
	}
	
	public CommentDTO getCommentByNum(Integer commentNum) throws DAOException{
		CommentDTO comment = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_COMMENT_BY_COMMENTNUM_SQL);
			pStatement.setInt(1, commentNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				comment=new CommentDTO();
				comment.setCommentNo(resultSet.getInt("comment_no"));
				comment.setCommentContent(resultSet.getString("comment_content"));
				comment.setCommentDate(resultSet.getString("comment_date"));
				comment.setPostNo(resultSet.getInt("post_no"));
				comment.setId(resultSet.getString("id"));
				comment.setPrivacyLevel(resultSet.getInt("privacy_Level"));
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return comment;
	}
	
	public List<CommentDTO> getCommentByPostNum(Integer postNum) throws DAOException{
		List<CommentDTO> comments = new ArrayList<CommentDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_COMMENT_BY_POSTNUM_SQL);
			pStatement.setInt(1, postNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				CommentDTO comment = new CommentDTO();
				comment.setCommentNo(resultSet.getInt("comment_no"));
				comment.setCommentContent(resultSet.getString("comment_content"));
				comment.setCommentDate(resultSet.getString("comment_date"));
				comment.setPostNo(resultSet.getInt("post_no"));
				comment.setId(resultSet.getString("id"));
				comment.setPrivacyLevel(resultSet.getInt("privacy_Level"));
				comments.add(comment);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return comments;
	}
	
	public List<CommentDTO> getCommentById(String id) throws DAOException{
		List<CommentDTO> comments = new ArrayList<CommentDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_COMMENT_BY_ID_SQL);
			pStatement.setString(1, id);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				CommentDTO comment = new CommentDTO();
				comment.setCommentNo(resultSet.getInt("comment_no"));
				comment.setCommentContent(resultSet.getString("comment_content"));
				comment.setCommentDate(resultSet.getString("comment_date"));
				comment.setPostNo(resultSet.getInt("post_no"));
				comment.setId(resultSet.getString("id"));
				comment.setPrivacyLevel(resultSet.getInt("privacy_Level"));
				comments.add(comment);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return comments;
	}
	
	public List<CommentDTO> getCommentByIdPostNum(String id, Integer postNum) throws DAOException{
		List<CommentDTO> comments = new ArrayList<CommentDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_COMMENT_BY_ID_POSTNUM_SQL);
			pStatement.setString(1, id);
			pStatement.setInt(2, postNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				CommentDTO comment = new CommentDTO();
				comment.setCommentNo(resultSet.getInt("comment_no"));
				comment.setCommentContent(resultSet.getString("comment_content"));
				comment.setCommentDate(resultSet.getString("comment_date"));
				comment.setPostNo(resultSet.getInt("post_no"));
				comment.setId(resultSet.getString("id"));
				comment.setPrivacyLevel(resultSet.getInt("privacy_Level"));
				comments.add(comment);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return comments;
	}
	
	public void updateCommentByCommentNum(String content, Integer commentNum) throws DAOException{
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_COMMENT_BY_COMMENTNUM_SQL);
			pStatement.setString(1, content);
			pStatement.setInt(2, commentNum);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void deleteCommentByCommentNum(Integer commentNum) throws DAOException{
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_COMMENT_BY_COMMENTNUM_SQL);
			pStatement.setInt(1, commentNum);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void deleteCommentByPostNum(Integer postNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_COMMENT_BY_POSTNUM_SQL);
			pStatement.setInt(1, postNum);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void deleteCommentById(String id) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_COMMENT_BY_ID_SQL);
			pStatement.setString(1, id);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public Integer insertComment(String content, Integer postNum, String id, Integer privacyLevel) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		Integer commentNo = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(INSERT_COMMENT_SQL);
			pStatement.setString(1, content);
			pStatement.setInt(2, postNum);
			pStatement.setString(3, id);
			pStatement.setInt(4, privacyLevel);
			pStatement.executeQuery();
			pStatement = connection.prepareStatement("SELECT comment_seq.CURRVAL FROM DUAL");
			resultSet = pStatement.executeQuery();
			resultSet.next();
			commentNo = resultSet.getInt("CURRVAL");
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return commentNo;
	}
	/*
	public static void main(String[] args){
		DependencyInjector di = new DependencyInjector();
		di.start();
		CommentDAO commentDAO = di.createCommentDAO();
		try{
			System.out.println(commentDAO.getComment());
			System.out.println(commentDAO.getCommentById("id2"));
			System.out.println(commentDAO.getCommentByIdPostNum("id2", 1));
			System.out.println(commentDAO.getCommentByNum(1));
			System.out.println(commentDAO.getCommentByPostNum(1));
			//commentDAO.insertComment("wow", 1, "id1", 1);
			System.out.println(commentDAO.getCommentById("id1"));
			//commentDAO.updateCommentByCommentNum("wowow", 1);
			System.out.println(commentDAO.getCommentByNum(1));
			//commentDAO.deleteCommentByCommentNum(1);
			//commentDAO.deleteCommentById("id2");
			commentDAO.deleteCommentByPostNum(1);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}*/
}
