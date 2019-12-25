package com.as.usedcarservice.service;

import java.util.List;

import com.as.usedcarservice.entity.VehicleGarage;

public interface VehicleGarageService {
	void addNewVehicleToGarage(VehicleGarage vehicleGarage);
	List<VehicleGarage> vehicles();
	List<VehicleGarage> vehiclesByFilter(String city, String brand);
	List<VehicleGarage> findByCity(String city);
	List<VehicleGarage> vehiclesByFilter(String brand);
}
