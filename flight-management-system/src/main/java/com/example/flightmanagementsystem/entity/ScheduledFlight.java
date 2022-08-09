package com.example.flightmanagementsystem.entity;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@Table(name="ScheduledFlights")
public class ScheduledFlight {
	
	@Id
	@Column(name = "schedule_flight_id")
	private String scheduleFlightId;

	@Column(name = "available_seats")
	@NotNull
	private Integer availableSeats;
	
	@Column(name = "available_date")
	@NotNull
	private Date availableDate;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn (name="flightId")
	private Flight flight;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="scheduleID")
	private Schedule schedule;

	/**
	 * @return the scheduleFlightId
	 */
	public String getScheduleFlightId() {
		return scheduleFlightId;
	}

	/**
	 * @param scheduleFlightId the scheduleFlightId to set
	 */
	public void setScheduleFlightId(String scheduleFlightId) {
		this.scheduleFlightId = scheduleFlightId;
	}

	/**
	 * @return the availableSeats
	 */
	public Integer getAvailableSeats() {
		return availableSeats;
	}

	/**
	 * @param availableSeats the availableSeats to set
	 */
	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

	/**
	 * @return the flight
	 */
	public Flight getFlight() {
		return flight;
	}

	/**
	 * @param flight the flight to set
	 */
	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	/**
	 * @return the schedule
	 */
	public  Schedule getSchedule() {
		return schedule;
	}

	/**
	 * @param schedule the schedule to set
	 */
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return "ScheduledFlight [scheduleFlightId=" + scheduleFlightId + ", availableSeats=" + availableSeats
				+ ", flight=" + flight + ", schedule=" + schedule + "]";
	}
	
	
}
