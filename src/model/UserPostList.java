package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UserPostList {
	private Map<Integer, UserPost> userPostList;
	public UserPostList() {
		// TODO Auto-generated constructor stub
		userPostList = new HashMap<Integer, UserPost>();
	}
	public UserPostList(Map<Integer, UserPost> userPostList) {
		super();
		this.userPostList = userPostList;
	}
	public Map<Integer, UserPost> getUserPostList() {
		return userPostList;
	}
	public void setUserPostList(Map<Integer, UserPost> userPostList) {
		this.userPostList = userPostList;
	}
	public UserPost searchPost(int postNo){
		return userPostList.get(postNo);
	}
	public List<UserPost> searchPost(String startDate, String endDate){
		SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		List<UserPost> searchedList = null;
		try {
			Date date = formatter.parse(startDate);
			Date date2 = formatter.parse(endDate);
			Date date3 = null;
			Collection<UserPost> posts = userPostList.values();
			Iterator<UserPost> it = posts.iterator();
			searchedList = new ArrayList<UserPost>(); 
			while(it.hasNext()){
				UserPost userPost = it.next();
				date3 = formatter.parse(userPost.getPostingTime());
				if(date3.getTime()<=date2.getTime() && date3.getTime()>=date.getTime()){
					searchedList.add(userPost);
				}
			}
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return searchedList;
	}
	public List<UserPost> searhPost(String content){
		Collection<UserPost> posts = userPostList.values();
		Iterator<UserPost> it = posts.iterator();
		List<UserPost> searchedList = new ArrayList<UserPost>(); 
		while(it.hasNext()){
			UserPost userPost = it.next();
			if(userPost.getPostContent().getContent().contains(content))
				searchedList.add(userPost);
		}
		return searchedList;
	}
	public int writePost(UserPost userPost){
		userPostList.put(userPost.getPostNo(), userPost);
		return userPostList.size();
	}
	public int deletePost(int postNo){
		userPostList.remove(postNo);
		return userPostList.size();
	}
	public int modifyPost(UserPost userPost){
		UserPost up = userPostList.get(userPost.getPostNo());
		if(up!=null){
			up.setPostContent(userPost.getPostContent());
			up.setPrivacyLevel(userPost.getPrivacyLevel());
		}
		return 1;
	}
	@Override
	public String toString() {
		return "UserPostList [userPostList=" + userPostList + "]";
	}
	
}
