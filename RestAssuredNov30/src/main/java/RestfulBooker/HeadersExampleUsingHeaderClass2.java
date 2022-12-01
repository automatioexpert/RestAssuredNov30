package RestfulBooker;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersExampleUsingHeaderClass2 {
	/*h1,v1
	 *h2,v2
	 *h3,v3
	 * 
	 */
	
	@Test
	public void addHeaders() {
		
		//Pass Header using Map
		//Header has got 5 diff overloaded method
		Map<String,String> header=new HashMap<String,String>();
		header.put("h1", "v1");
		header.put("h2", "v2");
		header.put("h3", "v3");
		header.put("h4", "v4");
		
	Response response=	
		RestAssured.given()
		.log()
		.all()
		.headers(header)
		.get();
	
	System.out.println("==========Below are headers================");

	//Get all header and print all the headers 
	
	Headers headers=response.getHeaders();
		
	for(Header head:headers) {
		System.out.println(head);
		System.out.println(head.getName()+" : "+head.getValue());
	}
		
		
	String conn=response.getHeader("ContentType");
		System.out.println("Conn::"+conn); 
	}

}
