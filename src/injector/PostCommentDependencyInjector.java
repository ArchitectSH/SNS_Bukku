package injector;
import javax.sql.DataSource;

import action.*;
import dao.*;

public class PostCommentDependencyInjector {
	private DataSource dataSource;
	public PostCommentDependencyInjector(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public Object getObject(Class type) {
		if(type==PostAction.class){
			return createPostAction();
		}else if(type==PostContentAction.class){
			return createPostContentAction();
		}else if(type==ImageContentAction.class){
			return createImageContentAction();
		}else if(type==CommentAction.class){
			return  createCommentAction();
		}else if(type==SharePostAction.class){
			return createSharePostAction();
		}else if(type==GuestPostAction.class){
			return createGuestPostAction();
		}else if(type==MyPagePostAction.class){
			return createMyPagePostAction();
		}else if(type==GroupPostAction.class){
			return createGroupPostAction();
		}else if(type==CommentTagUserAction.class){
			return createCommentTagUserAction();
		}else if(type==RecommendationKindAction.class){
			return createRecommendationKindAction();
		}else if(type==HideUserAction.class){
			return createHideUserAction();
		}else if(type==RecommendationUserAction.class){
			return createRecommendationUserAction();
		}else if(type==PostTagUserAction.class){
			return createPostTagUserAction();
		}else if(type==ReportedUserAction.class){
			return createReportedUserAction();
		}else if(type==TagViewAction.class){
			return createTagViewAction();
		}else if(type==CommentViewAction.class){
			return createCommentViewAction();
		}else if(type==PostingViewAction.class){
			return createPostingViewAction();
		}else{
			return null;
		}
	}
	
	private PostDAO createPostDAO() {
			PostDAO pd = new PostDAOImpl();
			pd.setDataSource(dataSource);
			return pd;
	}
	
	private PostContentDAO createPostContentDAO() {
		PostContentDAO pcd = new PostContentDAOImpl();
		pcd.setDataSource(dataSource);
		return pcd;
	}
	
	private ImageContentDAO createImageContentDAO() {
		ImageContentDAO icd = new ImageContentDAOImpl();
		icd.setDataSource(dataSource);
		return icd;
	}
	
	private SharePostDAO createSharePostDAO() {
		SharePostDAO spd = new SharePostDAOImpl();
		spd.setDataSource(dataSource);
		return spd;
	}
	
	private GuestPostDAO createGuestPostDAO() {
		GuestPostDAO gpd = new GuestPostDAOImpl();
		gpd.setDataSource(dataSource);
		return gpd;
	}
	
	private MyPagePostDAO createMyPagePostDAO() {
		MyPagePostDAO pd = new MyPagePostDAOImpl();
		pd.setDataSource(dataSource);
		return pd;
	}
	
	private GroupPostDAO createGroupPostDAO() {
		GroupPostDAO gpd = new GroupPostDAOImpl();
		gpd.setDataSource(dataSource);
		return gpd;
	}
	
	private CommentTagUserDAO createCommentTagUserDAO() {
		CommentTagUserDAO ctud = new CommentTagUserDAOImpl();
		ctud.setDataSource(dataSource);
		return ctud;
	}
	
	private RecommendationKindDAO createRecommendationKindDAO() {
		RecommendationKindDAO rkd = new RecommendationKindDAOImpl();
		rkd.setDataSource(dataSource);
		return rkd;
	}
	
	private HideUserDAO createHideUserDAO() {
		HideUserDAO hd = new HideUserDAOImpl();
		hd.setDataSource(dataSource);
		return hd;
	}
	
	private RecommendationUserDAO createRecommendationUserDAO() {
		RecommendationUserDAO rud = new RecommendationUserDAOImpl();
		rud.setDataSource(dataSource);
		return rud;
	}
	
	private PostTagUserDAO createPostTagUserDAO() {
		PostTagUserDAO ptd = new PostTagUserDAOImpl();
		ptd.setDataSource(dataSource);
		return ptd;
	}
	
	private ReportedUserDAO createReportedUserDAO() {
		ReportedUserDAO rud = new ReportedUserDAOImpl();
		rud.setDataSource(dataSource);
		return rud;
	}
	
	private CommentDAO createCommentDAO(){
		CommentDAO cd = new CommentDAOImpl();
		cd.setDataSource(dataSource);
		return cd;
	}
	
	private PostAction createPostAction() {
		PostAction pa = new PostAction();
		pa.setPostDAO(createPostDAO());
		return pa;
	}
	
	private PostContentAction createPostContentAction() {
		PostContentAction pca = new PostContentAction();
		pca.setPostContentDAO(createPostContentDAO());
		return pca;
	}
	
	private ImageContentAction createImageContentAction() {
		ImageContentAction ica = new ImageContentAction();
		ica.setImageContentDAO(createImageContentDAO());
		return ica;
	}
	
	private CommentAction createCommentAction() {
		CommentAction ca = new CommentAction();
		ca.setCommentDAO(createCommentDAO());
		return ca;
	}
	
	
	private SharePostAction createSharePostAction() {
		SharePostAction spa = new SharePostAction();
		spa.setSharePostDAO(createSharePostDAO());
		return spa;
	}
	
	private GuestPostAction createGuestPostAction() {
		GuestPostAction gpa = new GuestPostAction();
		gpa.setGuestPostDAO(createGuestPostDAO());
		return gpa;
	}
	
	private MyPagePostAction createMyPagePostAction() {
		MyPagePostAction mpa = new MyPagePostAction();
		mpa.setMyPagePostDAO(createMyPagePostDAO());
		return mpa;
	}
	
	private GroupPostAction createGroupPostAction() {
		GroupPostAction gpa = new GroupPostAction();
		gpa.setGroupPostDAO(createGroupPostDAO());
		return gpa;
	}
	
	private CommentTagUserAction createCommentTagUserAction() {
		CommentTagUserAction ctua = new CommentTagUserAction();
		ctua.setCommentTagUserDAO(createCommentTagUserDAO());
		return ctua;
	}
	
	private RecommendationKindAction createRecommendationKindAction() {
		RecommendationKindAction rka = new RecommendationKindAction();
		rka.setRecommendationKindDAO(createRecommendationKindDAO());
		return rka;
	}
	
	private HideUserAction createHideUserAction() {
		HideUserAction hua = new HideUserAction();
		hua.setHideUserDAO(createHideUserDAO());
		return hua;
	}
	
	private RecommendationUserAction createRecommendationUserAction() {
		RecommendationUserAction rua = new RecommendationUserAction();
		rua.setRecommendationUserDAO(createRecommendationUserDAO());
		return rua;
	}
	
	private PostTagUserAction createPostTagUserAction() {
		PostTagUserAction ptua = new PostTagUserAction();
		ptua.setPostTagUserDAO(createPostTagUserDAO());
		return ptua;
	}
	
	private ReportedUserAction createReportedUserAction() {
		ReportedUserAction rua = new ReportedUserAction();
		rua.setReportedUserDAO(createReportedUserDAO());
		return rua;
	}
	
	private TagViewDAO createTagViewDAO() {
		TagViewDAO tvd = new TagViewDAOImpl();
		tvd.setDataSource(dataSource);
		return tvd;
	}
	
	private CommentViewDAO createCommentViewDAO() {
		CommentViewDAO cvd = new CommentViewDAOImpl();
		cvd.setDataSource(dataSource);
		return cvd;
	}
	
	private PostingViewDAO createPostingViewDAO() {
		PostingViewDAO pvd = new PostingViewDAOImpl();
		pvd.setDataSource(dataSource);
		return pvd;
	}
	
	private TagViewAction createTagViewAction() {
		TagViewAction tvd = new TagViewAction();
		tvd.setTagViewDAO(createTagViewDAO());
		return tvd;
	}
	
	private CommentViewAction createCommentViewAction() {
		CommentViewAction cva = new CommentViewAction();
		cva.setCommentViewDAO(createCommentViewDAO());
		return cva;
	}
	
	private PostingViewAction createPostingViewAction() {
		PostingViewAction pva = new PostingViewAction();
		pva.setPostingViewDAO(createPostingViewDAO());
		return pva;
	}
}
