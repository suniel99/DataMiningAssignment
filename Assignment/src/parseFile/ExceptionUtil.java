package parseFile;

import java.util.ArrayList;
import parseFile.StoreExceptions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ExceptionUtil {
 @SuppressWarnings("unchecked")
static int flag=0;
 String listOfExceptions="";
 String returnExceptions="";
 public  String getAllCatchBlocks(ArrayList fileData)
 {
	 StoreExceptions st=new StoreExceptions();
	 int nbrExcep=0;
	 ArrayList<ArrayList<String>> exceptions=new ArrayList<ArrayList<String>>();
	ArrayList <String> catchBlockContent=new ArrayList<String>();
//ArrayList<HashMap<Integer,ArrayList<String>>> storeExceptionss=new ArrayList<HashMap<Integer,ArrayList<String>>>();
	ArrayList<ArrayList<String>> indivException = new ArrayList<ArrayList<String>>();
		
	System.out.println("Entering new file");
		@SuppressWarnings("rawtypes")
		List <String> catchBlock= new ArrayList<String>();
		
		//Iterator it=fileData.iterator();
		int length=fileData.size();
		int count=0;
		int temp=0;
		int counter;
		
		boolean tempChanged=false;
		//Map <Integer,ArrayList <String>> allExceptions=new HashMap<Integer,ArrayList <String>>();
		
		for(int j=1;j<=length;j++)
		//while(it.hasNext())
		{
			counter=0;
			tempChanged=false;
	//		System.out.println("entering the while loop"+fileData);
			count++;
			String line=(String) fileData.get(j-1);
			
//			System.out.println("count--->"+count+" line----->"+line);
			if(line.contains("catch"))
			{
				//System.out.println("entering the catch block");
				catchBlockContent.clear();
				//catchBlock=(ArrayList<String>)fileData.subList(count, length);
				/*System.out.println("count--->"+count);
				System.out.println("length--->"+length);
				*/
			//	catchBlock=fileData.subList(count-1, length);
				//Map.put("catchStart",count);
				for(int i=count;i<length;i++)
				{
				counter++;
				//System.out.println("Sun: value of counter--->"+counter+" i--->"+i);
				
				
		/*		Iterator k=catchBlock.iterator();
				while(k.hasNext())
				{
					counter++;
					System.out.println(("counter"));
		*/
					//String braceLine=(String) catchBlock.get(i);			
				
				String braceLine=(String) fileData.get(i-1);
				//System.out.println("i--->"+i+" braceLine--->"+braceLine);
				
				catchBlockContent.add(braceLine);
				if(braceLine.contains("{"))
				{	
					temp++;
					tempChanged=true;
				//System.out.println("entering this");
				}
					if(braceLine.contains("}"))
					temp--;
				
				//System.out.println("temp----->"+temp);
				for(int k=1;k<=nbrExcep;k++)
				{
					Integer nbr=(Integer)k;
					//System.out.println("sun--->"+k+"--->"+allExceptions.get(nbr));
				}
				if(temp==0&&tempChanged)
				{
					//System.out.println("catchblock content--->"+catchBlockContent);
					//ArrayList<HashMap<Integer,ArrayList<String>>> storeExceptions=new ArrayList<HashMap<Integer,ArrayList<String>>>();
					/*for(int k=1;k<=nbrExcep;k++)
					{
						Integer nbr=(Integer)k;
						//System.out.println("inigo--->"+k+"--->"+allExceptions.get(nbr));
					}*/
					i=length;
					count=count+counter-1;
					j=count;
					//System.out.println("count+counter-1---->"+count);
					nbrExcep++;
					indivException=gatherExceptions(catchBlockContent);
					returnExceptions=identifyAndStore(catchBlockContent);
					exceptions.addAll(indivException);
					//System.out.println("indivException--->"+indivException);
					//System.out.println("exceptions--->"+exceptions);
					//st.storeExceptions(indivException);
					//storeExceptions.add(indivException);
					//System.out.println("Store Exception--->"+storeExceptions);
					/*System.out.println("nbrExcep"+nbrExcep);
					Integer nbr=(Integer)nbrExcep;
					System.out.println("putting "+catchBlockContent+" in place"+nbr);
					allExceptions.put(nbr, catchBlockContent);
					exceptions.add(catchBlockContent);
					System.out.println("exceptions-->"+exceptions);
					System.out.println("why isnt it working!-->"+allExceptions);
					System.out.println("printing-->"+nbrExcep+"all--->"+allExceptions.get(nbr));
*/
					//return catchBlockContent;
				}
				}
			}
			
				
		}
		/*for(int k=1;k<=nbrExcep;k++)
		{
			Integer nbr=(Integer)k;
			System.out.println("code--->"+k+"--->"+allExceptions.get(nbr));
		}*/
		return returnExceptions;
	
 }

public  ArrayList<ArrayList<String>> gatherExceptions(ArrayList<String> exception)
{
	
	ArrayList<ArrayList<String>> exceptions = new ArrayList<ArrayList<String>>();
	exceptions.add(exception);
	System.out.println("Exceptions---->"+exceptions);// important LOC to get list of exceptions
	return exceptions;
}

public String identifyAndStore(ArrayList<String> exception)
{
	String excep="";
	for(int i=0;i<exception.size();i++)
	{
	String line=exception.get(i);
	if(line.contains("catch"))
	{
		line=line.trim();
		int n=line.indexOf("(");
		line=line.substring(n+1).trim();
		int space=line.indexOf(" ");
		excep=line.substring(0, space);
		//System.out.println(excep);
		listOfExceptions+=excep+",";
		System.out.println(listOfExceptions);
		
	}
	
	}
	System.out.println(listOfExceptions);
	return listOfExceptions;
}
}
