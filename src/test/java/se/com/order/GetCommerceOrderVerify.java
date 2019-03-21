package se.com.order;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import se.com.common.CommonData;

public class GetCommerceOrderVerify {

	@Test
	public void test() {
		
		CommonData CD = new CommonData();
		
		RestAssured.baseURI=CD.baseUrl;
		
		RequestSpecification request = RestAssured.given().
				queryParam("email", CD.userEmail).
				queryParam("orderNumber", "1903216243");
		
		request.header("deviceId","6abe971b-5f77-4755-af2f-2bbbddeb1521");
		
		Response response = request.get("/commerce/order/verify");
		
		String output = response.
				then().
				contentType(ContentType.JSON).
				extract().response().
				asString();
		
		System.out.println(output);
		
		response.then().body("data.orderNumber", Matchers.is("1903216243"));
		response.then().body("data.status.name", Matchers.is("PREPARING"));
		response.then().body("data.status.value", Matchers.is("Preparing"));
		
		response.then().body("data.paymentStatus.name", Matchers.is("PAIDSUCCESS"));
		response.then().body("data.paymentStatus.value", Matchers.is("PaidSuccess"));
		response.then().body("code", Matchers.is("1"));
		
	}
	
}
