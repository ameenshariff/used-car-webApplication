package com.as.usedcarservice.service;

import com.as.usedcarservice.entity.Login;

public interface LoginService {
	void addLogin(Login login);

	boolean checkIfEmailExist(String email);

	boolean validateLogin(Login login);

}
