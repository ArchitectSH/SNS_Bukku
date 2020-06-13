package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class CommentList {
	private Map<Integer,Map<Integer,Comment>> commentList;
	public CommentList() {
		// TODO Auto-generated constructor stub
		commentList = new HashMap<Integer,Map<Integer,Comment>>();
	}
	public CommentList(Map<Integer, Map<Integer, Comment>> commentList) {
		super();
		this.commentList = commentList;
	}
	public Map<Integer, Map<Integer, Comment>> getCommentList() {
		return commentList;
	}
	public void setCommentList(Map<Integer, Map<Integer, Comment>> commentList) {
		this.commentList = commentList;
	}
	@Override
	public String toString() {
		return "CommentList [commentList=" + commentList + "]";
	}
	public int writeComment(int postNo, Comment comment){
		if(commentList.get(postNo)==null){
			Map<Integer,Comment> comments = new HashMap<Integer,Comment>();
			comments.put(comment.getCommentNo(),comment);
			commentList.put(postNo, comments);
		}
		commentList.get(postNo).put(comment.getCommentNo(), comment);
		return commentList.size();
	}
	public int modifyComment(int postNo, Comment comment){
		Comment originComment = commentList.get(postNo).get(comment.getCommentNo());
		if(originComment!=null){
			originComment.setCommentContent(comment.getCommentContent());
			originComment.setPrivacyLevel(comment.getPrivacyLevel());
		}
		return 1;
	}
	public List<Comment> searchComment(String tagFriendId){
		Collection<Map<Integer, Comment>> comments = commentList.values();
		Iterator<Map<Integer, Comment>> it = comments.iterator();
		List<Comment> searchedList = null;
		while(it.hasNext()){
			Map<Integer, Comment> commentMap = it.next(); 
			Collection<Comment> comments2 = commentMap.values();
			Iterator<Comment> it2 = comments2.iterator();
			while(it2.hasNext()){
				Comment c = it2.next();
				Map<String, String> tagFriends = c.getCommentContent().getTagFriends();
				Set<String> friendIds = tagFriends.keySet();
				Iterator<String> it3 = friendIds.iterator();
				while(it3.hasNext()){
					String friendId = it3.next();
					if(friendId.equals(tagFriendId)){
						if(searchedList==null){
							searchedList = new ArrayList<Comment>();
						}
						searchedList.add(c);
					}
				}
			}
		}
		return searchedList;
	}
	public int deleteComment(int commentNo){
		Collection<Map<Integer, Comment>> comments = commentList.values();
		Iterator<Map<Integer, Comment>> it = comments.iterator();
		while(it.hasNext()){
			Map<Integer, Comment> commentMap = it.next();
			Set<Integer> commentNoSet = commentMap.keySet();
			Iterator<Integer> it2 = commentNoSet.iterator();
			while(it2.hasNext()){
				if(it2.next()==commentNo){
					commentMap.remove(commentNo);
				}
			}
		}
		return 1;
	}
}
