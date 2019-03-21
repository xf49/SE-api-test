package se.com.user;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import se.com.common.CommonData;

public class UserEmailExist {

	@Test
	public void test() {
		
		CommonData commonData = new CommonData();
		
		RestAssured.baseURI=commonData.baseUrl;
	    RequestSpecification request = RestAssured.given();
	    
	    JSONObject requestParams = new JSONObject();
	    


	    String email = commonData.userEmail;
	    String emailFail = "xf49@hotmail.com";


	    Response response = request.get("/commerce/users/email/exists"+"?"+"email="+email);
	    
	    Response responseFail = request.get("/commerce/users/email/exists"+"?"+"email="+emailFail);
	    
	    response.then().body("data.source",Matchers.is(0));
	    response.then().body("code", Matchers.is("1"));
	    responseFail.then().body("data.source",Matchers.is(-1));
	    responseFail.then().body("code", Matchers.is("1"));
	    
	    
	    
	}
}
