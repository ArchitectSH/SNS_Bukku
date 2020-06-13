package dto;

import java.io.Serializable;

public class PrivacyDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4812466526235519483L;
	private int privacyLevel;
	private String privacyContent;
	
	public PrivacyDTO() {
		// TODO Auto-generated constructor stub
	}

	public PrivacyDTO(int privacyLevel, String privacyContent) {
		super();
		this.privacyLevel = privacyLevel;
		this.privacyContent = privacyContent;
	}

	/**
	 * @return the privacyLevel
	 */
	public int getPrivacyLevel() {
		return privacyLevel;
	}

	/**
	 * @param privacyLevel the privacyLevel to set
	 */
	public void setPrivacyLevel(int privacyLevel) {
		this.privacyLevel = privacyLevel;
	}

	/**
	 * @return the privacyContent
	 */
	public String getPrivacyContent() {
		return privacyContent;
	}

	/**
	 * @param privacyContent the privacyContent to set
	 */
	public void setPrivacyContent(String privacyContent) {
		this.privacyContent = privacyContent;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PrivacyDTO [privacyLevel=" + privacyLevel + ", privacyContent="
				+ privacyContent + "]";
	}
	
}
