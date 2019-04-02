package se.com.admin.users;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import se.com.common.CommonData;
import se.com.common.GetToken;

public class GetAdminUsersFindAll {
	
	@Test
	public void test() {
		
		CommonData cd = new CommonData();
		GetToken gt = new GetToken();
		
		RestAssured.baseURI=cd.adminUrl;
		
		RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type","application/json");
		request.header("wm-commerce-token",gt.tokenAdmin());
		
		request.contentType(ContentType.JSON).get("/admin/users/find/all").then().statusCode(200);
		
		Response response = request.
				contentType(ContentType.JSON).get("/admin/users/find/all");
		
		String output = response.then().
				contentType(ContentType.JSON).
				extract().
				response().
				asString();
		
		
		System.out.println(output);

		response.then().body("code", Matchers.is("1"));
		
		//request.get("/something").then().assertThat().body(containsString("OK")).and().body(containsString("something else"))
		
		//get("/admin/users/find/all").then().assertThat().content("data", hasItem("2917236139328766530"));
		//request.get("/admin/users/find/all").then().assertThat().body("data", hasItem("2917236139328766530"));

;		
	}

	private Matcher<?> containsString(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private Validatable<ValidatableResponse, Response> get(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private ResponseAwareMatcher<Response> hasItem(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
