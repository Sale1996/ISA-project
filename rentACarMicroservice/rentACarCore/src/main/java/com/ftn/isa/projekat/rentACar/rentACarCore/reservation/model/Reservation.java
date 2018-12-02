package com.ftn.isa.projekat.rentACar.rentACarCore.reservation.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ftn.isa.projekat.rentACar.rentACarCore.branchOffice.model.BranchOffice;
import com.ftn.isa.projekat.rentACar.rentACarCore.car.model.Car;

import lombok.Data;

@Entity
@Table (name="reservation")
@Data
public class Reservation {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name="id")
	private Long id;
	
	@Column (name = "date_from",nullable = false)
	private Date dateFrom;
	
	@Column (name = "date_to",nullable = false)
	private Date dateTo;
	
	@Column (name="rating")
	private int rating;
	

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY,
				cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name="reserved_cars", joinColumns = { @JoinColumn(name="car_id") }, inverseJoinColumns = { @JoinColumn(name = "reservation_id")})
	private List<Car> reservedCars;
	
	/*
	 * Location where user will pick a car.
	 * */
	@JsonIgnore
	@ManyToOne (cascade=CascadeType.ALL)
	@JoinColumn (name="branch_office_from")
	private BranchOffice branchOfficeFrom;
	
	/*
	 * Location where user will return a car.
	 * */
	@JsonIgnore
	@ManyToOne (cascade=CascadeType.ALL)
	@JoinColumn (name="branch_office_to")
	private BranchOffice branchOfficeTo;
}
