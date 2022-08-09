package com.example.flightmanagementsystem.services;

import java.math.BigInteger;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.flightmanagementsystem.repositories.ScheduleRepo;
import com.example.flightmanagementsystem.repositories.ScheduledFlightRepo;
import com.example.flightmanagementsystem.entity.Flight;
import com.example.flightmanagementsystem.entity.Schedule;
import com.example.flightmanagementsystem.entity.ScheduledFlight;
import com.example.flightmanagementsystem.exceptions.RecordNotFoundException;
import com.example.flightmanagementsystem.exceptions.ScheduledFlightNotFoundException;
import com.example.flightmanagementsystem.services.BookingService;
import com.example.flightmanagementsystem.services.ScheduledFlightService;

import com.example.flightmanagementsystem.exceptions.NoScheduleFoundException;

@Service
public class ScheduledFlightServiceImpl implements ScheduledFlightService {

	/*
	 * Creating DAO object
	 */
	@Autowired
	ScheduledFlightRepo scheduleFlightRepo;
	@Autowired
	ScheduleRepo scheduleDao;
	@Autowired
	BookingService bookingService;

	@Override
	public ScheduledFlight addScheduledFlight(ScheduledFlight scheduledFlight) {
		return scheduleFlightRepo.save(scheduledFlight);
	}

	@Override
	public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduledFlight) {
		return scheduleFlightRepo.save(scheduledFlight);
	}

	@Override
	public int removeScheduledFlight(String scheduleFlightId) throws RecordNotFoundException {
		if (scheduleFlightRepo.existsById(scheduleFlightId)) {
			scheduleFlightRepo.deleteById(scheduleFlightId);
			return 1;
		} else {
			throw new NoScheduleFoundException();
		}
	}

	@Override
	public ArrayList<ScheduledFlight> viewAllScheduledFlights() {
		return (ArrayList<ScheduledFlight>) scheduleFlightRepo.findAll();
	}

	@Override
	public ScheduledFlight viewScheduledFlight(String scheduleFlightId) throws ScheduledFlightNotFoundException {
		return scheduleFlightRepo.findByScheduleFlightId(scheduleFlightId);
	}

}