package action;

import java.util.List;

import dao.DAOException;
import dao.HideUserDAO;
import dto.HideUserDTO;


public class HideUserAction {
	private HideUserDAO hideUserDAO;
	public void setHideUserDAO(HideUserDAO hideUserDAO) {
		this.hideUserDAO = hideUserDAO;
	}
	
	public List<HideUserDTO> getHideUser() {
		return null;
	}
	
	public HideUserDTO getHideUserByHideNum(Integer hideNum) {
		HideUserDTO hud = null;
		try{
			hud = hideUserDAO.getHideUserByHideNum(hideNum);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return hud;
	}
	
	public List<HideUserDTO> getHideUserByPostNum(Integer postNum) {
		List<HideUserDTO> list = null;
		try{
			list = hideUserDAO.getHideUserByPostNum(postNum);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<HideUserDTO> getHideUserById(String id) {
		List<HideUserDTO> list = null;
		try{
			list = hideUserDAO.getHideUserById(id);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public Integer getHideUserCount(Integer postNum) {
		return null;
	}
	
	public void deleteHideUserByPostNum(Integer postNum) {
		try{
			hideUserDAO.deleteHideUserByPostNum(postNum);
		}catch(DAOException e){
			e.printStackTrace();
		}
	}
	
	public void deleteHideUserByHideNum(Integer hideNum) {
		
	}
	
	public void deleteHideUserById(String id) {
		try{
			hideUserDAO.deleteHideUserById(id);
		}catch(DAOException e){
			e.printStackTrace();
		}
	}
	
	public void deleteHideUserByIdPostNum(String id, Integer postNum) {
		try{
			hideUserDAO.deleteHideUserByIdPostNum(id, postNum);
		}catch(DAOException e){
			e.printStackTrace();
		}
	}
	
	public void insertHideUser(Integer postNum, String id) {
		try{
			hideUserDAO.insertHideUser(postNum, id);
		}catch(DAOException e){
			e.printStackTrace();
		}
	}
}
