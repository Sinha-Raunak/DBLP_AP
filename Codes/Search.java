import java.util.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.*;

public class Search {
	
	
	public ArrayList<Data> searchAuthor(String auth,Entity ee)
	{
		
		wwwEntity ent=ee.getList(auth);
		ArrayList<Data> dlist=null;
		
		try {	
	         File inputFile = new File("testDBLP.xml");
	         //File inputFile = new File("dblp.xml");
	         SAXParserFactory factory = SAXParserFactory.newInstance();
	         SAXParser saxParser = factory.newSAXParser();
	         SearchHandler userhandler = new SearchHandler(auth,ent,1); //1 -not by reference,2-for reference
	         
	         dlist=userhandler.getList();
	         saxParser.parse(inputFile, userhandler);     
	         System.out.println("HIHIHIHIHIHIHIHIHIHIHIHHIHIHIHIIIHIHI");
		} catch (Exception e) {
	         e.printStackTrace();
	    }
		//TODO do stuff here 
		return dlist;
	}
}
