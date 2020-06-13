package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

/**
 * DataSource를 캡슐화 하고 있는 클래스로, DAO 인터페이스에 있는 메소드를 구현한다.
 * 추가로 DB관련 객체를 close() 해주는 메소드가 있다.
 * @author 희빈
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
