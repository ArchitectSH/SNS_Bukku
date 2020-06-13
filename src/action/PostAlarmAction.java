package action;

import java.util.List;

import dao.DAOException;
import dao.PostAlarmDAO;

import dto.PostAlarmDTO;

public class PostAlarmAction {
	private PostAlarmDAO postAlarmDAO;

	public void setPostAlarmDAO(PostAlarmDAO postAlarmDAO) {
		this.postAlarmDAO = postAlarmDAO;
	}

	public List<PostAlarmDTO> getPostAlarm() {
		List<PostAlarmDTO> postAlarmDTOs = null;
		try {
			postAlarmDTOs = postAlarmDAO.getPostAlarm();
		} catch (DAOException e) {
		}
		return postAlarmDTOs;
	}

	public List<PostAlarmDTO> getPostAlarmByDate(String startDate,
			String lastDate) {
		List<PostAlarmDTO> postAlarmDTOs = null;
		try {
			postAlarmDTOs = postAlarmDAO
					.getPostAlarmByDate(startDate, lastDate);
		} catch (DAOException e) {
		}
		return postAlarmDTOs;
	}

	public List<PostAlarmDTO> getPostAlarmBySinceDate(String beforeDate) {
		List<PostAlarmDTO> postAlarmDTOs = null;
		try {
			postAlarmDTOs = postAlarmDAO.getPostAlarmBySinceDate(beforeDate);
		} catch (DAOException e) {
		}
		return postAlarmDTOs;
	}

	public List<PostAlarmDTO> getPostAlarmBySinceDay(Integer beforeDay) {
		List<PostAlarmDTO> postAlarmDTOs = null;
		try {
			postAlarmDTOs = postAlarmDAO.getPostAlarmBySinceDay(beforeDay);
		} catch (DAOException e) {
		}
		return postAlarmDTOs;
	}

	public PostAlarmDTO getPostAlarmByAlarmNum(Integer alarmNum) {
		PostAlarmDTO postAlarmDTO = null;
		try {
			postAlarmDTO = postAlarmDAO.getPostAlarmByAlarmNum(alarmNum);
		} catch (DAOException e) {
		}
		return postAlarmDTO;
	}

	public List<PostAlarmDTO> getPostAlarmByPostNum(Integer postNum) {
		List<PostAlarmDTO> postAlarmDTOs = null;
		try {
			postAlarmDTOs = postAlarmDAO.getPostAlarmByPostNum(postNum);
		} catch (DAOException e) {
		}
		return postAlarmDTOs;
	}

	public void deletePostAlarmByAlarmNum(Integer alarmNum) {
		try {
			postAlarmDAO.deletePostAlarmByAlarmNum(alarmNum);
		} catch (DAOException e) {
		}
	}

	public void deletePostAlarmByPostNum(Integer postNum) {
		try {
			postAlarmDAO.deletePostAlarmByPostNum(postNum);
		} catch (DAOException e) {
		}
	}

	public void insertPostAlarm(Integer alarmNum, Integer postNum) {
		try {
			postAlarmDAO.insertPostAlarm(alarmNum, postNum);
		} catch (DAOException e) {
		}
	}
}
