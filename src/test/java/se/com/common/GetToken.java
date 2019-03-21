package se.com.common;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetToken {

	public String token() {
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
	    
		return tokenFinal;
	}
	
	
	
}
