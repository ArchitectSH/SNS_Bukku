package model;

public class GuestPost extends UserPost{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6983321687844810824L;
	private String receiverId;
	public GuestPost() {
		// TODO Auto-generated constructor stub
	}
	
	public GuestPost(String receiverId, int postNo, PostContent postContent, UserPublicInfo writer,
			PrivacyLevel privacyLevel, String postingTime) {
		super(postNo, postContent, writer, privacyLevel, postingTime);
		this.receiverId = receiverId;
	}

	public String getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	@Override
	public String toString() {
		return "GuestPost [receiverId=" + receiverId + "]";
	}
	
}
