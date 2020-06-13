package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ReportUserInfoList {
	private  Map<Integer,List<UserPublicInfo>> reportUserInfos;
	public ReportUserInfoList() {
		// TODO Auto-generated constructor stub
		reportUserInfos = new HashMap<Integer,List<UserPublicInfo>>();
	}
	
	public ReportUserInfoList(Map<Integer, List<UserPublicInfo>> reportUserInfos) {
		super();
		this.reportUserInfos = reportUserInfos;
	}
	public Map<Integer, List<UserPublicInfo>> getReportUserInfos() {
		return reportUserInfos;
	}
	public void setReportUserInfos(
			Map<Integer, List<UserPublicInfo>> reportUserInfos) {
		this.reportUserInfos = reportUserInfos;
	}
	public int addReportingUser(int postNo, UserPublicInfo userPublicInfo){
		if(reportUserInfos.get(postNo)==null){
			ArrayList<UserPublicInfo> list = new ArrayList<UserPublicInfo>();
			list.add(userPublicInfo);
			reportUserInfos.put(postNo, list);
		}else{
			List<UserPublicInfo> list = reportUserInfos.get(postNo);
			list.add(userPublicInfo);
		}
		return reportUserInfos.size();
	}
	public List<UserPublicInfo> searchReportUsers(int postNo){
		return reportUserInfos.get(postNo);
	}
	public int deleteReportUser(int postNo, String userId){
		List<UserPublicInfo> list = reportUserInfos.get(postNo);
		if(list!=null){
			Iterator<UserPublicInfo> it = list.iterator();
			int index = 0;
			while(it.hasNext()){
				UserPublicInfo upi = it.next();
				if(upi.getId().equals(userId)){
					list.remove(index);
				}
				index++;
			}
		}
		return list.size();
	}
	@Override
	public String toString() {
		return "ReportUserInfoList [reportUserInfos=" + reportUserInfos + "]";
	}
	
}
