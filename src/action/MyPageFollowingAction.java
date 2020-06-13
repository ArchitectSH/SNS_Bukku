package action;

import java.util.List;

import dao.MyPageFollowingDAO;
import dto.MyPageFollowingDTO;

public class MyPageFollowingAction {
	private MyPageFollowingDAO myPageFollowingDAO;
	public void setMyPageFollowingDAO(MyPageFollowingDAO myPageFollowingDAO) {
		this.myPageFollowingDAO = myPageFollowingDAO;
	}
	
	public List<MyPageFollowingDTO> getMyPageFollowing() {
		try{
			return myPageFollowingDAO.getMyPageFollowing();
		}
		catch(Exception e){
			return null;
		}
	}
	
	public List<MyPageFollowingDTO> getMyPageFollowingByTitle(String title) {
		try{
			return myPageFollowingDAO.getMyPageFollowingByTitle(title);
		}
		catch(Exception e){
			return null;
		}
	}
	
	public List<MyPageFollowingDTO> getMyPageFollowingById(String id) {
		try{
			return myPageFollowingDAO.getMyPageFollowingById(id);
		}
		catch(Exception e){
			return null;
		}
	}
	
	public void deleteMyPageFollowing(String myPageTitle) {
		try{
			myPageFollowingDAO.deleteMyPageFollowing(myPageTitle);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void deleteMyPageFollowingByTitleId(String myPageTitle, String id) {
		try{
			myPageFollowingDAO.deleteMyPageFollowingByTitleId(myPageTitle, id);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void deleteMyPageFollowingById(String id) {
		try{
			myPageFollowingDAO.deleteMyPageFollowingById(id);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void insertMyPageFollowing(String myPageTitle, String id) {
		try{
			myPageFollowingDAO.insertMyPageFollowing(myPageTitle, id);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
