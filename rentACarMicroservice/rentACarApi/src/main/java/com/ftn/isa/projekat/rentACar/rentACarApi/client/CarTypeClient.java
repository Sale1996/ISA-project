package com.ftn.isa.projekat.rentACar.rentACarApi.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.CarTypeDTO;


@FeignClient(name="carTypeClient", url = "http://localhost:8090/api/rentacar/carType")
public interface CarTypeClient {
	
	@GetMapping("/{id}")
	public CarTypeDTO getOneCarTypeById (@PathVariable("id") Long id);
	
	@GetMapping("/all")
	public List<CarTypeDTO> getAllCarTypes();
	
	@PostMapping("/")
	public CarTypeDTO addCarType(@RequestHeader("Role") String role,@RequestBody CarTypeDTO dto);
	
	@DeleteMapping("/{id}")
	public CarTypeDTO deleteCarType(@RequestHeader("Role") String role,@PathVariable("id") Long id);
	
	@PutMapping("/{id}")
	public CarTypeDTO changeCarType (@RequestHeader("Role") String role,@PathVariable("id") Long id, @RequestBody CarTypeDTO carTypeDto );

}
