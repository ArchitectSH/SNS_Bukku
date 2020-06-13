package dao;
import java.util.List;

import dto.GuestPostDTO;

public interface GuestPostDAO extends DAO{
	public List<GuestPostDTO> getGuestPost() throws DAOException;
	public List<GuestPostDTO> getGuestPostByWriterId(String id) throws DAOException;
	public List<GuestPostDTO> getGuestPostByReceiverId(String id) throws DAOException;
	public void deleteGuestPostByPostNum(Integer postNum) throws DAOException;
	public void deleteGuestPostByReceiverId(String id) throws DAOException;
	public void insertGuestPost(Integer postNum, String receiverId) throws DAOException;
}
