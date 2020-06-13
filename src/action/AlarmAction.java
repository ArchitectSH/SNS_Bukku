package action;

import java.util.List;

import dao.AlarmDAO;
import dao.DAOException;
import dto.AlarmDTO;


public class AlarmAction {
	private AlarmDAO alarmDAO;

	public void setAlarmDAO(AlarmDAO alarmDAO) {
		this.alarmDAO = alarmDAO;
	}

	public List<AlarmDTO> getAlarm() {
		List<AlarmDTO> alarmDTOs = null;
		try {
			alarmDTOs = alarmDAO.getAlarm();
		} catch (DAOException e) {
		}
		return alarmDTOs;
	}

	public List<AlarmDTO> getAlarmByDate(String startDate, String lastDate) {
		List<AlarmDTO> alarmDTOs = null;
		try {
			alarmDTOs = alarmDAO.getAlarmByDate(startDate, lastDate);
		} catch (DAOException e) {
		}
		return alarmDTOs;
	}

	public List<AlarmDTO> getAlarmBySinceDate(String beforeDate) {
		List<AlarmDTO> alarmDTOs = null;
		try {
			alarmDTOs = alarmDAO.getAlarmBySinceDate(beforeDate);
		} catch (DAOException e) {
		}
		return alarmDTOs;
	}

	public List<AlarmDTO> getAlarmBySinceDay(Integer beforeDay) {
		List<AlarmDTO> alarmDTOs = null;
		try {
			alarmDTOs = alarmDAO.getAlarmBySinceDay(beforeDay);
		} catch (DAOException e) {
		}
		return alarmDTOs;
	}

	public AlarmDTO getAlarmByNum(Integer alarmNum) {
		AlarmDTO alarmDTO = null;
		try {
			alarmDTO = alarmDAO.getAlarmByNum(alarmNum);
		} catch (DAOException e) {
		}
		return alarmDTO;
	}

	public List<AlarmDTO> getAlarmByCheck(Integer check) {
		List<AlarmDTO> alarmDTOs = null;
		try {
			alarmDTOs = alarmDAO.getAlarmByCheck(check);
		} catch (DAOException e) {
		}
		return alarmDTOs;
	}

	public List<AlarmDTO> getAlarmByReceiverId(String receiverId) {
		List<AlarmDTO> alarmDTOs = null;
		try {
			alarmDTOs = alarmDAO.getAlarmByReceiverId(receiverId);
		} catch (DAOException e) {
		}
		return alarmDTOs;
	}

	public List<AlarmDTO> getAlarmByReceiverIdAndCheck(String receiverId,
			Integer check) {
		List<AlarmDTO> alarmDTOs = null;
		try {
			alarmDTOs = alarmDAO
					.getAlarmByReceiverIdAndCheck(receiverId, check);
		} catch (DAOException e) {
		}
		return alarmDTOs;
	}

	public List<AlarmDTO> getAlarmByReceiverIdActNum(String receiverId,
			Integer activityNum) {
		List<AlarmDTO> alarmDTOs = null;
		try {
			alarmDTOs = alarmDAO.getAlarmByReceiverIdActNum(receiverId,
					activityNum);
		} catch (DAOException e) {
		}
		return alarmDTOs;
	}

	public void updateCheckAlarm(Integer check, Integer alarmNum) {
		try {
			System.out.println("check : "+check+"alarmNo : "+alarmNum);
			alarmDAO.updateCheckAlarm(check, alarmNum);
		} catch (DAOException e) {
		}
	}

	public void deleteAlarm(Integer alarmNum) {
		try {
			alarmDAO.deleteAlarm(alarmNum);
		} catch (DAOException e) {
		}
	}

	public void deleteAlarmByBeforeDate(Integer beforeDate) {
		try {
			alarmDAO.deleteAlarmByBeforeDate(beforeDate);
		} catch (DAOException e) {
		}
	}

	public void deleteAlarmByCheck(Integer check) {
		try {
			alarmDAO.deleteAlarmByCheck(check);
		} catch (DAOException e) {
		}
	}

	public void deleteAlarmByReceiverId(String receiverId) {
		try {
			alarmDAO.deleteAlarmByReceiverId(receiverId);
		} catch (DAOException e) {
		}
	}

	public void deleteAlarmBySenderId(String senderId) {
		try {
			alarmDAO.deleteAlarmBySenderId(senderId);
		} catch (DAOException e) {
		}
	}

	public void deleteAlarmBySenderAndReceiver(String senderId,
			String receiverId) {
		try {
			alarmDAO.deleteAlarmBySenderAndReceiver(senderId, receiverId);
		} catch (DAOException e) {
		}
	}

	public void deleteAlarmBySenderAndReceiverAndActNum(String senderId,
			String receiverId, Integer activityNum) {
		try {
			alarmDAO.deleteAlarmBySenderAndReceiverAndActNum(senderId,
					receiverId, activityNum);
		} catch (DAOException e) {
		}
	}

	public Integer insertAlarm(Integer check, String receiverId,
			Integer activityNum, String id) {
		Integer alarmNo = null;
		try {
			alarmNo = alarmDAO.insertAlarm(check, receiverId, activityNum, id);
		} catch (DAOException e) {
		}
		return alarmNo;
	}

}
