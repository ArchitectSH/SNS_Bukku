package dto;

public class UserEnvironmentSettingDTO {
	private String id;
	private int privacyLevel;
	private boolean deactivation;
	private boolean userStop;
	public UserEnvironmentSettingDTO() {
		// TODO Auto-generated constructor stub
	}
	public UserEnvironmentSettingDTO(String id, int privacyLevel,
			boolean deactivation, boolean userStop) {
		super();
		this.id = id;
		this.privacyLevel = privacyLevel;
		this.deactivation = deactivation;
		this.userStop = userStop;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPrivacyLevel() {
		return privacyLevel;
	}
	public void setPrivacyLevel(int privacyLevel) {
		this.privacyLevel = privacyLevel;
	}
	public boolean isDeactivation() {
		return deactivation;
	}
	public void setDeactivation(boolean deactivation) {
		this.deactivation = deactivation;
	}
	public boolean isUserStop() {
		return userStop;
	}
	public void setUserStop(boolean userStop) {
		this.userStop = userStop;
	}
	@Override
	public String toString() {
		return "UserEnvironmentSettingDTO [id=" + id + ", privacyLevel="
				+ privacyLevel + ", deactivation=" + deactivation
				+ ", userStop=" + userStop + "]";
	}
	
	
}
