package dao;

import java.util.List;
import dto.*;

public interface MyPageInfoViewDAO extends DAO{
	public List<MyPageInfoViewDTO> getMyPageInfoView() throws DAOException;
	public List<MyPageInfoViewDTO> getMyPageInfoViewByTitle(String title) throws DAOException;
	public List<MyPageInfoViewDTO> getMyPageInfoViewById(String id) throws DAOException;
}
