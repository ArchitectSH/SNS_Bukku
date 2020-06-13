package applicationController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Comment;
import model.CommentContent;
import model.CommentList;
import model.GroupPost;
import model.GuestPost;
import model.GuestPostList;
import model.HideUserInfoList;
import model.MyPagePost;
import model.MyPagePostList;
import model.OriginPost;
import model.PostContent;
import model.PrivacyLevel;
import model.RecommendationUsersList;
import model.ReportUserInfoList;
import model.SharePost;
import model.SharePostList;
import model.ShareUserInfoList;
import model.UserPost;
import model.UserPostList;
import model.UserPublicInfo;
import persistanceController.PostCommentDBManager;
import persistanceController.UserDBManager;
import validator.PostValidator;
import viewHelperBean.CommentViewBean;
import viewHelperBean.PostAllInfoBean;
import viewHelperBean.PostingViewBean;
import viewHelperBean.UserPublicBean;
import dto.CommentViewDTO;
import dto.FriendInfoViewDTO;
import dto.PostingViewDTO;
import form.CommentForm;
import form.UserPostForm;

public class PostCommentController {
	private static PostCommentController postCommentController;
	private Map<String, UserPostList> userPostList;
	private Map<String, GuestPostList> userGuestPostList;
	private Map<String, SharePostList> userSharePostList;
	private Map<String, MyPagePostList> userMyPagePostList;
	private Map<String, CommentList> commentList;
	private Map<String, ReportUserInfoList> reportUserInfoList;
	private Map<String, ShareUserInfoList> shareUserInfoList;
	private Map<String, HideUserInfoList> hideUserInfoList;
	private Map<String, RecommendationUsersList> recommendationUserList;
	private PostCommentController() {
		// TODO Auto-generated constructor stub
		userPostList = new HashMap<String, UserPostList>();
		userGuestPostList = new  HashMap<String, GuestPostList>();
		userSharePostList = new HashMap<String, SharePostList>();
		userMyPagePostList = new HashMap<String, MyPagePostList>();
		commentList = new HashMap<String, CommentList>();
		reportUserInfoList = new HashMap<String, ReportUserInfoList>();
		shareUserInfoList = new HashMap<String, ShareUserInfoList>();
		hideUserInfoList = new HashMap<String, HideUserInfoList>();
		recommendationUserList = new HashMap<String, RecommendationUsersList>();
	}
	public static PostCommentController getInstance(){
		if(postCommentController == null){
			postCommentController = new PostCommentController();
		}
		return postCommentController;
	}
	public List<PostAllInfoBean> showHomePost(String id){
		if(userPostList.get(id)==null){
			userPostList.put(id, new UserPostList());
			userGuestPostList.put(id, new GuestPostList());
			userSharePostList.put(id, new SharePostList());
			userMyPagePostList.put(id, new MyPagePostList());
			commentList.put(id, new CommentList());
			reportUserInfoList.put(id, new ReportUserInfoList());
			shareUserInfoList.put(id, new ShareUserInfoList());
			hideUserInfoList.put(id, new HideUserInfoList());
			recommendationUserList.put(id, new RecommendationUsersList());
		}
		
		
		
		List<PostAllInfoBean> homePosts = new ArrayList<PostAllInfoBean>(); 
		
		UserPublicInfo upi = new UserPublicInfo();
		upi.setId(id);
		List<PostingViewDTO> myPagePosts = PostCommentDBManager.getInstance().getMyPagePostsById(upi);
		if(myPagePosts!=null){
			for(PostingViewDTO pvd : myPagePosts){
				addPost(homePosts, pvd, 1); //마이페이지 글
			}
		}
		
		List<PostingViewDTO> getFriendCommentedPosts = PostCommentDBManager.getInstance().getFriendCommentedPosts(id);
		if(getFriendCommentedPosts!=null){
			for(PostingViewDTO pvd : getFriendCommentedPosts){
				addPost(homePosts, pvd, 4); //친구가 댓글을 남긴 글
			}
		}
		
		List<PostingViewDTO> getFriendLikePosts = PostCommentDBManager.getInstance().getFriendLikePosts(id);
		if(getFriendLikePosts!=null){
			for(PostingViewDTO pvd : getFriendLikePosts){
				addPost(homePosts, pvd, 3); //친구가 좋아한 글
			}
		}
		
		List<PostingViewDTO> myPosts = PostCommentDBManager.getInstance().getMyPosts(id);
		if(myPosts!=null){
			for(PostingViewDTO pvd : myPosts){
				addPost(homePosts, pvd, 0); //일반 글
			}
		}
		
		List<PostingViewDTO> getFriendTaggedPosts = PostCommentDBManager.getInstance().getFriendTaggedPosts(id);
		if(getFriendTaggedPosts!=null){			
			for(PostingViewDTO pvd : getFriendTaggedPosts){
				addPost(homePosts, pvd, 5); //친구가 태그한 글
			}
		}
		
		
		List<PostingViewDTO> getFriendPosts = PostCommentDBManager.getInstance().getFriendPosts(id);
		if(getFriendPosts!=null){
			for(PostingViewDTO pvd : getFriendPosts){
				addPost(homePosts, pvd, 6); //친구가 쓴 글
			}
		}
		
		List<PostingViewDTO> myGroupPosts = PostCommentDBManager.getInstance().getGroupPostById(id);
		if(myGroupPosts!=null){
			for(PostingViewDTO pvd : myGroupPosts){
				addPost(homePosts, pvd, 2); //그룹 글
			}
		}
		
		/*for(PostAllInfoBean pa : homePosts){
			System.out.println(pa.getPostingViewBean().getPostNo()+ " "+ pa.getPostingViewBean().getStandardTime());
		}
		System.out.println(homePosts.size());*/
		homePosts = sortPost(homePosts);
		loadPost(homePosts, id);
		/*System.out.println("\n\n");
		for(PostAllInfoBean pa : homePosts){
			System.out.println(pa.getPostingViewBean().getPostNo() + " "+ pa.getPostingViewBean().getStandardTime());
		}
		System.out.println(homePosts.size());*/
		
		return homePosts;
	}

