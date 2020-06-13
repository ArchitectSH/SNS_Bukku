package model;

import java.util.List;
import java.util.Map;
/**
 * ���������� �̸��� Ű������ �ϰ�, ���������� �������� value�� ������ �ִ� Map�� ĸ��ȭ �ϰ��ִ�Ŭ������.
 * ���ο� ���������� �����, ����, �������� �޼ҵ���� ĸ��ȭ �ϰ��ִ�.
 * @author ���
 *
 */
public class MyPageList {
	private Map<String, MyPage> myPageList;
	/**
	 * MyPageList�� ����Ʈ �������̴�.
	 */
	public MyPageList() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * MyPageList�� �Ķ���Ͱ� �մ� �������̴�. Ű���� ���������� �̸��̰�, value���� ���������� �����̴�.
	 * @param myPageList
	 */
	public MyPageList(Map<String, MyPage> myPageList) {
		super();
		this.myPageList = myPageList;
	}

	/**
	 * ĸ��ȭ �ϰ� �ִ� ����� myPageList�� �ܺ� Ŭ�������� ����ϰ��� �� �� �̿�Ǵ� �޼ҵ��̴�.
	 * @return the myPageList
	 */
	public Map<String, MyPage> getMyPageList() {
		return myPageList;
	}

	/**
	 * ĸ��ȭ �ϰ� �ִ� ����� myPageList�� ���� �ܺ� Ŭ�������� �ٲٰ��� �� �� ���ȴ�.
	 * @param myPageList the myPageList to set
	 */
	public void setMyPageList(Map<String, MyPage> myPageList) {
		this.myPageList = myPageList;
		//System.out.println("�ߵ��Դ�");
	}
	/**
	 * ���ο� ������������ ���鶧 ȣ��Ǵ� �޼ҵ��̴�. �������ڷ�
	 * String ���� masterId, String ���� myPageTitle, String ����  myPageImg, String ����  myPageIntroduction
	 * �� �޴´�.
	 * ĸ��ȭ�� ����� myPageList�� ���ο� ���������� ������ �߰��Ѵ�.
	 * @param masterId
	 * @param myPageTitle
	 * @param myPageImg
	 * @param myPageIntroduction
	 * @return int ��������
	 */
	public int makeMyPage(String masterId, String myPageTitle, String myPageImg, String myPageIntroduction) {
		MyPage mp = new MyPage(myPageIntroduction, masterId, new MyPagePublicInfo(myPageTitle, myPageImg));
		System.out.println(myPageTitle);
		myPageList.put(myPageTitle, mp);
		//System.out.println("�𵨿����´�! : "+mp);
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
	 * ĸ��ȭ �� ����� myPageList�� �̹� �����ϴ� ���������� ������ �����ϰ��� �� �� ���ȴ�.
	 * ��, ������ �� �ִ� ������ intro(�Ұ���)�̴�.
	 * @param title
	 * @param intro
	 * @return int ��������
	 */
	public int updateMyPageIntro(String title, String intro){
		MyPage mp = myPageList.get(title);
		mp.setMyPageIntroduction(intro);
		System.out.println("�𵨼���!!"+intro);
		return 1;
	}
}
