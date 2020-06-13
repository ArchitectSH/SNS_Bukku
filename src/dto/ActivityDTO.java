package dto;

public class ActivityDTO {
	private int activityNo;
	private String activityKind;
	public ActivityDTO() {
		// TODO Auto-generated constructor stub
	}
	public ActivityDTO(int activityNo, String activityKind) {
		super();
		this.activityNo = activityNo;
		this.activityKind = activityKind;
	}
	public int getActivityNo() {
		return activityNo;
	}
	public void setActivityNo(int activityNo) {
		this.activityNo = activityNo;
	}
	public String getActivityKind() {
		return activityKind;
	}
	public void setActivityKind(String activityKind) {
		this.activityKind = activityKind;
	}
	@Override
	public String toString() {
		return "ActivityDTO [activityNo=" + activityNo + ", activityKind="
				+ activityKind + "]";
	}
	
	
}
