package dto;

import java.io.Serializable;

public class RecommendationKindDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5954612493029789848L;
	private int recommendationKindNo;
	private String recommendationKind;
	public RecommendationKindDTO() {
		// TODO Auto-generated constructor stub
	}
	public RecommendationKindDTO(int recommendationKindNo,
			String recommendationKind) {
		super();
		this.recommendationKindNo = recommendationKindNo;
		this.recommendationKind = recommendationKind;
	}
	public int getRecommendationKindNo() {
		return recommendationKindNo;
	}
	public void setRecommendationKindNo(int recommendationKindNo) {
		this.recommendationKindNo = recommendationKindNo;
	}
	public String getRecommendationKind() {
		return recommendationKind;
	}
	public void setRecommendationKind(String recommendationKind) {
		this.recommendationKind = recommendationKind;
	}
	@Override
	public String toString() {
		return "RecommendationKindDTO [recommendationKindNo="
				+ recommendationKindNo + ", recommendationKind="
				+ recommendationKind + "]";
	}
	
}
