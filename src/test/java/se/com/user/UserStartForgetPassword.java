package se.com.user;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import se.com.common.CommonData;

public class UserStartForgetPassword {

	@Test
	public void test() {
		
		CommonData commonData = new CommonData();
		
		
		RestAssured.baseURI=commonData.baseUrl;
	    RequestSpecification request = RestAssured.given().
	    		queryParam("email", commonData.userEmail);
	    
	    JSONObject requestParams = new JSONObject();
	    

	    Response response = request.post("/commerce/users/startForgetPassword");
	    
	    String output = response.
	    		then().
	    		contentType(ContentType.JSON).
	    		extract().
	    		response().asString();
	    
	    System.out.println("response : "+ output);
	    System.out.println("response code : "+response.statusCode());
	    System.out.println();
	    

	   
	    
	    response.then().body("code", Matchers.is("1"));
	    
		
	}
}
