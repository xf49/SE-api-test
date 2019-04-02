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

public class PutAdminProductsIdVariant {

	@Test
	public void test() {
		
		CommonData cd = new CommonData();
		GetToken gt = new GetToken();
		
		RestAssured.baseURI = cd.adminUrl;
		
		RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type", "application/json");
		request.header("wm-commerce-token",gt.tokenAdmin());
		
		
		Response response = request.body("{\r\n" + 
				"    \"costPriceCent\": 10,\r\n" + 
				"    \"originalPriceCent\": 10,\r\n" + 
				"    \"sellingPriceCent\": 10,\r\n" + 
				"    \"available\": true,\r\n" + 
				"    \"searchTags\": [],\r\n" + 
				"    \"searchTag\": [],\r\n" + 
				"    \"categoryId\": \"2518860467853386173\",\r\n" + 
				"    \"supplierIds\": [\r\n" + 
				"        \"654\"\r\n" + 
				"    ],\r\n" + 
				"    \"excludeCountryCodeList\": [],\r\n" + 
				"    \"tagIds\": [],\r\n" + 
				"    \"productConnectIds\": [],\r\n" + 
				"    \"multiLanguage\": [\r\n" + 
				"        {\r\n" + 
				"            \"language\": \"ENGLISH\",\r\n" + 
				"            \"translation\": {\r\n" + 
				"                \"bodyHtml\": \"\",\r\n" + 
				"                \"detailDescription\": \"{}\",\r\n" + 
				"                \"title\": \"hello666\"\r\n" + 
				"            }\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"language\": \"CHINESE\",\r\n" + 
				"            \"translation\": {\r\n" + 
				"                \"bodyHtml\": \"\",\r\n" + 
				"                \"detailDescription\": \"{}\",\r\n" + 
				"                \"title\": \"\"\r\n" + 
				"            }\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"language\": \"ARABIC\",\r\n" + 
				"            \"translation\": {\r\n" + 
				"                \"bodyHtml\": \"\",\r\n" + 
				"                \"detailDescription\": \"{}\",\r\n" + 
				"                \"title\": \"\"\r\n" + 
				"            }\r\n" + 
				"        }\r\n" + 
				"    ],\r\n" + 
				"    \"mediaList\": [\r\n" + 
				"        \"3077607881703612652\"\r\n" + 
				"    ],\r\n" + 
				"    \"detailMediaList\": [\r\n" + 
				"        \"3077607881703612655\"\r\n" + 
				"    ],\r\n" + 
				"    \"skuMediaList\": [\r\n" + 
				"        \"3077607881703612657\"\r\n" + 
				"    ],\r\n" + 
				"    \"primaryMediaId\": \"3077607881703612652\",\r\n" + 
				"    \"productVariantDTOList\": [\r\n" + 
				"        {\r\n" + 
				"            \"articleNumber\": \"\",\r\n" + 
				"            \"sku\": \"\",\r\n" + 
				"            \"inventoryQuantity\": 10,\r\n" + 
				"            \"costPriceCent\": 1000,\r\n" + 
				"            \"originalPriceCent\": 1000,\r\n" + 
				"            \"sellingPriceCent\": 1000,\r\n" + 
				"            \"weight\": 10,\r\n" + 
				"            \"height\": \"\",\r\n" + 
				"            \"length\": \"\",\r\n" + 
				"            \"width\": \"\",\r\n" + 
				"            \"imageId\": \"3077607881703612657\",\r\n" + 
				"            \"optionList\": [\r\n" + 
				"                \"85\",\r\n" + 
				"                \"12\"\r\n" + 
				"            ]\r\n" + 
				"        }\r\n" + 
				"    ],\r\n" + 
				"    \"optionIdList\": []\r\n" + 
				"}").
				contentType("application/json").
				put("/admin/products/3057091991161171790/variants");
		
		response.then().body("code", Matchers.is("1"));
		response.then().body("data.id",Matchers.is("3057091991161171790"));
		
		
		
	}
	
}
