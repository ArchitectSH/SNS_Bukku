package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

/**
 * DataSource�� ĸ��ȭ �ϰ� �ִ� Ŭ������, DAO �������̽��� �ִ� �޼ҵ带 �����Ѵ�.
 * �߰��� DB���� ��ü�� close() ���ִ� �޼ҵ尡 �ִ�.
 * @author ���
 *
 */
public class BaseDAO implements DAO {
	private DataSource dataSource;
	
	@Override
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		this.dataSource = dataSource;
	}

	@Override
	public Connection getConnection() throws DAOException {
		// TODO Auto-generated method stub
		try{
			return dataSource.getConnection();
		}
		catch(Exception e){
			e.printStackTrace();
			throw new DAOException();
		}
	}
	protected void closeDBObjects(ResultSet rs, Statement stmt, Connection conn){
		if(rs != null){
			try{
				rs.close();
			}
			catch(Exception e){
			}
		}
		if(stmt != null){
			try{
				stmt.close();
			}
			catch(Exception e){
			}
		}
		if(conn != null){
			try{
				conn.close();
			}
			catch(Exception e){
			}
		}
	}
}
