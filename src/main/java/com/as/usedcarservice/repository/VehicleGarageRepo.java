package com.as.usedcarservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.as.usedcarservice.entity.VehicleGarage;

@Repository
@Transactional
public interface VehicleGarageRepo extends JpaRepository<VehicleGarage, String> {

	@Modifying
	@Query("select vehicle from VehicleGarage vehicle where vehicle.city = :city and vehicle.brand = :brand")
	List<VehicleGarage> findByFilter(@Param("city") String city,@Param("brand") String brand);

	
	@Modifying
	@Query("update VehicleGarage vehicle set vehicle.isSold = :status where vehicle.vehicleNumber = :vehicleNumber")
	void changeStatus(@Param("status") boolean status,@Param("vehicleNumber") String vehicleNumber);


	List<VehicleGarage> findByCity(String city);


	List<VehicleGarage> findByBrand(String brand);

}
