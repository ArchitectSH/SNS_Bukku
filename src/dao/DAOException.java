package dao;
/**
 * DAO�� ���õ� ����� ���� Exception�̴�.
 * �����޽��� ������ ĸ��ȭ �ϰ� �ִ�.
 * @author ���
 *
 */
public class DAOException extends Exception {
	private static final long serialVersionUID = 19192L;
	/** ���� ������ ������ ���*/
	private String message;
	
	/**
	 * ����ڰ� �������� ����Ʈ ������ �̴�.
	 */
	public DAOException() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * ĸ��ȭ�� ����� message�� �������ڷ� �޴�,
	 * ����ڰ� �������� �������̴�.
	 * @param message
	 */
	public DAOException(String message){
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return message;
	}
	
}
