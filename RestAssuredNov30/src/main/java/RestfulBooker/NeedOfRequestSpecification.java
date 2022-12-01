package RestfulBooker;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;

public class NeedOfRequestSpecification {
	
	//1. Configure request - RequestSpecification
	//2. Hit the request and get the response
	//3. Assert/Verify the response
	
	@Test
	public void createBooking() {
		
		//1. Configure request - RequestSpecification
	//	RequestSpecification requestSpecification = RestAssured.given();
		
	//	RequestLogSpecification requestLog = RestAssured.given().log();
	//	RestAssured.given().log().all();
		
		RestAssured.given()
		.log()
		.all()
		.header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"firstname\" : \"Jim\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2022-12-01\",\r\n"
				+ "        \"checkout\" : \"2022-12-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}")
		
		.baseUri("https://restful-booker.herokuapp.com")
		.basePath("/booking")
		
		/*
		requestSpecification.header("Content-Type","application/json");
		requestSpecification.body("{\r\n"
				+ "    \"firstname\" : \"Jim\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}"); */
		
		
	
		
		
		//2. Hit the request and get the response
		.post()
		.then()
		.log()
		.all()
		.statusCode(200);
		
		//3. Assert/Verify the response
	//	ValidatableResponse validatableResponse = response.then();
	//	validatableResponse.statusCode(200);
		
		//Log response 
	//	System.out.println("========================");
	//	validatableResponse.log().all();
		
		
		
		
	
	}

}
