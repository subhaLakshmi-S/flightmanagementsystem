package com.example.flightmanagementsystem.services;



import org.springframework.http.ResponseEntity;

import com.example.flightmanagementsystem.entity.User;
import com.example.flightmanagementsystem.exceptions.InvalidCredentialsException;
import com.example.flightmanagementsystem.exceptions.RecordNotFoundException;

public interface UserService {
	public String login(String userId,String password) throws InvalidCredentialsException;
	public  String addUser(User user); 
	public String viewUser(String userId)throws RecordNotFoundException;
	public String removeUser(String UserId) ;//throws UserNotFoundException;
	public String updateUser(String userId,User user);
}
