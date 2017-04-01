//***************************************
//          Author tag
//Raunak Sinha-2015075
//Ishbir Walia-2015041
//****************************************

import java.io.*;
import java.util.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Entity {
	ArrayList<wwwEntity> entList;
	Map<String,String> emap;
	
	Entity()
	{
		initialize();
	}
	
	public void initialize()
	{
		System.setProperty("jdk.xml.entityExpansionLimit", "0");
		try {	
			 System.out.println("Starting entity");
	         
			 //File inputFile = new File("testDBLP.xml");
	         File inputFile = new File("dblp.xml");
	         SAXParserFactory factory = SAXParserFactory.newInstance();
	         SAXParser saxParser = factory.newSAXParser();
	         EntityHandler userhandler = new EntityHandler();
	         
	         saxParser.parse(inputFile, userhandler);     
	         entList=userhandler.getList();
	         emap=userhandler.getMap();
	         System.out.println("Size="+userhandler.getList().size());
	         System.out.println("ENTITY DONE");
		} catch (Exception e) {
	         e.printStackTrace();
	    }
	
	}
	
	public wwwEntity getList(String auth)
	{
		auth=auth.toLowerCase();
		wwwEntity tmp=null;
		for(wwwEntity aa:entList)
		{
			if(aa.getAuthors().contains(auth))
			{
				tmp=aa;
				break;
			}
		}
		return tmp;
		
	}
	public Map<String,String> getMap()
	{
		return emap;
	}
}
