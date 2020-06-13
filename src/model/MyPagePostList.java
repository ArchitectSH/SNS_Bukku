package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MyPagePostList {
	private Map<Integer, MyPagePost> myPagePostList;
	public MyPagePostList() {
		// TODO Auto-generated constructor stub
		myPagePostList = new HashMap<Integer, MyPagePost>();
	}
	public MyPagePostList(Map<Integer, MyPagePost> myPagePostList) {
		super();
		this.myPagePostList = myPagePostList;
	}
	public Map<Integer, MyPagePost> getMyPagePostList() {
		return myPagePostList;
	}
	public void setMyPagePostList(Map<Integer, MyPagePost> myPagePostList) {
		this.myPagePostList = myPagePostList;
	}
	public MyPagePost searchPost(int postNo){
		return myPagePostList.get(postNo);
	}
	public List<MyPagePost> searchMyPagePost(String myPageTitle){
		Collection<MyPagePost> posts = myPagePostList.values();
		Iterator<MyPagePost> it = posts.iterator();
		List<MyPagePost> searchedList = new ArrayList<MyPagePost>(); 
		while(it.hasNext()){
			MyPagePost myPagePost = it.next();
			if(myPagePost.getMyPageTitle().equals(myPageTitle))
				searchedList.add(myPagePost);
		}
		return searchedList;
	}
	public int deleteMyPagePost(int postNo){
		myPagePostList.remove(postNo);
		return myPagePostList.size();
	}
	public int deleteMyPagePost(String myPageTitle){
		Collection<MyPagePost> posts = myPagePostList.values();
		Iterator<MyPagePost> it = posts.iterator(); 
		while(it.hasNext()){
			MyPagePost myPagePost = it.next();
			if(myPagePost.getMyPageTitle().equals(myPageTitle))
				myPagePostList.remove(myPagePost.getPostNo());
		}
		return myPagePostList.size();
	}
	public int writeMyPagePost(MyPagePost myPagePost){
		myPagePostList.put(myPagePost.getPostNo(), myPagePost);
		return myPagePostList.size();
	}
	public int updateMyPagePost(MyPagePost myPagePost){
		MyPagePost mp = myPagePostList.get(myPagePost.getPostNo());
		mp.setPostContent(myPagePost.getPostContent());
		mp.setPrivacyLevel(myPagePost.getPrivacyLevel());
		return 1;
	}
	@Override
	public String toString() {
		return "MyPagePostList [myPagePostList=" + myPagePostList + "]";
	}
	

}
