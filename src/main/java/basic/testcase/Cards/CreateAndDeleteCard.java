package basic.testcase.Cards;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.google.common.util.concurrent.FakeTimeLimiter;
import com.restapibase.BaseAPIClass;

import basic.testcase.Members.GetAllBoardIDs;
import io.restassured.response.Response;
import utility.Authorization;
import utility.CommonUtilFunctions;
import utility.ConfigReader;
import utility.RestLogger;

public class CreateAndDeleteCard {

	Response response;

	String cardID ="";
	@Test(priority = 1)
	public void createACard() {
		
		String endPoint = ConfigReader.getEndpoint("endpoint.CreateNewCard");
		
		String Id = "67c03fbc0310dc1fb7910dd4";
		String token = Authorization.token;
		String key = Authorization.key;
		RestLogger.info(CreateAndDeleteCard.class,"Starting Create Repo Test");
		String requestPayload = "";
		
		Faker faker = new Faker();

		String name = faker.name().firstName();
		String description = faker.address().fullAddress();
		
		
	    // Define query parameters
	    Map<String, String> queryParams = new HashMap<>();
	    queryParams.put("key", key);
	    queryParams.put("token", token);
	    queryParams.put("idList", Id);
	    queryParams.put("name", name);
	    queryParams.put("desc", description);

	    // Call the method
	    Response response = BaseAPIClass.postRequest(endPoint, requestPayload, queryParams);
	    // Process the response
	    System.out.println("Status Code: " + response.getStatusCode());	
	    RestLogger.info(CreateAndDeleteCard.class,"Id:"+CommonUtilFunctions.getJsonValueInString(response, "id"));		
		RestLogger.info(CreateAndDeleteCard.class,"name:"+CommonUtilFunctions.getJsonValueInString(response, "name"));
		cardID = CommonUtilFunctions.getJsonValueInString(response, "id");
	}
	
	@Test(priority = 2)
	public void deleteACard() {
		
		String endPoint = ConfigReader.getEndpoint("endpoint.DeleteCard");
		String finalUrl = endPoint.replace("{CardID}", cardID);

			
		String token = Authorization.token;
		String key = Authorization.key;
		RestLogger.info(CreateAndDeleteCard.class,"Starting Create Repo Test");
		
	 // Call the method
	    Response response = BaseAPIClass.deleteRequest(finalUrl, token, key);
	    // Process the response
	    System.out.println("Status Code: " + response.getStatusCode());	
	    
	}
}
