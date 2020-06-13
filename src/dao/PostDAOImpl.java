package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.PostDTO;


public class PostDAOImpl extends BaseDAO implements PostDAO {
	private static final String GET_POST_SQL = "SELECT * FROM post_tb ORDER BY post_date DESC";
	private static final String GET_POST_BY_DATE_SQL = "SELECT * FROM post_tb WHERE post_date >= TO_DATE(?,'YYYYMMDDHH24MISS') AND post_date <= TO_DATE(?,'YYYYMMDDHH24MISS') ORDER BY post_date DESC";
	private static final String GET_POST_BY_SYSDATE_SQL = "SELECT * FROM post_tb WHERE post_date >= SYSDATE-? AND post_date <= SYSDATE ORDER BY post_date DESC";
	private static final String GET_POST_BY_NUM_SQL = "SELECT * FROM post_tb WHERE post_no = ?";
	private static final String UPDATE_POST_SQL = "UPDATE post_tb SET privacy_level=?,post_date = sysdate WHERE post_no=?";
	private static final String DELETE_POST_SQL = "DELETE post_tb WHERE post_no=?";
	private static final String DELETE_POST_BY_ID_SQL = "DELETE post_tb WHERE id=?";
	private static final String INSERT_POST_SQL = "INSERT INTO post_tb VALUES(post_seq.NEXTVAL,?,SYSDATE,?,?)";
	public List<PostDTO> getPost() throws DAOException {
		List<PostDTO> posts = new ArrayList<PostDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_POST_SQL);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				PostDTO post = new PostDTO();
				post.setId(resultSet.getString("id"));
				post.setPrivacyLevel(resultSet.getInt("privacy_level"));
				post.setPostDate(resultSet.getString("post_date"));
				post.setPostContentNo(resultSet.getInt("post_content_no"));
				post.setPostNo(resultSet.getInt("post_no"));
				posts.add(post);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return posts;
	}
	
	public List<PostDTO> getPostByDate(String startDate, String lastDate) throws DAOException {
		List<PostDTO> posts = new ArrayList<PostDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_POST_BY_DATE_SQL);
			pStatement.setString(1, startDate);
			pStatement.setString(2, lastDate);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				PostDTO post = new PostDTO();
				post.setId(resultSet.getString("id"));
				post.setPrivacyLevel(resultSet.getInt("privacy_level"));
				post.setPostDate(resultSet.getString("post_date"));
				post.setPostContentNo(resultSet.getInt("post_content_no"));
				post.setPostNo(resultSet.getInt("post_no"));
				posts.add(post);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return posts;
	}
	
	public List<PostDTO> getPostByCurrentDate(Integer beforeDays) throws DAOException {
		List<PostDTO> posts = new ArrayList<PostDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_POST_BY_SYSDATE_SQL);
			pStatement.setInt(1, beforeDays);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				PostDTO post = new PostDTO();
				post.setId(resultSet.getString("id"));
				post.setPrivacyLevel(resultSet.getInt("privacy_level"));
				post.setPostDate(resultSet.getString("post_date"));
				post.setPostContentNo(resultSet.getInt("post_content_no"));
				post.setPostNo(resultSet.getInt("post_no"));
				posts.add(post);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return posts;
	}
	
	public PostDTO getPostByNum(Integer postNum) throws DAOException {
		PostDTO post = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_POST_BY_NUM_SQL);
			pStatement.setInt(1, postNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				post = new PostDTO();
				post.setId(resultSet.getString("id"));
				post.setPrivacyLevel(resultSet.getInt("privacy_level"));
				post.setPostDate(resultSet.getString("post_date"));
				post.setPostContentNo(resultSet.getInt("post_content_no"));
				post.setPostNo(resultSet.getInt("post_no"));
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return post;
	}	
	
	public void updatePost(Integer privacyLevel, Integer postNo) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_POST_SQL);
			pStatement.setInt(1, privacyLevel);
			pStatement.setInt(2, postNo);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void deletePost(Integer postNo) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_POST_SQL);
			pStatement.setInt(1, postNo);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void deletePostById(String id) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_POST_BY_ID_SQL);
			pStatement.setString(1, id);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public Integer insertPost(Integer privacyLevel, String id, Integer contentNo) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		PreparedStatement pStatement2 = null;
		Integer postNum = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(INSERT_POST_SQL);
			pStatement.setInt(1, privacyLevel);
			pStatement.setString(2, id);
			pStatement.setInt(3,contentNo);
			pStatement.executeQuery();
			pStatement2 = connection.prepareStatement("SELECT post_seq.CURRVAL FROM DUAL");
			resultSet = pStatement2.executeQuery();
			resultSet.next();
			postNum = resultSet.getInt("CURRVAL");
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
		return postNum;
	}
	
	
	public static void main(String[] args) {
		DependencyInjector di = new DependencyInjector();
		di.start();
		PostDAO postDAO = di.createPostDAO();
		try {
			System.out.println(postDAO.getPost());
			System.out.println(postDAO.getPostByCurrentDate(3));
			//System.out.println(postDAO.getPostByDate("20150123", "20150125"));
			//System.out.println(postDAO.getPostByNum(12));
			//postDAO.updatePost(1, 12);
			//postDAO.insertPost(2, "id2", 2);
			//postDAO.deletePost(5);
			//postDAO.deletePostById("id4");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
