import java.util.*;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


import org.xml.sax.InputSource;
import java.io.*;


public class Initialize {
	
	
	
	public void Parse(String name)
	{
		File ff=new File("A.ser");
		if(ff.exists())
		{
			return ;
		}
		else 
		{
			int max =90;
			int i;
			for(i=65;i<=max;i++)
			{
				ff=new File((char)i+".ser");
				try
				{
				ff.createNewFile();
				
				}catch(IOException e)
				{
					e.printStackTrace();
				}
			}
			
			
		
			try {	
		         File inputFile = new File("testDBLP.xml");
		         /*
		         InputStream inp=new FileInputStream(inputFile);
		         Reader rr=new InputStreamReader(inp,"UTF-8");
		         InputSource is=new InputSource(rr);
		         is.setEncoding("UTF-8");
		         */
		         SAXParserFactory factory = SAXParserFactory.newInstance();
		         SAXParser saxParser = factory.newSAXParser();
		         ArticleHandler userhandler = new ArticleHandler(name);
		         
		         saxParser.parse(inputFile, userhandler);     
		         System.out.println("Size="+userhandler.getList().size());
			} catch (Exception e) {
		         e.printStackTrace();
		      }
		}
	    
	}
	
	public void DeleteFiles()       //only call while testing for ease of use
	{
		int i;
		File f=null;
		for(i=65;i<=90;i++)
		{
			f=new File((char)i+".ser");
			if(f.exists())
			{
				f.delete();
			}
		}
		System.out.println("Delete Done");
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hi");
		Initialize in=new Initialize();
		Scanner ins = new Scanner(System.in);
		String name = ins.nextLine();
		//in.Parse(name);
		//in.DeleteFiles();
		
		
	}

}
