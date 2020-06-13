package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.GroupPostDTO;

public class GroupPostDAOImpl extends BaseDAO implements GroupPostDAO {
	private final static String GET_GROUPPOST_SQL = "SELECT * FROM group_post_tb";
	private final static String GET_GROUPPOST_BY_ID_SQL = "SELECT * FROM group_post_tb WHERE post_no IN (SELECT post_no FROM post_tb WHERE id = ?)";
	private final static String GET_GROUPPOST_BY_GROUP_NUM_SQL = "SELECT * FROM group_post_tb WHERE group_no =?";
	private final static String DELETE_GROUPPOST_BY_POSTNUM_SQL = "DELETE group_post_tb WHERE post_no =?";
	private final static String DELETE_GROUPPOST_BY_GROUPNUM_SQL = "DELETE group_post_tb WHERE group_no=?";
	private final static String INSERT_GROUPPOST_SQL = "INSERT INTO group_post_tb VALUES(?,?)";
	public List<GroupPostDTO> getGroupPost() throws DAOException {
		List<GroupPostDTO> groupPosts = new ArrayList<GroupPostDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_GROUPPOST_SQL);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				GroupPostDTO gpost = new GroupPostDTO();
				gpost.setGroupNo(resultSet.getInt("group_no"));
				gpost.setPostNo(resultSet.getInt("post_no"));
				groupPosts.add(gpost);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return groupPosts;
	}
	
	public List<GroupPostDTO> getGroupPostById(String id) throws DAOException {
		List<GroupPostDTO> groupPosts = new ArrayList<GroupPostDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_GROUPPOST_BY_ID_SQL);
			pStatement.setString(1, id);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				GroupPostDTO gpost = new GroupPostDTO();
				gpost.setGroupNo(resultSet.getInt("group_no"));
				gpost.setPostNo(resultSet.getInt("post_no"));
				groupPosts.add(gpost);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return groupPosts;
	}
	
	public List<GroupPostDTO> getGroupPostByGroupNum(Integer groupNum) throws DAOException {
		List<GroupPostDTO> groupPosts = new ArrayList<GroupPostDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_GROUPPOST_BY_GROUP_NUM_SQL);
			pStatement.setInt(1, groupNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				GroupPostDTO gpost = new GroupPostDTO();
				gpost.setGroupNo(resultSet.getInt("group_no"));
				gpost.setPostNo(resultSet.getInt("post_no"));
				groupPosts.add(gpost);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return groupPosts;
	}
	
	public void deleteGroupPostByPostNum(Integer postNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_GROUPPOST_BY_POSTNUM_SQL);
			pStatement.setInt(1, postNum);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void deleteGroupPostByGroupNum(Integer groupNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_GROUPPOST_BY_GROUPNUM_SQL);
			pStatement.setInt(1,groupNum);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void insertGroupPost(Integer postNum, Integer groupNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(INSERT_GROUPPOST_SQL);
			pStatement.setInt(1, postNum);
			pStatement.setInt(2, groupNum);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}

	/*public static void main(String[] args){
		DependencyInjector di = new DependencyInjector();
		di.start();
		GroupPostDAO groupPostDAO = di.createGroupPostDAO();
		try{
			System.out.println(groupPostDAO.getGroupPost());
			System.out.println(groupPostDAO.getGroupPostByGroupNum(1));
			System.out.println(groupPostDAO.getGroupPostById("id1"));
			//groupPostDAO.insertGroupPost(2, 2);
			//groupPostDAO.deleteGroupPostByGroupNum(2);
			//groupPostDAO.deleteGroupPostByPostNum(1);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}*/
}
