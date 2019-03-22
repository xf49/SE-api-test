package se.com.admin.product;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import se.com.common.CommonData;

public class PostAdminProducts {

	@Test
	public void test() {
		
		CommonData cd = new CommonData();
		
		RestAssured.baseURI = cd.adminUrl;
		
		RequestSpecification request = RestAssured.given();
	}
	
}
