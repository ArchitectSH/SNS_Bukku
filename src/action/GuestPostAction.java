package action;

import java.util.List;

import dao.DAOException;
import dao.GuestPostDAO;
import dto.GuestPostDTO;


public class GuestPostAction {
	private GuestPostDAO guestPostDAO;
	public void setGuestPostDAO(GuestPostDAO guestPostDAO) {
		this.guestPostDAO = guestPostDAO;
	}
	
	public List<GuestPostDTO> getGuestPost() {
		return null;
	}
	
	public List<GuestPostDTO> getGuestPostByWriterId(String id) {
		List<GuestPostDTO> list = null;
		try{
			list = guestPostDAO.getGuestPostByWriterId(id);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<GuestPostDTO> getGuestPostByReceiverId(String id) {
		List<GuestPostDTO> list = null;
		try{
			list = guestPostDAO.getGuestPostByReceiverId(id);
		}catch(DAOException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public void deleteGuestPostByPostNum(Integer postNum) {
		try{
			guestPostDAO.deleteGuestPostByPostNum(postNum);
		}catch(DAOException e){
			e.printStackTrace();
		}
	}
	
	public void deleteGuestPostByReceiverId(String id) {
		try{
			guestPostDAO.deleteGuestPostByReceiverId(id);
		}catch(DAOException e){
			e.printStackTrace();
		}
	}
	
	public void insertGuestPost(Integer postNum, String receiverId) {
		try{
			guestPostDAO.insertGuestPost(postNum, receiverId);
		}catch(DAOException e){
			e.printStackTrace();
		}
	}
}
