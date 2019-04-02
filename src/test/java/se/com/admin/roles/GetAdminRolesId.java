package se.com.admin.roles;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import se.com.common.CommonData;
import se.com.common.GetToken;

public class GetAdminRolesId {

	@Test
	public void test() {
		
		CommonData cd = new CommonData();
		GetToken gt = new GetToken();
		
		RestAssured.baseURI=cd.adminUrl;
		
		RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type","application/json");
		request.header("wm-commerce-token",gt.tokenAdmin());
		
		request.contentType(ContentType.JSON).get("/admin/roles/2519549449327698525").then().statusCode(200);
		
		Response response = request.
				contentType(ContentType.JSON).get("/admin/roles/2519549449327698525");
		
		String output = response.then().
				contentType(ContentType.JSON).
				extract().
				response().
				asString();
		
		
		System.out.println(output);

		response.then().body("code", Matchers.is("1"));
		response.then().body("data.id", Matchers.is("2519549449327698525"));
		response.then().body("data.available", Matchers.is(true));
		response.then().body("data.name", Matchers.is("管理员"));


		
	}
	
}
