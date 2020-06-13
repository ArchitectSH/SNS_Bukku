package dao;

import java.util.*;

import dto.*;


public interface MyPageUserKindDAO extends DAO{
	public List<MyPageUserKindDTO> getMyPageUserKind() throws DAOException;
	public MyPageUserKindDTO getMyPageUserKindByNum(Integer kindNum) throws DAOException;
	public void updateMyPageUserKind(String kind, Integer kindNum) throws DAOException;
	public void deleteMyPageUserKind(Integer kindNum) throws DAOException;
	public void insertMyPage(Integer kindNum, String kind) throws DAOException;
}
