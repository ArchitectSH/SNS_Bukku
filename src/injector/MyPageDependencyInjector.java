package injector;

import javax.sql.DataSource;
import action.ApprovalPageViewAction;
import action.FollowingMyPageViewAction;
import action.MyPageAction;
import action.MyPageFollowingAction;
import action.MyPageInfoViewAction;
import action.MyPageUserAction;
import action.MyPageUserKindAction;
import dao.ApprovalPageViewDAO;
import dao.ApprovalPageViewDAOImpl;
import dao.FollowingMyPageViewDAO;
import dao.FollowingMyPageViewDAOImpl;
import dao.MyPageDAO;
import dao.MyPageDAOImpl;
import dao.MyPageFollowingDAO;
import dao.MyPageFollowingDAOImpl;
import dao.MyPageInfoViewDAO;
import dao.MyPageInfoViewImpl;
import dao.MyPageUserDAO;
import dao.MyPageUserDAOImpl;
import dao.MyPageUserKindDAO;
import dao.MyPageUserKindDAOImpl;

public class MyPageDependencyInjector {
	private DataSource dataSource;
	
	public MyPageDependencyInjector(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	
	public Object getObject(Class type) {
		//MyPage
		if(type == MyPageDAO.class){
			return createMyPageDAO();
		}
		else if(type == MyPageFollowingDAO.class){
			return createMyPageFollowingDAO();
		}
		else if(type == MyPageUserKindDAO.class){
			return createMyPageUserKindDAO();
		}
		else if(type == MyPageUserDAO.class){
			return createMyPageUserDAO();
		}
		//mypage view
		else if(type == MyPageInfoViewDAO.class){
			return createMyPageInfoViewDAO();
		}
		else if(type == FollowingMyPageViewDAO.class){
			return createFollowingMyPageViewDAO();
		}
		else if(type == ApprovalPageViewDAO.class){
			return createApprovalPageViewDAO();
		}
		//mypage Action
		else if(type == MyPageAction.class){
			return createMyPageAction();
		}
		else if(type == MyPageFollowingAction.class){
			return createMyPageFollowingAction();
		}
		else if(type == MyPageUserKindAction.class){
			return createMyPageUserKindAction();
		}
		else if(type == MyPageUserAction.class){
			return createMyPageUserAction();
		}
		else if(type == MyPageInfoViewAction.class){
			return createMyPageInfoViewAction();
		}
		else if(type == FollowingMyPageViewAction.class){
			return createFollowingMyPageViewAction();
		}
		else if(type == ApprovalPageViewAction.class){
			return createApprovalPageViewAction();
		}
		return null;
	}
	//MyPage
	private MyPageDAO createMyPageDAO(){
		MyPageDAO myPageDAO = new MyPageDAOImpl();
		myPageDAO.setDataSource(dataSource);
		return myPageDAO;
	}
	private MyPageFollowingDAO createMyPageFollowingDAO(){
		MyPageFollowingDAO myPageFollowingDAO = new MyPageFollowingDAOImpl();
		myPageFollowingDAO.setDataSource(dataSource);
		return myPageFollowingDAO;
	}
	private MyPageUserKindDAO createMyPageUserKindDAO(){
		MyPageUserKindDAO myPageUserKindDAO = new MyPageUserKindDAOImpl();
		myPageUserKindDAO.setDataSource(dataSource);
		return myPageUserKindDAO;
	}
	private MyPageUserDAO createMyPageUserDAO(){
		MyPageUserDAO myPageUserDAO = new MyPageUserDAOImpl();
		myPageUserDAO.setDataSource(dataSource);
		return myPageUserDAO;
	}
	//mypage view
	private MyPageInfoViewDAO createMyPageInfoViewDAO(){
		MyPageInfoViewDAO myPageInfoViewDAO = new MyPageInfoViewImpl();
		myPageInfoViewDAO.setDataSource(dataSource);
		return myPageInfoViewDAO;
	}
	private FollowingMyPageViewDAO createFollowingMyPageViewDAO(){
		FollowingMyPageViewDAO followingMyPageViewDAO = new FollowingMyPageViewDAOImpl();
		followingMyPageViewDAO.setDataSource(dataSource);
		return followingMyPageViewDAO;
	}
	private ApprovalPageViewDAO createApprovalPageViewDAO(){
		ApprovalPageViewDAO approvalPageViewDAO = new ApprovalPageViewDAOImpl();
		approvalPageViewDAO.setDataSource(dataSource);
		return approvalPageViewDAO;
	}
	//action
	private MyPageAction createMyPageAction() {
		MyPageAction myPageAction = new MyPageAction();
		myPageAction.setMyPageDAO(createMyPageDAO());
		return myPageAction;
	}
	private MyPageFollowingAction createMyPageFollowingAction() {
		MyPageFollowingAction myPageFollowingAction = new MyPageFollowingAction();
		myPageFollowingAction.setMyPageFollowingDAO(createMyPageFollowingDAO());
		return myPageFollowingAction;
	}
	private MyPageUserKindAction createMyPageUserKindAction() {
		MyPageUserKindAction myPageUserKindAction = new MyPageUserKindAction();
		myPageUserKindAction.setMyPageUserKindDAO(createMyPageUserKindDAO());
		return myPageUserKindAction;
	}
	private MyPageUserAction createMyPageUserAction() {
		MyPageUserAction myPageUserAction = new MyPageUserAction();
		myPageUserAction.setMyPageUserDAO(createMyPageUserDAO());
		return myPageUserAction;
	}
	private MyPageInfoViewAction createMyPageInfoViewAction() {
		MyPageInfoViewAction myPageInfoViewAction = new MyPageInfoViewAction();
		myPageInfoViewAction.setMyPageInfoViewDAO(createMyPageInfoViewDAO());
		return myPageInfoViewAction;
	}	
	private FollowingMyPageViewAction createFollowingMyPageViewAction() {
		FollowingMyPageViewAction followingMyPageViewAction = new FollowingMyPageViewAction();
		followingMyPageViewAction.setFollowingMyPageViewDAO(createFollowingMyPageViewDAO());
		return followingMyPageViewAction;
	}
	private ApprovalPageViewAction createApprovalPageViewAction() {
		ApprovalPageViewAction approvalPageViewAction = new ApprovalPageViewAction();
		approvalPageViewAction.setApprovalPageViewDAO(createApprovalPageViewDAO());
		return approvalPageViewAction;
	}
}
