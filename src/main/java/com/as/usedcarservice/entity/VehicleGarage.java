package com.as.usedcarservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VehicleGarage {
	@Id
	private String vehicleNumber;
	private String brand;
	private String model;
	private String registrationDate;
	private double price;
	private String colour;
	private Boolean isAc;
	private Boolean isManual;
	private String city;
	private Boolean isSold;

	public VehicleGarage() {
		// TODO Auto-generated constructor stub
	}

	public VehicleGarage(String vehicleNumber, String brand, String model, String registrationDate,
			Double price, String colour, Boolean isAc, Boolean isManual, String city, Boolean isSold) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.brand = brand;
		this.model = model;
		this.registrationDate = registrationDate;
		this.price = price;
		this.colour = colour;
		this.isAc = isAc;
		this.isManual = isManual;
		this.city = city;
		this.isSold = isSold;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public Boolean getIsAc() {
		return isAc;
	}

	public void setIsAc(Boolean isAc) {
		this.isAc = isAc;
	}

	public Boolean getIsManual() {
		return isManual;
	}

	public void setIsManual(Boolean isManual) {
		this.isManual = isManual;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Boolean getIsSold() {
		return isSold;
	}

	public void setIsSold(Boolean isSold) {
		this.isSold = isSold;
	}

	@Override
	public String toString() {
		return "VehicleGarage [vehicleNumber=" + vehicleNumber + ", brand=" + brand + ", model=" + model
				+ ", registrationDate=" + registrationDate + ", price=" + price + ", colour=" + colour + ", isAc="
				+ isAc + ", isManual=" + isManual + ", city=" + city + ", isSold=" + isSold + "]";
	}
	
	
	
	

}
