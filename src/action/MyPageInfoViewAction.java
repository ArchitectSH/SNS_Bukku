package action;

import java.util.List;

import dao.MyPageInfoViewDAO;
import dto.MyPageInfoViewDTO;

public class MyPageInfoViewAction {
	private MyPageInfoViewDAO myPageInfoViewDAO;
	public void setMyPageInfoViewDAO(MyPageInfoViewDAO myPageInfoViewDAO) {
		this.myPageInfoViewDAO = myPageInfoViewDAO;
	}
	
	public List<MyPageInfoViewDTO> getMyPageInfoView() {
		try{
			return myPageInfoViewDAO.getMyPageInfoView();
		}
		catch(Exception e){
			return null;
		}
	}
	
	public List<MyPageInfoViewDTO> getMyPageInfoViewByTitle(String title) {
		try{
			return myPageInfoViewDAO.getMyPageInfoViewByTitle(title);
		}
		catch(Exception e){
			return null;
		}
	}
	
	public List<MyPageInfoViewDTO> getMyPageInfoViewById(String id) {
		try{
			return myPageInfoViewDAO.getMyPageInfoViewById(id);
		}
		catch(Exception e){
			return null;
		}
	}
}
