package com.example.flightmanagementsystem.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.flightmanagementsystem.entity.Airport;
import com.example.flightmanagementsystem.entity.Schedule;
import com.example.flightmanagementsystem.repositories.ScheduleRepo;
import com.example.flightmanagementsystem.entity.Schedule;

@Service
public class ScheduleService {
ScheduleRepo schedulerepo;
Schedule schedule ;

public List<Schedule> viewAllSchedule() {
	return (List<Schedule>) schedulerepo.findAll();
}

public String viewscheduleById(String scheduleId) {
	if (schedulerepo.existsById(scheduleId)) {
		Schedule schedule = schedulerepo.getReferenceById(scheduleId);
		return "Schedule Found\n" + schedule;
	} else
		return "Schedule Not Found";
}

public String removescheduleId(String scheduleId) {
	if (schedulerepo.existsById(scheduleId)) {
		Schedule schedule = schedulerepo.getReferenceById(scheduleId);
		schedulerepo.deleteById(scheduleId);
		return "Schedule " + scheduleId + " Deleted";

	} else {
		return "Schedule Id not Found";

	}
}

public String addSchedule(Schedule schedule) {
	if (schedule.getSourceAirport().isEmpty() || schedule.getDestinationAirport().isEmpty()) {
		return "Please fill all fields";
	} else {
		schedulerepo.save(schedule);
		return "Schedule Added Successfully " + schedule.getScheduleID();
	}
}

public String modifySchedule(String scheduleid, Schedule schedule) {
	if (schedulerepo.existsById(scheduleid)) {
	    if (schedule.getSourceAirport().isEmpty() || schedule.getDestinationAirport().isEmpty()) 
	    {
		return "Please fill all fields";
	    }
        else  {
        Schedule schedule1 = schedulerepo.getReferenceById(scheduleid);
        schedule1.setSourceAirport(schedule.getSourceAirport());
        schedule1.setDestinationAirport(schedule.getDestinationAirport());
        schedulerepo.save(schedule1);
		return "Schedule Updated Successfully";
	    }
	}
	else return "Schedule Id not Found";
}
}
