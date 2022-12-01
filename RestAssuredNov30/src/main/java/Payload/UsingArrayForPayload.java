package Payload;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsingArrayForPayload {

	public static void main(String[] args) {
		Map<String, Object> details1 = new HashMap<String, Object>();
		details1.put("firstname", "Jim");
		details1.put("lastname", "Brown");
		details1.put("totalprice", 111);
		details1.put("depositpaid", true);
		details1.put("additionalneeds", "Breakfast");

		Map<String, Object> details2 = new HashMap<String, Object>();
		details2.put("firstname", "Jim");
		details2.put("lastname", "Brown");
		details2.put("totalprice", 111);
		details2.put("depositpaid", true);
		details2.put("additionalneeds", "Breakfast");

		// details1.put("details2", details2);
		System.out.println(details1);

		// Create list of Map
		List<Map<String, Object>> empDetails = new ArrayList<>();
		empDetails.add(details1);
		empDetails.add(details2);
		System.out.println(empDetails);

	}

}
