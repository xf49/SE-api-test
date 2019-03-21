package se.com.user.address;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import se.com.common.CommonData;
import se.com.common.DataMock;
import se.com.common.GetToken;

public class UserAddress {

	@Test
	public void test() {
		
		CommonData commonData = new CommonData();
		GetToken GT = new GetToken();
		DataMock DM = new DataMock();
		
		RestAssured.baseURI=commonData.baseUrl;
	    RequestSpecification request = RestAssured.given();
	    
	    
	    JSONObject requestParams = new JSONObject();
	    
	    requestParams.put("addressLine1", DM.address);
	    requestParams.put("firstName", DM.firstName);
	    requestParams.put("lastName", DM.lastName);
	    requestParams.put("city", "nyc");
	    requestParams.put("country", "usa");
	    requestParams.put("countryCode", "+1");
	    requestParams.put("isDefault", true);
	    requestParams.put("mobile", "123456789");
	    requestParams.put("province","nj");
	    requestParams.put("provinceCode", "07029");
	    requestParams.put("zipCode", "07029");
	    
	    
	    
	    
	    request.header("Content-Type", "application/json");
        request.header("wm-commerce-token",GT.token());
	    
        
	    request.body(requestParams.toString());
	    
	    
	    Response response = request.post("/commerce/userAddress");
	    
		String output = response.
				then().
				contentType(ContentType.JSON).
				extract().
				response().
				asString();
		
	    System.out.println("response : "+ output);
	    System.out.println("response code : "+response.statusCode());
	    
	    response.then().body("data.addressLine1", Matchers.is(DM.address));
	    response.then().body("data.firstName", Matchers.is(DM.firstName));
	    response.then().body("data.lastName", Matchers.is(DM.lastName));
	    response.then().body("data.isDefault", Matchers.is(true));
	    response.then().body("code", Matchers.is("1"));
	    
	    
	}
}
