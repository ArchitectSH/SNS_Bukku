package action;

import java.util.List;

import dao.MyPageDAO;
import dto.MyPageDTO;

public class MyPageAction {
	private MyPageDAO myPageDAO;
	public void setMyPageDAO(MyPageDAO myPageDAO) {
		this.myPageDAO = myPageDAO;
	}
	
	public List<MyPageDTO> getMyPage() {
		try{
			return myPageDAO.getMyPage();
		}
		catch(Exception e){
			return null;
		}
	}
	
	public MyPageDTO getMyPageByTitle(String title) {
		try{
			return myPageDAO.getMyPageByTitle(title);
		}
		catch(Exception e){
			return null;
		}
	}
	
	public List<MyPageDTO> getMyPageById(String id) {
		try{
			return myPageDAO.getMyPageById(id);
		}
		catch(Exception e){
			return null;
		}
	}
	
	public void updateMyPageIntro(String introduction, String title) {
		try{
			myPageDAO.updateMyPageIntro(introduction, title);
			//System.out.println("수정하러왔다");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void updateMyPageImage(String image, String title) {
		try{
			myPageDAO.updateMyPageImage(image, title);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void deleteMyPage(String title) {
		try{
			myPageDAO.deleteMyPage(title);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void insertMyPage(String title, String image, String introduction, String id) {
		try{
			myPageDAO.insertMyPage(title, image, introduction, id);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
