package basic.testcase.Lists;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.restapibase.BaseAPIClass;

import io.restassured.response.Response;
import utility.Authorization;
import utility.CommonUtilFunctions;
import utility.ConfigReader;
import utility.RestLogger;

public class VerifyResponseGetABoardTest {

	Response response;
	@Test
	public void getCardsinaList() {
		String CardId = "67c03fbc0310dc1fb7910dd3";
		String endPoint = ConfigReader.getEndpoint("endpoint.GetCardsinaList");
		String finalUrl = endPoint.replace("{CardId}", CardId);

		String token = Authorization.token;
		String key = Authorization.key;
		RestLogger.info(VerifyResponseGetABoardTest.class,"Starting Create Repo Test");
		response = BaseAPIClass.getRequest(finalUrl, token, key);
		RestLogger.info(VerifyResponseGetABoardTest.class,"Id:"+CommonUtilFunctions.getJsonValueInString(response, "[0].id"));		
		RestLogger.info(VerifyResponseGetABoardTest.class,"Votes:"+CommonUtilFunctions.getJsonValueInString(response, "[0].badges.votes"));
		Assert.assertEquals(CommonUtilFunctions.getJsonValueInString(response, "[0].id"), "67c9a1f2fdd92ede14e69442");
		Assert.assertEquals(CommonUtilFunctions.getJsonValueInString(response, "[0].badges.votes"), "0");
	}
	
	@Test
	public void getListsonaBoard() {
		String boardId = "67c03fbc0310dc1fb7910cf7";
		String endPoint = ConfigReader.getEndpoint("endpoint.GetListsonaBoard");
		String finalUrl = endPoint.replace("{BoardId}", boardId);

		String CardId = "67c03fbc0310dc1fb7910dd3";
		String token = Authorization.token;
		String key = Authorization.key;
		RestLogger.info(VerifyResponseGetABoardTest.class,"Starting Create Repo Test");
		response = BaseAPIClass.getRequest(finalUrl, token, key);
		RestLogger.info(VerifyResponseGetABoardTest.class,"Id:"+CommonUtilFunctions.getJsonValueInString(response, "[0].id"));		
		RestLogger.info(VerifyResponseGetABoardTest.class,"name:"+CommonUtilFunctions.getJsonValueInString(response, "[0].name"));
		Assert.assertEquals(CommonUtilFunctions.getJsonValueInString(response, "[0].id"), CardId);
		Assert.assertEquals(CommonUtilFunctions.getJsonValueInString(response, "[0].name"), "To Do");
	}
}
