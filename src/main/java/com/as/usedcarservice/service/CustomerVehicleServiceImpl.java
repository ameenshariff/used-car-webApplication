package com.as.usedcarservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.usedcarservice.entity.CustomerVehicle;
import com.as.usedcarservice.entity.VehicleGarage;
import com.as.usedcarservice.model.CartModel;
import com.as.usedcarservice.repository.CartRepo;
import com.as.usedcarservice.repository.CustomerVehicleRepo;
import com.as.usedcarservice.repository.VehicleGarageRepo;

@Service
public class CustomerVehicleServiceImpl implements CustomerVehicleService {

	@Autowired
	private CustomerVehicleRepo vehicleRepo;

	@Autowired
	private VehicleGarageRepo garageRepo;

	@Autowired
	private CartRepo cartRepo;

	@Override
	public void saveVehiclePurchasedByCustomer(Integer customerId, String vehicleNumber) {

		VehicleGarage garage = garageRepo.findById(vehicleNumber).get();
		if (garage != null) {
			garageRepo.changeStatus(true, vehicleNumber);
			CustomerVehicle customerVehicle = new CustomerVehicle(customerId, garage);

			vehicleRepo.save(customerVehicle);
		}

	}

	@Override
	public void saveAllPurchasedVehicles(List<CartModel> cartModel) {
		// TODO Auto-generated method stub
		if (!cartModel.isEmpty()) {
			for (CartModel cart : cartModel) {
				VehicleGarage garage = garageRepo.findById(cart.getVehicleNumber()).get();
				if (garage != null) {
					garageRepo.changeStatus(true, cart.getVehicleNumber());
					CustomerVehicle customerVehicle = new CustomerVehicle(cart.getCustomerId(), garage);

					vehicleRepo.save(customerVehicle);
				}
			}
			if (cartModel.size() > 1)
				cartRepo.deleteAll();

		}

	}

	@Override
	public List<CustomerVehicle> getOwnedVehicles(Integer customerId) {
		// TODO Auto-generated method stub
		vehicleRepo.getOwnedVehicles(customerId);

		return vehicleRepo.getOwnedVehicles(customerId);

	}

}
