package utility;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CommonUtilFunctions {

	public static JsonPath jsonPath;
	
	public static String stringToJsonConverter(String response_body, String response_key)
	{
		jsonPath= new JsonPath(response_body);
		String key_value= jsonPath.get(response_key);
		return key_value;
	}
	
	public static String stringToJsonConverterAsString(Response response, String response_key)
	{
		String resopnseString = response.getBody().asString();
		
		jsonPath= new JsonPath(resopnseString);
		String key_value= jsonPath.get(response_key);
		return key_value;
	}
}
