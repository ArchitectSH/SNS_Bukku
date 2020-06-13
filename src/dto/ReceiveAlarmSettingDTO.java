package dto;

public class ReceiveAlarmSettingDTO {
	private String id;
	private boolean postReceiveAlarm;
	private boolean commentReceiveAlarm;
	private boolean communityReceiveAlarm;
	private boolean warningReceiveAlarm;
	public ReceiveAlarmSettingDTO() {
		// TODO Auto-generated constructor stub
	}
	public ReceiveAlarmSettingDTO(String id, boolean postReceiveAlarm,
			boolean commentReceiveAlarm, boolean communityReceiveAlarm,
			boolean warningReceiveAlarm) {
		super();
		this.id = id;
		this.postReceiveAlarm = postReceiveAlarm;
		this.commentReceiveAlarm = commentReceiveAlarm;
		this.communityReceiveAlarm = communityReceiveAlarm;
		this.warningReceiveAlarm = warningReceiveAlarm;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isPostReceiveAlarm() {
		return postReceiveAlarm;
	}
	public void setPostReceiveAlarm(boolean postReceiveAlarm) {
		this.postReceiveAlarm = postReceiveAlarm;
	}
	public boolean isCommentReceiveAlarm() {
		return commentReceiveAlarm;
	}
	public void setCommentReceiveAlarm(boolean commentReceiveAlarm) {
		this.commentReceiveAlarm = commentReceiveAlarm;
	}
	public boolean isCommunityReceiveAlarm() {
		return communityReceiveAlarm;
	}
	public void setCommunityReceiveAlarm(boolean communityReceiveAlarm) {
		this.communityReceiveAlarm = communityReceiveAlarm;
	}
	public boolean isWarningReceiveAlarm() {
		return warningReceiveAlarm;
	}
	public void setWarningReceiveAlarm(boolean warningReceiveAlarm) {
		this.warningReceiveAlarm = warningReceiveAlarm;
	}
	@Override
	public String toString() {
		return "ReceiveAlarmSettingDTO [id=" + id + ", postReceiveAlarm="
				+ postReceiveAlarm + ", commentReceiveAlarm="
				+ commentReceiveAlarm + ", communityReceiveAlarm="
				+ communityReceiveAlarm + ", warningReceiveAlarm="
				+ warningReceiveAlarm + "]";
	}
	
	
}
