package com.example.flightmanagementsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.flightmanagementsystem.entity.Booking;


public interface BookingService {
	@Autowired
	public Booking addBooking(Booking booking);//Creates a new booking.
	public Booking modifyBooking(Booking booking);
	/*Modifies a previous booking. All
	information related to the booking except the booking id can be
	modified.*/
	public List<Booking> viewBooking(Integer bid );
	//Retrieves a booking made by the user based on the booking id.
	public List<Booking> viewBooking();  //Retrieves a list of all the bookings
	public String deleteBooking(Integer bid);//Deletes a previous booking identifiable by the ‘bookingId’.
	//public void validateBooking(Booking booking); //Validates the attributes of a booking.
	//public void validatePassenger(Passenger passenger);//Validates the attributes of a passenger

}
