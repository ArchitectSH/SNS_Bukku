package model;

import java.util.List;



public class UserSetting {
	private boolean activated;
	private boolean stopped;
	private SearchLevel searchLevel;
	private List<Boolean> acceptingAlarm;
	public UserSetting() {
	
	}
	
	
	public UserSetting(boolean activated, boolean stopped,
			SearchLevel searchLevel, List<Boolean> acceptingAlarm) {
		super();
		this.activated = activated;
		this.stopped = stopped;
		this.searchLevel = searchLevel;
		this.acceptingAlarm = acceptingAlarm;
	}


	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public boolean isStopped() {
		return stopped;
	}

	public void setStopped(boolean stopped) {
		this.stopped = stopped;
	}

	public SearchLevel getSearchLevel() {
		return searchLevel;
	}

	public void setSearchLevel(SearchLevel searchLevel) {
		this.searchLevel = searchLevel;
	}

	public List<Boolean> getAcceptingAlarm() {
		return acceptingAlarm;
	}

	public void setAcceptingAlarm(List<Boolean> acceptingAlarm) {
		this.acceptingAlarm = acceptingAlarm;
	}

	@Override
	public String toString() {
		return "UserSetting [activated=" + activated + ", stopped=" + stopped
				+ ", searchLevel=" + searchLevel + ", acceptingAlarm="
				+ acceptingAlarm + "]";
	}
	
	
}
