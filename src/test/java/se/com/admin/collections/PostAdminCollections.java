package se.com.admin.collections;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import se.com.common.CommonData;
import se.com.common.GetToken;

public class PostAdminCollections {
	
	@Test
	public void test() {
		
		CommonData cd = new CommonData();
		GetToken gt = new GetToken();
		
		RestAssured.baseURI = cd.adminUrl;
		
		RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type", "application/json");
		request.header("wm-commerce-token",gt.tokenAdmin());
		
		Response response = request.body("{\"title\":\"996icu\","
				+ "\"available\":true,\"note\":\"\",\"baseType\":\"Basic\","
				+ "\"collectionMediaList\":[],\"lookBook\":{},"
				+ "\"multiLanguage\":[{\"language\":\"ENGLISH\","
				+ "\"translation\":{\"description\":\"[{\\\"title\\\":\\\"996icu\\\"}]\","
				+ "\"mdescription\":\"[]\"}},{\"language\":\"CHINESE\","
				+ "\"translation\":{\"description\":\"[]\",\"mdescription\":\"[]\"}},"
				+ "{\"language\":\"ARABIC\",\"translation\":{\"description\":\"[]\","
				+ "\"mdescription\":\"[]\"}}],\"type\":\"Smart\",\"smartProducts\":[],"
				+ "\"collectionFilterDTOList\":[{\"column\":\"inventory\",\"condition\":10,"
				+ "\"integrated\":true,\"relation\":\"is greater than\"}],\"anyMatch\":false}").
				contentType("application/json").
				post("/admin/collections");
		
		String output = response.then().
				contentType(ContentType.JSON).
				extract().
				response().
				asString();
		
		System.out.println(output);
		
		response.then().body("code", Matchers.is("1"));
		
		
	}

}
