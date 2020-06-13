package dao;

import java.util.List;

import dto.StopViewDTO;


public interface StopViewDAO extends DAO{
	public List<StopViewDTO> getStopView() throws DAOException;
	
	
	
	public List<StopViewDTO> getStopViewByUserStop(Integer userStop) throws DAOException;
	
	
	
	public StopViewDTO getStopViewById(String id) throws DAOException;
	
	}

