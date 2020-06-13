package action;

import java.util.List;
import dao.ApprovalPageViewDAO;
import dto.ApprovalPageViewDTO;

public class ApprovalPageViewAction {
	private ApprovalPageViewDAO approvalPageViewDAO;
	
	public void setApprovalPageViewDAO(ApprovalPageViewDAO approvalPageViewDAO) {
		this.approvalPageViewDAO = approvalPageViewDAO;
	}
	
	public List<ApprovalPageViewDTO> getApprovalPageView() {
		try{
			return approvalPageViewDAO.getApprovalPageView();
		}
		catch(Exception e){
			return null;
		}
	}
	
	public List<ApprovalPageViewDTO> getApprovalPageViewByTitle(String title) {
		try{
			return approvalPageViewDAO.getApprovalPageViewByTitle(title);
		}
		catch(Exception e){
			return null;
		}
	}
	
	public List<ApprovalPageViewDTO> getApprovalPageViewById(String id) {
		try{
			return approvalPageViewDAO.getApprovalPageViewById(id);
		}
		catch(Exception e){
			return null;
		}
	}
	
	public List<ApprovalPageViewDTO> getApprovalPageViewByTitleId(String title, String id) {
		try{
			return approvalPageViewDAO.getApprovalPageViewByTitleId(title, id);
		}
		catch(Exception e){
			return null;
		}
	}
}
