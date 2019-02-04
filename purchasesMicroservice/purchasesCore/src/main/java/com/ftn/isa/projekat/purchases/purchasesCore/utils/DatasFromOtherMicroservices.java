package com.ftn.isa.projekat.purchases.purchasesCore.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.client.AvioCompanyClient;
import com.ftn.isa.projekat.avioCompany.avioCompanyApi.client.FlightClient;
import com.ftn.isa.projekat.avioCompany.avioCompanyApi.client.TicketClient;
import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.AvioCompanyDTO;
import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.FlightDTO;
import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.TicketDTO;
import com.ftn.isa.projekat.hotel.hotelApi.client.HotelClient;
import com.ftn.isa.projekat.hotel.hotelApi.client.HotelskaSobaClient;
import com.ftn.isa.projekat.hotel.hotelApi.client.RezervacijeSobeClient;
import com.ftn.isa.projekat.hotel.hotelApi.dto.HotelDTO;
import com.ftn.isa.projekat.hotel.hotelApi.dto.HotelskaSobaDTO;
import com.ftn.isa.projekat.hotel.hotelApi.dto.RezervacijeSobeDTO;
import com.ftn.isa.projekat.rentACar.rentACarApi.client.CarClient;
import com.ftn.isa.projekat.rentACar.rentACarApi.client.CarReservationClient;
import com.ftn.isa.projekat.rentACar.rentACarApi.client.RentACarServiceClient;
import com.ftn.isa.projekat.rentACar.rentACarApi.dto.CarDTO;
import com.ftn.isa.projekat.rentACar.rentACarApi.dto.CarReservationDTO;
import com.ftn.isa.projekat.rentACar.rentACarApi.dto.RentACarServiceDTO;
import com.ftn.isa.projekat.user.userApi.client.UserClient;
import com.ftn.isa.projekat.user.userApi.dto.UserDTO;

import feign.FeignException;

@Component
public class DatasFromOtherMicroservices {
	
	@Autowired
	CarReservationClient carReservationClient;
	
	@Autowired
	RezervacijeSobeClient roomReservationClient;
	
	@Autowired
	AvioCompanyClient avioClient;
	
	@Autowired
	FlightClient flightClient;
	
	@Autowired
	TicketClient ticketClient;
	
	@Autowired
	CarClient carClient;
	
	@Autowired
	RentACarServiceClient rentClient;
	
	@Autowired
	HotelClient hotelClient;
	
	@Autowired
	HotelskaSobaClient hotelskaSobaClient;
	
	@Autowired
	UserClient userClient;
	
	public TicketDTO deleteTicketReservation(Long id)
	{
		TicketDTO ticketRes = null;
		try {
			ticketRes = ticketClient.deleteTicket(id);
		}
		catch(FeignException e) {
			return new TicketDTO();
		}
		return ticketRes;
	}
	
	public CarReservationDTO deleteCarReservation(Long id) {
		CarReservationDTO carReservation = null;
		try {
			carReservation = carReservationClient.deleteReservation(id);
		}
		catch(FeignException e) {
			return new CarReservationDTO();
		}
		return carReservation;
	}
	
	public RezervacijeSobeDTO deleteRoomReservation(Long id) {
		RezervacijeSobeDTO roomReservation = null;
		try {
			roomReservation = roomReservationClient.deleteRezervaciju(id);
		}
		catch(FeignException e) {
			return new RezervacijeSobeDTO();
		}
		return roomReservation;
	}
	
	public TicketDTO addTicketReservation(TicketDTO ticket)
	{
		
		TicketDTO ticketRes = null;
		try {
			ticketRes = ticketClient.addTicket(ticket);
		}
		catch(FeignException e) {
			return new TicketDTO();
		}
		return ticketRes;
	}
	
	public CarReservationDTO addCarReservation(CarReservationDTO carResercation) {
		
		CarReservationDTO carReservation = null;
		try {
			carReservation = carReservationClient.addReservation(carResercation);
		}
		catch(FeignException e) {
			return new CarReservationDTO();
		}
		return carReservation;
	}
	
	public RezervacijeSobeDTO addRoomReservation(RezervacijeSobeDTO roomReservationParam) {
		
		RezervacijeSobeDTO roomReservation = null;
			try {
				roomReservation = roomReservationClient.addRezervaciju(roomReservationParam);
			}
			catch(FeignException e) {
				return new RezervacijeSobeDTO();
			}
			return roomReservation;
		}
	
	public TicketDTO getTicketById(Long id) 
	{
		
		TicketDTO ticketRes = null;
		try {
			ticketRes = ticketClient.getOneTicketById(id);
		}
		catch(FeignException e) {
			return new TicketDTO();
			
		}		
		return ticketRes;
	}
	
	public CarReservationDTO getCarReservationById(Long id) {
		
		CarReservationDTO carReservation = null;
		try {
			carReservation = carReservationClient.getOneReservationById(id);
		}
		catch(FeignException e) {
			return new CarReservationDTO();
			
		}		
		return carReservation;
	}
	
	public RezervacijeSobeDTO getRoomReservationById(Long id) {
		
		RezervacijeSobeDTO roomReservation = null;
		try {
			roomReservation = roomReservationClient.getRezervaciju(id);
		}
		catch(FeignException e) {
			return new RezervacijeSobeDTO();
			
		}		
		return roomReservation;
	}
	
	public FlightDTO getFlightById(Long id)
	{
		FlightDTO flight = null;
		try {
			flight = flightClient.getSingleFlight(id);
		}
		catch(FeignException e) {
			new FlightDTO();
		}
		return flight;
	}
	
	public CarDTO getCarById(Long id) {
		
		CarDTO car = null;
		try {
			car = carClient.getOneCarById(id);
		}
		catch(FeignException e) {
			new CarDTO();
		}
		return car;
	}
	
	public HotelskaSobaDTO getRoomById(Long id) {
			
		HotelskaSobaDTO room = null;
			try {
				room = hotelskaSobaClient.getHotelskaSoba(id);
			}
			catch(FeignException e) {
				new HotelskaSobaDTO();
			}
			return room;
		}
	
	public AvioCompanyDTO getAvioCompanyServiceById(Long avioCompanyId) 
	{
		AvioCompanyDTO avioService = null;
		try {
			avioService = avioClient.getOneAvioCompanyById(avioCompanyId);
		}
		catch(FeignException e) {
			new AvioCompanyDTO();
		}
		return avioService;
	}
	
	public RentACarServiceDTO getRentACarServiceById(Long id) {
		
		RentACarServiceDTO rentService = null;
		try {
			rentService = rentClient.getOneRentACarServiceById(id);
		}
		catch(FeignException e) {
			new RentACarServiceDTO();
		}
		return rentService;
	}
	
	public HotelDTO getHotelById(Long id) {
		
		HotelDTO rentHotel = null;
		try {
			rentHotel = hotelClient.getHotel(id);
		}catch(FeignException e) {
			new HotelDTO();
		}
		
		return rentHotel;
		
	}
	
	
	/*
	 * 
	 * Methods linked to user
	 * 
	 */
	
	
	public UserDTO getUserById(Long id) {
		UserDTO user= null;
		try {
		user = userClient.getOneUserById(id);
		}
		catch(FeignException e) {
			return new UserDTO();
		}
		return user;
	}

	
	
	

}
