import java.util.*;
import java.io.*;
public class Article implements Serializable {
	private ArrayList<String> author;
	private String title;
	private String pages;
	private String year;
	private String volume;
	private String journal;
	private String number;
	private String url;
	private String ee;
	
	Article()
	{
		author=new ArrayList<String>();
		title=new String();
		pages=new String();
		year=new String();
		volume=new String();
		journal=new String();
		number=new String();
		url=new String();
		ee=new String();
		
	}
	
	
	public void setAuthor(String str)
	{
		author.add(str);
	}
	
	public String getAuthor()//returns only the first author 
	{
		return author.get(0);
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
	
	public void setNumber(String str)
	{
		number=new String(str);
	}
	
	public void setUrl(String str)
	{
		url=new String(str);
	}
	
	public void setEE(String str)
	{
		ee=new String(str);
	}
	
	//public void toString()
	
}
