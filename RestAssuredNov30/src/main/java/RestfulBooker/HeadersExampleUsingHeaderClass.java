package RestfulBooker;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;

public class HeadersExampleUsingHeaderClass {
	/*h1,v1
	 *h2,v2
	 *h3,v3
	 * 
	 */
	
	@Test
	public void addHeaders() {
		
		//Pass Header using Map
		//Header has got 5 diff overloaded method
		/*
		Map<String,String> header=new HashMap<String,String>();
		header.put("h1", "v1");
		header.put("h2", "v2");
		header.put("h3", "v3");
		header.put("h4", "v4"); */
		
		Header header = new Header("h4","v4");
		
		
		RestAssured.given()
		.log()
		.all()
		.header(header)
		.get();
		
		 
	}

}
