package com.ftn.isa.projekat.purchases.purchasesCore.rentACarRating.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ftn.isa.projekat.purchases.purchasesApi.dto.RentACarRatingDTO;

@Service
public interface IRentACarRatingService {

	public RentACarRatingDTO findOneById ( Long id );
	
	public List<RentACarRatingDTO> findAll();
	
	public RentACarRatingDTO save (RentACarRatingDTO rentCarRatingToSave);
	
	public RentACarRatingDTO deleteById ( Long id );
	
	public RentACarRatingDTO changeRentACarRating ( Long id, RentACarRatingDTO rentCarRating );
	
	public RentACarRatingDTO rateRentACarService(Long userId, Long carId, int rating);

	public Double getAverageRating(Long rentServiceId, LocalDate dateFrom, LocalDate dateTo);

}