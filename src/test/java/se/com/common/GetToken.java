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
	
	
	public String tokenAdmin() {
		
		CommonData commonData = new CommonData();
		
		RestAssured.baseURI=commonData.adminUrl;
	   
	    
	    RequestSpecification request = RestAssured.given().
	    		queryParam("email", commonData.adminEmail).
	    		queryParam("password", commonData.adminPassword);



	    // Add a header stating the Request body is a JSON
	    request.header("Content-Type", "application/json");



	    Response response = request.post("admin/users/login");
		
	    Response token = response.
	    		then().
	    		contentType(ContentType.JSON).
	    		extract().
	    		response();
	    
	    String tokenFinal = token.path("data.token");
	    
		return tokenFinal;
		
	}
	
	
	
	public String tokenSE() {
		
		CommonData commonData = new CommonData();
		
		RestAssured.baseURI=commonData.SeUrl;
	   
	    
	    RequestSpecification request = RestAssured.given();
	    
	    JSONObject requestParams = new JSONObject();
	    
	    requestParams.put("email", commonData.userSeEmail);
	    requestParams.put("password", commonData.userSePassword);



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
