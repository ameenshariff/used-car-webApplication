package com.as.usedcarservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.as.usedcarservice.entity.CustomerVehicle;
import com.as.usedcarservice.entity.VehicleGarage;

@Repository
public interface CustomerVehicleRepo extends JpaRepository<CustomerVehicle, String> {

	@Modifying
	@Query("select vehicle from CustomerVehicle vehicle where vehicle.customerId = :custId")
	List<CustomerVehicle> getOwnedVehicles(@Param("custId") Integer customerId);

}
