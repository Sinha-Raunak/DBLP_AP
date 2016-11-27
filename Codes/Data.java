
import java.util.*;
import java.io.*;
public class Data implements Serializable,Comparable<Data> {
	private ArrayList<String> author;
	private String title;
	private String pages;
	private String year;
	private String volume;
	private String journal;
	private String url;
	private int refcount;
	//TODO remove unnecessary comments
	Data()
	{
		author=new ArrayList<String>();
		title=new String("null");
		pages=new String("null");
		year=new String("null");
		volume=new String("null");
		journal=new String("null");
		url=new String("null");
		refcount=0;
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
	
	public int getYear()
	{
		return Integer.parseInt(year);
	}
	
	public void setRefcount(int i)
	{
		refcount=i;
	}
	
	public int compareTo(Data aa)
	{
		//TODO do something to handle types that dont have year
		if(this.getYear()==aa.getYear())
		{
			return 0;
		}
		else if(this.getYear()<aa.getYear())
		{
			return 1;
		}
		else
		{
			return -1;
		}
		
	}
	
	
}
