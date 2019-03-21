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

public class UserCouponList {

	@Test
	public void test() {
		
		CommonData commonData = new CommonData();
		GetToken GT = new GetToken();
		
		RestAssured.baseURI=commonData.baseUrl;
	    RequestSpecification request = RestAssured.given();
	    
	    JSONObject requestParams = new JSONObject();
	    




	    // Add a header stating the Request body is a JSON
	    String token = GT.token();
	    request.header("wm-commerce-token", token);

	    

	    Response response = request.get("/commerce/users/couponList ");
	 

	    response.then().body("code", Matchers.is("1"));
	    
		
	}
}
