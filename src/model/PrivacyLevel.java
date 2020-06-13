package model;

import java.io.Serializable;

public enum PrivacyLevel implements Serializable{
	ONLY_FRIEND("친구만 공개"), ALL("전체공개"), CLOSED("비공개"), GROUP_MEMBER("그룹멤버에게 공개"), TAGED_FRIEND("태그한 사람에게만 공개");				 
	final private String level;
	PrivacyLevel(String level){ this.level = level; }
	String getName(){ return level; }
}