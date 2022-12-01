package RestfulBooker;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

public class RequestSpecBuilderExample {

//Class level variable:
	RequestSpecification requestSpecification;

	@BeforeClass
	public void setUp() {
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		requestSpecBuilder.setBaseUri("https://restful-booker.herokuapp.com");
		requestSpecBuilder.setBasePath("/booking");
		requestSpecBuilder.addHeader("Content-Type", "application/json");
		requestSpecBuilder.log(LogDetail.ALL);
		requestSpecification = requestSpecBuilder.build();

	}
	

}
