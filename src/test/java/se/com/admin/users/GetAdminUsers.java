package se.com.admin.users;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import se.com.common.CommonData;
import se.com.common.GetToken;

public class GetAdminUsers {
	
	@Test
	public void test() {
		
		CommonData cd = new CommonData();
		GetToken gt = new GetToken();
		
		RestAssured.baseURI=cd.adminUrl;
		
		RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type","application/json");
		request.header("wm-commerce-token",gt.tokenAdmin());
		
		request.contentType(ContentType.JSON).get("/admin/users").then().statusCode(200);
		
		Response response = request.
				contentType(ContentType.JSON).get("/admin/users");
		
		String output = response.then().
				contentType(ContentType.JSON).
				extract().
				response().
				asString();
		
		
		System.out.println(output);

		response.then().body("code", Matchers.is("1"));
		response.then().body("data.sort.unsorted", Matchers.is(true));
		response.then().body("data.sort.sorted", Matchers.is(false));
		response.then().body("data.numberOfElements", Matchers.is(10));
		response.then().body("data.size", Matchers.is(10));

		
	}

}
