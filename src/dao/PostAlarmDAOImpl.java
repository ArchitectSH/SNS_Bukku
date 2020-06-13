package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.PostAlarmDTO;



public class PostAlarmDAOImpl extends BaseDAO implements PostAlarmDAO {
	private final static String GET_POSTALARM_SQL = "SELECT * FROM post_alarm_tb";
	private final static String GET_POSTALARM_BY_ACTDATE_SQL = "SELECT * FROM post_alarm_tb WHERE alarm_no IN (SELECT alarm_no FROM alarm_tb WHERE activity_date >= TO_DATE(?,'YYYYMMDDHH24MISS') AND activity_date <= TO_DATE(?,'YYYYMMDDHH24MISS'))";
	private final static String GET_POSTALARM_BY_SINCE_DATE_SQL = "SELECT * FROM post_alarm_tb WHERE alarm_no IN (SELECT alarm_no FROM alarm_tb WHERE activity_date >= TO_DATE(?,'YYYYMMDDHH24MISS') AND activity_date <= sysdate)";
	private final static String GET_POSTALARM_BY_SINCE_DAY_SQL = "SELECT * FROM post_alarm_tb WHERE alarm_no IN (SELECT alarm_no FROM alarm_tb WHERE activity_date >= sysdate-? AND activity_date <= sysdate)";
	private final static String GET_POSTALARM_BY_ALARMNUM_SQL = "SELECT * FROM post_alarm_tb WHERE alarm_no = ?";
	private final static String GET_POSTALARM_BY_POSTNUM_SQL = "SELECT * FROM post_alarm_tb WHERE post_no = ?";
	private final static String DELETE_POSTALARM_BY_ALARMNUM_SQL = "DELETE post_alarm_tb WHERE alarm_no = ?";
	private final static String DELETE_POSTALARM_BY_POSTNUM_SQL = "DELETE post_alarm_tb WHERE post_no =?";
	private final static String INSERT_POSTALARM_SQL = "INSERT INTO post_alarm_tb VALUES(?,?)";
	@Override
	public List<PostAlarmDTO> getPostAlarm() throws DAOException {
		// TODO Auto-generated method stub

		List<PostAlarmDTO> postAlarmDTOs = new ArrayList<PostAlarmDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_POSTALARM_SQL );
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				PostAlarmDTO postAlarmDTO = new PostAlarmDTO();
				postAlarmDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				postAlarmDTO.setPostNo(resultSet.getInt("post_no"));
				postAlarmDTOs.add(postAlarmDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting PostAlarmDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return postAlarmDTOs;
	}
	@Override
	public List<PostAlarmDTO> getPostAlarmByDate(String startDate,
			String lastDate) throws DAOException {
		// TODO Auto-generated method stub

		List<PostAlarmDTO> postAlarmDTOs = new ArrayList<PostAlarmDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_POSTALARM_BY_ACTDATE_SQL );
			pStatement.setString(1,startDate);
			pStatement.setString(2,lastDate);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				PostAlarmDTO postAlarmDTO = new PostAlarmDTO();
				postAlarmDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				postAlarmDTO.setPostNo(resultSet.getInt("post_no"));
				postAlarmDTOs.add(postAlarmDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting PostAlarmDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return postAlarmDTOs;
	}
	@Override
	public List<PostAlarmDTO> getPostAlarmBySinceDate(String beforeDate)
			throws DAOException {
		// TODO Auto-generated method stub

		List<PostAlarmDTO> postAlarmDTOs = new ArrayList<PostAlarmDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_POSTALARM_BY_SINCE_DATE_SQL );
			pStatement.setString(1,beforeDate);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				PostAlarmDTO postAlarmDTO = new PostAlarmDTO();
				postAlarmDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				postAlarmDTO.setPostNo(resultSet.getInt("post_no"));
				postAlarmDTOs.add(postAlarmDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting PostAlarmDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return postAlarmDTOs;
	}
	@Override
	public List<PostAlarmDTO> getPostAlarmBySinceDay(Integer beforeDay)
			throws DAOException {
		// TODO Auto-generated method stub

		List<PostAlarmDTO> postAlarmDTOs = new ArrayList<PostAlarmDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_POSTALARM_BY_SINCE_DAY_SQL );
			pStatement.setInt(1,beforeDay);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				PostAlarmDTO postAlarmDTO = new PostAlarmDTO();
				postAlarmDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				postAlarmDTO.setPostNo(resultSet.getInt("post_no"));
				postAlarmDTOs.add(postAlarmDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting PostAlarmDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return postAlarmDTOs;
	}
	@Override
	public PostAlarmDTO getPostAlarmByAlarmNum(Integer alarmNum)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		PostAlarmDTO postAlarmDTO=null;
		try{
			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_POSTALARM_BY_ALARMNUM_SQL );
			pStatement.setInt(1,alarmNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				postAlarmDTO = new PostAlarmDTO();
				postAlarmDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				postAlarmDTO.setPostNo(resultSet.getInt("post_no"));
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting postAlarmDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return postAlarmDTO;

	}
	@Override
	public List<PostAlarmDTO> getPostAlarmByPostNum(Integer postNum)
			throws DAOException {
		// TODO Auto-generated method stub

		List<PostAlarmDTO> postAlarmDTOs = new ArrayList<PostAlarmDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_POSTALARM_BY_POSTNUM_SQL );
			pStatement.setInt(1,postNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				PostAlarmDTO postAlarmDTO = new PostAlarmDTO();
				postAlarmDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				postAlarmDTO.setPostNo(resultSet.getInt("post_no"));
				postAlarmDTOs.add(postAlarmDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting PostAlarmDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return postAlarmDTOs;
	}
	@Override
	public void deletePostAlarmByAlarmNum(Integer alarmNum) throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_POSTALARM_BY_ALARMNUM_SQL );
			pStatement.setInt(1, alarmNum);
			pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error deleting postAlarmDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}	
	}
	@Override
	public void deletePostAlarmByPostNum(Integer postNum) throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_POSTALARM_BY_POSTNUM_SQL );
			pStatement.setInt(1, postNum);
			pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error deleting postAlarmDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}	
	}
	@Override
	public void insertPostAlarm(Integer alarmNum, Integer postNum)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(INSERT_POSTALARM_SQL);
			pStatement.setInt(1, alarmNum);
			pStatement.setInt(2, postNum);
		   pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error inserting postAlarmDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}

	}
	
	/*public static void main(String[] args) {
	      // TODO Auto-generated method stub
	      DependencyInjector injector = new DependencyInjector();
	      try{
	         injector.start();
	         PostAlarmDAO postAlarmDAO = (PostAlarmDAO)injector.getObject(PostAlarmDAO.class);
	         
	         try{
	           /* System.out.println(PostAlarmDAO.getGroupAlarm());
	            System.out.println("=============================");
	     /*       postAlarmDAO.insertPostAlarm(2,12);
	            postAlarmDAO.insertPostAlarm(3,13);
	            postAlarmDAO.insertPostAlarm(4,14);
	            System.out.println("=============================");
	            System.out.println(postAlarmDAO.getPostAlarmByAlarmNum(3));
	            System.out.println("=============================");
	            System.out.println(postAlarmDAO.getPostAlarmByDate("20150124000000", "20150124195600"));
	            System.out.println("=============================");
	            System.out.println(postAlarmDAO.getPostAlarmByPostNum(13));
	            System.out.println("=============================");
	            System.out.println(postAlarmDAO.getPostAlarmBySinceDate("20150124000000"));
	            System.out.println("=============================");
	            System.out.println(postAlarmDAO.getPostAlarmBySinceDay(3));
	            System.out.println("=============================");
	            System.out.println(postAlarmDAO.getPostAlarm());
	            System.out.println("=============================");
	            
	            postAlarmDAO.deletePostAlarmByAlarmNum(3);
	            System.out.println("=============================");
	            System.out.println("=============================");
	            postAlarmDAO.deletePostAlarmByPostNum(14);
	            System.out.println("=============================");
	            System.out.println(postAlarmDAO.getPostAlarm());
	       
	            System.out.println("=============================");
	            
	            
	            //productDAO.insert(product);
	         }catch(Exception e){
	            e.printStackTrace();
	         }
	      }finally{
	         injector.shutDown();
	      }

	   }*/
}