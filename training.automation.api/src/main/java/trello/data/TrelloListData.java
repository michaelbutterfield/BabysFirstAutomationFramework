package trello.data;

import java.util.ArrayList;

public class TrelloListData
{
	private String id;
	private String name;
	public ArrayList<Object> lists = new ArrayList < Object > ();
	
	public String getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
