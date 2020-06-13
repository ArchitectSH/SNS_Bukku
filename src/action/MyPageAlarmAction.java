package action;

import java.util.List;

import dao.DAOException;
import dao.MyPageAlarmDAO;
import dto.MyPageAlarmDTO;

public class MyPageAlarmAction {
	private MyPageAlarmDAO myPageAlarmDAO;

	public void setMyPageAlarmDAO(MyPageAlarmDAO myPageAlarmDAO) {
		this.myPageAlarmDAO = myPageAlarmDAO;
	}

	public List<MyPageAlarmDTO> getMyPageAlarm() {
		List<MyPageAlarmDTO> myPageAlarmDTOs = null;
		try {
			myPageAlarmDTOs = myPageAlarmDAO.getMyPageAlarm();
		} catch (DAOException e) {
		}
		return myPageAlarmDTOs;
	}

	public List<MyPageAlarmDTO> getMyPageAlarmByDate(String startDate,
			String lastDate) {
		List<MyPageAlarmDTO> myPageAlarmDTOs = null;
		try {
			myPageAlarmDTOs = myPageAlarmDAO.getMyPageAlarmByDate(startDate,
					lastDate);
		} catch (DAOException e) {
		}
		return myPageAlarmDTOs;
	}

	public List<MyPageAlarmDTO> getMyPageAlarmBySinceDate(String beforeDate) {
		List<MyPageAlarmDTO> myPageAlarmDTOs = null;
		try {
			myPageAlarmDTOs = myPageAlarmDAO
					.getMyPageAlarmBySinceDate(beforeDate);
		} catch (DAOException e) {
		}
		return myPageAlarmDTOs;
	}

	public List<MyPageAlarmDTO> getMyPageAlarmBySinceDay(Integer beforeDay) {
		List<MyPageAlarmDTO> myPageAlarmDTOs = null;
		try {
			myPageAlarmDTOs = myPageAlarmDAO
					.getMyPageAlarmBySinceDay(beforeDay);
		} catch (DAOException e) {
		}
		return myPageAlarmDTOs;
	}

	public List<MyPageAlarmDTO> getMyPageAlarmByTitle(String myPageTitle) {
		List<MyPageAlarmDTO> myPageAlarmDTOs = null;
		try {
			myPageAlarmDTOs = myPageAlarmDAO.getMyPageAlarmByTitle(myPageTitle);
		} catch (DAOException e) {
		}
		return myPageAlarmDTOs;
	}

	public MyPageAlarmDTO getMyPageAlarmByAlarmNum(Integer alarmNum) {
		MyPageAlarmDTO myPageAlarmDTO = null;
		try {
			myPageAlarmDTO = myPageAlarmDAO.getMyPageAlarmByAlarmNum(alarmNum);
		} catch (DAOException e) {
		}
		return myPageAlarmDTO;
	}

	public void deleteMyPageAlarmByAlarmNum(Integer alarmNum) {
		try {
			myPageAlarmDAO.deleteMyPageAlarmByAlarmNum(alarmNum);
		} catch (DAOException e) {
		}
	}

	public void deleteMyPageAlarmByTitle(String myPageTitle) {
		try {
			myPageAlarmDAO.deleteMyPageAlarmByTitle(myPageTitle);
		} catch (DAOException e) {
		}
	}

	public void insertMyPageAlarm(Integer alarmNum, String myPageTitle) {
		try {
			myPageAlarmDAO.insertMyPageAlarm(alarmNum, myPageTitle);
		} catch (DAOException e) {
		}
	}

}
