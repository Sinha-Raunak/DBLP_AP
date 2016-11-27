import java.util.*;
import java.io.*;
public class wwwEntity implements Serializable {
	ArrayList<String> author;
	
	wwwEntity()
	{
		author=new ArrayList<String>();
	}
	
	public void addAuthor(String str)
	{
		//str=str.toLowerCase();
		author.add(str);
	}
	
	public ArrayList<String> getAuthors()
	{
		return author;
	}
}
