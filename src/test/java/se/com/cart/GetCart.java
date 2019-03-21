package se.com.cart;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import se.com.common.CommonData;

public class GetCart {

	@Test
	public void test() {
		
		CommonData CD = new CommonData();
		
		RestAssured.baseURI=CD.baseUrl;
		
		RequestSpecification request = RestAssured.given();
		
		request.header("deviceId", CD.deviceId);
		
		Response response = request.get("commerce/cart");
		
		String output = response.
				then().
				contentType(ContentType.JSON).
				extract().
				response().
				asString();
		
		System.out.println(output);
		
		response.then().body("code", Matchers.is("1"));
		response.then().body("data.headerInfo.text",Matchers.is("Free shipping on items as low as $0.00 !"));
		response.then().body("data.currencyCode", Matchers.is("USD"));
		
		
	}
	
}
