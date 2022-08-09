package com.example.flightmanagementsystem.services;
import java.math.BigInteger;

import com.example.flightmanagementsystem.entity.ScheduledFlight;
import com.example.flightmanagementsystem.exceptions.RecordNotFoundException;
import com.example.flightmanagementsystem.exceptions.ScheduledFlightNotFoundException;

public interface ScheduledFlightService {
	public ScheduledFlight addScheduledFlight(ScheduledFlight scheduledFlight);

	public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduledFlight);

	public int removeScheduledFlight(String scheduleFlightId) throws RecordNotFoundException;

	public Iterable<ScheduledFlight> viewAllScheduledFlights();

	public ScheduledFlight viewScheduledFlight(String scheduleFlightId) throws ScheduledFlightNotFoundException;
}