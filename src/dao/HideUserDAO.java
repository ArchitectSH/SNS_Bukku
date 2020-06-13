package dao;
import java.util.List;

import dto.HideUserDTO ;

public interface HideUserDAO extends DAO{
	public List<HideUserDTO> getHideUser()  throws DAOException;
		
	 
	
	public HideUserDTO getHideUserByHideNum(Integer hideNum)  throws DAOException;
	
	 
	
	public List<HideUserDTO> getHideUserByPostNum(Integer postNum)  throws DAOException;
	
	 
	
	public List<HideUserDTO> getHideUserById(String id)  throws DAOException;
	
	 
	
	public Integer getHideUserCount(Integer postNum)  throws DAOException;
	
	 
	
	public void deleteHideUserByPostNum(Integer postNum)  throws DAOException;
	
	 
	
	public void deleteHideUserByHideNum(Integer hideNum)  throws DAOException;
	
	 
	
	public void deleteHideUserById(String id)  throws DAOException;
	
	 
	
	public void deleteHideUserByIdPostNum(String id, Integer postNum)  throws DAOException;
	
	 
	
	public void insertHideUser(Integer postNum, String id)  throws DAOException;
	
	 
	}
