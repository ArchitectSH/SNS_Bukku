package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.GuestPostDTO;

public class GuestPostDAOImpl extends BaseDAO implements GuestPostDAO {
	private final static String GET_GUESTPOST_SQL = "SELECT * FROM guest_post_tb";
	private final static String GET_GUESTPOST_BY_WRITER_ID_SQL = "SELECT * FROM guest_post_tb WHERE post_no IN (SELECT post_no FROM post_tb WHERE id = ?)";
	private final static String GET_GUESTPOST_BY_RECEIVER_ID_SQL = "SELECT * FROM guest_post_tb WHERE id=?";
	private final static String DELETE_GUESTPOST_BY_POSTNUM_SQL = "DELETE guest_post_tb WHERE post_no =?";
	private final static String DELETE_GUESTPOST_BY_ID_SQL = "DELETE guest_post_tb WHERE id= ?";
	private final static String INSERT_GUESTPOST_SQL = "INSERT INTO guest_post_tb VALUES(?,?)";
	public List<GuestPostDTO> getGuestPost() throws DAOException {
		List<GuestPostDTO> guestPosts = new ArrayList<GuestPostDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_GUESTPOST_SQL);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				GuestPostDTO gpost = new GuestPostDTO();
				gpost.setId(resultSet.getString("id"));
				gpost.setPostNo(resultSet.getInt("post_no"));
				guestPosts.add(gpost);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return guestPosts;
	}
	
	public List<GuestPostDTO> getGuestPostByWriterId(String id) throws DAOException {
		List<GuestPostDTO> guestPosts = new ArrayList<GuestPostDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_GUESTPOST_BY_WRITER_ID_SQL);
			pStatement.setString(1, id);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				GuestPostDTO gpost = new GuestPostDTO();
				gpost.setId(resultSet.getString("id"));
				gpost.setPostNo(resultSet.getInt("post_no"));
				guestPosts.add(gpost);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return guestPosts;
	}
	
	public List<GuestPostDTO> getGuestPostByReceiverId(String id) throws DAOException {
		List<GuestPostDTO> guestPosts = new ArrayList<GuestPostDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_GUESTPOST_BY_RECEIVER_ID_SQL);
			pStatement.setString(1, id);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				GuestPostDTO gpost = new GuestPostDTO();
				gpost.setId(resultSet.getString("id"));
				gpost.setPostNo(resultSet.getInt("post_no"));
				guestPosts.add(gpost);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return guestPosts;
	}
	
	public void deleteGuestPostByPostNum(Integer postNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_GUESTPOST_BY_POSTNUM_SQL);
			pStatement.setInt(1, postNum);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void deleteGuestPostByReceiverId(String id) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_GUESTPOST_BY_ID_SQL);
			pStatement.setString(1,id);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null,  pStatement, connection);
		}
	}
	
	public void insertGuestPost(Integer postNum, String receiverId) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(INSERT_GUESTPOST_SQL);
			pStatement.setInt(1,postNum);
			pStatement.setString(2, receiverId);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	/*
	public static void main(String[] args){
		DependencyInjector di = new DependencyInjector();
		di.start();
		GuestPostDAO guestPostDAO = di.createGuestPostDAO();
		try{
			System.out.println(guestPostDAO.getGuestPost());
			System.out.println(guestPostDAO.getGuestPostByReceiverId("id3"));
			System.out.println(guestPostDAO.getGuestPostByWriterId("id3"));
			//guestPostDAO.insertGuestPost(2,"id4");
			//guestPostDAO.deleteGuestPostByPostNum(2);
			//guestPostDAO.deleteGuestPostByReceiverId("id3");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	*/
}
