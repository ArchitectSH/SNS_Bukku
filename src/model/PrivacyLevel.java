package model;

import java.io.Serializable;

public enum PrivacyLevel implements Serializable{
	ONLY_FRIEND("ģ���� ����"), ALL("��ü����"), CLOSED("�����"), GROUP_MEMBER("�׷������� ����"), TAGED_FRIEND("�±��� ������Ը� ����");				 
	final private String level;
	PrivacyLevel(String level){ this.level = level; }
	String getName(){ return level; }
}