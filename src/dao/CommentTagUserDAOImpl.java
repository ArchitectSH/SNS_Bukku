package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.CommentTagUserDTO;

public class CommentTagUserDAOImpl extends BaseDAO implements CommentTagUserDAO {
	private final static String GET_COMMENT_TAG_USER_SQL = "SELECT * FROM comment_tag_user_tb";
	private final static String GET_COMMENT_TAG_BY_NUM_SQL = "SELECT * FROM comment_tag_user_tb WHERE comment_no=?";
	private final static String GET_TAGGED_ID_SQL = "SELECT id FROM comment_tag_user_tb WHERE comment_no=?";
	private final static String GET_COMMENT_TAG_USER_BY_CNUM_ID_SQL = "SELECT * FROM comment_tag_user_tb WHERE comment_no=? AND id=?";
	private final static String DELETE_COMMENT_SQL = "DELETE FROM comment_tag_user_tb WHERE comment_no=?";
	private final static String DELETE_COMMENT_BY_ID_SQL = "DELETE FROM comment_tag_user_tb WHERE id=?";
	private final static String INSERT_COMMENT_SQL = "INSERT INTO comment_tag_user_tb VALUES(comment_tag_user_seq.nextval,?,?)";
	public List<CommentTagUserDTO> getCommentTagUser() throws DAOException {
		List<CommentTagUserDTO> commentTagUsers = new ArrayList<CommentTagUserDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_COMMENT_TAG_USER_SQL);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				CommentTagUserDTO ctu = new CommentTagUserDTO();
				ctu.setCommentTagNo(resultSet.getInt("comment_tag_no"));
				ctu.setCommentNo(resultSet.getInt("comment_no"));
				ctu.setId(resultSet.getString("id"));
				commentTagUsers.add(ctu);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return commentTagUsers;
	}
	
	public List<CommentTagUserDTO> getCommentTagByNum(Integer commentNum) throws DAOException {
		List<CommentTagUserDTO> commentTagUsers = new ArrayList<CommentTagUserDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_COMMENT_TAG_BY_NUM_SQL);
			pStatement.setInt(1, commentNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				CommentTagUserDTO ctu = new CommentTagUserDTO();
				ctu.setCommentTagNo(resultSet.getInt("comment_tag_no"));
				ctu.setCommentNo(resultSet.getInt("comment_no"));
				ctu.setId(resultSet.getString("id"));
				commentTagUsers.add(ctu);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return commentTagUsers;
	}	
	
	public List<String> getTaggedId(Integer commentNum) throws DAOException {
		List<String> commentTagUserIds = new ArrayList<String>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_TAGGED_ID_SQL);
			pStatement.setInt(1, commentNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				commentTagUserIds.add(resultSet.getString("id"));
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return commentTagUserIds;
	}
	
	public CommentTagUserDTO getCommentTagUserByComNumId(Integer commentNum, String id) throws DAOException {
		CommentTagUserDTO commentTagUser = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_COMMENT_TAG_USER_BY_CNUM_ID_SQL);
			pStatement.setInt(1, commentNum);
			pStatement.setString(2, id);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				commentTagUser = new CommentTagUserDTO();
				commentTagUser.setCommentTagNo(resultSet.getInt("comment_tag_no"));
				commentTagUser.setCommentNo(resultSet.getInt("comment_no"));
				commentTagUser.setId(resultSet.getString("id"));
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return commentTagUser;
	}
	
	public void deleteCommentTagUser(Integer commentNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_COMMENT_SQL);
			pStatement.setInt(1, commentNum);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void deleteCommentTagUserById(String id) throws DAOException {
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
	
	public void insertComment(Integer commentNum, String id) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(INSERT_COMMENT_SQL);
			pStatement.setInt(1, commentNum);
			pStatement.setString(2, id);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public static void main(String[] args){
		DependencyInjector di = new DependencyInjector();
		di.start();
		CommentTagUserDAO commentDAO = di.createCommentTagUserDAO();
		try{
			System.out.println(commentDAO.getCommentTagUser());
			System.out.println(commentDAO.getCommentTagByNum(2));
			System.out.println(commentDAO.getCommentTagUserByComNumId(2, "id1"));
			System.out.println(commentDAO.getTaggedId(2));
			//commentDAO.insertComment(2, "id1");
			//commentDAO.deleteCommentTagUserById("id1");
			//commentDAO.deleteCommentTagUser(1);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
