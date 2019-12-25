package com.as.usedcarservice.service;

import java.util.List;

import com.as.usedcarservice.entity.Cart;
import com.as.usedcarservice.entity.VehicleGarage;

public interface CartService {
	void addToCart(String vehicleNumber, Integer customerId);
	void removeFromCart(int id);
	public List<VehicleGarage> getCart(Integer customerId);
	int getcartId(String vehicleNumber);

}
