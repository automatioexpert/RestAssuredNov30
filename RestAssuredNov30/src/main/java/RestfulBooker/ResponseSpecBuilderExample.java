package RestfulBooker;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecBuilderExample {

//Class level variable:
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;

	@BeforeClass
	public void setUp() {
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		requestSpecBuilder.setBaseUri("https://restful-booker.herokuapp.com");
		requestSpecBuilder.setBasePath("/booking");
		requestSpecBuilder.addHeader("Content-Type", "application/json");
		requestSpecBuilder.log(LogDetail.ALL);
		requestSpecification = requestSpecBuilder.build();

		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
		responseSpecBuilder.expectStatusCode(200);
		responseSpecBuilder.expectContentType(ContentType.JSON);
		responseSpecBuilder.expectResponseTime(Matchers.lessThan(10000L));
		responseSpecBuilder.build();
	
	}
	@Test
	public void request3() {
		RestAssured
		.given(requestSpecification)
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
		.post();
	
	}

	

}
