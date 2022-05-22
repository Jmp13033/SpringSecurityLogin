package com.Java.loginreg.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Java.loginreg.services.UserService;
import com.Java.loginreg.web.dto.UserRegisterationDTO;

@Controller
@RequestMapping("/registeration")
public class UserRegisterationController {

	
	@Autowired
	UserService userServ;
	
	
	
	
	
	@ModelAttribute("user")
	public UserRegisterationDTO userRegisterationDTO() {
		return new UserRegisterationDTO();
	}
	
	
	

	@GetMapping
	public String userFormReg() {
		
		return "registeration";
	}
	
	
	
	
	
	
	@PostMapping
	public String RegUserAccount(@ModelAttribute("user") UserRegisterationDTO registerationDTO) {
		
		userServ.save(registerationDTO);	
	
		return "redirect:/registeration?success";
	}








}
