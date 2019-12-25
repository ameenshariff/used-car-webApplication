package com.as.usedcarservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.as.usedcarservice.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}
