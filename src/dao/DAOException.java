package dao;
/**
 * DAO에 관련된 사용자 정의 Exception이다.
 * 에러메시지 내용을 캡슐화 하고 있다.
 * @author 희빈
 *
 */
public class DAOException extends Exception {
	private static final long serialVersionUID = 19192L;
	/** 에러 내용을 저장할 멤버*/
	private String message;
	
	/**
	 * 사용자가 재정의한 디폴트 생성자 이다.
	 */
	public DAOException() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 캡슐화된 멤버인 message를 전달인자로 받는,
	 * 사용자가 재정의한 생성자이다.
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
