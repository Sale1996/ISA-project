package com.ftn.isa.projekat.rentACar.rentACarCore.car.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ftn.isa.projekat.rentACar.rentACarCore.carType.model.CarType;
import com.ftn.isa.projekat.rentACar.rentACarCore.rentACarService.model.RentACarService;
import com.ftn.isa.projekat.rentACar.rentACarCore.reservation.model.Reservation;

import lombok.Data;

@Entity
@Table (name="car")
@Data
public class Car {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name="id")
	private Long id;
	
	@Column (name="registration_licence")
	private String registrationLicence;
	
	@Column (name="rent_price")
	private int rentPrice;
	
	
	@JsonIgnore
	@ManyToOne ( cascade=CascadeType.ALL )
	@JoinColumn ( name = "rent_a_car_service_id")
	private RentACarService carRentService;
	
	@JsonIgnore
	@ManyToOne ( cascade=CascadeType.ALL )
	@JoinColumn (name="car_type_id")
	private CarType carType;
	
	@JsonIgnore
	@OneToMany(mappedBy="reservedCars")
	private List<Reservation> carReservations;
	
	
	
}
