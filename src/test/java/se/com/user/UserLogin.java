package se.com.user;

import se.com.common.*;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserLogin {

	@Test
	public void test() {
		
		CommonData commonData = new CommonData();
		
		RestAssured.baseURI=commonData.baseUrl;
	    RequestSpecification request = RestAssured.given();
	    
	    JSONObject requestParams = new JSONObject();
	    
	    requestParams.put("email", commonData.userEmail);
	    requestParams.put("password", commonData.password);



	    // Add a header stating the Request body is a JSON
	    request.header("Content-Type", "application/json");

	    // Add the Json to the body of the request
	    request.body(requestParams.toString());

	    
	    Response response = request.post("/commerce/users/login");
	    
	    Response token = response.
	    		then().
	    		contentType(ContentType.JSON).
	    		extract().
	    		response();
	    
	    String tokenFinal = token.path("data.token");
	    
	    String tokenAsString = token.asString();
	    
	    System.out.println("response : "+ tokenAsString);
	    
	    System.out.println("token : "+tokenFinal);
	    
	    System.out.println("response code : "+response.statusCode());
	    
	    response.then().body("data.email", Matchers.is("fengxuming1992@gmail.com"));
	    response.then().body("data.fullName", Matchers.is("xuming feng"));
	    
	    
	    
	    
	    
		
	}
	

	

	
}
