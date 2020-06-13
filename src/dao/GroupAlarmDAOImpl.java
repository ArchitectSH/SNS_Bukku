package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.GroupAlarmDTO;


public class GroupAlarmDAOImpl extends BaseDAO implements GroupAlarmDAO {
	private final static String GET_GROUPALARM_SQL = "SELECT * FROM group_alarm_tb";
	private final static String GET_GROUPALARM_BY_DATE_SQL = "SELECT * FROM group_alarm_tb WHERE alarm_no IN (SELECT alarm_no FROM alarm_tb WHERE activity_date >= TO_DATE(?,'YYYYMMDDHH24MISS') AND activity_date <= TO_DATE(?,'YYYYMMDDHH24MISS'))";
	private final static String GET_GROUPALARM_BY_SINCE_DATE_SQL = "SELECT * FROM group_alarm_tb WHERE alarm_no IN (SELECT alarm_no FROM alarm_tb WHERE activity_date >= TO_DATE(?,'YYYYMMDDHH24MISS') AND activity_date <= sysdate)";
	private final static String GET_GROUPALARM_BY_SINCE_DAY_SQL = "SELECT * FROM group_alarm_tb WHERE alarm_no IN (SELECT alarm_no FROM alarm_tb WHERE activity_date >= sysdate-? AND activity_date <= sysdate)";
	private final static String GET_GROUPALARM_BY_ALARMNUM_SQL = "SELECT * FROM group_alarm_tb WHERE alarm_no = ?";
	private final static String GET_GROUPALARM_BY_GROUPNUM_SQL = "SELECT * FROM group_alarm_tb WHERE group_no = ?";
	private final static String DELETE_GROUPALARM_BY_ALARMNUM_SQL = "DELETE group_alarm_tb WHERE alarm_no =?";
	private final static String DELETE_GROUPALARM_BY_GROUPNUM_SQL = "DELETE group_alarm_tb WHERE group_no =?";
	private final static String INSERT_GROUPALARM_SQL = "INSERT INTO group_alarm_tb VALUES(?,?)";
	@Override
	public List<GroupAlarmDTO> getGroupAlarm() throws DAOException {
		// TODO Auto-generated method stub
		List<GroupAlarmDTO> groupAlarmDTOs = new ArrayList<GroupAlarmDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_GROUPALARM_SQL );
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				GroupAlarmDTO groupAlarmDTO = new GroupAlarmDTO();
				groupAlarmDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				groupAlarmDTO.setGroupNo(resultSet.getInt("group_no"));
				groupAlarmDTOs.add(groupAlarmDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting GroupAlarmDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return groupAlarmDTOs;

	}
	@Override
	public List<GroupAlarmDTO> getGroupAlarmByDate(String startDate,
			String lastDate) throws DAOException {
		// TODO Auto-generated method stub

		List<GroupAlarmDTO> groupAlarmDTOs = new ArrayList<GroupAlarmDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			
			pStatement = connection.prepareStatement(GET_GROUPALARM_BY_DATE_SQL );
			pStatement.setString(1,startDate);
			
			pStatement.setString(2,lastDate);
		
			
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()){
				GroupAlarmDTO groupAlarmDTO = new GroupAlarmDTO();
				groupAlarmDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				
				groupAlarmDTO.setGroupNo(resultSet.getInt("group_no"));
		
				groupAlarmDTOs.add(groupAlarmDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting GroupAlarmDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return groupAlarmDTOs;
	}
	@Override
	public List<GroupAlarmDTO> getGroupAlarmBySinceDate(String beforeDate)
			throws DAOException {
		// TODO Auto-generated method stub

		List<GroupAlarmDTO> groupAlarmDTOs = new ArrayList<GroupAlarmDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_GROUPALARM_BY_SINCE_DATE_SQL );
			pStatement.setString(1,beforeDate);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				GroupAlarmDTO groupAlarmDTO = new GroupAlarmDTO();
				groupAlarmDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				groupAlarmDTO.setGroupNo(resultSet.getInt("group_no"));
				groupAlarmDTOs.add(groupAlarmDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting GroupAlarmDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return groupAlarmDTOs;
	}
	@Override
	public List<GroupAlarmDTO> getGroupAlarmBySinceDay(Integer beforeDay)
			throws DAOException {
		// TODO Auto-generated method stub

		List<GroupAlarmDTO> groupAlarmDTOs = new ArrayList<GroupAlarmDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_GROUPALARM_BY_SINCE_DAY_SQL );
			pStatement.setInt(1,beforeDay);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				GroupAlarmDTO groupAlarmDTO = new GroupAlarmDTO();
				groupAlarmDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				groupAlarmDTO.setGroupNo(resultSet.getInt("group_no"));
				groupAlarmDTOs.add(groupAlarmDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting GroupAlarmDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return groupAlarmDTOs;
	}
	@Override
	public GroupAlarmDTO getGroupAlarmByAlarmNum(Integer alarmNum)
			throws DAOException {
		// TODO Auto-generated method stub

		GroupAlarmDTO groupAlarmDTO = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_GROUPALARM_BY_ALARMNUM_SQL);
			pStatement.setInt(1,alarmNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				groupAlarmDTO = new GroupAlarmDTO();
				groupAlarmDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				groupAlarmDTO.setGroupNo(resultSet.getInt("group_no"));
		
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting GroupAlarmDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return groupAlarmDTO;
	}
	@Override
	public List<GroupAlarmDTO> getGroupAlarmByGroupNum(Integer groupNum)
			throws DAOException {
		// TODO Auto-generated method stub

		List<GroupAlarmDTO> groupAlarmDTOs = new ArrayList<GroupAlarmDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_GROUPALARM_BY_GROUPNUM_SQL );
			pStatement.setInt(1,groupNum);
			System.out.println("!!");
			resultSet = pStatement.executeQuery();
		
			while(resultSet.next()){
				GroupAlarmDTO groupAlarmDTO = new GroupAlarmDTO();
				
				groupAlarmDTO.setAlarmNo(resultSet.getInt("alarm_no"));
				groupAlarmDTO.setGroupNo(resultSet.getInt("group_no"));
			
				groupAlarmDTOs.add(groupAlarmDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting GroupAlarmDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return groupAlarmDTOs;
	}
	@Override
	public void deleteGroupAlarmByAlarmNum(Integer alarmNum)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_GROUPALARM_BY_ALARMNUM_SQL );
			pStatement.setInt(1, alarmNum);
			pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error deleting groupAlarmDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}	
	}
	@Override
	public void deleteGroupAlarmByGroupNum(Integer groupNum)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_GROUPALARM_BY_GROUPNUM_SQL );
			pStatement.setInt(1, groupNum);
			pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error deleting groupAlarmDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}	
	}
	@Override
	public void insertGroupAlarm(Integer alarmNum, Integer groupNum)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(INSERT_GROUPALARM_SQL );
			pStatement.setInt(1, alarmNum);
			pStatement.setInt(2,groupNum);
		   pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error inserting groupAlarmDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}

	}
	/*public static void main(String[] args) {
	      // TODO Auto-generated method stub
	      DependencyInjector injector = new DependencyInjector();
	      try{
	         injector.start();
	         GroupAlarmDAO groupAlarmDAO = (GroupAlarmDAO)injector.getObject(GroupAlarmDAO.class);
	         
	         try{
	           /* System.out.println(groupAlarmDAO.getGroupAlarm());
	            System.out.println("=============================");
	          /*  groupAlarmDAO.insertGroupAlarm(7, 1);
	            groupAlarmDAO.insertGroupAlarm(8, 1);
	            groupAlarmDAO.insertGroupAlarm(9, 2);*/
	    /*        System.out.println("=============================");
	            System.out.println(groupAlarmDAO.getGroupAlarmByAlarmNum(8));
	            System.out.println("=============================");
	            System.out.println(groupAlarmDAO.getGroupAlarmByDate("20150124000000", "20150124195600"));
	            System.out.println("=============================");
	            System.out.println(groupAlarmDAO.getGroupAlarmByGroupNum(7));
	            System.out.println("=============================");
	            System.out.println(groupAlarmDAO.getGroupAlarmBySinceDate("201501240000"));
	            System.out.println("=============================");
	            System.out.println(groupAlarmDAO.getGroupAlarmBySinceDay(3));
	            System.out.println("=============================");
	            System.out.println(groupAlarmDAO.getGroupAlarm());
	            System.out.println("=============================");
	            
	            groupAlarmDAO.deleteGroupAlarmByAlarmNum(7);
	            System.out.println("=============================");
	            System.out.println("=============================");
	           groupAlarmDAO.deleteGroupAlarmByGroupNum(2);
	            System.out.println("=============================");
	            System.out.println(groupAlarmDAO.getGroupAlarm());
	       
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