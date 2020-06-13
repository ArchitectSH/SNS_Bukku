package dto;

public class BlockUserDTO {
	private int blockUserNo;
	private String blockedId;
	private String blockRequestId;
	public BlockUserDTO() {
		// TODO Auto-generated constructor stub
	}
	public BlockUserDTO(int blockUserNo, String blockedId,
			String blockRequestId) {
		super();
		this.blockUserNo = blockUserNo;
		this.blockedId = blockedId;
		this.blockRequestId = blockRequestId;
	}
	public int getBlockUserNo() {
		return blockUserNo;
	}
	public void setBlockUserNo(int blockUserNo) {
		this.blockUserNo = blockUserNo;
	}
	public String getBlockedId() {
		return blockedId;
	}
	public void setBlockedId(String blockedId) {
		this.blockedId = blockedId;
	}
	public String getBlockRequestId() {
		return blockRequestId;
	}
	public void setBlockRequestId(String blockRequestId) {
		this.blockRequestId = blockRequestId;
	}
	@Override
	public String toString() {
		return "BlockUserDTO [blockUserNo=" + blockUserNo + ", blockedId="
				+ blockedId + ", blockRequestId=" + blockRequestId + "]";
	}
	
}
