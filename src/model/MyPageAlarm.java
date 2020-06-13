package model;

public class MyPageAlarm {
	private String mypageTitle;
	private UserAlarm userAlarm;
	public MyPageAlarm() {
		// TODO Auto-generated constructor stub
	}
	public MyPageAlarm(String mypageTitle, UserAlarm userAlarm) {
		super();
		this.mypageTitle = mypageTitle;
		this.userAlarm = userAlarm;
	}
	/**
	 * @return the mypageTitle
	 */
	public String getMypageTitle() {
		return mypageTitle;
	}
	/**
	 * @param mypageTitle the mypageTitle to set
	 */
	public void setMypageTitle(String mypageTitle) {
		this.mypageTitle = mypageTitle;
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
		return "MyPageAlarm [mypageTitle=" + mypageTitle + ", userAlarm="
				+ userAlarm + "]";
	}
	
}
