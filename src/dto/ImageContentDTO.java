package dto;

import java.io.Serializable;

public class ImageContentDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2118926997981987326L;
	private int imageContentNo;
	private String image;
	private int postContentNo;
	public ImageContentDTO() {
		// TODO Auto-generated constructor stub
	}
	public ImageContentDTO(int imageContentNo, String image, int postContentNo) {
		super();
		this.imageContentNo = imageContentNo;
		this.image = image;
		this.postContentNo = postContentNo;
	}
	public int getImageContentNo() {
		return imageContentNo;
	}
	public void setImageContentNo(int imageContentNo) {
		this.imageContentNo = imageContentNo;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getPostContentNo() {
		return postContentNo;
	}
	public void setPostContentNo(int postContentNo) {
		this.postContentNo = postContentNo;
	}
	@Override
	public String toString() {
		return "ImageContentDTO [imageContentNo=" + imageContentNo + ", image="
				+ image + ", postContentNo=" + postContentNo + "]";
	}
	
}
