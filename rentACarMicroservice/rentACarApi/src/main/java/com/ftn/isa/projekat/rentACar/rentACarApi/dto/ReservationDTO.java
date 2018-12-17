package com.ftn.isa.projekat.rentACar.rentACarApi.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class ReservationDTO {

	private Long id;
	private LocalDate dateFrom;
	private LocalDate dateTo;
	private int rating;
	
	private BranchOfficeDTO branchOfficeFrom;
	private BranchOfficeDTO branchOfficeTo;
	private List<CarDTO> reservedCars;
	private RentACarServiceDTO service;
	
}
