package action;

import java.util.List;

import dao.DAOException;
import dao.StopViewDAO;

import dto.StopViewDTO;

public class StopViewAction {
	private StopViewDAO stopViewDAO;

	public void setStopViewDAO(StopViewDAO stopViewDAO) {
		this.stopViewDAO = stopViewDAO;
	}

	public List<StopViewDTO> getStopView() {
		List<StopViewDTO> stopViewDTOs = null;
		try {
			stopViewDTOs = stopViewDAO.getStopView();
		} catch (DAOException e) {
		}
		return stopViewDTOs;
	}

	public List<StopViewDTO> getStopViewByUserStop(Integer userStop) {
		List<StopViewDTO> stopViewDTOs = null;
		try {
			stopViewDTOs = stopViewDAO.getStopViewByUserStop(userStop);
		} catch (DAOException e) {
		}
		return stopViewDTOs;
	}

	public StopViewDTO getStopViewById(String id) {
		StopViewDTO stopViewDTO = null;
		try {
			stopViewDTO = stopViewDAO.getStopViewById(id);
		} catch (DAOException e) {
		}
		return stopViewDTO;
	}

}
