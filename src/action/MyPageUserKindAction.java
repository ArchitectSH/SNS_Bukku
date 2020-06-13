package action;

import java.util.List;

import dao.MyPageUserKindDAO;
import dto.MyPageUserKindDTO;

public class MyPageUserKindAction {
	private MyPageUserKindDAO myPageUserKindDAO;
	public void setMyPageUserKindDAO(MyPageUserKindDAO myPageUserKindDAO) {
		this.myPageUserKindDAO = myPageUserKindDAO;
	}
	
	public List<MyPageUserKindDTO> getMyPageUserKind() {
		try{
			return myPageUserKindDAO.getMyPageUserKind();
		}
		catch(Exception e){
			return null;
		}
	}
	
	public MyPageUserKindDTO getMyPageUserKindByNum(Integer kindNum) {
		try{
			return myPageUserKindDAO.getMyPageUserKindByNum(kindNum);
		}
		catch(Exception e){
			return null;
		}
	}
	
	public void updateMyPageUserKind(String kind, Integer kindNum) {
		try{
			myPageUserKindDAO.updateMyPageUserKind(kind, kindNum);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void deleteMyPageUserKind(Integer kindNum) {
		try{
			myPageUserKindDAO.deleteMyPageUserKind(kindNum);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void insertMyPage(Integer kindNum, String kind) {
		try{
			myPageUserKindDAO.insertMyPage(kindNum, kind);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
