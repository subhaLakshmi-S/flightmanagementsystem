package com.example.flightmanagementsystem.controllers;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.example.flightmanagementsystem.entity.Flight;
import com.example.flightmanagementsystem.entity.Schedule;
import com.example.flightmanagementsystem.entity.ScheduledFlight;

import com.example.flightmanagementsystem.services.AirportService;
import com.example.flightmanagementsystem.services.Flightservice;
import com.example.flightmanagementsystem.services.ScheduleService;
import com.example.flightmanagementsystem.services.ScheduledFlightService;
import com.example.flightmanagementsystem.exceptions.NoScheduleFoundException;
import com.example.flightmanagementsystem.exceptions.NoFlightOrRouteFoundException;

@RestController
@RequestMapping("/scheduledFlight")
public class ScheduledFlightController<SceduleService> {
	@Autowired
	ScheduledFlightService scheduleFlightService;
	@Autowired
	AirportService airportService;
	@Autowired
	Flightservice flightService;
	@Autowired
	ScheduleService scheduleService;

	/*
	 * Controller for adding Scheduled Flights
	 */
	@PostMapping(consumes = "application/json",value="/ScheduleFlight")
	public String addScheduleFlight(@RequestBody ScheduledFlight scheduleFlight) {

		List<Flight> flights = flightService.viewAllFlights();
		List<Schedule> schedules =scheduleService.viewAllSchedule();

		for(Flight f: flights) {
			for(Schedule s: schedules) {
			if(f.getFlightId().equals(scheduleFlight.getFlight().getFlightId())&&s.getScheduleID().equals(scheduleFlight.getSchedule().getScheduleID())) {
				scheduleFlight.getFlight().setFlightId(f.getFlightId());
				scheduleFlight.getSchedule().setScheduleID(s.getScheduleID());
				Random rand = new Random();
				int resRandom = rand.nextInt((9999 - 100) + 1) + 10;
				scheduleFlight.setScheduleFlightId(Integer.toString(resRandom)); 
				scheduleFlightService.addScheduledFlight(scheduleFlight);
				return "Added succesfully";	 
			}
		}
			
		}
		throw new NoFlightOrRouteFoundException();
		
	}


	/*
	 * Controller for modifying existing Scheduled Flights
	 */
	@PutMapping(value="/update/scheduleFlight")
	public String modifyScheduleFlight(@RequestBody ScheduledFlight scheduleFlight) {
		scheduleFlightService.modifyScheduledFlight(scheduleFlight);
		return "Updated Successfully";
	}

	/*
	 * Controller for deleting existing Scheduled Flights
	 */
	@DeleteMapping(value="/delete/{scheduleFlightID}")
	public String deleteScheduledFlightById(@PathVariable("scheduleFlightID") String scheduleFlightId) {
		scheduleFlightService.removeScheduledFlight(scheduleFlightId);
		return "Deleted Successfully";
	}
	/*
	 * Controller for viewing a Scheduled Flight by ID
	 */
	@GetMapping(value="/viewById/{scheduleFlightID}")
	public ScheduledFlight viewById(@PathVariable("scheduleFlightID") String scheduleFlightId ) {
		
		if(scheduleFlightService.viewScheduledFlight(scheduleFlightId)==null) {
			throw new NoScheduleFoundException();
		}
		return scheduleFlightService.viewScheduledFlight(scheduleFlightId);
		
	}

	/*
	 * Controller for viewing all Scheduled Flights
	 */
	@GetMapping("/viewAll")
	public Iterable<ScheduledFlight> viewAllSF() {
		return scheduleFlightService.viewAllScheduledFlights();
	}
}
