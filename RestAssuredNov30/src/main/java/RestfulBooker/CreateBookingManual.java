package RestfulBooker;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class CreateBookingManual {


	@Test
	public void createBookingAgain() {
		
		RequestSpecification spec = RestAssured.given();
		
		RestAssured
		.given()
		.baseUri("")
		.basePath("")
		.log()
		.all()
		.header("","")
		.body("")
		.post()
		.then()
		.statusCode(200);
		
		
 	}
}
