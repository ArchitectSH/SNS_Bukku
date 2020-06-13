package action;

import java.util.List;

import dao.AlarmViewDAO;
import dao.DAOException;
import dto.AlarmViewDTO;

public class AlarmViewAction {
	private AlarmViewDAO alarmViewDAO;

	public void setAlarmViewDAO(AlarmViewDAO alarmViewDAO) {
		this.alarmViewDAO = alarmViewDAO;
	}

	public List<AlarmViewDTO> getAlarmView() {
		List<AlarmViewDTO> alarmViewDTOs = null;
		try {
			alarmViewDTOs = alarmViewDAO.getAlarmView();
		} catch (DAOException e) {
		}
		return alarmViewDTOs;
	}

	public List<AlarmViewDTO> getAlarmViewByDate(String startDate,
			String endDate) {
		List<AlarmViewDTO> alarmViewDTOs = null;
		try {
			alarmViewDTOs = alarmViewDAO.getAlarmViewByDate(startDate, endDate);
		} catch (DAOException e) {
		}
		return alarmViewDTOs;
	}

	public List<AlarmViewDTO> getAlarmViewBySinceDate(String beforeDate) {
		List<AlarmViewDTO> alarmViewDTOs = null;
		try {
			alarmViewDTOs = alarmViewDAO.getAlarmViewBySinceDate(beforeDate);
		} catch (DAOException e) {
		}
		return alarmViewDTOs;
	}

	public List<AlarmViewDTO> getAlarmViewBySinceDay(Integer beforeDay) {
		List<AlarmViewDTO> alarmViewDTOs = null;
		try {
			alarmViewDTOs = alarmViewDAO.getAlarmViewBySinceDay(beforeDay);
		} catch (DAOException e) {
		}
		return alarmViewDTOs;
	}

	public AlarmViewDTO getAlarmViewByAlarmNo(Integer alarmNo) {
		AlarmViewDTO alarmViewDTO = null;
		try {
			alarmViewDTO = alarmViewDAO.getAlarmViewByAlarmNo(alarmNo);
		} catch (DAOException e) {
		}
		return alarmViewDTO;
	}

	public List<AlarmViewDTO> getAlarmViewByReceiverIdAndCheck(
			String receiverId, Integer check) {
		List<AlarmViewDTO> alarmViewDTOs = null;
		try {
			alarmViewDTOs = alarmViewDAO.getAlarmViewByReceiverIdAndCheck(
					receiverId, check);
		} catch (DAOException e) {
		}
		return alarmViewDTOs;
	}

	public List<AlarmViewDTO> getAlarmViewByReceiverId(String receiverId) {
		List<AlarmViewDTO> alarmViewDTOs = null;
		try {
			alarmViewDTOs = alarmViewDAO.getAlarmViewByReceiverId(receiverId);
		} catch (DAOException e) {
		}
		return alarmViewDTOs;
	}

	public List<AlarmViewDTO> getAlarmViewByReceiverIdOrderBukku(
			String receiverId) {
		List<AlarmViewDTO> alarmViewDTOs = null;
		try {
			alarmViewDTOs = alarmViewDAO
					.getAlarmViewByReceiverIdOrderBukku(receiverId);
		} catch (DAOException e) {
		}
		return alarmViewDTOs;
	}

	public List<AlarmViewDTO> getAlarmViewByReceiverIdAtti(String receiverId) {
		List<AlarmViewDTO> alarmViewDTOs = null;
		try {
			alarmViewDTOs = alarmViewDAO
					.getAlarmViewByReceiverIdAtti(receiverId);
		} catch (DAOException e) {
		}
		return alarmViewDTOs;
	}

	public List<AlarmViewDTO> getAlarmViewByReceiverIdNotFriend(
			String receiverId) {
		List<AlarmViewDTO> alarmViewDTOs = null;
		try {
			alarmViewDTOs = alarmViewDAO
					.getAlarmViewByReceiverIdNotFriend(receiverId);
		} catch (DAOException e) {
		}
		return alarmViewDTOs;
	}

}
