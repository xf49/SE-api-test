package se.com.user.address;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import se.com.common.CommonData;
import se.com.common.DataMock;
import se.com.common.GetToken;

public class UserAddressFetch {

	@Test
	public void test() {
		
		CommonData commonData = new CommonData();
		GetToken GT = new GetToken();
		DataMock DM = new DataMock();
		
		RestAssured.baseURI=commonData.baseUrl;
	    RequestSpecification request = RestAssured.given().
	    		queryParam("ID", "3068744443565656113");
	    
	    String token = GT.token();
	    request.header("wm-commerce-token", token);

	    

	    Response response = request.get("/commerce/userAddress/fetch");
	    
	    String output = response.
	    		then().
	    		contentType(ContentType.JSON).
	    		extract().
	    		response().asString();
	    
	    
	    response.then().body("code", Matchers.is("1"));
	    
	}
}
