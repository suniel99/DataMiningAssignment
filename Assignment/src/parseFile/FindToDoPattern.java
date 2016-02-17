package parseFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FindToDoPattern {
	
	public  void getToDoExceptions(ArrayList fileData)
	{
		try
		{
		System.out.println("Entering new file");
		@SuppressWarnings("rawtypes")
		Iterator it=fileData.iterator();
		int count=0;
		while(it.hasNext())
		{
			count++;
			String line=(String) it.next();
			if(line.contains("TODO"))
			System.out.println("To-do present in line "+count);
			if(line.contains("FIXME"))
			System.out.println("Fix-me present in line "+count);
				
		}
	}
	catch(Exception e)
	{
		System.out.println("Issues faced while reading the file");
	
	}
	}
}
