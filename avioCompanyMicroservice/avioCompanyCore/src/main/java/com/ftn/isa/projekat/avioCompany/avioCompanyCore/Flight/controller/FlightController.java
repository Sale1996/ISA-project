package com.ftn.isa.projekat.avioCompany.avioCompanyCore.Flight.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.FlightDTO;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Flight.service.IFlightService;

import feign.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/aviocompany/flight")
@Api(value = "flight")
public class FlightController
{
	@Autowired
	IFlightService service;
	
	//READ ONE
	@GetMapping("/{id}")
	@ApiOperation(value = "Find single flight.", notes = "Returns single flight.", httpMethod = "GET")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
						   @ApiResponse(code = 404, message = "NOT_FOUND")
	})
	public ResponseEntity<FlightDTO> getSingleFlight(@PathVariable("id") Long id)
	{
		FlightDTO flight = service.findOneById(id);
		
		return (flight != null) ? new ResponseEntity<FlightDTO>(flight, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND); 
	}
	
	//READ ALL
	@GetMapping("/all")
	@ApiOperation(value = "Find all flights.", notes = "Returns list of flights.", httpMethod = "GET")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
						   @ApiResponse(code = 404, message = "NOT_FOUND")
	})
	public ResponseEntity<List<FlightDTO>> getAllFlights()
	{
		List<FlightDTO> flights = service.findAll();
		
		return (!flights.isEmpty()) ? new ResponseEntity<List<FlightDTO>>(flights, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	//CREATE
	@PostMapping("/")
	@ApiOperation(value = "Insert new flight.", notes = "Returns inserted flight.", httpMethod = "POST", produces = "application/json", consumes = "application/json")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
						   @ApiResponse(code = 400, message = "BAD_REQUEST")
	})
	public ResponseEntity<FlightDTO> addNewFlight(@RequestBody FlightDTO dto)
	{
		FlightDTO crFlight = service.save(dto);
		
		return (crFlight != null) ? new ResponseEntity<FlightDTO>(crFlight, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);				
	}
	
	//DELETE
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete one flight.", notes = "Returns deleted flight.", httpMethod = "DELETE")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "DELETED"),
						   @ApiResponse(code = 404, message = "NOT_FOUND")
	})
	public ResponseEntity<FlightDTO> deleteFlight(@PathVariable("id") Long id)
	{
		FlightDTO delFlight = service.deleteById(id);
		
		return (delFlight.getId() != null) ? new ResponseEntity<FlightDTO>(delFlight, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	//UPDATE
	@PutMapping("/{id}")
	@ApiOperation(value = "Update one flight.", notes = "Returns updated flight.", httpMethod = "PUT")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
						   @ApiResponse(code = 404, message = "NOT_FOUND")
	})	
	public ResponseEntity<FlightDTO> updateFlight(@PathVariable("id") Long id, @RequestBody FlightDTO dto) //ovo je ondaj prosledjeni objekat na koji se menja ovaj nas (vrv)
	{
		FlightDTO changedFlight = service.changeFlight(id, dto);
		
		return (changedFlight.getId() != null) ? new ResponseEntity<FlightDTO>(changedFlight, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	/*
	 * Search by takeoff date and landing date (doradi za vreme, ne samo za datum)
	 */
	@GetMapping("/getFlightsByDate/{takeOffTime}/{landingTime}")
	public ResponseEntity<List<FlightDTO>> getFlightsByDate(@PathVariable("takeOffTime") String takeOffTime, @PathVariable("landingTime") String landingTime)
	{
		List<FlightDTO> flights = service.getFlightsByDate(LocalDate.parse(takeOffTime), LocalDate.parse(landingTime));
	
		return (!flights.isEmpty()) ? new ResponseEntity<List<FlightDTO>>(flights, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	/*
	 * Search flights by price
	 */
	@GetMapping("/getFlightsByPrice/{bottomPrice}/{topPrice}")
	public ResponseEntity<List<FlightDTO>> getFlightsByPrice(@PathVariable("bottomPrice") float bottomPrice, @PathVariable("topPrice") float topPrice)
	{
		List<FlightDTO> flights = service.getFlightsByPrice(bottomPrice, topPrice);
		
		return (!flights.isEmpty()) ? new ResponseEntity<List<FlightDTO>>(flights, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	/*
	 * Cancel flight (returns true if cancel is allowed)
	 */
	@GetMapping("/cancelFlight/{id}")
	public ResponseEntity<Boolean> ifFlightCanceled(@PathVariable("id") Long flightId)
	{
		Boolean canceled = service.cancelFlight(flightId);
		
		return (!canceled) ? new ResponseEntity<Boolean>(canceled, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		
	}
	
	/*
	 * Average rating for one flight (cudilo bi me da radi)
	 */
	@GetMapping("/getAvgRating/{id}")
	public ResponseEntity<Float> getAverageRating(@PathVariable("id") Long id)
	{
		Float avg = service.getAvgRating(id);
		
		return(avg != null) ? new ResponseEntity<Float>(avg, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
}
