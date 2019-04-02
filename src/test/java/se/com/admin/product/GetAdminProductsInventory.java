package se.com.admin.product;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import se.com.common.CommonData;
import se.com.common.GetToken;

public class GetAdminProductsInventory {
	
	@Test
	public void test() {
		
		CommonData cd = new CommonData();
		
		GetToken gt = new GetToken();
		
		RestAssured.baseURI=cd.adminUrl;
		
		RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type", "application/json");
		
		
		Response response = request.
				contentType(ContentType.JSON).
				get("/admin/products/inventory");
		
		
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
