package parseFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class FindEmptyCatch {
	
	//@SuppressWarnings("unchecked")
	public void getEmptyCatchException(ArrayList<String> fileData)
	{
	//	 StoreExceptions st=new StoreExceptions();
		int tempo=0;
		String str="";
		String str1;
		String str2;
		//ArrayList<String> subArrayList=new ArrayList<String>();
		//fix for brace with catch
		Iterator it=fileData.iterator();
		while(it.hasNext())
		{
			tempo++;
			String line=(String)it.next();
			if(line.contains("} catch"))
			{
				str1=(String)fileData.get(tempo-2);
				str1=str1+"}";
				System.out.println("str1---->"+str1);
				fileData.set(tempo-2, str1);
				str2=(String)fileData.get(tempo-1);
				int t=str2.indexOf("}");
				str2=str2.substring(t+1, str2.length());
				System.out.println("str2---->"+str2);
				fileData.set(tempo-1, str2);
				
				System.out.println("tempo-->"+(tempo-2)+"str1"+fileData.get(tempo-2));
				System.out.println("tempo-->"+(tempo-1)+"str1"+fileData.get(tempo-1));

				System.out.println("This change is for showing how git works!");
				
			/*	
				
				
				str=line;
				int p= line.indexOf("}");
				str1=line.substring(0, p);
				str2=line.substring(p+1, line.length());
				for(int l=tempo;l<fileData.size();l++)
				{
					String s=(String)fileData.get(l);
					subArrayList.add(s);
				}
				//subArrayList=(ArrayList<String>)fileData.subList(tempo,fileData.size());
				fileData.set(tempo-1,str1);
				System.out.println("tempo-1 "+(tempo-1)+" content "+fileData.get(tempo-1));
				fileData.set(tempo,str2);
				System.out.println("tempo-2 "+(tempo)+" content "+fileData.get(tempo));
				fileData.addAll(subArrayList);
			*/
				
			/*	System.out.println("yeahhhh"+fileData.get(tempo-1));
				fileData.set(tempo-1, "} \n catch");
			*/
			}
		}
		int nbrExcep=0;
	//	 ArrayList<ArrayList<String>> exceptions=new ArrayList<ArrayList<String>>();
		ArrayList <String> catchBlockContent=new ArrayList<String>();
//	ArrayList<HashMap<Integer,ArrayList<String>>> storeExceptionss=new ArrayList<HashMap<Integer,ArrayList<String>>>();
		HashMap<Integer,ArrayList<String>> indivException = new HashMap<Integer,ArrayList<String>>();
			System.out.println("Entering new file");
		//	@SuppressWarnings("rawtypes")
//			List <String> catchBlock= new ArrayList<String>();
			
	//		Iterator it=fileData.iterator();
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
				
//				System.out.println("count--->"+count+" line----->"+line);
				if(line.contains("catch"))
				{
					System.out.println("entering the catch block");
					catchBlockContent.clear();
					//catchBlock=(ArrayList<String>)fileData.subList(count, length);
					System.out.println("count--->"+count);
					//System.out.println("length--->"+length);
					
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
					System.out.println("i--->"+i+" braceLine--->"+braceLine);
					
					catchBlockContent.add(braceLine);
					if(braceLine.contains("{"))
					{	
						temp++;
						tempChanged=true;
					//System.out.println("entering this");
					}
						if(braceLine.contains("}"))
						{
							temp--;
							if(braceLine.contains("catch"))
							{
								braceLine.replace("} catch","} \n catch");
							}
						}
						
					//System.out.println("temp----->"+temp);
					/*for(int k=1;k<=nbrExcep;k++)
					{
						Integer nbr=(Integer)k;
						//System.out.println("sun--->"+k+"--->"+allExceptions.get(nbr));
					}*/
					if(temp==0&&tempChanged)
					{
						//System.out.println("catchblock content--->"+catchBlockContent);
						/*ArrayList<HashMap<Integer,ArrayList<String>>> storeExceptions=new ArrayList<HashMap<Integer,ArrayList<String>>>();
						for(int k=1;k<=nbrExcep;k++)
						{
							Integer nbr=(Integer)k;
							//System.out.println("inigo--->"+k+"--->"+allExceptions.get(nbr));
						}*/
						i=length;
						count=count+counter-1;
						j=count;
						//System.out.println("count+counter-1---->"+count);
						nbrExcep++;
						boolean isEmpty=findEmptyBlock(catchBlockContent);
						//System.out.println("-->"+isEmpty);
						if(isEmpty)
						{
							System.out.println("catch block is empty at line "+count);
						}
					//	System.out.println("indivException--->"+indivException);
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
			
		
	 }
	
	public boolean findEmptyBlock(ArrayList<String> catchBlockContent)
	{
		//System.out.println("catchBlockContent---->"+catchBlockContent);
		int counter=0;
		//System.out.println(catchBlockContent.size());
		for(int i=0;i<catchBlockContent.size();i++)	
		{
			String line=catchBlockContent.get(i);
			//System.out.println("line---->"+line);
			line=line.trim();
			//System.out.println("line "+i+" has code"+line);
			
			//if(line.contains("{")||line.contains("}"))
	//			
			/*	System.out.println(line.contains("catch"));
			System.out.println(line.contains("{"));
			System.out.println(line.contains("}"));
			System.out.println(line.contains("println"));
			*/
			boolean b=(line.contains("info")||line.contains("{")||line.contains("}")||line.contains("println")
					||line.contains("catch")||line.contains("debug")||line.contains("warn")
					||line.contains("error")||line.contains("trace")||line.contains("logger"));
			if(!(line.contains("info")||line.contains("{")||line.contains("}")||line.contains("println")
					||line.contains("catch")||line.contains("debug")||line.contains("warn")
					||line.contains("error")||line.contains("trace")||line.contains("logger")))
			{
			counter++;	
			}
		}	
		if(counter==0)
		{
			System.out.println("catchBlockContent sample--->"+catchBlockContent);
			System.out.println("Empty block reached");
			return true;
		}
		return false;
	}
	}
