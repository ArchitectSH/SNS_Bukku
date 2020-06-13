package dao;

import java.util.List;

import dto.ActivityDTO;

public interface ActivityDAO extends DAO{

	public List<ActivityDTO> getActivity() throws DAOException;
	
	public ActivityDTO getActivityByNum(Integer activityNum) throws DAOException;
	
	public void updateActivity(String activityKind, Integer activityNum) throws DAOException;
	
	public void deleteActivity(Integer activityNum) throws DAOException ;
	
	public void insertActivity(Integer activityNum, String activityKind) throws DAOException;
}