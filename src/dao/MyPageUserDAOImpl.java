package dao;

import injector.MyPageDependencyInjector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import dto.*;


public class MyPageUserDAOImpl extends BaseDAO implements MyPageUserDAO {
	private static String GET_MYPAGE_USER_SQL = "SELECT * FROM mypage_user_tb";
	private static String GET_MYPAGE_USER_BY_TITLE_SQL = "SELECT * FROM mypage_user_tb WHERE mypage_title=?";
	private static String GET_MYPAGE_USER_BY_KIND_TITLE_SQL = "SELECT * FROM mypage_user_tb WHERE mypage_kind_no=? AND mypage_title=?";
	private static String GET_MYPAGE_USER_BY_ID_SQL = "SELECT * FROM mypage_user_tb WHERE id=?";
	private static String GET_MYPAGE_USER_BY_KIND_SQL = "SELECT * FROM mypage_user_tb WHERE mypage_kind_no=?";
	private static String GET_MYPAGE_USER_BY_KIND_ID_SQL = "SELECT * FROM mypage_user_tb WHERE mypage_kind_no=? AND id=?";
	private static String UPDATE_MYPAGE_USER_SQL = "UPDATE mypage_user_tb SET mypage_kind_no = ? WHERE id=? AND mypage_title=?";
	private static String DELETE_MYPAGE_USER_SQL = "DELETE FROM mypage_user_tb WHERE id=?";
	private static String DELETE_MYPAGE_USER_TITLE_ID_SQL = "DELETE FROM mypage_user_tb WHERE id=? AND mypage_title=?";
	private static String DELETE_MYPAGE_USER_TITLE = "DELETE FROM mypage_user_tb WHERE mypage_title=?";
	private static String INSERT_MYPAGE_USER_SQL = "INSERT INTO mypage_user_tb VALUES(mypage_user_seq.nextval,?,?,?)";

	@Override
	public List<MyPageUserDTO> getMyPageUser() throws DAOException {
		// TODO Auto-generated method stub
		List<MyPageUserDTO> myPageUserDTOs = new ArrayList<MyPageUserDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_MYPAGE_USER_SQL);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				MyPageUserDTO myPageUserDTO = new MyPageUserDTO();
				myPageUserDTO.setMyPageUserNo(rs.getInt("MYPAGE_USER_NO"));
				myPageUserDTO.setMyPageTitle(rs.getString("MYPAGE_TITLE"));
				myPageUserDTO.setMyPageKindNo(rs.getInt("MYPAGE_KIND_NO"));
				myPageUserDTO.setId(rs.getString("ID"));
				
