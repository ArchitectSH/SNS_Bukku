package dao;

import injector.DataSourceManager;
import injector.MyPageDependencyInjector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.sql.DataSource;

import dto.*;


public class MyPageDAOImpl extends BaseDAO implements MyPageDAO {
	private static String GET_MYPAGE_SQL = "SELECT * FROM mypage_tb";
	private static String GET_MYPAGE_BY_TITLE_SQL = "SELECT * FROM mypage_tb WHERE mypage_title=?";
	private static String GET_MYPAGE_BY_ID_SQL = "SELECT * FROM mypage_tb WHERE id=?";
	private static String UPDATE_MYPAGE_INTRO_SQL = "UPDATE mypage_tb SET mypage_introduction=? WHERE mypage_title=?";
	private static String UPDATE_MYPAGE_IMG_SQL = "UPDATE mypage_tb SET img=? WHERE mypage_title=?";
	private static String DELETE_MYPAGE_SQL = "DELETE FROM mypage_tb WHERE mypage_title=?";
	private static String INSERT_MYPAGE_SQL = "INSERT INTO mypage_tb VALUES(?,?,?,?)";

	@Override
	public List<MyPageDTO> getMyPage() throws DAOException {
		// TODO Auto-generated method stub
		List<MyPageDTO> myPageDTOs = new ArrayList<MyPageDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_MYPAGE_SQL);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				MyPageDTO myPageDTO = new MyPageDTO();
				myPageDTO.setMyPageTitle(rs.getString("MYPAGE_TITLE"));
				myPageDTO.setImg(rs.getString("IMG"));
				myPageDTO.setMyPageIntroduction(rs.getString("MYPAGE_INTRODUCTION"));
				myPageDTO.setId(rs.getString("ID"));
				
				myPageDTOs.add(myPageDTO);
			}
		}
		catch(SQLException e){
			throw new DAOException("Error : "+e.getMessage());
		}
		finally{
			closeDBObjects(rs, pstmt, conn);
		}
		return myPageDTOs;
	}
	@Override
	public MyPageDTO getMyPageByTitle(String title) throws DAOException {
		// TODO Auto-generated method stub
		MyPageDTO myPageDTO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_MYPAGE_BY_TITLE_SQL);
			pstmt.setString(1, title);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				myPageDTO = new MyPageDTO();
				myPageDTO.setMyPageTitle(rs.getString("MYPAGE_TITLE"));
				myPageDTO.setImg(rs.getString("IMG"));
				myPageDTO.setMyPageIntroduction(rs.getString("MYPAGE_INTRODUCTION"));
				myPageDTO.setId(rs.getString("ID"));
			}
		}
		catch(SQLException e){
			throw new DAOException("Error : "+e.getMessage());
		}
		finally{
			closeDBObjects(rs, pstmt, conn);
		}
		return myPageDTO;
	}
	@Override
	public List<MyPageDTO> getMyPageById(String id) throws DAOException {
		// TODO Auto-generated method stub
		List<MyPageDTO> myPageDTOs = new ArrayList<MyPageDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_MYPAGE_BY_ID_SQL);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				MyPageDTO myPageDTO = new MyPageDTO();
				myPageDTO.setMyPageTitle(rs.getString("MYPAGE_TITLE"));
				myPageDTO.setImg(rs.getString("IMG"));
				myPageDTO.setMyPageIntroduction(rs.getString("MYPAGE_INTRODUCTION"));
				myPageDTO.setId(rs.getString("ID"));
				
				myPageDTOs.add(myPageDTO);
			}
		}
		catch(SQLException e){
			throw new DAOException("Error : "+e.getMessage());
		}
		finally{
			closeDBObjects(rs, pstmt, conn);
		}
		return myPageDTOs;
	}
	@Override
	public void updateMyPageIntro(String introduction, String title)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(UPDATE_MYPAGE_INTRO_SQL);
			pstmt.setString(1, introduction);
			pstmt.setString(2, title);
			
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
	public void updateMyPageImage(String image, String title)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(UPDATE_MYPAGE_IMG_SQL);
			pstmt.setString(1, image);
			pstmt.setString(2, title);
			
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
	public void deleteMyPage(String title) throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(DELETE_MYPAGE_SQL);
			pstmt.setString(1, title);
			
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
	public void insertMyPage(String title, String image,
			String introduction, String id) throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(INSERT_MYPAGE_SQL);
			pstmt.setString(1, title);
			pstmt.setString(2, image);
			pstmt.setString(3, introduction);
			pstmt.setString(4, id);
			pstmt.execute();
		}
		catch(SQLException e){
			throw new DAOException("Error : "+e.getMessage());
		}
		finally{
			closeDBObjects(null, pstmt, conn);
		}
	}
	
	public static void main(String[] args) {
		MyPageDependencyInjector injector = new MyPageDependencyInjector(DataSourceManager.getInstance().getDataSource());
		try{
			MyPageDAO myPageDAO = (MyPageDAO)injector.getObject(MyPageDAO.class);
			try{
				//====전체검색====
				System.out.println(myPageDAO.getMyPage());
				//====제목으로 검색====
				System.out.println(myPageDAO.getMyPageByTitle("mypage1"));
				//====id로 검색===
				System.out.println(myPageDAO.getMyPageById("id1"));
				
				//====소개글 수정====
				//myPageDAO.updateMyPageIntro("introduction1", "mypage1");
				
				//====추가====
				//myPageDAO.insertMyPage("mypage1_2", "img1_2", "introduction1_2", "id1");
				
				//====삭제====
				//myPageDAO.deleteMyPage("mypage1_2");
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}	
	
}