package dao;

import java.util.List;

import dto.ApprovalPageViewDTO;


public interface ApprovalPageViewDAO extends DAO{
	public List<ApprovalPageViewDTO> getApprovalPageView() throws DAOException;
	public List<ApprovalPageViewDTO> getApprovalPageViewByTitle(String title) throws DAOException;
	public List<ApprovalPageViewDTO> getApprovalPageViewById(String id) throws DAOException;
	public List<ApprovalPageViewDTO> getApprovalPageViewByTitleId(String title, String id) throws DAOException;
}
