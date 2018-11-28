package com.ftn.isa.projekat.rentACar.rentACarCore.car.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.projekat.rentACar.rentACarApi.dto.CarDTO;
import com.ftn.isa.projekat.rentACar.rentACarCore.car.model.Car;
import com.ftn.isa.projekat.rentACar.rentACarCore.car.repository.CarRepository;
import com.ftn.isa.projekat.rentACar.rentACarCore.carType.model.CarType;
import com.ftn.isa.projekat.rentACar.rentACarCore.carType.repository.CarTypeRepository;
import com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter.DTOCarConverter;
import com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter.DTOCarTypeConverter;
import com.ftn.isa.projekat.rentACar.rentACarCore.dtoConverter.DTORentACarServiceConverter;
import com.ftn.isa.projekat.rentACar.rentACarCore.rentACarService.model.RentACarService;
import com.ftn.isa.projekat.rentACar.rentACarCore.rentACarService.repository.RentACarServiceRepository;

@Service
public class CarServiceImpl  implements ICarService{

	@Autowired
	CarRepository carRepository;
	@Autowired
	RentACarServiceRepository rentACarServiceRepository;
	@Autowired
	CarTypeRepository carTypeRepository;
	
	
	@Autowired
	DTOCarConverter carConverter;
	@Autowired
	DTORentACarServiceConverter rentACarServiceConverter;
	@Autowired
	DTOCarTypeConverter carTypeConverter;

	@Override
	public CarDTO findOneById(Long id) {
		
		Optional <Car> car = carRepository.findById(id);
		
		
		if (car.isPresent()) {
			
			return carConverter.convertToDTO(car.get());
		
		}
		else {
			
			return new CarDTO();
			
		}
		
	}

	@Override
	public List<CarDTO> findAll() {

		Optional< List<Car> > list = Optional.of(carRepository.findAll());
		ArrayList< CarDTO > CarsDTO = new ArrayList< CarDTO >();
		
		if ( list.isPresent() ) {
			
			for ( Car car : list.get()) {
				
				CarsDTO.add(carConverter.convertToDTO(car));
				
			}
			
			return CarsDTO;
			
		}
		
		return Collections.emptyList();
		
	}

	@Override
	public CarDTO save(CarDTO carToSave) {
		
		carRepository.save(carConverter.convertFromDTO(carToSave));
		
		return carToSave;
	}

	@Override
	public CarDTO deleteById(Long id) {

		Optional<Car> carToDelete = carRepository.findById(id);
		
		if( carToDelete.isPresent() ) {
		
			carRepository.deleteById(id);
			return carConverter.convertToDTO(carToDelete.get());
		
		}
		
		return null;
		
	}

	@Override
	public CarDTO changeCar(Long id, CarDTO car) {

		Optional<Car> carForChange = carRepository.findById(id);
		
		if( carForChange.isPresent() && car!=null ) {
			
			//setting rentACarService and carType for car
			Optional<RentACarService> rentService = rentACarServiceRepository.findById(car.getService().getId());
			Optional<CarType> carType = carTypeRepository.findById(car.getCarType().getId());
			
			if( rentService.isPresent() && carType.isPresent() ) {
				
				carForChange.get().setCarRentService(rentService.get());
				carForChange.get().setCarType(carType.get());
				carForChange.get().setRegistrationLicence(car.getRegistrationLicence());
				carForChange.get().setRentPrice(car.getRentPrice());
				
				carRepository.save(carForChange.get());
				
				car.setId(carForChange.get().getId());
				
				return car;
				
			}
		}
		
		return null;
		
	}
}