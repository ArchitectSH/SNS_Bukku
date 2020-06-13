package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.OpinionDTO;
import dto.PostContentDTO;

public class PostContentDAOImpl extends BaseDAO implements PostContentDAO {
	private final static String GET_CONTENT_SQL = "SELECT * FROM post_content_tb"; 
	private final static String GET_CONTENT_CONTAINS_SQL = "SELECT * FROM post_content_tb  WHERE post_content LIKE ? ";
	private final static String GET_CONTENT_BY_NUM_SQL = "SELECT * FROM post_content_tb WHERE post_content_no = ?";
	private final static String GET_CONTENT_BY_POSTNUM_SQL = "SELECT * FROM post_content_tb WHERE post_content_no = (SELECT post_content_no FROM post_tb WHERE post_no=?)"; 
	private final static String UPDATE_CONTENT_BY_POSTNUM_SQL = "UPDATE post_content_tb SET post_content = ?, video = ? WHERE post_content_no = (SELECT post_content_no FROM post_tb WHERE post_no=?)";
	private final static String UPDATE_CONTENT_SQL = "UPDATE post_content_tb SET post_content = ?, video=? WHERE post_content_no = ?";
	private final static String DELETE_CONTENT_BY_POSTNUM_SQL = "DELETE post_content_tb WHERE post_content_no = (SELECT post_content_no FROM post_tb WHERE post_no=?)";
	private final static String DELETE_CONTENT_SQL = "DELETE post_content_tb WHERE post_content_no = ?";
	private final static String INSERT_CONTENT_SQL = "INSERT INTO post_content_tb VALUES(post_content_seq.NEXTVAL,?, ?)";
	public List<PostContentDTO> getPostContent() throws DAOException {
		// TODO Auto-generated method stub
		List<PostContentDTO> postContents = new ArrayList<PostContentDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_CONTENT_SQL);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				PostContentDTO postContent = new PostContentDTO();
				postContent.setPostContentNo(resultSet.getInt("post_content_no"));
				postContent.setPostContent(resultSet.getString("post_content"));
				postContent.setVideo(resultSet.getString("video"));
				postContents.add(postContent);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return postContents;
	}
	public List<PostContentDTO> getPostContent(String keyword) throws DAOException {
		List<PostContentDTO> postContents = new ArrayList<PostContentDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_CONTENT_CONTAINS_SQL);
			pStatement.setString(1, '%'+keyword+'%');
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				PostContentDTO postContent = new PostContentDTO();
				postContent.setPostContentNo(resultSet.getInt("post_content_no"));
				postContent.setPostContent(resultSet.getString("post_content"));
				postContent.setVideo(resultSet.getString("video"));
				postContents.add(postContent);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return postContents;
	}
	
	public PostContentDTO getPostContentByNum(Integer contentNum) throws DAOException {
		PostContentDTO postContent = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_CONTENT_BY_NUM_SQL);
			pStatement.setInt(1, contentNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				postContent = new PostContentDTO();
				postContent.setPostContentNo(resultSet.getInt("post_content_no"));
				postContent.setPostContent(resultSet.getString("post_content"));
				postContent.setVideo(resultSet.getString("video"));
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return postContent;
	}
	
	public PostContentDTO getPostContentByPostNum(Integer postNum) throws DAOException {
		PostContentDTO postContent = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_CONTENT_BY_POSTNUM_SQL);
			pStatement.setInt(1, postNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				postContent = new PostContentDTO();
				postContent.setPostContentNo(resultSet.getInt("post_content_no"));
				postContent.setPostContent(resultSet.getString("post_content"));
				postContent.setVideo(resultSet.getString("video"));
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return postContent;
	}
	
	public void updatePostContentByPostNum(String postContent, String video, Integer postNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_CONTENT_BY_POSTNUM_SQL);
			pStatement.setString(1, postContent);
			pStatement.setString(2, video);
			pStatement.setInt(3, postNum);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void updatePostContent(String postContent, String video, Integer postContentNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_CONTENT_SQL);
			pStatement.setString(1, postContent);
			pStatement.setString(2, video);
			pStatement.setInt(3, postContentNum);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void deletePostContentByPostNum(Integer postNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_CONTENT_BY_POSTNUM_SQL);
			pStatement.setInt(1,postNum);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void deletePostContent(Integer postContentNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_CONTENT_SQL);
			pStatement.setInt(1,postContentNum);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public Integer insertPostContent(String postContent, String video) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		PreparedStatement pStatement2 = null;
		ResultSet resultSet = null;
		Integer postContentNum  = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(INSERT_CONTENT_SQL);
			pStatement.setString(1,postContent);
			pStatement.setString(2,video);
			pStatement.executeQuery();
			pStatement2 = connection.prepareStatement("SELECT post_content_seq.CURRVAL FROM dual");
			resultSet = pStatement2.executeQuery();
			resultSet.next();
			postContentNum = resultSet.getInt("CURRVAL");
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
			closeDBObjects(null, pStatement2, connection);
		}
		return postContentNum;
	}

	public static void main(String[] args) {
		DependencyInjector di = new DependencyInjector();
		di.start();
		PostContentDAO postContentDAO = di.createPostContentDAO();
		try {
			System.out.println(postContentDAO.getPostContent());
			System.out.println(postContentDAO.getPostContent("hi"));
			System.out.println(postContentDAO.getPostContentByNum(1));
			System.out.println(postContentDAO.getPostContentByPostNum(11));
			//postContentDAO.updatePostContent("¾È³ç¾È³ç", 1);
			//postContentDAO.updatePostContentByPostNum("¾È³ç2¾È³ç22", 11);
			//postContentDAO.insertPostContent("wowwow","ºñµð¿À1");
			//postContentDAO.deletePostContent(21);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}
