//***************************************
//          Author tag
//Raunak Sinha-2015075
//Ishbir Walia-2015041
//****************************************

import java.util.Comparator;
public class ByRelevance implements Comparator<Data> {

	public int compare(Data d1,Data d2) //by relevance - descending order
	{
		if(d1.getRefcount()==d2.getRefcount())
		{
			return 0;
		}
		else if(d1.getRefcount()>d2.getRefcount())
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}
}
