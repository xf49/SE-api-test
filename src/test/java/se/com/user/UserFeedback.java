package se.com.user;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import se.com.common.CommonData;
import se.com.common.GetToken;

public class UserFeedback {

	@Test
	public void test() {
		CommonData commonData = new CommonData();
		GetToken GT = new GetToken();
		
		RestAssured.baseURI=commonData.baseUrl;
		RequestSpecification request = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("content", "this is good");
		requestParams.put("email", "fengxuming1992@outlook.com");
		requestParams.put("title", "feedback");
		requestParams.put("type", "feedback");
		
		request.header("Content-Type","application/json");
		request.header("wm-commerce-token",GT.token());
		request.body(requestParams.toString());
		
		Response response = request.post("/commerce/users/feedback");
		
		String output = response.
				then().
				contentType(ContentType.JSON).
				extract().
				response().
				asString();
		
	    System.out.println("response : "+ output);
	    System.out.println("response code : "+response.statusCode());
	    
	    
	    
	    response.then().body("code", Matchers.is("1"));
		
	}
}
