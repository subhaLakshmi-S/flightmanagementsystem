package com.example.flightmanagementsystem.entity;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Airports")
@Data
public class Airport {
	@Id
	private String airportId;

	/**
	 * @return the airportId
	 */
	public String getAirportId() {
		return airportId;
	}

	/**
	 * @param airportId the airportId to set
	 */
	public void setAirportId(String airportId) {
		this.airportId = airportId;
	}

	/**
	 * @return the airportName
	 */
	public String getAirportName() {
		return airportName;
	}

	/**
	 * @param airportName the airportName to set
	 */
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	/**
	 * @return the airportLocation
	 */
	public String getAirportLocation() {
		return airportLocation;
	}

	/**
	 * @param airportLocation the airportLocation to set
	 */
	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}

	private String airportName;
	private String airportLocation;

	@Override
	public String toString() {
		return "Airport [airportId=" + airportId + ", airportName=" + airportName + ", airportLocation="
				+ airportLocation + "]";
	}

}