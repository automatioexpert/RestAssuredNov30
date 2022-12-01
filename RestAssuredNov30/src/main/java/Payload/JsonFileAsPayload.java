package Payload;
import java.io.File;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class JsonFileAsPayload {
	/*
	curl -X POST \
	  https://restful-booker.herokuapp.com/booking \
	  -H 'Content-Type: application/json' \
	  -d '{
	    "firstname" : "Jim",
	    "lastname" : "Brown",
	    "totalprice" : 111,
	    "depositpaid" : true,
	    "bookingdates" : {
	        "checkin" : "2018-01-01",
	        "checkout" : "2019-01-01"
	    },
	    "additionalneeds" : "Breakfast"
	}' */
 
	@Test
	public void sendJson() {
		
		File jsonPayload= new File("./src/main/java/Payload/CreateBookingPayload.json");
		
		RestAssured.baseURI="https://restful-booker.herokuapp.com/";
		RestAssured.basePath="booking";
		
		RestAssured.given()
		.log()
		.all()
		.header("Content-Type","application/json")
		.body(jsonPayload)
		.when()
		.post()
		.then()
		.statusCode(200);
		
	}

}
