package Payload;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ObjectNodeExample {
	public static void main(String[] args) throws JsonProcessingException {

		// ObjectMapper is used instead of Map
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectNode emp1 = objectMapper.createObjectNode();

		emp1.put("firstname", "Jim");
		emp1.put("lastname", "Brown");
		emp1.put("totalprice", 111);
		emp1.put("depositpaid", true);
		emp1.put("additionalneeds", "Breakfast");

		System.out.println(emp1);
		System.out.println("===============================");

		// Array Node
		ArrayNode empDetails = objectMapper.createArrayNode();
		empDetails.add(emp1);
		System.out.println(empDetails);

//Above is example for java object
//Below is for converting java object to JSON object
		String jsonString = objectMapper.writeValueAsString(emp1);
		System.out.println(jsonString);

		String jsonString2 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
		System.out.println(jsonString2);

/*		
		{"firstname":"Jim","lastname":"Brown","totalprice":111,"depositpaid":true,"additionalneeds":"Breakfast"}
		===============================
		[{"firstname":"Jim","lastname":"Brown","totalprice":111,"depositpaid":true,"additionalneeds":"Breakfast"}]
		{"firstname":"Jim","lastname":"Brown","totalprice":111,"depositpaid":true,"additionalneeds":"Breakfast"}
		
		{
		  "firstname" : "Jim",
		  "lastname" : "Brown",
		  "totalprice" : 111,
		  "depositpaid" : true,
		  "additionalneeds" : "Breakfast"
		}

*/
		
		
	}

}
