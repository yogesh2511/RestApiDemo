package basic.testcase.Board;

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
	
	@Test
	public void getASingleBoardID() {
		String endPoint = ConfigReader.getEndpoint("endpoint.GetaBoard");
		String CardId = "67c03fbc0310dc1fb7910cf7";
		String token = Authorization.token;
		String key = Authorization.key;
		RestLogger.info(VerifyResponseGetABoardTest.class,"Starting Create Repo Test");
		response = BaseAPIClass.getRequest(endPoint, token, key);
		RestLogger.info(VerifyResponseGetABoardTest.class,"Id:"+CommonUtilFunctions.getJsonValueInString(response, "id"));		
		RestLogger.info(VerifyResponseGetABoardTest.class,"name:"+CommonUtilFunctions.getJsonValueInString(response, "name"));
		Assert.assertEquals(CommonUtilFunctions.getJsonValueInString(response, "id"), CardId);
		Assert.assertEquals(CommonUtilFunctions.getJsonValueInString(response, "name"), "Postman Automation");
	}
}
