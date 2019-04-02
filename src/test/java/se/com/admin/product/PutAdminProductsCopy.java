package se.com.admin.product;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import se.com.common.CommonData;
import se.com.common.GetToken;

public class PutAdminProductsCopy {
	
	@Test
	public void test() {
		
		CommonData cd = new CommonData();
		GetToken gt = new GetToken();
		
		RestAssured.baseURI = cd.adminUrl;
		
		RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type", "application/json");
		request.header("wm-commerce-token",gt.tokenAdmin());
		
		Response response = request.
				contentType("application/json").
				put("/admin/products/copy/3057091991161171790");
		
		response.then().body("code", Matchers.is("1"));
		//response.then().body("data.id",Matchers.is("3057091991161171790"));
		//response.then().body("data.variantList.stockType", Matchers.is("[Spots]"));
		
		
	}

}
