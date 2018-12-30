package com.ftn.isa.projekat.hotel.hotelCore.HotelskaSoba.model;

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
import com.ftn.isa.projekat.hotel.hotelCore.Hotel.model.Hotel;
import com.ftn.isa.projekat.hotel.hotelCore.RezervacijeSobe.model.RezervacijeSobe;
import com.ftn.isa.projekat.hotel.hotelCore.TipSobe.model.TipSobe;

import lombok.Data;

@Entity
@Table (name="hotelska_soba")
@Data 

public class HotelskaSoba {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name="id")
	private Long id;
	
	@Column (name="floor", nullable=false)
	private int floor;
	
	@Column (name="reserved", nullable=false)
	private Boolean reserved;
	
	@JsonIgnore
	@OneToMany (mappedBy="hotelskaSoba_rezervacijeSobe")
	private List<RezervacijeSobe> rezervisaneSobeList;
	
	@JsonIgnore
	@ManyToOne (cascade=CascadeType.ALL)
	@JoinColumn (name="hotel_id",nullable = false)
	private Hotel hotel_hotelskeSobe;
	
	@JsonIgnore
	@ManyToOne (cascade=CascadeType.ALL)
	@JoinColumn (name="tipSobe_id",nullable = false)
	private TipSobe tipSobe_hotelskeSobe;

}