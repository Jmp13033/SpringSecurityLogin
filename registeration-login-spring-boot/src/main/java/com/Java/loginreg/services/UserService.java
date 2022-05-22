package com.Java.loginreg.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.Java.loginreg.models.User;
import com.Java.loginreg.web.dto.UserRegisterationDTO;

public interface UserService extends UserDetailsService {
	
	// passes the object DTO to save to DB 
	User save(UserRegisterationDTO registerationDTO);
	
	
}
