//***************************************
//          Author tag
//Raunak Sinha-2015075
//Ishbir Walia-2015041
//****************************************

import java.util.*;
public class wwwEntity  {
	ArrayList<String> author;
	
	wwwEntity()
	{
		author=new ArrayList<String>();
	}
	
	public void addAuthor(String str)
	{
		str=str.toLowerCase();
		author.add(str);
	}
	
	public ArrayList<String> getAuthors()
	{
		return author;
	}
}
