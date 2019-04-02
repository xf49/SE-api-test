package se.com.admin.business.config;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import se.com.common.CommonData;
import se.com.common.GetToken;

public class PostAdminBusinessConfig {
	
	@Test
	public void test() {
		
		CommonData cd = new CommonData();
		GetToken gt = new GetToken();
		
		RestAssured.baseURI = cd.adminUrl;
		
		RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type", "application/json");
		request.header("wm-commerce-token",gt.tokenAdmin());
		
		Response response = request.body("{\r\n" + 
				"  \"archived\": true,\r\n" + 
				"  \"createdAt\": 0,\r\n" + 
				"  \"createdBy\": 0,\r\n" + 
				"  \"description\": \"string\",\r\n" + 
				"  \"enValue\": {},\r\n" + 
				"  \"id\": 0,\r\n" + 
				"  \"multiLanguageObject\": [\r\n" + 
				"    {\r\n" + 
				"      \"language\": \"ENGLISH\",\r\n" + 
				"      \"translation\": {}\r\n" + 
				"    }\r\n" + 
				"  ],\r\n" + 
				"  \"updatedAt\": 0,\r\n" + 
				"  \"updatedBy\": 0,\r\n" + 
				"  \"value\": \"string\"\r\n" + 
				"}").
				contentType("application/json").
				post("/admin/business/config");
		
		        String output = response.
		        		then().
		        		contentType(ContentType.JSON).
		        		extract().
		        		response().
		        		asString();
		        
		        System.out.println(output);
		
		response.then().body("code", Matchers.is("1"));
		
		
	}

}
