package se.com.user;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import se.com.common.CommonData;
import se.com.common.GetToken;

public class UserMyFeedBacks {
	
	@Test
	public void test() {
		
		CommonData commonData = new CommonData();
		GetToken GT = new GetToken();
		
		RestAssured.baseURI=commonData.baseUrl;
		RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type","application/json");
		request.header("wm-commerce-token",GT.token());
		
		
		Response response = request.get("/commerce/users/myFeedbacks");
		
		String output = response.
				then().
				contentType(ContentType.JSON).
				extract().
				response().
				asString();
		
	    System.out.println("response : "+ output);
	    System.out.println("response code : "+response.statusCode());
	    
	    
	    response.then().body("data.number",Matchers.is(0));
	    response.then().body("code", Matchers.is("1"));
	}

}
