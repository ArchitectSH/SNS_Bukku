package dao;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

public class DependencyInjector {
	/**DB관련 정보를 갖는 필드*/
	private DataSource dataSource;
	
	public void start(){
		//dataSource 생성
		//lookup for tomcat
		try {
			Context context = new InitialContext();
			//Context envContext = (Context)context.lookup("java:/comp/env");
			//dataSource = (DataSource)envContext.lookup("jdbc/myoracle");
			dataSource = (DataSource)context.lookup("java:/comp/env/jdbc/myoracle");
			System.out.println("dataSource is set by lookup.");
		} catch (NamingException e) {
			// TODO: handle exception
		}
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
			
			//기본 설정 오버라이드
			cpds.setMinPoolSize(5);
			cpds.setAcquireIncrement(5);
			cpds.setMaxPoolSize(20);
			dataSource = cpds;
			System.out.println("dataSource is set by comboPool.");
		}
	}
	
	/**
	 * DI제거시의 처리를 수행한다. dataSource를 제거한다.
	 */
	public void shutDown(){
		//dataSource 제거
		try {
			DataSources.destroy(dataSource);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	public CommentTagUserDAO createCommentTagUserDAO(){
		CommentTagUserDAO ctud = new CommentTagUserDAOImpl();
		ctud.setDataSource(dataSource);
		return ctud;
	}
	public CommentDAO createCommentDAO(){
		CommentDAO commentDAO = new CommentDAOImpl();
		commentDAO.setDataSource(dataSource);
		return commentDAO;
	}
	public GroupPostDAO createGroupPostDAO(){
		GroupPostDAO gpd = new GroupPostDAOImpl();
		gpd.setDataSource(dataSource);
		return gpd;
	}
	
	public GuestPostDAO createGuestPostDAO(){
		GuestPostDAO gpd = new GuestPostDAOImpl();
		gpd.setDataSource(dataSource);
		return gpd;
	}
	public HelpDAO createHelpDAO(){
		HelpDAO hd = new HelpDAOImpl();
		hd.setDataSource(dataSource);
		return hd;
	}
	
	public ImageContentDAO createImageContentDAO(){
		ImageContentDAO icd = new ImageContentDAOImpl();
		icd.setDataSource(dataSource);
		return icd;
	}
	
	public MyPagePostDAO createMyPagePostDAO(){
		MyPagePostDAO pd = new MyPagePostDAOImpl();
		pd.setDataSource(dataSource);
		return pd;
	}
	
	public NoticeDAO createNoticeDAO(){
		NoticeDAO nd = new NoticeDAOImpl();
		nd.setDataSource(dataSource);
		return nd;
	}
	
	public OpinionDAO createOpinionDAO(){
		OpinionDAO od = new OpinionDAOImpl();
		od.setDataSource(dataSource);
		return od;
	}
	
	public PostContentDAO createPostContentDAO(){
		PostContentDAO pcd = new PostContentDAOImpl();
		pcd.setDataSource(dataSource);
		return pcd;
	}
	
	public PostDAO createPostDAO(){
		PostDAO pd = new PostDAOImpl();
		pd.setDataSource(dataSource);
		return pd;
	}
	
	public PostTagUserDAO createPostTagUserDAO(){
		PostTagUserDAO ptd = new PostTagUserDAOImpl();
		ptd.setDataSource(dataSource);
		return ptd;
	}
	
	public RecommendationKindDAO createRecommendationKindDAO(){
		RecommendationKindDAO rkd = new RecommendationKindDAOImpl();
		rkd.setDataSource(dataSource);
		return rkd;
	}
	
	public RecommendationUserDAO createRecommendationUserDAO(){
		RecommendationUserDAO rud = new RecommendationUserDAOImpl();
		rud.setDataSource(dataSource);
		return rud;
	}
	
	public SharePostDAO createSharePostDAO(){
		SharePostDAO spd = new SharePostDAOImpl();
		spd.setDataSource(dataSource);
		return spd;
	}
	
	public CommentViewDAO createCommentViewDAO(){
		CommentViewDAO cvd = new CommentViewDAOImpl();
		cvd.setDataSource(dataSource);
		return cvd;
	}
	
	public PostingViewDAO createPostingViewDAO(){
		PostingViewDAO pvd = new PostingViewDAOImpl();
		pvd.setDataSource(dataSource);
		return pvd;
	}
	
	public TagViewDAO createTagViewDAO(){
		TagViewDAO tvd = new TagViewDAOImpl();
		tvd.setDataSource(dataSource);
		return tvd;
	}
}