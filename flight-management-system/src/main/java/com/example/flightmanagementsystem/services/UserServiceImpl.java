package com.example.flightmanagementsystem.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.flightmanagementsystem.entity.User;
import com.example.flightmanagementsystem.exceptions.InvalidCredentialsException;
import com.example.flightmanagementsystem.exceptions.RecordNotFoundException;
import com.example.flightmanagementsystem.repositories.UserRepo;

@Service

public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo usr;

	@Override
	public String addUser(User user) {
		if (user.getPassword().isEmpty() || user.getUserType().isEmpty() || user.getPhoneNo().isEmpty()
				|| user.getUserEmail().isEmpty() || user.getUserName().isEmpty()) {
			return "Please fill all fields";
		} else if (user.getPhoneNo().length() > 10 || user.getPhoneNo().length() < 10) {
			return "Invalid Phone number";
		} else if (!(user.getUserEmail().contains("@gmail.com"))) {
			return "Invalid Email Id";
		} else {
			usr.save(user);
			return "User Added Successfully!!\nYour UserId is " + user.getUserId();
		}
	}

	@Override
	public String viewUser(String userId) throws RecordNotFoundException {

		if (usr.existsById(userId)) {
			User user = usr.getReferenceById(userId);
			return "User Found\n" + user;
		} else
			return "UserID Not Found";
	}

	@Override
	public String removeUser(String userId) {
		User user = usr.getReferenceById(userId);
		if (usr.existsById(userId)) {
			usr.deleteById(userId);
			return "User " + userId + " Deleted";
		} else
			return "UserId does not exists";

	}

	public String login(String userId, String password) throws InvalidCredentialsException {
		if (usr.existsById(userId)) {
			User user = usr.getReferenceById(userId);
			if (user.getPassword().equals(password)) {
				return "Successful login";
			}
		}
		return "Please Check Credentials";
	}

	@Override
	public String updateUser(String userId, User user) {
		User user1 = usr.getReferenceById(userId);
		if (usr.existsById(userId)) {
			if (user.getPassword().isEmpty() || user.getUserType().isEmpty() || user.getPhoneNo().isEmpty()
					|| user.getUserEmail().isEmpty() || user.getUserName().isEmpty()) {
				return "Please fill all fields";
			} else if (user.getPhoneNo().length() > 10 || user.getPhoneNo().length() < 10) {
				return "Invalid Phone number";
			} else if (!(user.getUserEmail().contains("@gmail.com"))) {
				return "Invalid Email Id";
			}else {
			user1.setUserName(user.getUserName());
			user1.setUserEmail(user.getUserEmail());
			user1.setPhoneNo(user.getPhoneNo());
			usr.save(user1);
			return "Updated " + user1;
			}

		} else {
			return "UserID Not Found";
		}
	}

}
