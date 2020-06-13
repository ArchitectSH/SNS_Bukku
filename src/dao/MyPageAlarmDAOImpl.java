package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.MyPageAlarmDTO;

public class MyPageAlarmDAOImpl extends BaseDAO implements MyPageAlarmDAO {
	private final static String GET_MYPAGEALARM_SQL = "SELECT * FROM mypage_alarm_tb";
	private final static String GET_MYPAGEALARM_BY_DATE_SQL = "SELECT * FROM mypage_alarm_tb WHERE alarm_no IN (SELECT alarm_no FROM alarm_tb WHERE activity_date >= TO_DATE(?,'YYYYMMDDHH24MISS') AND activity_date <= TO_DATE(?,'YYYYMMDDHH24MISS'))";
	private final static String GET_MYPAGEALARM_BY_SINCE_DATE_SQL = "SELECT * FROM mypage_alarm_tb WHERE alarm_no IN (SELECT alarm_no FROM alarm_tb WHERE activity_date >= TO_DATE(?,'YYYYMMDDHH24MISS') AND activity_date <= sysdate)";
	private final static String GET_MYPAGEALARM_BY_SINCE_DAY_SQL = "SELECT * FROM mypage_alarm_tb WHERE alarm_no IN (SELECT alarm_no FROM alarm_tb WHERE activity_date >= sysdate-? AND activity_date <= sysdate)";
	private final static String GET_MYPAGEALARM_BY_TITLE_SQL = "SELECT * FROM mypage_alarm_tb WHERE mypage_title = ?";
	private final static String GET_MYPAGEALARM_BY_ALARMNUM_SQL = "SELECT * FROM mypage_alarm_tb WHERE alarm_no = ?";
	private final static String DELETE_MYPAGEALARM_SQL = "DELETE mypage_alarm_tb WHERE alarm_no =?";
	private final static String DELETE_MYPAGEALARM_BY_TITLE_SQL = "DELETE mypage_alarm_tb WHERE mypage_title =?";
	private final static String INSERT_MYPAGEALARM_SQL = "INSERT INTO mypage_alarm_tb VALUES(?,?)";
	@Override
	public List<MyPageAlarmDTO> getMyPageAlarm() throws DAOException {
		// TODO Auto-generated method stub

		List<MyPageAlarmDTO> myPageAlarmDTOs = new ArrayList<MyPageAlarmDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_MYPAGEALARM_SQL );
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				MyPageAlarmDTO myPageAlarmDTO = new MyPageAlarmDTO();
				myPageAlarmDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				myPageAlarmDTO.setMyPageTitle(resultSet.getString("mypage_title"));
				myPageAlarmDTOs.add(myPageAlarmDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting MyPageAlarmDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return myPageAlarmDTOs;
	}
	@Override
	public List<MyPageAlarmDTO> getMyPageAlarmByDate(String startDate,
			String lastDate) throws DAOException {
		// TODO Auto-generated method stub


		List<MyPageAlarmDTO> myPageAlarmDTOs = new ArrayList<MyPageAlarmDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_MYPAGEALARM_BY_DATE_SQL );
			pStatement.setString(1,startDate);
			pStatement.setString(2,lastDate);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				MyPageAlarmDTO myPageAlarmDTO = new MyPageAlarmDTO();
				myPageAlarmDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				myPageAlarmDTO.setMyPageTitle(resultSet.getString("mypage_title"));
				myPageAlarmDTOs.add(myPageAlarmDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting MyPageAlarmDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return myPageAlarmDTOs;
	}
	@Override
	public List<MyPageAlarmDTO> getMyPageAlarmBySinceDate(String beforeDate)
			throws DAOException {
		// TODO Auto-generated method stub


		List<MyPageAlarmDTO> myPageAlarmDTOs = new ArrayList<MyPageAlarmDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_MYPAGEALARM_BY_SINCE_DATE_SQL );
			pStatement.setString(1,beforeDate);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				MyPageAlarmDTO myPageAlarmDTO = new MyPageAlarmDTO();
				myPageAlarmDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				myPageAlarmDTO.setMyPageTitle(resultSet.getString("mypage_title"));
				myPageAlarmDTOs.add(myPageAlarmDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting MyPageAlarmDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return myPageAlarmDTOs;
	}
	@Override
	public List<MyPageAlarmDTO> getMyPageAlarmBySinceDay(Integer beforeDay)
			throws DAOException {
		// TODO Auto-generated method stub


		List<MyPageAlarmDTO> myPageAlarmDTOs = new ArrayList<MyPageAlarmDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_MYPAGEALARM_BY_SINCE_DAY_SQL );
			pStatement.setInt(1,beforeDay);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				MyPageAlarmDTO myPageAlarmDTO = new MyPageAlarmDTO();
				myPageAlarmDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				myPageAlarmDTO.setMyPageTitle(resultSet.getString("mypage_title"));
				myPageAlarmDTOs.add(myPageAlarmDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting MyPageAlarmDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return myPageAlarmDTOs;
	}
	@Override
	public List<MyPageAlarmDTO> getMyPageAlarmByTitle(String myPageTitle)
			throws DAOException {
		// TODO Auto-generated method stub


		List<MyPageAlarmDTO> myPageAlarmDTOs = new ArrayList<MyPageAlarmDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_MYPAGEALARM_BY_TITLE_SQL );
			pStatement.setString(1,myPageTitle);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				MyPageAlarmDTO myPageAlarmDTO = new MyPageAlarmDTO();
				myPageAlarmDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				myPageAlarmDTO.setMyPageTitle(resultSet.getString("mypage_title"));
				myPageAlarmDTOs.add(myPageAlarmDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting MyPageAlarmDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return myPageAlarmDTOs;
	}
	@Override
	public MyPageAlarmDTO getMyPageAlarmByAlarmNum(Integer alarmNum)
			throws DAOException {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		MyPageAlarmDTO myPageAlarmDTO=null;
		try{
			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_MYPAGEALARM_BY_ALARMNUM_SQL );
			pStatement.setInt(1,alarmNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				myPageAlarmDTO = new MyPageAlarmDTO();
				myPageAlarmDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				myPageAlarmDTO.setMyPageTitle(resultSet.getString("mypage_title"));
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting myPageAlarmDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return myPageAlarmDTO;

	}
	@Override
	public void deleteMyPageAlarmByAlarmNum(Integer alarmNum)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_MYPAGEALARM_SQL );
			pStatement.setInt(1, alarmNum);
			pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error deleting myPageAlarmDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}	
	}
	@Override
	public void deleteMyPageAlarmByTitle(String myPageTitle)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_MYPAGEALARM_BY_TITLE_SQL );
			pStatement.setString(1, myPageTitle);
			pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error deleting myPageAlarmDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}	
	}
	@Override
	public void insertMyPageAlarm(Integer alarmNum, String myPageTitle)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(INSERT_MYPAGEALARM_SQL );
			pStatement.setInt(1, alarmNum);
			pStatement.setString(2,myPageTitle);
		   pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error inserting myPageAlarmDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}

	}
	/*public static void main(String[] args) {
	      // TODO Auto-generated method stub
	      DependencyInjector injector = new DependencyInjector();
	      try{
	         injector.start();
	        MyPageAlarmDAO myPageAlarmDAO = (MyPageAlarmDAO)injector.getObject(MyPageAlarmDAO.class);
	         
	         try{
	           /* System.out.println(myPageAlarmDAO.getMyPageAlarm());
	            System.out.println("=============================");
	           /*myPageAlarmDAO.insertMyPageAlarm(11, "mypage2");
	            myPageAlarmDAO.insertMyPageAlarm(10, "mypage1");*/
