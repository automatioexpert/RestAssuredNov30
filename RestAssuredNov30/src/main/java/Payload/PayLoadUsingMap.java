package Payload;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class PayLoadUsingMap {
	
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
			
		Map<String,Object> payload=new HashMap<>();
		payload.put("firstname", "Jim");
		payload.put("lastname", "Brown");
		payload.put("totalprice", 10000000);
		payload.put("depositpaid", true);
		
//java.lang.IllegalStateException: Cannot serialize object 
//because no JSON serializer found in classpath. 
//Please put Jackson (Databind), Gson, Johnzon, 
//or Yasson in the classpath.

		RestAssured.given()
		.log()
		.all()
		.header("Content-Type","application/json")
		.body(payload)
		.baseUri("https://restful-booker.herokuapp.com")
		.basePath("booking")
		.post();
				
	
	}

}
