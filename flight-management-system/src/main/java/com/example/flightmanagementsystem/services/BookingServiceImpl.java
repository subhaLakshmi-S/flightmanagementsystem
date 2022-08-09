package com.example.flightmanagementsystem.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flightmanagementsystem.entity.Booking;
import com.example.flightmanagementsystem.repositories.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	private BookingRepository bookingRepository;
	public Booking addBooking(Booking booking)
	{
		return bookingRepository.save(booking);
	}
	public Booking modifyBooking(Booking booking)
	{
		return bookingRepository.save(booking);
	}
	
	public List<Booking> viewBooking(Integer bid )
	{
		return bookingRepository.findByBookingId(bid);
	}

	public List<Booking> viewBooking()
	{
		return (List<Booking>) bookingRepository.findAll();
	}
	public String deleteBooking(Integer bid)
	{
		if(bookingRepository.existsById(bid)) {
			bookingRepository.deleteById(bid);
			}
			else {
				//throw new FlightNotFoundException();
				
			}
		return null;
	}
	//public void validateBooking(Booking booking); 
	//public void validatePassenger(Passenger passenger);

}
