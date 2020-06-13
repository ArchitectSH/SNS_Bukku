package dao;

import injector.MyPageDependencyInjector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


import dto.*;


public class MyPageFollowingDAOImpl extends BaseDAO implements MyPageFollowingDAO {
	private static String GET_MYPAGE_FOLLOWING_SQL = "SELECT * FROM mypage_following_tb";
	private static String GET_MYPAGE_FOLLOWING_BY_TITLE_SQL = "SELECT * FROM mypage_following_tb WHERE mypage_title = ?";
	private static String GET_MYPAGE_FOLLOWING_BY_ID_SQL = "SELECT * FROM mypage_following_tb WHERE id=?";
	private static String DELETE_MYPAGE_FOLLOWING_SQL = "DELETE FROM mypage_following_tb WHERE mypage_title=?";
	private static String DELETE_MYPAGE_FOLLOWING_BY_TITLE_ID_SQL = "DELETE FROM mypage_following_tb WHERE mypage_title=? AND id=?";
	private static String DELETE_MYPAGE_FOLLOWING_BY_ID_SQL = "DELETE FROM mypage_following_tb WHERE id=?";
	private static String INSERT_MYPAGE_FOLLOWING_SQL = "INSERT INTO mypage_following_tb VALUES(mypage_following_seq.nextval,?,?)";
	
	@Override
	public List<MyPageFollowingDTO> getMyPageFollowing() throws DAOException {
		// TODO Auto-generated method stub
		List<MyPageFollowingDTO> myPageFollowingDTOs = new ArrayList<MyPageFollowingDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_MYPAGE_FOLLOWING_SQL);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				MyPageFollowingDTO myPageFollowingDTO = new MyPageFollowingDTO();
				myPageFollowingDTO.setFollowingNo(rs.getInt("FOLLOWING_NO"));
				myPageFollowingDTO.setMyPageTitle(rs.getString("MYPAGE_TITLE"));
				myPageFollowingDTO.setId(rs.getString("ID"));
				
				myPageFollowingDTOs.add(myPageFollowingDTO);
			}
		}
		catch(SQLException e){
			throw new DAOException("Error : "+e.getMessage());
		}
		finally{
			closeDBObjects(rs, pstmt, conn);
		}
		return myPageFollowingDTOs;
	}
	@Override
	public List<MyPageFollowingDTO> getMyPageFollowingByTitle(String title)
			throws DAOException {
		// TODO Auto-generated method stub
		List<MyPageFollowingDTO> myPageFollowingDTOs = new ArrayList<MyPageFollowingDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_MYPAGE_FOLLOWING_BY_TITLE_SQL);
			pstmt.setString(1, title);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				MyPageFollowingDTO myPageFollowingDTO = new MyPageFollowingDTO();
				myPageFollowingDTO.setFollowingNo(rs.getInt("FOLLOWING_NO"));
				myPageFollowingDTO.setMyPageTitle(rs.getString("MYPAGE_TITLE"));
				myPageFollowingDTO.setId(rs.getString("ID"));
				
				myPageFollowingDTOs.add(myPageFollowingDTO);
			}
		}
		catch(SQLException e){
			throw new DAOException("Error : "+e.getMessage());
		}
		finally{
			closeDBObjects(rs, pstmt, conn);
		}
		return myPageFollowingDTOs;
	}
	@Override
	public List<MyPageFollowingDTO> getMyPageFollowingById(String id)
			throws DAOException {
		// TODO Auto-generated method stub
		List<MyPageFollowingDTO> myPageFollowingDTOs = new ArrayList<MyPageFollowingDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_MYPAGE_FOLLOWING_BY_ID_SQL);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				MyPageFollowingDTO myPageFollowingDTO = new MyPageFollowingDTO();
				myPageFollowingDTO.setFollowingNo(rs.getInt("FOLLOWING_NO"));
				myPageFollowingDTO.setMyPageTitle(rs.getString("MYPAGE_TITLE"));
				myPageFollowingDTO.setId(rs.getString("ID"));
				
				myPageFollowingDTOs.add(myPageFollowingDTO);
			}
		}
		catch(SQLException e){
			throw new DAOException("Error : "+e.getMessage());
		}
		finally{
			closeDBObjects(rs, pstmt, conn);
		}
		return myPageFollowingDTOs;
	}
	@Override
	public void deleteMyPageFollowing(String myPageTitle) throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(DELETE_MYPAGE_FOLLOWING_SQL);
			pstmt.setString(1, myPageTitle);
			
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
	public void deleteMyPageFollowingByTitleId(String myPageTitle, String id)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(DELETE_MYPAGE_FOLLOWING_BY_TITLE_ID_SQL);
			pstmt.setString(1, myPageTitle);
			pstmt.setString(2, id);
			
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
	public void deleteMyPageFollowingById(String id) throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(DELETE_MYPAGE_FOLLOWING_BY_ID_SQL);
			pstmt.setString(1, id);
			
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
	public void insertMyPageFollowing(String myPageTitle, String id)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(INSERT_MYPAGE_FOLLOWING_SQL);
			pstmt.setString(1, myPageTitle);
			pstmt.setString(2, id);
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
		MyPageDependencyInjector injector = new MyPageDependencyInjector();
		try{
			injector.start();
			MyPageFollowingDAO myPageFollowingDAO = (MyPageFollowingDAO)injector.getObject(MyPageFollowingDAO.class);
			try{
				//====전체검색
				System.out.println(myPageFollowingDAO.getMyPageFollowing());
				//====제목으로 검색
				System.out.println(myPageFollowingDAO.getMyPageFollowingByTitle("mypage1"));
				//====ID로 검색
				System.out.println(myPageFollowingDAO.getMyPageFollowingById("id3"));
				
				//====추가
				//myPageFollowingDAO.insertMyPageFollowing("mypage1", "id5");
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
