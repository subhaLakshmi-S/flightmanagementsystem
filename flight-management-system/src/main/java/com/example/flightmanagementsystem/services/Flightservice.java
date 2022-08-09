package com.example.flightmanagementsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flightmanagementsystem.entity.Flight;
import com.example.flightmanagementsystem.entity.User;
import com.example.flightmanagementsystem.repositories.Flightrepo;

@Service
public class Flightservice {

	@Autowired
	private Flightrepo flightrepo;

	public String addflight(Flight flight) {
		if (flight.getCarrierName().isEmpty() || flight.getFlightModel().isEmpty()) {
			return "Please fill all fields";
		} else if (flight.getSeatCapacity() == 0)
			return "Seat Capacity can not be zero";
		else {
			flightrepo.save(flight);
			return "Flight Created successfully\nFlight Id is " + flight.getFlightId();
		}
	}

	public List<Flight> viewAllFlights() {
		return flightrepo.findAll();
	}

	public List<Flight> viewFlightById(String flightId) {
		return flightrepo.findByFlightId(flightId);
	}

	/*
	 * public boolean modifyFlight(String flightId, Flight flight) {
	 * if(flightrepo.existsById(flightId)) { flightrepo.save(flight); return
	 * "Updated"+flightrepo.findByFlightId(flightId) != null; } else
	 * 
	 * return "Id not found"; }
	 */
	public String modifyFlight(String flightId, Flight flight) {
		if (flightrepo.existsById(flightId)) 
		{
			Flight flight1 = flightrepo.getReferenceById(flightId);
			if (flight.getCarrierName().isEmpty() || flight.getFlightModel().isEmpty()) {
				return "Please fill all fields";
			} 
			else if (flight.getSeatCapacity() == 0)
				return "Seat Capacity can not be zero";
			else {
				flight1.setCarrierName(flight.getCarrierName());
				flight.setFlightModel(flight.getFlightModel());
				flight1.setSeatCapacity(flight.getSeatCapacity());
				flightrepo.save(flight1);
				return "Updated " + flight1;
			}
		} 
		else {
			return "FlightID Not Found";
		}
	}

	public int deleteFlight(String flightId) {
		if (flightrepo.existsById(flightId)) {
			flightrepo.deleteById(flightId);
			return 1;
		} else
			return 0;
	}
}