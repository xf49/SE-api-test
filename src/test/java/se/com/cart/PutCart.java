package se.com.cart;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import se.com.common.CommonData;

public class PutCart {

	@Test
	public void test() {
		
		CommonData CD = new CommonData();
		
		RestAssured.baseURI=CD.baseUrl;
		
		RequestSpecification request = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("cartStatus", "DELETE");
		requestParams.put("sourceStatus","DELETE");
		requestParams.put("variantId",CD.variantId);
		
		request.header("Content-Type", "application/json");
		
		request.body(requestParams.toString());
		
		Response response = request.put("/commerce/cart/items");
		
		String output = response.
				then().
				contentType(ContentType.JSON).
				extract().
				response().
				asString();
		
		response.then().body("code", Matchers.is("1"));

	}
}
