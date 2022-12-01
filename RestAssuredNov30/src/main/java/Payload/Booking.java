package Payload;

public class Booking {
	
	private String tripType="One Way";
	private String departFrom="Mumbai";
	private String goingTo="Delhi";
	private String departureDate="25-01-2022";
	
	public String getTripType() {
		return tripType;
	}
	public void setTripType(String tripType) {
		this.tripType = tripType;
	}
	public String getDepartFrom() {
		return departFrom;
	}
	public void setDepartFrom(String departFrom) {
		this.departFrom = departFrom;
	}
	public String getGoingTo() {
		return goingTo;
	}
	public void setGoingTo(String goingTo) {
		this.goingTo = goingTo;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	

}
