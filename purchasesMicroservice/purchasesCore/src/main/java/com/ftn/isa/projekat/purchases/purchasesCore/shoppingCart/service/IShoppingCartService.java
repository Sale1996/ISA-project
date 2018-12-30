package com.ftn.isa.projekat.purchases.purchasesCore.shoppingCart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ftn.isa.projekat.purchases.purchasesApi.dto.ShoppingCartDTO;
import com.ftn.isa.projekat.rentACar.rentACarApi.dto.CarReservationDTO;

@Service
public interface IShoppingCartService {
	
	public ShoppingCartDTO findOneById ( Long id );
	
	public List<ShoppingCartDTO> findAll();
	
	public ShoppingCartDTO save (ShoppingCartDTO reservationToSave);
	
	public ShoppingCartDTO deleteById ( Long id );
	
	public ShoppingCartDTO changeReservation ( Long id, ShoppingCartDTO reservation );

	public ShoppingCartDTO addCarReservation(Long id, CarReservationDTO carReservation);

	public ShoppingCartDTO deleteCarReservation(Long id);

	public ShoppingCartDTO confirmReservation(Long id);

}