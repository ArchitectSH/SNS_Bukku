package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.ReportedUserDTO;
import dto.ReportedUserDTO;


public class ReportedUserDAOImpl extends BaseDAO implements ReportedUserDAO {
	private final static String GET_REPORTED_USER_SQL = "SELECT * FROM reported_user_tb";
	private final static String GET_REPORTED_USER_BY_REPORTNUM_SQL = "SELECT * FROM reported_user_tb WHERE report_no =?";
	private final static String GET_REPORTED_USER_BY_POSTNUM_SQL = "SELECT * FROM reported_user_tb WHERE post_no =?";
	private final static String GET_REPORTED_USER_BY_ID_SQL = "SELECT * FROM reported_user_tb WHERE id=?";
	private final static String GET_REPORTED_USER_COUNT_SQL = "SELECT COUNT(*) FROM reported_user_tb WHERE post_no = ?";
	private final static String DELETE_REPORTED_USER_BY_POSTNUM_SQL = "DELETE reported_user_tb WHERE post_no =?";
	private final static String DELETE_REPORTED_USER_BY_REPORTNUM_SQL = "DELETE reported_user_tb WHERE report_no =?";
	private final static String DELETE_REPORTED_USER_BY_ID_SQL = "DELETE reported_user_tb WHERE id =?";
	private final static String DELETE_REPORTED_USER_BY_ID_POSTNUM_SQL = "DELETE reported_user_tb WHERE post_no = ? AND id =?";
	private final static String INSERT_REPORTED_USER_SQL = "INSERT INTO reported_user_tb VALUES(reported_user_seq.NEXTVAL,?,?)";
	@Override
	public List<ReportedUserDTO> getReportedUser() throws DAOException {
		// TODO Auto-generated method stub
		List<ReportedUserDTO> reportedUserDTOs = new ArrayList<ReportedUserDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_REPORTED_USER_SQL  );
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				ReportedUserDTO reportedUserDTO = new ReportedUserDTO();
				reportedUserDTO.setReportNo(resultSet.getInt("report_no"));
				reportedUserDTO.setPostNo(resultSet.getInt("post_no"));
				reportedUserDTO.setId(resultSet.getString("id"));
				reportedUserDTOs.add(reportedUserDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting ReportedUserDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return reportedUserDTOs;
	}
	@Override
	public ReportedUserDTO getReportedUserByReportNum(Integer reportNum)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		ReportedUserDTO reportedUserDTO=null;
		try{
			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_REPORTED_USER_BY_REPORTNUM_SQL  );
			pStatement.setInt(1,reportNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				reportedUserDTO = new ReportedUserDTO();
				reportedUserDTO.setReportNo(resultSet.getInt("report_no"));
				reportedUserDTO.setPostNo(resultSet.getInt("post_no"));
				reportedUserDTO.setId(resultSet.getString("id"));
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting reportedUserDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return reportedUserDTO;
	}
	@Override
	public List<ReportedUserDTO> getReportedUserByPostNum(Integer postNum)
			throws DAOException {
		// TODO Auto-generated method stub
		List<ReportedUserDTO> reportedUserDTOs = new ArrayList<ReportedUserDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_REPORTED_USER_BY_POSTNUM_SQL  );
			pStatement.setInt(1,postNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				ReportedUserDTO reportedUserDTO = new ReportedUserDTO();
				reportedUserDTO.setReportNo(resultSet.getInt("report_no"));
				reportedUserDTO.setPostNo(resultSet.getInt("post_no"));
				reportedUserDTO.setId(resultSet.getString("id"));
				reportedUserDTOs.add(reportedUserDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting ReportedUserDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return reportedUserDTOs;
	}
	@Override
	public List<ReportedUserDTO> getReportedUserByID(String id)
			throws DAOException {
		// TODO Auto-generated method stub
		List<ReportedUserDTO> reportedUserDTOs = new ArrayList<ReportedUserDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_REPORTED_USER_BY_ID_SQL  );
			pStatement.setString(1,id);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				ReportedUserDTO reportedUserDTO = new ReportedUserDTO();
				reportedUserDTO.setReportNo(resultSet.getInt("report_no"));
				reportedUserDTO.setPostNo(resultSet.getInt("post_no"));
				reportedUserDTO.setId(resultSet.getString("id"));
				reportedUserDTOs.add(reportedUserDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting ReportedUserDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return reportedUserDTOs;
	}
	@Override
	public Integer getReportedUserCount(Integer postNum) throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		int num = 0;
		try{
			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_REPORTED_USER_COUNT_SQL  );
			pStatement.setInt(1,postNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				
				num=resultSet.getInt("COUNT(*)");
			
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting reportedUserDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return num;
	}
	@Override
	public void deleteReportedUserByPostNum(Integer postNum)
			throws DAOException {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_REPORTED_USER_BY_POSTNUM_SQL  );
			pStatement.setInt(1, postNum);
			pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error deleting reportedUserDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}	
	}
	@Override
	public void deleteReportedUserByReportNum(Integer reportNum)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_REPORTED_USER_BY_REPORTNUM_SQL  );
			pStatement.setInt(1, reportNum);
			pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error deleting reportedUserDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}	
	}
	@Override
	public void deleteReportedUserByID(String id) throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_REPORTED_USER_BY_ID_SQL  );
			pStatement.setString(1, id);
			pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error deleting reportedUserDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}	
	}
	@Override
	public void deleteReportedUserByIdPostNum(String id, Integer postNum)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_REPORTED_USER_BY_ID_POSTNUM_SQL  );
			pStatement.setString(1, id);
			pStatement.setInt(2, postNum);
			pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error deleting reportedUserDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}	
	}
	@Override
	public void insertReportedUser(Integer postNum, String id)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(INSERT_REPORTED_USER_SQL  );
			pStatement.setInt(1, postNum);
			pStatement.setString(2,id);
		   pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error inserting reportedUserDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}
	}
	/*public static void main(String[] args) {
	      // TODO Auto-generated method stub
	      DependencyInjector injector = new DependencyInjector();
	      try{
	         injector.start();
	         ReportedUserDAO reportedUserDAO = (ReportedUserDAO)injector.getObject(ReportedUserDAO.class);
	         
	         try{
	            
	    /*        System.out.println("=============================");
	            reportedUserDAO.insertReportedUser(18, "id3");
	            reportedUserDAO.insertReportedUser(18, "id4");
	            reportedUserDAO.insertReportedUser(19, "id4");
	            reportedUserDAO.insertReportedUser(20, "id1");
	            System.out.println(reportedUserDAO.getReportedUser());
	            System.out.println("=============================");
	            System.out.println(reportedUserDAO.getReportedUserByReportNum(1));
	            System.out.println("=============================");
	            System.out.println(reportedUserDAO.getReportedUserByID("id3"));
	            System.out.println("=============================");
	            System.out.println(reportedUserDAO.getReportedUserByPostNum(20));
	            System.out.println("=============================");
	            System.out.println(reportedUserDAO.getReportedUserCount(18));
	            System.out.println("=============================");
	           
	            System.out.println("=============================");
	           reportedUserDAO.deleteReportedUserByReportNum(1);
	            System.out.println("=============================");
	         /*  reportedUserDAO.deleteReportedUserByID("id1");
	            System.out.println("=============================");
	           reportedUserDAO.deleteReportedUserByIdPostNum("id4", 19);
	            System.out.println("=============================");
	            reportedUserDAO.deleteReportedUserByPostNum(19);
	            System.out.println(reportedUserDAO.getReportedUser());
	            
	            //productDAO.insert(product);
	         }catch(Exception e){
	            e.printStackTrace();
	         }
	      }finally{
	         injector.shutDown();
	      }

	   }*/
}