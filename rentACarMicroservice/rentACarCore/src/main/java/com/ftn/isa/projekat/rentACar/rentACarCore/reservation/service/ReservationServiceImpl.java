package com.ftn.isa.projekat.rentACar.rentACarCore.reservation.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.ReservationDTO;
import com.ftn.isa.projekat.rentACar.rentACarCore.branchOffice.model.BranchOffice;
import com.ftn.isa.projekat.rentACar.rentACarCore.branchOffice.repository.BranchOfficeRepository;
import com.ftn.isa.projekat.rentACar.rentACarCore.car.repository.CarRepository;
import com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter.DTOBranchOfficeConverter;
import com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter.DTOCarConverter;
import com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter.DTOReservationConverter;
import com.ftn.isa.projekat.rentACar.rentACarCore.reservation.model.Reservation;
import com.ftn.isa.projekat.rentACar.rentACarCore.reservation.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements IReservationService {

	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	CarRepository carRepository;
	@Autowired
	BranchOfficeRepository branchOfficeRepository;
	
	@Autowired
	DTOReservationConverter reservationConverter;
	@Autowired
	DTOCarConverter carConverter;
	@Autowired
	DTOBranchOfficeConverter branchOfficeConverter;
	

	@Override
	public ReservationDTO findOneById(Long id) {
		
		Optional <Reservation> reservation = reservationRepository.findById(id);
		
		
		if (reservation.isPresent()) {
			
			return reservationConverter.convertToDTO(reservation.get());
		
		}
		else {
			
			return new ReservationDTO();
			
		}	
	}

	@Override
	public List<ReservationDTO> findAll() {
		
		Optional< List<Reservation> > list = Optional.of(reservationRepository.findAll());
		ArrayList< ReservationDTO > reservationsDTO = new ArrayList< ReservationDTO >();
		
		if ( list.isPresent() ) {
			
			for ( Reservation reservation : list.get()) {
				
				reservationsDTO.add(reservationConverter.convertToDTO(reservation));
				
			}
			
			return reservationsDTO;
			
		}
		
		return Collections.emptyList();

	}

	@Override
	public ReservationDTO save(ReservationDTO reservationToSave) {
		
		reservationRepository.save(reservationConverter.convertFromDTO(reservationToSave));
		
		return reservationToSave;

	}

	@Override
	public ReservationDTO deleteById(Long id) {
		
		Optional<Reservation> reservationToDelete = reservationRepository.findById(id);
		
		if( reservationToDelete.isPresent() ) {
		
			reservationRepository.deleteById(id);
			return reservationConverter.convertToDTO(reservationToDelete.get());
		
		}
		
		return null;
	}

	@Override
	public ReservationDTO changeReservation(Long id, ReservationDTO reservation) {
		
		Optional<Reservation> reservationForChange = reservationRepository.findById(id);
		
		if(reservationForChange.isPresent() && reservation != null) {
			
			//Optional<Car> reservedCar = carRepository.findById(reservation.getCar());
			Optional<BranchOffice> branchFrom = branchOfficeRepository.findById(reservation.getBranchOfficeFrom().getId());
			Optional<BranchOffice> branchTo = branchOfficeRepository.findById(reservation.getBranchOfficeTo().getId());
			
			//OVDE JOS LISTA AUTOMOBILA TREBA DA SE SREDI!
			
			if(branchFrom.isPresent() && branchTo.isPresent()) {
				
				reservationForChange.get().setBranchOfficeFrom(branchFrom.get());
				reservationForChange.get().setBranchOfficeTo(branchTo.get());
				//reservationForChange.get().setDateFrom(reservation.getDateFrom());
				//reservationForChange.get().setDateTo(reservation.getDateTo());
				reservationForChange.get().setRating(reservation.getRating());
				
				reservationRepository.save(reservationForChange.get());
				
				reservation.setId(reservationForChange.get().getId());
				
				return reservation;
				
			}
		}
		
		return null;
	}
	
}
