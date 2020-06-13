package action;

import java.util.List;

import dao.MyPageUserDAO;
import dto.MyPageUserDTO;

public class MyPageUserAction {
	private MyPageUserDAO myPageUserDAO;
	public void setMyPageUserDAO(MyPageUserDAO myPageUserDAO) {
		this.myPageUserDAO = myPageUserDAO;
	}
	
	public List<MyPageUserDTO> getMyPageUser() {
		try{
			return myPageUserDAO.getMyPageUser();
		}
		catch(Exception e){
			return null;
		}
	}
	
	public List<MyPageUserDTO> getMyPageUserByTitle(String myPageTitle) {
		try{
			return myPageUserDAO.getMyPageUserByTitle(myPageTitle);
		}
		catch(Exception e){
			return null;
		}
	}
	
	public List<MyPageUserDTO> getMyPageUserByKindTitle(Integer kind, String myPageTitle) {
		try{
			return myPageUserDAO.getMyPageUserByKindTitle(kind,myPageTitle);
		}
		catch(Exception e){
			return null;
		}
	}
	
	public List<MyPageUserDTO> getMyPageUserById(String id) {
		try{
			return myPageUserDAO.getMyPageUserById(id);
		}
		catch(Exception e){
			return null;
		}
	}
	
	public List<MyPageUserDTO> getMyPageUserByKind(Integer kind) {
		try{
			return myPageUserDAO.getMyPageUserByKind(kind);
		}
		catch(Exception e){
			return null;
		}
	}
	
	public List<MyPageUserDTO> getMyPageUserByKindId(Integer kind, String id) {
		try{
			return myPageUserDAO.getMyPageUserByKindId(kind, id);
		}
		catch(Exception e){
			return null;
		}
	}
	
	public void updateMyPageUser(Integer kind, String id, String myPageTitle) {
		try{
			myPageUserDAO.updateMyPageUser(kind, id, myPageTitle);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void deleteMyPageUser(String id) {
		try{
			myPageUserDAO.deleteMyPageUser(id);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void deleteMyPageUserByTitle(String title) {
		try{
			myPageUserDAO.deleteMyPageUserByTitle(title);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void deleteMyPageUserByTitleId(String id, String title) {
		try{
			myPageUserDAO.deleteMyPageUserByTitleId(id, title);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void insertMyPageUser(String myPageTitle, Integer kind, String id) {
		try{
			myPageUserDAO.insertMyPageUser(myPageTitle, kind, id);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
