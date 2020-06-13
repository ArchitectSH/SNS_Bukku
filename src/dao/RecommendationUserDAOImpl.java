package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.RecommendationUserDTO;

public class RecommendationUserDAOImpl extends BaseDAO implements RecommendationUserDAO {
	private final static String GET_RECOMMENDATION_USER_SQL = "SELECT * FROM recommendation_user_tb";
	private final static String GET_RECOMMENDATION_USER_BY_POSTNUM_SQL = "SELECT * FROM  recommendation_user_tb WHERE post_no =?";
	private final static String GET_RECOMMENDATION_USER_BY_RECONUM_SQL = "SELECT * FROM recommendation_user_tb WHERE recommendation_no =?";
	private final static String GET_LIKE_BUKKU_COUNT_SQL = "SELECT COUNT(*) FROM recommendation_user_tb WHERE post_no =? AND (recommendation_kind_no=1 OR recommendation_kind_no=2)";
	private final static String GET_HATE_COUNT_SQL = "SELECT COUNT(*) FROM recommendation_user_tb WHERE post_no = ? AND recommendation_kind_no=3";
	private final static String UPDATE_RECOMMENDATION_USER_SQL = "UPDATE recommendation_user_tb SET recommendation_kind_no = ?  WHERE post_no = ? AND id =?";
	private final static String DELETE_RECOMMENDATION_USER_SQL = "DELETE recommendation_user_tb WHERE post_no =?";
	private final static String DELETE_RECOMMENDATION_USER_BY_NUM_SQL = "DELETE recommendation_user_tb WHERE recommendation_no =?";
	private final static String DELETE_RECOMMENDATION_USER_BY_ID_SQL = "DELETE recommendation_user_tb WHERE id = ?";
	private final static String DELETE_RECOMMENDATION_USER_BY_POSTNUM_ID_SQL = "DELETE recommendation_user_tb WHERE post_no = ? AND id =?";
	private final static String INSERT_RECOMMENDATION_USER_SQL = "INSERT INTO recommendation_user_tb VALUES(recommendation_user_seq.nextval,?,?,?, sysdate)";
	public List<RecommendationUserDTO> getRecommendationUser() throws DAOException {
		List<RecommendationUserDTO> recommendUsers = new ArrayList<RecommendationUserDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_RECOMMENDATION_USER_SQL);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				RecommendationUserDTO recommendUser = new RecommendationUserDTO();
				recommendUser.setId(resultSet.getString("id"));
				recommendUser.setPostNo(resultSet.getInt("post_no"));
				recommendUser.setRecommendationKindNo(resultSet.getInt("recommendation_kind_no"));
				recommendUser.setRecommendationNo(resultSet.getInt("recommendation_no"));
				recommendUsers.add(recommendUser);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return recommendUsers;
	}
	
	public List<RecommendationUserDTO> getRecommendationUserByPostNum(Integer postNum) throws DAOException {
		List<RecommendationUserDTO> recommendUsers = new ArrayList<RecommendationUserDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_RECOMMENDATION_USER_BY_POSTNUM_SQL);
			pStatement.setInt(1, postNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				RecommendationUserDTO recommendUser = new RecommendationUserDTO();
				recommendUser.setId(resultSet.getString("id"));
				recommendUser.setPostNo(resultSet.getInt("post_no"));
				recommendUser.setRecommendationKindNo(resultSet.getInt("recommendation_kind_no"));
				recommendUser.setRecommendationNo(resultSet.getInt("recommendation_no"));
				recommendUsers.add(recommendUser);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return recommendUsers;
	}
	
	public RecommendationUserDTO getRecommendationUserByRecoNum(Integer recommendationNum) throws DAOException {
		RecommendationUserDTO recommendUser = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_RECOMMENDATION_USER_BY_RECONUM_SQL);
			pStatement.setInt(1, recommendationNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				recommendUser = new RecommendationUserDTO();
				recommendUser.setId(resultSet.getString("id"));
				recommendUser.setPostNo(resultSet.getInt("post_no"));
				recommendUser.setRecommendationKindNo(resultSet.getInt("recommendation_kind_no"));
				recommendUser.setRecommendationNo(resultSet.getInt("recommendation_no"));
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return recommendUser;
	}
	
	public Integer getLikeBukkuCount(Integer postNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		Integer bukkuCount = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_LIKE_BUKKU_COUNT_SQL);
			pStatement.setInt(1, postNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				bukkuCount = resultSet.getInt("COUNT(*)");
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return bukkuCount;
	}
	
	public Integer getHateCount(Integer postNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		Integer hateCount = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_HATE_COUNT_SQL);
			pStatement.setInt(1, postNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				hateCount = resultSet.getInt("COUNT(*)");
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return hateCount;
	}
	
	public void updateRecommendationUser(Integer kind, Integer postNum, String id) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		PreparedStatement pStatement2 = null;
		ResultSet resultSet = null;
		Integer hateCount = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_RECOMMENDATION_USER_SQL);
			pStatement.setInt(1, kind);
			pStatement.setInt(2, postNum);
			pStatement.setString(3, id);
			resultSet = pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
	}
	
	public void deleteRecommendationUserByPostNum(Integer postNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_RECOMMENDATION_USER_SQL);
			pStatement.setInt(1, postNum);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void deleteRecommendationUserByRecoNum(Integer recommendationNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_RECOMMENDATION_USER_BY_NUM_SQL);
			pStatement.setInt(1, recommendationNum);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void deleteRecommendationUserById(String id) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_RECOMMENDATION_USER_BY_ID_SQL);
			pStatement.setString(1, id);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void deleteRecommendationUserByPostNumId(Integer postNum, String id) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_RECOMMENDATION_USER_BY_POSTNUM_ID_SQL);
			pStatement.setInt(1, postNum);
			pStatement.setString(2, id);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void insertRecommendationUser(Integer recommendationKind, Integer postNum, String id) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(INSERT_RECOMMENDATION_USER_SQL);
			pStatement.setInt(1, recommendationKind);
			pStatement.setInt(2, postNum);
			pStatement.setString(3, id);
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
		RecommendationUserDAO recommendationUserDAO = di.createRecommendationUserDAO();
		try {
			//recommendationUserDAO.insertRecommendationUser(1, 12, "id1");
			//recommendationUserDAO.deleteRecommendationUserByPostNum(4);
			//recommendationUserDAO.deleteRecommendationUserById("id1");
			System.out.println(recommendationUserDAO.getRecommendationUser());
			System.out.println(recommendationUserDAO.getRecommendationUserByPostNum(12));
			System.out.println(recommendationUserDAO.getRecommendationUserByRecoNum(12));
			System.out.println(recommendationUserDAO.getLikeBukkuCount(12));
			System.out.println(recommendationUserDAO.getHateCount(12));
			//recommendationUserDAO.updateRecommendationUser(1, 12, "id1");
			//recommendationUserDAO.deleteRecommendationUserByRecoNum(2);
			//recommendationUserDAO.deleteRecommendationUserByPostNumId(12, "id1");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
