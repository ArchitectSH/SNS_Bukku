package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.NoticeDTO;

public class NoticeDAOImpl extends BaseDAO implements NoticeDAO {
	private final static String GET_NOTICE_SQL = "SELECT * FROM notice_tb";
	private final static String GET_NOTICE_BY_ID_SQL = "SELECT * FROM notice_tb WHERE admin_id=?";
	private final static String GET_NOTICE_BY_NUM_SQL = "SELECT * FROM notice_tb WHERE notice_no=?";
	private final static String UPDATE_NOTICE_SQL = "UPDATE notice_tb SET notice_title = ?, notice_content=? WHERE notice_no=?";
	private final static String UPDATE_NOTICE_TITLE_SQL = "UPDATE notice_tb SET notice_title = ? WHERE notice_no=?";
	private final static String UPDATE_NOTICE_CONTENT_SQL = "UPDATE notice_tb SET notice_content=? WHERE notice_no=?";
	private final static String DELETE_NOTICE_SQL = "DELETE FROM notice_tb WHERE notice_no=?";
	private final static String DELETE_NOTICE_BY_ID_SQL = "DELETE FROM notice_tb WHERE admin_id=?";
	private final static String DELETE_NOTICE_BY_TITLE_SQL = "DELETE FROM notice_tb WHERE notice_title=?";
	private final static String INSERT_NOTICE_SQL = "INSERT into notice_tb VALUES(notice_seq.NEXTVAL,?,?,?,sysdate)";
	public List<NoticeDTO> getNotice() throws DAOException {
		List<NoticeDTO> notices = new ArrayList<NoticeDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_NOTICE_SQL);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				NoticeDTO notice = new NoticeDTO();
				notice.setAdminId(resultSet.getString("admin_id"));
				notice.setNoticeContent(resultSet.getString("notice_content"));
				notice.setNoticeDate(resultSet.getString("notice_date"));
				notice.setNoticeNo(resultSet.getInt("notice_no"));
				notice.setNoticeTitle(resultSet.getString("notice_title"));
				notices.add(notice);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return notices;
	}
	
	public List<NoticeDTO> getNoticeById(String adminId) throws DAOException {
		List<NoticeDTO> notices = new ArrayList<NoticeDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_NOTICE_BY_ID_SQL);
			pStatement.setString(1, adminId);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				NoticeDTO notice = new NoticeDTO();
				notice.setAdminId(resultSet.getString("admin_id"));
				notice.setNoticeContent(resultSet.getString("notice_content"));
				notice.setNoticeDate(resultSet.getString("notice_date"));
				notice.setNoticeNo(resultSet.getInt("notice_no"));
				notice.setNoticeTitle(resultSet.getString("notice_title"));
				notices.add(notice);
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return notices;
	}
	
	public NoticeDTO getNoticeByNum(Integer noticeNum) throws DAOException {
		NoticeDTO notice = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_NOTICE_BY_NUM_SQL);
			pStatement.setInt(1, noticeNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				notice = new NoticeDTO();
				notice.setAdminId(resultSet.getString("admin_id"));
				notice.setNoticeContent(resultSet.getString("notice_content"));
				notice.setNoticeDate(resultSet.getString("notice_date"));
				notice.setNoticeNo(resultSet.getInt("notice_no"));
				notice.setNoticeTitle(resultSet.getString("notice_title"));
			}
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(resultSet, pStatement, connection);
		}
		return notice;
	}
	
	public void updateNotice(String noticeTitle, String noticeContent, Integer noticeNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_NOTICE_SQL);
			pStatement.setString(1, noticeTitle);
			pStatement.setString(2, noticeContent);
			pStatement.setInt(3, noticeNum);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void updateNoticeTitle(String noticeTitle, Integer noticeNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_NOTICE_TITLE_SQL);
			pStatement.setString(1, noticeTitle);
			pStatement.setInt(2, noticeNum);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void updateNoticeContent(String noticeContent, Integer noticeNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_NOTICE_CONTENT_SQL);
			pStatement.setString(1, noticeContent);
			pStatement.setInt(2, noticeNum);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void deleteNotice(Integer noticeNum) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_NOTICE_SQL);
			pStatement.setInt(1, noticeNum);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void deleteNoticeById(String adminId) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_NOTICE_BY_ID_SQL);
			pStatement.setString(1, adminId);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void deleteNoticeByTitle(String noticeTitle) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_NOTICE_BY_TITLE_SQL);
			pStatement.setString(1, noticeTitle);
			pStatement.executeQuery();
		}catch(SQLException e){
			throw new DAOException(e.getMessage());
		}finally{
			closeDBObjects(null, pStatement, connection);
		}
	}
	
	public void insertNotice(String adminId, String noticeTitle, String noticeContent) throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();
			pStatement = connection.prepareStatement(INSERT_NOTICE_SQL);
			pStatement.setString(1, adminId);
			pStatement.setString(2, noticeTitle);
			pStatement.setString(3, noticeContent);
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
		NoticeDAO noticeDAO = di.createNoticeDAO();
		try {
			System.out.println(noticeDAO.getNotice());
			System.out.println(noticeDAO.getNoticeById("admin1"));
			System.out.println(noticeDAO.getNoticeByNum(3));
			noticeDAO.insertNotice("admin1", "공지사항1", "공지공지");
			noticeDAO.insertNotice("admin1", "공지사항2", "공지공지");
			noticeDAO.insertNotice("admin1", "공지사항3", "공지공지");
			//noticeDAO.deleteNotice(3);
			//noticeDAO.deleteNoticeById("admin1");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
