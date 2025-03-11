package basic.testcase;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.restapibase.BaseAPIClass;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utility.Authorization;
import utility.CommonUtilFunctions;
import utility.ConfigReader;
import utility.RestLogger;

public class VerifyResponseGetABoardTest {

	Response response;
	@Test
	public void verifyResponseBody() {
		String endPoint = ConfigReader.getEndpoint("endpoint.GetCardsinaList");
		String token = Authorization.token;
		String key = Authorization.key;
		RestLogger.info("Starting Create Repo Test");
		response = BaseAPIClass.getRequest(endPoint, token, key);
		String resopnseString = response.getBody().asString();
		
		JsonPath responsebody = new JsonPath(resopnseString);
		RestLogger.info("Response String:"+resopnseString);
		
		RestLogger.info("Id:"+CommonUtilFunctions.stringToJsonConverter(resopnseString, "[0].id"));
//		assertEquals("67c2f2a09a585e78f447e7b3", responsebody.get("[0].id"));
//		String badges=CommonUtilFunctions.stringToJsonConverterAsString(response, "[0].badges");

//		String votes=CommonUtilFunctions.stringToJsonConverter(resopnseString, "[0].badges.votes");
//		RestLogger.info("Votes:"+votes);
		
		System.out.println("Votes:"+responsebody.get("[0].badges.votes"));
		
		 String votes= responsebody.get("[0].badges.votes").toString(); int vote =
		 Integer.parseInt(votes); assertEquals(0, vote);
		 System.out.println("badges:"+responsebody.get("badges"));
		 
		System.out.println("===================================================");
		System.out.println(CommonUtilFunctions.stringToJsonConverter(resopnseString, "[0].id"));
		
	}
}
