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

public class UserBind {

	@Test
	public void test() {
		
		CommonData commonData = new CommonData();
		GetToken GT = new GetToken();
		
		String email = "xf49@ucla.edu";
		
		RestAssured.baseURI=commonData.baseUrl;
		RequestSpecification request = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("email", email);
		
		// Add a header stating the Request body is a JSON
		String token =GT.token();
		
		System.out.println(token);
		
		request.header("Content-Type","application/json");
		request.header("wm-commerce-token",token);
		request.contentType(ContentType.JSON);
		request.body(requestParams.toString());
		
		
		Response response = request.put("/commerce/users/bind");
		
		String output = response.
						then().
						contentType(ContentType.JSON).
						extract().
						response().
						asString();
		
		
		System.out.println("response : "+output);
		System.out.println();
		System.out.println("response code : "+response.statusCode());
		

		response.then().body("message", Matchers.is("This email is already on our list!"));
		response.then().body("code",Matchers.is("100003") );
		

		
		
	}
}
