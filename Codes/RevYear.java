import java.util.*;
public class RevYear implements Comparator<Data> {

	public int compare(Data d1,Data d2)//by year - ascending order
	{
		if(d1.getYear().intValue()==d2.getYear().intValue())
		{
			return 0;
		}
		else if(d1.getYear().intValue()>d2.getYear().intValue())
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
}
