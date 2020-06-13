package action;

import java.util.List;

import dao.FollowingMyPageViewDAO;
import dto.FollowingMyPageViewDTO;

public class FollowingMyPageViewAction {
	private FollowingMyPageViewDAO followingMyPageViewDAO;
	public void setFollowingMyPageViewDAO(FollowingMyPageViewDAO followingMyPageViewDAO) {
		this.followingMyPageViewDAO = followingMyPageViewDAO;
	}
	
	public List<FollowingMyPageViewDTO> getFollowingMyPageView() {
		try{
			return followingMyPageViewDAO.getFollowingMyPageView();
		}
		catch(Exception e){
			return null;
		}
	}
	
	public List<FollowingMyPageViewDTO> getFollowingMyPageViewById(String id) {
		try{
			return followingMyPageViewDAO.getFollowingMyPageViewById(id);
		}
		catch(Exception e){
			return null;
		}
	}
	
	public List<FollowingMyPageViewDTO> getFollowingMyPageViewByTitleId(String title, String id) {
		try{
			return followingMyPageViewDAO.getFollowingMyPageViewByTitleId(title, id);
		}
		catch(Exception e){
			return null;
		}
	}
}
