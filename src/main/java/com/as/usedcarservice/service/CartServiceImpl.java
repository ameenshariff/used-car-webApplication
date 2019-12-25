package com.as.usedcarservice.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.usedcarservice.entity.Cart;
import com.as.usedcarservice.entity.Customer;
import com.as.usedcarservice.entity.VehicleGarage;
import com.as.usedcarservice.model.CartModel;
import com.as.usedcarservice.repository.CartRepo;
import com.as.usedcarservice.repository.CustomerRepo;
import com.as.usedcarservice.repository.VehicleGarageRepo;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartRepo cartRepo;

	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private VehicleGarageRepo vehicleGarageRepo;

	@Override
	public void addToCart(String vehicleNumber, Integer customerId) {
//		Customer customer = customerRepo.findById(customerId).get();
		VehicleGarage vg=vehicleGarageRepo.findById(vehicleNumber).get();
		if(vg!=null) {
			String pattern = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String date = simpleDateFormat.format(new Date());
			
			Cart cart=new Cart(customerId, vg, date);
			cartRepo.save(cart);
		}
	}

	@Override
	public void removeFromCart(int id) {
		cartRepo.deleteById(id);
	}
	
	public List<VehicleGarage> getCart(Integer customerId) {
		List<Cart> cartFromDb=cartRepo.findByCustomerId(customerId);
		
		cartFromDb.forEach(x->System.out.println(x));
		
		List<VehicleGarage> vehicles=new ArrayList<>();
		for (Cart cart : cartFromDb) {
			vehicles.add(cart.getVehicleGarage());
		}
		System.out.println("vehicles.......");
		vehicles.forEach(x->System.out.println(x));
		return vehicles;
	}

	@Override
	public int getcartId(String vehicleNumber) {
		// TODO Auto-generated method stub
		VehicleGarage vg=vehicleGarageRepo.findById(vehicleNumber).get();
		Cart cartFromDb=cartRepo.findByVehicleGarage(vg);
		return cartFromDb.getCartId();
		
	}

	

}
