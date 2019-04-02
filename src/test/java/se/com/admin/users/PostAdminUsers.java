package se.com.admin.users;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import se.com.common.CommonData;
import se.com.common.GetToken;
import se.com.common.RandomName;

public class PostAdminUsers {
	
	@Test
	public void test() {
		
		CommonData cd = new CommonData();
		GetToken gt = new GetToken();
		RandomName rn = new RandomName();
		
		JSONObject js = new JSONObject();
		
		js.put("available", true);
		js.put("email", rn.getRandomName(5)+"@gmail.com");
		js.put("nickName", rn.getRandomName());
		js.put("password", "123456");
		js.put("promoterType", 0);
		js.put("roleId", 0);
		js.put("type", 1);
		
		
		
		RestAssured.baseURI=cd.adminUrl;
		
		RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type","application/json");
		request.header("wm-commerce-token",gt.tokenAdmin());
		
		request.body(js.toString());
		
		Response response = request.
				contentType(ContentType.JSON).post("/admin/users");
		
		String output = response.then().
				contentType(ContentType.JSON).
				extract().
				response().
				asString();
		
		
		System.out.println(output);

		response.then().body("code", Matchers.is("1"));
		
		



		
	}

}
