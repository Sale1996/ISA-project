package com.ftn.isa.projekat.rentACar.rentACarCore.reservation.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ftn.isa.projekat.rentACar.rentACarCore.reservation.model.CarReservation;


public interface CarReservationRepository extends JpaRepository< CarReservation, Long>{

	

}