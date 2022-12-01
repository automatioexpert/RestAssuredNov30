package Payload;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UseBookingWithDefaultValues {
	
	public static void main(String[] args) throws JsonProcessingException {
		
		Booking booking = new Booking();
		//If we are not setting any value
		//then default values will be displayed
		
		
		//booking.setTripType("Two Way");
		
		ObjectMapper objectMapper= new ObjectMapper();
		
		String jsonEmployee=objectMapper.writerWithDefaultPrettyPrinter()
		.writeValueAsString(booking);
		
		System.out.println(jsonEmployee);
		
		
	}

}
