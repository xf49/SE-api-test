package se.com.campaign.collection;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import se.com.common.CommonData;

public class CampaignCollection {

	@Test
	public void test() {
		
		CommonData CD = new CommonData();
		
		RestAssured.baseURI = CD.baseUrl;
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.get("/commerce/product/campaign/collection");
		
		String output = response.
				then().
				contentType(ContentType.JSON).
				extract().response().
				asString();
		
		System.out.println(output);
		
		response.then().body("code", Matchers.is("1"));
		
	}
}
