package model;

import java.util.HashMap;
import java.util.Map;

public class RecommendationUsersList {
	private Map<Integer,RecommendationUsers> recommendationUsersList;
	public RecommendationUsersList() {
		// TODO Auto-generated constructor stub
		recommendationUsersList = new HashMap<Integer,RecommendationUsers>();
	}
	public RecommendationUsersList(
			Map<Integer, RecommendationUsers> recommendationUsersList) {
		super();
		this.recommendationUsersList = recommendationUsersList;
	}
	public Map<Integer, RecommendationUsers> getRecommendationUsersList() {
		return recommendationUsersList;
	}
	public void setRecommendationUsersList(
			Map<Integer, RecommendationUsers> recommendationUsersList) {
		this.recommendationUsersList = recommendationUsersList;
	}
	public int addRecommendation(int postNo, RecommendationUsers recommendationUsers){
		recommendationUsersList.put(postNo, recommendationUsers);
		return recommendationUsersList.size();
	}
	public int cancelLike(int postNo, UserPublicInfo likeUserInfo){
		recommendationUsersList.get(postNo).cancelLike(likeUserInfo);
		return 1;
	}
	public int cancelBukku(int postNo, UserPublicInfo bukkuUserInfo){
		recommendationUsersList.get(postNo).cancelBukku(bukkuUserInfo);
		return 1;
	}
	public int cancelHate(int postNo, UserPublicInfo hateUserInfo){
		recommendationUsersList.get(postNo).cancelHate(hateUserInfo);
		return 1;
	}
	int selectLike(int postNo, UserPublicInfo likeUserInfo){
		RecommendationUsers ru = recommendationUsersList.get(postNo);
		ru.addLike(likeUserInfo);
		return 1;
	}
	int selectBukku(int postNo, UserPublicInfo bukkuUserInfo){
		RecommendationUsers ru = recommendationUsersList.get(postNo);
		ru.addBukku(bukkuUserInfo);
		return 1;
	}
	int selectHate(int postNo, UserPublicInfo hateUserInfo){
		RecommendationUsers ru = recommendationUsersList.get(postNo);
		ru.addHate(hateUserInfo);
		return 1;
	}
	@Override
	public String toString() {
		return "RecommendationUsersList [recommendationUsersList="
				+ recommendationUsersList + "]";
	}

}
