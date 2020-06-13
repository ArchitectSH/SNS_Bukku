package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.PostTagUserDTO;

public class PostTagUserDAOImpl extends BaseDAO implements PostTagUserDAO {
	private final static String GET_POST_TAG_USER_SQL = "SELECT * FROM post_tag_user_tb";
	private final static String GET_POST_TAG_USER_BY_POSTNUM_SQL = "SELECT * FROM post_tag_user_tb WHERE post_no=?";
	private final static String GET_TAGGED_ID_SQL = "SELECT id FROM post_tag_user_tb WHERE post_no=?";
	private final static String GET_POST_TAG_USER_BY_POSTNUM_ID_SQL = "SELECT * FROM post_tag_user_tb WHERE post_no=? AND id=?";
	private final static String DELETE_POST_TAG_USER_BY_POST_NO_SQL = "DELETE FROM post_tag_user_tb WHERE post_no=?";
	private final static String DELETE_POST_TAG_USER_SQL = "DELETE FROM post_tag_user_tb WHERE id=?";
	private final static String INSERT_POST_TAG_USER_SQL = "INSERT INTO post_tag_user_tb VALUES(post_tag_user_seq.nextval,?,?)";
	public List<PostTagUserDTO> getPostTagUser() throws DAOException {
		List<PostTagUserDTO> postTags = new ArrayList<PostTagUserDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_POST_TAG_USER_SQL);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				PostTagUserDTO postTag = new PostTagUserDTO();
				postTag.setId(resultSet.getString("id"));
				postTag.setPostNo(resultSet.getInt("post_no"));
				postTag.setPostTagNo(resultSet.getInt("post_tag_no"));
				postTags.add(postTag);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return postTags;
	}
	
	public List<PostTagUserDTO> getPostTagUserByPostNum(Integer postNum) throws DAOException {
		List<PostTagUserDTO> postTags = new ArrayList<PostTagUserDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_POST_TAG_USER_BY_POSTNUM_SQL);
			pStatement.setInt(1, postNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				PostTagUserDTO postTag = new PostTagUserDTO();
				postTag.setId(resultSet.getString("id"));
				postTag.setPostNo(resultSet.getInt("post_no"));
				postTag.setPostTagNo(resultSet.getInt("post_tag_no"));
				postTags.add(postTag);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return postTags;
	}
	
	public List<String> getTaggedId(Integer postNum) throws DAOException {
		List<String> postTagIds = new ArrayList<String>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_TAGGED_ID_SQL);
			pStatement.setInt(1, postNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				postTagIds.add(resultSet.getString("id"));
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return postTagIds;
	}
	
	public PostTagUserDTO getPostTagUserByPostNumId(Integer postNum, String id) throws DAOException {
		PostTagUserDTO postTag = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_POST_TAG_USER_BY_POSTNUM_ID_SQL);
			pStatement.setInt(1, postNum);
			pStatement.setString(2, id);
			resultSet = pStatement.executeQuery();  
			while(resultSet.next()){
				postTag = new PostTagUserDTO();
				postTag.setId(resultSet.getString("id"));
				postTag.setPostNo(resultSet.getInt("post_no"));
				postTag.setPostTagNo(resultSet.getInt("post_tag_no"));
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return postTag;
	}
	
	public void deletePostTagUser(Integer postNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_POST_TAG_USER_BY_POST_NO_SQL);
			pStatement.setInt(1, postNum);
			pStatement.executeQuery();  
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void deletePostTagUser(String id) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_POST_TAG_USER_SQL);
			pStatement.setString(1, id);
			pStatement.executeQuery();  
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void insertPostTagUser(Integer postNum, String id) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(INSERT_POST_TAG_USER_SQL);
			pStatement.setInt(1, postNum);
			pStatement.setString(2, id);
			pStatement.executeQuery();  
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public static void main(String[] args) {
		DependencyInjector di = new DependencyInjector();
		di.start();
		PostTagUserDAO ptd = di.createPostTagUserDAO();
		try {
			//ptd.insertPostTagUser(4, "id2");
			System.out.println(ptd.getPostTagUser());
			System.out.println(ptd.getPostTagUserByPostNum(4));
			System.out.println(ptd.getPostTagUserByPostNumId(4, "id2"));
			System.out.println(ptd.getTaggedId(4));
			//ptd.deletePostTagUser(4);
			ptd.deletePostTagUser("id2");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
