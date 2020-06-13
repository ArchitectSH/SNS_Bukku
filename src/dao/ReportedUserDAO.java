package dao;

import java.util.List;

import dto.ReportedUserDTO;

public interface ReportedUserDAO extends DAO{
	public List<ReportedUserDTO> getReportedUser()  throws DAOException;
		
	 
	
	public ReportedUserDTO getReportedUserByReportNum(Integer reportNum)  throws DAOException;
	
	 
	
	public List<ReportedUserDTO> getReportedUserByPostNum(Integer postNum)  throws DAOException;
	
	 
	
	public List<ReportedUserDTO> getReportedUserByID(String id)  throws DAOException;
	
	 
	
	public Integer getReportedUserCount(Integer postNum)  throws DAOException;
	
	 
	
	public void deleteReportedUserByPostNum(Integer postNum)  throws DAOException;
	
	 
	
	public void deleteReportedUserByReportNum(Integer reportNum)  throws DAOException;
	
	 
	
	public void deleteReportedUserByID(String id)  throws DAOException;
	
	 
	
	public void deleteReportedUserByIdPostNum(String id, Integer postNum)  throws DAOException;
	
	 
	
	public void insertReportedUser(Integer postNum, String id)  throws DAOException;
	
	}
 
