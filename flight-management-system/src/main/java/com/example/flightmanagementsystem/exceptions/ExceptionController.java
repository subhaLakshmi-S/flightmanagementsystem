package com.example.flightmanagementsystem.exceptions;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.flightmanagementsystem.exceptions.NoFlightOrRouteFoundException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = FlightNotFoundException.class)
	public ResponseEntity<Object> exception(FlightNotFoundException exception) {

		return new ResponseEntity<Object>("Flight not found", HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = RecordNotFoundException.class)
	public ResponseEntity<Object> RecordNotFoundException(RecordNotFoundException exception) {
		return new ResponseEntity<Object>("Record not found", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = ListEmptyException.class)
	public ResponseEntity<Object> ListEmptyException(ListEmptyException exception) {
		return new ResponseEntity<Object>("List not found", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = NoFlightOrRouteFoundException.class)
	public ResponseEntity<Object> exeception2(NoFlightOrRouteFoundException exception) {
		return new ResponseEntity<Object>("No Route Or Flight Found", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = NoScheduleFoundException.class)
	public ResponseEntity<Object> exeception3(NoScheduleFoundException exception) {
		return new ResponseEntity<Object>("No Schedule Found", HttpStatus.NOT_FOUND);
	}

}
