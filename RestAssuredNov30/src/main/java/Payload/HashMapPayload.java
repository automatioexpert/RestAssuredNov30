package Payload;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class HashMapPayload {
/*
	{
	    "firstname" : "Jim",
	    "lastname" : "Brown",
	    "totalprice" : 111,
	    "depositpaid" : true,
	    "bookingdates" : {
	        "checkin" : "2018-01-01",
	        "checkout" : "2019-01-01"
	    },
	    "additionalneeds" : "Breakfast"
	} */
	
	
	@Test
	public void sendPayload() {
		
	Map<String,Object> details= new HashMap<String,Object>();
	details.put("firstname", "Jim");
	details.put("lastname", "Brown");
	details.put("totalprice", 111);
	details.put("depositpaid", true);
	details.put("additionalneeds", "Breakfast");
	
	Map<String,Object> bookingDates= new HashMap<String,Object>();
	bookingDates.put("checkin", "2022-12-01");
	bookingDates.put("checkout", "2022-12-01");
	
	details.put("bookingDates", bookingDates);
	
	System.out.println(details);
	
	RestAssured.baseURI="https://restful-booker.herokuapp.com/";
	 RestAssured
	 
	 .given()
	 .contentType(ContentType.JSON)
	 .log()
	 .all()
	 .body(details.toString())
	 .when()
	 .post("booking")
	 .then()
	 .log()
	 .all()
	 .statusCode(200);
	 
	
		
	}

	
}
