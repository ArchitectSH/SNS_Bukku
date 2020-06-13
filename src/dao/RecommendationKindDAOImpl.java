package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.RecommendationKindDTO;

public class RecommendationKindDAOImpl extends BaseDAO implements RecommendationKindDAO {
	private final String GET_RECOMMENDATION_KIND_SQL = "SELECT * FROM recommendation_kind_tb";
	private final String GET_RECOMMENDATION_KIND_BY_NUM_SQL = "SELECT * FROM recommendation_kind_tb WHERE recommendation_kind_no =?";
	private final String UPDATE_RECOMMENDATION_KIND_SQL = "UPDATE recommendation_kind_tb SET recommendation_kind=? WHERE recommendation_kind_no=?";
	private final String DELETE_RECOMMENDATION_KIND_SQL = "DELETE recommendation_kind_tb WHERE recommendation_kind_no =?";
	private final String INSERT_RECOMMENDATION_KIND_SQL = "INSERT INTO recommendation_kind_tb VALUES(?,?)";
	public List<RecommendationKindDTO> getRecommendationKind() throws DAOException {
		List<RecommendationKindDTO> recommendKinds = new ArrayList<RecommendationKindDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_RECOMMENDATION_KIND_SQL);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				RecommendationKindDTO recommendKind = new RecommendationKindDTO();
				recommendKind.setRecommendationKindNo(resultSet.getInt("recommendation_kind_no"));
				recommendKind.setRecommendationKind(resultSet.getString("recommendation_kind"));
				recommendKinds.add(recommendKind);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return recommendKinds;
	}
	
	public RecommendationKindDTO getRecommendationKindByNum(Integer recommendationKindNum) throws DAOException {
		RecommendationKindDTO recommendKind = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_RECOMMENDATION_KIND_BY_NUM_SQL);
			pStatement.setInt(1, recommendationKindNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				recommendKind = new RecommendationKindDTO();
				recommendKind.setRecommendationKindNo(resultSet.getInt(resultSet.getInt("recommendation_kind_no")));
				recommendKind.setRecommendationKind(resultSet.getString("recommendation_kind"));
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return recommendKind;
	}
	
	public void updateRecommendationKind(String recommendationKind, Integer recommendationKindNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_RECOMMENDATION_KIND_SQL);
			pStatement.setString(1,recommendationKind);
			pStatement.setInt(2, recommendationKindNum);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void deleteRecommendationKind(Integer recommendationKindNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_RECOMMENDATION_KIND_SQL);
			pStatement.setInt(1, recommendationKindNum);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void insertRecommendationKind(Integer recommendationKindNum, String recommendationKind) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(INSERT_RECOMMENDATION_KIND_SQL);
			pStatement.setInt(1, recommendationKindNum);
			pStatement.setString(2, recommendationKind);
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
		RecommendationKindDAO recommendationKindDAO = di.createRecommendationKindDAO();
		try {
			System.out.println(recommendationKindDAO.getRecommendationKind());
			System.out.println(recommendationKindDAO.getRecommendationKindByNum(1));
			//recommendationKindDAO.insertRecommendationKind(5, "¸ô¶ó");
			//recommendationKindDAO.updateRecommendationKind("¸Þ·Õ", 5);
			//recommendationKindDAO.deleteRecommendationKind(5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
