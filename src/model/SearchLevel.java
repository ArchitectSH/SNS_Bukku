package model;

public enum SearchLevel {

	ALL("전체 가능"),ONLY_FRIENDS("친구만 가능"),NO_SEARCH("허용안함");
	private String searchLevel;

	SearchLevel(String searchLevel)
	{
		this.searchLevel=searchLevel;
	}
	public String getSearchLevel()
	{return this.searchLevel;}

}
