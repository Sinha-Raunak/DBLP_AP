//***************************************
//          Author tag
//Raunak Sinha-2015075
//Ishbir Walia-2015041
//****************************************

import java.util.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.*;

public class Search {
	
	
	private ArrayList<Data> searchAuthor(String auth,Entity ee)
	{
		
		wwwEntity ent=ee.getList(auth);
		if(ent!=null)
		{
			for(String s:ent.getAuthors())
			{
				System.out.println(s);
			}
		}
		ArrayList<Data> dlist=null;
		System.setProperty("jdk.xml.entityExpansionLimit", "0");
		
		try {	
			 System.out.println("Search starting");
	         
			 //File inputFile = new File("testDBLP.xml");
	         File inputFile = new File("dblp.xml");
	         SAXParserFactory factory = SAXParserFactory.newInstance();
	         SAXParser saxParser = factory.newSAXParser();
	         SearchHandler userhandler = new SearchHandler(auth,ent); 
	         
	         dlist=userhandler.getList();
	         saxParser.parse(inputFile, userhandler);     
	         System.out.println("Search ended");
		} catch (Exception e) {
	         e.printStackTrace();
	    }
		return dlist;
	}
	
	private ArrayList<Data> searchTitle(String title)
	{
		
		ArrayList<Data> dlist=null;
		System.setProperty("jdk.xml.entityExpansionLimit", "0");
		
		try {	
			 System.out.println("Search starting");
	         
			 //File inputFile = new File("testDBLP.xml");
	         File inputFile = new File("dblp.xml");
	         SAXParserFactory factory = SAXParserFactory.newInstance();
	         SAXParser saxParser = factory.newSAXParser();
	         TitleSearchHandler userhandler = new TitleSearchHandler(title); 
	         
	         dlist=userhandler.getList();
	         saxParser.parse(inputFile, userhandler);     
	         System.out.println("Search ended");
		} catch (Exception e) {
	         e.printStackTrace();
	    }
		return dlist;
	}
	
	
	
	public ArrayList<Data> searchAuthorandType(String auth,Entity ent,int type)  //only for sorting by relevance and reverse sort and normal sort 
	{
		ArrayList<Data> dlist;
		dlist=searchAuthor(auth,ent);
		
		if(type==0)//normal sort by year(descending)
		{
			if(dlist!=null)
			{
				Collections.sort(dlist,new ByYear());
			}
		}
		else if(type==1)//for reverse sorting by year
		{
			if(dlist!=null)
			{
				
				Collections.sort(dlist,new RevYear());
			}
		}
		else if(type==2)//for sorting by relevance
		{
			if(dlist!=null)
			{
				Collections.sort(dlist,new ByRelevance());
			}
		}
		return dlist;
	}
	
	public ArrayList<Data> searchAuthorBetween(String auth,Entity ent,int start,int end) //only for inbetween years
	{
		
		ArrayList<Data> dlist;
		dlist=searchAuthor(auth,ent);
		ArrayList<Data> dupli=new ArrayList<Data>();
		for(Data tmp:dlist)
		{
			if(tmp.getYear()>=start && tmp.getYear()<=end)
			{
				dupli.add(tmp);
			}
		}
		
		//gonna sort in ascending order
		Collections.sort(dupli,new RevYear());
		
		return dupli;
	}
	
	
	public ArrayList<Data> searchAuthorAfter(String auth,Entity ent,int start) //only for after x years
	{
		ArrayList<Data> dlist;
		dlist=searchAuthor(auth,ent);
		ArrayList<Data> dupli=new ArrayList<Data>();
		for(Data tmp:dlist)
		{
			if(tmp.getYear()>=start)
			{
				dupli.add(tmp);
			}
		}
		
		//gonna sort it in ascending order
		Collections.sort(dupli,new RevYear());
		
		return dupli;
	}
	public ArrayList<Data> searchTitleandType(String title,int type)  //only for sorting by relevance and reverse sort and normal sort 
	{
		ArrayList<Data> dlist;
		dlist=searchTitle(title);
		
		if(type==0)//normal sort by year(descending)
		{
			if(dlist!=null)
			{
				Collections.sort(dlist,new ByYear());
			}
		}
		else if(type==1)//for reverse sorting by year
		{
			if(dlist!=null)
			{
				
				Collections.sort(dlist,new RevYear());
			}
		}
		else if(type==2)//for sorting by relevance
		{
			if(dlist!=null)
			{
				Collections.sort(dlist,new ByRelevance());
			}
		}
		return dlist;
	}
	
	public ArrayList<Data> searchTitleBetween(String title,int start,int end) //only for inbetween years
	{
		
		ArrayList<Data> dlist;
		dlist=searchTitle(title);
		ArrayList<Data> dupli=new ArrayList<Data>();
		for(Data tmp:dlist)
		{
			if(tmp.getYear()>=start && tmp.getYear()<=end)
			{
				dupli.add(tmp);
			}
		}
		
		//gonna sort in ascending order
		Collections.sort(dupli,new RevYear());
		
		return dupli;
	}
	
	
	public ArrayList<Data> searchTitleAfter(String title,int start) //only for after x years
	{
		ArrayList<Data> dlist;
		dlist=searchTitle(title);
		ArrayList<Data> dupli=new ArrayList<Data>();
		for(Data tmp:dlist)
		{
			if(tmp.getYear()>=start)
			{
				dupli.add(tmp);
			}
		}
		
		//gonna sort it in ascending order
		Collections.sort(dupli,new RevYear());
		
		return dupli;
	}

	
}
