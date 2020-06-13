package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.MyPagePostDTO;

public class MyPagePostDAOImpl extends BaseDAO implements MyPagePostDAO {
	private final static String GET_MYPAGEPOST_SQL = "SELECT * FROM mypage_post_tb";
	private final static String GET_MYPAGEPOST_BY_ID_SQL = "SELECT * FROM mypage_post_tb WHERE post_no IN (SELECT post_no FROM post_tb WHERE id = ?)";
	private final static String GET_MYPAGEPOST_BY_TITLE_SQL = "SELECT * FROM mypage_post_tb WHERE mypage_title LIKE ?";
	private final static String DELETE_MYPAGEPOST_BY_POSTNUM_SQL = "DELETE mypage_post_tb WHERE post_no=?";
	private final static String DELETE_MYPAGEPOST_BY_TITLE_SQL = "DELETE mypage_post_tb WHERE mypage_title=?";
	private final static String INSERT_MYPAGEPOST_SQL = "INSERT INTO mypage_post_tb VALUES(?,?)";
	public List<MyPagePostDTO> getMyPagePost() throws DAOException {
		List<MyPagePostDTO> pagePosts = new ArrayList<MyPagePostDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_MYPAGEPOST_SQL);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				MyPagePostDTO pagePost = new MyPagePostDTO();
				pagePost.setMyPageTitle(resultSet.getString("mypage_title"));
				pagePost.setPostNo(resultSet.getInt("post_no"));
				pagePosts.add(pagePost);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return pagePosts;
	}
	
	public List<MyPagePostDTO> getMyPagePostById(String id) throws DAOException {
		List<MyPagePostDTO> pagePosts = new ArrayList<MyPagePostDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_MYPAGEPOST_BY_ID_SQL);
			pStatement.setString(1, id);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				MyPagePostDTO pagePost = new MyPagePostDTO();
				pagePost.setMyPageTitle(resultSet.getString("mypage_title"));
				pagePost.setPostNo(resultSet.getInt("post_no"));
				pagePosts.add(pagePost);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return pagePosts;
	}
	
	public List<MyPagePostDTO> getMyPagePostByTitle(String title) throws DAOException {
		List<MyPagePostDTO> pagePosts = new ArrayList<MyPagePostDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_MYPAGEPOST_BY_TITLE_SQL);
			pStatement.setString(1, '%'+title+'%');
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				MyPagePostDTO pagePost = new MyPagePostDTO();
				pagePost.setMyPageTitle(resultSet.getString("mypage_title"));
				pagePost.setPostNo(resultSet.getInt("post_no"));
				pagePosts.add(pagePost);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return pagePosts;
	}
	
	public void deleteMyPagePost(Integer postNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_MYPAGEPOST_BY_POSTNUM_SQL);
			pStatement.setInt(1, postNum);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void deleteMyPagePostByTitle(String myPageTitle) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_MYPAGEPOST_BY_TITLE_SQL);
			pStatement.setString(1, myPageTitle);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void insertMyPagePost(Integer postNum, String myPageTitle) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(INSERT_MYPAGEPOST_SQL);
			pStatement.setInt(1, postNum);
			pStatement.setString(2, myPageTitle);
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
		MyPagePostDAO myPagePostDAO = di.createMyPagePostDAO();
		try {
			System.out.println(myPagePostDAO.getMyPagePost());
			System.out.println(myPagePostDAO.getMyPagePostById("id2"));
			System.out.println(myPagePostDAO.getMyPagePostByTitle("mypage2"));
			//myPagePostDAO.insertMyPagePost(10, "mypage3");
			//myPagePostDAO.deleteMyPagePost(10);
			//myPagePostDAO.deleteMyPagePostByTitle("mypage2");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
