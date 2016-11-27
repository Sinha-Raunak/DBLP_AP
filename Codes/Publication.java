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
	         File inputFile = new File("testDBLP.xml");
	         //File inputFile = new File("dblp.xml");
	         SAXParserFactory factory = SAXParserFactory.newInstance();
	         SAXParser saxParser = factory.newSAXParser();
	         PublicationHandler userhandler = new PublicationHandler(ent);
	         
	         saxParser.parse(inputFile, userhandler);     
	         publiList=userhandler.getList();
	         System.out.println("HIHIHIHIHIHIHIHIHIHIHIHHIHIHIHIIIHIHI");
		} catch (Exception e) {
	         e.printStackTrace();
	    }
	}
	
	public ArrayList<String> SearchMoreThan(int k)
	{
		ArrayList<String> auth=new ArrayList<String>();
		Set<String> authList=publiList.keySet();
		Iterator<String> it=authList.iterator();
		while(it.hasNext())
		{
			String tmp=it.next();
			if(publiList.get(tmp)>k)
			{
				auth.add(tmp);
			}
			
		}
		return auth;
	}
	
	
	
}
