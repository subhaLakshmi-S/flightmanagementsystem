package com.example.flightmanagementsystem.entity;

import java.math.BigInteger;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@Table(name = "schedule")
public class Schedule {
	@Id
	private String scheduleID;
	private String sourceAirport;
	private String destinationAirport;
	private Integer ticketcost;

	/*
	 * @OneToOne(mappedBy = "schedule",orphanRemoval = true)
	 * 
	 * @JsonIgnore private ScheduledFlight scheduledflight;
	 */
	/**
	 * @return the ticketcost
	 */
	public Integer getTicketcost() {
		return ticketcost;
	}

	/**
	 * @param ticketcost the ticketcost to set
	 */
	public void setTicketcost(Integer ticketcost) {
		this.ticketcost = ticketcost;
	}

	/**
	 * @return the scheduleID
	 */
	public String getScheduleID() {
		return scheduleID;
	}

	/**
	 * @param string the scheduleID to set
	 */
	public void setScheduleID(String string) {
		this.scheduleID = string;
	}

	/**
	 * @return the sourceAirport
	 */
	public String getSourceAirport() {
		return sourceAirport;
	}

	/**
	 * @param source the sourceAirport to set
	 */
	public void setSourceAirport(String source) {
		this.sourceAirport = source;
	}

	/**
	 * @return the destinationAirport
	 */
	public String getDestinationAirport() {
		return destinationAirport;
	}

	/**
	 * @param destinationAirport the destinationAirport to set
	 */
	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

}
