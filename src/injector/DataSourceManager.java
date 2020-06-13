package injector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

public class DataSourceManager {
	private static DataSourceManager dataSourceManager;
	private DataSource dataSource;
	
	public static synchronized DataSourceManager getInstance(){
		if(dataSourceManager == null){
			dataSourceManager = new DataSourceManager();
			dataSourceManager.start();
			return dataSourceManager;
		}
		return dataSourceManager;
	}
	public DataSource getDataSource(){
		return dataSource;
	}
	public void start(){
		//dataSource ����
		//lookup for tomcat
	
		//ComboPool for unit test
		if(dataSource == null){
			ComboPooledDataSource cpds = new ComboPooledDataSource();
			try {
				cpds.setDriverClass("oracle.jdbc.driver.OracleDriver");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			cpds.setJdbcUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
			cpds.setUser("bukku");
			cpds.setPassword("bukku");
			
			//�⺻ ���� �������̵�
			cpds.setMinPoolSize(5);
			cpds.setAcquireIncrement(5);
			cpds.setMaxPoolSize(20);
			dataSource = cpds;
			System.out.println("dataSource is set by comboPool.");
		}
	}
	
	/**
	 * DI���Ž��� ó���� �����Ѵ�. dataSource�� �����Ѵ�.
	 */
	public void shutDown(){
		//dataSource ����
		try {
			DataSources.destroy(dataSource);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
