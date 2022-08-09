package com.example.flightmanagementsystem.controllers;

import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.flightmanagementsystem.entity.Schedule;
import com.example.flightmanagementsystem.exceptions.AirportNotFoundException;
import com.example.flightmanagementsystem.exceptions.ListEmptyException;
import com.example.flightmanagementsystem.services.ScheduleService;
@RestController
public class ScheduleController {
	ScheduleService scheduleservice;
	@PostMapping(value="/route/save",consumes = "application/json")
	public String addroute(@RequestBody Schedule schedule) {
		
		Random rand = new Random();
		int resRandom = rand.nextInt((9999 - 100) + 1) + 10;
		schedule.setScheduleID(schedule.getSourceAirport().substring(0,2)+ schedule.getDestinationAirport().substring(0,2) + Integer.toString(resRandom)); 
		scheduleservice.addSchedule(schedule);
		 return "Added Successfully";
		
	}
	@GetMapping("/viewSchedule")
	public List<Schedule> viewSchedule() throws ListEmptyException {
		if (scheduleservice.viewAllSchedule().isEmpty())
			throw new ListEmptyException();
		return scheduleservice.viewAllSchedule();
	}
	
	@GetMapping(value = "/ScheduleById/{scheduleId}")
	public String viewScheduleByID(@PathVariable("scheduleId") String scheduleId) throws AirportNotFoundException {
		if (scheduleservice.viewscheduleById(scheduleId).isEmpty())
			throw new AirportNotFoundException();
		System.out.println("Fetched Successfully");
		return scheduleservice.viewscheduleById(scheduleId);
	}

	@DeleteMapping(value = "/delete/{scheduleId}")
	public String deleteAirport(@PathVariable String scheduleId) {
		return scheduleservice.removescheduleId(scheduleId);
	}

	@PutMapping(value = "/updateAirport/{scheduleId}")
	public String updateAirport(@PathVariable (value="airportId")String scheduleId, @RequestBody Schedule schedule) {
		return scheduleservice.modifySchedule(scheduleId, schedule);
	}

}
