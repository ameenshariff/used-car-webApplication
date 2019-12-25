package com.as.usedcarservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.as.usedcarservice.entity.Login;
import com.as.usedcarservice.repository.LoginRepo;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepo loginRepo;

	@Override
	public void addLogin(Login login) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
		String encodedPassword = encoder.encode(login.getPassword());
		login.setPassword(encodedPassword);
		loginRepo.save(login);
	}

	@Override
	public boolean checkIfEmailExist(String email) {
		return loginRepo.existsById(email);
	}

	@Override
	public boolean validateLogin(Login login) {
		if (loginRepo.existsById(login.getEmail())) {
			Login loginDb = loginRepo.findById(login.getEmail()).get();
			System.out.println(loginDb);
			if (new BCryptPasswordEncoder().matches(login.getPassword(), loginDb.getPassword()))
				return true;
			else
				return false;
		} else
			return false;
	}

}
