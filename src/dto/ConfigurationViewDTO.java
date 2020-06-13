package dto;

public class ConfigurationViewDTO {
	private String userId;
	private int privacyLevel;
	private boolean postReceiveAlarm;
	private boolean commentReceiveAlarm;
	private boolean communityReceiveAlarm;
	private boolean warningReceiveAlarm;
	public ConfigurationViewDTO() {
		super();
	}
	public ConfigurationViewDTO(String userId, int privacyLevel,
			boolean postReceiveAlarm, boolean commentReceiveAlarm,
			boolean communityReceiveAlarm, boolean warningReceiveAlarm) {
		super();
		this.userId = userId;
		this.privacyLevel = privacyLevel;
		this.postReceiveAlarm = postReceiveAlarm;
		this.commentReceiveAlarm = commentReceiveAlarm;
		this.communityReceiveAlarm = communityReceiveAlarm;
		this.warningReceiveAlarm = warningReceiveAlarm;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getPrivacyLevel() {
		return privacyLevel;
	}
	public void setPrivacyLevel(int privacyLevel) {
		this.privacyLevel = privacyLevel;
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
	
	public String toString() {
		return "ConfigurationViewDTO [userId=" + userId + ", privacyLevel="
				+ privacyLevel + ", postReceiveAlarm=" + postReceiveAlarm
				+ ", commentReceiveAlarm=" + commentReceiveAlarm
				+ ", communityReceiveAlarm=" + communityReceiveAlarm
				+ ", warningReceiveAlarm=" + warningReceiveAlarm + "]";
	}
	
	

}
