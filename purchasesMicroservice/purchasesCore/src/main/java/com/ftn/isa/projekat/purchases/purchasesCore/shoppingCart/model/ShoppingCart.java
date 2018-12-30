package com.ftn.isa.projekat.purchases.purchasesCore.shoppingCart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name="id")
	private Long id;
	
	@Column (name = "user_id",nullable = false)
	private Long userId;
	
	@Column (name = "carReservation_id")
	private Long carReservationId;
	
	@Column (name = "price" , nullable = false)
	private Double price;
}