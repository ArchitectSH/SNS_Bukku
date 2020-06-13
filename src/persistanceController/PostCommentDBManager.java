package persistanceController;

import injector.DataSourceManager;
import injector.MyPageDependencyInjector;
import injector.PostCommentDependencyInjector;
import injector.UserDependencyInjector;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import model.BukkuUserList;
import model.Comment;
import model.HateUserList;
import model.LikeUserList;
import model.PrivacyLevel;
import model.RecommendationUsers;
import model.UserPost;
import model.UserPublicInfo;
import action.BlockUserAction;
import action.CommentAction;
import action.CommentViewAction;
import action.GuestPostAction;
import action.HideUserAction;
import action.ImageContentAction;
import action.MyPageInfoViewAction;
import action.MyPagePostAction;
import action.PostAction;
import action.PostContentAction;
import action.PostTagUserAction;
import action.PostingViewAction;
import action.RecommendationUserAction;
import action.TagViewAction;
import action.UserAction;
import dto.CommentViewDTO;
import dto.HideUserDTO;
import dto.ImageContentDTO;
import dto.MyPageInfoViewDTO;
import dto.PostingViewDTO;
import dto.RecommendationUserDTO;
import dto.TagViewDTO;
import dto.UserDTO;
/**
 * ApplicationLayer�� ��û�� �޾� �Խñ� �� ��� ���� �����͸� �����ϱ����� �Ŵ���
 * @author SH.J
 *
 */
