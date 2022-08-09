package com.example.flightmanagementsystem.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import com.example.flightmanagementsystem.entity.User;

public interface UserRepo extends JpaRepository<User, String>{

	User findByUserId(String userId);
	
}
