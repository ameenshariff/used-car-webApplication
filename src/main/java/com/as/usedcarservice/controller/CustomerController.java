package com.as.usedcarservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.as.usedcarservice.entity.Address;
import com.as.usedcarservice.entity.Customer;
import com.as.usedcarservice.entity.Login;
import com.as.usedcarservice.service.CustomerService;
import com.as.usedcarservice.service.LoginService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/addCustomer")
	public void addCustomer(@RequestBody Customer customer){
		customerService.addCustomer(customer);
	}
	
	@PostMapping("/addLoginForCustomer")
	public void addLoginForCustomer(@RequestBody Login login){
		loginService.addLogin(login);
	}
	
	@GetMapping("/checkIfEmailExist/{email}")
	public boolean checkIfEmailExist(@PathVariable String email) {
		return loginService.checkIfEmailExist(email);
	}
	
	@PostMapping("/validateLogin")
	public boolean validateLogin(@RequestBody Login login) {
		return loginService.validateLogin(login);
	}
	
	@GetMapping("/customer/{email}")
	public Customer getCustomer(@PathVariable String email) {
		return customerService.getCustomer(email);
	}
	
//	----------------address manipulation---------------
	
	@PostMapping("/addNewAddress/{customerId}")
	public void addNewAddress(@RequestBody Address address, @PathVariable Integer customerId) {
		customerService.addNewAddress(address,customerId);
	}
	
	@PutMapping("/editAddress/{customerId}")
	public void editAddress(@RequestBody Address address, @PathVariable Integer customerId) {
		customerService.editAddress(address,customerId);
	}
	
	@DeleteMapping("/deleteAddress/{id}")
	public void deleteAddress(@PathVariable Integer id) {
		customerService.deleteAddress(id);
	}
}
