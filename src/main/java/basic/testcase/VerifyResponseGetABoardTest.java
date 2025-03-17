package basic.testcase;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
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
		RestLogger.info(VerifyResponseGetABoardTest.class,"Starting Create Repo Test");
		response = BaseAPIClass.getRequest(endPoint, token, key);
		RestLogger.info(VerifyResponseGetABoardTest.class,"Id:"+CommonUtilFunctions.getJsonValueInString(response, "[0].id"));		
		RestLogger.info(VerifyResponseGetABoardTest.class,"Votes:"+CommonUtilFunctions.getJsonValueInString(response, "[0].badges.votes"));
		Assert.assertEquals(CommonUtilFunctions.getJsonValueInString(response, "[0].id"), "67c9a1f2fdd92ede14e69442");
		Assert.assertEquals(CommonUtilFunctions.getJsonValueInString(response, "[0].badges.votes"), "0");
		
		
	}
}
