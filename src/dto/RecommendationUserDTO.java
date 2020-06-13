package dto;

import java.io.Serializable;

public class RecommendationUserDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4198050193943021083L;
	private int recommendationNo;
	private int recommendationKindNo;
	private int postNo;
	private String id;
	public RecommendationUserDTO() {
		// TODO Auto-generated constructor stub
	}
	public RecommendationUserDTO(int recommendationNo,
			int recommendationKindNo, int postNo, String id) {
		super();
		this.recommendationNo = recommendationNo;
		this.recommendationKindNo = recommendationKindNo;
		this.postNo = postNo;
		this.id = id;
	}
	public int getRecommendationNo() {
		return recommendationNo;
	}
	public void setRecommendationNo(int recommendationNo) {
		this.recommendationNo = recommendationNo;
	}
	public int getRecommendationKindNo() {
		return recommendationKindNo;
	}
	public void setRecommendationKindNo(int recommendationKindNo) {
		this.recommendationKindNo = recommendationKindNo;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "RecommendationUserDTO [recommendationNo=" + recommendationNo
				+ ", recommendationKindNo=" + recommendationKindNo
				+ ", postNo=" + postNo + ", id=" + id + "]";
	}
	
}
