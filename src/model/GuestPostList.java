package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GuestPostList {
	private Map<Integer, GuestPost> guestPostList;
	public GuestPostList() {
		// TODO Auto-generated constructor stub
		guestPostList = new HashMap<Integer, GuestPost>();
	}
	public GuestPostList(Map<Integer, GuestPost> guestPostList) {
		super();
		this.guestPostList = guestPostList;
	}
	public Map<Integer, GuestPost> getGuestPostList() {
		return guestPostList;
	}
	public void setGuestPostList(Map<Integer, GuestPost> guestPostList) {
		this.guestPostList = guestPostList;
	}
	public List<GuestPost> searchGuestPost(String receiverId){
		Collection<GuestPost> posts = guestPostList.values();
		Iterator<GuestPost> it = posts.iterator();
		List<GuestPost> searchedList = new ArrayList<GuestPost>(); 
		while(it.hasNext()){
			GuestPost guestPost = it.next();
			if(guestPost.getReceiverId().equals(receiverId))
				searchedList.add(guestPost);
		}
		return searchedList;
	}
	public GuestPost searchGuestPost(int postNo){
		return guestPostList.get(postNo);
	}
	public int deleteGuestPost(int postNo){
		guestPostList.remove(postNo);
		return guestPostList.size();
	}
	public int writeGuestPost(GuestPost guestPost){
		guestPostList.put(guestPost.getPostNo(), guestPost);
		return guestPostList.size();
	}
	@Override
	public String toString() {
		return "GuestPostList [guestPostList=" + guestPostList + "]";
	}
	

}
