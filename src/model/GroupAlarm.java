package model;

public class GroupAlarm {
	private int groupNo;
	private UserAlarm userAlarm;
	public GroupAlarm() {
		// TODO Auto-generated constructor stub
	}
	public GroupAlarm(int groupNo, UserAlarm userAlarm) {
		super();
		this.groupNo = groupNo;
		this.userAlarm = userAlarm;
	}
	/**
	 * @return the groupNo
	 */
	public int getGroupNo() {
		return groupNo;
	}
	/**
	 * @param groupNo the groupNo to set
	 */
	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
	/**
	 * @return the userAlarm
	 */
	public UserAlarm getUserAlarm() {
		return userAlarm;
	}
	/**
	 * @param userAlarm the userAlarm to set
	 */
	public void setUserAlarm(UserAlarm userAlarm) {
		this.userAlarm = userAlarm;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GroupAlarm [groupNo=" + groupNo + ", userAlarm=" + userAlarm
				+ "]";
	}
	
}
