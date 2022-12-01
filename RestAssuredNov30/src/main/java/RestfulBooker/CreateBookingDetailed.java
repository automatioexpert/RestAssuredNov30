package RestfulBooker;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;

public class CreateBookingDetailed {
	
	//1. Configure request - RequestSpecification
	//2. Hit the request and get the response
	//3. Assert/Verify the response
	
	@Test
	public void createBooking() {
		
		//1. Configure request - RequestSpecification
		RequestSpecification requestSpecification = RestAssured.given();		

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
				+ "}");
		
		requestSpecification.baseUri("https://restful-booker.herokuapp.com");
		requestSpecification.basePath("/booking");
	
		RequestLogSpecification requestLog = requestSpecification.log();
		requestLog.all();
		
		//2. Hit the request and get the response
		Response response =requestSpecification.post();
		
		//3. Assert/Verify the response
		ValidatableResponse validatableResponse = response.then();
		validatableResponse.statusCode(200);
		
		//Log response 
		System.out.println("========================");
		validatableResponse.log().all();
		
		
		
		
	
	}

}
