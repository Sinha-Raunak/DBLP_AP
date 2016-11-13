import java.util.*;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class Initialize {
	
	
	
	public void Parse()
	{
		try {	
	         File inputFile = new File("testDBLP.xml");
	         SAXParserFactory factory = SAXParserFactory.newInstance();
	         SAXParser saxParser = factory.newSAXParser();
	         ArticleHandler userhandler = new ArticleHandler();
	         
	         saxParser.parse(inputFile, userhandler);     
	         System.out.println("Size="+userhandler.getList().size());
		} catch (Exception e) {
	         e.printStackTrace();
	      }
	      
	    
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Initialize in=new Initialize();
		in.Parse();
	}

}
