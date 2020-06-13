package dao;

import java.util.*;

import dto.*;


public interface MyPageDAO extends DAO{
	public List<MyPageDTO> getMyPage() throws DAOException;
	public MyPageDTO getMyPageByTitle(String title) throws DAOException;
	public List<MyPageDTO> getMyPageById(String id) throws DAOException;
	public void updateMyPageIntro(String introduction, String title) throws DAOException;
	public void updateMyPageImage(String image, String title) throws DAOException;
	public void deleteMyPage(String title) throws DAOException;
	public void insertMyPage(String title, String image, String introduction, String id) throws DAOException;
}
