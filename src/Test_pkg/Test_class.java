package Test_pkg;


import java.io.IOException;
import org.testng.Assert;

import Common_function.Common_fun_class;
import Common_function.Comon_method_utility;
import Req_repository.Req_repository_class;
import io.restassured.path.json.JsonPath;
	
	public class Test_class {
		
			
		public static void orchestrator() throws IOException
	{
	

	String baseURI=Req_repository_class.baseURI();
	String resource=Req_repository_class.resource();
	for(int i=0; i<5; i++)
	{
	int StatusCode=Common_fun_class.responseStatusCode_Extractor(baseURI, resource);
			
	if(StatusCode==200)
	{
	String responseBody=Common_fun_class.responseBody_Extractor(baseURI, resource);
			
    Test_class.responseBodyValidator(responseBody, StatusCode);
    Comon_method_utility.EvidenceFileCreator("Test_class",responseBody);
	break;
	}
	else
	{
	System.out.println("Correct Status Code is not found");
	}
	}
	
	
	}
	private static void responseBodyValidator(String responseBody, int StatusCode) {
	// TODO Auto-generated method stub
	//Create json Path object to extract response body
	JsonPath obj = new JsonPath(responseBody);
	int data_array_length=obj.getInt("data.size()");
	System.out.println("Data: " +data_array_length);
	//Extract Response body parameters to validate
	int exp_Id[] = {7,8,9,10,11,12};
	String exp_email[]= {"michael.lawson@reqres.in", "lindsay.ferguson@reqres.in", "tobias.funke@reqres.in", "byron.fields@reqres.in", "george.edwards@reqres.in", "rachel.howell@reqres.in"};
	String exp_fname[]= {"Michael", "Lindsay", "Tobias", "Byron", "George", "Rachel"};
	String exp_lname[]= {"Lawson", "Ferguson", "Funke", "Fields", "Edwards", "Howell"};
	String exp_Avatar[]= {"https://reqres.in/img/faces/7-image.jpg", "https://reqres.in/img/faces/8-image.jpg", "https://reqres.in/img/faces/9-image.jpg", "https://reqres.in/img/faces/10-image.jpg", "https://reqres.in/img/faces/11-image.jpg", "https://reqres.in/img/faces/12-image.jpg"};
	for(int i=0; i<data_array_length; i++)
	{
	//extract response body parameters from array
	int res_Id=obj.getInt("data["+i+"].id");
	String res_email=obj.get("data["+i+"].email");
	String res_fname=obj.getString("data["+i+"].first_name");
	String res_lname=obj.getString("data["+i+"].last_name");
	String res_Avatar=obj.getString("data["+i+"].avatar");
	//Print the Result from response body
	System.out.println("Id: " +res_Id);
	System.out.println("Email Id: " +res_email);
	System.out.println("First Name: " +res_fname);
	System.out.println("Last Name: " +res_lname);
	System.out.println("Avatar: " +res_Avatar);
	//Validate the response body parameters
	Assert.assertEquals(StatusCode, 200);
	Assert.assertEquals(res_Id, exp_Id[i]);
	Assert.assertEquals(res_email, exp_email[i]);
	Assert.assertEquals(res_fname, exp_fname[i]);
	Assert.assertEquals(res_lname, exp_lname[i]);
	Assert.assertEquals(res_Avatar, exp_Avatar[i]);
	}
	}
	}
	


