package com.example.flightmanagementsystem.entity;
import javax.persistence.*;

//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
@Entity


@Table(name="Flight_Info")
@Data
public class Flight {
 @Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", carrierName=" + carrierName + ", flightModel=" + flightModel
				+ ", seatCapacity=" + seatCapacity + "]";
	}
@Id
 //@GeneratedValue(strategy = GenerationType.IDENTITY)

 private String flightId;
 private String carrierName;
 private String flightModel;
 private int seatCapacity;
/**
 * @return the flightId
 */
public String getFlightId() {
	return flightId;
}
/**
 * @param flightId the flightId to set
 */
public void setFlightId(String flightId) {
	this.flightId = flightId;
}
/**
 * @return the carrierName
 */
public String getCarrierName() {
	return carrierName;
}
/**
 * @param carrierName the carrierName to set
 */
public void setCarrierName(String carrierName) {
	this.carrierName = carrierName;
}
/**
 * @return the flightModel
 */
public String getFlightModel() {
	return flightModel;
}
/**
 * @param flightModel the flightModel to set
 */
public void setFlightModel(String flightModel) {
	this.flightModel = flightModel;
}
/**
 * @return the seatCapacity
 */
public int getSeatCapacity() {
	return seatCapacity;
}
/**
 * @param seatCapacity the seatCapacity to set
 */
public void setSeatCapacity(int seatCapacity) {
	this.seatCapacity = seatCapacity;
}
 
 
}









