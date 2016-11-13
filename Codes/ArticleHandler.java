import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;

public class ArticleHandler extends DefaultHandler {
	
	boolean bAuthor=false;
	boolean bTitle=false;
	boolean bPages=false;
	boolean bYear=false;
	boolean bVolume=false;
	boolean bJournal=false;
	boolean bNumber=false;
	boolean bUrl=false;
	boolean bEE=false;
	
	ArrayList<Article> artlist;
	Article tempart;
	
	ArticleHandler()
	{
		artlist=new ArrayList<Article>();
		tempart=new Article();
	}
	
	
	
	
	public void startElement(String uri, 
			   String localName, String qName, Attributes attributes)
			      throws SAXException {
			      if (qName.equalsIgnoreCase("article")) {
			         //String rollNo = attributes.getValue("rollno");
			         //System.out.println("Roll No : " + rollNo);
			      } else if (qName.equalsIgnoreCase("author")) {
			         bAuthor = true;
			      } else if (qName.equalsIgnoreCase("title")) {
			         bTitle = true;
			      } else if (qName.equalsIgnoreCase("pages")) {
			         bPages = true;
			      }
			      else if (qName.equalsIgnoreCase("year")) {
			         bYear = true;
			      }
			      else if (qName.equalsIgnoreCase("volume")) {
				         bVolume = true;
				  }
			      else if (qName.equalsIgnoreCase("journal")) {
				         bJournal = true;
			      }
			      else if (qName.equalsIgnoreCase("number")) {
				         bNumber = true;
				  }
			      else if (qName.equalsIgnoreCase("url")) {
				         bUrl = true;
				  }
			      else if (qName.equalsIgnoreCase("ee")) {
				         bEE = true;
				  }
			   }

			   @Override
			   public void endElement(String uri, 
			   String localName, String qName) throws SAXException {
			      if (qName.equalsIgnoreCase("article")) {
			         System.out.println("End Element :" + qName);
			         artlist.add(tempart);
			         tempart=new Article();
			      }
			   }

			   @Override
			   public void characters(char ch[], 
			      int start, int length) throws SAXException {
			      if(bAuthor)
			      {
			    	  tempart.setAuthor(new String(ch,start,length));
			    	  bAuthor=false;
			    	  
			      }
			      else if(bTitle)
			      {
			    	  tempart.setTitle(new String(ch,start,length));
			    	  bTitle=false;
			      }
			      else if(bPages)
			      {
			    	  tempart.setPages(new String(ch,start,length));
			    	  bPages=false;
			      }
			      else if(bYear)
			      {
			    	  tempart.setYear(new String(ch,start,length));
			    	  bYear=false;
			      }
			      else if(bVolume)
			      {
			    	  tempart.setVolume(new String(ch,start,length));
			    	  bVolume=false;
			      }
			      else if(bJournal)
			      {
			    	  tempart.setJournal(new String(ch,start,length));
			    	  bJournal=false;
			      }
			      else if(bNumber)
			      {
			    	  tempart.setNumber(new String(ch,start,length));
			    	  bNumber=false;
			      }
			      else if(bUrl)
			      {
			    	  tempart.setUrl(new String(ch,start,length));
			    	  bUrl=false;
			      }
			      else if(bEE)
			      {
			    	  tempart.setEE(new String(ch,start,length));
			    	  bEE=false;
			      }
			    	  
			   }
			   
			   
			   public ArrayList<Article> getList()
			   {
				   return artlist;
			   }
	
	
	
}
