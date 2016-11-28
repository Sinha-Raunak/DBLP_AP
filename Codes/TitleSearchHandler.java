import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;

public class TitleSearchHandler extends DefaultHandler{
	
	boolean bAuthor=false;
	boolean bTitle=false;
	boolean bPages=false;
	boolean bYear=false;
	boolean bVolume=false;
	boolean bJournal=false;
	boolean bUrl=false;
	
	String tempchar;	
	boolean resultFound = false;
	boolean isEntity=false;
	ArrayList<Data> artlist;
	Data tempart;
	String title;
	String []titlesplit;
	
	TitleSearchHandler(String titles)
	{
		artlist=new ArrayList<Data>();
		tempart=new Data();
		tempchar=new String("");
		this.title=titles;
		titlesplit=title.toLowerCase().split("[ -]");
		
		
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
			      else if (qName.equalsIgnoreCase("title")) {
				         bTitle = true;
				  } 
			      else if (qName.equalsIgnoreCase("pages")) {
				         bPages = true;
				  }
				  else if (qName.equalsIgnoreCase("year")) {
				         bYear = true;
				  }
				  else if (qName.equalsIgnoreCase("volume")) {
					         bVolume = true;
				  }
				  else if (qName.equalsIgnoreCase("journal")  || qName.equalsIgnoreCase("booktitle")) {
					         bJournal = true;
				  }
				  else if (qName.equalsIgnoreCase("url")) {
					         bUrl = true;
				  }
	}

	@Override
	public void endElement(String uri,String localName, String qName) throws SAXException
	{
			      
		if (qName.equalsIgnoreCase("article") ||  qName.equalsIgnoreCase("inproceedings") || qName.equalsIgnoreCase("incollection") || qName.equalsIgnoreCase("phdthesis") ) 
		{
			 if(resultFound)
			 {
				 artlist.add(tempart);
			 }
	         tempart=new Data();
	         tempchar=new String("");
	    	 resultFound=false;
	         isEntity=false;
	    }
	    else if(qName.equalsIgnoreCase("www"))
	    {
	    	  if(isEntity=false)
	    	  {
	    		if(resultFound)
	    		{
	    			artlist.add(tempart);
	    		}
	    		tempart=new Data();
			    resultFound=false;
			    tempchar=new String("");
			    isEntity=false;
			  }
	    	  
	    }
	    else if(bAuthor)
	    {
	    	  if(isEntity==false)
	    	  {
		    	tempart.setAuthor(tempchar);
	    	  }
	    	  tempchar=new String("");
	    	  bAuthor=false;
	    	  
	     }
	     else if(bTitle && isEntity==false)
	     {
	    	 
		    	  if(tempchar.toLowerCase().equals(title.toLowerCase()))
		    	  {
		    		  resultFound=true;
		    	  }
		     
	    		  String []temp1=tempchar.split(" ");
	    		  int count=0;
	    		  for(String s:titlesplit)
	    		  {
	    			  for(String str:temp1)
	    			  {
	    				  if(s.toLowerCase().equals(str.toLowerCase()))
	    				  {
	    					  count++;
	    				  }
	    			  }
	    		  }
	    		  if(count>0)
	    		  {
	    			  resultFound=true;
	    			  tempart.setRefcount(count/tempchar.length());
	    		  }
	    	 
	    	  tempart.setTitle(tempchar);
	    	  
	    	  tempchar=new String("");
	    	  bTitle=false;
	     }
	     else if(bPages && isEntity==false)
	     {
	    	  tempart.setPages(tempchar);
	    	  
	    	  tempchar=new String("");
	    	  bPages=false;
	     }
	     else if(bYear && isEntity==false)
	     {
	    	  tempart.setYear(tempchar);
	    	  
	    	  tempchar=new String("");
	    	  bYear=false;
	     }
	     else if(bVolume && isEntity==false)
	     {
	    	  tempart.setVolume(tempchar);
	    	  
	    	  tempchar=new String("");
	    	  bVolume=false;
	     }
	     else if(bJournal && isEntity==false)
	     {
	    	  tempart.setJournal(tempchar);
	    	  
	    	  tempchar=new String("");
	    	  bJournal=false;
	     }
	     else if(bUrl && isEntity==false)
	     {
	    	  tempart.setUrl(tempchar);
	    	  
	    	  tempchar=new String("");
	    	  bUrl=false;
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
	
	
	public ArrayList<Data> getList()
	{
		return artlist;
	}
	

}