				myPageUserDTOs.add(myPageUserDTO);
			}
			
		}
		catch(SQLException e){
			throw new DAOException("Error : "+e.getMessage());
		}
		finally{
			closeDBObjects(rs, pstmt, conn);
		}
		return myPageUserDTOs;
	}
	@Override
	public List<MyPageUserDTO> getMyPageUserByTitle(String myPageTitle)
			throws DAOException {
		// TODO Auto-generated method stub
		List<MyPageUserDTO> myPageUserDTOs = new ArrayList<MyPageUserDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_MYPAGE_USER_BY_TITLE_SQL);
			pstmt.setString(1, myPageTitle);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				MyPageUserDTO myPageUserDTO = new MyPageUserDTO();
				myPageUserDTO.setMyPageUserNo(rs.getInt("MYPAGE_USER_NO"));
				myPageUserDTO.setMyPageTitle(rs.getString("MYPAGE_TITLE"));
				myPageUserDTO.setMyPageKindNo(rs.getInt("MYPAGE_KIND_NO"));
				myPageUserDTO.setId(rs.getString("ID"));
				
				myPageUserDTOs.add(myPageUserDTO);
			}
			
		}
		catch(SQLException e){
			throw new DAOException("Error : "+e.getMessage());
		}
		finally{
			closeDBObjects(rs, pstmt, conn);
		}
		return myPageUserDTOs;
	}
	@Override
	public List<MyPageUserDTO> getMyPageUserById(String id) throws DAOException {
		// TODO Auto-generated method stub
		List<MyPageUserDTO> myPageUserDTOs = new ArrayList<MyPageUserDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_MYPAGE_USER_BY_ID_SQL);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				MyPageUserDTO myPageUserDTO = new MyPageUserDTO();
				myPageUserDTO.setMyPageUserNo(rs.getInt("MYPAGE_USER_NO"));
				myPageUserDTO.setMyPageTitle(rs.getString("MYPAGE_TITLE"));
				myPageUserDTO.setMyPageKindNo(rs.getInt("MYPAGE_KIND_NO"));
				myPageUserDTO.setId(rs.getString("ID"));
				
				myPageUserDTOs.add(myPageUserDTO);
			}
			
		}
		catch(SQLException e){
			throw new DAOException("Error : "+e.getMessage());
		}
		finally{
			closeDBObjects(rs, pstmt, conn);
		}
		return myPageUserDTOs;
	}
	@Override
	public List<MyPageUserDTO> getMyPageUserByKind(Integer kind)
			throws DAOException {
		// TODO Auto-generated method stub
		List<MyPageUserDTO> myPageUserDTOs = new ArrayList<MyPageUserDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_MYPAGE_USER_BY_KIND_SQL);
			pstmt.setInt(1, kind);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				MyPageUserDTO myPageUserDTO = new MyPageUserDTO();
				myPageUserDTO.setMyPageUserNo(rs.getInt("MYPAGE_USER_NO"));
				myPageUserDTO.setMyPageTitle(rs.getString("MYPAGE_TITLE"));
				myPageUserDTO.setMyPageKindNo(rs.getInt("MYPAGE_KIND_NO"));
				myPageUserDTO.setId(rs.getString("ID"));
				
				myPageUserDTOs.add(myPageUserDTO);
			}
			
		}
		catch(SQLException e){
			throw new DAOException("Error : "+e.getMessage());
		}
		finally{
			closeDBObjects(rs, pstmt, conn);
		}
		return myPageUserDTOs;
	}
	@Override
	public List<MyPageUserDTO> getMyPageUserByKindId(Integer kind, String id)
			throws DAOException {
		// TODO Auto-generated method stub
		List<MyPageUserDTO> myPageUserDTOs = new ArrayList<MyPageUserDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_MYPAGE_USER_BY_KIND_ID_SQL);
			pstmt.setInt(1, kind);
			pstmt.setString(2, id);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				MyPageUserDTO myPageUserDTO = new MyPageUserDTO();
				myPageUserDTO.setMyPageUserNo(rs.getInt("MYPAGE_USER_NO"));
				myPageUserDTO.setMyPageTitle(rs.getString("MYPAGE_TITLE"));
				myPageUserDTO.setMyPageKindNo(rs.getInt("MYPAGE_KIND_NO"));
				myPageUserDTO.setId(rs.getString("ID"));
				
				myPageUserDTOs.add(myPageUserDTO);
			}
			
		}
		catch(SQLException e){
			throw new DAOException("Error : "+e.getMessage());
		}
		finally{
			closeDBObjects(rs, pstmt, conn);
		}
		return myPageUserDTOs;
	}
	@Override
	public void updateMyPageUser(Integer kind, String id, String myPageTitle)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(UPDATE_MYPAGE_USER_SQL);
			pstmt.setInt(1, kind);
			pstmt.setString(2, id);
			pstmt.setString(3, myPageTitle);
			
			pstmt.execute();
		}
		catch(SQLException e){
			throw new DAOException("Error : "+e.getMessage());
		}
		finally{
			closeDBObjects(null, pstmt, conn);
		}
	}
	@Override
	public void deleteMyPageUser(String id) throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(DELETE_MYPAGE_USER_SQL);
			pstmt.setString(1, id);
			
			pstmt.execute();
		}
		catch(SQLException e){
			throw new DAOException("Error : "+e.getMessage());
		}
	}
	@Override
	public void deleteMyPageUserByTitleId(String id, String title)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(DELETE_MYPAGE_USER_TITLE_ID_SQL);
			pstmt.setString(1, id);
			pstmt.setString(2, title);
			
			pstmt.execute();
		}
		catch(SQLException e){
			throw new DAOException("Error : "+e.getMessage());
		}
	}
	@Override
	public void deleteMyPageUserByTitle(String title) throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(DELETE_MYPAGE_USER_TITLE);
			pstmt.setString(1, title);
			
			pstmt.execute();
		}
		catch(SQLException e){
			throw new DAOException("Error : "+e.getMessage());
		}
	}
	@Override
	public void insertMyPageUser(String myPageTitle, Integer kind, String id)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(INSERT_MYPAGE_USER_SQL);
			pstmt.setString(1, myPageTitle);
			pstmt.setInt(2, kind);
			pstmt.setString(3, id);
			
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
			MyPageUserDAO myPageUserDAO = (MyPageUserDAO)injector.getObject(MyPageUserDAO.class);
			try{
				//전체검색
				System.out.println(myPageUserDAO.getMyPageUser());
				//페이지타이틀로 검색
				System.out.println(myPageUserDAO.getMyPageUserByTitle("mypage1"));
				//ID로 검색
				System.out.println(myPageUserDAO.getMyPageUserById("id7"));
				//종류로 검색
				System.out.println(myPageUserDAO.getMyPageUserByKind(1));
				//id와 종류로 검색
				System.out.println(myPageUserDAO.getMyPageUserByKindId(1, "id7"));
				//수정, 추가, 삭제
				//myPageUserDAO.updateMyPageUser(2, "id6", "mypage1");
				//myPageUserDAO.insertMyPageUser("mypage1", 1, "id8");
				//myPageUserDAO.deleteMyPageUser("id7");
				//myPageUserDAO.deleteMyPageUserByTitleId("id6", "mypage1");
				//myPageUserDAO.deleteMyPageUserByTitle("mypage1");
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		finally{
			injector.shutDown();
		}
	}*/
	@Override
	public List<MyPageUserDTO> getMyPageUserByKindTitle(Integer kind,
			String myPageTitle) throws DAOException {
		// TODO Auto-generated method stub
		List<MyPageUserDTO> myPageUserDTOs = new ArrayList<MyPageUserDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_MYPAGE_USER_BY_KIND_TITLE_SQL);
			pstmt.setInt(1, kind);
			pstmt.setString(2, myPageTitle);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				MyPageUserDTO myPageUserDTO = new MyPageUserDTO();
				myPageUserDTO.setMyPageUserNo(rs.getInt("MYPAGE_USER_NO"));
				myPageUserDTO.setMyPageTitle(rs.getString("MYPAGE_TITLE"));
				myPageUserDTO.setMyPageKindNo(rs.getInt("MYPAGE_KIND_NO"));
				myPageUserDTO.setId(rs.getString("ID"));
				
				myPageUserDTOs.add(myPageUserDTO);
			}
			
		}
		catch(SQLException e){
			throw new DAOException("Error : "+e.getMessage());
		}
		finally{
			closeDBObjects(rs, pstmt, conn);
		}
		return myPageUserDTOs;
	}
}
