package com.as.usedcarservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.as.usedcarservice.entity.VehicleGarage;
import com.as.usedcarservice.service.CustomerVehicleService;
import com.as.usedcarservice.service.VehicleGarageService;

@RestController
@CrossOrigin()
public class VehicleGarageController {
	
	@Autowired
	private CustomerVehicleService customerVehicleService;
	
	@Autowired
	private VehicleGarageService vehicleGarageService;
	
	@PostMapping("/addVehiclesToGarage")
	public void addVehiclesToGarage(@RequestBody VehicleGarage vehicleGarage) {
		vehicleGarageService.addNewVehicleToGarage(vehicleGarage);
	}
	
	@GetMapping("/vehicles")
	public List<VehicleGarage> vehicles() {
		return vehicleGarageService.vehicles();
	}
	
	@GetMapping("/filteredVehicles/{city}/{brand}")
	public List<VehicleGarage> filteredVehicles(@PathVariable String city, @PathVariable String brand) {
		return vehicleGarageService.vehiclesByFilter(city, brand);
	}
	
	@GetMapping("/findByCity/{city}")
	public List<VehicleGarage> findByCity(@PathVariable String city) {
		System.out.println(city);
		System.out.println(vehicleGarageService.findByCity(city));
		return vehicleGarageService.findByCity(city);
	}
	
	@GetMapping("/findByBrand/{brand}")
	public List<VehicleGarage> findByBrand(@PathVariable String brand) {
		System.out.println(brand);
		return vehicleGarageService.vehiclesByFilter(brand);
	}
	
	

}