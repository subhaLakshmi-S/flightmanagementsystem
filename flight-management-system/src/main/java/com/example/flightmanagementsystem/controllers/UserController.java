package com.example.flightmanagementsystem.controllers;

import java.util.List;
import java.math.BigInteger;

import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.example.flightmanagementsystem.entity.User;
import com.example.flightmanagementsystem.exceptions.AirportNotFoundException;
import com.example.flightmanagementsystem.exceptions.InvalidCredentialsException;
import com.example.flightmanagementsystem.exceptions.RecordNotFoundException;
import com.example.flightmanagementsystem.repositories.UserRepo;
import com.example.flightmanagementsystem.services.UserService;
import com.example.flightmanagementsystem.services.UserServiceImpl;

@RestController
@RequestMapping("/users")

public class UserController {
	@Autowired
	public UserService userService;

	@PostMapping(value = "/createUser", consumes = "application/json")
	public String addUser(@RequestBody User newUser)
			 {
		Random rand = new Random();
		Integer resRandom = rand.nextInt((9999 - 100) + 1) + 10;
		String userid =Integer.toString(resRandom);
		newUser.setUserId(userid);
		return  userService.addUser(newUser);
	}

	@PutMapping("/update/{id}")
	public String updateUser(@PathVariable(value = "id") String userId, @Valid @RequestBody User user)
			{
		return userService.updateUser(userId,user);
	}

	@PostMapping(value = "/users/login")
	public ResponseEntity<String> loginUser(@RequestParam String userId, @RequestParam String password)
			throws InvalidCredentialsException {
		return new ResponseEntity<>(userService.login(userId, password), HttpStatus.FOUND);
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/searchUser/{id}")
	// @ExceptionHandler(RecordNotFoundException.class)
	public String searchUserByID(@PathVariable("id") String userId){
		//userService.viewUser(userId);
		// throw new RecordNotFoundException();
		return  userService.viewUser(userId);

	}

	@DeleteMapping("/deleteUser/{id}")
	// @ExceptionHandler(RecordNotFoundException.class)
	public String deleteBookingByID(@PathVariable("id") String userId) {
		return userService.removeUser(userId);
	}
}
