package POJOPayload;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UseEmployee {

	public static void main(String[] args) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		Employee emp = new Employee();
		emp.setFirstName("VV");
		emp.setLastName("Vishwa");
		emp.setSalary(10000000);
		emp.setExpert(true);

		String jsonEmployee = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);

		System.out.println(jsonEmployee);
		
		/* 
		{
			  "firstName" : "VV",
			  "lastName" : "Vishwa",
			  "salary" : 10000000,
			  "expert" : true
			}
			*/
	}
}