public class PostCommentDBManager {
	/**
	 * DB�� �����ϱ� ���� ActionŬ�������� ��ȯ�����ش�.
	 */
	private PostCommentDependencyInjector postCommentInjector;
	/**
	 * �ٸ� Ŭ������ PostCommentDBManagerŬ������ ����� �� �����Ѵ�.
	 */
	private static PostCommentDBManager postCommentDBManager;
	/**
	 * getInstance()�� ���� ȣ��Ǵ�PostCommentDBManagerŬ���� �������̴�.
	 */
	private PostCommentDBManager() {
		this.postCommentInjector = new PostCommentDependencyInjector(DataSourceManager.getInstance().getDataSource());
	}
	/**
	 * PostCommentDBManagerŬ������ �����ϰ� ������ ��ȯ�Ѵ�.
	 * @return PostCommentDBManager����
	 */
	public static PostCommentDBManager getInstance(){
		if(postCommentDBManager==null){
			postCommentDBManager = new PostCommentDBManager();
		}
		return postCommentDBManager;
	}
	/**
	 * ����ڰ� �ۼ��� �Խñ������� ��ȯ�Ѵ�.
	 * @param id �Խñ� �ۼ���
	 * @return �ۼ��� �Խñ� ������ ����
	 */
	public List<PostingViewDTO> getMyPosts(String id){
		PostingViewAction pva = (PostingViewAction) postCommentInjector.getObject(PostingViewAction.class);
		return pva.getPostingViewById(id);
	}
	/**
	 * ����ڰ� �ȷ����ϴ� ���������� �Խñ������� ��ȯ�Ѵ�.
	 * @param userPublicInfo ����� ����
	 * @return �ȷ����ϴ� ������������ �Խñ�
	 */
	public List<PostingViewDTO> getMyPagePostsById(UserPublicInfo userPublicInfo){
		PostingViewAction pva = (PostingViewAction) postCommentInjector.getObject(PostingViewAction.class);
		return pva.getMyPagePostingView(userPublicInfo.getId());
	}
	/**
	 * ����ڰ� ������ �׷��� �Խñ������� ��ȯ�Ѵ�.
	 * @param id ����� ���̵�
	 * @return ������ �׷��� �Խñ�
	 */
	public List<PostingViewDTO> getGroupPostById(String id){
		PostingViewAction pva = (PostingViewAction) postCommentInjector.getObject(PostingViewAction.class);
		return pva.getGroupPostingView(id);
	}
	/**
	 * ������� ģ���� �����ϴ� �Խñ������� ��ȯ�Ѵ�.
	 * @param id ����� ���̵�
	 * @return ������� ģ���� ���Ƹ� ������ �Խñ�
	 */
	public List<PostingViewDTO> getFriendLikePosts(String id){
		PostingViewAction pva = (PostingViewAction) postCommentInjector.getObject(PostingViewAction.class);
		return pva.getFriendLikeView(id);
	}
	/**
	 * ������� ģ���� ����� ���� �Խñ������� ��ȯ�Ѵ�.
	 * @param id ����� ���̵�
	 * @return ������� ģ���� ����� ���� �Խñ�
	 */
	public List<PostingViewDTO> getFriendCommentedPosts(String id){
		PostingViewAction pva = (PostingViewAction) postCommentInjector.getObject(PostingViewAction.class);
		return pva.getFriendCommentedView(id);
	}
	/**
	 * ����ڰ� �±׵� �Խñ������� ��ȯ�Ѵ�.
	 * @param id ����� ���̵�
	 * @return ����ڰ� �±׵� �Խñ�
	 */
	public List<PostingViewDTO> getFriendTaggedPosts(String id){
		PostingViewAction pva = (PostingViewAction) postCommentInjector.getObject(PostingViewAction.class);
		return pva.getFriendTaggedView(id);
	}
	/**
	 * ������� ģ���� �ۼ��� �Խñ������� ��ȯ�Ѵ�.
	 * @param id ����� ���̵�
	 * @return ������� ģ���� �ۼ��� �Խñ�
	 */
	public List<PostingViewDTO> getFriendPosts(String id){
		PostingViewAction pva = (PostingViewAction) postCommentInjector.getObject(PostingViewAction.class);
		return pva.getFriendPostingView(id);
	}
	/**
	 * 
	 */
	public List<PostingViewDTO> getMyPagePostsByTitle(String title){
		PostingViewAction pva = (PostingViewAction) postCommentInjector.getObject(PostingViewAction.class);
		return pva.getPostingViewByMyPageTitle(title);
	}
	/**
	 * ����ڰ� ������ ����� �ۼ��� �Խñ������� �Ǵ��Ͽ��ش�.
	 * @param requestId ����� ���̵�
	 * @param receiveId �Խñ� �ۼ��� ���̵�
	 * @return ����ڰ� ������ ����� �ۼ��� �Խñ��̸� true, �׷��� ������ false�� �����Ѵ�.
	 */
	public Boolean getBlock(String requestId, String receiveId){
		UserDependencyInjector udi = new UserDependencyInjector(DataSourceManager.getInstance().getDataSource());
		BlockUserAction bua = (BlockUserAction) udi.getObject(BlockUserAction.class);
		if(bua.getBlockUserPair(requestId, receiveId)==null){
			return false;
		}else{
			return true;
			
		}
	}
	/**
	 * �Խñ��� �ۼ��� �� ���� ���������� ��ȯ�Ѵ�.
	 * @param postNo �Խñ� ��ȣ
	 * @return �Խñ��� �ۼ��� �� ���� ���� ���
	 */
	public List<String> getPostImage(Integer postNo){
		ImageContentAction ica = (ImageContentAction) postCommentInjector.getObject(ImageContentAction.class);
		List<String> images = new ArrayList<String>();
		List<ImageContentDTO> dbImages = ica.getImageByPostNum(postNo);
		for(ImageContentDTO icd : dbImages){
			images.add(icd.getImage());
		}
		return images;
	}
	/**
	 * �Խñ� ���뿡 �±׵� ����ڵ��� ������  ��ȯ�Ѵ�.
	 * @param userPost �±׵� ����ڸ� ������ �Խñ� ��ȣ�� ����� �ִ� �Խñ� ����
	 * @return �Խñ� ���뿡 �±׵� ��������� 
	 */
	public Map<String, String> getPostTagFriends(Integer postNo){
		PostTagUserAction ptua = (PostTagUserAction) postCommentInjector.getObject(PostTagUserAction.class);
		List<String> taggedIdList = ptua.getTaggedId(postNo);
		Map<String, String> upiList = new HashMap<String, String>();
		UserDependencyInjector ui = new UserDependencyInjector(DataSourceManager.getInstance().getDataSource());
		UserAction ua = (UserAction) ui.getObject(UserAction.class);
		for(String id : taggedIdList){
			UserDTO ud = ua.getUserById(id);
			if(ud!=null){
				String name = ud.getName();
				upiList.put(id, name);
			}
		}
		return upiList;
	}
	/**
	 * �Խñ� �ϳ��� ������ ��������� ��ȯ�Ѵ�.
	 * @param postNo �Խñ� ��ȣ
	 * @return �Խñ� �ϳ��� ������ ��� 
	 */
	public List<CommentViewDTO> getPostComments(Integer postNo){
		CommentViewAction cva = (CommentViewAction) postCommentInjector.getObject(CommentViewAction.class);
		return cva.getCommentViewByPostNo(postNo);
	}
	/**
	 * �Խñ� �ϳ��� ������ ��ۿ� �±��� ������� ������ ��ȯ�Ѵ�. 
	 * @param postNo �Խñ� ��ȣ
	 * @return �±��� ������� ���̵�� �̸��� ��ҷ� �ϴ� Map
	 */
	public Map<String, String> getTagComments(Integer postNo){
		TagViewAction tva = (TagViewAction) postCommentInjector.getObject(TagViewAction.class);
		List<TagViewDTO> tvList = tva.getTagViewByPostNo(postNo);
		Map<String, String> upiList = new HashMap<String, String>();
		for(TagViewDTO tvd : tvList){
			upiList.put(tvd.getTaggedUserId(), tvd.getTaggedUserName());
		}
		return upiList;
	}
	/**
	 * ����ڰ� ���� �Խñ����� �Ǵ��Ͽ��ش�.
	 * @param id ����� ���̵�
	 * @param postNo �Խñ� ��ȣ
	 * @return ����ڰ� ���� �Խñ��̸� true, �׷��� ������ false�� �����Ѵ�. 
	 */
	public Boolean getHide(String id, Integer postNo){
		HideUserAction hua = (HideUserAction) postCommentInjector.getObject(HideUserAction.class);
		List<HideUserDTO> hudList = hua.getHideUserByPostNum(postNo);
		for(HideUserDTO hud : hudList){
			if(hud.getId()==id){
				return true;
			}
		}
		return false;
	}
	/**
	 * �Խñ� �ϳ��� ��õ�� ������� ������ ��ȯ�Ѵ�.
	 * @param postNo �Խñ� ��ȣ
	 * @return �Խñ� �ϳ��� ��õ�� ������� ����
	 */
	public RecommendationUsers getRecommendList(Integer postNo) {
		RecommendationUserAction rua = (RecommendationUserAction) postCommentInjector.getObject(RecommendationUserAction.class);
		List<RecommendationUserDTO> ruDBList = rua.getRecommendationUser();
		RecommendationUsers rUsers = null;		
		if (ruDBList != null) {
			BukkuUserList bukkuUserList = new BukkuUserList();
			LikeUserList likeUserList = new LikeUserList();
			HateUserList hateUserList = new HateUserList();
			UserDependencyInjector udi = new UserDependencyInjector(DataSourceManager.getInstance().getDataSource());
			UserAction ua = (UserAction) udi.getObject(UserAction.class);
			for (RecommendationUserDTO rud : ruDBList) {
				if (rud.getPostNo() == postNo) {
					UserPublicInfo upi = new UserPublicInfo();
					upi.setId(rud.getId());
					upi.setName(ua.getUserById(upi.getId()).getName());
					if (rud.getRecommendationKindNo() == 1) {
						likeUserList.addLikeUser(upi);
					} else if (rud.getRecommendationKindNo() == 2) {
						bukkuUserList.addBukkuUser(upi);
					} else {
						hateUserList.addHateUser(upi);
					}
				}
			}
			rUsers = new RecommendationUsers();
			rUsers.setLikeUserList(likeUserList);
			rUsers.setBukkuUserList(bukkuUserList);
			rUsers.setHateUserList(hateUserList);
			return rUsers;
		}
		return rUsers;
	}
	/**
	 * �Խñ��� ������ ������� ������ ��ȯ�Ѵ�.
	 * @param postNo �Խñ� ��ȣ
	 * @return �Խñ��� ������ ������� ����
	 */
	public List<UserPublicInfo> getShareUsers(Integer postNo){
		PostingViewAction pva = (PostingViewAction) postCommentInjector.getObject(PostingViewAction.class);
		List<PostingViewDTO> postList = pva.getPostingViewByOriginPostNo(postNo);
		List<UserPublicInfo> shareUsers = null;
		if(postList!=null){
			shareUsers = new ArrayList<UserPublicInfo>();
			for(PostingViewDTO pvd : postList){
				UserPublicInfo upi = new UserPublicInfo();
				upi.setId(pvd.getId());
				upi.setName(pvd.getName());
				upi.setPicture(pvd.getProfileImg());
				shareUsers.add(upi);
			}
		}
		return shareUsers;
	}
	public PostingViewDTO getPostingView(Integer postNo){
		PostingViewAction pva = (PostingViewAction) postCommentInjector.getObject(PostingViewAction.class);
		PostingViewDTO pvd = pva.getPostingViewByPostNo(postNo);
		return pvd;
	}
	//�� ����
	public Integer writePost(UserPost userPost){
		PostAction pa = (PostAction) postCommentInjector.getObject(PostAction.class);
		PostContentAction pca = (PostContentAction) postCommentInjector.getObject(PostContentAction.class);
		int contentNum = pca.insertPostContent(userPost.getPostContent().getContent(), userPost.getPostContent().getVideo());
		ImageContentAction ica = (ImageContentAction) postCommentInjector.getObject(ImageContentAction.class);
		for(String img : userPost.getPostContent().getImg()){
			ica.insertImage(img, contentNum);
		}
		int level = 1;
		if(userPost.getPrivacyLevel()==PrivacyLevel.CLOSED){
			level = 3;
		}else if(userPost.getPrivacyLevel()==PrivacyLevel.GROUP_MEMBER){
			level = 5;
		}else if(userPost.getPrivacyLevel()==PrivacyLevel.ONLY_FRIEND){
			level = 2;
		}else if(userPost.getPrivacyLevel()==PrivacyLevel.TAGED_FRIEND){
			level = 4;
		}
		
		//�±�
		if(userPost.getPostContent().getTagFriends()!=null){
			PostTagUserAction ptua = (PostTagUserAction) postCommentInjector.getObject(PostTagUserAction.class);
			Collection<String> tagFriends = userPost.getPostContent().getTagFriends().values();
			Iterator<String> it = tagFriends.iterator();
			while(it.hasNext()){
				ptua.insertPostTagUser(userPost.getPostNo(), it.next());
			}
		}
		return pa.insertPost(level, userPost.getWriter().getId(), contentNum);
	}
	//�� ����
	public Integer deletePost(Integer postNo){
		PostAction pa = (PostAction) postCommentInjector.getObject(PostAction.class);
		pa.deletePost(postNo);
		return 1;
	}
	//��� �ۼ�
	public Integer writeComment(Integer postNo, Comment comment){
		CommentAction ca = (CommentAction) postCommentInjector.getObject(CommentAction.class);
		int level = 1;
		if(comment.getPrivacyLevel()==PrivacyLevel.CLOSED){
			level = 3;
		}
		return ca.insertComment(comment.getCommentContent().getComment(), postNo, comment.getWriter().getId(), level);
	}
	//��� ����
	public Integer deleteComment(Integer commentNo){
		CommentAction ca = (CommentAction) postCommentInjector.getObject(CommentAction.class);
		ca.deleteCommentByCommentNum(commentNo);
		return 1;
	}
	//���� �ۼ�
	public List<PostingViewDTO> getGuestPost(String id){
		PostingViewAction pva = (PostingViewAction) postCommentInjector.getObject(PostingViewAction.class);
		return pva.getPostingViewByGuestId(id);
	}
	//��õ
	public void recommendPost(Integer recommendKind,Integer postNo, String id){
		RecommendationUserAction rua = (RecommendationUserAction) postCommentInjector.getObject(RecommendationUserAction.class);
		if(confirmRecommend(postNo, id)!=recommendKind)
			rua.insertRecommendationUser(recommendKind, postNo, id);
		else
			rua.deleteRecommendationUserByPostNumId(postNo, id);
	}
	//��õ����
	public Integer confirmRecommend(Integer postNo, String id){
		RecommendationUserAction rua = (RecommendationUserAction) postCommentInjector.getObject(RecommendationUserAction.class);
		List<RecommendationUserDTO> recommendUserList = rua.getRecommendationUserByPostNum(postNo);
		for(RecommendationUserDTO rud : recommendUserList){
			if(rud.getId().equals(id)){
				if(rud.getRecommendationKindNo()==1){
					return 1;
				}else if(rud.getRecommendationKindNo()==2){
					return 2;
				}else if(rud.getRecommendationKindNo()==3){
					return 3;
				}
			}
		}
		return 0;
	}
	public void modifyPost(UserPost userPost){
		PostContentAction pca = (PostContentAction) postCommentInjector.getObject(PostContentAction.class);
		PostAction pa = (PostAction) postCommentInjector.getObject(PostAction.class);
		ImageContentAction ica = (ImageContentAction) postCommentInjector.getObject(ImageContentAction.class);
		//����,����
		pca.updatePostContent(userPost.getPostContent().getContent(), userPost.getPostContent().getVideo(), pa.getPostByNum(userPost.getPostNo()).getPostContentNo());
		//�̹���
		for(String img : userPost.getPostContent().getImg()){
			ica.insertImage(img, pca.getPostContentByPostNum(userPost.getPostNo()).getPostContentNo());
		}
		//�±�
		PostTagUserAction ptua = (PostTagUserAction) postCommentInjector.getObject(PostTagUserAction.class);
		ptua.deletePostTagUser(userPost.getPostNo());
		Collection<String> tagFriends = userPost.getPostContent().getTagFriends().values();
		Iterator<String> it = tagFriends.iterator();
		while(it.hasNext()){
			ptua.insertPostTagUser(userPost.getPostNo(), it.next());
		}
		//��������
		int level = 1;
		if(userPost.getPrivacyLevel()==PrivacyLevel.CLOSED){
			level = 3;
		}else if(userPost.getPrivacyLevel()==PrivacyLevel.GROUP_MEMBER){
			level = 5;
		}else if(userPost.getPrivacyLevel()==PrivacyLevel.ONLY_FRIEND){
			level = 2;
		}else if(userPost.getPrivacyLevel()==PrivacyLevel.TAGED_FRIEND){
			level = 4;
		}
		pa.updatePost(level, userPost.getPostNo());
	}
	public List<PostingViewDTO> searchMyPost(String id, String content, String startDate, String lastDate){
		PostingViewAction pva = (PostingViewAction) postCommentInjector.getObject(PostingViewAction.class);
		List<PostingViewDTO> postList = null;
		System.out.println(content);
		System.out.println(startDate);
		System.out.println(lastDate);
		if(!content.equals("") && !startDate.equals("") && !lastDate.equals("")){
			postList = pva.getPostingViewByContentDate(content, startDate, lastDate);
			System.out.println("1/"+postList);
		}else if(!startDate.equals("") && !lastDate.equals("")){
			postList = pva.getPostingViewByDate(startDate, lastDate);
			System.out.println("2/"+postList);
		}else if(!content.equals("")){
			postList = pva.getPostingViewByPostContent(content);
			System.out.println("3/"+postList);
		}
		
		List<PostingViewDTO> searchedList = new ArrayList<PostingViewDTO>();
		if(postList!=null){
			for(PostingViewDTO pvd : postList){
				if(pvd.getId().equals(id) || (pvd.getGuestId()!=null && pvd.getGuestId().equals(id))){
					searchedList.add(pvd);
				}
			}
		}
		return searchedList;
	}
	public Integer writeGuestPostDB(UserPost userPost, String guestId){
		int postNo = writePost(userPost);
		GuestPostAction gpa = (GuestPostAction) postCommentInjector.getObject(GuestPostAction.class);
		gpa.insertGuestPost(postNo, guestId);
		return postNo;
	}
	public Integer writeMyPagePostDB(UserPost userPost, String title){
		int postNo = writePost(userPost);
		MyPagePostAction mpp = (MyPagePostAction) postCommentInjector.getObject(MyPagePostAction.class);
		mpp.insertMyPagePost(postNo, title);
		return postNo;
	}
	public String getPostWriter(Integer postNo){
		PostAction pa = (PostAction) postCommentInjector.getObject(PostAction.class);
		return pa.getPostByNum(postNo).getId();
	}
	 
	//�Űܾ��Ҹ޼ҵ��
	public MyPageInfoViewDTO getMyPageView(String myPageTitle){
		MyPageDependencyInjector mpdi = new MyPageDependencyInjector(DataSourceManager.getInstance().getDataSource());
		MyPageInfoViewAction mpva = (MyPageInfoViewAction) mpdi.getObject(MyPageInfoViewAction.class);
		return mpva.getMyPageInfoViewByTitle(myPageTitle).get(0);
	}
	public UserDTO getUserInfo(String id){
		UserDependencyInjector udi = new UserDependencyInjector(DataSourceManager.getInstance().getDataSource());
		UserAction ua = (UserAction) udi.getObject(UserAction.class);
		return ua.getUserById(id);
	}
}
