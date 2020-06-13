package action;

import java.util.List;

import dao.DAOException;
import dao.GroupAlarmDAO;

import dto.GroupAlarmDTO;

public class GroupAlarmAction {
	private GroupAlarmDAO groupAlarmDAO;

	public void setGroupAlarmDAO(GroupAlarmDAO groupAlarmDAO) {
		this.groupAlarmDAO = groupAlarmDAO;
	}

	public List<GroupAlarmDTO> getGroupAlarm() {
		List<GroupAlarmDTO> groupAlarmDTOs = null;
		try {
			groupAlarmDTOs = groupAlarmDAO.getGroupAlarm();
		} catch (DAOException e) {
		}
		return groupAlarmDTOs;
	}

	public List<GroupAlarmDTO> getGroupAlarmByDate(String startDate,
			String lastDate) {
		List<GroupAlarmDTO> groupAlarmDTOs = null;
		try {
			groupAlarmDTOs = groupAlarmDAO.getGroupAlarmByDate(startDate,
					lastDate);
		} catch (DAOException e) {
		}
		return groupAlarmDTOs;
	}

	public List<GroupAlarmDTO> getGroupAlarmBySinceDate(String beforeDate) {
		List<GroupAlarmDTO> groupAlarmDTOs = null;
		try {
			groupAlarmDTOs = groupAlarmDAO.getGroupAlarmBySinceDate(beforeDate);
		} catch (DAOException e) {
		}
		return groupAlarmDTOs;
	}

	public List<GroupAlarmDTO> getGroupAlarmBySinceDay(Integer beforeDay) {
		List<GroupAlarmDTO> groupAlarmDTOs = null;
		try {
			groupAlarmDTOs = groupAlarmDAO.getGroupAlarmBySinceDay(beforeDay);
		} catch (DAOException e) {
		}
		return groupAlarmDTOs;
	}

	public GroupAlarmDTO getGroupAlarmByAlarmNum(Integer alarmNum) {
		GroupAlarmDTO groupAlarmDTO = null;
		try {
			groupAlarmDTO = groupAlarmDAO.getGroupAlarmByAlarmNum(alarmNum);
		} catch (DAOException e) {
		}
		return groupAlarmDTO;
	}

	public List<GroupAlarmDTO> getGroupAlarmByGroupNum(Integer groupNum) {
		List<GroupAlarmDTO> groupAlarmDTOs = null;
		try {
			groupAlarmDTOs = groupAlarmDAO.getGroupAlarmByGroupNum(groupNum);
		} catch (DAOException e) {
		}
		return groupAlarmDTOs;
	}

	public void deleteGroupAlarmByAlarmNum(Integer alarmNum) {
		try {
			groupAlarmDAO.deleteGroupAlarmByAlarmNum(alarmNum);
		} catch (DAOException e) {
		}
	}

	public void deleteGroupAlarmByGroupNum(Integer groupNum) {
		try {
			groupAlarmDAO.deleteGroupAlarmByGroupNum(groupNum);
		} catch (DAOException e) {
		}
	}

	public void insertGroupAlarm(Integer alarmNum, Integer groupNum) {
		try {
			groupAlarmDAO.insertGroupAlarm(alarmNum, groupNum);
		} catch (DAOException e) {
		}
	}

}