/*	           myPageAlarmDAO.insertMyPageAlarm(8, "mypage4");*/
	         /*   System.out.println("=============================");
	            System.out.println(myPageAlarmDAO.getMyPageAlarm());
	            System.out.println("=============================");
	            System.out.println(myPageAlarmDAO.getMyPageAlarmByAlarmNum(9));
	            System.out.println("=============================");
	            System.out.println(myPageAlarmDAO.getMyPageAlarmByDate("20150101", "20150125"));
	            System.out.println("=============================");
	            System.out.println(myPageAlarmDAO.getMyPageAlarmBySinceDate("20150124"));
	            System.out.println("=============================");
	            System.out.println(myPageAlarmDAO.getMyPageAlarmBySinceDay(3));
	            System.out.println("=============================");
	            System.out.println(myPageAlarmDAO.getMyPageAlarmByTitle("mypage4"));
	            System.out.println("=============================");
	            myPageAlarmDAO.deleteMyPageAlarmByTitle("mypage4");
	            System.out.println("=============================");
	            System.out.println(myPageAlarmDAO.getMyPageAlarm());
	            System.out.println("=============================");
	            myPageAlarmDAO.deleteMyPageAlarmByAlarmNum(11);
	            System.out.println("=============================");
	            System.out.println(myPageAlarmDAO.getMyPageAlarm());
	            System.out.println("=============================");
	         
	         
	         }catch(Exception e){
	            e.printStackTrace();
	         }
	      }finally{
	         injector.shutDown();
	      }

	   }*/
	
}