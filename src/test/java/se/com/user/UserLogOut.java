/**
 * 
 */
package se.com.user;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import se.com.common.CommonData;

/**
 * @author EDZ
 *
 */
public class UserLogOut {

	@Test
	public void test() {
		
		CommonData commonData = new CommonData();
		
		RestAssured.baseURI="https://testb.21smarthome.com";
	    RequestSpecification request = RestAssured.given();
	    
	    JSONObject requestParams = new JSONObject();
	    




	    // Add a header stating the Request body is a JSON
	    request.header("wm-commerce-token", commonData.token);

	    

	    Response response = request.delete("/commerce/users/logout");
	    
	   // System.out.println("response : "+ response);
	    System.out.println("response code : "+response.statusCode());
	    
	    response.then().body("code", Matchers.is("100007"));
	    response.then().body("message", Matchers.is("Please login again"));
		
	}
	

	
}
