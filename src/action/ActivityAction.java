package action;

import java.util.List;

import dao.ActivityDAO;
import dao.DAOException;
import dto.ActivityDTO;


public class ActivityAction {
	private ActivityDAO activityDAO;

	public void setActivityDAO(ActivityDAO activityDAO) {
		this.activityDAO = activityDAO;
	}

	public List<ActivityDTO> getActivity() {
		List<ActivityDTO> activityDTOs = null;
		try {
			activityDTOs = activityDAO.getActivity();
		} catch (DAOException e) {
		}
		return activityDTOs;
	}

	public ActivityDTO getActivityByNum(Integer activityNum) {
		ActivityDTO activityDTO = null;
		try {
			activityDTO = activityDAO.getActivityByNum(activityNum);
		} catch (DAOException e) {
		}
		return activityDTO;
	}

	public void updateActivity(String activityKind, Integer activityNum) {
		try {
			activityDAO.updateActivity(activityKind, activityNum);
		} catch (DAOException e) {
		}
	}

	public void deleteActivity(Integer activityNum) {
		try {
			activityDAO.deleteActivity(activityNum);
		} catch (DAOException e) {
		}
	}

	public void insertActivity(Integer activityNum, String activityKind) {
		try {
			activityDAO.insertActivity(activityNum, activityKind);
		} catch (DAOException e) {
		}
	}

}
