package com.example.flightmanagementsystem.entity;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "booking")
@Data
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingId;
	private Integer noOfPassengers;
	
	private Date bookingdate;
	private String sourceAirport;
	private String destinationAirport;
	@OneToMany(cascade = CascadeType.MERGE)
	private List<Passenger> passengerList;

	/*
	 * @OneToMany(cascade = CascadeType.MERGE) private Passenger passenger;
	 */
	/*
	 * @OneToOne(cascade = CascadeType.ALL) private ScheduledFlight scheduledFlight;
	 */
	/**
	 * @return the bookingId
	 */
	public Integer getBookingId() {
		return bookingId;
	}
	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	/**
	 * @return the noOfPassengers
	 */
	public Integer getNoOfPassengers() {
		return noOfPassengers;
	}
	/**
	 * @param noOfPassengers the noOfPassengers to set
	 */
	public void setNoOfPassengers(Integer noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
	/**
	 * @return the bookingdate
	 */
	public Date getBookingdate() {
		return bookingdate;
	}
	/**
	 * @param bookingdate the bookingdate to set
	 */
	public void setBookingdate(Date bookingdate) {
		this.bookingdate = bookingdate;
	}
	/**
	 * @return the sourceAirport
	 */
	public String getSourceAirport() {
		return sourceAirport;
	}
	/**
	 * @param sourceAirport the sourceAirport to set
	 */
	public void setSourceAirport(String sourceAirport) {
		this.sourceAirport = sourceAirport;
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
	/**
	 * @return the passengerList
	 */
	public List<Passenger> getPassengerList() {
		return passengerList;
	}
	/**
	 * @param passengerList the passengerList to set
	 */
	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}
	/**
	 * @return the passenger
	 */
	
	

}
