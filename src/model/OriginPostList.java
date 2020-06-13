package model;

import java.util.HashMap;
import java.util.Map;

public class OriginPostList {
	private Map<Integer, OriginPost> originPostList;
	public OriginPostList() {
		// TODO Auto-generated constructor stub
		originPostList = new HashMap<Integer, OriginPost>();
	}
	public OriginPostList(Map<Integer, OriginPost> originPostList) {
		super();
		this.originPostList = originPostList;
	}
	public Map<Integer, OriginPost> getOriginPostList() {
		return originPostList;
	}
	public void setOriginPostList(Map<Integer, OriginPost> originPostList) {
		this.originPostList = originPostList;
	}
	@Override
	public String toString() {
		return "OriginPostList [originPostList=" + originPostList + "]";
	}
	
}
