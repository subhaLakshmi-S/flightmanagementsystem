package com.example.flightmanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.flightmanagementsystem.entity.Schedule;


@Repository
public interface ScheduleRepo extends JpaRepository<Schedule,String> {


	
}

