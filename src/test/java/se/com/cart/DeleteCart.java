package se.com.cart;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import se.com.common.CommonData;

public class DeleteCart {
	
	@Test
	public void test() {
		
		CommonData CD = new CommonData();
		
		RestAssured.baseURI=CD.baseUrl;
		
		RequestSpecification request = RestAssured.given().queryParam("cartStatus", "SHOPPING");
		

		
		request.header("Content-Type", "application/json");
		
		
		
		Response response = request.delete("/commerce/cart");
		
		String output = response.
				then().
				contentType(ContentType.JSON).
				extract().
				response().
				asString();
		
		response.then().body("code", Matchers.is("1"));
	}

}
