package dao;

import injector.MyPageDependencyInjector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.*;

public class MyPageInfoViewImpl extends BaseDAO implements MyPageInfoViewDAO {
	private static String GET_MYPAGEINFOVIEW_SQL = "SELECT * FROM page_info_view";
	private static String GET_MYPAGEINFOVIEW_BY_TITLE_SQL = "SELECT * FROM page_info_view WHERE mypage_title LIKE ?";
	private static String GET_MYPAGEINFOVIEW_BY_ID_SQL = "SELECT * FROM page_info_view WHERE master_id = ?";

	@Override
	public List<MyPageInfoViewDTO> getMyPageInfoView() throws DAOException {
		// TODO Auto-generated method stub
		List<MyPageInfoViewDTO> myPageInfoViewDTOs = new ArrayList<MyPageInfoViewDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_MYPAGEINFOVIEW_SQL);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				MyPageInfoViewDTO myPageInfoViewDTO = new MyPageInfoViewDTO();
				myPageInfoViewDTO.setMyPageTitle(rs.getString("MYPAGE_TITLE"));
				myPageInfoViewDTO.setMyPageImg(rs.getString("MYPAGE_IMG"));
				myPageInfoViewDTO.setMyPageIntroduction(rs.getString("MYPAGE_INTRODUCTION"));
				myPageInfoViewDTO.setMyPageFollower(rs.getInt("FOLLOWING_NUM"));
				myPageInfoViewDTO.setMasterId(rs.getString("MASTER_ID"));
				
				myPageInfoViewDTOs.add(myPageInfoViewDTO);
			}
			
		}
		catch(SQLException e){
			throw new DAOException("Error : "+e.getMessage());
		}
		finally{
			closeDBObjects(rs, pstmt, conn);
		}
		return myPageInfoViewDTOs;
	}
	@Override
	public List<MyPageInfoViewDTO> getMyPageInfoViewByTitle(String title)
			throws DAOException {
		// TODO Auto-generated method stub
		List<MyPageInfoViewDTO> myPageInfoViewDTOs = new ArrayList<MyPageInfoViewDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_MYPAGEINFOVIEW_BY_TITLE_SQL);
			pstmt.setString(1, "%"+title+"%");
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				MyPageInfoViewDTO myPageInfoViewDTO = new MyPageInfoViewDTO();
				myPageInfoViewDTO.setMyPageTitle(rs.getString("MYPAGE_TITLE"));
				myPageInfoViewDTO.setMyPageImg(rs.getString("MYPAGE_IMG"));
				myPageInfoViewDTO.setMyPageIntroduction(rs.getString("MYPAGE_INTRODUCTION"));
				myPageInfoViewDTO.setMyPageFollower(rs.getInt("FOLLOWING_NUM"));
				myPageInfoViewDTO.setMasterId(rs.getString("MASTER_ID"));
				
				myPageInfoViewDTOs.add(myPageInfoViewDTO);
			}
			
		}
		catch(SQLException e){
			throw new DAOException("Error : "+e.getMessage());
		}
		finally{
			closeDBObjects(rs, pstmt, conn);
		}
		return myPageInfoViewDTOs;
	}
	@Override
	public List<MyPageInfoViewDTO> getMyPageInfoViewById(String id)
			throws DAOException {
		// TODO Auto-generated method stub
		List<MyPageInfoViewDTO> myPageInfoViewDTOs = new ArrayList<MyPageInfoViewDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_MYPAGEINFOVIEW_BY_ID_SQL);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				MyPageInfoViewDTO myPageInfoViewDTO = new MyPageInfoViewDTO();
				myPageInfoViewDTO.setMyPageTitle(rs.getString("MYPAGE_TITLE"));
				myPageInfoViewDTO.setMyPageImg(rs.getString("MYPAGE_IMG"));
				myPageInfoViewDTO.setMyPageIntroduction(rs.getString("MYPAGE_INTRODUCTION"));
				myPageInfoViewDTO.setMyPageFollower(rs.getInt("FOLLOWING_NUM"));
				myPageInfoViewDTO.setMasterId(rs.getString("MASTER_ID"));
				
				myPageInfoViewDTOs.add(myPageInfoViewDTO);
			}
			
		}
		catch(SQLException e){
			throw new DAOException("Error : "+e.getMessage());
		}
		finally{
			closeDBObjects(rs, pstmt, conn);
		}
		return myPageInfoViewDTOs;
	}
	/*public static void main(String[] args) {
		MyPageDependencyInjector injector = new MyPageDependencyInjector();
		try{
			injector.start();
			MyPageInfoViewDAO myPageInfoViewDAO = (MyPageInfoViewDAO)injector.getObject(MyPageInfoViewDAO.class);
			try{
				//전체검색
				System.out.println(myPageInfoViewDAO.getMyPageInfoView());
				//마이페이지 타이틀 일부주고 찾기
				System.out.println(myPageInfoViewDAO.getMyPageInfoViewByTitle("my"));
				//아이디 주고 내가만든 마이페이지 찾기
				System.out.println(myPageInfoViewDAO.getMyPageInfoViewById("id1"));
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		finally{
			injector.shutDown();
		}
	}*/
}
