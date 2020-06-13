package dao;
import java.sql.Connection;
import javax.sql.DataSource;
/**
 * Ŀ�ؼ� Ǯ�� ���Ϲ޾� �� �� �ִ� �޼ҵ带 ĸ��ȭ �ϰ� �ִ� �������̽� �̴�.
 * �Ӹ� �ƴ϶�, DataSource�� �����ϴ� �޼ҵ嵵 ĸ��ȭ �ϰ� �ִ�.
 * @author ���
 *
 */
public interface DAO {
	/**
	 * DataSource�� �Ķ���ͷ� �޾Ƽ� �����Ѵ�.
	 * @param dataSource
	 */
	void setDataSource(DataSource dataSource);
	/**
	 * Ŀ�ؼ� Ǯ�� �����Ѵ�.
	 * @return Ŀ�ؼ� Ǯ
	 * @throws DAOException DAOException�� ������.
	 */
	Connection getConnection() throws DAOException;
}
