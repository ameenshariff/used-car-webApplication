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
public class CustomerVehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer customerId;
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "vehicle_number", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private VehicleGarage vehicleGarage;
	
	public CustomerVehicle() {
		
	}

	public CustomerVehicle(Integer customerId, VehicleGarage vehicleGarage) {
		super();
		this.customerId = customerId;
		this.vehicleGarage = vehicleGarage;
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "CustomerVehicle [customerId=" + customerId + ", vehicleGarage=" + vehicleGarage + "]";
	}
	
	

	
	
}
