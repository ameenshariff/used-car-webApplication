package com.as.usedcarservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.usedcarservice.entity.VehicleGarage;
import com.as.usedcarservice.repository.VehicleGarageRepo;
@Service
public class VehicleGarageServiceImpl implements VehicleGarageService {
	@Autowired
	private VehicleGarageRepo vehicleGarageRepo;

	@Override
	public void addNewVehicleToGarage(VehicleGarage vehicleGarage) {
		vehicleGarageRepo.save(vehicleGarage);
	}

	@Override
	public List<VehicleGarage> vehicles() {
		return vehicleGarageRepo.findAll();
	}

	@Override
	public List<VehicleGarage> vehiclesByFilter(String city, String brand) {
		return vehicleGarageRepo.findByFilter(city, brand);
	}

	@Override
	public List<VehicleGarage> findByCity(String city) {
		// TODO Auto-generated method stub
		return vehicleGarageRepo.findByCity(city);
	}

	@Override
	public List<VehicleGarage> vehiclesByFilter(String brand) {
		// TODO Auto-generated method stub
		return vehicleGarageRepo.findByBrand(brand);
	}

}
