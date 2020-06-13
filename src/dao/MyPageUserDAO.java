package dao;

import java.util.*;

import dto.*;


public interface MyPageUserDAO extends DAO{
	public List<MyPageUserDTO> getMyPageUser() throws DAOException;
	public List<MyPageUserDTO> getMyPageUserByTitle(String myPageTitle) throws DAOException;
	public List<MyPageUserDTO> getMyPageUserById(String id) throws DAOException;
	public List<MyPageUserDTO> getMyPageUserByKind(Integer kind) throws DAOException;
	public List<MyPageUserDTO> getMyPageUserByKindId(Integer kind, String id) throws DAOException;
	public void updateMyPageUser(Integer kind, String id, String myPageTitle) throws DAOException;
	public void deleteMyPageUser(String id) throws DAOException;
	public void deleteMyPageUserByTitleId(String id, String title) throws DAOException;
	public void deleteMyPageUserByTitle(String title) throws DAOException;
	public void insertMyPageUser(String myPageTitle, Integer kind, String id) throws DAOException;
	public List<MyPageUserDTO> getMyPageUserByKindTitle(Integer kind, String myPageTitle) throws DAOException;
}
