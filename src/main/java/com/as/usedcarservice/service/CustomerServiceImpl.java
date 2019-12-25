package com.as.usedcarservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.usedcarservice.entity.Address;
import com.as.usedcarservice.entity.Customer;
import com.as.usedcarservice.repository.AddressRepo;
import com.as.usedcarservice.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private AddressRepo addressRepo;

	@Override
	public void addCustomer(Customer customer) {
		customerRepo.save(customer);
	}

	@Override
	public Customer getCustomer(String email) {
		return customerRepo.findByEmail(email);
	}
	
//	----------------address manipulation---------------

	@Override
	public void addNewAddress(Address address, Integer customerId) {
		Customer customer=customerRepo.findById(customerId).get();
		address.setCustomer(customer);
		addressRepo.save(address);
		
	}

	@Override
	public void editAddress(Address address, Integer customerId) {
		Customer customer=customerRepo.findById(customerId).get();
		address.setCustomer(customer);
		address.setId(address.getId());
		addressRepo.save(address);
	}

	@Override
	public void deleteAddress(Integer id) {
		addressRepo.deleteById(id);
	}
	
	
	

}
