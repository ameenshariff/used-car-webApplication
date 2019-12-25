package com.as.usedcarservice.service;

import com.as.usedcarservice.entity.Address;
import com.as.usedcarservice.entity.Cart;
import com.as.usedcarservice.entity.Customer;

public interface CustomerService {
	void addCustomer(Customer customer);

	Customer getCustomer(String email);
	
	
//	----------------address manipulation---------------
	void addNewAddress(Address address,Integer customerId);
	void editAddress(Address address,Integer customerId);
	void deleteAddress(Integer id);

}
