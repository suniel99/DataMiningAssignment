package parseFile;

import java.io.BufferedReader;
import parseFile.FindOverCatch;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
 
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import java.util.Scanner;
//import org.eclipse.jdt.internal.compiler.parser.Scanner;
 
public class Main {
	static int countMethod=0;
	//use ASTParse to parse string
	public static  void parse(String str) {
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setSource(str.toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
 
		final CompilationUnit cu = (CompilationUnit) parser.createAST(null);
 
		cu.accept(new ASTVisitor() {
 
			Set names = new HashSet();
 
			public boolean visit(VariableDeclarationFragment node) {
				SimpleName name = node.getName();
			//System.out.println("Sunil: value of node--->"+node);
				this.names.add(name.getIdentifier());
			//	System.out.println("Declaration of '" + name + "' at line"
			//		+ cu.getLineNumber(name.getStartPosition()));
				return false; // do not continue 
			}
 
			public boolean visit(SimpleName node) {
			//	System.out.println("Sunil: value of node at place 2--->"+node);
				if (this.names.contains(node.getIdentifier())) {
			//		System.out.println("Usage of '" + node + "' at line "
			//				+ cu.getLineNumber(node.getStartPosition()));
				}
				return true;
			}
			//public void printDetails()
		});
 
	}
 
	//read file content into a string
	public static  String readFileToString(String filePath) throws IOException {
		StringBuilder fileData = new StringBuilder(1000);
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
 
		char[] buf = new char[10];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {
		//	System.out.println("Value of numRead---->"+numRead);
			String readData = String.valueOf(buf, 0, numRead);
		//	System.out.println("value of oreadData-------->"+readData);
			fileData.append(readData);
			buf = new char[1024];
		}
 
		reader.close();
 
		return  fileData.toString();	
	}
 
	//loop directory to get file list
	public  static void ParseFilesInDir() throws IOException{
		File dirs = new File("C:\\Concordia\\Data Mining\\src");
		//	String dirPath = dirs.getCanonicalPath() + File.separator+"src"+File.separator;
		//	System.out.println(dirs);
			displayDirectoryContents(dirs);
		}
		public static void displayDirectoryContents(File dirs) throws IOException {
			//File root = new File(f2);
					//System.out.println(root.listFiles());
				//	File[] files = root.listFiles ( );
						File[] files = dirs.listFiles();
					String filePath = null;
			 
					 for (File f : files ) {
						 if (f.isDirectory()) {
							System.out.println("directory:"+f.getCanonicalPath());
								filePath = f.getAbsolutePath();
								displayDirectoryContents(f);
							} else {
								if(f.getName().endsWith((".java")))
								{
								System.out.println("file:" + f.getCanonicalPath());
								filePath = f.getAbsolutePath();
								//if(f.isFile()){
									readFile(f);
									 //parse(readFileToString(filePath));
									//			}
								}
									}
						
					 }
	}
	
	
	public static void readFile(File f) throws FileNotFoundException
	{
		Scanner sc=new Scanner(f);
		ArrayList <String> fileDetail=new ArrayList<String>();
		String s="";
		int count=0;
		while(sc.hasNext())
		{
		count++;
		
			s=sc.nextLine();	
			fileDetail.add(s);
			//System.out.println("s--->"+s);
			
		}
		//System.out.println("Issues with File "+f.getName());
	//	System.out.println("hello");
	//FindToDoPattern ftp=new FindToDoPattern();
	//	System.out.println("hello1");
		//ftp.getToDoExceptions(fileDetail);
//	FindEmptyCatch fec=new FindEmptyCatch();
	//	fec.getEmptyCatchException(fileDetail);
		FindOverCatch foc=new FindOverCatch();
		countMethod+=foc.getOverCatchException(fileDetail);
		System.out.println("There is(are) "+countMethod+ "instances of over catches in the file");
	}
	

	
	/*public static void readFile(File f) 
	{
		InputStreamReader isr= new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		System.out.println("Flow coming to location 2");
		int lineCount=0;
		String s="";
		do
		{
			try {
				System.out.println("Flow coming to location 4"+br.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//s=br.readLine();
			lineCount++;
			System.out.println("Flow coming to location 4");
			
		System.out.println("line number---->"+lineCount);
		System.out.println(s);
		}while(s!=null);
					
			
	}
*/ 
	public static void main(String[] args) throws IOException {
		
		ParseFilesInDir();
	}
}