package se.com.admin.users;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import se.com.common.CommonData;

public class AdminUsersLogin {
	
	@Test
	public void test() {
		
		CommonData commonData = new CommonData();
		
		RestAssured.baseURI=commonData.adminUrl;
	    RequestSpecification request = RestAssured.given().
	    		queryParam("email", commonData.adminEmail).
	    		queryParam("password", commonData.adminPassword);
	    


	    // Add a header stating the Request body is a JSON
	    request.header("Content-Type", "application/json");



	    
	    Response response = request.post("admin/users/login");
	    
		String output = response.
				then().
				contentType(ContentType.JSON).
				extract().
				response().
				asString();
	    

	    System.out.println(output);
	    
	    
	    
	    response.then().body("data.nickName", Matchers.is("SuperAdmin"));
	    response.then().body("data.email", Matchers.is(commonData.adminEmail));
	    response.then().body("data.isSuperAdmin", Matchers.is(true));
	    response.then().body("code", Matchers.is("1"));
	    
	    
	    
	    
	    
	    
		
	}

}
