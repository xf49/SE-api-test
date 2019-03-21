package se.com.email.collect;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import se.com.common.CommonData;

public class EmailCollect {

	@Test
	public void test() {
		
		CommonData commonData = new CommonData();
		
		RestAssured.baseURI=commonData.baseUrl;
	    RequestSpecification request = RestAssured.given();
	    
	    JSONObject requestParams = new JSONObject();
	    
	    requestParams.put("email", commonData.userEmail);
	   



	    // Add a header stating the Request body is a JSON
	    request.header("Content-Type", "application/json");

	    // Add the Json to the body of the request
	    request.body(requestParams.toString());

	    
	    Response response = request.post("/commerce/email/collect");
	    
	    String output = response.
	    		then().
	    		contentType(ContentType.JSON).
	    		extract().
	    		response().
	    		asString();
	    
        System.out.println(output);
	    
	    System.out.println("response code : "+response.statusCode());
	    
	    response.then().body("code", Matchers.is("1"));
	    response.then().body("data.email", Matchers.is(commonData.userEmail));
	    
	    
	    
	    
	    
	    
		
	}
}
