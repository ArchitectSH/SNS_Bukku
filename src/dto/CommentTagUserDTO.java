package dto;

import java.io.Serializable;

public class CommentTagUserDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2070089291378101373L;
	private int commentTagNo;
	private int commentNo;
	private String id;
	public CommentTagUserDTO() {
		// TODO Auto-generated constructor stub
	}
	public CommentTagUserDTO(int commentTagNo, int commentNo, String id) {
		super();
		this.commentTagNo = commentTagNo;
		this.commentNo = commentNo;
		this.id = id;
	}
	public int getCommentTagNo() {
		return commentTagNo;
	}
	public void setCommentTagNo(int commentTagNo) {
		this.commentTagNo = commentTagNo;
	}
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "CommentTagUserDTO [commentTagNo=" + commentTagNo
				+ ", commentNo=" + commentNo + ", id=" + id + "]";
	}
	
}
