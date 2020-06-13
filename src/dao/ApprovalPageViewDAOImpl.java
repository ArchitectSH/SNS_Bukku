package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ApprovalPageViewDTO;

public class ApprovalPageViewDAOImpl extends BaseDAO implements ApprovalPageViewDAO {
	private static String GET_APPROVALPAGEVIEW_SQL = "SELECT * FROM approval_page_view";
	private static String GET_APPROVALPAGEVIEW_BY_TITLE_SQL = "SELECT * FROM approval_page_view WHERE mypage_title =?";
	private static String GET_APPROVALPAGEVIEW_BY_ID_SQL = "SELECT * FROM approval_page_view WHERE invited_id=?";
	private static String GET_APPROVALPAGEVIEW_BY_TITLE_ID_SQL = "SELECT * FROM approval_page_view WHERE invited_id=? AND mypage_title LIKE ?";
	@Override
	public List<ApprovalPageViewDTO> getApprovalPageView() throws DAOException {
		// TODO Auto-generated method stub
		List<ApprovalPageViewDTO> approvalPageViewDTOs = new ArrayList<ApprovalPageViewDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_APPROVALPAGEVIEW_SQL);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				ApprovalPageViewDTO approvalPageViewDTO = new ApprovalPageViewDTO();
				approvalPageViewDTO.setInvitedId(rs.getString("INVITED_ID"));
				approvalPageViewDTO.setMyPageTitle(rs.getString("MYPAGE_TITLE"));
				approvalPageViewDTO.setMyPageImg(rs.getString("MYPAGE_IMG"));
				approvalPageViewDTO.setMasterId(rs.getString("MASTER_ID"));
				
				approvalPageViewDTOs.add(approvalPageViewDTO);
			}
			
		}
		catch(SQLException e){
			throw new DAOException("Error : "+e.getMessage());
		}
		finally{
			closeDBObjects(rs, pstmt, conn);
		}
		return approvalPageViewDTOs;
	}
	@Override
	public List<ApprovalPageViewDTO> getApprovalPageViewByTitle(String title)
			throws DAOException {
		// TODO Auto-generated method stub
		List<ApprovalPageViewDTO> approvalPageViewDTOs = new ArrayList<ApprovalPageViewDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_APPROVALPAGEVIEW_BY_TITLE_SQL);
			pstmt.setString(1, title);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				ApprovalPageViewDTO approvalPageViewDTO = new ApprovalPageViewDTO();
				approvalPageViewDTO.setInvitedId(rs.getString("INVITED_ID"));
				approvalPageViewDTO.setMyPageTitle(rs.getString("MYPAGE_TITLE"));
				approvalPageViewDTO.setMyPageImg(rs.getString("MYPAGE_IMG"));
				approvalPageViewDTO.setMasterId(rs.getString("MASTER_ID"));
				
				approvalPageViewDTOs.add(approvalPageViewDTO);
			}
			
		}
		catch(SQLException e){
			throw new DAOException("Error : "+e.getMessage());
		}
		finally{
			closeDBObjects(rs, pstmt, conn);
		}
		return approvalPageViewDTOs;
	}
	@Override
	public List<ApprovalPageViewDTO> getApprovalPageViewById(String id)
			throws DAOException {
		// TODO Auto-generated method stub
		List<ApprovalPageViewDTO> approvalPageViewDTOs = new ArrayList<ApprovalPageViewDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_APPROVALPAGEVIEW_BY_ID_SQL);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				ApprovalPageViewDTO approvalPageViewDTO = new ApprovalPageViewDTO();
				approvalPageViewDTO.setInvitedId(rs.getString("INVITED_ID"));
				approvalPageViewDTO.setMyPageTitle(rs.getString("MYPAGE_TITLE"));
				approvalPageViewDTO.setMyPageImg(rs.getString("MYPAGE_IMG"));
				approvalPageViewDTO.setMasterId(rs.getString("MASTER_ID"));
				
				approvalPageViewDTOs.add(approvalPageViewDTO);
			}
			
		}
		catch(SQLException e){
			throw new DAOException("Error : "+e.getMessage());
		}
		finally{
			closeDBObjects(rs, pstmt, conn);
		}
		return approvalPageViewDTOs;
	}
	@Override
	public List<ApprovalPageViewDTO> getApprovalPageViewByTitleId(String title,
			String id) throws DAOException {
		// TODO Auto-generated method stub
		List<ApprovalPageViewDTO> approvalPageViewDTOs = new ArrayList<ApprovalPageViewDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(GET_APPROVALPAGEVIEW_BY_TITLE_ID_SQL);
			pstmt.setString(1, id);
			pstmt.setString(2, "%"+title+"%");
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				ApprovalPageViewDTO approvalPageViewDTO = new ApprovalPageViewDTO();
				approvalPageViewDTO.setInvitedId(rs.getString("INVITED_ID"));
				approvalPageViewDTO.setMyPageTitle(rs.getString("MYPAGE_TITLE"));
				approvalPageViewDTO.setMyPageImg(rs.getString("MYPAGE_IMG"));
				approvalPageViewDTO.setMasterId(rs.getString("MASTER_ID"));
				
				approvalPageViewDTOs.add(approvalPageViewDTO);
			}
			
		}
		catch(SQLException e){
			throw new DAOException("Error : "+e.getMessage());
		}
		finally{
			closeDBObjects(rs, pstmt, conn);
		}
		return approvalPageViewDTOs;
	}
	/*public static void main(String[] args) {
		MyPageDependancyInjector injector = new MyPageDependancyInjector();
		try{
			injector.start();
			ApprovalPageViewDAO approvalPageViewDAO = (ApprovalPageViewDAO)injector.getObject(ApprovalPageViewDAO.class);
			try{
				//��ü�˻�
				System.out.println(approvalPageViewDAO.getApprovalPageView());
				//���������� Ÿ��Ʋ �Ϻ��ְ� ã��
				System.out.println(approvalPageViewDAO.getApprovalPageViewByTitle("mypage2"));
				//�ʴ�� ��� ���̵� �ְ� ã�� getApprovalPageViewById
				System.out.println(approvalPageViewDAO.getApprovalPageViewById("id8"));
				//�ʴ�� ��� ���̵�� ���� �Ϻ� �ְ� ã��
				System.out.println(approvalPageViewDAO.getApprovalPageViewByTitleId("my","id8"));
				
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
