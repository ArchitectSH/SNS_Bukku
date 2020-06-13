package model;

public enum BukkuLevel {
	NOT_FRIEND("친구가 아닌 사이"), JUST_FRIEND("이제 막 친구가 된 사이"), AWKWARD_FRIEND(
			"어색한 친구 사이"), KNOWING_FRIEND("서로를 알아가는 사이"), CLOSE_FRIEND("터울없는 사이"), ATTI(
			"아띠");
	private String bukkuLevel;

	BukkuLevel(String bukkuLevel) {
		this.bukkuLevel = bukkuLevel;
	}

	public String getBukkuLevel() {
		return this.bukkuLevel;
	}

}
