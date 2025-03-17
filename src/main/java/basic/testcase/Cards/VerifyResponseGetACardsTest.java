package basic.testcase.Cards;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.restapibase.BaseAPIClass;

import io.restassured.response.Response;
import utility.Authorization;
import utility.CommonUtilFunctions;
import utility.ConfigReader;
import utility.RestLogger;

public class VerifyResponseGetACardsTest {

	Response response;
	@Test
	public void getCardsinaList() {
		String CardId = "67c03fbc0310dc1fb7910dd3";
		String endPoint = ConfigReader.getEndpoint("endpoint.GetCardsinaList");
		String finalUrl = endPoint.replace("{CardId}", CardId);

		String token = Authorization.token;
		String key = Authorization.key;
		RestLogger.info(VerifyResponseGetACardsTest.class,"Starting Create Repo Test");
		response = BaseAPIClass.getRequest(finalUrl, token, key);
		RestLogger.info(VerifyResponseGetACardsTest.class,"Id:"+CommonUtilFunctions.getJsonValueInString(response, "[0].id"));		
		RestLogger.info(VerifyResponseGetACardsTest.class,"Votes:"+CommonUtilFunctions.getJsonValueInString(response, "[0].badges.votes"));
		Assert.assertEquals(CommonUtilFunctions.getJsonValueInString(response, "[0].id"), "67c9a1f2fdd92ede14e69442");
		Assert.assertEquals(CommonUtilFunctions.getJsonValueInString(response, "[0].badges.votes"), "0");
	}
	
}
