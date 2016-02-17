package parseFile;

import java.util.ArrayList;
import java.util.HashMap;

public class StoreExceptions {
	static ArrayList<HashMap<Integer,ArrayList<String>>> storeExeptions=new ArrayList<HashMap<Integer,ArrayList<String>>>();
	public void storeExceptions(HashMap<Integer,ArrayList<String>> exception)
	{
		storeExeptions.add(exception);
		System.out.println("Finally lets see=-->"+storeExeptions);
	}
}
