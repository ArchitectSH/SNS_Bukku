package model;

public enum SearchLevel {

	ALL("��ü ����"),ONLY_FRIENDS("ģ���� ����"),NO_SEARCH("������");
	private String searchLevel;

	SearchLevel(String searchLevel)
	{
		this.searchLevel=searchLevel;
	}
	public String getSearchLevel()
	{return this.searchLevel;}

}
