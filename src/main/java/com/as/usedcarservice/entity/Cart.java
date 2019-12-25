package com.as.usedcarservice.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
	private Integer customerId;
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "vehicle_id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private VehicleGarage vehicleGarage;
	private String cartAddDate;
	
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}


	public Cart(Integer customerId, VehicleGarage vehicleGarage, String cartAddDate) {
		super();
		this.customerId = customerId;
		this.vehicleGarage = vehicleGarage;
		this.cartAddDate = cartAddDate;
	}
	
	
	public Cart(int cartId, Integer customerId, VehicleGarage vehicleGarage, String cartAddDate) {
		this(customerId,vehicleGarage,cartAddDate);
		this.cartId=cartId;
	}

	public int getCartId() {
		return cartId;
	}


	public void setCartId(int cartId) {
		this.cartId = cartId;
	}


	public Integer getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}


	public VehicleGarage getVehicleGarage() {
		return vehicleGarage;
	}


	public void setVehicleGarage(VehicleGarage vehicleGarage) {
		this.vehicleGarage = vehicleGarage;
	}


	public String getCartAddDate() {
		return cartAddDate;
	}


	public void setCartAddDate(String cartAddDate) {
		this.cartAddDate = cartAddDate;
	}


	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", customerId=" + customerId + ", vehicleGarage=" + vehicleGarage
				+ ", cartAddDate=" + cartAddDate + "]";
	}
	
	
}
