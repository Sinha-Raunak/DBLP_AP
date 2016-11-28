import java.io.*;
import java.util.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Publication {
	
	Map<String,Integer> publiList;
	Entity ent;
	
	Publication(Entity en)
	{
		publiList=new HashMap<String,Integer>();
		ent=en;
		initialize();
	}
	
	public void initialize()
	{
		System.setProperty("jdk.xml.entityExpansionLimit", "0");
		try {	
			 System.out.println("Starting Publication");
	        
			 //File inputFile = new File("testDBLP.xml");
	         File inputFile = new File("dblp.xml");
	         SAXParserFactory factory = SAXParserFactory.newInstance();
	         SAXParser saxParser = factory.newSAXParser();
	         PublicationHandler userhandler = new PublicationHandler(ent);
	         
	         saxParser.parse(inputFile, userhandler);     
	         publiList=userhandler.getList();
	         System.out.println("PUBLICATIONS DONE");
		} catch (Exception e) {
	         e.printStackTrace();
	    }
	}
	
	public ArrayList<String> SearchMoreThan(int k)
	{
		ArrayList<String> auth=new ArrayList<String>();
		Set<String> authList=publiList.keySet();
		Iterator<String> it=authList.iterator();
		int tt=0,i=0;
		while(it.hasNext())
		{
			String tmp=it.next();
			tt=publiList.get(tmp);
			if(tt>i)
			{
				i=tt;
			}
			if(tt>k)
			{
				auth.add(tmp);
			}
			
		}
		System.out.println("The most publications is= "+i);
		return auth;
	}
	
	
	
}
