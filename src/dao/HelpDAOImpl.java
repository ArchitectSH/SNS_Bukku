package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.GuestPostDTO;
import dto.HelpDTO;


public class HelpDAOImpl extends BaseDAO implements HelpDAO {
	private final static String GET_HELP_SQL = "SELECT * FROM help_tb";
	private final static String GET_HELP_BY_NUM_SQL = "SELECT * FROM help_tb WHERE help_no=?";
	private final static String GET_HELP_BY_TITLE_SQL = "SELECT * FROM help_tb WHERE help_title=?";
	private final static String UPDATE_HELP_SQL = "UPDATE help_tb SET help_title=?, help_content=? WHERE help_no=?";
	private final static String UPDATE_HELP_TITLE_SQL = "UPDATE help_tb SET help_title=? WHERE help_no=?";
	private final static String UPDATE_HELP_CONTENT_SQL = "UPDATE help_tb SET help_content=? WHERE help_no=?";
	private final static String DELETE_HELP_BY_ID_SQL = "DELETE FROM help_tb WHERE admin_id=?";
	private final static String DELETE_HELP_BY_HELP_NUM_SQL = "DELETE FROM help_tb WHERE help_no=?";
	private final static String INSERT_HELP_SQL = "INSERT into help_tb VALUES(help_seq.NEXTVAL,?,?,?)";
	public List<HelpDTO> getHelp() throws DAOException {
		List<HelpDTO> helps = new ArrayList<HelpDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_HELP_SQL);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				HelpDTO hDTO = new HelpDTO();
				hDTO.setHelpNo(resultSet.getInt("help_no"));
				hDTO.setAdminId(resultSet.getString("admin_id"));
				hDTO.setHelpTitle(resultSet.getString("help_title"));
				hDTO.setHelpContent(resultSet.getString("help_content"));
				helps.add(hDTO);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return helps;
	}
	
	public HelpDTO getHelpByNum(Integer helpNum) throws DAOException {
		HelpDTO hDTO = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_HELP_BY_NUM_SQL);
			pStatement.setInt(1, helpNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				hDTO = new HelpDTO();
				hDTO.setHelpNo(resultSet.getInt("help_no"));
				hDTO.setAdminId(resultSet.getString("admin_id"));
				hDTO.setHelpTitle(resultSet.getString("help_title"));
				hDTO.setHelpContent(resultSet.getString("help_content"));
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return hDTO;
	}
	
	public List<HelpDTO> getHelpByTitle(String helpTitle) throws DAOException {
		List<HelpDTO> helps = new ArrayList<HelpDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_HELP_BY_TITLE_SQL);
			pStatement.setString(1, helpTitle);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				HelpDTO hDTO = new HelpDTO();
				hDTO.setHelpNo(resultSet.getInt("help_no"));
				hDTO.setAdminId(resultSet.getString("admin_id"));
				hDTO.setHelpTitle(resultSet.getString("help_title"));
				hDTO.setHelpContent(resultSet.getString("help_content"));
				helps.add(hDTO);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return helps;
	}
	
	public void updateHelp(String helpTitle, String helpContent, Integer helpNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_HELP_SQL);
			pStatement.setString(1, helpTitle);
			pStatement.setString(2, helpContent);
			pStatement.setInt(3, helpNum);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void updateHelpTitle(String helpTitle, Integer helpNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_HELP_TITLE_SQL);
			pStatement.setString(1, helpTitle);
			pStatement.setInt(2, helpNum);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void updateHelpContent(String helpContent, Integer helpNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_HELP_CONTENT_SQL);
			pStatement.setString(1, helpContent);
			pStatement.setInt(2, helpNum);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void deleteHelpById(String adminId) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_HELP_BY_ID_SQL);
			pStatement.setString(1, adminId);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void deleteHelpByNum(Integer helpNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_HELP_BY_HELP_NUM_SQL);
			pStatement.setInt(1, helpNum);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void insertHelp(String adminId, String helpTitle, String helpContent) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(INSERT_HELP_SQL);
			pStatement.setString(1, adminId);
			pStatement.setString(2, helpTitle);
			pStatement.setString(3, helpContent);
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
		HelpDAO helpDAO = di.createHelpDAO();
		try{
			System.out.println(helpDAO.getHelp());
			System.out.println(helpDAO.getHelpByNum(4));
			System.out.println(helpDAO.getHelpByTitle("도와드릴까요"));
			//helpDAO.insertHelp("admin1", "도와드릴까요", "도와줄게요");
			//helpDAO.deleteHelpById("admin1");
			helpDAO.deleteHelpByNum(9);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
