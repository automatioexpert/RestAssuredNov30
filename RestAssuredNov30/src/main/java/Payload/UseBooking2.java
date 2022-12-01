package Payload;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UseBooking2 {

	public static void main(String[] args) throws JsonProcessingException {
		Booking booking = new Booking();
		
		Travellers travellers=new Travellers();
		travellers.setFirstName("steve");
		travellers.setLastName("jobs");
		travellers.setAge(21);
		
		Travellers travellers2=new Travellers();
		travellers2.setFirstName("Bill");
		travellers2.setLastName("gates");
		travellers2.setAge(22);
		
		List<Travellers> allTravellers= new ArrayList<>();
		allTravellers.add(travellers);
		allTravellers.add(travellers2);
		
		//Print using ObjectMapper class
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(allTravellers);
		System.out.println(jsonString);
		
		/*
		[ {
			  "firstName" : "steve",
			  "lastName" : "jobs",
			  "age" : 21
			}, {
			  "firstName" : "Bill",
			  "lastName" : "gates",
			  "age" : 22
			} ]
		*/
	}
}
