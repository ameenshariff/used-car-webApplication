package com.as.usedcarservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.as.usedcarservice.entity.VehicleGarage;
import com.as.usedcarservice.service.CartService;

@RestController
@CrossOrigin()
public class CartController {
	@Autowired
	private CartService cartService;
	
	@GetMapping("/addToCart/{vehicleNumber}/{customerId}")
	public void addToCart(@PathVariable String vehicleNumber, @PathVariable Integer customerId) {
		cartService.addToCart(vehicleNumber,customerId);
	}
	
	@DeleteMapping("/removeFromCart/{id}")
	public void removeFromCart(@PathVariable int id) {
		System.out.println("wytwrrrrrrrrrrrrrrrrrrr   "+id);
		cartService.removeFromCart(id);
	}
	
	@GetMapping("/getCartId/{vehicleNumber}")
	public int getCartId(@PathVariable String vehicleNumber) {
		return cartService.getcartId(vehicleNumber);
	}
	
	@GetMapping("/getCart/{customerId}")
	public List<VehicleGarage> getCart(@PathVariable Integer customerId) {
		return cartService.getCart(customerId);
	}

}
