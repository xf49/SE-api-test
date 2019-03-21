package se.com.order;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import se.com.common.CommonData;

public class PostCommerceCheckoutsCalculateFee {

	@Test
	public void test() {
		
		CommonData CD = new CommonData();
		
		RestAssured.baseURI=CD.baseUrl;
		
		RequestSpecification request = RestAssured.given();
		
		request.header("deviceId","6abe971b-5f77-4755-af2f-2bbbddeb1521");
		
		Response response = request.body("{\r\n" + 
				"	\"orderLineItems\":\r\n" + 
				" [{\"sku\":\"8000871\",\"title\":\"3 X 1080P Dome Camera\",\"optionsText\":\"US Plug\",\"variantId\":\"3009327969108066894\",\"productId\":\"3009327969108066893\",\"originPrice\":\"23999\",\"salePrice\":\"8999\",\"quantity\":2,\"imageUrl\":\"https://static.socialeras.com/qa/images/950b164d-8d83-4db3-92a1-1e3ebc631d00.jpeg\",\"currencyCode\":\"USD\",\"currency\":null,\"options\":\r\n" + 
				"	 [{\"optionName\":\"Adapter\",\"optionValue\":\"US Plug\"}],\r\n" + 
				"	 \"influencerInfo\":null,\"reviewed\":false,\"originMoney\":{\"cent\":23999,\"currencyCode\":\"USD\",\"formatText\":\"$239.99\"},\r\n" + 
				"	 \"saleMoney\":{\"cent\":8999,\"currencyCode\":\"USD\",\"formatText\":\"$89.99\"},\"totalSaleMoney\":{\"cent\":17998,\"currencyCode\":\"USD\",\"formatText\":\"$179.98\"},\"selected\":true}],\"usePoint\":true,\"couponCode\":\"save5\",\"email\":\"fengxuming1992@outlook.com\",\"shippingAddress\":{\"id\":null,\"userAddressId\":null,\"firstName\":\"jj\",\"lastName\":\"watt\",\"fullName\":\"jj watt\",\"mobile\":\"9175621370\",\"country\":\"United States\",\"countryCode\":\"US\",\"province\":\"Arkansas\",\"provinceCode\":\"AR\",\"city\":\"fuck\",\"addressLine1\":\"fuck\",\"addressLine2\":\"fuck\",\"zipCode\":\"07029\",\"isDefault\":null},\"itemsFromCart\":true\r\n" + 
				"\r\n" + 
				"}").
				contentType("application/json").
				post("/commerce/checkouts/calculate/fee");
		
//		String bodyOutput = response.getBody().asString();
//		
//		System.out.println(bodyOutput);
//		
//		System.out.println();
		
		String output = response.
				then().
				contentType(ContentType.JSON).
				extract().response().
				asString();
		
		
		
		System.out.println(output);
		
//		response.then().body("data.orderNumber", Matchers.is("1903216243"));
//		response.then().body("data.status.name", Matchers.is("PREPARING"));
//		response.then().body("data.status.value", Matchers.is("Preparing"));
//		
//		response.then().body("data.paymentStatus.name", Matchers.is("PAIDSUCCESS"));
//		response.then().body("data.paymentStatus.value", Matchers.is("PaidSuccess"));
		response.then().body("code", Matchers.is("1"));
		
	}
	
}
