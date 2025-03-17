package utility;

import java.util.List;
import java.util.Map;

import basic.testcase.Board.VerifyResponseGetABoardTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CommonUtilFunctions {

	public static JsonPath jsonPath;
		
	public static String getJsonValueInString(Response response, String response_key)
	{
        String responseString = response.getBody().asString();
        String stringValue = null;

        try {
            JsonPath jsonPath = new JsonPath(responseString);
            Object key_value = jsonPath.get(response_key);

            // Check and handle different types of values
            if (key_value instanceof Integer) {
                int intValue = (Integer) key_value;
                stringValue = String.valueOf(intValue); // Convert to String
                RestLogger.info(CommonUtilFunctions.class,"Value:"+stringValue);		
        		
            } else if (key_value instanceof String) {
                stringValue = (String) key_value;
                RestLogger.info(CommonUtilFunctions.class,"Value:"+stringValue);	
            } else if (key_value instanceof Double) {
                double doubleValue = (Double) key_value;
                stringValue = String.valueOf(doubleValue); // Convert to String
                RestLogger.info(CommonUtilFunctions.class,"Value:"+stringValue);	
            } else if (key_value instanceof Boolean) {
                boolean booleanValue = (Boolean) key_value;
                stringValue = String.valueOf(booleanValue); // Convert to String
                RestLogger.info(CommonUtilFunctions.class,"Value:"+stringValue);	
            } else if (key_value instanceof List) {
            	List<?> listValue = (List<?>) key_value;
                RestLogger.info(CommonUtilFunctions.class,"Value:"+listValue);	
                // Example: Access a specific element by index
                if (!listValue.isEmpty()) {
                    Object firstElement = listValue.get(0); // Retrieve the first element
                    System.out.println("First Element: " + firstElement);
                }

                // Example: Search for a specific value
                if (listValue.contains("desiredValue")) {
                    System.out.println("List contains desiredValue");
                }

                // Convert the entire list to a string
                stringValue = listValue.toString();
            } else if (key_value instanceof Map) {
            	  Map<?, ?> mapValue = (Map<?, ?>) key_value;
            	    System.out.println("Map Value: " + mapValue);

            	    // Example: Access a value by key
            	    if (mapValue.containsKey("desiredKey")) {
            	        Object valueForKey = mapValue.get("desiredKey");
            	        System.out.println("Value for desiredKey: " + valueForKey);
            	    }

            	    // Iterate through the map entries
            	    for (Map.Entry<?, ?> entry : mapValue.entrySet()) {
            	        System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            	    }

            	    // Convert the entire map to a string
            	    stringValue = mapValue.toString();
            } else {
                System.out.println("Unknown Type: " + key_value.getClass().getName());
            }
        } catch (Exception e) {
            // Handle exception gracefully
            System.err.println("Error occurred while parsing JSON: " + e.getMessage());
            e.printStackTrace();
        }

        return stringValue;
	}
	
	public static int getStatusCode(Response response) 
	{
		int status_code= response.getStatusCode();
		return status_code;
	}
	
	public static String getStatusMessage(Response response) 
	{
		String status_message= response.getStatusLine();
		return status_message;
	}
	
	public static String getResponseHeader(Response response, String header_key) 
	{
		String response_header= response.getHeader(header_key);
		return response_header;
	}
	
	public static String getResponseContentType(Response response) 
	{
		String content_type= response.getContentType();
		return content_type;
	}
}
