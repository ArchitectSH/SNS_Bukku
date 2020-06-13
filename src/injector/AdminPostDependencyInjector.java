package injector;
import javax.sql.DataSource;

import dao.AdminDAO;
import dao.HelpDAO;
import dao.NoticeDAO;
import dao.OpinionDAO;
import dao.PrivacyDAO;
import action.*;



public class AdminPostDependencyInjector {
	private DataSource dataSource;
	public AdminPostDependencyInjector(DataSource dataSource) {
	
	}
	
	private NoticeDAO createNoticeDAO() {
		return null;
	}
	
	private HelpDAO createHelpDAO() {
		return null;
	}
	
	private OpinionDAO createOpinionDAO() {
		return null;
	}
	
	private AdminDAO createAdminDAO() {
		return null;
	}
	
	private PrivacyDAO createPrivacyDAO() {
		return null;
	}
	/*
	private NoticeAction createNoticeAction() {
		return null;
	}
	
	private HelpAction createHelpAction() {
		return null;
	}
	
	private OpinionAction createOpinionAction() {
		return null;
	}
	
	private AdminAction createAdminAction() {
		return null;
	}
	
	private action.PrivacyAction createPrivacyAction() {
		return null;
	}*/
}
