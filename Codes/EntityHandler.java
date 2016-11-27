import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;
public class EntityHandler extends DefaultHandler {
	
	boolean bAuthor=false;
	
	String tempchar;
	boolean isEntity=false;
	ArrayList<wwwEntity> entlist;
	wwwEntity ent;
	
	EntityHandler()
	{
		entlist=new ArrayList<wwwEntity>();
		ent=new wwwEntity();
		tempchar=new String("");
	}
	
	
	
	
	public void startElement(String uri,String localName, String qName, Attributes attributes) throws SAXException 
	{
			      if(qName.equalsIgnoreCase("www")){
			    	  String tmmp=attributes.getValue("key");
			    	  if(tmmp.contains("homepages/"))
			    	  {
			    		  isEntity=true;
			    	  }
			    	  else
			    	  {
			    		  isEntity=false;
			    	  }
			    	  
			      } 
			      else if (qName.equalsIgnoreCase("author")) 
			      {
			         bAuthor = true;
			      } 
	}

	@Override
	public void endElement(String uri,String localName, String qName) throws SAXException
	{
			      
		 if(qName.equalsIgnoreCase("www"))
		 {
			     if(isEntity)
			     {
			    		  entlist.add(ent);
			    		  ent=new wwwEntity();
			    		  tempchar=new String("");
			    		  isEntity=false;
			     }
		}
		else if(bAuthor)
		{
			if(isEntity)
			{
				ent.addAuthor(tempchar);
			}
			tempchar=new String("");
			bAuthor=false;
		}
		else
		{
			tempchar=new String("");
		}
	}

	@Override
	public void characters(char ch[],int start, int length) throws SAXException
	{
		tempchar += new String(ch, start, length);
	}
			   
	public ArrayList<wwwEntity> getList()
	{
	   return entlist;
	}

}