	private void loadPost(List<PostAllInfoBean> paibList, String id){
		int index=0;
		for(index=0; index<30 && index<paibList.size(); index++){
			//차단회원의 글인지 확인
			PostAllInfoBean paib = paibList.get(index);
			if(PostCommentDBManager.getInstance().getBlock(id, paib.getPostingViewBean().getId())){
				System.out.println("truetrue");
				paib.setBlock(true);
			}
			//이미지 불러오기
			paib.setImageList(PostCommentDBManager.getInstance().getPostImage(paib.getPostingViewBean().getPostNo()));
			//내용에 태그된 회원 불러오기			
			paib.setPostTagFriends(PostCommentDBManager.getInstance().getPostTagFriends(paib.getPostingViewBean().getPostNo()));
			//댓글 불러오기
			List<CommentViewDTO> cvdList = PostCommentDBManager.getInstance().getPostComments(paib.getPostingViewBean().getPostNo());
			List<CommentViewBean> cvbList = new ArrayList<CommentViewBean>();
			for(CommentViewDTO cvd : cvdList){
				CommentViewBean cv = new CommentViewBean();
				cv.setCommentNo(cvd.getCommentNo());
				cv.setCommentContent(cvd.getCommentContent());
				cv.setCommentDate(cvd.getCommentDate());
				cv.setPostNo(cvd.getPostNo());
				cv.setPrivacyLevel(cvd.getPrivacyLevel());
				cv.setWriterId(cvd.getWriterId());
				cv.setWriterName(cvd.getWriterName());
				cv.setWriterPorifleImg(cvd.getWriterProfileImg());
				cvbList.add(cv);
			}
			paib.setCommentViewBeanList(cvbList);
			//댓글에 태그한 회원 불러오기
			paib.setCommentTagFriends(PostCommentDBManager.getInstance().getTagComments(paib.getPostingViewBean().getPostNo()));
			
			//숨긴 글인지 확인
			if(PostCommentDBManager.getInstance().getHide(id, paib.getPostingViewBean().getPostNo())){
				paib.setHide(true);
				hideUserInfoList.get(id).addHidingUser(paib.getPostingViewBean().getPostNo(), new UserPublicInfo(null, id, null));
			}
			
			//추천여부 확인
			paib.setRecommend(PostCommentDBManager.getInstance().confirmRecommend(paib.getPostingViewBean().getPostNo(), id));
			
			//아띠 여부
			paib.setAtti(false);
			String writerId = paib.getPostingViewBean().getId();
			if(writerId!=null && paib.getPostingViewBean().getMypageTitle()==null){
				FriendInfoViewDTO fivd = UserDBManager.getInstance().getAttiFriend(id, writerId);
				if(fivd!=null)
					paib.setAtti(true);
			}
			
			//모델 세팅
			PostContent pc = new PostContent();
			pc.setContent(paib.getPostingViewBean().getPostContent());
			pc.setImg(paib.getImageList());
			pc.setTagFriends(paib.getPostTagFriends());
			pc.setVideo(paib.getPostingViewBean().getVideo());
			
			UserPost up = null;
			if(paib.getPostingViewBean().getMypageTitle()!=null){
				up = new MyPagePost();
				paib.getPostingViewBean().setMypageImg(PostCommentDBManager.getInstance().getMyPageView(paib.getPostingViewBean().getMypageTitle()).getMyPageImg());
			}else if(paib.getPostingViewBean().getGuestId()!=null){
				up = new GuestPost();
				paib.getPostingViewBean().setGuestName(PostCommentDBManager.getInstance().getUserInfo(paib.getPostingViewBean().getGuestId()).getName());
			}else if(paib.getPostingViewBean().getOriginPostNo()!=0){
				up = new SharePost();
				PostingViewDTO pvd = PostCommentDBManager.getInstance().getPostingView(paib.getPostingViewBean().getOriginPostNo());
				paib.getPostingViewBean().setOriginPostNo(pvd.getPostNo());
				paib.getPostingViewBean().setOriginPostContent(pvd.getPostContent());
				paib.getPostingViewBean().setOriginPostImg(PostCommentDBManager.getInstance().getPostImage(pvd.getPostNo()));
				paib.getPostingViewBean().setOriginVideo(pvd.getVideo());
				paib.getPostingViewBean().setOriginTagUsers(PostCommentDBManager.getInstance().getPostTagFriends(pvd.getPostNo()));
			}
			else if(paib.getPostingViewBean().getGroupNo()!=0){
				up = new GroupPost(); //그룹(미지정)
			}else{
				up = new UserPost();
			}
			
			up.setPostContent(pc);
			up.setPostingTime(paib.getPostingViewBean().getPostDate());
			up.setPostNo(paib.getPostingViewBean().getPostNo());
			int level = paib.getPostingViewBean().getPrivacyLevel();
			if(level==1){
				up.setPrivacyLevel(PrivacyLevel.ALL);
			}else if(level==2){
				up.setPrivacyLevel(PrivacyLevel.ONLY_FRIEND);
			}else if(level==3){
				up.setPrivacyLevel(PrivacyLevel.CLOSED);
			}else if(level==4){
				up.setPrivacyLevel(PrivacyLevel.TAGED_FRIEND);
			}else if(level==5){
				up.setPrivacyLevel(PrivacyLevel.GROUP_MEMBER);
			}
			up.setWriter(new UserPublicInfo(paib.getPostingViewBean().getName(), paib.getPostingViewBean().getId(), paib.getPostingViewBean().getProfileImg()));
			
			if(paib.getPostingViewBean().getMypageTitle()!=null){ //마이페이지
				((MyPagePost)up).setMyPageTitle(paib.getPostingViewBean().getMypageTitle());
				if(userMyPagePostList.get(id)!=null)
					userMyPagePostList.get(id).writeMyPagePost((MyPagePost)up);
			}else if(paib.getPostingViewBean().getGuestId()!=null){ //방명록
				((GuestPost)up).setReceiverId(paib.getPostingViewBean().getGuestId());
				if(userGuestPostList.get(id)!=null)
					userGuestPostList.get(id).writeGuestPost((GuestPost)up);
			}else if(paib.getPostingViewBean().getOriginPostNo()!=0){
				PostingViewDTO pvd = PostCommentDBManager.getInstance().getPostingView(paib.getPostingViewBean().getOriginPostNo());
				PostContent originPostContent = new PostContent();
				originPostContent.setContent(paib.getPostingViewBean().getOriginPostContent());
				originPostContent.setImg(paib.getPostingViewBean().getOriginPostImg());
				originPostContent.setTagFriends(paib.getPostingViewBean().getOriginTagUsers());
				originPostContent.setVideo(paib.getPostingViewBean().getOriginVideo());
				((SharePost) up).setOriginPost(new OriginPost(pvd.getPostNo(), originPostContent, pvd.getId()));
			}
			else if(paib.getPostingViewBean().getGroupNo()!=0){ //그룹글
				((GroupPost) up).setGroupNo(paib.getPostingViewBean().getGroupNo());
			}else{
				if(userPostList.get(id)!=null)
					userPostList.get(id).writePost(up);
			}
			
			
			//댓글 세팅
			if(cvbList.size()>0){
				for(CommentViewBean cvb : cvbList){
					CommentContent cc = new CommentContent();
					cc.setComment(cvb.getCommentContent());
					cc.setTagFriends(paib.getCommentTagFriends());
					Comment comment = new Comment();
					comment.setCommentContent(cc);
					comment.setCommentDate(cvb.getCommentDate());
					comment.setCommentNo(cvb.getCommentNo());

					level = cvb.getPrivacyLevel();
					if(level==1){
						comment.setPrivacyLevel(PrivacyLevel.ALL);
					}else if(level==2){
						comment.setPrivacyLevel(PrivacyLevel.ONLY_FRIEND);
					}else if(level==3){
						comment.setPrivacyLevel(PrivacyLevel.CLOSED);
					}else if(level==4){
						comment.setPrivacyLevel(PrivacyLevel.TAGED_FRIEND);
					}else if(level==5){
						comment.setPrivacyLevel(PrivacyLevel.GROUP_MEMBER);
					}
					comment.setWriter(new UserPublicInfo(cvb.getWriterId(), cvb.getWriterName(), cvb.getWriterPorifleImg()));
					if(commentList.get(id)!=null)
						commentList.get(id).writeComment(paib.getPostingViewBean().getPostNo(), comment);
				}
			}
		}
	}
	private void addPost(List<PostAllInfoBean> postList, PostingViewDTO postingViewDTO, int activityKind){
		if(!checkRepeatPost(postList, postingViewDTO)){
			PostAllInfoBean postAllInfoBean = new PostAllInfoBean();
			
			PostingViewBean postingViewBean = new PostingViewBean();
			postingViewBean.setCommentNum(postingViewDTO.getCommentNum());
			postingViewBean.setFriendId(postingViewDTO.getFriendId());
			postingViewBean.setFriendName(postingViewDTO.getFriendName());
			postingViewBean.setGroupNo(postingViewDTO.getGroupNo());
			postingViewBean.setGuestId(postingViewDTO.getGuestId());
			postingViewBean.setHateNum(postingViewDTO.getHateNum());
			postingViewBean.setId(postingViewDTO.getId());
			postingViewBean.setLikeNBukkuNum(postingViewDTO.getLikeNBukkuNum());
			postingViewBean.setMypageTitle(postingViewDTO.getMypageTitle());
			postingViewBean.setName(postingViewDTO.getName());
			postingViewBean.setOriginPostNo(postingViewDTO.getOriginPostNo());
			postingViewBean.setPostContent(postingViewDTO.getPostContent());
			postingViewBean.setPostContentNo(postingViewDTO.getPostContentNo());
			postingViewBean.setPostDate(postingViewDTO.getPostDate());
			postingViewBean.setPostNo(postingViewDTO.getPostNo());
			postingViewBean.setPrivacyLevel(postingViewDTO.getPrivacyLevel());
			postingViewBean.setProfileImg(postingViewDTO.getProfileImg());
			postingViewBean.setReportNum(postingViewDTO.getReportNum());
			postingViewBean.setShareNum(postingViewDTO.getShareNum());
			postingViewBean.setStandardTime(postingViewDTO.getStandardTime());
			postingViewBean.setVideo(postingViewDTO.getVideo());
			
			postAllInfoBean.setPostingViewBean(postingViewBean);
			postAllInfoBean.setActivityKind(activityKind); 
			postList.add(postAllInfoBean);
		}
		
	}
	private boolean checkRepeatPost(List<PostAllInfoBean> postList, PostingViewDTO postingViewDTO){
		if(postList.size()>0){
			for(PostAllInfoBean paib : postList){
				if(paib.getPostingViewBean().getPostNo()==postingViewDTO.getPostNo()){
					return true;
				}
			}
		}
		return false;
	}

