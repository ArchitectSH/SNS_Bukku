package dao;

import injector.MyPageDependencyInjector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import dto.*;


public class MyPageUserKindDAOImpl extends BaseDAO implements MyPageUserKindDAO {
	private static String GET_MYPAGE_USER_KIND_SQL = "SELECT * FROM mypage_user_kind_tb";
	private static String GET_MYPAGE_USER_KIND_BY_NUM_SQL = "SELECT * FROM mypage_user_kind_tb WHERE mypage_kind_no=?";
	private static String UPDATE_MYPAGE_USER_KIND_SQL = "UPDATE mypage_user_kind_tb SET mypage_user_kind=? WHERE mypage_kind_no=?";
	private static String DELETE_MYPAGE_USER_KIND_SQL = "DELETE FROM mypage_user_kind_tb WHERE mypage_kind_no=?";
	private static String INSERT_MYPAGE_USER_KIND_SQL = "INSERT INTO mypage_user_kind_tb VALUES(?,?)";

	@Override
	public List<MyPageUserKindDTO> getMyPageUserKind() throws DAOException {
		// TODO Auto-generated method stub
		List<MyPageUserKindDTO> myPageUserKindDTOs = new ArrayList<MyPageUserKindDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_MYPAGE_USER_KIND_SQL);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				MyPageUserKindDTO myPageUserKindDTO = new MyPageUserKindDTO();
				myPageUserKindDTO.setMyPageKindNo(rs.getInt("MYPAGE_KIND_NO"));
				myPageUserKindDTO.setMyPageUserKind(rs.getString("MYPAGE_USER_KIND"));
				
				myPageUserKindDTOs.add(myPageUserKindDTO);
				
			}
		}
		catch(SQLException e){
			throw new DAOException("Error : "+e.getMessage());
		}
		finally{
			closeDBObjects(rs, pstmt, conn);
		}
		return myPageUserKindDTOs;
	}
	@Override
	public MyPageUserKindDTO getMyPageUserKindByNum(Integer kindNum)
			throws DAOException {
		// TODO Auto-generated method stub
		MyPageUserKindDTO myPageUserKindDTO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_MYPAGE_USER_KIND_BY_NUM_SQL);
			pstmt.setInt(1, kindNum);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				myPageUserKindDTO = new MyPageUserKindDTO();
				myPageUserKindDTO.setMyPageKindNo(rs.getInt("MYPAGE_KIND_NO"));
				myPageUserKindDTO.setMyPageUserKind(rs.getString("MYPAGE_USER_KIND"));
			}
		}
		catch(SQLException e){
			throw new DAOException("Error : "+e.getMessage());
		}
		finally{
			closeDBObjects(rs, pstmt, conn);
		}
		return myPageUserKindDTO;
	}
	@Override
	public void updateMyPageUserKind(String kind, Integer kindNum)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(UPDATE_MYPAGE_USER_KIND_SQL);
			pstmt.setString(1, kind);
			pstmt.setInt(2, kindNum);
			
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
	public void deleteMyPageUserKind(Integer kindNum) throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(DELETE_MYPAGE_USER_KIND_SQL);
			pstmt.setInt(1, kindNum);
			
			pstmt.execute();
		}
		catch(SQLException e){
			throw new DAOException("Error : "+e.getMessage());
		}
	}
	@Override
	public void insertMyPage(Integer kindNum, String kind) throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(INSERT_MYPAGE_USER_KIND_SQL);
			pstmt.setInt(1, kindNum);
			pstmt.setString(2, kind);
			
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
			MyPageUserKindDAO myPageUserKindDAO = (MyPageUserKindDAO)injector.getObject(MyPageUserKindDAO.class);
			try{
				//====전체검색====
				System.out.println(myPageUserKindDAO.getMyPageUserKind());
				//====번호로 검색====
				System.out.println(myPageUserKindDAO.getMyPageUserKindByNum(1));
			
				//추가, 삭제
				//myPageUserKindDAO.insertMyPage(3, "시범용");
				//myPageUserKindDAO.deleteMyPageUserKind(3);
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
