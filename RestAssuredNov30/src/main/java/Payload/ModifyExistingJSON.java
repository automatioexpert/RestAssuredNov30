package Payload;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ModifyExistingJSON {
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		
		String someJSON="{\r\n"
				+ "  \"firstname\" : \"Jim\",\r\n"
				+ "  \"lastname\" : \"Brown\"}";
		
		//I want to read above json as a MAP
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		Map jsonMap = objectMapper.readValue(someJSON, Map.class);
		jsonMap.put("age", 27);
		jsonMap.put("id", 10000000);
		
		
		System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonMap));
		
		
		
		
		
	
	}

}
