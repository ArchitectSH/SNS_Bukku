package model;

public enum BukkuLevel {
	NOT_FRIEND("ģ���� �ƴ� ����"), JUST_FRIEND("���� �� ģ���� �� ����"), AWKWARD_FRIEND(
			"����� ģ�� ����"), KNOWING_FRIEND("���θ� �˾ư��� ����"), CLOSE_FRIEND("�Ϳ���� ����"), ATTI(
			"�ƶ�");
	private String bukkuLevel;

	BukkuLevel(String bukkuLevel) {
		this.bukkuLevel = bukkuLevel;
	}

	public String getBukkuLevel() {
		return this.bukkuLevel;
	}

}
