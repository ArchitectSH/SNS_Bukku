package model;

import java.util.HashMap;
import java.util.Map;




public class AdminInfoList {
	private Map<String, AdminInfo> adminInfoList;
	public AdminInfoList() {
		adminInfoList = new HashMap<String,AdminInfo>();

	}
	
	public AdminInfoList(Map<String,AdminInfo> adminInfoList) {
		this.adminInfoList=adminInfoList;	
	
	}
	
	public void login(String id, String password) {
	
	}
	
	public void modifyPw(String id, String password, String newPassword) {
	
	}

	public Map<String, AdminInfo> getAdminInfoList() {
		return adminInfoList;
	}

	public void setAdminInfoList(Map<String, AdminInfo> adminInfoList) {
		this.adminInfoList = adminInfoList;
	}

	@Override
	public String toString() {
		return "AdminInfoList [adminInfoList=" + adminInfoList + "]";
	}
	
/*	public AdminInfo searchInfo(String id) {
	
	}
	
	public int deleteInfo(String id) {
	
	}
	
	public int addAdminInfo(String id, String password) {
	
	}
	
	public int addAdminInfo(AdminInfo adminInfo) {
	
	}*/
	
}
