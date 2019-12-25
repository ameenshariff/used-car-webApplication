package com.as.usedcarservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.as.usedcarservice.entity.CustomerVehicle;
import com.as.usedcarservice.entity.VehicleGarage;
import com.as.usedcarservice.model.CartModel;
import com.as.usedcarservice.service.CustomerVehicleService;
import com.as.usedcarservice.service.VehicleGarageService;

@RestController
@CrossOrigin()
public class VehicleController {
	@Autowired
	private CustomerVehicleService customerVehicleService;
	
	@Autowired
	private VehicleGarageService vehicleGarageService;
	
//	@GetMapping("/savePurchasedVehicle/{customerId}/{vehicleNumber}")
//	public void savePurchasedVehicle(@PathVariable Integer customerId, @PathVariable String vehicleNumber) {
//		customerVehicleService.saveVehiclePurchasedByCustomer(customerId, vehicleNumber);
//	}
	
	@GetMapping("/savePurchasedVehicle/{customerId}/{vehicleNumber}")
	public void savePurchasedVehicle(@PathVariable Integer customerId, @PathVariable String vehicleNumber) {
		customerVehicleService.saveVehiclePurchasedByCustomer(customerId, vehicleNumber);
	}
	
	@PostMapping("/saveAllPurchasedVehicle")
	public void savePurchasedVehicle(@RequestBody List<CartModel> cartModel) {
		customerVehicleService.saveAllPurchasedVehicles(cartModel);
	}
	
	@GetMapping("/customerOwnedVehicles/{customerId}")
	public List<VehicleGarage> getOwnedVehicles(@PathVariable Integer customerId) {
		List<CustomerVehicle> l=customerVehicleService.getOwnedVehicles(customerId);
		List<VehicleGarage> vehicle=new ArrayList<>();
		for (CustomerVehicle customerVehicle : l) {
			vehicle.add(customerVehicle.getVehicleGarage());
		}
		return vehicle;
	}

}
