package model;

public class SharePost extends UserPost{
	private OriginPost originPost;
	public SharePost() {
		// TODO Auto-generated constructor stub
	}
	public SharePost(OriginPost originPost, int postNo, PostContent postContent, UserPublicInfo writer,
			PrivacyLevel privacyLevel, String postingTime) {
		super(postNo, postContent, writer, privacyLevel, postingTime);
		this.originPost = originPost;
	}
	public OriginPost getOriginPost() {
		return originPost;
	}
	public void setOriginPost(OriginPost originPost) {
		this.originPost = originPost;
	}
	@Override
	public String toString() {
		return "SharePost [originPost=" + originPost + "]";
	}

	
	
}
