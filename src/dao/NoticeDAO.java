package dao;

import java.util.List;

import dto.NoticeDTO;

public interface NoticeDAO extends DAO{
	public List<NoticeDTO> getNotice() throws DAOException;
	public List<NoticeDTO> getNoticeById(String adminId) throws DAOException;
	
	public NoticeDTO getNoticeByNum(Integer noticeNum) throws DAOException;
	
	public void updateNotice(String noticeTitle, String noticeContent, Integer noticeNum) throws DAOException;
	
	public void updateNoticeTitle(String noticeTitle, Integer noticeNum) throws DAOException;
	public void updateNoticeContent(String noticeContent, Integer noticeNum)  throws DAOException;
	public void deleteNotice(Integer noticeNum) throws DAOException;
	public void deleteNoticeById(String adminId) throws DAOException;
	
	public void deleteNoticeByTitle(String noticeTitle) throws DAOException;
	
	public void insertNotice(String adminId, String noticeTitle, String noticeContent) throws DAOException;
}
