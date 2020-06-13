package model;

import java.util.List;
import java.util.Map;
/**
 * 마이페이지 이름을 키값으로 하고, 마이페이지 정보들을 value로 가지고 있는 Map을 캡슐화 하고있는클래스다.
 * 새로운 마이페이지 만들기, 수정, 삭제등의 메소드들을 캡슐화 하고있다.
 * @author 희빈
 *
 */
public class MyPageList {
	private Map<String, MyPage> myPageList;
	/**
	 * MyPageList의 디폴트 생성자이다.
	 */
	public MyPageList() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * MyPageList의 파라메터가 잇는 생성자이다. 키값을 마이페이지 이름이고, value값은 마이페이지 정보이다.
	 * @param myPageList
	 */
	public MyPageList(Map<String, MyPage> myPageList) {
		super();
		this.myPageList = myPageList;
	}

	/**
	 * 캡슐화 하고 있는 멤버인 myPageList를 외부 클래스에서 사용하고자 할 때 이용되는 메소드이다.
	 * @return the myPageList
	 */
	public Map<String, MyPage> getMyPageList() {
		return myPageList;
	}

	/**
	 * 캡슐화 하고 있는 멤버인 myPageList의 값을 외부 클래스에서 바꾸고자 할 때 사용된다.
	 * @param myPageList the myPageList to set
	 */
	public void setMyPageList(Map<String, MyPage> myPageList) {
		this.myPageList = myPageList;
		//System.out.println("잘들어왔다");
	}
	/**
	 * 새로운 마이페이지를 만들때 호출되는 메소드이다. 전달인자로
	 * String 형인 masterId, String 형인 myPageTitle, String 형인  myPageImg, String 형인  myPageIntroduction
	 * 을 받는다.
	 * 캡슐화한 멤버인 myPageList에 새로운 마이페이지 정보를 추가한다.
	 * @param masterId
	 * @param myPageTitle
	 * @param myPageImg
	 * @param myPageIntroduction
	 * @return int 성공여부
	 */
	public int makeMyPage(String masterId, String myPageTitle, String myPageImg, String myPageIntroduction) {
		MyPage mp = new MyPage(myPageIntroduction, masterId, new MyPagePublicInfo(myPageTitle, myPageImg));
		System.out.println(myPageTitle);
		myPageList.put(myPageTitle, mp);
		//System.out.println("모델에들어온다! : "+mp);
		return 1;
	}
	
	public int blockMyPage(String blockId, String myPageTitle) {
		return 1;
	}
	
	public int inviteMyPage(String invitedId, String myPageTitle) {
		return 1;
	}
	
	public int removeMyPage(String myPageTitle) {
		myPageList.remove(myPageTitle);
		return 1;
	}
	
	public int followMyPage(String followerId, String myPageTitle) {
		return 1;
	}
	
	public int cancelFollowingMyPage(String cancelFollowerId, String myPageTitle) {
		return 1;
	}
	
	public List<MyPagePublicInfo> searchMyPageByMyPageTitle(String myPageTitle) {
		return null;
	}
	
	public List<MyPagePublicInfo> searchMyPageById(String masterId) {
		return null;
	}
	/**
	 * 캡슐화 된 멤버인 myPageList에 이미 존재하는 마이페이지 정보를 수정하고자 할 때 사용된다.
	 * 단, 수정할 수 있는 정보는 intro(소개글)이다.
	 * @param title
	 * @param intro
	 * @return int 성공여부
	 */
	public int updateMyPageIntro(String title, String intro){
		MyPage mp = myPageList.get(title);
		mp.setMyPageIntroduction(intro);
		System.out.println("모델수정!!"+intro);
		return 1;
	}
}
