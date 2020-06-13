package model;
/**
 * ���������� �Ұ���, ���������� �������� ID, ���������� ��������(���������� �̸�, ���������� �̹���)�� ĸ��ȭ �ϰ� �ִ�.
 * @author ���
 *
 */
public class MyPage {
	/*���������� �Ұ��۷� ������������ �����Ѵ�.*/
	private String myPageIntroduction;
	/*������������ ������ ������� ���̵� ��Ÿ����.*/
	private String myPageMaster;
	/*���������� ��������(���������� �̸�, ���������� �̹���)�� ĸ��ȭ �� ��ü�̴�.*/
	private MyPagePublicInfo myPagePublicInfo;
	/**
	 * ����Ʈ ������
	 */
	public MyPage() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * ���������� Ŭ������ ĸ��ȭ ��� ��ü�� �޴� �������̴�.
	 */
	public MyPage(String myPageIntroduction, String myPageMaster,
			MyPagePublicInfo myPagePublicInfo) {
		super();
		this.myPageIntroduction = myPageIntroduction;
		this.myPageMaster = myPageMaster;
		this.myPagePublicInfo = myPagePublicInfo;
	}
	/**
	 * ĸ��ȭ �ϰ� �ִ� ����� ���������� �Ұ����� �ܺ� Ŭ�������� ����ϰ��� �� �� ���ȴ�.
	 * @return the myPageIntroduction
	 */
	public String getMyPageIntroduction() {
		return myPageIntroduction;
	}
	/**
	 * ĸ��ȭ �ϰ� �ִ� ����� ���������� ������ ID�� ���� �ܺ� Ŭ�������� �ٲٰ��� �� �� ���ȴ�.
	 * @param myPageIntroduction the myPageIntroduction to set
	 */
	public void setMyPageIntroduction(String myPageIntroduction) {
		this.myPageIntroduction = myPageIntroduction;
	}
	/**
	 * ĸ��ȭ �ϰ� �ִ� ����� ���������� ������ ID�� �ܺ� Ŭ�������� ����ϰ��� �� �� ���ȴ�.
	 * @return the myPageMaster
	 */
	public String getMyPageMaster() {
		return myPageMaster;
	}
	/**
	 * ĸ��ȭ �ϰ� �ִ� ����� ���������� ��������(���������� �̸�, ���������� �̹���)�� ���� 
	 * �ܺ� Ŭ�������� �ٲٰ��� �� �� ���ȴ�.
	 * @param myPageMaster the myPageMaster to set
	 */
	public void setMyPageMaster(String myPageMaster) {
		this.myPageMaster = myPageMaster;
	}
	/**
	 * ĸ��ȭ �ϰ� �ִ� ����� ���������� ��������(���������� �̸�, ���������� �̹���)�� 
	 * �ܺ� Ŭ�������� ����ϰ��� �� �� ���ȴ�.
	 * @return the myPagePublicInfo
	 */
	public MyPagePublicInfo getMyPagePublicInfo() {
		return myPagePublicInfo;
	}
	/**
	 * ĸ��ȭ �ϰ� �ִ� ����� ���������� �Ұ����� ���� �ܺ� Ŭ�������� �ٲٰ��� �� �� ���ȴ�.
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
