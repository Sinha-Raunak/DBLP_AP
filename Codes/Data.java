import java.util.*;

public class Data  {
	private ArrayList<String> author;
	private String title;
	private String pages;
	private String year;
	private String volume;
	private String journal;
	private String url;
	private float refcount;
	
	Data()
	{
		author=new ArrayList<String>();
		title=new String("null");
		pages=new String("null");
		year=null;
		volume=new String("null");
		journal=new String("null");
		url=new String("null");
		refcount=0f;
	}
	
	public void setAuthor(String str)
	{
		author.add(str);
	}
	
	public String getAuthor()//returns only the first author based on which the files will be divided
	{
		return author.get(0);
	}
	
	public ArrayList<String> getAuthors()
	{
		return author;
	}
	
	public void setTitle(String str)
	{
		title=new String(str);
	}
	
	public void setPages(String str)
	{
		pages=new String(str);
	}
	
	public void setYear(String str)
	{
		year=new String(str);
	}
	
	public void setVolume(String str)
	{
		volume=new String(str);
	}
	
	public void setJournal(String str)
	{
		journal=new String(str);
	}
	
	public void setUrl(String str)
	{
		url=new String(str);
	}
	
	public Integer getYear()
	{
		return Integer.parseInt(year);
	}
	
	public void setRefcount(float i)
	{
		refcount=i;
	}
	
	public float getRefcount()
	{
		return refcount;
	}
	
	
}
