package Payload;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class CreateBookingMethodChaining {
	
	//1. Configure request - RequestSpecification
	//2. Hit the request and get the response
	//3. Assert/Verify the response
	
	//Define class level variable:
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	
	public String getCreateBookingPayload(String firstName,String lastName,String price) {
		String payload="{\r\n"
				+ "    \"firstname\" : \""+firstName+"\",\r\n"
				+ "    \"lastname\" : \""+lastName+"\",\r\n"
				+ "    \"totalprice\" : "+price+",\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2022-12-01\",\r\n"
				+ "        \"checkout\" : \"2022-12-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}";
		
		return payload;
	}
	
	@BeforeClass
	public void setUp() {
		//Local variable
		requestSpecification = RestAssured.given();
		requestSpecification.baseUri("https://restful-booker.herokuapp.com/")
		.basePath("booking")
		.log()
		.all()
		.header("Content-Type","application/json");
		
		responseSpecification=	RestAssured.expect();
		responseSpecification.statusCode(200)
		.contentType(ContentType.JSON)
		//.time(Matchers.greaterThan(5000L));
		.time(Matchers.lessThan(5000L));
	}
	
	@Test
	public void createBooking() {
		
		//1. Configure request - RequestSpecification
	//	RequestSpecification requestSpecification = RestAssured.given();
		
	//	RequestLogSpecification requestLog = RestAssured.given().log();
	//	RestAssured.given().log().all();
		
		RestAssured.given()
		.spec(requestSpecification)
		.body(getCreateBookingPayload("Jim", "Ju", "10000000"))
		
		//.baseUri("")
		//.basePath("/booking")
		
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
		.spec(responseSpecification);
//		.log()
//		.all()
//		.statusCode(200);
		
		//3. Assert/Verify the response
	//	ValidatableResponse validatableResponse = response.then();
	//	validatableResponse.statusCode(200);
		
		//Log response 
	//	System.out.println("========================");
	//	validatableResponse.log().all();
		
	}
	
	//@Test
	public void request2() {
		RestAssured
		.given()
		.spec(requestSpecification)
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
	
		.when()
		.post()
		.then()
		.log()
		.all()
		.statusCode(200);
		
		
		
	}

	//@Test
	public void request3() {
		RestAssured
		.given()
		.spec(requestSpecification)
		.body("{\r\n"
				+ "    \"firstname\" : \"Jim\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2022-11-30\",\r\n"
				+ "        \"checkout\" : \"2022-12-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Lunch\"\r\n"
				+ "}")
	
		.when()
		.post()
		.then()
		.spec(responseSpecification);
//		.log()
//		.all()
//		.statusCode(200)
//		.contentType(ContentType.JSON)
//		.time(Matchers.greaterThan(5000L));
//		
	
	}

}
