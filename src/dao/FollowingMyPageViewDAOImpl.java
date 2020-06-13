package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import dto.*;

public class FollowingMyPageViewDAOImpl extends BaseDAO implements FollowingMyPageViewDAO {
	private static String GET_FOLLOWINGMYPAGEVIEW_SQL = "SELECT * FROM following_page_view";
	private static String GET_FOLLOWINGMYPAGEVIEW_BY_ID_SQL = "SELECT * FROM following_page_view WHERE mypage_follower_id =?";
	private static String GET_FOLLOWINGMYPAGEVIEW_BY_TITLE_ID_SQL = "SELECT * FROM following_page_view WHERE mypage_follower_id = ? AND mypage_title LIKE ?";
	@Override
	public List<FollowingMyPageViewDTO> getFollowingMyPageView()
			throws DAOException {
		// TODO Auto-generated method stub
		List<FollowingMyPageViewDTO> followingMyPageViewDTOs = new ArrayList<FollowingMyPageViewDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_FOLLOWINGMYPAGEVIEW_SQL);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				FollowingMyPageViewDTO followingMyPageViewDTO = new FollowingMyPageViewDTO();
				followingMyPageViewDTO.setFollowerId(rs.getString("MYPAGE_FOLLOWER_ID"));
				followingMyPageViewDTO.setMyPageTitle(rs.getString("MYPAGE_TITLE"));
				followingMyPageViewDTO.setMyPageImg(rs.getString("MYPAGE_IMG"));
				followingMyPageViewDTO.setMasterId(rs.getString("MASTER_ID"));
				
				followingMyPageViewDTOs.add(followingMyPageViewDTO);
			}
			
		}
		catch(SQLException e){
			throw new DAOException("Error : "+e.getMessage());
		}
		finally{
			closeDBObjects(rs, pstmt, conn);
		}
		return followingMyPageViewDTOs;
	}
	@Override
	public List<FollowingMyPageViewDTO> getFollowingMyPageViewById(String id)
			throws DAOException {
		// TODO Auto-generated method stub
		List<FollowingMyPageViewDTO> followingMyPageViewDTOs = new ArrayList<FollowingMyPageViewDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_FOLLOWINGMYPAGEVIEW_BY_ID_SQL);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				FollowingMyPageViewDTO followingMyPageViewDTO = new FollowingMyPageViewDTO();
				followingMyPageViewDTO.setFollowerId(rs.getString("MYPAGE_FOLLOWER_ID"));
				followingMyPageViewDTO.setMyPageTitle(rs.getString("MYPAGE_TITLE"));
				followingMyPageViewDTO.setMyPageImg(rs.getString("MYPAGE_IMG"));
				followingMyPageViewDTO.setMasterId(rs.getString("MASTER_ID"));
				
				followingMyPageViewDTOs.add(followingMyPageViewDTO);
			}
			
		}
		catch(SQLException e){
			throw new DAOException("Error : "+e.getMessage());
		}
		finally{
			closeDBObjects(rs, pstmt, conn);
		}
		return followingMyPageViewDTOs;
	}
	@Override
	public List<FollowingMyPageViewDTO> getFollowingMyPageViewByTitleId(
			String title, String id) throws DAOException {
		// TODO Auto-generated method stub
		List<FollowingMyPageViewDTO> followingMyPageViewDTOs = new ArrayList<FollowingMyPageViewDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_FOLLOWINGMYPAGEVIEW_BY_TITLE_ID_SQL);
			pstmt.setString(1, id);
			pstmt.setString(2, title);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				FollowingMyPageViewDTO followingMyPageViewDTO = new FollowingMyPageViewDTO();
				followingMyPageViewDTO.setFollowerId(rs.getString("MYPAGE_FOLLOWER_ID"));
				followingMyPageViewDTO.setMyPageTitle(rs.getString("MYPAGE_TITLE"));
				followingMyPageViewDTO.setMyPageImg(rs.getString("MYPAGE_IMG"));
				followingMyPageViewDTO.setMasterId(rs.getString("MASTER_ID"));
				
				followingMyPageViewDTOs.add(followingMyPageViewDTO);
			}
			
		}
		catch(SQLException e){
			throw new DAOException("Error : "+e.getMessage());
		}
		finally{
			closeDBObjects(rs, pstmt, conn);
		}
		return followingMyPageViewDTOs;
	}
	
	/*public static void main(String[] args) {
		MyPageDependancyInjector injector = new MyPageDependancyInjector();
		try{
			injector.start();
			FollowingMyPageViewDAO followingMyPageViewDAO = (FollowingMyPageViewDAO)injector.getObject(FollowingMyPageViewDAO.class);
			try{
				//전체검색
				System.out.println(followingMyPageViewDAO.getFollowingMyPageView());
				//id주고 사용자가 팔로잉하는 마이페이지 찾기
				System.out.println(followingMyPageViewDAO.getFollowingMyPageViewById("id3"));
				//아이디 주고 내가팔로잉하는 마이페이지 이름(일부)주고 검색
				System.out.println(followingMyPageViewDAO.getFollowingMyPageViewByTitleId("mypage1","id3"));
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
