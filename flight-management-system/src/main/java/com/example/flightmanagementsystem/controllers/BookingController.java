package com.example.flightmanagementsystem.controllers;

import java.util.ArrayList;


import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.flightmanagementsystem.entity.Airport;
import com.example.flightmanagementsystem.entity.Booking;
import com.example.flightmanagementsystem.entity.Flight;
import com.example.flightmanagementsystem.entity.Passenger;
import com.example.flightmanagementsystem.entity.User;
import com.example.flightmanagementsystem.services.BookingService;

@RestController
@RequestMapping(value="/Booking")
public class BookingController {
	@Autowired
	public BookingService bookingService;
	@PostMapping(value="/Booking/add",consumes = "application/json")
	public String addBooking(@RequestBody Booking booking) {
		Random rand = new Random();
		Integer resRandom = rand.nextInt((9999 - 100) + 1) + 10;
		booking.setBookingId(resRandom);

		Passenger p=new Passenger();
		List<Passenger> passengerList = new ArrayList<>();
		passengerList.add(p);
		
		bookingService.addBooking(booking);
		 return "Added Successfully";
	}
		/* Role r = new Role(user);
			AccountInfo ai = new AccountInfo(user);
			List<AccountInfo> accountList = new ArrayList<>();
			accountList.add(ai);
			Login l = new Login(user, ai);

			user.setRole(r);
			user.setLogin(l);
			user.setAccountList(accountList);

			return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);	
	}*/
	
	@RequestMapping(value = "/Booking/modify", method = RequestMethod.POST)
	 public ResponseEntity<Booking> modifyBooking(@RequestBody Booking booking) {
		 return new ResponseEntity<>(bookingService.modifyBooking(booking), HttpStatus.OK);
	 }
	@GetMapping(value="/Booking/viewall")
	public ResponseEntity<List<Booking>> viewBooking(){
		if(bookingService.viewBooking().isEmpty()) {
			System.out.println("No Bookings done");
			//throw new FlightNotFoundException();
		}
		return new ResponseEntity<>(bookingService.viewBooking(), HttpStatus.OK);
	}

	@GetMapping(value="/Booking/viewById/{bid}")
	public ResponseEntity<List<Booking>> viewBooking(@PathVariable Integer bid ) {
		if(bookingService.viewBooking(bid)==null) {
			System.out.println("No Booking with this Id");
			//throw new FlightNotFoundException();
		}

		return new ResponseEntity<>(bookingService.viewBooking(bid), HttpStatus.FOUND);
	}
	

	@RequestMapping(value = "/Booking/delete/{bid}", method = RequestMethod.DELETE)
	 public ResponseEntity<String> deleteBooking(@PathVariable Integer bid) {
		 return new ResponseEntity<>(bookingService.deleteBooking(bid), HttpStatus.ACCEPTED);
		 	 
	 }

	



}
