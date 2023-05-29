package Common_function;


	import io.restassured.RestAssured;
	import static io.restassured.RestAssured.given;


	public class Common_fun_class {	
		public static int responseStatusCode_Extractor(String baseURI, String resource)
		{
			RestAssured.baseURI=baseURI;
			int res_StatusCode=given().when().get(resource).then().extract().statusCode();
			return res_StatusCode;
		}
		public static String responseBody_Extractor(String baseURI, String resource)
		{
			RestAssured.baseURI=baseURI;
			String responseBody=given().when().get(resource).then().extract().response().asString();
			return responseBody;
		}

}


