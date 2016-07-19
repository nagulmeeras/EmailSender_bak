package com.pramati.emailsender;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pramati.emailsender.beans.Employee;
<<<<<<< HEAD
import com.pramati.emailsender.beans.Facilities;
=======
>>>>>>> 547909aea75b2c7a94cf202b10b8abe7c72779cd
import com.pramati.emailsender.beans.TravelInfo;
import com.pramati.emailsender.beans.Traveller;
import com.pramati.emailsender.beans.Trip;

@Component
public class DataParser {

<<<<<<< HEAD
	public TravelInfo parseRequestData(HashMap<String, String> inputData) {
=======
	public TravelInfo parseRequestData(HashMap<String, String> inputData){
>>>>>>> 547909aea75b2c7a94cf202b10b8abe7c72779cd
		TravelInfo travelInfo = new TravelInfo();
		travelInfo.setRequestId("12603");
		travelInfo.setWorkLocation("Hyderabad");
		travelInfo.setEmployee(true);
<<<<<<< HEAD
		travelInfo.setBilledTo("employee");
		travelInfo.setTicketChecked(true);
		travelInfo.setApprovingManagerEmail("nagulmeera.shaik@gmail.com");

=======
		travelInfo.setBilledTo("client");
		travelInfo.setTicketChecked(true);
		
>>>>>>> 547909aea75b2c7a94cf202b10b8abe7c72779cd
		Traveller traveller = new Traveller();
		traveller.setdOB("05-03-1991");
		traveller.setGender("Male");
		traveller.setMealPreference("Lunch");
		traveller.setName("Nagulmeera");
		traveller.setRelationship("");
<<<<<<< HEAD

=======
		
>>>>>>> 547909aea75b2c7a94cf202b10b8abe7c72779cd
		Trip trip = new Trip();
		trip.setType("Visit");
		trip.setFrom("Hyderabad");
		trip.setTo("Delhi");
		trip.setDateOfJourney("14-07-2016");
		trip.setPreferredTime("12:00");
<<<<<<< HEAD

=======
		
>>>>>>> 547909aea75b2c7a94cf202b10b8abe7c72779cd
		Trip trip1 = new Trip();
		trip1.setType("Visit");
		trip1.setFrom("Hyderabad");
		trip1.setTo("Delhi");
		trip1.setDateOfJourney("14-07-2016");
		trip1.setPreferredTime("12:00");
<<<<<<< HEAD

=======
		
>>>>>>> 547909aea75b2c7a94cf202b10b8abe7c72779cd
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
<<<<<<< HEAD

=======
		
>>>>>>> 547909aea75b2c7a94cf202b10b8abe7c72779cd
		Employee employee = new Employee();
		employee.setApprovingManager("afasfasfasf");
		employee.setName("Nagulmeera");
		employee.setContactNumber("afasfasfas");
		employee.setId("12603");
<<<<<<< HEAD
		employee.setEmailId("sknagulmeera06@gmail.com");

		Facilities facilities = new Facilities();
		facilities.setHotel(true);
		facilities.setTicket(true);
		facilities.setForex(false);
		facilities.setInsurance(false);
		facilities.setSimCard(true);
		facilities.setVisa(false);

		List<Facilities> facilitiesList = new ArrayList<Facilities>();
		facilitiesList.add(facilities);
=======
>>>>>>> 547909aea75b2c7a94cf202b10b8abe7c72779cd
		
		travelInfo.setTravellers(travellersDetails);
		travelInfo.setTrips(trips);
		travelInfo.setEmployee(employee);
<<<<<<< HEAD
		travelInfo.setFacilites(facilitiesList);

=======
		
>>>>>>> 547909aea75b2c7a94cf202b10b8abe7c72779cd
		return travelInfo;
	}
}
