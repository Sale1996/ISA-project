package com.ftn.isa.projekat.hotel.hotelCore.HotelskaSoba.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ftn.isa.projekat.hotel.hotelApi.dto.HotelskaSobaDTO;

@Service
public interface IHotelskaSobaService {
	
	public HotelskaSobaDTO findOneById(Long id);
	public List<HotelskaSobaDTO> findAll();
	public HotelskaSobaDTO save(HotelskaSobaDTO hotelskaSobaDTO);
	public HotelskaSobaDTO deleteById(Long id);
	public HotelskaSobaDTO change(Long id, HotelskaSobaDTO hotelskaSobaDTO);

}
