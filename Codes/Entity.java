import java.io.*;
import java.util.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Entity {
	ArrayList<wwwEntity> entList;
	
	
	Entity()
	{
		initialize();
	}
	
	public void initialize()
	{
		System.setProperty("jdk.xml.entityExpansionLimit", "0");
		try {	
	         File inputFile = new File("testDBLP.xml");
	         //File inputFile = new File("dblp.xml");
	         SAXParserFactory factory = SAXParserFactory.newInstance();
	         SAXParser saxParser = factory.newSAXParser();
	         EntityHandler userhandler = new EntityHandler();
	         
	         saxParser.parse(inputFile, userhandler);     
	         entList=userhandler.getList();
	         System.out.println("Size="+userhandler.getList().size());
	         System.out.println("HIHIHIHIHIHIHIHIHIHIHIHHIHIHIHIIIHIHI");
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
}
