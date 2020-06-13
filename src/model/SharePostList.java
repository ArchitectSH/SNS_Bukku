package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SharePostList {
	private  Map<Integer, SharePost> sharePostList;
	public SharePostList() {
		// TODO Auto-generated constructor stub
		sharePostList = new HashMap<Integer, SharePost>();
	}
	public SharePostList(Map<Integer, SharePost> sharePostList) {
		super();
		this.sharePostList = sharePostList;
	}
	public List<SharePost> searchLinkedOriginPost(int originPostNo){
		Collection<SharePost> posts = sharePostList.values();
		Iterator<SharePost> it = posts.iterator();
		List<SharePost> searchedList = new ArrayList<SharePost>(); 
		while(it.hasNext()){
			SharePost sharePost = it.next();
			if(sharePost.getOriginPost().getOriginPostNo()==originPostNo)
				searchedList.add(sharePost);
		}
		return searchedList;
	}
	public int updatePost(SharePost sharePost){
		SharePost sp = sharePostList.get(sharePost.getPostNo());
		sp.getOriginPost().getOriginContent().setContent(sharePost.getOriginPost().getOriginContent().getContent());
		sp.setPostContent(sharePost.getPostContent());
		sp.setPrivacyLevel(sharePost.getPrivacyLevel());
		return sharePostList.size();
	}
	public int writePost(SharePost sharePost){
		sharePostList.put(sharePost.getPostNo(), sharePost);
		return sharePostList.size();
	}
	public int deletePost(int postNo){
		sharePostList.remove(postNo);
		return sharePostList.size();
	}
	public int deleteLinkedOriginPost(int originPostNo){
		Collection<SharePost> posts = sharePostList.values();
		Iterator<SharePost> it = posts.iterator(); 
		while(it.hasNext()){
			SharePost sharePost = it.next();
			if(sharePost.getOriginPost().getOriginPostNo()==originPostNo)
				sharePostList.remove(sharePost.getPostNo());
		}
		return sharePostList.size();
	}
	public SharePost searchPost(int postNo){
		return sharePostList.get(postNo);
	}
	public Map<Integer, SharePost> getSharePostList() {
		return sharePostList;
	}
	public void setSharePostList(Map<Integer, SharePost> sharePostList) {
		this.sharePostList = sharePostList;
	}
	@Override
	public String toString() {
		return "SharePostList [sharePostList=" + sharePostList + "]";
	}
	

}
