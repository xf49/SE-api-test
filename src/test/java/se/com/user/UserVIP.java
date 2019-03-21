package se.com.user;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import se.com.common.CommonData;
import se.com.common.GetToken;

public class UserVIP {
	
	@Test
    public void test() {
    	
		CommonData commonData = new CommonData();
		GetToken GT = new GetToken();
		
		RestAssured.baseURI=commonData.baseUrl;
	    RequestSpecification request = RestAssured.given();
	    
	    String token = GT.token();
	    request.header("Content-Type","application/json");
	    request.header("wm-commerce-token", token);

	    

	    Response response = request.post("/commerce/users/vip");
	    
	    String output = response.then().
	    		contentType(ContentType.JSON).
	    		extract().
	    		response().
	    		asString();
	    
	   System.out.println(output);
	   
	  //  response.then().body("data.level",Matchers.is(null));
	    
	    response.then().body("code", Matchers.is("1"));
    }

}
