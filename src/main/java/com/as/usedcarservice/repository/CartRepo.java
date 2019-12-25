package com.as.usedcarservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.as.usedcarservice.entity.Cart;
import com.as.usedcarservice.entity.VehicleGarage;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {

	List<Cart> findByCustomerId(Integer customerId);

	Cart findByVehicleGarage(VehicleGarage vehicleGarage);

}
