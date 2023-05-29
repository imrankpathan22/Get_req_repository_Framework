package Common_function;


	import java.io.File;
	import java.io.FileWriter;
	import java.io.IOException;
	public class Comon_method_utility {
	public static void EvidenceFileCreator(String fileName,String responseBody) throws IOException
	{
	File newtxtfile=new File("C:\\Imran123\\"+fileName+".txt");
	System.out.println("new file is creating." +newtxtfile.getName());
	FileWriter datawriter=new FileWriter(newtxtfile);
	datawriter.write("Response body is: " +responseBody);
	datawriter.close();
	System.out.println("Request and Response Body file is created." +newtxtfile.getName());
	}
	
}
