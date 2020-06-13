package model;
/**
 * 마이페이지 소개글, 마이페이지 개설자의 ID, 마이페이지 공개정보(마이페이지 이름, 마이페이지 이미지)를 캡슐화 하고 있다.
 * @author 희빈
 *
 */
public class MyPage {
	/*마이페이지 소개글로 마이페이지를 설명한다.*/
	private String myPageIntroduction;
	/*마이페이지를 개설한 사용자의 아이디를 나타낸다.*/
	private String myPageMaster;
	/*마이페이지 공개정보(마이페이지 이름, 마이페이지 이미지)를 캡슐화 한 객체이다.*/
	private MyPagePublicInfo myPagePublicInfo;
	/**
	 * 디폴트 생성자
	 */
	public MyPage() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 마이페이지 클래스의 캡슐화 멤버 전체를 받는 생성자이다.
	 */
	public MyPage(String myPageIntroduction, String myPageMaster,
			MyPagePublicInfo myPagePublicInfo) {
		super();
		this.myPageIntroduction = myPageIntroduction;
		this.myPageMaster = myPageMaster;
		this.myPagePublicInfo = myPagePublicInfo;
	}
	/**
	 * 캡슐화 하고 있는 멤버인 마이페이지 소개글을 외부 클래스에서 사용하고자 할 때 사용된다.
	 * @return the myPageIntroduction
	 */
	public String getMyPageIntroduction() {
		return myPageIntroduction;
	}
	/**
	 * 캡슐화 하고 있는 멤버인 마이페이지 개설자 ID의 값을 외부 클래스에서 바꾸고자 할 때 사용된다.
	 * @param myPageIntroduction the myPageIntroduction to set
	 */
	public void setMyPageIntroduction(String myPageIntroduction) {
		this.myPageIntroduction = myPageIntroduction;
	}
	/**
	 * 캡슐화 하고 있는 멤버인 마이페이지 개설자 ID를 외부 클래스에서 사용하고자 할 때 사용된다.
	 * @return the myPageMaster
	 */
	public String getMyPageMaster() {
		return myPageMaster;
	}
	/**
	 * 캡슐화 하고 있는 멤버인 마이페이지 공개정보(마이페이지 이름, 마이페이지 이미지)의 값을 
	 * 외부 클래스에서 바꾸고자 할 때 사용된다.
	 * @param myPageMaster the myPageMaster to set
	 */
	public void setMyPageMaster(String myPageMaster) {
		this.myPageMaster = myPageMaster;
	}
	/**
	 * 캡슐화 하고 있는 멤버인 마이페이지 공개정보(마이페이지 이름, 마이페이지 이미지)를 
	 * 외부 클래스에서 사용하고자 할 때 사용된다.
	 * @return the myPagePublicInfo
	 */
	public MyPagePublicInfo getMyPagePublicInfo() {
		return myPagePublicInfo;
	}
	/**
	 * 캡슐화 하고 있는 멤버인 마이페이지 소개글의 값을 외부 클래스에서 바꾸고자 할 때 사용된다.
	 * @param myPagePublicInfo the myPagePublicInfo to set
	 */
	public void setMyPagePublicInfo(MyPagePublicInfo myPagePublicInfo) {
		this.myPagePublicInfo = myPagePublicInfo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MyPage [myPageIntroduction=" + myPageIntroduction
				+ ", myPageMaster=" + myPageMaster + ", myPagePublicInfo="
				+ myPagePublicInfo + "]";
	}
	
}
