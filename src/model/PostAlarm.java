package model;

public class PostAlarm {
	private int postNo;
	private UserAlarm userAlarm;
	public PostAlarm() {
		// TODO Auto-generated constructor stub
	}
	public PostAlarm(int postNo, UserAlarm userAlarm) {
		super();
		this.postNo = postNo;
		this.userAlarm = userAlarm;
	}
	/**
	 * @return the postNo
	 */
	public int getPostNo() {
		return postNo;
	}
	/**
	 * @param postNo the postNo to set
	 */
	public void setPostNo(int postNo) {
		this.postNo = postNo;
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
		return "PostAlarm [postNo=" + postNo + ", userAlarm=" + userAlarm + "]";
	}
}
