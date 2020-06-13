package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.ActivityDTO;



public class ActivityDAOImpl extends BaseDAO implements ActivityDAO {
	private final static String GET_ACTIVITY_SQL = "SELECT * FROM activity_tb";
	private final static String GET_ACTIVITY_BY_NUM_SQL = "SELECT * FROM activity_tb WHERE activity_no =?";
	private final static String UPDATE_ACTIVITY_SQL = "UPDATE activity_tb SET activity_kind=? WHERE activity_no=?";
	private final static String DELETE_ACTIVITY_BY_NUM_SQL = "DELETE activity_tb WHERE activity_no = ?";
	private final static String INSERT_ACTIVITY_SQL = "INSERT INTO activity_tb VALUES(?,?)";
	@Override
	public List<ActivityDTO> getActivity() throws DAOException {
		// TODO Auto-generated method stub
		List<ActivityDTO> activityDTOs = new ArrayList<ActivityDTO>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_ACTIVITY_SQL);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				ActivityDTO activityDTO = new ActivityDTO();
				activityDTO.setActivityNo(resultSet.getInt("activity_no"));
				activityDTO.setActivityKind(resultSet.getString("activity_kind"));
				activityDTOs.add(activityDTO);
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting ActivityDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return activityDTOs;
	}
	@Override
	public ActivityDTO getActivityByNum(Integer activityNum)
			throws DAOException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		ActivityDTO activityDTO=null;
		try{
			
			connection = getConnection();
			pStatement = connection.prepareStatement(GET_ACTIVITY_BY_NUM_SQL);
			pStatement.setInt(1,activityNum);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				activityDTO = new ActivityDTO();
				activityDTO.setActivityNo(resultSet.getInt("activity_no"));
				activityDTO.setActivityKind(resultSet.getString("activity_kind"));
			}
		}catch(Exception e)
		{
			throw new DAOException("Error getting activityDTOs." + e.getMessage());
		}finally{
			closeDBObjects(resultSet,pStatement,connection);
		}
		return activityDTO;
	}
	@Override
	public void updateActivity(String activityKind, Integer activityNum)
			throws DAOException {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_ACTIVITY_SQL);
		
			pStatement.setString(1, activityKind);
			pStatement.setInt(2, activityNum);
		    pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error updating activityDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}
	
	}
	@Override
	public void deleteActivity(Integer activityNum) throws DAOException {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_ACTIVITY_BY_NUM_SQL);
			pStatement.setInt(1, activityNum);
			pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error deleting activityDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}		
	}
	@Override
	public void insertActivity(Integer activityNum, String activityKind)
			throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try{			
			connection = getConnection();
			pStatement = connection.prepareStatement(INSERT_ACTIVITY_SQL);
			pStatement.setInt(1, activityNum);
			pStatement.setString(2,activityKind);
		   pStatement.executeUpdate();
		}catch(Exception e)
		{
			throw new DAOException("Error inserting activityDTO." + e.getMessage());
		}finally{
			closeDBObjects(null,pStatement,connection);
		}
	}

}
