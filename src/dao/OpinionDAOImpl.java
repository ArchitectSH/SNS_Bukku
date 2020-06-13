package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.OpinionDTO;

public class OpinionDAOImpl extends BaseDAO implements OpinionDAO {
	private final static String GET_OPINION_SQL = "SELECT * FROM opinion_tb";
	private final static String GET_OPINION_BY_ID_SQL = "SELECT * FROM opinion_tb WHERE id=?";
	private final static String GET_OPINION_BY_NUM_SQL = "SELECT * FROM opinion_tb WHERE opinion_no=?";
	private final static String GET_OPINION_BY_TITLE_SQL = "SELECT * FROM opinion_tb WHERE opinion_title=?";
	private final static String DELETE_OPINION_SQL = "DELETE FROM opinion_tb WHERE id=?";
	private final static String INSERT_OPINION_SQL = "INSERT INTO opinion_tb VALUES(opinion_seq.nextval,?,?,sysdate,?)";
	public List<OpinionDTO> getOpinion() throws DAOException {
		List<OpinionDTO> opinions = new ArrayList<OpinionDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_OPINION_SQL);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				OpinionDTO opinion = new OpinionDTO();
				opinion.setId(resultSet.getString("id"));
				opinion.setOpinionContent(resultSet.getString("opinion_content"));
				opinion.setOpinionDate(resultSet.getString("opinion_date"));
				opinion.setOpinionNo(resultSet.getInt("opinion_no"));
				opinion.setOpinionTitle(resultSet.getString("opinion_title"));
				opinions.add(opinion);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return opinions;
	}
	
	public List<OpinionDTO> getOpinionById(String id) throws DAOException {
		List<OpinionDTO> opinions = new ArrayList<OpinionDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_OPINION_BY_ID_SQL);
			pStatement.setString(1, id);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				OpinionDTO opinion = new OpinionDTO();
				opinion.setId(resultSet.getString("id"));
				opinion.setOpinionContent(resultSet.getString("opinion_content"));
				opinion.setOpinionDate(resultSet.getString("opinion_date"));
				opinion.setOpinionNo(resultSet.getInt("opinion_no"));
				opinion.setOpinionTitle(resultSet.getString("opinion_title"));
				opinions.add(opinion);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return opinions;
	}
	
	public OpinionDTO getOpinionByNum(Integer opinionNum) throws DAOException {
		OpinionDTO opinion = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_OPINION_BY_NUM_SQL);
			pStatement.setInt(1, opinionNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				opinion = new OpinionDTO();
				opinion.setId(resultSet.getString("id"));
				opinion.setOpinionContent(resultSet.getString("opinion_content"));
				opinion.setOpinionDate(resultSet.getString("opinion_date"));
				opinion.setOpinionNo(resultSet.getInt("opinion_no"));
				opinion.setOpinionTitle(resultSet.getString("opinion_title"));
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return opinion;
	}
	
	public List<OpinionDTO> getOpinionByTitle(String title) throws DAOException {
		List<OpinionDTO> opinions = new ArrayList<OpinionDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_OPINION_BY_TITLE_SQL);
			pStatement.setString(1,title);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				OpinionDTO opinion = new OpinionDTO();
				opinion.setId(resultSet.getString("id"));
				opinion.setOpinionContent(resultSet.getString("opinion_content"));
				opinion.setOpinionDate(resultSet.getString("opinion_date"));
				opinion.setOpinionNo(resultSet.getInt("opinion_no"));
				opinion.setOpinionTitle(resultSet.getString("opinion_title"));
				opinions.add(opinion);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return opinions;
	}
	
	public void deleteOpinion(String id) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_OPINION_SQL);
			pStatement.setString(1, id);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void insertOpinion(String title, String content, String id) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(INSERT_OPINION_SQL);
			pStatement.setString(1, title);
			pStatement.setString(2, content);
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
		OpinionDAO opinionDAO = di.createOpinionDAO();
		try {
			System.out.println(opinionDAO.getOpinion());
			System.out.println(opinionDAO.getOpinionById("id1"));
			System.out.println(opinionDAO.getOpinionByNum(1));
			System.out.println(opinionDAO.getOpinionByTitle("건의사항1"));
			//opinionDAO.insertOpinion("건의건의", "건의건의건의", "id1");
			//opinionDAO.deleteOpinion("id1");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
