package se.com.user;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import se.com.common.CommonData;
import se.com.common.GetToken;

public class UserRenewCancel {

	@Test
	public void test() {
		
		CommonData commonData = new CommonData();
		GetToken GT = new GetToken();
		
		RestAssured.baseURI=commonData.baseUrl;
		RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type", "application/json");
		request.header("wm-commerce-token",GT.token());
		
		Response response = request.post("/commerce/users/user/renew/cancel");
		
		response.then().body("data.email", Matchers.is(commonData.userEmail));
		response.then().body("data.fullName", Matchers.is(commonData.fullName));
		response.then().body("code", Matchers.is("1"));
		
		
	}
}
