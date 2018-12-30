package com.ftn.isa.projekat.hotel.hotelCore.dtoConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.hotel.hotelApi.dto.HotelDTO;
import com.ftn.isa.projekat.hotel.hotelApi.dto.HotelskaSobaDTO;
import com.ftn.isa.projekat.hotel.hotelCore.Hotel.model.Hotel;
import com.ftn.isa.projekat.hotel.hotelCore.HotelskaSoba.model.HotelskaSoba;

@Component
public class DTOHotelskaSobaConverter {
	
	@Autowired
	DTOHotelConverter hotelConverter;
	
	@Autowired
	DTOTipSobeConverter tipSobeConverter;

	public HotelskaSobaDTO convertToDTO(HotelskaSoba soba) {	
		HotelskaSobaDTO dto=new HotelskaSobaDTO();	
		dto.setId(soba.getId());
		dto.setFloor(soba.getFloor());
		dto.setReserved(soba.getReserved());
		dto.setHotel(hotelConverter.convertToDTO(soba.getHotel_hotelskeSobe()));
		dto.setTipSobe(tipSobeConverter.convertToDTO(soba.getTipSobe_hotelskeSobe()));
		return dto;
		
	}
	
	public HotelskaSoba convertFromDTO(HotelskaSobaDTO sobaDTO) {
		HotelskaSoba bean=new HotelskaSoba();
		bean.setFloor(sobaDTO.getFloor());
		bean.setReserved(sobaDTO.getReserved());
		bean.setHotel_hotelskeSobe(hotelConverter.convertFromDTO(sobaDTO.getHotel()));
		bean.setTipSobe_hotelskeSobe(tipSobeConverter.convertFromDTO(sobaDTO.getTipSobe()));
		return bean;
		
	}
	
}