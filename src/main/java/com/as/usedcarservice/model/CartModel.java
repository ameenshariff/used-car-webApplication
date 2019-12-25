package com.as.usedcarservice.model;

public class CartModel {
	private int customerId;
	private String vehicleNumber;

	public CartModel() {
		// TODO Auto-generated constructor stub
	}

	public CartModel(int customerId, String vehicleNumber) {
		super();
		this.customerId = customerId;
		this.vehicleNumber = vehicleNumber;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

}
