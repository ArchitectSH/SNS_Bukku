package dao;
import java.sql.Connection;
import javax.sql.DataSource;
/**
 * 커넥션 풀을 리턴받아 올 수 있는 메소드를 캡슐화 하고 있는 인터페이스 이다.
 * 뿐만 아니라, DataSource를 세팅하는 메소드도 캡슐화 하고 있다.
 * @author 희빈
 *
 */
public interface DAO {
	/**
	 * DataSource를 파라미터로 받아서 세팅한다.
	 * @param dataSource
	 */
	void setDataSource(DataSource dataSource);
	/**
	 * 커넥션 풀을 리턴한다.
	 * @return 커넥션 풀
	 * @throws DAOException DAOException을 던진다.
	 */
	Connection getConnection() throws DAOException;
}
