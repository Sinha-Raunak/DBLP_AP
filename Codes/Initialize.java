import java.util.*;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


import org.xml.sax.InputSource;
import java.io.*;


public class Initialize {
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Entity ent=new Entity();
		//Publication pub=new Publication(ent);
		//pub.SearchMoreThan(1000);
		
		Search s=new Search();
		
		ArrayList<Data> d=s.searchAuthorandType("Chin Chen Chang", ent,0);
		System.out.println("Size="+d.size());
		
		
	}

}
