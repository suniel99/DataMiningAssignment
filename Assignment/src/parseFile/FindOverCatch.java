package parseFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class FindOverCatch {
	 String exceptionTypes="";
	 String exceptions[];
	@SuppressWarnings("unchecked")
	public  int getOverCatchException(ArrayList fileData)
	{
		//get catch block content
		ExceptionUtil e=new ExceptionUtil();
		exceptionTypes=e.getAllCatchBlocks(fileData);
		int s = findOverCatches(exceptionTypes);
		//System.out.println("FOC--->catchBlockContents-->"+catchBlockContents);
	/*	if(catchBlockContents!=null)
		populateListOfExceptions(catchBlockContents);
		findUnhandledExceptions(exceptionTypes);
		System.out.println("catchBlockContent--->"+catchBlockContents);
	*/	//findEmptyBlock(catchBlockContent);
	
	return s;
	}
	/*	
	public  void populateListOfExceptions(ArrayList<HashMap<Integer,ArrayList<String>>> allExceptions)
	{
		ArrayList <String> exception=new ArrayList <String>();
		int size=allExceptions.size();
		HashMap<Integer,ArrayList<String>> exceptions = new HashMap<Integer,ArrayList<String>>();
		for(int i=0;i<size;i++)	
		{
		exceptions=	allExceptions.get(i);
			for(int j=1;j<=exceptions.size();j++)
			{
				Integer temp=(Integer)j;
				System.out.println("i -->"+i+" allExceptions---->"+allExceptions);
				exception=exceptions.get(temp);
				System.out.println("Exception---->"+exception);
				findExceptionType(exception);
			}
		
		}
		
		}
		
		*/
/*	
	public  void findExceptionType(ArrayList<String> exception)
	{
	
		String firstLine=exception.get(0).trim();
		//int n = firstLine.indexOf(" ");
		String [] split=firstLine.split(" ");
		System.out.println("split--->"+split);
		String type=split[0];
		exceptionTypes.add(type);
		System.out.println("type---->"+type);
	
		System.out.println("first line is --->"+firstLine);
	}
*/
public  int findOverCatches(String exceptionTypes)
{
	exceptions=exceptionTypes.split(",");
	int count=0;
	for(int i =0;i<exceptions.length;i++)
	{
		
		//System.out.println("String--->"+exceptions[i]);
		String thrown = exceptions[i];
		Exception thrownException=new Exception(thrown);
		if(thrownException.getMessage().equalsIgnoreCase("Throwable")||thrownException.getMessage().equalsIgnoreCase("Exception"))
		{
			count++;
		}
		
	}
	if(count<exceptions.length);
	{
		System.out.println("There is(are) "+count+" instance(s) of over catches in the file");
	}
	return count;
}
/*
public  boolean isSubClass(String thrown, String handled)
{
	Exception th=new Exception(thrown);
	System.out.println("thrown Exception---->"+th);
	Exception ha=new Exception(handled);
	System.out.println("handled Exception---->"+ha);
	Exception a=new Exception("Throwable");
	Exception b=new Exception("Exception");
	System.out.println("spider a.getMessage-->"+a.getMessage());
	System.out.println("spider b.getMessage()-->"+b.getMessage());
	System.out.println("###a.getString-->"+a.toString());
	System.out.println("###a.getClass-->"+a.getClass());
	System.out.println("###a.getClass.toString-->"+a.getClass().getCanonicalName());
//	Exception c=new Exception(th.getClass().toString());
	System.out.println("###th.getMessage-->"+a.getMessage());
	//System.out.println("###a.getCause-->"+a.getCause());
	//System.out.println("###b.getMessage-->"+b.getMessage());
//	Exception d=new Exception(ha.getMessage());
	System.out.println("###ha.getMessage-->"+b.getClass());
	if(a.getMessage().equals(b.getClass()));
	System.out.println("WIN!!");
	System.out.println("handled Exception---->"+ha.getMessage());
	System.out.println("***th.getClass()--->"+th.getClass().getName());
	System.out.println("th.getClass().getSuperclass()--->"+th.getClass().getSuperclass());
	System.out.println("---->ha.getMessage()--->"+ha);
	
	if(a.getMessage().equals(b.getClass()))
			{
		System.out.println("success");
		return true;
			}
return false;
}
*/
}