	private List<PostAllInfoBean> sortPost(List<PostAllInfoBean> postList){
		int i=0,j=0;
		int max;
		int listSize = postList.size();
		List<PostAllInfoBean> pList = new ArrayList<PostAllInfoBean>();
		if(listSize>1){
		SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		for(i=0; postList.size()>1; i++){
			max=i;
			for(j=i+1; j<postList.size(); j++){
				Date date2 = null;
				try {
					PostAllInfoBean pvd = postList.get(max);
					Date date1=null;
					date1 = formatter.parse(pvd.getPostingViewBean().getStandardTime());
					date2 = formatter.parse(postList.get(j).getPostingViewBean().getStandardTime());
					if(date1.getTime()<date2.getTime()){
						max = j;
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			pList.add(postList.get(max));
			postList.remove(max);
			i=0;
			System.out.println("j : "+j);
		}
	}
		if(postList.size()!=0)
			pList.add(postList.get(0));
		return pList;
	}
	
	public Integer writePostDB(UserPostForm userPostForm, UserPublicBean upb){
		UserPost up = makeUserPost(userPostForm, upb);
		return PostCommentDBManager.getInstance().writePost(up);
	}
	private UserPost makeUserPost(UserPostForm userPostForm, UserPublicBean upb){
		PostValidator pv = new PostValidator();
		pv.validate(userPostForm);
		PostContent pc = new PostContent();
		pc.setContent(userPostForm.getContents());
		pc.setImg(userPostForm.getimageList());
		pc.setTagFriends(userPostForm.getTagFriends());
		pc.setVideo(userPostForm.getVideo());
		UserPost up = new UserPost();
		up.setPostContent(pc);
		UserPublicInfo upi = new UserPublicInfo();
		upi.setId(upb.getId());
		upi.setName(upb.getName());
		upi.setPicture(upb.getProfileImg());
		up.setWriter(upi);
		up.setPrivacyLevel(userPostForm.getPrivacyLevel());
		return up;
	}
	public Integer writeGuestPostDB(UserPostForm userPostForm, UserPublicBean upb, String guestId){
		UserPost up = makeUserPost(userPostForm, upb);
		return PostCommentDBManager.getInstance().writeGuestPostDB(up, guestId);
	}
	public Integer writeMyPagePostDB(UserPostForm userPostForm, UserPublicBean upb, String title){
		UserPost up = makeUserPost(userPostForm, upb);
		return PostCommentDBManager.getInstance().writeMyPagePostDB(up, title); 
	}
	public Integer deletePostDB(int postNo){
		return PostCommentDBManager.getInstance().deletePost(postNo);
	}
	public int writeComment(CommentForm commentForm, int postNo, UserPublicBean upb){
		CommentContent cc = new CommentContent();
		cc.setComment(commentForm.getComment());
		Comment c = new Comment();
		c.setCommentContent(cc);
		c.setPrivacyLevel(commentForm.getPrivacyLevel());
		UserPublicInfo upi = new UserPublicInfo();
		upi.setId(upb.getId());
		upi.setName(upb.getName());
		upi.setPicture(upb.getProfileImg());
		c.setWriter(upi);
		
		return PostCommentDBManager.getInstance().writeComment(postNo, c);
	}
	public Integer deleteComment(int commentNo){
		return PostCommentDBManager.getInstance().deleteComment(commentNo);
	}
	
	public PostAllInfoBean showOnePost(String id, int postNo){
		List<PostAllInfoBean> posts = new ArrayList<PostAllInfoBean>();
		PostingViewDTO post = PostCommentDBManager.getInstance().getPostingView(postNo);
		if(posts!=null){
				addPost(posts, post, 0); //일반 글
		}
		if(posts.get(0)!=null)
			return posts.get(0);
		else
			return null;
	}
	public List<PostAllInfoBean> showMyPost(String id){ //내 타임라인
		List<PostAllInfoBean> homePosts = new ArrayList<PostAllInfoBean>();
		
		List<PostingViewDTO> myPosts = PostCommentDBManager.getInstance().getMyPosts(id);
		if(myPosts!=null){
			for(PostingViewDTO pvd : myPosts){
				addPost(homePosts, pvd, 0); //일반 글
			}
		}
		
		List<PostingViewDTO> guestPosts = PostCommentDBManager.getInstance().getGuestPost(id);
		if(guestPosts!=null){
			for(PostingViewDTO pvd : guestPosts){
				addPost(homePosts, pvd, 5); //친구가 쓴 글 
			}
		}
		
		homePosts = sortPost(homePosts);
		
		loadPost(homePosts, id);
		return homePosts;
	}
	
	
	public List<PostAllInfoBean> showMyPagePost(String id, String title){ //마이페이지
		List<PostAllInfoBean> homePosts = new ArrayList<PostAllInfoBean>();
		
		List<PostingViewDTO> myPosts = PostCommentDBManager.getInstance().getMyPagePostsByTitle(title);
		if(myPosts!=null){
			for(PostingViewDTO pvd : myPosts){
				addPost(homePosts, pvd, 1);
			}
		}
		
		homePosts = sortPost(homePosts);
		loadPost(homePosts, id);
		
		return homePosts;
	}
	
	public void recommendPost(int postNo, int recommendKind,String id){
		PostCommentDBManager.getInstance().recommendPost(recommendKind, postNo, id);
	}
	public void modifyPost(UserPostForm userPostForm, int postNo){
		PostValidator pv = new PostValidator();
		pv.validate(userPostForm);
		UserPost userPost = new UserPost();
		PostContent pc = new PostContent();
		pc.setContent(userPostForm.getContents());
		pc.setImg(userPostForm.getimageList());
		pc.setVideo(userPostForm.getVideo());
		pc.setTagFriends(userPostForm.getTagFriends());
		userPost.setPostContent(pc);
		userPost.setPrivacyLevel(userPostForm.getPrivacyLevel());
		userPost.setPostNo(postNo);
		PostCommentDBManager.getInstance().modifyPost(userPost);
	}
	
	public List<PostAllInfoBean> searchMyPosts(String id, String content, String startDate, String lastDate){
		List<PostingViewDTO> searchedList = PostCommentDBManager.getInstance().searchMyPost(id, content, startDate, lastDate);
		System.out.println(searchedList);
		List<PostAllInfoBean> paibList = new ArrayList<PostAllInfoBean>(); 
		
		for(PostingViewDTO pvd : searchedList){
			addPost(paibList, pvd, 0);
		}
		
		loadPost(paibList, id);
		
		
		return paibList;
	}
	
	public String getPostWriter(int postNo){
		return PostCommentDBManager.getInstance().getPostWriter(postNo);
	}
	
	public static void main(String[] args){
		System.out.println(PostCommentController.getInstance().showHomePost("id1"));
	}
	
}
