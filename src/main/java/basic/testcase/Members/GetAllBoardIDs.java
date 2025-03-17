package basic.testcase.Members;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.restapibase.BaseAPIClass;

import io.restassured.response.Response;
import utility.Authorization;
import utility.CommonUtilFunctions;
import utility.ConfigReader;
import utility.RestLogger;

public class GetAllBoardIDs {

	Response response;
	@Test
	public void getListsonaBoard() {
		String MemberID = "678cbc268c0cb1b94182fbea";
		String endPoint = ConfigReader.getEndpoint("endpoint.GetAllTheMembers");
		String finalUrl = endPoint.replace("{MemberID}", MemberID);

		String Id = "678cbcbd64731b38472cccd6";
		String token = Authorization.token;
		String key = Authorization.key;
		RestLogger.info(GetAllBoardIDs.class,"Starting Create Repo Test");
		response = BaseAPIClass.getRequest(finalUrl, token, key);
		RestLogger.info(GetAllBoardIDs.class,"Id:"+CommonUtilFunctions.getJsonValueInString(response, "[1].id"));		
		RestLogger.info(GetAllBoardIDs.class,"name:"+CommonUtilFunctions.getJsonValueInString(response, "[1].name"));
		Assert.assertEquals(CommonUtilFunctions.getJsonValueInString(response, "[1].id"), Id);
		Assert.assertEquals(CommonUtilFunctions.getJsonValueInString(response, "[1].name"), "Automation");
	}
	
}
