package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.SharePostDTO;

public class SharePostDAOImpl extends BaseDAO implements SharePostDAO {
	private final static String GET_SHAREPOST_SQL = "SELECT * FROM share_post_tb";
	private final static String GET_SHAREPOST_BY_POSTNUM_SQL = "SELECT * FROM share_post_tb WHERE post_no = ?";
	private final static String GET_SHAREPOST_BY_ORIGIN_POSTNUM_SQL = "SELECT * FROM share_post_tb WHERE origin_post_no =?";
	private final static String DELETE_SHAREPOST_BY_POSTNUM_SQL = "DELETE share_post_tb WHERE post_no =?";
	private final static String DELETE_SHAREPOST_BY_ORIGIN_POSTNUM_SQL = "DELETE share_post_tb WHERE origin_post_no=?";
	private final static String INSERT_SHAREPOST_SQL = "INSERT INTO share_post_tb VALUES(?,?)";
	public List<SharePostDTO> getSharePost() throws DAOException {
		List<SharePostDTO> sharePosts = new ArrayList<SharePostDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_SHAREPOST_SQL);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				SharePostDTO sharePost = new SharePostDTO();
				sharePost.setPostNo(resultSet.getInt("post_no"));
				sharePost.setOriginPostNo(resultSet.getString("origin_post_no"));
				sharePosts.add(sharePost);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return sharePosts;
	}
	
	public List<SharePostDTO> getSharePostByPostNum(Integer postNum) throws DAOException {
		List<SharePostDTO> sharePosts = new ArrayList<SharePostDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_SHAREPOST_BY_POSTNUM_SQL);
			pStatement.setInt(1, postNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				SharePostDTO sharePost = new SharePostDTO();
				sharePost.setPostNo(resultSet.getInt("post_no"));
				sharePost.setOriginPostNo(resultSet.getString("origin_post_no"));
				sharePosts.add(sharePost);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return sharePosts;
	}
	
	public List<SharePostDTO> getSharePostByOriginPostNum(Integer originPostNum) throws DAOException {
		List<SharePostDTO> sharePosts = new ArrayList<SharePostDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_SHAREPOST_BY_ORIGIN_POSTNUM_SQL);
			pStatement.setInt(1, originPostNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				SharePostDTO sharePost = new SharePostDTO();
				sharePost.setPostNo(resultSet.getInt("post_no"));
				sharePost.setOriginPostNo(resultSet.getString("origin_post_no"));
				sharePosts.add(sharePost);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return sharePosts;
	}
	
	public void deleteSharePostByPostNum(Integer postNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_SHAREPOST_BY_POSTNUM_SQL);
			pStatement.setInt(1, postNum);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void deleteSharePostByOriginPostNum(Integer originPostNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_SHAREPOST_BY_ORIGIN_POSTNUM_SQL);
			pStatement.setInt(1, originPostNum);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void insertSharePost(Integer postNum, Integer originPostNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(INSERT_SHAREPOST_SQL);
			pStatement.setInt(1, postNum);
			pStatement.setInt(2, originPostNum);
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
		SharePostDAO sharePostDAO = di.createSharePostDAO();
		try {
			//sharePostDAO.insertSharePost(4, 12);
			System.out.println(sharePostDAO.getSharePost());
			System.out.println(sharePostDAO.getSharePostByOriginPostNum(12));
			System.out.println(sharePostDAO.getSharePostByPostNum(4));
			//sharePostDAO.deleteSharePostByOriginPostNum(12);
			sharePostDAO.deleteSharePostByPostNum(4);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
