//***************************************
//          Author tag
//Raunak Sinha-2015075
//Ishbir Walia-2015041
//****************************************

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
	
	public String getURl(){
		return url;
	}
	
	public void setAuthor(String str)
	{
		author.add(str);
	}
	public String getJournal(){
		return journal;
	}
	public String getVolume(){
		return volume;
	}
	public String getPages(){
		return pages;
	}
	public String getTitle(){
		return title;
	}
	public String getAuthor()//returns only the first author based on which the files will be divided
	{
		return author.get(0);
	}
	public String getStringAuthors()
	{
		String tmp=new String("");
		for(String str:author)
		{
			tmp+=str+",";
		}
		return tmp;
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
	
	public String getStringYear()
	{
		return year;
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
