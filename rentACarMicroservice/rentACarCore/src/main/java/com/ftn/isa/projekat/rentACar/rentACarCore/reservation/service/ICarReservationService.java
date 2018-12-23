package com.ftn.isa.projekat.rentACar.rentACarCore.reservation.service;

import java.time.LocalDate;
import java.util.List;

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.CarReservationDTO;

public interface ICarReservationService {
	
	

	public CarReservationDTO findOneById ( Long id );
	
	public List<CarReservationDTO> findAll();
	
	public CarReservationDTO save (CarReservationDTO reservationToSave);
	
	public CarReservationDTO deleteById ( Long id );
	
	public CarReservationDTO changeReservation ( Long id, CarReservationDTO reservation );

	public CarReservationDTO rateReservation(Long id, int rating);

	public CarReservationDTO rateCarReservation(Long id, int rating);

	

	
}
