package com.as.usedcarservice.service;

import java.util.List;

import com.as.usedcarservice.entity.CustomerVehicle;
import com.as.usedcarservice.model.CartModel;

public interface CustomerVehicleService {
	void saveVehiclePurchasedByCustomer(Integer customerId,String vehicleNumber);
	
	void saveAllPurchasedVehicles(List<CartModel> cartModel);

	List<CustomerVehicle> getOwnedVehicles(Integer customerId);

}
