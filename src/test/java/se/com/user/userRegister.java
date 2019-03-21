package se.com.user;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import se.com.common.CommonData;

public class userRegister {
	
	@Test
	public void test() {
		
		CommonData commonData = new CommonData();
		
		RestAssured.baseURI=commonData.baseUrl;
	    RequestSpecification request = RestAssured.given();
	    
	    JSONObject requestParams = new JSONObject();
	    
	    requestParams.put("email", "bg23@gmail.com");
	    requestParams.put("password", commonData.password);



	    // Add a header stating the Request body is a JSON
	    request.header("Content-Type", "application/json");

	    // Add the Json to the body of the request
	    request.body(requestParams.toString());

	    Response response = request.post("/commerce/users/register");
	    
  
	    response.then().body("message", Matchers.is("This email is already on our list!"));
	    response.then().body("code", Matchers.is("100003"));
	    
	    
	    
	    
		
	}
	

}
