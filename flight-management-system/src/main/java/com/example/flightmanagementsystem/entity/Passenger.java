package com.example.flightmanagementsystem.entity;

import javax.persistence.*;

@Entity
@Table(name="passenger")
public class Passenger {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer passengerUIN;
	private Integer passengerAge;
	private Integer pnrNumber;
	private String passengerName;
	private Double luggage;
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Passenger(Integer passengerUIN, Integer passengerAge, Integer pnrNumber, String passengerName,
			Double luggage) {
		super();
		this.passengerUIN = passengerUIN;
		this.passengerAge = passengerAge;
		this.pnrNumber = pnrNumber;
		this.passengerName = passengerName;
		this.luggage = luggage;
	}
	/**
	 * @return the passengerUIN
	 */
	public Integer getPassengerUIN() {
		return passengerUIN;
	}
	/**
	 * @param passengerUIN the passengerUIN to set
	 */
	public void setPassengerUIN(Integer passengerUIN) {
		this.passengerUIN = passengerUIN;
	}
	/**
	 * @return the passengerAge
	 */
	public Integer getPassengerAge() {
		return passengerAge;
	}
	/**
	 * @param passengerAge the passengerAge to set
	 */
	public void setPassengerAge(Integer passengerAge) {
		this.passengerAge = passengerAge;
	}
	/**
	 * @return the pnrNumber
	 */
	public Integer getPnrNumber() {
		return pnrNumber;
	}
	/**
	 * @param pnrNumber the pnrNumber to set
	 */
	public void setPnrNumber(Integer pnrNumber) {
		this.pnrNumber = pnrNumber;
	}
	/**
	 * @return the passengerName
	 */
	public String getPassengerName() {
		return passengerName;
	}
	/**
	 * @param passengerName the passengerName to set
	 */
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	/**
	 * @return the luggage
	 */
	public Double getLuggage() {
		return luggage;
	}
	/**
	 * @param luggage the luggage to set
	 */
	public void setLuggage(Double luggage) {
		this.luggage = luggage;
	}
	
	
}
