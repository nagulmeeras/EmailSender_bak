package com.pramati.emailsender;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pramati.emailsender.beans.Employee;
import com.pramati.emailsender.beans.TravelInfo;
import com.pramati.emailsender.beans.Traveller;
import com.pramati.emailsender.beans.Trip;

@Component
public class DataParser {

	public TravelInfo parseRequestData(HashMap<String, String> inputData){
		TravelInfo travelInfo = new TravelInfo();
		travelInfo.setRequestId("12603");
		travelInfo.setWorkLocation("Hyderabad");
		travelInfo.setEmployee(true);
		travelInfo.setBilledTo("client");
		travelInfo.setTicketChecked(true);
		
		Traveller traveller = new Traveller();
		traveller.setdOB("05-03-1991");
		traveller.setGender("Male");
		traveller.setMealPreference("Lunch");
		traveller.setName("Nagulmeera");
		traveller.setRelationship("");
		
		Trip trip = new Trip();
		trip.setType("Visit");
		trip.setFrom("Hyderabad");
		trip.setTo("Delhi");
		trip.setDateOfJourney("14-07-2016");
		trip.setPreferredTime("12:00");
		
		Trip trip1 = new Trip();
		trip1.setType("Visit");
		trip1.setFrom("Hyderabad");
		trip1.setTo("Delhi");
		trip1.setDateOfJourney("14-07-2016");
		trip1.setPreferredTime("12:00");
		
		List<Trip> trips = new ArrayList<Trip>();
		trips.add(trip);
		trips.add(trip1);

		Traveller traveller1 = new Traveller();
		traveller1.setName("Nagulmeera Shaik");
		traveller1.setGender("Male");
		traveller1.setdOB("05-03-1991");
		traveller1.setRelationship("");
		traveller1.setMealPreference("Dinner");

		List<Traveller> travellersDetails = new ArrayList<Traveller>();
		travellersDetails.add(traveller);
		travellersDetails.add(traveller1);
		
		Employee employee = new Employee();
		employee.setApprovingManager("afasfasfasf");
		employee.setName("Nagulmeera");
		employee.setContactNumber("afasfasfas");
		employee.setId("12603");
		
		travelInfo.setTravellers(travellersDetails);
		travelInfo.setTrips(trips);
		travelInfo.setEmployee(employee);
		
		return travelInfo;
	}
}
