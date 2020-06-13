package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.PrivacyDTO;


public class PrivacyDAOImpl extends BaseDAO implements PrivacyDAO {
	private final static String GET_PRIVACY_SQL = "SELECT * FROM privacy_tb";
	private final static String GET_PRIVACY_LEVEL_SQL = "SELECT privacy_level FROM privacy_tb WHERE privacy_content=?";
	private final static String GET_PRIVACY_CONTENT_SQL = "SELECT privacy_content FROM privacy_tb WHERE privacy_level =?";
	private final static String UPDATE_PRIVACY_CONTENT_SQL = "UPDATE privacy_tb SET privacy_content =? WHERE privacy_level =?";
	private final static String DELETE_PRIVACY_SQL = "DELETE FROM privacy_tb WHERE privacy_level=?";
	private final static String DELETE_PRIVACY_BY_CONTENT_SQL = "DELETE FROM privacy_tb WHERE privacy_content=?";
	private final static String INSERT_PRIVACY_SQL = "INSERT INTO privacy_tb VALUES(?,?)";
	@Override
	public List<PrivacyDTO> getPrivacy() throws DAOException {
		// TODO Auto-generated method stub
		List<PrivacyDTO> privacyDTOs = new ArrayList<PrivacyDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_PRIVACY_SQL);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				PrivacyDTO privacyDTO = new PrivacyDTO();
				privacyDTO.setPrivacyLevel(rs.getInt("PRIVACY_LEVEL"));
				privacyDTO.setPrivacyContent(rs.getString("PRIVACY_CONTENT"));
				privacyDTOs.add(privacyDTO);
			}
		}
		catch(SQLException e){
			throw new DAOException("Error:"+e.getMessage());
		}
		finally{
			closeDBObjects(rs, pstmt, conn);
		}
		
		return privacyDTOs;
	}
	@Override
	public Integer getPrivacyLevel(String privacyContent) 
			throws DAOException {
		// TODO Auto-generated method stub
		int level = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_PRIVACY_LEVEL_SQL);
			pstmt.setString(1, privacyContent);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				level = rs.getInt("PRIVACY_LEVEL");
			}
		}
		catch(SQLException e){
			throw new DAOException("Error:"+e.getMessage());
		}
		finally{
			closeDBObjects(rs, pstmt, conn);
		}
		
		return new Integer(level);
	}
	@Override
	public String getPrivacyContent(Integer privacyLevel)
			throws DAOException {
		// TODO Auto-generated method stub
		String content = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_PRIVACY_CONTENT_SQL);
			pstmt.setInt(1, privacyLevel);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				content = rs.getString("PRIVACY_CONTENT");
			}
		}
		catch(SQLException e){
			throw new DAOException("Error:"+e.getMessage());
		}
		finally{
			closeDBObjects(rs, pstmt, conn);
		}
		
		return content;
	}
	@Override
	public void updatePrivacy(String privacyContent, Integer privacyLevel)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(UPDATE_PRIVACY_CONTENT_SQL);
			pstmt.setString(1, privacyContent);
			pstmt.setInt(2,privacyLevel);
			
			pstmt.execute();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			closeDBObjects(null, pstmt, conn);
		}
	}
	@Override
	public void deletePrivacy(Integer privacyLevel) throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(DELETE_PRIVACY_SQL);
			pstmt.setInt(1, privacyLevel);
			
			pstmt.execute();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			closeDBObjects(null, pstmt, conn);
		}
	}
	@Override
	public void deletePrivacyByContent(String privacyContent)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(DELETE_PRIVACY_BY_CONTENT_SQL);
			pstmt.setString(1, privacyContent);
			
			pstmt.execute();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			closeDBObjects(null, pstmt, conn);
		}
		
	}
	@Override
	public void insertPrivacy(Integer privacyLevel, String privacyContent)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(INSERT_PRIVACY_SQL);
			pstmt.setInt(1, privacyLevel);
			pstmt.setString(2, privacyContent);
			pstmt.execute();
		}
		catch(SQLException e){
			throw new DAOException("Error : "+e.getMessage());
		}
		finally{
			closeDBObjects(null, pstmt, conn);
		}
	}
	
	/*public static void main(String[] args) {
		DependencyInjector injector = new DependencyInjector();
		try{
			injector.start();
			PrivacyDAO privacyDAO = (PrivacyDAO)injector.getObject(PrivacyDAO.class);
			try{
				//====전체검색====
				System.out.println(privacyDAO.getPrivacy());
				//====내용으로 검색====
				System.out.println(privacyDAO.getPrivacyLevel("전체공개"));
				//====번호로 검색====
				System.out.println(privacyDAO.getPrivacyContent(5));
				
				//삭제, 추가
				//privacyDAO.deletePrivacy(5);
				//privacyDAO.insertPrivacy(5, "그룹멤버에게만 공개");
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		finally{
			injector.shutDown();
		}
	}	*/
}
